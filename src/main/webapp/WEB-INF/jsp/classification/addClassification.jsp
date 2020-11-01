<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../commons/head.jsp"%>
<body class="hold-transition skin-blue sidebar-mini">
<div class="login-box">
    <div class="login-logo">
        <b>欢迎来到添加分类条目页面</b>
    </div>
    <div id="empAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title" id="myModalLabel">分类条目添加</h4>
                </div>

                <div class="modal-body">
                    <form class="form-horizontal" action="/classification/add">
                        <select name="no">
                            <option value="1">书籍分类</option>
                            <option value="2">出版商分类</option>
                            <option value="3">年龄分类</option>
                        </select>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">author</label>
                            <div class="col-sm-10">
                                <input type="text" name="name" class="form-control" placeholder="请输入条目名">
                                <span class="help-block"></span>
                            </div>
                        </div>
                        <input type="submit" value="确定新增条目" />
                    </form>
                    <form action="/main/toMain" method="get">
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
