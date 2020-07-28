<%--
  Created by IntelliJ IDEA.
  User: huhayi
  Date: 2020/7/28
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员主页</title>
</head>
<body>
<h1>管理书籍</h1>
<form action="/addBook" method="post">
    <table>
        <p>
            <input type="text" name="bname" placeholder="请输入书名">
        </p>
        <p>
            <input type="text" name="author" placeholder="请输入作者">
        </p>
        <p>
            <input type="text" name="cover" placeholder="请输入封面">
        </p>
        <p>
            <input type="number" name="price" placeholder="请输入价格">
        </p>
        <p>
            <input type="text" name="description" placeholder="请输入描述">
        </p>
        <p>
            <input type="submit" value="增加书籍">
        </p>
    </table>
</form>

<form action="/deleteBook" method="post">
    <table>
        <p>
            <input type="text" name="bname" placeholder="请输入书名">
        </p>
            <input type="submit" value="删除书籍">
        </p>
    </table>
</form>

</body>
</html>
