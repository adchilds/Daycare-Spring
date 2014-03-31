<%@ include file="taglibs.jsp" %>

<jsp:include page="header.jsp" />

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
                <li class="${fn:contains(pageURI, 'index') ? 'active' : 'none'}"><a href="<c:url value="/index.html" />">Home</a></li>
                <li class="${fn:contains(pageURI, 'features') ? 'active' : 'none'}"><a href="/features.html">Features</a></li>
                <li class="${fn:contains(pageURI, 'pricing') ? 'active' : 'none'}"><a href="<c:url value="/pricing.html" />">Pricing</a></li>
                <li class="${fn:contains(pageURI, 'contact') ? 'active' : 'none'}"><a href="<c:url value="/contact.html" />">Contact Us</a></li>
                <!-- Elements in the navbar based on if a user is logged in or not -->
            </ul>
            <c:choose>
                <c:when test="${not empty isAuthenticated}">
                    <c:choose>
                        <c:when test="${isAuthenticated}">
                            <div class="navbar-form navbar-right">
                                <a href="/dashboard.html" class="btn btn-default" title="Dashboard"><span class="glyphicon glyphicon-home"></span></a>
                                <a href="/account/edit.html" class="btn btn-default" title="Account"><span class="glyphicon glyphicon-user"></span></a>
                                <a href="/settings.html" class="btn btn-default" title="Settings"><span class="glyphicon glyphicon-cog"></span></a>
                                <a href="<c:url value="/j_spring_security_logout" />" class="btn btn-danger" title="Logout"><span class="glyphicon glyphicon-off"></span></a>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div class="navbar-form navbar-right">
                                <a href="/login.html" class="btn btn-success normalize">Login</a>
                                <a href="/register.html" class="btn btn-primary normalize">Register</a>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </c:when>
                <c:otherwise>
                    <div class="navbar-form navbar-right">
                        <a href="/login.html" class="btn btn-success normalize">Login</a>
                        <a href="/register.html" class="btn btn-primary normalize">Register</a>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>