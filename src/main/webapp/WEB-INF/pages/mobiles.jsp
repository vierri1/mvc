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
<a href="/static/j_spring_security_logout">logout</a><br>

<c:forEach items="${mobiles}" var="mobile">
    ${mobile.id} ${mobile.manufacturer.name} ${mobile.model} ${mobile.price} <br>
</c:forEach>

<a href="../admin/addMobile/${manId}">Добавить</a>

</body>
</html>
