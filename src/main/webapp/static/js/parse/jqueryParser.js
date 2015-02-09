/*jshint dojo:true devel:true strict:false*/
/*global define:true */
define([
    'jquery',
    'lodash',
    '../WidgetUtil'
], function (
    $,
    _,
    WidgetUtil
) {

    /**
     * Registry map for widget instances
     *
     * @type {Object}
     */
    var widgetRegistry = {};

    /**
     * Registry map of widget types to their next ID number, to allow for unique IDs
     *
     * @type {Object}
     */
    var idCountRegistry = {};

    var DATA_JQ_TYPE = 'data-jq-type';
    var DATA_JQ_PROPS = 'data-jq-props';
    var DATA_JQ_ID = 'data-jq-id';
    return {

        /**
         * Query for all nodes with a data-jq-type, and instantiate those into widgets.
         */
        parse: function() {

            var allWidgets = $('[' + DATA_JQ_TYPE + ']');

            $.each(allWidgets, function(index, node) {
                node = $('#' + node.id);

                var jqType = node.attr(DATA_JQ_TYPE),
                    jqProps = node.attr(DATA_JQ_PROPS),
                    jqId = node.attr(DATA_JQ_ID),
                    hasCustomId = !_.isEmpty(jqId);

                // Require the data-jq-type as a path to a widget module
                require([jqType], function(widgetObj) {
                    // Keep track of the number of widgets created of the widget type
                    // Ignore if there's a custom ID on the node
                    if (!hasCustomId && !_.isNumber(idCountRegistry[jqType])) {
                        idCountRegistry[jqType] = 0;
                    }

                    // Parse props attribute for passing as config to widget constructor
                    if (jqProps) {
                        jqProps = $.parseJSON('{' + jqProps + '}');
                    } else {
                        jqProps = {};
                    }

                    // Create the unique ID for the widget
                    // Use a custom ID over the default generated one, if a custom ID was set on the node
                    var widgetId = jqId || jqType.replace(/\//g, '_') + '_' + idCountRegistry[jqType];

                    // Check for duplicate IDs in the registry
                    if (!_.isUndefined(widgetRegistry[widgetId])) {
                        throw new Error('jq-parser error: Trying to create a widget with an ID that already exists ' +
                        'in the widget registry! Widget type is "' + jqType + '" and ID is "' + widgetId + '".');
                    }

                    // Create the widget and save it into the widget registry
                    widgetRegistry[widgetId] = WidgetUtil.construct(widgetObj, jqProps);

                    // If the object supplies a 'postCreate' method, call it to set up the object
                    if (widgetObj.hasOwnProperty('postCreate')) {
                        if (_.isFunction(widgetObj.postCreate)) {
                            widgetObj.postCreate();
                        }
                    }

                    // Set non-custom generated ID on the node, and increment the generated ID uniqueness counter
                    if (!hasCustomId) {
                        node.attr(DATA_JQ_ID, widgetId);
                        idCountRegistry[jqType]++;
                    }

                });

            });

        }

    }
});