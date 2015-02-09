/**
 *
 */
requirejs.config({

    /*
     * Default base URL
     */
    baseUrl: '/static/js',

    /*
     * Defines a Module ID for any modules found in nested directories (relative to base URL)
     */
    paths: {
        // Third-party scripts
        jquery: 'third-party/jquery-2.1.3.min',
        'jquery-ui': 'third-party/jquery-ui.min',
        lodash: 'third-party/lodash.min'
    }

});

require([
    /*
     * Util scripts
     */
    'WidgetUtil',

    /*
     * DOM Parsers
     */
    'parser/jqueryParser',

    /*
     * Third-party libraries
     */
    'jquery', 'jquery-ui', 'jquery-ui',
    'lodash',

    /*
     * App scripts
     */
    'example'

], function (widgetUtil, jqueryParser) {
    $(document).ready(function () {
        jqueryParser.parse();
    });
});