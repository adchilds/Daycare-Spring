<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="alert alert-danger">
    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
    <h5 class="error-header">One or more errors occurred:</h5>
    <ul>
        <form:errors path="*" element="li" delimiter="</li><li>" htmlEscape="false" />
    </ul>
</div>