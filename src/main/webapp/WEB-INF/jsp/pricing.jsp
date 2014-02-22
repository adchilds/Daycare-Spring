<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
    <head>
        <!-- CSS -->
        <jsp:include page="template/pieces/styles.jsp" />
        <link href="/static/style/pricing.css" rel="stylesheet" type="text/css" />

        <!-- JavaScript -->
        <jsp:include page="template/pieces/scripts.jsp" />

        <title>Daycare.ms - Pricing</title>
    </head>
    <body>
        <jsp:include page="template/pieces/navigation.jsp" />

        <div class="container" style="margin-top: 50px;">
            <div class="row">
                <div class="col-lg-3 col-md-3 col-sm-4 col-xs-8">
                    <div class="panel panel-info">
                        <div class="panel-heading pricing panel-text-center">
                            <h3>Basic</h3>
                            <h5 class="pricing-price">$8.95 / month</h5>
                        </div>
                        <div class="panel-body text-center">
                            <p>25 child slots</p>
                            <hr>
                            <p>3 document slots per child</p>
                            <hr>
                            <p>3 employee slots</p>
                            <hr>
                            <p>1 user account</p>
                            <hr>
                            <p style="text-decoration: line-through;">Finances/billing</p>
                            <hr>
                            <p>Free support</p>
                            <hr>
                            <p><button class="btn btn-info">Purchase</button></p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-3 col-sm-4 col-xs-8">
                    <div class="panel panel-success">
                        <div class="panel-heading pricing panel-text-center">
                            <h3>Plus</h3>
                            <h5 class="pricing-price">$12.95 / month</h5>
                        </div>
                        <div class="panel-body text-center">
                            <p>100 child slots</p>
                            <hr>
                            <p>5 document slots per child</p>
                            <hr>
                            <p>15 employee slots</p>
                            <hr>
                            <p>2 user accounts</p>
                            <hr>
                            <p style="text-decoration: line-through;">Finances/billing</p>
                            <hr>
                            <p>Free support</p>
                            <hr>
                            <p><button class="btn btn-success">Purchase</button></p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-3 col-sm-4 col-xs-8">
                    <div class="panel panel-warning">
                        <div class="panel-heading pricing panel-text-center">
                            <h3>Premium</h3>
                            <h5 class="pricing-price">$19.95 / month</h5>
                        </div>
                        <div class="panel-body text-center">
                            <p><span class="infinite">&infin;</span> child slots</p>
                            <hr>
                            <p><span class="infinite">&infin;</span> documents per child</p>
                            <hr>
                            <p>30 employee slots</p>
                            <hr>
                            <p>5 user accounts</p>
                            <hr>
                            <p>Finances/billing</p>
                            <hr>
                            <p>Free support</p>
                            <hr>
                            <p><button class="btn btn-warning">Purchase</button></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <jsp:include page="template/pieces/footer.jsp" />
    </body>
</html>
