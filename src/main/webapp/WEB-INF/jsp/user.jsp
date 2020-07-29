<%@ page import="net.gdut.bean.TbBook" %>
<%@ page import="java.util.List" %>
<%--Created by IntelliJ IDEA.
User: Administrator
Date: 2020/7/28
Time: 15:12
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<body>
<%
    List<TbBook> books = (List<TbBook>) request.getAttribute("books");
    for (TbBook book:books){
        out.println(book+"<br/>");
    }
%>

</body>
</html> <scope>provided</scope>