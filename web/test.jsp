<%--
  Created by IntelliJ IDEA.
  User: lh
  Date: 2017/3/31
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test</title>
</head>
<link rel="stylesheet" type="text/css" href="css/mycss.css">
<link rel="stylesheet" type="text/css" href="css/magic.css">
<body>
<form action="" method="post" class="STYLE-NAME">
    <h1>Contact Form
        <span>Please fill all the texts in the fields.</span>
    </h1>
    <label>
        <span>Your Name :</span>
        <input id="name" type="text" name="name" placeholder="Your Full Name" />
    </label>
    <label>
        <span>Your Email :</span>
        <input id="email" type="email" name="email" placeholder="Valid Email Address" />
    </label>
    <label>
        <span>Message :</span>
        <textarea id="message" name="message" placeholder="Your Message to Us"></textarea>
    </label>
    <label>
        <span>Subject :</span><select name="selection">
        <option value="Job Inquiry">Job Inquiry</option>
        <option value="General Question">General Question</option>
    </select>
    </label>
    <label>
        <span>&nbsp;</span>
        <input type="button" class="button" value="Send" />
    </label>
</form>

</body>
</html>
