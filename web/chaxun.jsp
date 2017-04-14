<%@ page import="java.util.List" %>
<%@ page import="base.mstudent" %><%--
  Created by IntelliJ IDEA.
  User: MR.zhang
  Date: 2017/4/8
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="css/mycss.css">
<html>
<head>
</head>
<body>
查询
<form action="inclass" method="post">
    <select name="sem">
        <% List<String> list1= (List<String>) session.getAttribute("xueqi");
           for(int i=0;i<list1.size();i++)
           {
               %>
               <option value="<%=list1.get(i)%>"><%=list1.get(i)%></option>
               <%
           }
        %>
    </select>
    <select name="keming">
        <% List<String> list2= (List<String>) session.getAttribute("kecheng");
            for(int j=0;j<list2.size();j++)
            {
        %>
        <option value=<%=list2.get(j)%>><%=list2.get(j)%></option>
        <%
            }
        %>
    </select>
    <input type="submit"class="myButton" value="确定">

</form>
<table class="tables">
    <caption>学生表</caption>
    <tr>
        <th>学生姓名</th>
        <th>学生学号</th>
        <th>平时成绩</th>
        <th>考试成绩</th>
        <th>总评成绩</th>
    </tr>
<% List<mstudent> list3= (List<mstudent>) session.getAttribute("instudent");
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
        <td><%=list3.get(i).getPscj()%></td>
        <td><%=list3.get(i).getKscj()%></td>
        <td><%=list3.get(i).getZpcj()%></td>
    </tr>
    <%
    }
}

%>
</table>
</body>
</html>
