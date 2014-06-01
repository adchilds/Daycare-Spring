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
            <div id="administration">
                <div class="container">
                    <div class="row">

                        <div id="left_content">
                            <div class="col-md-2">
                                <jsp:include page="../administration-navigation.jsp" />
                            </div>
                        </div>

                        <div id="right_content">
                            <div class="col-md-10">
                                <tiles:insertAttribute name="body" />
                            </div>
                        </div>

                    </div>
                </div>
            </div>
            <div id="footer">
                <tiles:insertAttribute name="footer" />
            </div>
        </div>
    </body>
</html>