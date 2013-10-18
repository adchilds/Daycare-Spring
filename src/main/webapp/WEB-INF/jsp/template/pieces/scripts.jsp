<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!-- JavaScript -->
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="/static/assets/js/bootstrap.min.js"></script>

<c:if test="${usingAceBootstrap}">
    <script type="text/javascript" src="/static/assets/js/ace.min.js"></script>
    <script type="text/javascript" src="/static/assets/js/ace-extra.min.js"></script>
    <script type="text/javascript" src="/static/assets/js/ace-elements.min.js"></script>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

    <!--[if lt IE 9]>
    <script src="/static/assets/js/html5shiv.js"></script>
    <script src="/static/assets/js/respond.min.js"></script>
    <![endif]-->
</c:if>