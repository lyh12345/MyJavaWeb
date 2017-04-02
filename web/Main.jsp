<%--
  Created by IntelliJ IDEA.
  User: lh
  Date: 2017/3/29
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="model.UserTable,java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="css/mycss.css">
<link rel="stylesheet" type="text/css" href="css/magic.css">

<html>

<head>
    <title>主页</title>
</head>
<body>
<div class="magictime puffin">
    <%
        UserTable userTable = (UserTable) session.getAttribute("user");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-hh:mm");
    %>
    <div class="head1">
        <div id="head_left">
            <form action="loginOutServlet" method="get">
                欢迎 <%=userTable.getName()%>登陆本系统！<%=simpleDateFormat.format(new Date())%> <input type="submit" class="myButton" value="退出">

            </form>
        </div>
    </div>
    <div>
        <%--分区显示--%>
        <iframe align="left" name="ifram1" id="ifram1" frameborder="1" width="14%" height="100%" src="MainLeft.jsp">
        </iframe>
        <iframe align="left" name="ifram3" id="ifram3" scrolling="no" frameborder="0" width="85%" height="60px"
                src="MainTop.jsp">
        </iframe>
        <iframe align="left|bottom" name="ifram2" id="ifam2" frameborder="0" width="85%" height="100%"
                src="MainRight.jsp">
        </iframe>
    </div>
</div>
</body>
</html>
