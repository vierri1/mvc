<%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 11.10.2018
  Time: 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Addmobile</title>
</head>
<body>
<a href="/static/j_spring_security_logout">logout</a>

<form action="admin/addMobile" method="post">
    <label>Название <input type="text" name="name"></label>
    <label>Цена <input type="text" name="price"></label>
    <input type="hidden" name="id" value="${id}">
    <input type="submit"/>
</form>
</body>
</html>
