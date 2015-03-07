<%@ include file="/WEB-INF/jsp/template/pieces/taglibs.jsp" %>

<div id="daycare_logo">
    <div class="image">
        <%@ include file="/WEB-INF/jsp/svg/logo.jsp" %>
    </div>
    <span class="text">
        Daycare Management System
    </span>
</div>

<div id="page_container">
    <div id="top_section">
        Top Section

        <div id="start-date">
            <button id="calendar-button" data-jq-type="example" data-jq-props=''>Choose date</button>
            <div id="calendar"></div>
        </div>

        <div id="dialog" data-jq-type="Dialog" data-jq-props='
            "draggable":false,
            "title":"Test Title",
            "type":"info",
            "modal":true
        '>
            <p>This is the default dialog which is useful for displaying information. The dialog window can be moved, resized and closed with the 'x' icon.</p>
        </div>
    </div>

    <div id="top_middle_section">
        Top Middle Section
    </div>

    <div id="top_bottom_section">
        Top Bottom Section
    </div>

    <div id="bottom_section">
        Bottom Section
    </div>
</div>