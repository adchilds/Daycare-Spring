<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="spring-form" uri="http://www.springframework.org/tags/form" %>

<div>
    <div class="navbar navbar-inverse navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand">Daycare.ms</a>
            </div>
            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li class="${fn:contains(pageContext.request.requestURL, 'index') ? 'active' : 'none'}"><a href="/">Home</a></li>
                    <li class="${fn:contains(pageContext.request.requestURL, 'features') ? 'active' : 'none'}"><a href="/features">Features</a></li>
                    <li class="${fn:contains(pageContext.request.requestURL, 'pricing') ? 'active' : 'none'}"><a href="/pricing">Pricing</a></li>
                    <li class="${fn:contains(pageContext.request.requestURL, 'contact') ? 'active' : 'none'}"><a href="/contact">Contact Us</a></li>
                    <!-- Elements in the navbar based on if a user is logged in or not -->
                </ul>
                <c:if test="${not loggedIn}">
                    <spring-form:form commandName="loginForm" class="navbar-form navbar-right" action="/index">
                        <div class="form-group">
                            <spring-form:input path="username" type="text" placeholder="Email" class="form-control" />
                        </div>
                        <div class="form-group">
                            <spring-form:input path="password" type="password" placeholder="Password" class="form-control" />
                        </div>
                        <button type="submit" class="btn btn-success">Sign in</button>
                    </spring-form:form>
                </c:if>
            </div><!--/.navbar-collapse -->
        </div>
    </div>
</div>