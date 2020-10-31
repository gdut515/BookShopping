<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../commons/nav.jsp"%>
<%@ page isELIgnored="false" %>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Main content -->
    <section class="content">
        <shiro:user>
            <div class="box box-info">
                <div class="box-body" style="display: block;">
                    <div class="table-responsive">
                        <table class="table no-margin">
                            <thead>
                            <tr>
                                <th>订单号</th>
                                <th>总价</th>
                                <th>订单时间</th>
                                <th>状态</th>
                                <th>地址</th>>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="order" items="${orders}">
                                <tr>
                                    <td>${order.ono}</td>
                                    <td>${order.cost}</td>
                                    <td>${order.time}</td>
                                    <td>未支付</td>
                                    <td>${order.address}</td>
                                    <td>
                                        <shiro:hasAnyRoles name="user">
                                            <a type="button" class="btn btn-danger"
                                               href="/order/openOrder?ono=${order.ono}&pageNo=1">查看订单</a>
                                        </shiro:hasAnyRoles>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </shiro:user>
    </section>
</div>
<%@include file="../commons/tail.jsp"%>
<script>
</script>
</body>
</html>
