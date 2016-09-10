(function ($) {

    var CATEGORY_PANEL_WIDTH = 64;
    var DATA_PANEL_WIDTH = 256;
    var CONTROLS_BAR_HEIGHT = 64;

    var windowHeight = 0;
    var windowWidth = 0;


    function refreshUI()
    {
        windowHeight = $(window).height() - 2;
        windowWidth = $(window).width() - 2;

        $(".panel-header").height(CONTROLS_BAR_HEIGHT);
        $(".panel-content").height(windowHeight - CONTROLS_BAR_HEIGHT);
        $(".panel").height(windowHeight);

        $("#CategoryPanel").width(CATEGORY_PANEL_WIDTH).css({ left: 0, top: 0 });
        $("#DataPanel").width(DATA_PANEL_WIDTH).css({ left: CATEGORY_PANEL_WIDTH, top: 0 });
        $("#MapPanel").width(windowWidth - DATA_PANEL_WIDTH - CATEGORY_PANEL_WIDTH).css({ left: CATEGORY_PANEL_WIDTH + DATA_PANEL_WIDTH, top: 0 });
    }

    function clearUI()
    {

    }


    function loadMissingPersons()
    {
        clearUI();

        $.get("/MissingPersons/List", function (response) {

            $.each(response, function (index, item) {


            });

        });
    }


    $(document).ready(function () {
        refreshUI();

        $("#ButtonWantedPersons").on("click", function () {
            alert("1");
        });

        $("#ButtonMissingPersons").on("click", function () {
            loadMissingPersons();
        });

        $("#ButtonStolenVehicles").on("click", function () {
            alert("3");
        });

        $("#ButtonStolenPlates").on("click", function () {
            alert("4");
        });

    })

    $(window).resize(function () {
        refreshUI();
    });


}(jQuery));