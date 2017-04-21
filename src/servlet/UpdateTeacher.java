package servlet;

import database.DatabaseCon;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Created by wjk1996 on 2017/4/16.
 */
public class UpdateTeacher extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.setCharacterEncoding("UTF-8");
        String gh =request.getParameter("gh");
        String xm = request.getParameter("xm");
        String xb = request.getParameter("xb");
        String csrq = request.getParameter("csrq");
        String xl = request.getParameter("xl");
        String jbgz = request.getParameter("jbgz");
        String yxh = request.getParameter("yxh");
        PreparedStatement statement;
        try{
            DatabaseCon databaseCon = new DatabaseCon();
            Connection connection = databaseCon.getConnection();
            statement = connection.prepareStatement("update T set xm=?,xb=?,csrq=?,xl=?,jbgz=?,yxh=? where gh=?");
            statement.setString(1, xm);
            statement.setString(2, xb);
            statement.setString(3, csrq);
            statement.setString(4, xl);
            statement.setString(5, jbgz);
            statement.setString(6, yxh);
            statement.setString(7, gh);
            statement.executeUpdate();

            databaseCon.closeConnection();
    }catch(Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("FindTeacher");
    }
}