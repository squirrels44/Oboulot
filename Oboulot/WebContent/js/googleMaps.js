/**
 * Permet de calculer et d'afficher les itinéraires, d'afficher la map, d'initialiser les options de la map
 * 
 */
var directionsService = new google.maps.DirectionsService(); // service GoogleMaps d'affichage de map et d'itinéraire
var map,geocoder, marker, marker2; // La carte, le service de géocodage et les marqueurs
var depart,arrivee,ptCheck; // point de départ, arrivé et de vérification



init(); // on lance l'initialisation au départ pour avoir une carte 
depart = Trajet.getPtdepart();
arrivee = Trajet.getPtarrivee();
intermediaire = Trajet.getPtintermediaire();

waypts=new Array(intermediaire);

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
//	directionsDisplay.setPanel(document.getElementById("divRoute"));

	/*intialise le geocoder pour localiser les adresses */
	geocoder = new google.maps.Geocoder();
}

function trouveRoute() {
	/*test si les variables sont bien initialisés*/


	if (depart && arrivee){
		  var request = {
				    origin:depart,
				    destination:arrivee,
				//waypoints:waypts,
				    travelMode: google.maps.DirectionsTravelMode["DRIVING"]
		  };
		  /*appel à l'API pour tracer l'itinéraire*/
		  directionsService.route(request, function(response, status) {
			    if (status == google.maps.DirectionsStatus.OK) {
				      directionsDisplay.setDirections(response);
				      var monTrajet=response.routes[0] ;
				      var point0=monTrajet.overview_path[0];// Position (J:, M:)
				      var latPoint0=point0.lat(); // Latitude de départ du premier segment
				      var longPoint0=point0.lng(); // Longitude de départ du premier segment 
				    }
			  });
	}
}

function calculateAndDisplayRoute(src,src2){
//	var waypts = [];
//	if (geocoder) {
//	  geocoder.geocode( { 'address': document.getElementById(srcInt).value}, function(results, status) {
//	    if (status == google.maps.GeocoderStatus.OK) {
//	      /*ajoute un marqueur à l'adresse choisie*/
//	      map.setCenter(results[0].geometry.location);
//	      if (marker) { marker.setMap(null);}
//	        marker = new google.maps.Marker({
//	        map: map,
//	        position: results[0].geometry.location
//	      });

//	var checkboxArray = document.getElementById(srcInt).value;

//	waypts.push({
//	location: document.getElementById(srcInt).value,
//	stopover: true
//	});
//	}
//	}	
//	}
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


//function calculateAndDisplayRouteWithIntermediate(src,src2, srcInt){
//// ptCheck = code; /*adresse de départ ou arrivée ? */
//if (geocoder) {
//  geocoder.geocode( { 'address': document.getElementById(src).value}, function(results, status) {
//    if (status == google.maps.GeocoderStatus.OK) {
//      /*ajoute un marqueur à l'adresse choisie*/
//      map.setCenter(results[0].geometry.location);
//      if (marker) { marker.setMap(null);}
//        marker = new google.maps.Marker({
//        map: map,
//        position: results[0].geometry.location
//      });
//      /*on remplace l'adresse par celle fournie du geocoder*/
//      document.getElementById(src).value = results[0].formatted_address;
//      depart = results[0].formatted_address;
//      /*trace la route*/
//      trouveRoute();
//    }
//  });
//  geocoder.geocode( { 'address': document.getElementById(src2).value}, function(results, status) {
//    if (status == google.maps.GeocoderStatus.OK) {
//      /*ajoute un marqueur à l'adresse choisie*/
//      if (marker2) { marker2.setMap(null);}
//      marker2 = new google.maps.Marker({
//        map: map,
//        position: results[0].geometry.location
//      });
//      /*on remplace l'adresse par celle fournie du geocoder*/
//        document.getElementById(src2).value = results[0].formatted_address;
//      arrivee = results[0].formatted_address;
//      /*trace la route*/
//      trouveRoute();
//    }
//  });
//geocoder.geocode( { 'address': document.getElementById(srcInt).value}, function(results, status) {
//    if (status == google.maps.GeocoderStatus.OK) {
//      /*ajoute un marqueur à l'adresse choisie*/
//      if (marker3) { marker3.setMap(null);}
//      marker3 = new google.maps.Marker({
//        map: map,
//        position: results[0].geometry.location
//      });
//      /*on remplace l'adresse par celle fournie du geocoder*/
//        document.getElementById(srcInt).value = results[0].formatted_address;
//      intermediaire = results[0].formatted_address;
//      /*trace la route*/
//      trouveRoute();
//    }
//  });
//   }

//}

/////////////////////détermination des coordonnées///////////////////////////////////
if (navigator.geolocation)
{

	function affichePosition(position)
	{
		var infopos = "Position déterminée : <br>";
		infopos += "Latitude : "+position.coords.latitude +"<br>";
		infopos += "Longitude: "+position.coords.longitude+"<br>";
		document.getElementById("maposition").innerHTML = infopos;
		

		var latlng = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);					//recuperation coordonnée gps

		var marker = new google.maps.Marker({
			position: latlng,
			map: map,
			title:"Vous êtes ici"
		});
		map.panTo(latlng);
	}
	var origin1 = new google.maps.LatLng(-18.903906,47.522092 );

	var image = {
			url: 'imag/logo.png',

			size: new google.maps.Size(40, 40),

			origin: new google.maps.Point(0,0),

			anchor: new google.maps.Point(0, 0)
	};
	var originIcon = 'https://chart.googleapis.com/chart?chst=d_map_pin_letter&chld=O|FFFF00|000000';



	function calculateDistances() {
		var service = new google.maps.DistanceMatrixService();
		service.getDistanceMatrix(
				{
					origins: [origin1],
					destinations: [intermediaire, arrivee],
					travelMode: google.maps.TravelMode.DRIVING,
					unitSystem: google.maps.UnitSystem.METRIC,
					avoidHighways: false,
					avoidTolls: false
				}, callback);
	}
	function callback(response, status) {
		if (status != google.maps.DistanceMatrixStatus.OK) {
			alert('Error was: ' + status);
		} else {
			var origins = response.originAddresses;
			var destinations = response.destinationAddresses;
			var outputDiv = document.getElementById('outputDiv');

			outputDiv.innerHTML = '';
			deleteOverlays();

			for (var i = 0; i < origins.length; i++) {
				var results = response.rows[i].elements;


				recuperation = response.rows[i].elements;

				addMarker(origins[i], false);
				for (var j = 0; j < results.length; j++) {
					addMarker(destinations[j], true);
					outputDiv.innerHTML += origins[i] + ' -> ' + destinations[j]
					+ ': ' + results[j].distance.text + ' en '
					+ results[j].duration.text + '<br>';
				}
			}
		}
	}
}