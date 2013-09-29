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
            <jsp:include page="template/pieces/header.jsp" />
        </div>
        <div class="h3 text-center text-primary">
            <p>Welcome to Daycare.ms - Your solution to childcare organization</p>
        </div>
        <div class="text-center">
            <spring:message code="welcome.language" />:
            <a href="?lang=en_US"><img src="/resources/image/languages/english/flag-en.png" alt="en" /></a>
            <a href="?lang=es_ES"><img src="/resources/image/languages/spanish/flag-es.png" alt="es" /></a>
<%--
                <a href="?lang=pt_BR"><img src="/resources/image/languages/portuguese/flag-br.png" alt="pt" /></a>
                <a href="?lang=ko_KO"><img src="/resources/image/languages/korean/flag-kr.png" alt="kr" /></a>
--%>
            (Current: ${pageContext.response.locale})

            <h2>Username --> <c:out value="${user.username}"/></h2>
            <h2>Subscription --> <c:out value="${subscription.subscriptionLengthInMonths}"/></h2>
            <h2>SHA-256 --> <c:out value="${sha256}"/></h2>
            <h2>Base64 --> <c:out value="${base64}"/></h2>
            <h2>Base64 --> MD5 --> <c:out value="${encrypted}"/></h2>
        </div>

        <div class="modal-footer">
            <jsp:include page="template/pieces/footer.jsp" />
        </div>
    </body>
</html>
