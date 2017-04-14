package Teacher;

import base.Connect;
import base.mTeacher;

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
 * Created by Mr.zhang on 2017/4/9.
 */
public class Getsem  extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        request.setCharacterEncoding("utf-8");
        List<String> xqList=new ArrayList<String>();
        mTeacher teacher= (mTeacher) session.getAttribute("teacher");
        Connect cnn=new Connect();
        String sql="select xq from O,C where C.kh=O.kh and gh="+"'"+teacher.getgh()+"'";
        ResultSet rs=cnn.executeQuery(sql);
        try{
            while (rs.next()){
                if(!xqList.contains(rs.getString("xq")))
                    xqList.add(rs.getString("xq"));
            }
            session.setAttribute("cxxueqi",xqList);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        cnn.closeStmt();
        cnn.closeConn();
        response.sendRedirect("ChaKanKeBiao.jsp");
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,
            IOException{
        doGet(request,response);
    }

}