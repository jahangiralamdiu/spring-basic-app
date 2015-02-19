<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 19/02/2015
  Time: 05:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form:form commandName="user">

    <label>
        User Name
    </label>
    <form:input path="userName"/>
    <form:errors path="userName" cssClass="errors"/>
    <br/>
    <br/>
    <label>
        Full Name
    </label>
    <form:input path="fullName"/>
    <form:errors path="fullName" cssClass="errors"/>
    <br/>
    <br/>
    <label>
        Mobile
    </label>
    <form:input path="mobile"/>
    <form:errors path="mobile" cssClass="errors"/>
    <br/>
    <br/>
    <label>
        Email
    </label>
    <form:input path="email"/>
    <form:errors path="email" cssClass="errors"/>
    <br/>
    <br/>
    <label>
        Address
    </label>
    <form:input path="address"/>
    <form:errors path="address" cssClass="errors"/>
    <br/>
    <br/>
    <label>
        DOB
    </label>
    <form:input path="dateOfBirth"/>
    <form:errors path="dateOfBirth" cssClass="errors"/>
    <br/>
    <br/>
</form:form>
</body>
</html>
