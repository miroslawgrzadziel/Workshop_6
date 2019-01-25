<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form</title>
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
<form:form method="post" action="/user/save" modelAttribute="user" cssClass="container col-6">
    <form:hidden path="id"/>
    <%--<form:errors path="*"/>--%>

    <form:input path="firstName" placeholder="First Name" cssClass="form-input"/>
    <form:errors path="firstName" cssClass="alert alert-danger" element="div"/>

    <form:input path="lastName" placeholder="Last Name" cssClass="form-input"/>
    <form:errors path="lastName" cssClass="alert alert-danger" element="div"/>

    <form:input path="email" placeholder="eMail" cssClass="form-input"/>
    <form:errors path="email" cssClass="alert alert-danger" element="div"/>

    <input type = "submit" class="btn btn-success"/>
</form:form>
</body>
</html>