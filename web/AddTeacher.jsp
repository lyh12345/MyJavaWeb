<%@ page import="model.TeacherTable" %><%--
  Created by IntelliJ IDEA.
  User: wjk1996
  Date: 2017/4/17
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="css/mycss.css">
<html>
<head>
    <title>添加教师信息</title>
</head>
<body>
<%
    TeacherTable teacherTable = new TeacherTable();
%>
<form action="AddTeacherServlet" method="post" onsubmit="return check(this);">
    <table aligen="center">
        <tr>
            <td align="center" colspan="2">
                <h2>添加教师信息</h2>
                <hr>
            </td>
        </tr>
        <tr>
            <td align="right">教师工号：</td>
            <td><input type="text" name="gh"/></td>
        </tr>
        <tr>
            <td align="right">姓 名：</td>
            <td><input type="text" name="xm"/></td>
        </tr>
        <tr>
            <td align="right">性 别：</td>
            <td><input type="text" name="xb"/></td>
        </tr>
        <tr>
            <td align="right">出生日期：</td>
            <td><input type="text" name="csrq"/></td>
        </tr>
        <tr>
            <td align="right">职 务：</td>
            <td><input type="text" name="xl"/></td>
        </tr>
        <tr>
            <td align="right">教师工资：</td>
            <td><input type="text" name="jsgz"/></td>
        </tr>
        <tr>
            <td align="right">院系号 ：</td>
            <td><input type="text" name="yxh"/></td>
        </tr>
        <tr>
            <td align="center" colspan="2">
                <input type="submit" class="myButton" value="添加"/>
            </td>
        </tr>
    </table>
</form>

</body>
</html>
