<%@ page import="net.gdut.bean.TbBook" %>
<%@ page import="java.util.List" %>
<%@ page import="net.gdut.bean.TbUser" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<body>
<head>
    <title>用户-书城</title>
</head>


<%
    int i;
    List<TbBook> books = (List<TbBook>) request.getAttribute("books");
    int count = books.size();
    TbBook[] tbBooks = new TbBook[count];
    String[] names = new String[count];
    books.toArray(tbBooks);

    for (i=0;i<count;i++) {
        names[i] = tbBooks[i].getBname();
    }
%>
<form action="addorder" method="post">
    <div class="box b1">
        <h3>书籍</h3>
        <ul>
            <%
                if (count >= 1){
            %>
            <li>
                1<a href=""><%=names[0]%></a>
                <input type="checkbox" name="bno" value="<%=tbBooks[0].getBno()%>">
            </li>
            <%
                }
                if (count >= 2){
            %>
            <li>
                2<a href=""><%=names[1]%></a>
                <input type="checkbox" name="bno" value="<%=tbBooks[1].getBno()%>">
            </li>
            <%
                }
                if (count >= 3){
            %>
            <li>
                3<a href=""><%=names[2]%></a>
                <input type="checkbox" name="bno" value="<%=tbBooks[2].getBno()%>">
            </li>
            <%
                }
                if (count >= 4){
            %>
            <li>
                4<a href=""><%=names[3]%></a>
                <input type="checkbox" name="bno" value="<%=tbBooks[3].getBno()%>">
            </li>
            <%
                }
            %>
        </ul>
    </div>
    <div>
        <h3>
            <input type="submit" name="submit" value="购买">
            <input type="reset" name="reset" value="重置"><br/>
        </h3>
    </div>
</form>
<div class="srsearch-result-pagination">
    <div class="csdn-pagination hide-set" >
    <span class="page-nav">
        <a href="?page=0"
           page_num="1"
           class="btn btn-xs btn-default active checklogin">
            1
        </a><br>
        <a href="?page=<%=count%>"
           page_num="2"
           class="btn btn-xs btn-default checklogin">
            2
        </a><br>
    </span>
    </div>
</div>

</body>
</html>




