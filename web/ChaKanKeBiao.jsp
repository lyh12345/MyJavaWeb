<%@ page import="java.util.List" %>
<%@ page import="base.Tclass" %><%--
  Created by IntelliJ IDEA.
  User: MR.zhang
  Date: 2017/4/9
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="css/mycss.css">
<html>

<body>
<form action="getkb" method="post">
    <select name="cksem">
        <% List<String> list1= (List<String>) session.getAttribute("cxxueqi");
            for(int i=0;i<list1.size();i++)
            {
        %>
        <option value="<%=list1.get(i)%>"><%=list1.get(i)%></option>
        <%
            }
        %>
    </select>
    <input TYPE="submit" class="myButton" value="确定">
</form>
<table class="tables">
    <caption>开课表</caption>
    <tr>

        <th>学期</th>
        <th>课号</th>
        <th>课程名</th>
        <th>上课时间</th>
    </tr>
    <% List<Tclass> list= (List<Tclass>) session.getAttribute("hasclass");
        int i;
        if(list!=null)
        for(i=0;i<list.size();i++)
        {%>
    <tr>
        <td><%=list.get(i).getXq() %></td>
        <td><%=list.get(i).getKh() %></td>
        <td><%=list.get(i).getName() %></td>
        <td><%=list.get(i).getSksj() %></td>
    </tr>

    <%
        }
    %>
</table>
<table class="tables">
    <caption>课程表</caption>
    <tr>

        <th>时间</th>
        <th>星期一</th>
        <th>星期二</th>
        <th>星期三</th>
        <th>星期四</th>
        <th>星期五</th>
    </tr>
    <%  char tt[][]= (char[][]) session.getAttribute("kebiao");
        if(tt!=null)
        for(i=0;i<10;i++)
            {%>
    <tr>
        <td><%=i+1%></td>
        <% for(int j=0;j<5;j++)
            {
            %><td><%=tt[i][j]%></td>
        <%
            }
            %>

    </tr>

    <%
            }
    %>
</table>
</body>
</html>
