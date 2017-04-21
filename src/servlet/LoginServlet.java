package servlet;

import base.mTeacher;
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
        String roles = request.getParameter("roles");
        boolean validated = false;
        DatabaseCon sqlserverDB = new DatabaseCon();
        HttpSession session = request.getSession();
        UserTable userTable = null;
        userTable = (UserTable) session.getAttribute("user");//获取用户信息
        String sql = null;
        ResultSet rs= null;
        String loginConfirm = "successful";
        session.setAttribute("loginConfirm",loginConfirm);
        //根据用户角色选择要查询的表
        switch (roles) {
            case "student":
                sql = "select * from S";
                if (userTable == null) {
                    rs = sqlserverDB.executeQuery(sql);
                    try {
                        while (rs.next()) {//信息的比对
                            if (rs.getString(1).trim().compareTo(usr) == 0 && rs.getString(8).trim().compareTo(pwd) == 0) {
                                userTable = new UserTable();
                                userTable.setId(rs.getString(1));
                                userTable.setName(rs.getString(2));
                                userTable.setPassword(rs.getString(8));
                                userTable.setRoles(roles);
                                session.setAttribute("user", userTable);
                                validated = true;
                            }
                        }
                        rs.close();
                    } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                } else {
                    validated = true;
                }
                break;
            case "teacher":
                sql = "select * from T";
                String tt = "true";
                session.setAttribute("tt", tt);
                mTeacher teacher = null;
                teacher = (mTeacher) session.getAttribute("teacher");
                if (teacher == null) {
                    rs = sqlserverDB.executeQuery(sql);
                    try {
                        while (rs.next()) {
                            if ((rs.getString("gh").trim().equals(usr)) && (rs.getString("pwd").trim().equals(pwd))) {
                                teacher = new mTeacher();
                                teacher.setGh(rs.getString(1));
                                teacher.setXm(rs.getString(2));
                                teacher.setXb(rs.getString(3));
                                teacher.setCsrq(rs.getDate(4));
                                teacher.setXl(rs.getString(5));
                                teacher.setJbgz(rs.getDouble(6));
                                teacher.setYxh(rs.getString(7));
                                teacher.setPwd(rs.getString(8));
                                session.setAttribute("teacher", teacher);
                                validated = true;
                            }
                        }
                        rs.close();

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                } else {
                    validated = true;
                }
                break;
            case "manager":
                if(usr.equals("root")&&pwd.equals("123456")){
                    validated = true;
                }
                break;
            default:
                return;
        }

        //选择所有出现的学期信息并保存
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
            session.setAttribute("terms", terms);//把学期信息放入session
            session.setAttribute("currentTerm",terms.get(0).getTerm());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(validated){
            if(roles.equals("student")){
                response.sendRedirect("Main.jsp");
            }
            else if(roles.equals("teacher")){
                response.sendRedirect("MainOfTeacher.jsp");
            }
            else if(roles.equals("manager")){
                response.sendRedirect("MainOfManager.jsp");
            }

        }
        else{
            loginConfirm = "failed";
            session.setAttribute("loginConfirm",loginConfirm);
            response.sendRedirect("Index.jsp");

        }

    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        doGet(request, response);
    }
}
