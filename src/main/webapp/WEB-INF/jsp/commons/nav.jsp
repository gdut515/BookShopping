<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<jsp:include page="../commons/head.jsp"/>
<%--<!-- Site wrapper -->--%>
<div class="wrapper">
    <header class="main-header">
        <!- - Logo - ->
        <a href="" class="logo">
            <!-- mini logo for sidebar mini 50x50 pixels -->
            <span class="logo-mini">
     <img alt="" src="<%=request.getContextPath()%>/img/2.jpg" width="40px" height="40px">
  </span>
            <span class="logo-lg">电子书店系统</span>
        </a>
        <!- - Header Navbar - ->
        <nav class="navbar navbar-static-top" role="navigation">
            <!-- Sidebar toggle button-->
            <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
                <span class="sr-only">Toggle navigation</span>
            </a>
            <!-- Navbar Right Menu -->
            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                    <!-- User Account: -->
                        <li class="dropdown user user-menu">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <img src="<%=request.getContextPath()%>/img/2.jpg" class="user-image" alt="User Image">
                                <span class="hidden-xs">${user.uname}</span>
                            </a>
                            <ul class="dropdown-menu">
                                <!-- User image -->
                                <li class="user-header">
                                    <img id="user-header" src="<%=request.getContextPath()%>/img/2.jpg"
                                         class="img-circle"
                                         alt="User Image">
                                    <p>${user.uname}</p>
                                </li>
                                <!-- Menu Footer-->
                                <li class="user-footer">
                                    <div class="pull-right">
                                        <a href="/toLogin" class="btn btn-default btn-flat">注销</a>
                                    </div>
                                </li>
                            </ul>
                        </li>
                </ul>
            </div>
        </nav>
    </header>
    <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
            <!-- Sidebar user panel -->
            <!-- sidebar menu: : style can be found in sidebar.less -->
            <ul class="sidebar-menu">
                    <shiro:authenticated>
                    <li>
                        <a href="<%=request.getContextPath()%>/main/toMain">
                            <i class="fa fa-dashboard"></i> <span>主页</span>
                        </a>
                    </li>
                    </shiro:authenticated>
                    <shiro:hasAnyRoles name="user">
                    <li>
                        <a href="<%=request.getContextPath()%>/main/toCart">
                            <i class="fa fa-dashboard"></i> <span>购物车</span>
                        </a>
                    </li>
                    </shiro:hasAnyRoles>
                    <shiro:hasAnyRoles name="user">
                    <li>
                        <a href="<%=request.getContextPath()%>/order/toOrder?uno=${user.uno}">
                            <i class="fa fa-dashboard"></i> <span>订单</span>
                        </a>
                    </li>
                    </shiro:hasAnyRoles>
                    <shiro:hasAnyRoles name="admin">
                    <li>
                        <a href="<%=request.getContextPath()%>/addBook/toAddBook">
                            <i class="fa fa-dashboard"></i> <span>添加书籍</span>
                        </a>
                    </li>
                    </shiro:hasAnyRoles>
                    <shiro:hasAnyRoles name="admin">
                    <li>
                        <a href="<%=request.getContextPath()%>/todo">
                            <i class="fa fa-dashboard"></i> <span>用户管理</span>
                        </a>
                    </li>
                    </shiro:hasAnyRoles>
                    <shiro:hasAnyRoles name="admin">
                    <li>
                        <a href="<%=request.getContextPath()%>/classification/addClassification">
                            <i class="fa fa-dashboard"></i> <span>添加分类</span>
                        </a>
                    </li>
                    </shiro:hasAnyRoles>
                    <shiro:hasAnyRoles name="admin">
                    <li>
                        <a href="<%=request.getContextPath()%>/classification/toClassification">
                            <i class="fa fa-dashboard"></i> <span>分类</span>
                        </a>
                    </li>
                    </shiro:hasAnyRoles>
            </ul>
        </section>
        <!-- /.sidebar -->
    </aside>    <!-- Content Wrapper. Contains page content -->
