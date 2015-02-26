define('SearchBox', [
    'jquery'
], function (
    $
) {

    /**
     * Provides extra functionality for an HTML input component to make it react more like a search text box.
     *
     * @author Adam Childs
     */
    return {
        domNode: null,

        /**
         * Initializes the widget via the jqueryParser widget.
         */
        postCreate: function() {
            $('input', this.domNode).keyup(this.domNode, this.onKeyStroke);
            $('div#clear_button', this.domNode).click(this.domNode, this.clearContent);
        },

        /**
         * Removes the textual content from the HTML input element and also hides the clear button.
         */
        clearContent: function(event) {
            var node = event.data;
            var input = $('input', node);

            // Remove all text from the input
            input.val('');

            // Remove the close button
            node.removeClass('has_content');
        },

        /**
         * Handles key stroke events (when a user is typing in the HTML input element)
         */
        onKeyStroke: function(event) {
            var node = event.data;
            var input = $('input', node);
            var inputLength = input.val().length;

            if ((inputLength > 0) && (!input.hasClass('has_content'))) {
                node.addClass('has_content');
            } else if (inputLength <= 0) {
                node.removeClass('has_content');
            }
        }
    }
});