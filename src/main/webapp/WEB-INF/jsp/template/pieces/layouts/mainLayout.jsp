<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ include file="../taglibs.jsp" %>

<html>
    <head>
        <tiles:insertAttribute name="header" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><tiles:insertAttribute name="title" ignore="true" /></title>
    </head>
    <body>
        <div id="body_container">
            <div id="header">
                <tiles:insertAttribute name="menu" />
            </div>
            <div id="body">
                <tiles:insertAttribute name="body" />
            </div>
            <div id="footer">
                <tiles:insertAttribute name="footer" />
            </div>
        </div>
    </body>
</html>