<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ include file="../taglibs.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <tiles:insertAttribute name="header" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><tiles:insertAttribute name="title" ignore="true" /></title>
    </head>
    <body>
        <div id="body_container">
            <tiles:insertAttribute name="menu" />

            <div id="body">
                <tiles:insertAttribute name="body" />
            </div>

            <tiles:insertAttribute name="footer" />
        </div>
    </body>
</html>