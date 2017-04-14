<%--
  Created by IntelliJ IDEA.
  User: lh
  Date: 2017/3/31
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="css/mycss.css">
<html>
<head>
    <title>选课</title>
</head>
<body>
<div height="40%"></div>
<form action="courseSearchServlet" method="post" target="iframCourseSearch">
    <h2> 查询</h2>
    课程号:<input type="text" name="courseId">
    课程名:<input type="text" name="courseName">
    <input type="submit" value="查询" class="myButton">
</form>
<form action="courseChooseServlet" method="post" target="iframCourseSearch">
    <h2>选课</h2>
    课程号:<input type="text" name="courseId">
    教师号:<input type="text" name="teacherId">
    <input type="submit" value="确定" class="myButton">
</form>
<iframe name="iframCourseSearch" frameborder="0" height="60%" width="100%">
</iframe>
</body>
</html>
