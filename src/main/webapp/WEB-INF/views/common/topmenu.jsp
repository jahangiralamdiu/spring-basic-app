<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul class="nav nav-tabs">
    <li role="presentation" class="active"><a href="#">Home</a></li>
    <li role="presentation"><a href="#">Profile</a></li>
    <li role="presentation"><a href="#">Messages</a></li>
    <c:if test="${pageContext['request'].userPrincipal != null}">
    <li role="presentation"> <a href="<c:url value='j_spring_security_logout'/>" >Logout</a></li>
    </c:if>
</ul>