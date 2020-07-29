<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <span class="logo-lg">移动电子商务系统</span>
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
                        <a type="button" class="btn btn-info"
                           href="<%=request.getContextPath()%>/order/myOrder/${user.uId}">我的订单</a>
                        <a type="button" class="btn btn-info"
                           href="<%=request.getContextPath()%>/cart/cart">我的购物车</a>
                    <!-- User Account: -->
                        <li class="dropdown user user-menu">
                            <ul class="dropdown-menu">
                                <!-- User image -->
                                <!--Menu Body-->
                                <li class="user-body">
                                    <div class="col-xs-4 text-center">
                                        <a href="#">Followers</a>
                                    </div>
                                    <div class="col-xs-4 text-center">
                                        <a href="#">Sales</a>
                                    </div>
                                    <div class="col-xs-4 text-center">
                                        <a href="#">Friends</a>
                                    </div>
                                </li>
                                <!-- Menu Footer-->
                                <li class="user-footer">
                                    <div class="pull-left">
                                        <a id="systemsettingBtn" href="javascript:void(0)"
                                           class="btn btn-default btn-flat">修改密码</a>
                                    </div>
                                    <div class="pull-right">
                                        <a href="/user/logOut" class="btn btn-default btn-flat">注销</a>
                                    </div>
                                </li>
                            </ul>
                        </li>
                </ul>
            </div>
        </nav>
    </header>
    <aside class="main-sidebar">
        <section class="sidebar">
            <ul class="sidebar-menu">
                <li>
                    <a href="<%=request.getContextPath()%>/book/toindex">
                        <i class="fa fa-dashboard"></i> <span>首页</span>
                    </a>
                </li>
            </ul>
        </section>
        <!-- /.sidebar -->
    </aside>    <!-- Content Wrapper. Contains page content -->
</div>