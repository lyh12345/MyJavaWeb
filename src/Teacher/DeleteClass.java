package Teacher;

import base.Connect;
import base.Tclass;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;

/**
 * Created by Mr.zhang on 2017/4/8.
 */
public class DeleteClass extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        request.setCharacterEncoding("utf-8");
        int i=0;
        Connect cnn=new Connect();
        String list[]=request.getParameterValues("check");
        if(list!=null)
        {for(i=0;i<list.length;i++){
            int j=Integer.parseInt(list[i]);
            List<Tclass> class1= (List<Tclass>) session.getAttribute("class");
          //  System.out.println(class1.get(j).getXq()+class1.get(j).getKh()+class1.get(j).getGh());
            String sql="DELETE from O where ( xq="+"'"+class1.get(j).getXq()+"'"+
                    " and kh="+"'"+class1.get(j).getKh()+"'"+" and gh= "+"'"+class1.get(j).getGh()+"'"
                    +" and sksj="+"'"+class1.get(j).getSksj()+"'"+" )"
                    ;
            String sql6="DELETE from E where ( xq="+"'"+class1.get(j).getXq()+"'"+
                    " and kh="+"'"+class1.get(j).getKh()+"'"+" and gh= "+"'"+class1.get(j).getGh()+"'"
                    +" )"
                    ;
            ResultSet rs=cnn.executeQuery(sql6);
            rs=cnn.executeQuery(sql);
        }

            cnn.closeStmt();
            cnn.closeConn();
        response.sendRedirect("close");
        }


    }
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,
            IOException{
        doGet(request,response);
    }
}
