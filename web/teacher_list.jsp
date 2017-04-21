<%@ page import="model.TeacherTable" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: wjk1996
  Date: 2017/4/14
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="css/mycss.css">
<html>
<head>
    <title>教师信息</title>
</head>
<body>
<table align="center" class="tables">
    <caption>全部教师信息</caption>
    <tr>
        <th lign="center" valign="middle">工号</td>
        <th align="center" valign="middle">姓名</th>
        <th align="center" valign="middle">性别</th>
        <th align="center" valign="middle">出生日期</th>
        <th align="center" valign="middle">职务</th>
        <th align="center" valign="middle">教师工资</th>
        <th align="center" valign="middle">院系号</th>
        <th align="center" valign="middle">修改信息</th>
        <th align="center" valign="middle">删除信息</th>
    </tr>
    <%
        //获取教师信息集合
        List<TeacherTable> list = (List) session.getAttribute("list");
        //判断集合是否有效
        if (list == null || list.size() < 1) {
            out.print("没有数据！");
        } else {
            //遍历教师集合中的数据
            for (TeacherTable teacherTable : list) {
    %>
    <tr align="center">
        <td><%=teacherTable.getGh()%>
        </td>
        <td><%=teacherTable.getXm()%>
        </td>
        <td><%=teacherTable.getXb()%>
        </td>
        <td><%=teacherTable.getCsrq()%>
        </td>
        <td><%=teacherTable.getXl()%>
        </td>
        <td><%=teacherTable.getJbgz()%>
        </td>
        <td><%=teacherTable.getYxh()%>
        </td>
    </tr>
    <tr align="center">

        <form action="UpdateTeacher" method="post" onsubmit="return check(this);">
            <td>

                <input type="hidden" name="gh" value="<%=teacherTable.getGh()%>">
            </td>
            <td>
                <input type="text" name="xm" value="<%=teacherTable.getXm()%>" size="12">
            </td>
            <td>
                <input type="text" name="xb" value="<%=teacherTable.getXb()%>" size="5">
            </td>
            <td>
                <input type="text" name="csrq" value="<%=teacherTable.getCsrq()%>"size="10">
            </td>
            <td>
                <input type="text" name="xl" value="<%=teacherTable.getXl()%>"size="10">
            </td>
            <td>
                <input type="text" name="jbgz" value="<%=teacherTable.getJbgz()%>"size="10">
            </td>
            <td>
                <input type="text" name="yxh" value="<%=teacherTable.getYxh()%>"size="5">
            </td>
            <br>
            <td>
            <input type="submit" class="myButton" value="修 改">
            </td>
        </form>
        <td>
        <form action="DeleteTeacher" method="get" onsubmit="return check(this);">
            <input type="hidden" name="gh" value="<%=teacherTable.getGh()%>">
            <input type="submit" class="myButton" value="删 除">
        </form>
        </td>
    </tr>
    <%
            }
        }
    %>

</table>
</body>
</html>
