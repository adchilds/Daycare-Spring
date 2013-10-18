<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!-- CSS -->
<link href="/static/assets/css/bootstrap.min.css" rel="stylesheet" />

<!-- fonts -->
<link rel="stylesheet" href="/static/assets/css/font-awesome.min.css" />
<!--[if IE 7]>
<link rel="stylesheet" href="/static/assets/css/font-awesome-ie7.min.css" />
<![endif]-->
<c:if test="${usingAceBootstrap}">
    <link rel="stylesheet" href="/static/assets/css/ace-fonts.css" />

    <!-- ace styles -->
    <link rel="stylesheet" href="/static/assets/css/ace.min.css" />
    <link rel="stylesheet" href="/static/assets/css/ace-rtl.min.css" />
    <link rel="stylesheet" href="/static/assets/css/ace-skins.min.css" />
    <!--[if lte IE 8]>
    <link rel="stylesheet" href="/static/assets/css/ace-ie.min.css" />
    <![endif]-->
</c:if>

<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0-rc2/css/bootstrap-glyphicons.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/resources/style/main.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/resources/style/style.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/resources/style/footer.css" rel="stylesheet" type="text/css" media="screen" />