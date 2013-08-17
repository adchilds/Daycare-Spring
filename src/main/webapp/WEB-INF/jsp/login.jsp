<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
    <head>
        <!-- CSS -->
        <link href="/resources/style/login.css" rel="stylesheet" type="text/css" media="screen" />
        <link href="/resources/style/bootstrap.css" rel="stylesheet" type="text/css" media="screen" />

        <!-- JavaScript -->
        <script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
        <script type="text/javascript" src="/resources/js/bootstrap.js"></script>
        <script type="text/JavaScript" src="/resources/js/login.js"></script>

        <title>Login page</title>
    </head>

    <body>
        <div id="centerOnScreen" class="panel panel-primary">
            <div class="panel-heading"><img src="/resources/image/program_icon_medium.png" alt="Daycare Management System logo" />  Daycare Management System</div>
            <form:form cssClass="form-horizontal" commandName="user" action="/login">
                <div class="form-group">
                    <label class="col-lg-3 control-label"><spring:message code="login.label.username" /></label>
                    <div class="col-lg-9">
                        <form:input cssClass="form-control has-error" path="username" placeHolder="Username" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-lg-3 control-label"><spring:message code="login.label.password" /></label>
                    <div class="col-lg-9">
                        <form:password cssClass="form-control has-error" path="password" placeHolder="Password" />
                    </div>
                </div>
                <div class="form-group">
                    <div class="row pull-right">
                        <div class="col-lg-4">
                            <input type="submit" value="Login" class="btn btn-default">
                        </div>
                        <div class="col-lg-2">
                            <button type="signup" class="btn btn-default btn-success">Sign Up</button>
                        </div>
                    </div>
                </div>
            </form:form>

            <p class="copyright">&#169; Copyright 2013 -- Adam Childs</p>
        </div>
    </body>
</html>