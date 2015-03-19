<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 23/02/2015
  Time: 04:16
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri='http://java.sun.com/jstl/core_rt' prefix='c' %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>

<head>

    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/favicon.ico" />

    <title>
        <tiles:getAsString name="pageTitle" ignore="true"/>
    </title>
    <link type="text/css" rel="stylesheet"
          href='<c:url value="/contents/${applicationVersion}/css/customestyle.css"/>'/>

</head>
<body>

<div class="main-container">
    <!-- Insert Hearder -->
    <div class="row">
        <tiles:insertAttribute name="header"/>
    </div>


    <!-- Insert common top menu -->

    <div class="row">
        <tiles:insertAttribute name="topMenu"/>
    </div>

    <!-- Insert common welcome message -->
    <div class="row">
        <tiles:insertAttribute name="welcomeMessage"/>
    </div>

    <!-- Insert main content -->
    <div class="row">
        <tiles:insertAttribute name="content"/>
    </div>

    <!-- Insert footer -->

    <div class="row">
        <tiles:insertAttribute name="footer"/>
    </div>

</div>

</body>
</html>
