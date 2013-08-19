<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
    <head>
        <!-- CSS -->
        <link href="/resources/style/bootstrap.css" rel="stylesheet" type="text/css" media="screen" />
        <link href="/resources/style/style.css" rel="stylesheet" type="text/css" media="screen" />
        <link href="/resources/style/index.css" rel="stylesheet" type="text/css" media="screen" />

        <!-- JavaScript -->
        <script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
        <script type="text/javascript" src="/resources/js/bootstrap.js"></script>
        <script type="text/JavaScript" src="/resources/js/index.js"></script>

        <title>Daycare.ms - Your solution to childcare organization</title>
    </head>
    <body>
        <div>
            <jsp:include page="header.jsp" />
        </div>
        <div id="centerWrapper">
            <div class="center">
                <spring:message code="welcome.language" />: <a href="?lang=en_US">en</a> | <a href="?lang=es_ES">es</a> (Current: ${pageContext.response.locale})
                <h2><spring:message code="welcome.hello" /> ${name}!</h2>
                <br>
                <br>
                <c:url value="/login" var="link" />
                <h3><spring:message code="welcome.clickThis" /> <a href="${link}"><spring:message code="welcome.link" /></a> <spring:message code="welcome.toGOTO" /></h3>
                <br>
                <br>
            </div>
        </div>
    </body>
</html>
