package servlet;

import database.DatabaseCon;
import model.ScoreTable;
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
import java.util.List;

/**
 * Created by lh
 * on 2017/3/31.
 */
public class ScoreQueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserTable userTable =null;
        userTable = (UserTable) session.getAttribute("user");
        String studentId = userTable.getId();
        DatabaseCon databaseCon = new DatabaseCon();
        List<ScoreTable> scoreTables = null;
        scoreTables = (List<ScoreTable>) session.getAttribute("score");
        if(scoreTables==null){
            scoreTables = new ArrayList<>();
            String sql = "select * from E,C where E.kh = C.kh and xh = "+"'"+userTable.getId()+"'";
            ResultSet rs = databaseCon.executeQuery(sql);
            try {
                while(rs.next()){
                    ScoreTable scoreTable = new ScoreTable();
                    scoreTable.setCourseId(rs.getString(rs.findColumn("kh")));
                    scoreTable.setCourseName(rs.getString(rs.findColumn("km")));
                    scoreTable.setCourseCredit(rs.getInt(rs.findColumn("xf")));
                    scoreTable.setCourseGrade(rs.getDouble(rs.findColumn("zpcj")));
                    scoreTables.add(scoreTable);
                }
                rs.close();
                databaseCon.closeStatement();
                databaseCon.closeConnection();
                session.setAttribute("score",scoreTables);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        resp.sendRedirect("ScoreQuery.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
