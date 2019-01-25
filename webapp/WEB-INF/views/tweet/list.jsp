<<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tweets</title>
</head>
<body>
<h3>Tweets</h3>
<a href="${pageContext.request.contextPath}/tweet/add">DODAJ</a>
<c:forEach items="${tweets}" var="tweet">
    <ul>
        <li>${tweet.title} ${tweet.tweetText} ${tweet.created}
            <a href="${pageContext.request.contextPath}/tweet/add/${tweet.id}">EDYTUJ</a>&nbsp;&nbsp;
            <a href="${pageContext.request.contextPath}/tweet/delete/${tweet.id}">SKASUJ</a>
        </li>
    </ul>
</c:forEach>
</body>
</html>