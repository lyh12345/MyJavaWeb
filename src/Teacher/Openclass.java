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
import java.util.Objects;

/**
 * Created by Mr.zhang on 2017/4/6.
 */
public class Openclass extends HttpServlet{
public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException ,IOException{
    request.setCharacterEncoding("utf-8");
    HttpSession session=request.getSession();
    List<Tclass> tclassList=new ArrayList<Tclass>();

    char kb[][]=new char[10][5];
    for(int i=0;i<10;i++)
        for(int j=0;j<5;j++)
            kb[i][j]=' ';
    char x='A';
    Tclass tclass;
    mTeacher teacher=(mTeacher) session.getAttribute("teacher");
    String gh=teacher.getgh();
    Connect cnn=new Connect();
    boolean Iskc=false;
    boolean time=true;
    String weekday=request.getParameter("weekday");
    String xq=request.getParameter("semester");
    String kh=request.getParameter("kehao");
    String s=request.getParameter("begin");
    String end=request.getParameter("end");
    String sql="select kh from C";

    ResultSet rs=cnn.executeQuery(sql);
    try{
        while(rs.next()){
            if(Objects.equals(kh, rs.getString("kh")))
                Iskc=true;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    if(Integer.parseInt(s)>Integer.parseInt(end)){
     time=false;
    }

    String sql2="select * from O where gh ="+"'"+gh+"'"+" and "+"xq="+"'"+xq+"'";
    ResultSet rs1=cnn.executeQuery(sql2);
    try{
        while(rs1.next()){
            if(kh.equals(rs1.getString("kh")))
                Iskc=false;
            tclass=new Tclass();
            String sql4="select km from C where kh="+"'"+rs1.getString("kh")+"'";
            ResultSet rs4=cnn.executeQuery(sql4);
            while (rs4.next())
            tclass.setName(rs4.getString("km"));
            tclass.setxq(rs1.getString("xq"));
            tclass.setKh(rs1.getString("kh"));
            tclass.setGh(rs1.getString("gh"));
            tclass.setSksj(rs1.getString("sksj"));
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
            for(i=Integer.parseInt(ti[0]);i<=Integer.parseInt(ti[0]);i++)
             kb[i-1][j]=x;
             x++;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    if(Iskc&&time){
        int i,j;
        boolean TimeCon=true;
        if(weekday.equals("星期一"))
            j=0;
        else if(weekday.equals("星期二"))
            j=1;
        else if(weekday.equals("星期三"))
            j=2;
        else if(weekday.equals("星期四"))
            j=3;
        else
            j=4;
        for(i=Integer.parseInt(s);i<=Integer.parseInt(end);i++)
            if(kb[i-1][j]!=' ') {
                TimeCon = false;
                break;
            }
            if(TimeCon){
                String sql6="select * from O where gh ="+"'"+gh+"'";
                ResultSet rs6=cnn.executeQuery(sql6);
                try{
                    while(rs6.next()){
                        tclass=new Tclass();
                        String sql4="select km from C where kh="+"'"+rs6.getString("kh")+"'";
                        ResultSet rs4=cnn.executeQuery(sql4);
                        while (rs4.next())
                            tclass.setName(rs4.getString("km"));
                        tclass.setxq(rs6.getString("xq"));
                        tclass.setKh(rs6.getString("kh"));
                        tclass.setGh(rs6.getString("gh"));
                        tclass.setSksj(rs6.getString("sksj"));
                        tclassList.add(tclass);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            String sql3="INSERT INTO O(xq,kh,gh,sksj) VALUES ('"+xq+"','"+kh+"','"+gh+"','"+weekday+" "+s+"-"+end+"')";
            ResultSet rs3=cnn.executeQuery(sql3);
            tclass=new Tclass();
                String sql5="select km from C where kh="+"'"+kh+"'";
                ResultSet rs4=cnn.executeQuery(sql5);
                try {
                    while (rs4.next())
                        tclass.setName(rs4.getString("km"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                tclass.setKh(kh);
                tclass.setxq(xq);
                tclass.setGh(gh);
                tclass.setSksj(weekday+" "+s+"-"+end);
                tclassList.add(tclass);
                session.setAttribute("nowclass",tclassList);
            }
    }

    cnn.closeStmt();
    cnn.closeConn();
    response.sendRedirect("OpenClass.jsp");
}
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,
            IOException{
        doGet(request,response);
    }

}
