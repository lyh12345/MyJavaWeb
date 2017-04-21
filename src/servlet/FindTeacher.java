package servlet;

import database.DatabaseCon;
import model.TeacherTable;

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
 * Created by wjk1996 on 2017/4/14.
 */
public class FindTeacher extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        DatabaseCon databaseCon = new DatabaseCon();
        String sql = "select * from T";//添加sql语言
        ResultSet rs = databaseCon.executeQuery(sql);
        HttpSession session = request.getSession(false);
        List<TeacherTable> list = new ArrayList<TeacherTable>();
        try{
            while(rs.next()){
                TeacherTable teacherTable = new TeacherTable();//实例化TeacherTable对象
                teacherTable.setGh(rs.getString("gh"));
                teacherTable.setXm(rs.getString("xm"));
                teacherTable.setXb(rs.getString("xb"));
                teacherTable.setCsrq(rs.getDate("csrq"));
                teacherTable.setXl(rs.getString("xl"));
                teacherTable.setJbgz(rs.getString("jbgz"));
                teacherTable.setYxh(rs.getString("xyh"));
                list.add(teacherTable);//将老师对象添加到集合当中
            }
            rs.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
        session.setAttribute("list",list);//将老师集合放置到request中
        response.sendRedirect("teacher_list.jsp");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
