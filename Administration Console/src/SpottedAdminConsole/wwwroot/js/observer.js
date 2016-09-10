(function ($) {

    var windowHeight = 0;
    var windowWidth = 0;

    function refreshUI()
    {
        windowHeight = $(window).height();
        windowWidth = $(window).width();

        $(".panel").height(windowHeight);

        $("#CategoryPanel").width(64).css({left: 0, top: 0});
        $("#DataPanel").width(256).css({ left: 64, top: 0 });
        $("#MapPanel").width(windowWidth - 256 - 64).css({ left: 320, top: 0 });;
    }

    $(document).ready(function () {


        refreshUI();
    })

    $(window).resize(function () {
        refreshUI();
    });


}(jQuery));