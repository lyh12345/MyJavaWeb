<%@ page import="model.UserTable" %><%--
  Created by IntelliJ IDEA.
  User: lh
  Date: 2017/3/29
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="css/mycss.css">
<html>

<head>
    <title>主页</title>
</head>
<body>
<%
    UserTable userTable =(UserTable) session.getAttribute("user");
%>
<div class="head1">
    <label>
    欢迎 <%=userTable.getName()%>登陆本系统！
</label>
    <input type="button" value="退出" name="quit" align="right">
</div>
<iframe align="left" name="ifram1" id="ifram1" frameborder="1" width="15%" height="100%" src="MainLeft.jsp">
</iframe>
<iframe align="left" name="ifram2" id="ifam2" frameborder="1" width="84%" height="100%" src="MainRight.jsp">
</iframe>
</body>
</html>
