<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <title>Account Dashboard</title>
    </head>

    <body>
        <table>
            <tr>
                <td>Username:</td>
                <td>${user.username}</td>
            </tr>
            <tr>
                <td>Password:</td>
                <td>${user.password}</td>
            </tr>
        </table>
    </body>
</html>