
<%--@elvariable id="username" type="java.lang.String"--%>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2/12/2018
  Time: 1:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
</head>
<body>

    <c:if test="${username != null}">
        <h2>Wellcome ${username}</h2>
    </c:if>
    <c:if test="${username == null}">
        <h2 style="color:red">You are not logged in</h2>
    </c:if>

</body>
</html>
