<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
    <head>
        <!-- CSS -->
        <jsp:include page="../template/pieces/styles.jsp" />
        <link href="/resources/style/index.css" rel="stylesheet" type="text/css" media="screen" />

        <!-- JavaScript -->
        <jsp:include page="../template/pieces/scripts.jsp" />

        <title>Daycare.ms - Your solution to childcare organization</title>
    </head>
    <body>
        <div>
            <jsp:include page="../template/pieces/header.jsp" />
        </div>
        <div class="panel header-center">
            <div class="panel-heading">
                <div class="panel-title h3 text-center text-primary">
                    <p>Daycare.ms Terms of Service</p>
                </div>
            </div>
            <div class="panel-body">
                <p>You must follow our rules!</p>
            </div>
        </div>
        <div>
            <jsp:include page="../template/pieces/footer.jsp" />
        </div>
    </body>
</html>