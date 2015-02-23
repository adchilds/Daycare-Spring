define([
    'jquery',
    'lodash'
], function (
    $,
    _
) {

    /**
     * The SVGDecoder replaces all SVG images with inline SVG tags and content. This allows us to target the SVG
     * directly with styling, whereas we wouldn't be able to if we loaded the SVGs via the css background property.
     */
    return {

        decodeAll: function() {
            $('img.svg').each(function() {
                var $img = $(this);
                var imgID = $img.attr('id');
                var imgClass = $img.attr('class');
                var imgURL = $img.attr('src');

                $.get(imgURL, function(data) {
                    // Get the SVG tag, ignore the rest
                    var $svg = $(data).find('svg');

                    // Add replaced image's ID to the new SVG
                    if (!_.isUndefined(typeof imgID)) {
                        $svg = $svg.attr('id', imgID);
                    }

                    // Add replaced image's classes to the new SVG
                    if (!_.isUndefined(typeof imgClass)) {
                        $svg = $svg.attr('class', imgClass+' replaced-svg');
                    }

                    // Remove any invalid XML tags as per http://validator.w3.org
                    $svg = $svg.removeAttr('xmlns:a');

                    // Replace image with new SVG
                    $img.replaceWith($svg);

                }, 'xml');
            });
        }
    }
});