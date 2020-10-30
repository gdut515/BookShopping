<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/29
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册成功</title>
</head>
<body>
<h1>普通用户 注册成功!</h1>
注册成功！
<%
    response.setHeader("refresh", "3;URL=/toLogin");
%>

</body>
</html>
