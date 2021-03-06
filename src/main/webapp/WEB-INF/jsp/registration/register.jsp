<%@ include file="../template/pieces/taglibs.jsp" %>

<div class="container">
    <div class="row">
        <form:form commandName="registrationForm" action="/register.html">
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <div class="daycare_form">
                    <div id="daycare_form_header">
                        Lorem ipsum dolor sit amet
                        <p>All fields required</p>
                    </div>
                    <hr />
                    <div id="daycare_form_fields">
                        <div class="daycare_form_field">
                            <div class="row">
                                <div class="col-md-5">
                                    <label>First Name:</label>
                                </div>
                                <div class="col-md-7">
                                    <form:input path="firstName" type="text" autocomplete="off" />
                                </div>
                            </div>
                        </div>
                        <div class="daycare_form_field">
                            <div class="row">
                                <div class="col-md-5">
                                    <label>Last Name:</label>
                                </div>
                                <div class="col-md-7">
                                    <form:input path="lastName" type="text" autocomplete="off" />
                                </div>
                            </div>
                        </div>
                        <div class="daycare_form_field">
                            <div class="row">
                                <div class="col-md-5">
                                    <label>Email Address:</label>
                                </div>
                                <div class="col-md-7">
                                    <form:input path="emailAddress" type="text" autocomplete="off" />
                                </div>
                            </div>
                        </div>
                        <div class="daycare_form_field">
                            <div class="row">
                                <div class="col-md-5">
                                    <label>Password:</label>
                                </div>
                                <div class="col-md-7">
                                    <form:password path="password" autocomplete="off" />
                                </div>
                            </div>
                        </div>
                        <div class="daycare_form_field">
                            <div class="row">
                                <div class="col-md-5">
                                    <label>Confirm Password:</label>
                                </div>
                                <div class="col-md-7">
                                    <form:password path="confirmPassword" autocomplete="off" />
                                </div>
                            </div>
                        </div>
                    </div>
                    <div id="daycare_form_actions">
                        <div class="row">
                            <div class="col-md-3"></div>
                            <div class="col-md-6">
                                <input type="submit" value="Create" class="btn btn-success daycare_form_success" />
                            </div>
                            <div class="col-md-3"></div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-3"></div>
        </form:form>
    </div>
</div>

<%--
<form:form commandName="registrationForm" action="/registration/submit-registration">
    <c:if test="${not empty registrationForm}">
        <spring:hasBindErrors name="registrationForm">
            <jsp:include page="../template/pieces/form-errors.jsp" />
        </spring:hasBindErrors>
    </c:if>

    <div class="container text-center" style="margin-top: 30px; margin-bottom: 15px;">
        Selected Plan: ${subscriptionType}
    </div>

    <div class="container">
        <div class="row">
            <div class="col-lg-4 col-md-4 col-sm-5 col-xs-10">
                <div class="panel panel-info">
                    <div class="panel-heading pricing panel-text-center">
                        <h3>Personal</h3>
                        <h5>Tell us a little about yourself</h5>
                    </div>
                    <div class="panel-body">
                        <div class="form-group">
                            <form:label path="firstName" cssClass="form-label">First name</form:label>
                            <form:input path="firstName" cssClass="form-control form-input" />
                        </div>
                        <div class="form-group">
                            <form:label path="lastName" cssClass="form-label">Last name</form:label>
                            <form:input path="lastName" cssClass="form-control form-input" />
                        </div>
                        <div class="form-group">
                            <form:label path="emailAddress" cssClass="form-label">Email address</form:label>
                            <form:input path="emailAddress" cssClass="form-control form-input" />
                        </div>
                        <div class="form-group">
                            <form:label path="confirmEmailAddress" cssClass="form-label">Confirm email</form:label>
                            <form:input path="confirmEmailAddress" cssClass="form-control form-input" />
                        </div>
                        <div class="form-group">
                            <form:label path="password" cssClass="form-label">Password</form:label>
                            <form:input path="password" cssClass="form-control form-input" />
                        </div>
                        <div class="form-group">
                            <form:label path="confirmPassword" cssClass="form-label">Confirm password</form:label>
                            <form:input path="confirmPassword" cssClass="form-control form-input" />
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-lg-4 col-md-4 col-sm-5 col-xs-10">
                <div class="panel panel-info">
                    <div class="panel-heading pricing panel-text-center">
                        <h3>Business</h3>
                        <h5>Tell us a little about your business</h5>
                    </div>
                    <div class="panel-body">
                        <div class="form-group">
                            <form:label path="companyName" cssClass="form-label">Company Name</form:label>
                            <form:input path="companyName" cssClass="form-control form-input" />
                        </div>
                        <div class="form-group">
                            <form:label path="companyStreetAddress1" cssClass="form-label">Street Address</form:label>
                            <form:input path="companyStreetAddress1" cssClass="form-control form-input" />
                        </div>
                        <div class="form-group">
                            <label class="form-label"></label>
                            <form:input path="companyStreetAddress2" cssClass="form-control form-input" />
                        </div>
                        <div class="form-group">
                            <form:label path="city" cssClass="form-label">City</form:label>
                            <form:input path="city" cssClass="form-control form-input" />
                        </div>
                        <div class="form-group">
                            <form:label path="state" cssClass="form-label">State</form:label>
                            <form:input path="state" cssClass="form-control form-input" />
                        </div>
                        <div class="form-group">
                            <form:label path="zipcode" cssClass="form-label">Zipcode</form:label>
                            <form:input path="zipcode" cssClass="form-control form-input" />
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-lg-4 col-md-4 col-sm-5 col-xs-10">
                <div class="panel panel-info">
                    <div class="panel-heading pricing panel-text-center">
                        <h3>Payment</h3>
                        <h5>Enter your payment information</h5>
                    </div>
                    <div class="panel-body">
                        <div class="form-group">
                            <form:label path="creditCardNumber" cssClass="form-label">Credit card #</form:label>
                            <form:input path="creditCardNumber" cssClass="form-control form-input" />
                        </div>
                        <div class="form-group">
                            <form:label path="expirationDate" cssClass="form-label">Expiration</form:label>
                            <form:input path="expirationDate" cssClass="form-control form-input" />
                        </div>
                        <div class="form-group">
                            <form:label path="ccvCode" cssClass="form-label">CCV Code</form:label>
                            <form:input path="ccvCode" cssClass="form-control form-input" />
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Need to be passed along with the form but not displayed to the user -->
    <form:hidden path="subscriptionType"/>

    <div class="container text-center">
        <div class="submit-and-terms">
            <p>By clicking purchase, you agree to the <a href="/legal/tos">Terms of Service</a> and <a href="/legal/privacy">Privacy Policy</a>.</p>
            <p>You also agree to pay the fees representative of the package you've chosen.</p>
            <button type="submit" class="btn btn-default">Purchase</button>
        </div>
    </div>
</form:form>
--%>
