define('Dialog', [
    'jquery'
], function (
    $
) {

    /**
     *
     *
     * @author Adam Childs
     */
    return {
        domNode: null,
        draggable: true,
        title: 'Lorem Ipsum',
        type: 'info',
        modal: false,
        resizable: false,

        /**
         * Initializes the widget via the jqueryParser widget.
         */
        postCreate: function() {
            $(this.domNode).dialog({
                draggable: this.draggable,
                modal: this.modal,
                resizable: this.resizable,
                title: this.title
            });
        }
    }
});