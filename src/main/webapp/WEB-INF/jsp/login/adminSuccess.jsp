<%--
  Created by IntelliJ IDEA.
  User: 53084
  Date: 2020/7/28
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功</title>
</head>
<body>
<h1>管理员身份 登录成功!</h1>
<%
    response.setHeader("refresh", "5;URL=/admin");
%>
<font color="black" size="5">
    <br> 5秒后将跳转到主页面 <br> <br> 如果没有跳转,请按 <a href="/admin">这里</a>!!!<br>
</font>
</body>
</html>
