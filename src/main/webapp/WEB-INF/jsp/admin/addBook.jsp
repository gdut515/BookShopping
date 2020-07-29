<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../commons/head.jsp"%>
<body class="hold-transition skin-blue sidebar-mini">
<div class="login-box">
    <div class="login-logo">
        <b>欢迎来到添加图书页面</b>
    </div>

    <div id="empAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title" id="myModalLabel">书籍添加</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" action="/admin/book/addBook">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">author</label>
                            <div class="col-sm-10">
                                <input type="text" name="author" class="form-control" placeholder="请输入作者名">
                                <span class="help-block"></span>
                            </div>
                        </div>
                        <input type="hidden" name="cover" class="form-control" value="1.jpg">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">bookName</label>
                            <div class="col-sm-10">
                                <input type="text" name="bname" class="form-control" placeholder="请输入书籍名">
                                <span class="help-block"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">description</label>
                            <div class="col-sm-10">
                                <input type="text" name="description" class="form-control" placeholder="请输入描述">
                                <span class="help-block"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">price</label>
                            <div class="col-sm-10">
                                <input type="text" name="price" class="form-control" placeholder="请输入单价">
                                <span class="help-block"></span>
                            </div>
                        </div>
                        <input type="submit" value="Submit" />
                    </form>
                    <form action="/admin/book/getAllBook" method="post">
                        <input type="submit" value="返回" />
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="<%=request.getContextPath()%>/js/jquery-2.2.3.min.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<script type="text/javascript">

</script>
</body>


</html>
