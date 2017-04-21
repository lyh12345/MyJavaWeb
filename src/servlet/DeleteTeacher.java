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
public class DeleteTeacher extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String gh =request.getParameter("gh");
        DatabaseCon databaseCon = new DatabaseCon();

        PreparedStatement statement;

        try{
            Connection connection = databaseCon.getConnection();
            statement = connection.prepareStatement("delete from T where gh= ?");
            statement.setString(1, gh);
            statement.executeUpdate();

           // System.out.print("成功");

            statement.close();
            databaseCon.closeConnection();

        }catch(Exception e){
            e.printStackTrace();

        }

        response.sendRedirect("FindTeacher");
    }
}
