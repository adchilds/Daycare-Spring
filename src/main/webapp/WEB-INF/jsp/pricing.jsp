<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
    <head>
        <!-- CSS -->
        <jsp:include page="template/pieces/styles.jsp" />
        <link href="/resources/style/index.css" rel="stylesheet" type="text/css" media="screen" />

        <!-- JavaScript -->
        <jsp:include page="template/pieces/scripts.jsp" />

        <title>Daycare.ms - Pricing</title>
    </head>
    <body>
        <jsp:include page="template/pieces/header.jsp" />

        <div class="container" style="margin-top: 50px;">
            <div class="row">
                <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
                    <div class="panel panel-primary">
                        <div class="panel-heading pricing panel-text-center">
                            <h3>Basic</h3>
                            <h5 class="pricing-price">$8.95 / month</h5>
                        </div>
                        <div class="panel-body">
                            test test test
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
                    <div class="panel panel-primary">
                        <div class="panel-heading pricing panel-text-center">
                            <h3>Standard</h3>
                            <h5 class="pricing-price">$12.95 / month</h5>
                        </div>
                        <div class="panel-body">
                            test test test
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
                    <div class="panel panel-primary">
                        <div class="panel-heading pricing panel-text-center">
                            <h3>Premium</h3>
                            <h5 class="pricing-price">$19.95 / month</h5>
                        </div>
                        <div class="panel-body">
                            test test test
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <jsp:include page="template/pieces/footer.jsp" />
    </body>
</html>
