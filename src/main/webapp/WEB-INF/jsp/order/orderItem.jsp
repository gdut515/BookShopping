<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../commons/nav.jsp"%>
<%@ page isELIgnored="false" %>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">

    <shiro:user>
        <a type="button" class="btn btn-danger"
           href="/order/toOrder">返回订单列表</a>
    </shiro:user>

    <shiro:user>
        <div class="box box-info">
            <div class="box-body" style="display: block;">
                <div class="table-responsive">
                    <table class="table no-margin">
                        <thead>
                        <tr>
                            <th>书名</th>
                            <th>作者</th>
                            <th>书籍分类</th>
                            <th>出版商分类</th>
                            <th>年龄分类</th>
                            <th>封面</th>
                            <th>数量</th>
                            <th>单价</th>
                            <th>总价</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="item" items="${orderItems}">
                            <tr>
                                <td>${item.bname}</td>
                                <td>${item.author}</td>
                                <td>${item.categoryName}</td>
                                <td>${item.publisherName}</td>
                                <td>${item.ageName}</td>
                                <td>
                                    <img src="<%=request.getContextPath()%>/img/${item.cover}"
                                         style="width: 60px;height: 60px;"
                                         onclick='showimage("<%=request.getContextPath()%>/img/${item.cover}")'/>
                                </td>
                                <td>${item.quantity}</td>
                                <td>${item.price}</td>
                                <td>${item.cost}</td>>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </shiro:user>
    <%@include file="../commons/tail.jsp"%>
    <script>
    </script>
    </section>
</div>
