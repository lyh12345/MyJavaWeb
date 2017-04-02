package servlet;

import database.DatabaseCon;
import model.CourseTable;
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
 * on 2017/4/2.
 */
public class StudentScheduleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserTable userTable = (UserTable) session.getAttribute("user");
        String currentTerm = (String) session.getAttribute("currentTerm");
        String userId = userTable.getId();
        DatabaseCon databaseCon = new DatabaseCon();
        List<CourseTable> courseTables = new ArrayList<>();
        String sql;
        sql = "select * from E,T,C,O where E.gh = T.gh and E.kh = C.kh and E.xq = O.xq and E.kh = O.kh and E.gh = O.gh and E.xh = "+"'"+userId+"'"+" and E.xq = "+"'"+currentTerm+"'";
        ResultSet rs = databaseCon.executeQuery(sql);
        try {
            while(rs.next()){
                CourseTable courseTable = new CourseTable();
                courseTable.setCourseName(rs.getString("km"));
                courseTable.setCourseId(rs.getString("kh"));
                courseTable.setTime(rs.getString("sksj"));
                courseTable.setTeacherName(rs.getString("xm"));
                courseTable.setTeacherId(rs.getString("gh"));
                courseTable.setCourseCredit(rs.getInt("xf"));
                courseTables.add(courseTable);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        databaseCon.closeStatement();
        databaseCon.closeConnection();
        session.setAttribute("courseTables",courseTables);
        resp.sendRedirect("StudentSchedule.jsp");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
