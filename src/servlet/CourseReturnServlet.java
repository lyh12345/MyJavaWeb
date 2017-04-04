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
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lh
 * on 2017/4/3.
 */
public class CourseReturnServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserTable userTable = (UserTable) session.getAttribute("user");
        if(userTable==null){//如果用户注销了，跳转到出错界面
            resp.sendRedirect("Error.jsp");
            return;
        }
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
                courseTable.setTeacherName(rs.getString("xm"));
                courseTable.setTeacherId(rs.getString("gh"));
                courseTable.setTime(rs.getString("sksj"));
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
        resp.sendRedirect("CourseReturn.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String lo =req.getParameter("location");
        int location = Integer.parseInt(lo);
        if(location==-1){
            resp.sendRedirect("CourseReturn.jsp");
            return;
        }
        HttpSession session = req.getSession();
        UserTable userTable = (UserTable) session.getAttribute("user");
        if(userTable==null){//如果用户注销了，跳转到出错界面
            resp.sendRedirect("Error.jsp");
            return;
        }
        String currentTerm = (String) session.getAttribute("currentTerm");
        String userId = userTable.getId();
        DatabaseCon databaseCon = new DatabaseCon();
        List<CourseTable> courseTables = new ArrayList<>();
        courseTables = (ArrayList)session.getAttribute("courseTables");
        PrintWriter out = resp.getWriter();
        CourseTable courseTable = courseTables.get(location);
        String courseId = courseTable.getCourseId();
        String teacherId = courseTable.getTeacherId();
        Connection connection = databaseCon.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("delete from E where xh = ? and xq = ? and kh =? and gh = ?");
            preparedStatement.setString(1,userId);
            preparedStatement.setString(2,currentTerm);
            preparedStatement.setString(3,courseId);
            preparedStatement.setString(4,teacherId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            assert preparedStatement != null;
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        courseTables.remove(location);
        session.setAttribute("courseTables",courseTables);
        resp.sendRedirect("CourseReturn.jsp");
    }
}
