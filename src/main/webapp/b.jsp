<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2022-09-12
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
    <script>
        var userList=new Array();
        userList.push({username:"Li",userAge:23})
        userList.push({username:"Zhan",userAge:43})
        $.ajax({
           type:"POST",
            url:"${pageContext.request.contextPath}/quick14",
            data:JSON.stringify(userList),
            contentType:"application/json;charset=utf-8"

        });
    </script>
</head>
<body>

</body>
</html>
