<%--
  Created by IntelliJ IDEA.
  User: lh935
  Date: 2017/3/4
  Time: 19:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.sql.*" import="java.util.Date" %>
<html>
<head>
    <title>登陆</title>
</head>
<body background="css/back.jpg">
<link rel="stylesheet" type="text/css" href="css/mycss.css">
<link rel="stylesheet" type="text/css" href="css/magic.css">
<div class="magictime puffIn">
    <form action="loginServlet" method="post" class="basic-grey">
        <h1>请登陆</h1>
        <div style="text-align: center;">
            <label for="userId">账号:</label><input type="text" id="userId" name="userId" size="20"/>
            <br>
            <label for="password">密码:</label><input type="password" id="password" name="password" size="20"/>
            <br>
            <input type="radio" id="student" name="roles" value="student" checked="checked"><label
                for="student">学生</label>
            <input type="radio" id="teacher" name="roles" value="teacher"><label for="teacher">教师</label>
            <input type="radio" id=" manager" name="roles" value="manager"><label for=" manager">管理员</label>
            <br>
            <label>
                <input type="submit" value="登陆">
            </label>
        </div>
    </form>
    <% String flag = (String) session.getAttribute("loginConfirm");
        if (!(flag == null)) {
            if (flag.equals("failed")) {
    %>
    <center>
        <font color="red">密码或账号错误！</font>
    </center>
    <%
            }
        }
    %>
</div>
</body>
</html>