<%@ page import="base.mTeacher" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: MR.zhang
  Date: 2017/4/3
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教师首页</title>
</head>
<body>
<link rel="stylesheet" type="text/css" href="css/mycss.css">
<div class="head1">
    <form action="loginOutServlet" method="get">
        <%
            mTeacher teacher = (mTeacher) session.getAttribute("teacher");
            out.print(teacher.getXm());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-hh:mm");
        %>
        老师,欢迎您的到来！<%=simpleDateFormat.format(new Date())%>
        <input type="submit" class="myButton2" value="退出">
    </form>
</div>
<div style="float:left;width: 14%;border: 2px solid #9D9D9D;height: 100%">
    <table width="100%" class="tables">
        <tr>
            <th colspan="2">教师信息</th>
        </tr>
        <tr>
            <td>工号：</td>
            <td><%out.print(teacher.getgh());%>
            </td>
        </tr>
        <tr>
            <td>姓名：</td>
            <td><%out.print(teacher.getXm());%>
            </td>
        </tr>
        <tr>
            <td>性别：</td>
            <td><%out.print(teacher.getXb());%>
            </td>
        </tr>
        <tr>
            <td>学历：</td>
            <td><%out.print(teacher.getXl());%>
            </td>
        </tr>
        <tr>
            <td>基本工资：</td>
            <td><%out.print(teacher.getjbgz());%>
            </td>
        </tr>
        <tr>
            <th colspan="2">常用功能</th>
        </tr>
    </table>
    <br>
    <div style="text-align: center;">
        <form action="inclass1" method="post" target="work">
            <input type="submit" class="mySubmit" value="开课">
        </form>
        <form action="close" method="post" target="work">
            <input type="submit" class="mySubmit" value="关课">
        </form>
        <form action="enter" method="post" target="work">
            <input type="submit" class="mySubmit" value="成绩录入">
        </form>
        <form action="cx" method="post" target="work">
            <input type="submit" class="mySubmit" value="查询选课学生">
        </form>
        <form action="semst" method="post" target="work">
            <input type="submit" class="mySubmit" value="查询课表">
        </form>
    </div>
</div>
<div style="width:85%;float: left">
    <iframe name="work" style="height:100%;width: 100%;border: 0px">
    </iframe>
</div>
</body>
</html>
