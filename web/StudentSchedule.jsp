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
<%@ page import="java.util.Collections" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<link rel="stylesheet" type="text/css" href="css/mycss.css">
<html>
<head>
    <title>课表</title>
</head>
<body>
<%!
    public ArrayList<Integer> calculateLocation(String s) {
        ArrayList<Integer> list = new ArrayList<>();
        String s1 = s.substring(2, 3);
        String s2 = s.substring(4, 5);
        String s3 = s.substring(6, 7);
        char c1 = s.charAt(4);
        char c2 = s.charAt(6);
        Collections.addAll(list, 0, 0, 0);
        if (s1.equalsIgnoreCase("一")) {
            list.set(0, 1);
        } else if (s1.equalsIgnoreCase("二")) {
            list.set(0, 2);
        } else if (s1.equalsIgnoreCase("三")) {
            list.set(0, 3);
        } else if (s1.equalsIgnoreCase("四")) {
            list.set(0, 4);
        } else if (s1.equalsIgnoreCase("五")) {
            list.set(0, 5);
        }
        list.set(1, (int) (c1 - '0'));
        list.set(2, (int) (c2 - '0'));
        return list;
    }

%>
<%
    List<CourseTable> courseTables = (ArrayList) session.getAttribute("courseTables");
    Iterator<CourseTable> iterator = courseTables.iterator();
    CourseTable courseTable = null;
    char[][] tables = new char[14][6];
    char c = 'A';
%>
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
            ArrayList<Integer> list = calculateLocation(courseTable.getTime());
            int col = list.get(0);
            for (int i = list.get(1); i <= list.get(2); i++) {
                tables[i][col] = c;
            }
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
            c = (char) ((int) c + 1);
        }
    %>
</table>
<br>
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
        for (int i = 1; i <= 13; i++) {
    %>
    <tr align="center">
        <td><%=i%>
        </td>
        <%
            for (int j = 1; j <= 5; j++) {
        %>
        <td><%=tables[i][j]%>
        </td>
        <%
            }
        %>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
