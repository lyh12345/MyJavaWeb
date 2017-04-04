package servlet;

import database.DatabaseCon;
import model.AvgGPAofTerm;
import model.ScoreTable;
import model.Term;
import model.UserTable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by lh
 * on 2017/3/31.
 */
public class ScoreQueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        UserTable userTable = null;
        userTable = (UserTable) session.getAttribute("user");
        if(userTable==null){//如果用户注销了，跳转到出错界面
            resp.sendRedirect("Error.jsp");
            return;
        }
        String studentId = userTable.getId();
        String currentTerm = null;
        currentTerm = (String) session.getAttribute("currentTerm");
        DatabaseCon databaseCon = new DatabaseCon();
        List<ScoreTable> scoreTables = null;
        scoreTables = new ArrayList<>();
        String sql = "select * from E,C where E.kh = C.kh and xh = " + "'" + userTable.getId() + "' and xq = "+"'"+currentTerm+"'";
        ResultSet rs = databaseCon.executeQuery(sql);
        try {
            while (rs.next()) {//查询并保存成绩信息
                ScoreTable scoreTable = new ScoreTable();
                scoreTable.setCourseId(rs.getString(rs.findColumn("kh")));
                scoreTable.setCourseName(rs.getString(rs.findColumn("km")));
                scoreTable.setCourseCredit(rs.getInt(rs.findColumn("xf")));
                scoreTable.setCourseGrade(rs.getDouble(rs.findColumn("zpcj")));
                scoreTables.add(scoreTable);
            }
        } catch (SQLException e) {
            //e.printStackTrace();
            resp.sendRedirect("ScoreQuery.jsp");
        }
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        session.setAttribute("score", scoreTables);
        List<Term> terms = (ArrayList) session.getAttribute("terms");
        List<AvgGPAofTerm> avgGPAofTerms = new ArrayList<>();
        Term term = null;
        Iterator<Term> iterator = terms.iterator();
        ScoreTable scoreTable = new ScoreTable();
        while(iterator.hasNext()){
            term = iterator.next();
            sql = "select * from score where xq = "+"'"+term.getTerm()+"'"+" and xh = "+"'"+studentId+"'";
            rs = databaseCon.executeQuery(sql);
            double totalXF = 0;
            double totalGPA = 0;
            AvgGPAofTerm avgGPAofTerm = new AvgGPAofTerm();
            try {
                while(rs.next()){
                    totalXF+=rs.getInt(5);
                    scoreTable.setCourseGrade(rs.getDouble(6));
                    totalGPA += (scoreTable.getCourseGPA()*rs.getInt(5));
                }
                avgGPAofTerm.setTerm(term.getTerm());
                avgGPAofTerm.setAvgGPA(totalGPA/totalXF);
                avgGPAofTerms.add(avgGPAofTerm);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        databaseCon.closeStatement();
        databaseCon.closeConnection();
        session.setAttribute("avgGPAofTerms", avgGPAofTerms);
        resp.sendRedirect("ScoreQuery.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
