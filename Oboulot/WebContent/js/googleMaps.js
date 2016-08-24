/**
 * Permet de calculer et d'afficher les itinéraires, d'afficher la map, d'initialiser les options de la map
 * 
 */
var directionsService = new google.maps.DirectionsService(); // service GoogleMaps d'affichage de map et d'itinéraire
var map,geocoder, marker, marker2; // La carte, le service de géocodage et les marqueurs
var depart,arrivee,ptCheck; // point de départ, arrivé et de vérification

init(); // on lance l'initialisation au départ pour avoir une carte 

/*initialise google MAP V3*/
function init() {
    var polyline = new google.maps.Polyline({
        strokeColor: '#C00',
        strokeOpacity: 0.7,
        strokeWeight: 5
        });
    
    /*gestion des routes*/
    directionsDisplay = new google.maps.DirectionsRenderer();
    directionsDisplay.setOptions({polylineOptions: polyline});
    
    /*emplacement par défaut de la carte (Nantes)*/
    var maison = new google.maps.LatLng(47.214883, -1.545749);
    
    /*option par défaut de la carte*/
    var myOptions = {
      zoom: 11,
      mapTypeId: google.maps.MapTypeId.ROADMAP,
      center: maison
    };
    
    /*creation de la map*/
    map = new google.maps.Map(document.getElementById("div_carte"), myOptions);
    
    /*connexion de la map + le panneau de l'itinéraire*/
    directionsDisplay.setMap(map);
//    directionsDisplay.setPanel(document.getElementById("divRoute"));
    
    /*intialise le geocoder pour localiser les adresses */
    geocoder = new google.maps.Geocoder();
}

function trouveRoute() {
    /*test si les variables sont bien initialisés*/
    if (depart && arrivee){
      var request = {
        origin:depart,
        destination:arrivee,
        travelMode: google.maps.DirectionsTravelMode["DRIVING"]
      };
      /*appel à l'API pour tracer l'itinéraire*/
      directionsService.route(request, function(response, status) {
        if (status == google.maps.DirectionsStatus.OK) {
          directionsDisplay.setDirections(response);
        }
      });
    }
}

function calculateAndDisplayRoute(src,src2){
    // ptCheck = code; /*adresse de départ ou arrivée ? */
    if (geocoder) {
      geocoder.geocode( { 'address': document.getElementById(src).value}, function(results, status) {
        if (status == google.maps.GeocoderStatus.OK) {
          /*ajoute un marqueur à l'adresse choisie*/
          map.setCenter(results[0].geometry.location);
          if (marker) { marker.setMap(null);}
            marker = new google.maps.Marker({
            map: map,
            position: results[0].geometry.location
          });
          /*on remplace l'adresse par celle fournie du geocoder*/
          document.getElementById(src).value = results[0].formatted_address;
          depart = results[0].formatted_address;
          /*trace la route*/
          trouveRoute();
        }
      });
      geocoder.geocode( { 'address': document.getElementById(src2).value}, function(results, status) {
        if (status == google.maps.GeocoderStatus.OK) {
          /*ajoute un marqueur à l'adresse choisie*/
          if (marker2) { marker2.setMap(null);}
          marker2 = new google.maps.Marker({
            map: map,
            position: results[0].geometry.location
          });
          /*on remplace l'adresse par celle fournie du geocoder*/
            document.getElementById(src2).value = results[0].formatted_address;
          arrivee = results[0].formatted_address;
          /*trace la route*/
          trouveRoute();
        }
      });
    }
}