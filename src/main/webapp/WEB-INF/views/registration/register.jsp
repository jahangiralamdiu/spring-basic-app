<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 18/02/2015
  Time: 04:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:form commandName="user" enctype="multipart/form-data" class="navbar-form navbar-left">
    <div class="form-group">
    <div class="row">
    <div class="col-md-4 col-md-offset-2">
        <label>
            User Name
        </label>
    </div>
    <div class="col-md-4">
        <form:input path="userName"/>
        <form:errors path="userName" cssClass="errors"/>
    </div>
    </div>
        <br/>
    <div class="row">
    <div class="col-md-4 col-md-offset-2">

        <label>
            New Password
        </label>
    </div>

    <div class="col-md-4">
        <form:password path="password"/>
        <form:errors path="password" cssClass="errors"/>
    </div>
    </div>
        <br/>

    <div class="row">
    <div class="col-md-4 col-md-offset-2">
        <label>
            Full Name
        </label>
    </div>

    <div class="col-md-4">
        <form:input path="fullName"/>
        <form:errors path="fullName" cssClass="errors"/>
    </div>
    </div>
        <br/>
    <div class="row">
    <div class="col-md-4 col-md-offset-2">
        <label>
            Mobile
        </label>
    </div>
    <div class="col-md-4">
        <form:input path="mobile"/>
        <form:errors path="mobile" cssClass="errors"/>
    </div>
</div>
        <br/>

    <div class="row">

    <div class="col-md-4 col-md-offset-2">
        <label>
            Email
        </label>
    </div>
    <div class="col-md-4">
        <form:input path="email"/>
        <form:errors path="email" cssClass="errors"/>
    </div>
</div>
        <br/>

    <div class="row">

    <div class="col-md-4 col-md-offset-2">
        <label>
            Address
        </label>
    </div>
    <div class="col-md-4">
        <form:input path="address"/>
        <form:errors path="address" cssClass="errors"/>
    </div>
 </div>
        <br/>

    <div class="row">
    <div class="col-md-4 col-md-offset-2">
        <label>
            DOB
        </label>
    </div>
    <div class="col-md-4">
        <form:input path="dateOfBirth"/>
        <form:errors path="dateOfBirth" cssClass="errors"/>
    </div>

    </div>

        <br/>

    <div class="row">

    <div class="col-md-4 col-md-offset-2">
        <label>
            Select an Image
        </label>
    </div>
    <div class="col-md-4">
        <input type="file" name="imageFile"/>
    </div>
    </div>
        <br/>
    <div class="row">
    <div class="col-md-4 col-md-offset-6">
        <input type="submit" class="btn btn-default" value="Register"/>
    </div>
</div>
</div>
</form:form>
