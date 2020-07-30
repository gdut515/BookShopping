<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/27
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
</head>
<body>
<h1 align="center">注册</h1>
<form action="/addUser" method="post" align="center">
    姓名：<input type="text" name="uname" size="20" value="" maxlength="20"><br/>
    密码：<input type="password" name="password" size="20" value="" maxlength="20"><br/><br/>
    <input type="submit" name="submit" value="注册">
</form>
</body>
</html>
