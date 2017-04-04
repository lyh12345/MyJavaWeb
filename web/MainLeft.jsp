<%@ page import="model.UserTable" %><%--
  Created by IntelliJ IDEA.
  User: lh
  Date: 2017/3/31
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="css/mycss.css">
<html>
<head>
    <title>基本信息</title>
</head>
<body>
<%
    UserTable userTable = (UserTable) session.getAttribute("user");
%>
<div>
    <table width="100%" class="tables">
        <tr>
            <th colspan="2">基本信息</th>
        </tr>
        <tr>
            <td>学号:</td>
            <td><%=userTable.getId()%>
            </td>
        </tr>
        <tr>
            <td>姓名:</td>
            <td><%=userTable.getName()%>
            </td>
        </tr>
        <tr>
            <th colspan="2">常用功能</th>
        </tr>
    </table>
    <br>
    <center>
        <form action="CourseChoose.jsp" method="post" target="ifram2">
            <input type="submit" class="mySubmit" value="选课">
        </form>
        <form action="courseReturnServlet" method="post" target="ifram2">
            <input type="submit" class="mySubmit" value="退课">
        </form>
        <form action="studentScheduleServlet" method="post" target="ifram2">
            <input type="submit" class="mySubmit" value="查看课表">
        </form>
        <form action="scoreQueryServlet" method="post" target="ifram2">
            <input type="submit" class="mySubmit" value="成绩查询">
        </form>
    </center>

</div>
</body>
</html>
