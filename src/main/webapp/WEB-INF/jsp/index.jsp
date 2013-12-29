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

        <title>Daycare.ms - Your solution to childcare organization</title>
    </head>
    <body>
        <jsp:include page="template/pieces/navigation.jsp" />
        <div class="jumbotron">
            <div class="container">
                <h1>Daycare.ms</h1>
                <h3>Your solution to childcare organization</h3>
                <p><spring:message code="index.description"/></p>
                <p><a class="btn btn-primary btn-lg">Learn more</a></p>
            </div>
        </div>
        <div class="container ">
            <!-- Example row of columns -->
            <div class="row">
                <div class="col-lg-4">
                    <h2>Need an account?</h2>
                    <p>Signing up for our service is easy. We have many different plans available to fit your needs. Simply select a plan and provide the necessary information and we'll be ready to help your business needs.</p>
                    <p><a href="/registration/register" class="btn btn-success">Sign up</a></p>
                </div>
                <div class="col-lg-4">
                    <h2>Testimonials</h2>
                    <h2>${fee}</h2>
                    <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                    <p><a class="btn btn-default">View details</a></p>
                </div>
                <div class="col-lg-4">
                    <h2>Pricing</h2>
                    <p>Take a look at our base pricing model. Unsure if you'll meet one of our pre-determined prices? No problem! With our custom pricing guideline, you're guaranteed to find a package that suits your individual business needs.</p>
                    <p><a href="/pricing" class="btn btn-default">View options</a></p>
                </div>
            </div>
        </div>
        <jsp:include page="template/pieces/footer.jsp" />
    </body>
</html>