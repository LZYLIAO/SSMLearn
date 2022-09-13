<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2022-09-11
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
        <h1>${pageContext.request.contextPath}</h1>
    <form action="${pageContext.request.contextPath}/quick13">
        <input type="text" name="userList[0].username">
        <input type="text" name="userList[0].userAge">
        <input type="text" name="userList[1].username">
        <input type="text" name="userList[1].userAge">
        <input type="submit" value="提交">
    </form>
</body>
</html>
