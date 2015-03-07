define('SortSelector', [
    'jquery'
], function(
    $
) {

    /**
     *
     *
     * @author Adam Childs
     */
    return {
        domNode: null,

        postCreate: function() {
            $(this.domNode).on('click', this.toggleOptionsView)
        },

        /**
         * Toggles the visibility of the select boxes options.
         */
        toggleOptionsView: function() {
            var options = $('#options', this.domNode);

            if (options.is(':visible')) {
                options.hide();
            } else {
                options.show();
            }
        }
    }
});