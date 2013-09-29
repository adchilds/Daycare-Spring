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

        <title>Daycare.ms - Registration</title>
    </head>

    <body>
        <div>
            <jsp:include page="template/pieces/header.jsp" />
        </div>

        <div class="centerOnScreen">
            <div class="panel panel-primary">
                <div class="panel-heading"><img src="/resources/image/daycare_logo/program_icon_medium.png" alt="Daycare Management System logo" />&nbsp;&nbsp;Create an Account</div>
                <form:form cssClass="form-horizontal" commandName="registrationForm" action="/">
                    <div class="form-group">
                        <label class="col-lg-4 control-label"><spring:message code="registration.label.email" /></label>
                        <div class="col-lg-8">
                            <form:input cssClass="form-control" cssErrorClass="form-control has-error" path="emailAddress" placeHolder="Email Address" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-4 control-label"><spring:message code="registration.label.password" /></label>
                        <div class="col-lg-8">
                            <form:password cssClass="form-control" cssErrorClass="form-control has-error" path="password" placeHolder="Password" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-4 control-label"><spring:message code="registration.label.firstName" /></label>
                        <div class="col-lg-8">
                            <form:input cssClass="form-control" cssErrorClass="form-control has-error" path="firstName" placeHolder="First Name" />
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row pull-right">
                            <div class="col-lg-4 margin-right">
                                <input type="submit" value="Submit" class="btn btn-default">
                            </div>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </body>
</html>