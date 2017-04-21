package servlet;

import database.DatabaseCon;
import model.StudentTable;

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
 * Created by wjk1996 on 2017/4/15.
 */
public class FindStudent extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession(false);
        DatabaseCon databaseCon = new DatabaseCon();
        String sql = "select * from S";

        ResultSet rs = databaseCon.executeQuery(sql);
        List<StudentTable> studentTables = new ArrayList<>();
        try {
            while (rs.next()) {
                StudentTable studentTable = new StudentTable();
                studentTable.setXh(rs.getString("xh"));
                studentTable.setXm(rs.getString("xm"));
                studentTable.setXb(rs.getString("xb"));
                studentTable.setCsrq(rs.getString("csrq"));
                studentTable.setJg(rs.getString("jg"));
                studentTable.setSjhm(rs.getString("sjhm"));
                studentTable.setYxh(rs.getString("yxh"));
                studentTables.add(studentTable);
            }
            rs.close();
        } catch (SQLException e) {
            //e.printStackTrace();
        }
        databaseCon.closeStatement();
        databaseCon.closeConnection();
        session.setAttribute("studentTables", studentTables);
        resp.sendRedirect("student_list.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}