<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/26
  Time: 0:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>hpm的主页</title>
</head>
<<<<<<< Updated upstream
<body>
<h1 align="center">欢迎来到我的主页！</h1><br>
<h2 align="center">
    <a href="regist">学生注册</a>
=======

<body class="hold-transition skin-blue sidebar-mini">
<div class="login-box">
    <div class="login-logo">
        <b>欢迎来到登陆界面</b>
    </div>
    <!-- /.login-logo -->
    <div class="login-box-body">
        <h2 class="login-box-msg">用户登录</h2>
        <h5>没有人比我更懂前端</h5>
        <form action="/login" method="post">
            <div class="form-group has-feedback">
                <label class="col-md-4 control-label">用户名</label>
                <input type="text" class="form-control" name="uname" placeholder="请输入用户名">
                <span class="glyphicon glyphicon-user form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <label class="col-md-4 control-label">密码</label>
                <input type="password" class="form-control" name="password" placeholder="请输入密码">
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>
            <div class="row">
                <div class="col-xs-8">
                </div>
                <!-- /.col -->
                <div class="col-xs-4">
                    <br/>
                    <a type="button" class="btn btn-primary btn-block btn-flat" href="/regist">注册</a>
                    <br/>
                    <button type="submit" class="btn btn-primary btn-block btn-flat">登录</button>
                </div>
            </div>
        </form>
    </div>
</div>
<script src="<%=request.getContextPath()%>/js/jquery-2.2.3.min.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>

<h2 align="center">
    <a href="allbook">书城</a>
>>>>>>> Stashed changes
</h2>
</body>
</html>
