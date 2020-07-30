<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../commons/nav.jsp"%>

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
                                <th>书本作者</th>
                                <th>封面</th>
                                <th>序号</th>
                                <th>书名</th>
                                <th>价格</th>
                                <th>描述</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="book" items="${books}">
                                <tr>
                                    <td>${book.author}</td>
                                    <td>
                                        <img src="<%=request.getContextPath()%>/img/${book.cover}"
                                             style="width: 60px;height: 60px;"
                                             onclick='showimage("<%=request.getContextPath()%>/img/${book.cover}")'/>
                                    </td>
                                    <td>${book.bno}</td>
                                    <td>${book.bname}</td>
                                    <td>${book.price}</td>
                                    <td>${book.description}</td>
                                    <td>
                                        <shiro:hasAnyRoles name="admin">
                                            <a type="button" class="btn btn-danger"
                                               href="/admin/deleteBook/${book.bno}">下架该书籍</a>
                                        </shiro:hasAnyRoles>
                                        <shiro:hasAnyRoles name="user">
                                            <a type="button" class="btn btn-danger"
                                               href="/cart/add/${book.bno}">购买该书籍</a>
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
</body>
</html>
