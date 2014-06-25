<%@ include file="../template/pieces/taglibs.jsp" %>

<p>List of all caches:</p>

<ul>
    <c:forEach var="cache" items="${cacheList}">
        <li>${cache}</li>
    </c:forEach>
</ul>