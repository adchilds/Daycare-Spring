<%@ include file="taglibs.jsp" %>

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
                <c:set var="pageURI" value="${requestScope['javax.servlet.forward.servlet_path']}" />
                <li class="${fn:contains(pageURI, 'index') ? 'active' : 'none'}"><a href="/index.html">Home</a></li>
                <li class="${fn:contains(pageURI, 'features') ? 'active' : 'none'}"><a href="/features.html">Features</a></li>
                <li class="${fn:contains(pageURI, 'pricing') ? 'active' : 'none'}"><a href="/pricing.html">Pricing</a></li>
                <li class="${fn:contains(pageURI, 'contact') ? 'active' : 'none'}"><a href="/contact.html">Contact Us</a></li>
                <!-- Elements in the navbar based on if a user is logged in or not -->
            </ul>
            <c:choose>
                <c:when test="${not empty isAuthenticated}">
                    <c:choose>
                        <c:when test="${isAuthenticated}">

                        </c:when>
                        <c:otherwise>
                            <form:form commandName="loginForm" class="navbar-form navbar-right" action="/login-nav">
                                <div class="form-group">
                                    <form:input path="username" type="text" placeholder="Email" class="form-control" />
                                </div>
                                <div class="form-group">
                                    <form:input path="password" type="password" placeholder="Password" class="form-control" />
                                </div>
                                <button type="submit" class="btn btn-success">Sign in</button>
                            </form:form>
                        </c:otherwise>
                    </c:choose>
                </c:when>
                <c:otherwise>
                    <form:form commandName="loginForm" class="navbar-form navbar-right" action="/login">
                        <div class="form-group">
                            <form:input path="username" type="text" placeholder="Email" class="form-control" />
                        </div>
                        <div class="form-group">
                            <form:input path="password" type="password" placeholder="Password" class="form-control" />
                        </div>
                        <button type="submit" class="btn btn-success">Sign in</button>
                    </form:form>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>