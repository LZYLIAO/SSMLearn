<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2022-09-15
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/quick21" method="post" enctype="multipart/form-data">
        <input type="text" name="username">
        <input type="file" name="uploadFile">
        <input type="submit" value="提交">
    </form>

    <form action="${pageContext.request.contextPath}/quick22" method="post" enctype="multipart/form-data">
        <input type="text" name="username">
        <input type="file" name="multipartFiles">
        <input type="file" name="multipartFiles">
        <input type="file" name="multipartFiles">
        <input type="submit" value="提交">
    </form>

    <form action="${pageContext.request.contextPath}/quick23" method="post" enctype="multipart/form-data">
        <input type="text" name="username">
        <input type="file" name="multipartFile1">
        <input type="file" name="multipartFile2">
        <input type="submit" value="提交">
    </form>

</body>
</html>
