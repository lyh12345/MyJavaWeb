<%@ page import="base.Tclass" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: MR.zhang
  Date: 2017/4/8
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="css/mycss.css">
<html>
<head>
</head>
<body>
关课
<form action="offc" method="post" >
<table class="tables">
    <caption>开课表</caption>
    <tr>
        <th>选择关闭课程</th>
        <th>学期</th>
        <th>课号</th>
        <th>课程名</th>
        <th>上课时间</th>
    </tr>
    <% List<Tclass> list= (List<Tclass>) session.getAttribute("class");
    int i;
    for(i=0;i<list.size();i++)
     {%>
    <tr>
        <td><input type="checkbox" name="check" value=<%=i%>> </td>
<td><%=list.get(i).getXq() %></td>
<td><%=list.get(i).getKh() %></td>
        <td><%=list.get(i).getName() %></td>
        <td><%=list.get(i).getSksj() %></td>
    </tr>

         <%
     }
    %>
</table>
    <input type="submit" class="myButton" value="确定">
    <input type="reset" class="myButton" value="取消">
</form>
</body>
</html>
