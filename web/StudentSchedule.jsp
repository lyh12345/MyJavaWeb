<%--
  Created by IntelliJ IDEA.
  User: lh
  Date: 2017/3/31
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="model.CourseTable" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="css/mycss.css">
<link rel="stylesheet" type="text/css" href="css/magic.css">
<html>
<head>
    <title>课表</title>
</head>
<body>
<%
    List<CourseTable> courseTables = (ArrayList) session.getAttribute("courseTables");
    Iterator<CourseTable> iterator = courseTables.iterator();
    CourseTable courseTable = null;
    char c = 'A';
    char[][] tables = new char[13][5];
    int row = 0;
    int col = 0;
    char crow1;
    char crow2;
    char ccol;
%>
<div class="magictime puffIn">
<h2>课表</h2>
<table class="tables">
    <caption>课表</caption>
    <tr align="center">
        <th>序号</th>
        <th>课程号</th>
        <th>课程名</th>
        <th>上课时间</th>
        <th>教师姓名</th>
        <th>教师工号</th>
        <th>学分</th>
    </tr>
    <%
        while (iterator.hasNext()) {
            courseTable = iterator.next();

    %>
    <tr align="center">
        <td><%=c%>
        </td>
        <td><%=courseTable.getCourseId()%>
        </td>
        <td><%=courseTable.getCourseName()%>
        </td>
        <td><%=courseTable.getTime()%>
        </td>
        <td><%=courseTable.getTeacherName()%>
        </td>
        <td><%=courseTable.getTeacherId()%>
        </td>
        <td><%=courseTable.getCourseCredit()%>
        </td>
    </tr>
    <%
            c= (char) ((int)c+1);
            crow1 = courseTable.getTime().toCharArray()[5];
            crow2 = courseTable.getTime().toCharArray()[3];
            ccol = courseTable.getTime().toCharArray()[2];
            //col =ccol-'一';
            for(int k = (int)(crow2-'1'); k<=(int)(crow1-crow2);k++)
                tables[k][col] = c;
        }
    %>
</table>
    <table class="tables">
        <tr align="center">
            <th></th>
            <th>周一</th>
            <th>周二</th>
            <th>周三</th>
            <th>周四</th>
            <th>周五</th>
        </tr>
        <%
           for(int i = 1; i<=13;i++){
        %>
        <tr align="center">
            <td><%=i%>
            </td>
            <%
            for(int j = 1;j<=5;j++){
            %>
            <td><%=tables[i-1][j-1]%></td>
            <%
            }
            %>
        </tr>
        <%
            }
        %>
    </table>
</div>
</body>
</html>
