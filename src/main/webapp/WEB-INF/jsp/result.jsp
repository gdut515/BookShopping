<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/26
  Time: 0:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册成功</title>
</head>
<body>
<h1>注册成功!</h1>
<%
    response.setHeader("refresh", "3;URL=");
%>
<font color="black" size="5">
    <br> 3秒后将跳转到登录主页 <br> <br> 如果没有跳转,请按 <a href="">这里</a>!!!<br>
</font>
</body>
</html>