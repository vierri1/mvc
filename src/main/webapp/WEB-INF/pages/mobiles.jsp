<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 10.10.2018
  Time: 12:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mobiles</title>
</head>
<body>
<c:forEach items="${mobiles}" var="mobile">
    ${mobile.id} ${mobile.manufacturer.name} ${mobile.model} ${mobile.price} <br>
</c:forEach>

<form action="/addMobile" method="post">
    <label>Название <input type="text" name="name"></label>
    <label>Цена <input type="text" name="price"></label>
    <input type="hidden" name="id" value="${manId}">
    <input type="submit"/>
</form>

</body>
</html>
