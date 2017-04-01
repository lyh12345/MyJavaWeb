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
<body bgcolor="#faebd7">
<link rel="stylesheet" type="text/css" href="css/mycss.css">
<link rel="stylesheet" type="text/css" href="css/magic.css">
<div class="magictime puffIn">
    <form action="mainServlet" method="post" class="basic-grey">

        <h1>请登陆
        </h1>
        <label>
            <span>学号:</span>
            <input type="text" name="userId" size="20"/>
        </label>
        <label>
            <span>密码:</span>
            <input type="password" name="password" size="20"/>
        </label>
        <center>
            <label>
                <input type="radio" name="roles" value="student" checked="checked">学生
                <input type="radio" name="roles" value="teacher">教师
                <input type="radio" name="roles" value="manager">管理员
            </label>
            <br>
            <label>
                <input type="submit" value="登陆">
            </label>
        </center>


    </form>
</div>
</body>
</html>