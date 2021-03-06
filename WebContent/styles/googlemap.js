
var panorama;

function initMap() {
    var astorPlace = {lat: 25.052384, lng: 121.554554};
     //25.052384,121.554554
    // Set up the map
    var map = new google.maps.Map(document.getElementById('map'), {
                                  center: astorPlace,
                                  zoom: 19,
                                  streetViewControl: false
                                  });
    
    // Set up the markers on the map
    var cafeMarker = new google.maps.Marker({
                                            position: {lat: 25.052384, lng: 121.554554},
                                            map: map,
                                            icon: 'http://chart.apis.google.com/chart?chst=d_map_pin_icon&chld=cafe|FFFF00',
                                            title: 'Cafe'
                                            });
    
     
    // We get the map's default panorama and set up some defaults.
    // Note that we don't yet set it visible.
    panorama = map.getStreetView();
    panorama.setPosition(astorPlace);
    panorama.setPov(/** @type {google.maps.StreetViewPov} */({
                                                             heading: 265,
                                                             pitch: 0
                                                             }));
}

function toggleStreetView() {
    var toggle = panorama.getVisible();
    if (toggle == false) {
        panorama.setVisible(true);
    } else {
        panorama.setVisible(false);
    }
}




