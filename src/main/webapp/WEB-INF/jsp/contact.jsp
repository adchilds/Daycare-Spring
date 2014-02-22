<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
    <head>
        <!-- CSS -->
        <jsp:include page="template/pieces/styles.jsp" />
        <link href="/static/style/index.css" rel="stylesheet" type="text/css" media="screen" />

        <!-- JavaScript -->
        <jsp:include page="template/pieces/scripts.jsp" />

        <title>Daycare.ms - Your solution to childcare organization</title>
    </head>
    <body>
        <div id="body_container">
            <div id="header">
                <jsp:include page="template/pieces/navigation.jsp" />
            </div>
            <div id="body">
                Contact Us at...
            </div>
            <div id="footer">
                <jsp:include page="template/pieces/footer.jsp" />
            </div>
        </div>
    </body>
</html>