<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri='http://java.sun.com/jstl/core_rt' prefix='c' %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 19/02/2015
  Time: 05:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <c:choose>
        <c:when test="${user.imageString=='noimage'}">
            No Image
        </c:when>
        <c:otherwise>
            <img class="img-responsive" src="data:image/jpg;base64,${user.imageString}" alt="Image not found" height="40" width="40"/>
        </c:otherwise>
    </c:choose>
    <br/>
    <br/>
</form:form>
