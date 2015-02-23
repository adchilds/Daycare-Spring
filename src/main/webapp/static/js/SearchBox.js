define([
    'jquery'
], function (
    $
) {

    /**
     * The SVGDecoder Replace all SVG images with inline SVG
     */
    return {
        domNode: null,

        /**
         *
         */
        postCreate: function() {
            $('input', this.domNode).keyup(this.domNode, this.onKeyStroke);
            $('svg', this.domNode).click(this.domNode, this.onClick);
        },

        /**
         *
         */
        onClick: function(event) {
            var node = event.data;
            var input = $('input', node);

            // Remove the close button
            node.removeClass('has_content');

            // Remove all text from the input
            input.val('');
        },

        /**
         *
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