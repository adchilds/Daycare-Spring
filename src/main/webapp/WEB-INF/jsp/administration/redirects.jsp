<%@ include file="../template/pieces/taglibs.jsp" %>

<div class="redirect_form">
    <h3>Add new redirect:</h3>

    <form:form action="/administration/redirects.html" commandName="form" method="POST">
        <c:if test="${hasErrors}">
            <div class="form_errors">
                <form:errors path="*" cssClass="errors"/>
            </div>
        </c:if>

        <div class="form_item">
            <form:label path="sourceURL">Source URL (i.e. /en-us/index.html):</form:label>
            <form:input path="sourceURL" type="text"/>
        </div>

        <div class="form_item">
            <form:label path="destinationURL">Destination URL (i.e. /en-us/maintenance.html):</form:label>
            <form:input path="destinationURL" type="text"/>
        </div>

        <div class="form_item">
            <form:label path="startDate">Start date (format = MM/dd/yyyy HH:mm:ss [i.e. 03/22/2014 18:00:00]):</form:label>
            <form:input path="startDate" type="text"/>
        </div>

        <div class="form_item">
            <form:label path="endDate">End date (format = MM/dd/yyyy HH:mm:ss [i.e. 07/14/2014 14:30:00]):</form:label>
            <form:input path="endDate" type="text"/>
        </div>

        <div class="submit-button">
            <input type="submit" value="Submit" class="default">
        </div>
    </form:form>
</div>

<div class="daycare_table">
    <h3>All redirects:</h3>

    <table>

        <tbody>
            <tr>
                <th class="first_th">ON / OFF</th>
                <th>Source URL</th>
                <th>Destination URL</th>
                <th>Start Date</th>
                <th>End Date</th>
                <th>Created By</th>
                <th>Last Updated Date</th>
                <th>Last Updated By</th>
                <th class="last_th"></th>
            </tr>

            <c:choose>
                <c:when test="${fn:length(allRedirects) > 0}">
                    <c:forEach var="redirect" items="${allRedirects}">
                        <tr>
                            <td class="redirect_status">
                                <c:choose>
                                    <c:when test="${redirect.enabled}">
                                        <span class="enabled">ON</span> -- <a
                                            href="/administration/redirects.html?disableId=${redirect.id}">OFF</a>
                                    </c:when>
                                    <c:otherwise>
                                        <a href="/administration/redirects.html?enableId=${redirect.id}">
                                            ON</a> -- <span class="disabled">OFF</span>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td>${redirect.sourceURL}</td>
                            <td>${redirect.destinationURL}</td>
                            <td><fmt:formatDate pattern="MM/dd/yyyy HH:mm:ss"
                                                value="${redirect.startDate.time}" /></td>
                            <td><fmt:formatDate pattern="MM/dd/yyyy HH:mm:ss"
                                                value="${redirect.endDate.time}" /></td>
                            <td>${redirect.createdBy}</td>
                            <td><fmt:formatDate pattern="MM/dd/yyyy HH:mm:ss"
                                                value="${redirect.lastUpdatedDate.time}"/></td>
                            <td>${redirect.lastUpdatedBy}</td>
                            <td><a href="/administration/redirects.html?removeId=${redirect.id}">Remove</a></td>
                        </tr>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <tr>
                        <td colspan="9">No redirects found.</td>
                    </tr>
                </c:otherwise>
            </c:choose>
        </tbody>

    </table>
</div>