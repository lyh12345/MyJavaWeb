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
public class GetKb extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session=request.getSession();
        List<Tclass> tclassList=new ArrayList<Tclass>();
        String xq=request.getParameter("cksem");
        char kb[][]=new char[10][5];
        for(int i=0;i<10;i++)
            for(int j=0;j<5;j++)
                kb[i][j]=' ';
        char x='A';
        Tclass tclass;
        mTeacher teacher=(mTeacher) session.getAttribute("teacher");
        String gh=teacher.getgh();
        Connect cnn=new Connect();
        String sql2="select * from O where gh ="+"'"+gh+"'"+" and "+"xq="+"'"+xq+"'";
        ResultSet rs1=cnn.executeQuery(sql2);
        try{
            while(rs1.next()){
                tclass=new Tclass();
                String sql4="select km from C where kh="+"'"+rs1.getString("kh")+"'";
                ResultSet rs4=cnn.executeQuery(sql4);
                while (rs4.next())
                    tclass.setName(rs4.getString("km"));
                tclass.setxq(rs1.getString("xq"));
                tclass.setKh(rs1.getString("kh"));
                tclass.setGh(rs1.getString("gh"));
                tclass.setSksj(rs1.getString("sksj"));
                tclassList.add(tclass);
                String t=tclass.getSksj();
                String word[]=t.split("\\s+");
                int i,j;
                if(word[0].equals("星期一"))
                    j=0;
                else if(word[0].equals("星期二"))
                    j=1;
                else if(word[0].equals("星期三"))
                    j=2;
                else if(word[0].equals("星期四"))
                    j=3;
                else
                    j=4;
                String ti[]=word[1].split("-");
//                System.out.println(ti[0]+"-"+ti[1]);
                for(i=Integer.parseInt(ti[0]);i<=Integer.parseInt(ti[1]);i++)
                    kb[i-1][j]=x;
                x++;
            }
//            for(int i=0;i<10;i++)
//            {  for(int j=0;j<5;j++)
//                    System.out.print(kb[i][j]);
//                System.out.print("\n");
//                }
            session.setAttribute("hasclass",tclassList);
            session.setAttribute("kebiao",kb);
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