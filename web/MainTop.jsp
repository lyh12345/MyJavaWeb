<%--
  Created by IntelliJ IDEA.
  User: lh
  Date: 2017/4/2
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="css/magic.css">
<link rel="stylesheet" type="text/css" href="css/mycss.css">
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="model.Term" %>
<html>
<head>
    <title>学期</title>
</head>
<body>

<%
    List<Term> terms = (ArrayList) session.getAttribute("terms");
    Iterator<Term> iterator2 = terms.iterator();
    Term term = null;
    String currentTerm = (String) session.getAttribute("currentTerm");
%>

<form action="changeTermServlet" method="post" target="ifram2">
    学期:<select name="term" size="1">
    <%
        while (iterator2.hasNext()) {
            term = iterator2.next();
    %>
    <option value=<%=term.getTerm()%>><%=term.getTerm()%>
    </option>
    <%
        }
    %>
</select>
    <input type="submit" class="myButton" value="确定修改">
</form>

</body>
</html>
