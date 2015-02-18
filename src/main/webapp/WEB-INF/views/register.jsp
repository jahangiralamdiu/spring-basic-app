<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 18/02/2015
  Time: 04:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Registration Page</title>
</head>
<body>

<form:form commandName="user">

    <label>
        User Name
    </label>
    <form:input path="userName"/>
    <br/>
    <br/>
    <label>
        Full Name
    </label>
    <form:input path="fullName"/>
    <br/>
    <br/>
    <label>
        Mobile
    </label>
    <form:input path="mobile"/>
    <br/>
    <br/>
    <label>
        Email
    </label>
    <form:input path="email"/>
    <br/>
    <br/>
    <label>
        Address
    </label>
    <form:input path="address"/>
    <br/>
    <br/>
    <label>
        DOB
    </label>
    <form:input path="dateOfBirth"/>
    <br/>
    <br/>
    <input type="submit" class="btn" value="Register"/>
</form:form>

</body>
</html>
