<%@ include file="/WEB-INF/jsp/template/pieces/taglibs.jsp" %>

<div class="pricing">
    <div class="container" style="margin-top: 50px;">
        <div class="row">
            <div class="dashboard">
                <div id="search_options">
                    <div id="search_box" data-jq-type="SearchBox">
                        <input class="search_box" placeholder="Search..." />
                        <div id="clear_button">
                            <%@ include file="/WEB-INF/jsp/svg/icon/appbar.close.jsp" %>
                        </div>
                    </div>
                    <div id="sort_and_filter">
                        <div id="sort" data-jq-type="SortSelector">
                            <div id="icon">
                                <%@ include file="/WEB-INF/jsp/svg/icon/appbar.filter.alphabetical.jsp" %>
                            </div>
                            <div id="options" style="display: none;">
                                <span class="option" data-jq-value="value1">Value 1</span>
                                <span class="option" data-jq-value="value1">Value 2</span>
                                <span class="option" data-jq-value="value1">Value 3</span>
                            </div>
                        </div>
                    </div>
                </div>
                <div id="active_filters">
                    <div id="content_block">
                        <p>Active Filters:</p>
                    </div>
                    <div id="filters">
                        <%@ include file="/WEB-INF/jsp/template/pieces/search/active_filter.jsp" %>
                        <%@ include file="/WEB-INF/jsp/template/pieces/search/active_filter.jsp" %>
                    </div>
                </div>
                <div id="result_container">
                    <%@ include file="/WEB-INF/jsp/template/pieces/search/result.jsp" %>
                    <%@ include file="/WEB-INF/jsp/template/pieces/search/result.jsp" %>
                    <%@ include file="/WEB-INF/jsp/template/pieces/search/result.jsp" %>
                    <%@ include file="/WEB-INF/jsp/template/pieces/search/result.jsp" %>
                    <%@ include file="/WEB-INF/jsp/template/pieces/search/result.jsp" %>
                </div>
            </div>
        </div>
    </div>
</div>