<%@ include file="../template/pieces/taglibs.jsp" %>

<div class="daycare_table">
    <table>
        <tbody>
        <tr>
            <th class="first_th">ID</th>
            <th>Email</th>
            <th>User Slots</th>
            <th class="last_th">Invite Code</th>
        </tr>
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
