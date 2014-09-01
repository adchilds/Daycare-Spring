<%@ include file="template/pieces/taglibs.jsp" %>

<div class="container">
    <div class="row">
        <form class="login_form" name='f' action="<c:url value='/j_spring_security_check'/>" method='POST'>
            <c:if test="${not empty param.error}">
                <jsp:include page="template/pieces/login-error.jsp" />
            </c:if>
            <h2 class="heading">Please sign in</h2>
            <input type="text" name="j_username" class="form-control username" placeholder="Username" autofocus="">
            <input type="password" name="j_password" class="form-control password" placeholder="Password">
            <label class="checkbox">
                <input type="checkbox" value="remember-me"> Remember me
            </label>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        </form>
    </div>
</div>