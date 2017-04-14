<%@ page import="java.util.List" %>
<%@ page import="base.mstudent" %><%--
  Created by IntelliJ IDEA.
  User: MR.zhang
  Date: 2017/4/8
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="css/mycss.css">
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="Entry" method="post">
    <select name="sem1">
        <% List<String> list1= (List<String>) session.getAttribute("xueqi1");
            for(int i=0;i<list1.size();i++)
            {
        %>
        <option value="<%=list1.get(i)%>"><%=list1.get(i)%></option>
        <%
            }
        %>
    </select>
    <select name="keming1">
        <% List<String> list2= (List<String>) session.getAttribute("kecheng1");
            for(int j=0;j<list2.size();j++)
            {
        %>
        <option value=<%=list2.get(j)%>><%=list2.get(j)%></option>
        <%
            }
        %>
    </select>
    <input type="submit" class="myButton" value="确定">
</form>
<form action="update" method="post">
<table class="tables">
    <caption>学生表</caption>
    <tr>
        <th>学生姓名</th>
        <th>学生学号</th>
        <th>平时成绩</th>
        <th>考试成绩</th>
        <th>总评成绩</th>
    </tr>
    <% List<mstudent> list3= (List<mstudent>) session.getAttribute("changstudent");
        if(list3==null)
        {%>
    请查询
    <% }
    else
    {
        for(int i=0;i<list3.size();i++)
        {
    %>
    <tr>
        <td><%=list3.get(i).getXm()%></td>
        <td><%=list3.get(i).getXh()%></td>
        <td><input type="number" max=100 min="0" name="<%=i%>p" value=<%=list3.get(i).getPscj()%>></td>
        <td><input type="number" max=100 min="0" name="<%=i%>k" value=<%=list3.get(i).getKscj()%>></td>
        <td><input type="number" max=100 min="0" name="<%=i%>z" value=<%=list3.get(i).getZpcj()%>></td>
    </tr>
    <%
            }
        }

    %>
</table>
<input type="submit" class="myButton" value="确定"><input type="reset" class="myButton" value="取消">
</form>
</body>
</html>
