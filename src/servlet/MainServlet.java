package servlet;

import database.DatabaseCon;
import model.UserTable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by lh
 * on 2017/3/29.
 */
public class MainServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        request.setCharacterEncoding("UTF-8");
        String usr = request.getParameter("userId");
        String pwd = request.getParameter("password");
        boolean validated = false;
        DatabaseCon sqlserverDB = new DatabaseCon();
        HttpSession session = request.getSession();
        UserTable userTable = null;
        userTable = (UserTable) session.getAttribute("user");
        if(userTable == null){
            String sql = "select * from S";
            ResultSet rs= sqlserverDB.executeQuery(sql);
            try {
                while(rs.next()){
                    if(rs.getString(1).trim().compareTo(usr)==0&&rs.getString(8).trim().compareTo(pwd)==0){
                        userTable = new UserTable();
                        userTable.setId(rs.getString(1));
                        userTable.setName(rs.getString(2));
                        userTable.setPassword(rs.getString(8));
                        session.setAttribute("user", userTable);
                        validated = true;
                    }
                }
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            sqlserverDB.closeStatement();
            sqlserverDB.closeConnection();
        }
        else{
            validated = true;
        }
        if(validated){
            response.sendRedirect("Main.jsp");
        }
        else{
            response.sendRedirect("Error.jsp");
        }
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        doGet(request, response);
    }
}
