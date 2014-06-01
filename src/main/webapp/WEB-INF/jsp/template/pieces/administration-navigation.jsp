<%@ include file="taglibs.jsp" %>

<div id="administration_nav">
    <c:forEach var="navElement" items="${administrationNavigation}">
        <div class="administration_nav_element">
            <a href="${navElement.url}">
                ${navElement.textRepresentation}
            </a>
        </div>
    </c:forEach>
</div>