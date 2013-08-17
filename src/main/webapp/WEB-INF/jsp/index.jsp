<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
    <body>
        <spring:message code="welcome.language" />: <a href="?lang=en_US">en</a> | <a href="?lang=es_ES">es</a> (Current: ${pageContext.response.locale})
        <h2><spring:message code="welcome.hello" /> ${name}!</h2>
        <br>
        <br>
        <c:url value="/login" var="link" />
        <h3><spring:message code="welcome.clickThis" /> <a href="${link}"><spring:message code="welcome.link" /></a> <spring:message code="welcome.toGOTO" /></h3>
        <br>
        <br>
    </body>
</html>
