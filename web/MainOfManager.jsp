<%@ page import="model.UserTable" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: lh
  Date: 2017/4/21
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="css/mycss.css">
<html>
<head>
    <title>管理员</title>
</head>
<body>
<%
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-hh:mm");
%>
<div class="head1">
    <form action="loginOutServlet" method="get">
        欢迎管理员登陆本系统！<%=simpleDateFormat.format(new Date())%>
        <input type="submit" class="myButton2" value="退出">
    </form>
</div>
<%--分区显示--%>
<iframe align="left" name="ifram1" id="ifram4" frameborder="1" width="14%" height="100%" src="MainOfManagerLeft.jsp">
</iframe>
<iframe align="left|bottom" name="ifram5" id="ifam2" frameborder="0" width="85%" height="100%"
        src="FindTeacher">
</iframe>
</body>
</html>
