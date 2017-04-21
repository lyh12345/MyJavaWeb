<%--
  Created by IntelliJ IDEA.
  User: lh
  Date: 2017/4/21
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="css/mycss.css">
<html>
<head>
    <title>添加学生</title>
</head>
<body>
<form action="AddStudentServlet" method="post" onsubmit="return check(this);">
    <table aligen="center">
        <tr>
            <td align="center" colspan="2">
                <h2>添加学生信息</h2>
                <hr>
            </td>
        </tr>
        <tr>
            <td align="right">学号：</td>
            <td><input type="text" name="xh"/></td>
        </tr>
        <tr>
            <td align="right">姓 名：</td>
            <td><input type="text" name="xm"/></td>
        </tr>
        <tr>
            <td align="right">性 别：</td>
            <td><input type="text" name="xb"/></td>
        </tr>
        <tr>
            <td align="right">出生日期：</td>
            <td><input type="text" name="csrq"/></td>
        </tr>
        <tr>
            <td align="right">籍贯：</td>
            <td><input type="text" name="jg"/></td>
        </tr>
        <tr>
            <td align="right">手机号码：</td>
            <td><input type="text" name="sjhm"/></td>
        </tr>
        <tr>
            <td align="right">院系号 ：</td>
            <td><input type="text" name="yxh"/></td>
        </tr>
        <tr>
            <td align="center" colspan="2">
                <input type="submit" class="myButton" value="添加"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
