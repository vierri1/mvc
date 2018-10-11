<%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 11.10.2018
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form action="/j_spring_security_check" method="post">
        <input type="text" name="j_username" required>
        <input type="password" name="j_password" required>
        <button type="submit">Вход</button>
    </form>
</body>
</html>
