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
<div class="main_left">

    <table width="100%" class="imagetable">
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
        <tr bgcolor="#a9e2a7">
            <th colspan="2">常用功能</th>
        </tr>
        <tr>
            <td colspan="2"><a href="CourseChoose.jsp" target="ifram2">选课</a></td>
        </tr>
        <tr>
            <td colspan="2"><a href="CourseReturn.jsp" target="ifram2">退课</a></td>
        </tr>
        <tr>
            <td colspan="2"><a href="StudentSchedule.jsp" target="ifram2">查看课表</a></td>
        </tr>
        <tr>
            <td colspan="2"><a href="scoreQueryServlet" target="ifram2">成绩查询</a></td>
        </tr>
    </table>
</div>
</body>
</html>
