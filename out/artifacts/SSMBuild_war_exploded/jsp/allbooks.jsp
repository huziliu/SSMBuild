<%@ page import="java.util.List" %>
<%@ page import="zuel.huziliu.pojo.Books" %><%--
  Created by IntelliJ IDEA.
  User: 72493
  Date: 2020/11/13
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书籍展示</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12" clomun>
            <div class="page-header">
                <h1>
                    <small>书籍列表 ---------- 显示所有书籍</small>
                </h1>
            </div>
        </div>
    </div>


    <div class="row">
        <div class="col-md-4 column">
            <a class="btn btn-primary" href="/book/to_addbook">添加书籍</a>
            <a class="btn btn-primary" href="/book/allbooks">显示所有书籍</a>
        </div>
        <div class="col-md-8 column">
            <div class="col-md-4 column"></div>
            <form action="/book/search" method="post" style="float: right" class="form-inline" >
                <input class="form-control" name="queryBookName" placeholder="请输入要查询的书籍名称">
                <input type="submit" class="btn btn-primary" value="查询">
            </form>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12" column>
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>书籍编号</th>
                    <th>书籍名称</th>
                    <th>书籍数量</th>
                    <th>书籍详情</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <%
                    List<Books> books = (List<Books>) request.getAttribute("books");
                    for (Books book : books) {
                %>
                <tr>
                    <td><%=book.getBookID()%>
                    </td>
                    <td><%=book.getBookName()%>
                    </td>
                    <td><%=book.getBookCounts()%>
                    </td>
                    <td><%=book.getDetail()%>
                    </td>
                    <td>
                        <a href="/book/to_updatebook/<%=book.getBookID()%>">修改</a>
                        &nbsp; | &nbsp;
                        <a href="/book/delete/<%=book.getBookID()%>">删除</a>
                    </td>
                </tr>
                <%
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>

</div>


</body>
</html>
