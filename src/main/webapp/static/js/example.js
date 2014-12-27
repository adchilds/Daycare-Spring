/**
 *
 */
define('example', ['jquery', 'jquery-ui'], function ($) {
    return {
        test: null,
        test2: null,

        /**
         *
         */
        postCreate: function() {
            $('#test-index').on('click', function() {
                $('#test-index').appendTo($('#date-picker')).datepicker();
            });
        },

        /**
         *
         */
        test5: function() {
            alert('test');
        }
    }
});