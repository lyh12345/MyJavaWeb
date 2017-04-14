package Teacher;

import base.Connect;
import base.mTeacher;
import base.mstudent;

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
 * Created by Mr.zhang on 2017/4/8.
 */
public class StudentInClass extends HttpServlet{
public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
    request.setCharacterEncoding("utf-8");
    HttpSession session=request.getSession();
    List<mstudent> slist=new ArrayList<mstudent>();
    mTeacher teacher= (mTeacher) session.getAttribute("teacher");
    String xq=request.getParameter("sem");
    String km=request.getParameter("keming");
    Connect cnn=new Connect();
    String sql="select E.xh,xm,pscj,kscj,zpcj from E,c,S where S.xh=E.xh and E.kh=C.kh and C.km="+"'"+km+"'"+" and xq="+"'"+xq+"'"+" and "
            +"gh="+"'"+teacher.getgh()+"'";
    ResultSet rs=cnn.executeQuery(sql);
    try {
        while (rs.next()){
            mstudent student=new mstudent();
            student.setXh(rs.getString("xh"));
            student.setXm(rs.getString("xm"));
            //System.out.println(student.getXh()+student.getXm());
            student.setPscj(rs.getString("pscj"));
            student.setKscj(rs.getString("kscj"));
            student.setZpcj(rs.getString("zpcj"));
            slist.add(student);
        }
        session.setAttribute("instudent",slist);
    } catch (SQLException e) {
        e.printStackTrace();
    }
    cnn.closeStmt();
    cnn.closeConn();
    response.sendRedirect("chaxun.jsp");
}
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,
            IOException{
        doGet(request,response);
    }
}
