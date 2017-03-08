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
    <title>数据库</title>
</head>
<body>
<table border="1">
    <tr>
        <th>姓名</th>
        <th>学号</th>
    </tr>
    <%
        String dbUser = "sa";//设置连接数据库的信息
        String dbPassword = "935686942";
        String dbDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String dbURL = "jdbc:sqlserver://localHost:1433;DatabaseName=t";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ResultSetMetaData md = null;

        String xSQL = "select * from T";//设置SQl
        try {
            Class.forName(dbDriver).newInstance();  //加载驱动
            conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);   //获取连接
            stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(xSQL);
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