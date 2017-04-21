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
 * Created by wjk1996 on 2017/4/17.
 */
public class DeleteStudent extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String xh =req.getParameter("xh");
        DatabaseCon databaseCon = new DatabaseCon();
        PreparedStatement statement;
        try{
            Connection connection = databaseCon.getConnection();
            statement = connection.prepareStatement("delete from S where xh= ?");
            statement.setString(1, xh);
            statement.executeUpdate();
            statement.close();
            databaseCon.closeConnection();

        }catch(Exception e){
            e.printStackTrace();

        }
        resp.sendRedirect("FindStudent");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
