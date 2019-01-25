<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<h3>Users</h3>
<a href="${pageContext.request.contextPath}/user/add">DODAJ</a>
<c:forEach items="${users}" var="user">
    <ul>
        <li>${user.firstName} ${user.lastName}
            <a href="${pageContext.request.contextPath}/user/add/${user.id}">EDYTUJ</a>&nbsp;&nbsp;
            <a href="${pageContext.request.contextPath}/user/delete/${user.id}">SKASUJ</a>
        </li>
    </ul>
</c:forEach>
</body>
</html>