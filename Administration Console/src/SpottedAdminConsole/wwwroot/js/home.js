(function ($) {

    $(document).ready(function () {

        $(".button-container").height($(window).height()).width($(window).width());

    });

    $(window).resize(function () {

        $(".button-container").height($(window).height()).width($(window).width());

    });


}(jQuery));