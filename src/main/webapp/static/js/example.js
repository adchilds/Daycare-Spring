/**
 *
 */
define('example', ['jquery', 'jquery-ui'], function ($) {

    var DATEPICKER_ID = '.ui-datepicker';
    var CALENDAR_BUTTON_ID = '#calendar-button';
    var CALENDAR_ID = '#calendar';

    return {
        test: null,
        test2: null,

        /**
         *
         */
        postCreate: function() {
            $(CALENDAR_ID).datepicker();

            $(DATEPICKER_ID).hide();

            $(CALENDAR_BUTTON_ID).on('click', this._toggle);
        },

        /**
         *
         */
        _toggle: function() {
            var datePicker = $(DATEPICKER_ID);

            if (datePicker.is(':visible')) {
                datePicker.hide();
            } else {
                datePicker.show();
            }
        },

        /**
         *
         */
        test5: function() {
            alert('test');
        }
    }
});