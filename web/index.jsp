<%--
  Created by IntelliJ IDEA.
  User: lh935
  Date: 2017/3/4
  Time: 19:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.sql.*" import="java.util.Date" %>
<jsp:useBean id="database" class="database.DatabaseCon"></jsp:useBean>
<html>
<head>
    <title>数据库</title>
</head>
<body>
<table border="1">
    <tr>
        <th>学号</th>
        <th>姓名</th>
    </tr>
    <%
        String sql = "select * from S";
        ResultSet rs = database.executeQuery(sql);
        try {
            while (rs.next()) {
    %>
    <tr>
        <td><%=rs.getString(1)%>
        </td>
        <td><%=rs.getString(2)%>
        </td>
    </tr>
    <%
        }
            rs.close();
            database.closeStatement();
            database.closeConnection();
        } catch (Exception e) {
    %>
    <%=e.getMessage()%>
    <%
        }
    %>
    </br>
</table>
</body>
</html>