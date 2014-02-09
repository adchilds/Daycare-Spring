<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="spring-form" uri="http://www.springframework.org/tags/form" %>

<link href="/static/style/header.css" rel="stylesheet" type="text/css" media="screen" />

<div class="navbar navbar-inverse navbar-static-top nav-height-sm">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <div class="navbar-brand">
                Daycare.ms
            </div>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="${fn:contains(pageContext.request.requestURL, 'index') ? 'active' : 'none'}"><a href="/">Home</a></li>
                <li class="${fn:contains(pageContext.request.requestURL, 'features') ? 'active' : 'none'}"><a href="/features">Features</a></li>
                <li class="${fn:contains(pageContext.request.requestURL, 'pricing') ? 'active' : 'none'}"><a href="/pricing">Pricing</a></li>
                <li class="${fn:contains(pageContext.request.requestURL, 'contact') ? 'active' : 'none'}"><a href="/contact">Contact Us</a></li>
                <!-- Elements in the navbar based on if a user is logged in or not -->
            </ul>
            <c:choose>
                <c:when test="${not empty isAuthenticated}">
                    <c:choose>
                        <c:when test="${isAuthenticated}">

                        </c:when>
                        <c:otherwise>
                            <spring-form:form commandName="loginForm" class="navbar-form navbar-right" action="/login-nav">
                                <div class="form-group">
                                    <spring-form:input path="username" type="text" placeholder="Email" class="form-control" />
                                </div>
                                <div class="form-group">
                                    <spring-form:input path="password" type="password" placeholder="Password" class="form-control" />
                                </div>
                                <button type="submit" class="btn btn-success">Sign in</button>
                            </spring-form:form>
                        </c:otherwise>
                    </c:choose>
                </c:when>
                <c:otherwise>
                    <spring-form:form commandName="loginForm" class="navbar-form navbar-right" action="/login">
                        <div class="form-group">
                            <spring-form:input path="username" type="text" placeholder="Email" class="form-control" />
                        </div>
                        <div class="form-group">
                            <spring-form:input path="password" type="password" placeholder="Password" class="form-control" />
                        </div>
                        <button type="submit" class="btn btn-success">Sign in</button>
                    </spring-form:form>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>