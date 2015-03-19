<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="top-menu">
    <ul>
        <li><a href="#">Home</a></li>
        <li><a href="#">Profile</a></li>
        <li><a href="#">Messages</a></li>
        <c:if test="${pageContext['request'].userPrincipal != null}">
            <li> <a href="<c:url value='j_spring_security_logout'/>" >Logout</a></li>
        </c:if>
    </ul>
</div>
