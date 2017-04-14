<%@ page import="base.Tclass" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: MR.zhang
  Date: 2017/4/5
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="css/mycss.css">
<html>
<head>
</head>
<body>
<h2>开课</h2>
<form action="insert" method="post">
    <laber>请输入学期：</laber>
    <label>
        <input type="text" name="semester">
    </label>
    <label>请输入课号：</label>
    <label>
        <input type="text" name="kehao">
    </label>
    <br>
    <label>请输入上课时间：</label>
    <label>
        <select name="weekday">--%>
            <option value="星期一">星期一</option>
            <option value="星期二">星期二</option>
            <option value="星期三">星期三</option>
            <option value="星期四">星期四</option>
            <option value="星期五">星期五</option>
        </select>
        &nbsp;
        <input type="number" max="10" min="1" name="begin">-
        <input type="number" max="10" min="1" name="end">
    </label>
<input type="submit" class="myButton" name="提交">
<input type="reset" class="myButton" name="重置">
    <table class="tables">
        <caption>开课表</caption>
        <tr>
            <th>学期</th>
            <th>课号</th>
            <th>课程名</th>
            <th>上课时间</th>
        </tr>
        <% List<Tclass> list= (List<Tclass>) session.getAttribute("nowclass");
            int i;
            for(i=0;i<list.size();i++)
            {%>
        <tr>

            <td><%=list.get(i).getXq() %></td>
            <td><%=list.get(i).getKh() %></td>
            <td><%=list.get(i).getName() %></td>
            <td><%=list.get(i).getSksj() %></td>
        </tr>

        <%
            }
        %>
    </table>
</form>
</body>
</html>
