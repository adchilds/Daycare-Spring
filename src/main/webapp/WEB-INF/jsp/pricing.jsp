<%@ include file="template/pieces/taglibs.jsp" %>

<div class="pricing">
    <div class="container" style="margin-top: 50px;">
        <div class="row">
            <div class="dashboard">
                <div id="search_options">
                    <div id="search_box" data-jq-type="SearchBox">
                        <input class="search_box" placeholder="Search..." />
                        <div id="clear_button">
                            <%@ include file="/WEB-INF/jsp/icon/appbar.close.jsp" %>
                        </div>
                    </div>
                    <div id="sort_and_filter">
                        <div id="sort">
                            <%@ include file="/WEB-INF/jsp/icon/appbar.filter.alphabetical.jsp" %>
                        </div>
                    </div>
                </div>
                <div id="active_filters">
                    <div id="content_block">
                        <p>Active Filters:</p>
                    </div>
                    <div id="filters">
                        <%@ include file="template/pieces/search/active_filter.jsp" %>
                        <%@ include file="template/pieces/search/active_filter.jsp" %>
                    </div>
                </div>
                <div id="result_container">
                    <%@ include file="template/pieces/search/result.jsp" %>
                    <%@ include file="template/pieces/search/result.jsp" %>
                    <%@ include file="template/pieces/search/result.jsp" %>
                    <%@ include file="template/pieces/search/result.jsp" %>
                    <%@ include file="template/pieces/search/result.jsp" %>
                </div>
            </div>
        </div>
    </div>
</div>