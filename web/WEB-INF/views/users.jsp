<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2/12/2018
  Time: 5:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
    <table border="1">
        <thead>
        <tr>
            <th>Username</th>
        </tr>
        </thead>
        <tbody>
            <%--@elvariable id="users" type="java.util.List"--%>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
