<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 10.10.2018
  Time: 12:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manufacturers</title>
    <link href="/resources/style.css" rel="stylesheet">
</head>
<div class="myStyle">hello</div>
    <body>
    <c:forEach items="${manufacturers}" var="manufacturer">
        ${manufacturer.id}   <a
            href="/manufacturer/${manufacturer.id}"> ${manufacturer.name} </a>${manufacturer.country}</a> <br>
    </c:forEach>
    </body>

</html>
