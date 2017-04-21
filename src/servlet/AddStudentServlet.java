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
 * Created by lh
 * on 2017/4/21.
 */
public class AddStudentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String xh = request.getParameter("xh");
        String xm = request.getParameter("xm");
        String xb = request.getParameter("xb");
        String csrq = request.getParameter("csrq");
        String jg = request.getParameter("jg");
        String sjhm = request.getParameter("sjhm");
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
            statement = connection.prepareStatement("insert into S(xh, xm, xb, csrq, jg, sjhm, yxh, password) VALUES(?,?,?,?,?,?,?,?)");
            statement.setString(1, xh);
            statement.setString(2, xm);
            statement.setString(3, xb);
            statement.setDate(4, sqlDate);
            statement.setString(5, jg);
            statement.setString(6, sjhm);
            statement.setString(7, yxh);
            statement.setString(8, xh);
            statement.executeUpdate();
            databaseCon.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("FindStudent");


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
