package servlet;

import database.DatabaseCon;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by wjk1996 on 2017/4/17.
 */
public class AddTeacherServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String gh = request.getParameter("gh");
        String xm = request.getParameter("xm");
        String xb = request.getParameter("xb");
        String csrq = request.getParameter("csrq");
        String xl = request.getParameter("xl");
        String jbgz = request.getParameter("jbgz");
        String yxh = request.getParameter("yxh");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟
        java.util.Date date = null;
        try {
            date = sdf.parse(csrq);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        PreparedStatement statement;
        try {
            DatabaseCon databaseCon = new DatabaseCon();
            Connection connection = databaseCon.getConnection();
            statement = connection.prepareStatement("insert into T(gh,xm,xb,csrq,xl,jbgz,xyh,password) VALUES(?,?,?,?,?,?,?,?)");
            statement.setString(1, gh);
            statement.setString(2, xm);
            statement.setString(3, xb);
            statement.setDate(4, sqlDate);
            statement.setString(5, xl);
            statement.setString(6, jbgz);
            statement.setString(7, yxh);
            statement.setString(8, gh);
            statement.executeUpdate();
            databaseCon.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("teacher_list.jsp");


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
