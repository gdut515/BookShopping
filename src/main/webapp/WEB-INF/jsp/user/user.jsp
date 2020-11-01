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
                                <th>账号名</th>
                                <th>身份</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="item" items="${users}">
                                <tr>
                                    <td>${item.uname}</td>
                                    <td>${item.authority}</td>
                                    <td>
                                        <shiro:hasAnyRoles name="admin">
                                            <a type="button" class="btn btn-danger"
                                               href="/user/delete?uno=${item.uno}">删除用户</a>
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
</body>
</html>
