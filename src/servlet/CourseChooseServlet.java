package servlet;

import database.DatabaseCon;
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

/**
 * Created by lh
 * on 2017/4/2.
 */
public class CourseChooseServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();
        UserTable userTable = (UserTable) session.getAttribute("user");
        if(userTable==null){//如果用户注销了，跳转到出错界面
            resp.sendRedirect("Error.jsp");
            return;
        }

        String userId = userTable.getId();
        String userName = userTable.getName();
        String currentTerm = (String) session.getAttribute("currentTerm");
        String teacherId = req.getParameter("teacherId");
        String courseId = req.getParameter("courseId");
        DatabaseCon databaseCon = new DatabaseCon();
        Connection connection = databaseCon.getConnection();
        PreparedStatement statement;
        String sql = "select sksj from O where xq = "+"'"+currentTerm+"'"+" and kh = "+"'"+courseId+"'"+" and gh = "+
                "'"+teacherId+"'";
        ResultSet rs;
        rs = databaseCon.executeQuery(sql);
        String sksj = null;
        try {
            while (rs.next()){
                sksj = rs.getString(1);
            }
            rs.close();
            sql = "select sksj from O,E where O.xq = E.xh and O.kh = E.kh and O.gh = E.gh and E.xq = "+"'"+currentTerm+"'"+" and E.xh = "+"'"+userId+"'"+" and O.sksj = "+"'"+sksj+"'";
            rs = databaseCon.executeQuery(sql);
            while (rs.next()){
                out.println("<html><body>");
                out.println("<font size = 10px color = #888>选课失败，请检查相关信息，并查看课表是否冲突</font>");
                out.println("</body></html>");
                return;
            }
        } catch (SQLException e) {
            //e.printStackTrace();
        }
        try {
            statement = connection.prepareStatement("insert into E(xh,xq,kh,gh) values(?,?,?,?)");
            statement.setString(1, userId);
            statement.setString(2, currentTerm);
            statement.setString(3, courseId);
            statement.setString(4, teacherId);
            statement.executeUpdate();
            out.println("<html><body>");
            out.println("<font size = 10px color = #888>选课成功，请到课表中查看</font>");
            out.println("</body></html>");
            databaseCon.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("<html><body>");
            out.println("<font size = 10px color = #888>选课失败，请检查相关信息，并查看课表是否冲突</font>");
            out.println("</body></html>");
        }


    }
}
