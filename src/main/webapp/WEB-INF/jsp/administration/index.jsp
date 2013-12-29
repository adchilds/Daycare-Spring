<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <!-- CSS -->
        <jsp:include page="../template/pieces/styles.jsp" />

        <!-- JavaScript -->
        <jsp:include page="../template/pieces/scripts.jsp" />

        <title>Daycare.ms - Administration</title>
    </head>

    <body>
        <div>
            <jsp:include page="../template/pieces/navigation.jsp" />
        </div>
        <div>
            <table class="table table-bordered table-striped">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Email</th>
                        <th>User Slots</th>
                        <th>Invite Code</th>
                    </tr>
                </thead>

                <tbody>
                <c:forEach var="user" items="${userList}" varStatus="status">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.emailAddress}</td>
                        <td>${accountList[status.index].userSlots}</td>
                        <td>${accountList[status.index].inviteCode}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>