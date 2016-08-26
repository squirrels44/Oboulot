/**
 * Permet de calculer et d'afficher les itinéraires, d'afficher la map, d'initialiser les options de la map
 * 
 */
var directionsService = new google.maps.DirectionsService(); // service GoogleMaps d'affichage de map et d'itinéraire
var map,geocoder, marker, marker2; // La carte, le service de géocodage et les marqueurs
var depart,arrivee,pointCheck; // point de départ, arrivé et de vérification


//on lance l'initialisation dès le démarrage pour avoir une carte 
init(); 

//récupération des données du Bean Trajet
depart = Trajet.getPointDepart();
arrivee = Trajet.getPointArrivee();
intermediaire = Trajet.getPointIntermediaire();

/*initialise google MAP V3*/
function init() {
	//options d'affichagepar défaut de la ligne qui représente l'itinéraire
	var polyline = new google.maps.Polyline({
		strokeColor: '#C00',
		strokeOpacity: 0.7,
		strokeWeight: 5
	});

	/*gestion des routes - prise en compte de DirectionRenderer (outil routes de GoogleMaps) et association des options*/
	directionsDisplay = new google.maps.DirectionsRenderer();
	directionsDisplay.setOptions({polylineOptions: polyline});

	/*emplacement par défaut de la carte (Nantes)*/
	var maison = new google.maps.LatLng(47.214883, -1.545749);

	/*options par défaut de la carte*/
	var myOptions = {
			  zoom: 11,
			  mapTypeId: google.maps.MapTypeId.ROADMAP,
			  center: maison
	};

	/*creation de la map*/
	map = new google.maps.Map(document.getElementById("div_carte"), myOptions);

	/*connexion de la map*/
	directionsDisplay.setMap(map);

	/*intialise le geocoder pour localiser les adresses */
	geocoder = new google.maps.Geocoder();
}

function trouveRoute() {
	/**
	 * La fonction calcule l'intinéraire puis l'affiche
	 * Appel automatisé dans calculateAndDisplayRoute et calculateAndDisplayRouteWithIntermediate
	 */

	/*test si les variables sont bien initialisés*/
	if (depart && arrivee){
		  var request = {
				    origin:depart,
				    destination:arrivee,
					//waypoints:intermediaire, //les wayPoints sont dans les options disponibles ils représentent des points de passage
				    travelMode: google.maps.DirectionsTravelMode["DRIVING"]
		  };
		  /*appel à l'API Google pour tracer l'itinéraire*/
		  directionsService.route(request, function(response, status) {
			    if (status == google.maps.DirectionsStatus.OK) {
				      directionsDisplay.setDirections(response);
				var monTrajet=response.routes[0] ;
				var point0=monTrajet.overview_path[0];
				var latPoint0=point0.lat(); // Latitude de départ du premier segment
				var longPoint0=point0.lng(); // Longitude de départ du premier segment 
				    }
			  });
	}
}

function calculateAndDisplayRoute(src,src2){
	/**
	 * Fonction qui fait le géocodage des adresses demandées et appelle traceRoute() pour les afficher avec l'itinéraire
	 * Remarque : on appelle trouveRoute() à la fin de chaque géocodage car on ne sait pas quelle requête sera répondue en premier
	 * L'appel à trouveRoute() ne peut pas se faire en dehors du bloc de géocodage car utilise des variables locales
	 */
	//
	if (geocoder) {
		//géocodage de la première adresse
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
				      /*trouve et trace la route*/
				      trouveRoute();
				    }
			  });
		//géocodage de la deuxième adresse
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
				      /*trouve et trace la route*/
				      trouveRoute();
				    }
			  });
	}
}


function calculateAndDisplayRouteWithIntermediate(src,src2, srcInt){
	/**
	 * Fonction qui fait le géocodage des adresses demandées et appelle traceRoute() pour les afficher avec l'itinéraire
	 * Comprends la possibilité d'un point de passage
	 * Remarque : on appelle trouveRoute() à la fin de chaque géocodage car on ne sait pas quelle requête sera répondue en premier
	 * L'appel à trouveRoute() ne peut pas se faire en dehors du bloc de géocodage car utilise des variables locales
	 */
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
		geocoder.geocode( { 'address': document.getElementById(srcInt).value}, function(results, status) {
			    if (status == google.maps.GeocoderStatus.OK) {
				      /*ajoute un marqueur à l'adresse choisie*/
				      if (marker3) { marker3.setMap(null);}
				      marker3 = new google.maps.Marker({
					        map: map,
					        position: results[0].geometry.location
					      });
				      /*on remplace l'adresse par celle fournie du geocoder*/
				        document.getElementById(srcInt).value = results[0].formatted_address;
				      intermediaire = results[0].formatted_address;
				      /*trace la route*/
				      trouveRoute();
				    }
			  });
	}

}
