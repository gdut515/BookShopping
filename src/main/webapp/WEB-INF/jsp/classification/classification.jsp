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
                                <th>分类名</th>
                                <th>条目名</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="item" items="${categoryItems}">
                                <tr>
                                    <td>书籍分类</td>
                                    <td>${item.name}</td>
                                    <td>
                                        <shiro:hasAnyRoles name="admin">
                                            <a type="button" class="btn btn-danger"
                                               href="delete?classification=1&no=${item.no}">删除条目</a>
                                        </shiro:hasAnyRoles>
                                    </td>
                                </tr>
                            </c:forEach>
                            <c:forEach var="item" items="${publisherItems}">
                                <tr>
                                    <td>出版商分类</td>
                                    <td>${item.name}</td>
                                    <td>
                                        <shiro:hasAnyRoles name="admin">
                                            <a type="button" class="btn btn-danger"
                                               href="delete?classification=2&no=${item.no}">删除条目</a>
                                        </shiro:hasAnyRoles>
                                    </td>
                                </tr>
                            </c:forEach>
                            <c:forEach var="item" items="${ageItems}">
                                <tr>
                                    <td>年龄分类</td>
                                    <td>${item.name}</td>
                                    <td>
                                        <shiro:hasAnyRoles name="admin">
                                            <a type="button" class="btn btn-danger"
                                               href="delete?classification=3&no=${item.no}">删除条目</a>
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
