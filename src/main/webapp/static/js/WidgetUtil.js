/**
 * Defines useful functions for dealing with 'Widgets'.
 *
 * @author Adam Childs
 */
define('WidgetUtil', [], function () {
    return {

        /**
         * Loops over the given {@code props} which should be an object of properties taken from the DOM, specified via
         * the 'data-jq-props' custom attribute in conjunction with the 'data-jq-type' attribute.
         *
         * @param obj the object to set the given props on (if possible)
         * @param props the properties (formatted as an object built from JSON) to set on the object (if possible)
         * @return a newly constructed object with the given props set on it.
         */
        construct: function(obj, props) {
            if (_.isObject(props)) {
                for (var jsonProperty in props) {
                    if (obj.hasOwnProperty(jsonProperty)) {
                        obj[jsonProperty] = props[jsonProperty];
                    }
                }
            }

            return obj;
        }
    }
});