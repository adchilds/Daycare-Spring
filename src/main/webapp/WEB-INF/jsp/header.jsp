<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
    <head>
        <!-- CSS -->
        <link href="/resources/style/bootstrap.css" rel="stylesheet" type="text/css" media="screen" />
        <link href="/resources/style/style.css" rel="stylesheet" type="text/css" media="screen" />
        <link href="/resources/style/header.css" rel="stylesheet" type="text/css" media="screen" />

        <!-- JavaScript -->
        <script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
        <script type="text/javascript" src="/resources/js/bootstrap.js"></script>
        <script type="text/JavaScript" src="/resources/js/header.js"></script>
    </head>
    <body>
        <div class="padded-border header-center">
            <nav class="navbar navbar-default" role="navigation">
                <c:set var="active" value="${fn:endsWith(pageContext.request.requestURI, page.url)}" />

                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <div class="navbar-brand">
                        Daycare.ms
<%--
                        <br/>
                        <a href="?lang=en_US"><img src="/resources/image/languages/english/flag-en.png" alt="en" /></a>
                        <a href="?lang=es_ES"><img src="/resources/image/languages/spanish/flag-es.png" alt="es" /></a>
                        <a href="?lang=pt_BR"><img src="/resources/image/languages/portuguese/flag-br.png" alt="pt" /></a>
                        <a href="?lang=ko_KO"><img src="/resources/image/languages/korean/flag-kr.png" alt="kr" /></a>
--%>
                    </div>
                </div>

                <div>
                    <ul class="nav navbar-nav">
                        <li class="${fn:contains(pageContext.request.requestURL, 'index') ? 'active' : 'none'}"><i class="icon-home icon-white"></i><a href="/">Home</a></li>

                        <!-- Elements in the navbar based on if a user is logged in or not -->
                        <c:choose>
<%-- TODO: Remove "not" from this expression --%>
                            <c:when test="${not userLoggedIn}">

                            </c:when>
                            <c:otherwise>
                                <li class="${fn:contains(pageContext.request.requestURL, 'login') ? 'active' : 'none'}"><a href="/login">Login</a></li>
                            </c:otherwise>
                        </c:choose>
                    </ul>

                    <!-- Elements pulled to the right of the navbar -->
                    <c:choose>
<%-- TODO: Remove "not" from this expression --%>
                        <c:when test="${userLoggedIn}">
                            <div class="pull-right">
                                <button type="submit" class="btn navbar-btn btn-small btn-primary" value="logout"><i class="icon-off icon-white"></i>Logout</button>
                            </div>
                            <div class="navbar-text pull-right">
                                Signed in as <a href="#" class="navbar-link">Adam Childs</a>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div class="pull-right">
                                <a href="/login" class="btn btn-primary navbar-btn" value="sign-in">Sign in</a>
                                <a href="/signup" class="btn btn-success navbar-btn" value="sign-up">Sign up</a>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </div>
            </nav>
        </div>
    </body>
</html>