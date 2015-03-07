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
    },

    "packages": [
        {
            name: "svg",
            location: "/com/adamchilds/daycare"
        }
    ]

});

require([
    /*
     * Util scripts
     */
    'WidgetUtil',

    /*
     * DOM Parsers
     */
    'parse/jqueryParser',
    'parse/SVGDecoder',

    /*
     * Third-party libraries
     */
    'jquery', 'jquery-ui', 'jquery-ui',
    'lodash',

    /*
     * App scripts
     */
    'example',
    'SearchBox',
    'SortSelector'

], function (widgetUtil, jqueryParser, svgDecoder) {
    $(document).ready(function () {
        // Convert all SVG images to svg tags
        svgDecoder.decodeAll();

        // Parse the DOM for widgets
        jqueryParser.parse();
    });
});