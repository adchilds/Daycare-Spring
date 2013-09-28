<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div id="errors-box">
    <h5>One or more errors occurred:</h5>
    <ul>
        <form:errors path="*" element="li" delimiter="</li><li>" htmlEscape="false" />
    </ul>
</div>