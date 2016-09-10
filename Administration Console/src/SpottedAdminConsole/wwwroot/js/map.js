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

        /*var contentString = '<div id="content">' +
            '<div id="siteNotice">' +
            '</div>' +
            '<h1 id="firstHeading" class="firstHeading">Uluru</h1>' +
            '<div id="bodyContent">' +
            '<p><b>Uluru</b>, also referred to as <b>Ayers Rock</b>, is a large ' +
            'sandstone rock formation in the southern part of the ' +
            'Northern Territory, central Australia. It lies 335&#160;km (208&#160;mi) ' +
            'south west of the nearest large town, Alice Springs; 450&#160;km ' +
            '(280&#160;mi) by road. Kata Tjuta and Uluru are the two major ' +
            'features of the Uluru - Kata Tjuta National Park. Uluru is ' +
            'sacred to the Pitjantjatjara and Yankunytjatjara, the ' +
            'Aboriginal people of the area. It has many springs, waterholes, ' +
            'rock caves and ancient paintings. Uluru is listed as a World ' +
            'Heritage Site.</p>' +
            '<p>Attribution: Uluru, <a href="https://en.wikipedia.org/w/index.php?title=Uluru&oldid=297882194">' +
            'https://en.wikipedia.org/w/index.php?title=Uluru</a> ' +
            '(last visited June 22, 2009).</p>' +
            '</div>' +
            '</div>' +
            '<img src="chihuahua.jpg" alt="Mountain View" style="width:304px;height:228px;">'; */

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

    $.fn.map = function (params, option, value) {

        if (typeof (params) === "string")
        {
            var self = $(this);
            
            if (params === "addMarker")
            {
                addMarker(self, option);
            }
            else if (params === "addMarkers") {
                $.each(option, function(index, marker) {
                    addMarker(self, marker);
                });
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
                center: cyprus,
                mapTypeId: 'terrain'
            });

            self.data("map", map);
            self.data("markers", []);
        });
    };


}(jQuery))