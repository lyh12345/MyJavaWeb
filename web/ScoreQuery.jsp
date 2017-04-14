<%--
  Created by IntelliJ IDEA.
  User: lh
  Date: 2017/3/31
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="model.ScoreTable" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="model.Term" %>
<%@ page import="java.util.Random" %>
<%@ page import="model.AvgGPAofTerm" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

    List<AvgGPAofTerm> avgGPAofTerms = (ArrayList) session.getAttribute("avgGPAofTerms");
    AvgGPAofTerm avgGPAofTerm = null;
    Iterator<AvgGPAofTerm> iterator2 = avgGPAofTerms.iterator();
    Term term = null;
    char c = 'A';
    ArrayList<Character> cc = new ArrayList<>();
%>
<h2>成绩表</h2>
<table class="tables">
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
<table class="tables">
    <caption>学期表</caption>
    <tr align="center">
        <th>序号</th>
        <th>学期</th>
        <th>平均绩点</th>
    </tr>
    <%
        while (iterator2.hasNext()) {
            avgGPAofTerm = iterator2.next();
    %>
    <tr align="center">
        <td><%=c%>
        </td>
        <td><%=avgGPAofTerm.getTerm()%>
        </td>
        <td><%=avgGPAofTerm.getAvgGPA()%>
        </td>
    </tr>
    <%
            cc.add(c);
            c = (char) (c + 1);
        }
    %>
</table>

<h2>成绩趋势</h2>
<br>
<div class="custom-bar-chart">
    <%
        Iterator<Character> iterator = cc.iterator();
        Iterator<AvgGPAofTerm> iterator3 = avgGPAofTerms.iterator();
        while (iterator.hasNext()) {
            char ccc = iterator.next();
            avgGPAofTerm = iterator3.next();
    %>
    <div class="bar">
        <div class="title"><%=ccc%>
        </div>
        <div class="value tooltips" data-toggle="tooltip" data-placement="top"
             style="height: <%=(avgGPAofTerm.getAvgGPA()*100)%>;"><%=(avgGPAofTerm.getAvgGPA())%>
        </div>
    </div>
    <%
        }
    %>
</div>
</body>
</html>
