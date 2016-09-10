(function ($) {

    var CATEGORY_PANEL_WIDTH = 80;
    var DATA_PANEL_WIDTH = 302;
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
        $(".panel-content", "#DataPanel").children().remove();
    }

    function loadMissingPersons()
    {
        clearUI();

        $.get("/MissingPersons/List", function (response) {
            $.each(response, function (index, item) {

                var itemUI = $("<div />").addClass("data-listing").height(48);

                if (item.picture != null)
                    $("<img />").attr("src", "/images/data/missing/" + item.picture).css({float:"left"}).width(48).height(48).appendTo(itemUI);
                else
                    $("<img />").attr("src", "").css({ float: "left" }).width(48).height(48).appendTo(itemUI);

                var content = $("<div />").addClass("content").appendTo(itemUI);

                content.append($("<div />").addClass("title").html(item.name));

                $(".panel-content", "#DataPanel").append(itemUI);

            });
        });
    }

    function loadWantedPersons() {
        clearUI();

        $.get("/WantedPersons/List", function (response) {
            $.each(response, function (index, item) {

                var itemUI = $("<div />").addClass("data-listing").height(48);

                if (item.picture != null)
                    $("<img />").attr("src", "/images/data/wanted/" + item.picture).css({ float: "left" }).width(48).height(48).appendTo(itemUI);
                else
                    $("<img />").attr("src", "").css({ float: "left" }).width(48).height(48).appendTo(itemUI);

                var content = $("<div />").addClass("content").appendTo(itemUI);

                content.append($("<div />").addClass("title").html(item.name));

                $(".panel-content", "#DataPanel").append(itemUI);

            });
        });
    }

    function loadStolenVehicles()
    {
        clearUI();

        $.get("/StolenVehicles/List", function (response) {
            $.each(response, function (index, item) {

                var itemUI = $("<div />").addClass("data-listing").height(48);

                var content = $("<div />").addClass("content").appendTo(itemUI);

                content.append($("<div />").addClass("title").html(item.plateNumber));

                $(".panel-content", "#DataPanel").append(itemUI);

            });
        });
    }

    function loadStolenPlates()
    {
        clearUI();

        $.get("/StolenPlates/List", function (response) {
            $.each(response, function (index, item) {

                var itemUI = $("<div />").addClass("data-listing").height(48);

                var content = $("<div />").addClass("content").appendTo(itemUI);

                content.append($("<div />").addClass("title").html(item.plateNumber));

                $(".panel-content", "#DataPanel").append(itemUI);

            });
        });
    }

    $(document).ready(function () {
        refreshUI();

        $("#ButtonWantedPersons").on("click", function () {
            $(this).addClass("active").parent().children().not(this).removeClass("active");

            loadWantedPersons();
        });

        $("#ButtonMissingPersons").on("click", function () {
            $(this).addClass("active").parent().children().not(this).removeClass("active");

            loadMissingPersons();
        });

        $("#ButtonStolenVehicles").on("click", function () {
            $(this).addClass("active").parent().children().not(this).removeClass("active");

            loadStolenVehicles();
        });

        $("#ButtonStolenPlates").on("click", function () {
            $(this).addClass("active").parent().children().not(this).removeClass("active");

            loadStolenPlates();
        });

    }).on("click", ".data-listing", function () {

        var self = $(this);

        $(".data-listing", $(".panel-content", "#DataPanel")).removeClass("active");
        self.addClass("active");
    });

    $(window).resize(function () {
        refreshUI();
    });


}(jQuery));