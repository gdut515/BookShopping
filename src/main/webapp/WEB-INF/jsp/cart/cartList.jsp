<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../commons/nav.jsp"%>
<%@ page isELIgnored="false" %>

    <div class="content-wrapper">
        <!-- Main content -->
        <section class="content">
            <div class="box box-info">
                <div class="box-body" style="display: block;">
                    <div class="table-responsive">
                        <table class="table no-margin">
                            <thead>
                            <tr>
                                <th>书本作者</th>
                                <th>封面</th>
                                <th>书名</th>
                                <th>价格</th>
                                <th>购买数量</th>
                                <th>商品总价</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:set var="totalPrice" value="0"></c:set>
                            <c:forEach var="cart" items="${cartList}">
                                <c:set var="totalPrice" value="${ totalPrice + (cart.price * cart.quantity)}"/>
                                <tr>
                                    <td>${cart.author}</td>
                                    <td><img src="<%=request.getContextPath()%>/img/${cart.book_image}"
                                             style="width: 60px;height: 60px;"
                                             onclick='showimage("<%=request.getContextPath()%>/img/${cart.book_image}")'/>
                                    </td>
                                    <td>${cart.book_name}</td>
                                    <td>${cart.price}</td>
                                    <td>${cart.quantity}</td>
                                    <td>${cart.price*cart.quantity}</td>
                                    <td>
                                        <a type="button" class="btn btn-danger"
                                           href="<%=request.getContextPath()%>/cart/delete/${cart.id}">删除</a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div>
                        <h2>总价：¥<fmt:formatNumber value="${totalPrice}" maxFractionDigits="2" minFractionDigits="2"
                                                  groupingUsed="true"/></h2>
                        <a type="button" class="btn btn-danger"
                           href="<%=request.getContextPath()%>/order/toindex">去结算</a>
                    </div>
                </div>
            </div>
        </section>
    </div>
</div>
<%@include file="../commons/tail.jsp"%>
<script>
</script>
</body>
</html>
