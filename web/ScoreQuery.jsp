<%@ page import="java.util.List" %>
<%@ page import="model.ScoreTable" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="model.Term" %>
<%--
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
    Iterator<ScoreTable> iterator1 = scoreTables.iterator();
    ScoreTable scoreTable = null;
    String currentTerm = (String) session.getAttribute("currentTerm");
    List<Term> terms = (ArrayList) session.getAttribute("terms");
    Iterator<Term> iterator2 = terms.iterator();
    Term term = null;
%>
<div class="magictime puffIn">
    <table>
        <caption>成绩表</caption>
        <tr align="center">
            <th width="100">课号</th>
            <th width="100">课名</th>
            <th width="100">学分</th>
            <th width="100">成绩</th>
            <th width="100">绩点</th>
        </tr>
        <%
            while (iterator1.hasNext()) {
                scoreTable = iterator1.next();
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
        <tr>
            <td colspan="5">学期：<%=currentTerm%>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
