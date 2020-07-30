<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../commons/nav.jsp"%>
<%@ page isELIgnored="false" %>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <form action="#" method="post">
        <input type="text" placeholder="请填写书籍名" name="bookName">
        <input type="submit" class="btn btn-danger" value="查询书籍">
    </form>
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
                                <a type="button" class="btn btn-danger"
                                   href="<%=request.getContextPath()%>/addorder?uno=${uno}&bno=${book.bno}">添加订单</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    </section>
</div>
<!--分页-->
<div class="container">
    <nav class="text-center">
        <ul class="pagination text-center">
            <li><a href="<%=request.getContextPath()%>/allbook?pageNo=1&uno=${uno}"><span>«首页</span> </a></li>
            <li>
                <a href="<%=request.getContextPath()%>/allbook?pageNo=${(pageInfo.pageNum>1)?(pageInfo.pageNum-1):1}&uno=${uno}">上一页</a>
            </li>
            <li>
                <a href="<%=request.getContextPath()%>/allbook?pageNo=${(pageInfo.pageNum<pageInfo.pages)?(pageInfo.pageNum+1):pageInfo.pages}&uno=${uno}">下一页</a>
            </li>
            <li><a href="<%=request.getContextPath()%>/allbook?pageNo=${pageInfo.pages}&uno=${uno}"> <span>末页»</span></a>
        </ul>
    </nav>
</div>
</div>
<jsp:include page="../commons/tail.jsp"/>

<script>

</script>

</body>
</html>
