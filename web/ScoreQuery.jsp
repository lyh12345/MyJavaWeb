<%@ page import="java.util.List" %>
<%@ page import="model.ScoreTable" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: lh
  Date: 2017/3/31
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="css/magic.css">
<link rel="stylesheet" type="text/css" href="css/mycss.css">
<html>
<head>
    <title>成绩查询</title>
</head>
<body>
<%
    List<ScoreTable> scoreTables = (ArrayList) session.getAttribute("score");
    Iterator<ScoreTable> iterator = scoreTables.iterator();
    ScoreTable scoreTable = null;
%>
<div class="magictime puffIn">

    <table class="imagetable2">
        <tr bgcolor="#e3f4ff" align="center">
            <th width="100">课号</th>
            <th width="100">课名</th>
            <th width="100">学分</th>
            <th width="100">成绩</th>
            <th width="100">绩点</th>
        </tr>
        <%
            while (iterator.hasNext()) {
                scoreTable = iterator.next();
        %>
        <tr align="center">
            <td><%=scoreTable.getCourseId()%>
            </td>
            <td><%=scoreTable.getCourseName()%>
            </td>
            <td><%=scoreTable.getCourseCredit()%>
            </td>
            <td><%=scoreTable.getCourseGrade()%>
            </td>
            <td><%=scoreTable.getCourseGPA()%>
            </td>
        </tr>
        <%
            }
        %>
    </table>
</div>
</body>
</html>
