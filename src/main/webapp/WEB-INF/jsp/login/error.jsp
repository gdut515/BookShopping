<%--
  Created by IntelliJ IDEA.
  User: 53084
  Date: 2020/7/28
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录失败</title>
</head>
<body>
<h1>
    密码错误或者用户不存在
</h1>
<%
    response.setHeader("refresh", "3;URL=/");
%>
<font color="black" size="5">
    <br> 3秒后将跳转到主页面 <br> <br> 如果没有跳转,请按 <a href="/">这里</a>!!!<br>
</font>
</body>
</html>
