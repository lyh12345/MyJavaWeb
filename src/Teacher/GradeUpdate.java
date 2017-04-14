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
import java.util.List;

/**
 * Created by Mr.zhang on 2017/4/9.
 */
public class GradeUpdate extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        HttpSession session=request.getSession();
        request.setCharacterEncoding("utf-8");
        String s=null;
        Connect cnn=new Connect();
        mTeacher teacher= (mTeacher) session.getAttribute("teacher");
        List<mstudent> list1= (List<mstudent>) session.getAttribute("changstudent");
        String xq= (String) session.getAttribute("nowxq");
        String kc= (String) session.getAttribute("nowkm");
        System.out.println(xq);
        String sql="select kh from c where km="+"'"+kc+"'";
        ResultSet rs=cnn.executeQuery(sql);
        try{
            while(rs.next()){
                kc=rs.getString("kh");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.print(kc);
        if(list1!=null){
            for(int i=0;i<list1.size();i++){
                s=String.valueOf(i);
                String pscj=request.getParameter(s+"p");
                String kscj=request.getParameter(s+"k");
                String zpcj=request.getParameter(s+"z");
                list1.get(i).setPscj(pscj);
                list1.get(i).setKscj(kscj);
                list1.get(i).setZpcj(zpcj);
                String sql2="update E set pscj="+pscj+" , kscj="+kscj+" , zpcj="+zpcj+" where " +
                        "gh="+"'"+teacher.getgh()+"'"+" and xq="+"'"+xq+"'"+" and kh="+"'"+kc+"'"
                        +" and xh="+"'"+list1.get(i).getXh()+"'";
               ResultSet rs1=cnn.executeQuery(sql2);
                try {
                    rs1.next();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        cnn.closeStmt();
        cnn.closeConn();
        response.sendRedirect("GradeEnter.jsp");
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,
            IOException{
        doGet(request,response);
    }
}
