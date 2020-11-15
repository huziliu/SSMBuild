<%--
  Created by IntelliJ IDEA.
  User: 72493
  Date: 2020/11/14
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新书籍</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12" clomun>
            <div class="page-header">
                <h1>
                    <small>书籍列表 ---------- 修改书籍</small>
                </h1>
            </div>
        </div>
    </div>


    <form action="/book/update" method="post">
        <%--使用隐藏域--%>
        <input type="hidden" name="bookID" value="${book.bookID}">
        <div class="form-group">
            <label for="book_name">书籍名称:</label>
            <input type="text" class="form-control" id="book_name" name="bookName" value="${book.bookName}" required>
        </div>
        <div class="form-group">
            <label for="book_count">书籍数量:</label>
            <input type="text" class="form-control" id="book_count" name="bookCounts" value="${book.bookCounts}" required>
        </div>
        <div class="form-group">
            <label for="book_detail">书籍描述:</label>
            <input type="text" class="form-control" id="book_detail" name="detail" value="${book.detail}" required>
        </div>
        <div class="form-group">
            <input type="submit" class="form-control" value="修改">
        </div>
    </form>




</div>



</body>
</html>
