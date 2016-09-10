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
        $(".map").map("clearMarkers")
        $(".panel-content", "#DataPanel").children().remove();
    }

    function loadMissingPersons()
    {
        clearUI();

        $.get("/MissingPersons/List", function (response) {
            $.each(response, function (index, item) {

                var itemUI = $("<div />").attr({
                    "data-custom-id": item.id,
                    "data-custom-type": "MissingPerson"
                }).addClass("data-listing");

                if (item.picture != null)
                    $("<img />").attr("src", "/images/data/missing/" + item.picture).appendTo(itemUI);
                else
                    $("<img />").addClass("picture-missing").attr("src", "/images/data/noImageGrey.png").appendTo(itemUI);

                var content = $("<div />").addClass("content").appendTo(itemUI);

                content.append($("<div />").addClass("title").html(item.name));

                $(".panel-content", "#DataPanel").append(itemUI);

            });

            $(".data-listing:first", "#DataPanel").trigger("click");
        });
    }

    function loadWantedPersons() {
        clearUI();

        $.get("/WantedPersons/List", function (response) {
            $.each(response, function (index, item) {

                var itemUI = $("<div />").attr({
                    "data-custom-id": item.id,
                    "data-custom-type": "WantedPerson"
                }).addClass("data-listing");

                if (item.picture != null)
                    $("<img />").attr("src", "/images/data/wanted/" + item.picture).appendTo(itemUI);
                else
                    $("<img />").addClass("picture-missing").attr("src", "/images/data/noImageGrey.png").appendTo(itemUI);

                var content = $("<div />").addClass("content").appendTo(itemUI);

                content.append($("<div />").addClass("title").html(item.name));

                $(".panel-content", "#DataPanel").append(itemUI);

            });

            $(".data-listing:first", "#DataPanel").trigger("click");
        });
    }

    function loadStolenVehicles()
    {
        clearUI();

        $.get("/StolenVehicles/List", function (response) {
            $.each(response, function (index, item) {

                var itemUI = $("<div />").attr({
                    "data-custom-id": item.id,
                    "data-custom-type": "StolenVehicle"
                }).addClass("data-listing").height(48);

                var content = $("<div />").addClass("content").appendTo(itemUI);

                content.append($("<div />").addClass("title").html(item.plateNumber));

                $(".panel-content", "#DataPanel").append(itemUI);

            });

            $(".data-listing:first", "#DataPanel").trigger("click");
        });
    }

    function loadStolenPlates()
    {
        clearUI();

        $.get("/StolenPlates/List", function (response) {
            $.each(response, function (index, item) {

                var itemUI = $("<div />").attr({
                    "data-custom-id": item.id,
                    "data-custom-type": "StolenPlate"
                }).addClass("data-listing").height(48);

                var content = $("<div />").addClass("content").appendTo(itemUI);

                content.append($("<div />").addClass("title").html(item.plateNumber));

                $(".panel-content", "#DataPanel").append(itemUI);

            });

            $(".data-listing:first", "#DataPanel").trigger("click");
        });
    }

    function processReports(reportData) {
        $(".map").map("clearMarkers").map("addMarkers", reportData);
    }

    $(document).ready(function () {
        refreshUI();

        $("#ButtonWantedPersons").on("click", function () {
            $(this).addClass("active").parent().children().not(this).removeClass("active");

            loadWantedPersons();
        }).trigger("click");

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

        var id = self.attr("data-custom-id");
        var type = self.attr("data-custom-type");

        switch(type)
        {
            case "MissingPerson":
                {
                    $.get("/api/MissingPersons/ReportList/" + id, processReports);

                    break;
                }
            case "WantedPerson":
                {
                    $.get("/api/WantedPersons/ReportList/" + id, processReports);

                    break;
                }
            case "StolenVehicle":
                {
                    $.get("/api/StolenVehicles/ReportList/" + id, processReports);

                    break;
                }
            case "StolenPlate":
                {
                    $.get("/api/StolenPlates/ReportList/" + id, processReports);

                    break;
                }
        }

        self.addClass("active");

        $(".data-listing:not(.active) img.picture-missing", $(".panel-content", "#DataPanel")).attr("src", "/images/data/noImageGrey.png");
        $(".data-listing.active img.picture-missing", $(".panel-content", "#DataPanel")).attr("src", "/images/data/noImageWhite.png");
    });

    $(window).resize(function () {
        refreshUI();
    });


}(jQuery));