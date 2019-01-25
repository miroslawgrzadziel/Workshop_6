<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tweet form</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <style>
        input, select{
            display: block;
            margin:15px 0;
            width: 100%;
        }
    </style>
</head>
<body>

<form:form method="post" action="${formAction}" modelAttribute="tweet" cssClass="container col-6">
    <%--<form:errors path="*"/>--%>

    <form:hidden path="id"/>

    <form:input path="title" placeholder="Title" cssClass="form-input"/>
    <form:errors path="title" cssClass="alert alert-danger" element="div"/>

    <form:textarea path="tweetText" cols="12" rows="3" cssClass="form-input"/>
    <form:errors path="tweetText" cssClass="alert alert-danger" element="div"/>

    <form:input path="created" value="${tweet.created}" placeholder="Created" cssClass="form-input"/>
    <form:errors path="created" cssClass="alert alert-danger" element="div"/>

    <form:select path="user" cssClass="select-input">
        <form:option value="0" label="Choose one" selected="true" disabled="true"/>
        <form:options items="${users}" itemValue="id" itemLabel="lastName"/>
    </form:select>
    <form:errors path="user" cssClass="alert alert-danger" element="div"/>

    <input type = "submit" class="btn btn-success"/>
</form:form>

</body>
</html>