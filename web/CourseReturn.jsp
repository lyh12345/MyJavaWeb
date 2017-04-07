<%--
  Created by IntelliJ IDEA.
  User: lh
  Date: 2017/3/31
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="model.CourseTable" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="css/mycss.css">
<html>
<head>
    <title>退课</title>
</head>
<body>
<%
    List<CourseTable> courseTables = (ArrayList) session.getAttribute("courseTables");
    Iterator<CourseTable> iterator = courseTables.iterator();
    CourseTable courseTable = null;
    int location = -1;
    session.setAttribute("courseReturnLocation",location);
    int count = 0;
%>
    <form action="courseReturnServlet" method="get">
        <div style="display: none">
            <input type="radio" name="location" value ="-1" checked="checked">
        </div>
        <h2>退课</h2>
    <table class="tables">
        <caption>课表</caption>
        <tr align="center">
            <th>选择一个</th>
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
            <td><input type="radio" name="location" value = <%=count%>>
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
                count++;
            }
        %>
        <tr>
            <td colspan="7"><input type="submit" class="mySubmit2" value="退课"></td>
        </tr>
    </table>
    </form>
</body>
</html>
