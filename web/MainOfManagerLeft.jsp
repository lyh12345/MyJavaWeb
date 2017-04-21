<%--
  Created by IntelliJ IDEA.
  User: lh
  Date: 2017/4/21
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="css/mycss.css">
<html>
<head>
    <title>left</title>
</head>
<body>
<table width="100%" class="tables">
    <tr>
        <th colspan="2">常用功能</th>
    </tr>
</table>
<br>
<div style="text-align: center;">
    <form action="FindTeacher" method="post" target="ifram5">
        <input type="submit" class="mySubmit" value="查看教师信息">
    </form>
    <form action="FindStudent" method="post" target="ifram5">
        <input type="submit" class="mySubmit" value="查看学生信息">
    </form>
    <form action="AddTeacher.jsp" method="post" target="ifram5">
        <input type="submit" class="mySubmit" value="添加教师">
    </form>
    <form action="AddStudent.jsp" method="post" target="ifram5">
        <input type="submit" class="mySubmit" value="添加学生">
    </form>
</div>
</body>
</html>
