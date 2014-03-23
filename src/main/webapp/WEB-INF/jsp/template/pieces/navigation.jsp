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
                                <a href="<c:url value="/j_spring_security_logout" />" class="btn btn-danger">Logout</a>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <form class="navbar-form navbar-right" action="<c:url value="/j_spring_security_check" />" method="POST">
                                <div class="form-group">
                                    <input name="j_username" type="text" placeholder="Email" class="form-control" />
                                </div>
                                <div class="form-group">
                                    <input name="j_username" type="password" placeholder="Password" class="form-control" />
                                </div>
                                <button type="submit" value="submit" class="btn btn-success">Sign in</button>
                            </form>
                        </c:otherwise>
                    </c:choose>
                </c:when>
                <c:otherwise>
                    <form class="navbar-form navbar-right" action="<c:url value="/j_spring_security_check" />" method="POST">
                        <div class="form-group">
                            <input name="j_username" type="text" placeholder="Email" class="form-control" />
                        </div>
                        <div class="form-group">
                            <input name="j_username" type="password" placeholder="Password" class="form-control" />
                        </div>
                        <button type="submit" value="submit" class="btn btn-success">Sign in</button>
                    </form>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>