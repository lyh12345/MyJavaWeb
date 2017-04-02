package servlet;

import database.DatabaseCon;
import model.Term;
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
 * on 2017/3/29.
 */
public class LoginServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        request.setCharacterEncoding("UTF-8");
        //获取提交的数据
        String usr = request.getParameter("userId");
        String pwd = request.getParameter("password");
        boolean validated = false;
        DatabaseCon sqlserverDB = new DatabaseCon();
        HttpSession session = request.getSession();
        UserTable userTable = null;
        userTable = (UserTable) session.getAttribute("user");//获取用户信息
        String sql = null;
        ResultSet rs= null;
        if(userTable == null){
            sql = "select * from S";
            rs= sqlserverDB.executeQuery(sql);
            try {
                while(rs.next()){//信息的比对
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
       }
        else{
            validated = true;
        }
        sql = "select distinct xq from O";
        rs = sqlserverDB.executeQuery(sql);
        List<Term> terms = new ArrayList<>();
        try {
            while(rs.next()){
                Term term = new Term();
                term.setTerm(rs.getString(1));
                terms.add(term);
            }
            rs.close();
            sqlserverDB.closeStatement();
            sqlserverDB.closeConnection();
            session.setAttribute("terms", terms);
            session.setAttribute("currentTerm",terms.get(0).getTerm());
        } catch (SQLException e) {
            e.printStackTrace();
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
