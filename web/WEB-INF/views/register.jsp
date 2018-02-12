<%--@elvariable id="username" type="java.lang.String"--%>
<%--@elvariable id="error" type="java.lang.String"--%>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2/12/2018
  Time: 12:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register page</title>
</head>
<body>
    <div style="color: red;">
        ${error}
    </div>

    <form method="POST">
        <div>Username:<input type="text" value="${username}" name="username" placeholder="Enter your username"></div>
        <div>Password: <input type="password" name="password" placeholder="Enter your password"></div>
        <input type="submit" value="Register">
    </form>

</body>
</html>
