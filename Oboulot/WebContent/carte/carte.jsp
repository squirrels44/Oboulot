<div>
	<table>
		<tr>
			<td><b>D�part: </b></td>
			<td><input type="text" id="adrDep" value=""style="width: 300px;"></td> <!--  -->
		</tr>
		<tr>
			<td><b>Arriv�e: </b></td>
			<td><input type="text" id="adrArr" value="" style="width: 300px;"></td>
			<td><input type="button" value="Recherche" onclick="calculateAndDisplayRoute('adrDep','adrArr')"></td>
		</tr>
	</table>
</div>
<div id="div_carte" style=" width: 100%; height: 100%; overflow: hidden;"></div> <!-- propri�t� de la div d'affichage de la carte -->
<!-- <div id="divRoute" style="float: right; width: 30%;height:80%;"></div> -->
<br /> <!-- scripts charg�s apr�s les proprietes (div) des fenetres de map  -->
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBYBslB29hWy9uPJJgawf8Y3VX690IC9Bc" type="text/javascript"></script> <!-- chargement de la carte googleMap -->
<script type="text/javascript" src="js/googleMaps.js"></script> <!-- chargement du js de gestion de la map -->
