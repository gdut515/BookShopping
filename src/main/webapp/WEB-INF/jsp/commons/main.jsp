<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="nav.jsp"%>
<%@ page isELIgnored="false" %>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">

    <shiro:user>
    <form action="<%=request.getContextPath()%>/main/checkBook" method="post">
        <input type="text" placeholder="请填写书籍名或作者名" name="bookName">
        <input type="submit" class="btn btn-danger" value="查询书籍">
    </form>
    </shiro:user>

    <shiro:user>
        <div class="box box-info">
            <div class="box-body" style="display: block;">
                <div class="table-responsive">
                    <table class="table no-margin">
                        <thead>
                        <tr>
                            <th>序号</th>
                            <th>书名</th>
                            <th>作者</th>
                            <th>封面</th>
                            <th>价格</th>
                            <th>描述</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="book" items="${books}">
                            <tr>
                                <td>${book.bno}</td>
                                <td>${book.bname}</td>
                                <td>${book.author}</td>
                                <td>
                                    <img src="<%=request.getContextPath()%>/img/${book.cover}"
                                         style="width: 60px;height: 60px;"
                                         onclick='showimage("<%=request.getContextPath()%>/img/${book.cover}")'/>
                                </td>
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

<!--分页-->
<div class="container">
    <nav class="text-center">
        <ul class="pagination text-center">
            <li><a href="<%=request.getContextPath()%>/main/toIndex?pageNo=1"><span>首页</span> </a></li>
            <li>
                <a href="<%=request.getContextPath()%>/main/toIndex?pageNo=${(pageInfo.pageNum>1)?(pageInfo.pageNum-1):1}">上一页</a>
            </li>
            <li>
                <a href="<%=request.getContextPath()%>/main/toIndex?pageNo=${(pageInfo.pageNum<pageInfo.pages)?(pageInfo.pageNum+1):pageInfo.pages}">下一页</a>
            </li>
            <li><a href="<%=request.getContextPath()%>/main/toIndex?pageNo=${pageInfo.pages}"> <span>末页»</span></a>
            </li>
            <li class="pagespan">11/12</li>
        </ul>
    </nav>
</div>
</div>
<jsp:include page="tail.jsp"/>


        <script>
        function showChoose() {
        $("#chooseType").show();
        locationChange();
        }

        function showimage(source) {
        $("#imgInModalID").attr("src", source);
        $('.modal').show();
        }

        function closeModel() {
        $('.modal').hide();
        }

        function locationChange() {
        var type = "";
        var obj = document.getElementById('typeList');
        obj.options.length = 0;
        $.ajax({
        type: "post",
        url: "/book/getParentTypeList",
        cache: false,
        data: {type: type},
        dataType: "json",
        success: function (result) {
        if (result.length > 0) {
        for (var i in result) {
        var selectOption = new Option(result[i].name, result[i].cId);
        obj.add(selectOption);
        }
        }
        }
        });
        }
        </script>

</body>
</html>