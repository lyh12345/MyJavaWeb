package servlet;

import database.DatabaseCon;
import model.CourseTable;

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
 * on 2017/4/2.
 */
public class CourseSearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String courseId = req.getParameter("courseId");
        String courseName = req.getParameter("courseName");
        HttpSession session = req.getSession();
        String currentTerm = (String) session.getAttribute("currentTerm");
        DatabaseCon databaseCon = new DatabaseCon();
        String sql = null;
        if(!courseId.equalsIgnoreCase("")){
            sql = "select * from O,T,C where O.gh = T.gh and O.kh = C.kh and C.kh = "+"'"+courseId+"'"+" and xq = "+"'"+currentTerm+"'";
        }
        else if(!courseName.equalsIgnoreCase("")){
            sql = "select * from O,T,C where O.gh = T.gh and O.kh = C.kh and C.km = "+"'"+courseName+"'"+" and xq = "+"'"+currentTerm+"'";
        }
        else{
            return;
        }
        ResultSet rs = databaseCon.executeQuery(sql);
        List<CourseTable> courseTables = new ArrayList<>();
        try {
            while(rs.next()){
                CourseTable courseTable = new CourseTable();
                courseTable.setCourseId(rs.getString("kh"));
                courseTable.setCourseName(rs.getString("km"));
                courseTable.setTime(rs.getString("sksj"));
                courseTable.setTeacherName(rs.getString("xm"));
                courseTable.setTeacherId(rs.getString("gh"));
                courseTable.setCourseCredit(rs.getInt("xf"));
                courseTables.add(courseTable);
            }
            rs.close();
        } catch (SQLException e) {
            //e.printStackTrace();
        }
        databaseCon.closeStatement();
        databaseCon.closeConnection();
        session.setAttribute("courseTables",courseTables);
        resp.sendRedirect("CourseSearch.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
