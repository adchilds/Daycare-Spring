<%@ include file="template/pieces/taglibs.jsp" %>

<%--
<div class="centerOnScreen">
    <div class="panel panel-primary">
        <div class="panel-heading"><img src="/static/image/daycare_logo/program_icon_medium.png" alt="Daycare Management System logo" />&nbsp;&nbsp;Daycare Management System</div>
        <form name='f' action="<c:url value="/j_spring_security_check" />" method='POST'>

            <table>
                <tr>
                    <td>User:</td>
                    <td><input type='text' name='j_username' value=''></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type='password' name='j_password' /></td>
                </tr>
                <tr>
                    <td><input name="submit" type="submit" value="submit" /></td>
                    <td><input name="reset" type="reset" /></td>
                </tr>
            </table>

        </form>
    </div>
</div>
--%>
<div class="container">

    <form class="form-signin" role="form">
        <h2 class="form-signin-heading">Please sign in</h2>
        <input type="email" class="form-control" placeholder="Email address" required="" autofocus="">
        <input type="password" class="form-control" placeholder="Password" required="">
        <label class="checkbox">
            <input type="checkbox" value="remember-me"> Remember me
        </label>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    </form>

</div>