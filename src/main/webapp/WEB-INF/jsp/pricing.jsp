<%@ include file="template/pieces/taglibs.jsp" %>

<div class="pricing">
    <div class="container" style="margin-top: 50px;">
        <div class="row">
            <div class="dashboard">
                <div id="search_options">
                    <div id="search_box" data-jq-type="SearchBox">
                        <input class="search_box" placeholder="Search..." />
                        <img id="clear_button" class="svg" src="/static/image/icon/appbar.close.svg" />
                    </div>
                    <div id="sort_and_filter">
                        <div id="sort">
                            <img class="svg" src="/static/image/icon/appbar.scale.svg" />
                        </div>
                        <div id="filter">
                            <img class="svg" src="/static/image/icon/appbar.filter.svg" />
                        </div>
                    </div>
                </div>
                <div id="active_filters">
                    <%@ include file="template/pieces/search/active_filter.jsp" %>
                    <%@ include file="template/pieces/search/active_filter.jsp" %>
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