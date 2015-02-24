<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 23/02/2015
  Time: 04:16
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri='http://java.sun.com/jstl/core_rt' prefix='c'%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>

<head>

    <title>
        <tiles:getAsString name="pageTitle" ignore="true"/>
    </title>
    <link type="text/css" rel="stylesheet" href='<c:url value="/contents/${applicationVersion}/css/bootstrap.min.css"/>'/>
    <link type="text/css" rel="stylesheet" href='<c:url value="/contents/${applicationVersion}/css/customestyle.css"/>'/>

</head>
<body>

    <div class="container-fluid">

        <!-- Insert Hearder -->
        <tiles:insertAttribute name="header"/>


        <!-- Insert common top menu -->
        <tiles:insertAttribute name="topMenu"/>

        <!-- Insert common welcome message -->
        <tiles:insertAttribute name="welcomeMessage"/>

        <!-- Insert main content -->
        <tiles:insertAttribute name="content"/>

        <!-- Insert footer -->

        <tiles:insertAttribute name="footer"/>

    </div>

</body>
</html>
