package Teacher;

import base.Connect;
import base.Tclass;
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
public class inclass  extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
        request.setCharacterEncoding("utf-8");
        Connect cnn=new Connect();
        HttpSession session=request.getSession();
        List<Tclass> tclassList=new ArrayList<Tclass>();
        mTeacher teacher=new mTeacher();
        teacher= (mTeacher) session.getAttribute("teacher");
        String gh=teacher.getgh();
        String sql="select * from O where gh="+"'"+gh+"'";
        ResultSet rs=cnn.executeQuery(sql);
        try{
            while(rs.next()){
                Tclass tclass=new Tclass();
                String sql2="select km from C where kh="+"'"+rs.getString("kh")+"'";
                ResultSet rs1=cnn.executeQuery(sql2);
                while(rs1.next()){
                    tclass.setName(rs1.getString("km"));
                }
                tclass.setxq(rs.getString("xq"));
                tclass.setKh(rs.getString("kh"));
                tclass.setGh(rs.getString("gh"));
                tclass.setSksj(rs.getString("sksj"));
                tclassList.add(tclass);
            }
            session.setAttribute("nowclass",tclassList);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        cnn.closeConn();
        cnn.closeStmt();
        response.sendRedirect("OpenClass.jsp");

    }
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,
            IOException{
        doGet(request,response);
    }




}