<%@ page import="model.StudentTable" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: wjk1996
  Date: 2017/4/15
  Time: 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="css/mycss.css">
<html>
<head>
</head>
<body>
<%
    //获取教师信息集合
    List<StudentTable> studentTables = (ArrayList) session.getAttribute("studentTables");
    Iterator<StudentTable> iterator = studentTables.iterator();
    StudentTable studentTable = null;
    /* 判断集合是否有效 */
%>
<table align="center" class="tables">
    <caption>全部学生信息</caption>
    <tr>
        <th align="center" valign="middle">学号</th>
        <th align="center" valign="middle">姓名</th>
        <th align="center" valign="middle">性别</th>
        <th align="center" valign="middle">出生日期</th>
        <th align="center" valign="middle">籍贯</th>
        <th align="center" valign="middle">手机号码</th>
        <th align="center" valign="middle">院系号</th>
        <th align="center" valign="middle">修改信息</th>
        <th align="center" valign="middle">删除信息</th>
    </tr>

    <%
        while (iterator.hasNext()) {
            studentTable = iterator.next();

    %>
    <tr align="center">
        <td><%=studentTable.getXh()%></td>
        <td><%=studentTable.getXm()%></td>
        <td><%=studentTable.getXb()%></td>
        <td><%=studentTable.getCsrq()%></td>
        <td><%=studentTable.getJg()%></td>
        <td><%=studentTable.getSjhm()%></td>
        <td><%=studentTable.getYxh()%></td>
    </tr>
    <tr align="center">

        <form action="UpdateStudent" method="post" onsubmit="return check(this);">
            <td>
                <input type="hidden" name="xh" value="<%=studentTable.getXh()%>">
            </td>
            <td>
                <input type="text" name="xm" value="<%=studentTable.getXm()%>" size="12">
            </td>
            <td>
                <input type="text" name="xb" value="<%=studentTable.getXb()%>" size="2" maxlength="2">
            </td>
            <td>
                <input type="text" name="csrq" value="<%=studentTable.getCsrq()%>"size="10">
            </td>
            <td>
                <input type="text" name="jg" value="<%=studentTable.getJg()%>"size="10">
            </td>
            <td>
                <input type="text" name="sjhm" value="<%=studentTable.getSjhm()%>"size="15">
            </td>
            <td>
                <input type="text" name="yxh" value="<%=studentTable.getYxh()%>"size="10">
            </td>
            <br>
            <td>
                <input type="submit" class="myButton" value="修 改">
            </td>
        </form>
        <td>
            <form action="DeleteStudent" method="get" onsubmit="return check(this);">
                <input type="hidden" name="xh" value="<%=studentTable.getXh()%>">
                <input type="submit" class="myButton" value="删 除">
            </form>
        </td>
    </tr>
    <%

        }
    %>

</table>
</body>
</html>
