
<%--  Created by IntelliJ IDEA.--%>
<%--  User: Administrator--%>
<%--  Date: 2020/7/28--%>
<%--  Time: 15:12--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>

<%--<body>--%>
<%--<%--%>
<%--    List<TbBook> books = (List<TbBook>) request.getAttribute("books");--%>
<%--    for (TbBook book:books){--%>
<%--        out.println(book+"<br/>");--%>
<%--    }--%>
<%--%>--%>

<%--</body>--%>
<%--</html>--%>




<%@ page import="net.gdut.bean.TbBook" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%--<%@ include file="commons/nav.jsp" %>--%>
<jsp:include page="commons/usernav.jsp"/>
<!-- Content Wrapper. Contains page content -->
<html>
<head>
    <title>用户界面-书城</title>
</head>
</body>
<div class="content-wrapper">
    <!-- Main content -->
    <section class="content">
        <form action="<%=request.getContextPath()%>/book/checkBook" method="post">
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
                            <th>书名</th>
                            <th>价格</th>
                            <th>描述</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <c:forEach var="book" items="${books}">
                            <tr>
                                <td>${book.author}</td>
                                <td><img src="<%=request.getContextPath()%>/${book.cover}"
                                         style="width: 45px;height: 80px;"
                                         onclick='showimage("<%=request.getContextPath()%>/${book.cover}")'/>
                                </td>
                                <td>${book.bname}</td>
                                <td>${book.price}</td>

                                <td>${book.description}</td>
                                <td>
                                    <a type="button" class="btn btn-danger" id="addCart"
<%--                                       action还没写好，应该有后台管理存储当前用户的id，然后action到那个页面跳转添加--%>
                                       href="<%=request.getContextPath()%>/addorder/${book.bno}">加入购物车</a>
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
            <li><a href="<%=request.getContextPath()%>/book/${url}?pageNo=1"><span>«首页</span> </a></li>
            <li>
                <a href="<%=request.getContextPath()%>/book/${url}?pageNo=${(pageInfo.pageNum>1)?(pageInfo.pageNum-1):1}">上一页</a>
            </li>
            <li>
                <a href="<%=request.getContextPath()%>/book/${url}?pageNo=${(pageInfo.pageNum<pageInfo.pages)?(pageInfo.pageNum+1):pageInfo.pages}">下一页</a>
            </li>
            <li><a href="<%=request.getContextPath()%>/book/${url}?pageNo=${pageInfo.pages}"> <span>末页»</span></a>
            </li>
        </ul>
    </nav>
</div>
</div>
<jsp:include page="commons/tail.jsp"/>



<%--<script>--%>
<%--    function showChoose() {--%>
<%--        $("#chooseType").show();--%>
<%--        locationChange();--%>
<%--    }--%>
<%--    function showimage(source) {--%>
<%--        $("#imgInModalID").attr("src", source);--%>
<%--        $('.modal').show();--%>
<%--    }--%>
<%--    function closeModel() {--%>
<%--        $('.modal').hide();--%>
<%--    }--%>
<%--    function locationChange() {--%>
<%--        var type = "";--%>
<%--        var obj = document.getElementById('typeList');--%>
<%--        obj.options.length = 0;--%>
<%--        $.ajax({--%>
<%--            type: "post",--%>
<%--            url: "/book/getParentTypeList",--%>
<%--            cache: false,--%>
<%--            data: {type: type},--%>
<%--            dataType: "json",--%>
<%--            success: function (result) {--%>
<%--                if (result.length > 0) {--%>
<%--                    for (var i in result) {--%>
<%--                        var selectOption = new Option(result[i].name, result[i].cId);--%>
<%--                        obj.add(selectOption);--%>
<%--                    }--%>
<%--                }--%>
<%--            }--%>
<%--        });--%>
<%--    }--%>
<%--</script>--%>
</body>
</html>