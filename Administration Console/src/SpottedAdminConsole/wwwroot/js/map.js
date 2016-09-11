function initializeMaps()
{
    $(".map").map({});
}

(function ($) {

    // Adds a marker to the map and push to the array.
    function addMarker(mapContainer, report) {

        var map = mapContainer.data("map");
        var markers = mapContainer.data("markers");

        var marker = new google.maps.Marker({
            position: { lat: report.latitude, lng: report.longitude },
            map: map,
            animation: google.maps.Animation.DROP
        });

        var infowindow = new google.maps.InfoWindow({
            content: report.description,
            maxWidth: 200
        });

        marker.addListener('click', function () {
            infowindow.open(map, marker);
        });

        markers.push(marker);

        mapContainer.data("markers", markers);
    }

    function setLocation(mapContainer, report)
    {
        var map = mapContainer.data("map");

        map.setCenter(new google.maps.LatLng(report.latitude, report.longitude), map.getZoom());
    }

    $.fn.map = function (params, option, value) {

        if (typeof (params) === "string")
        {
            var self = $(this);
            
            if (params === "addMarker")
            {
                addMarker(self, option);

                setLocation(self, option);
            }
            else if (params === "addMarkers") {
                $.each(option, function(index, marker) {
                    addMarker(self, marker);
                });

                if (option.length > 0)
                    setLocation(self, option[0]);
            }
            else if (params === "clearMarkers")
            {
                var markers = self.data("markers");
                $.each(markers, function(index, marker) {
                    marker.setMap(null);
                });

                self.data("markers", []);
            }

            return self;
        }


        return this.each(function () {
            var self = $(this);

            var cyprus = { lat: 35.1264, lng: 33.4299 };

            map = new google.maps.Map(self[0], {
                zoom: 10,
                center: cyprus
            });

            self.data("map", map);
            self.data("markers", []);
        });
    };


}(jQuery))