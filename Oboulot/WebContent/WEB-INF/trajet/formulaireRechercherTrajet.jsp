	<form method="POST" action="formRechercheTrajet">
			<p>Vous pouvez rechercher un trajet via ce formulaire.</p>
			<fieldset >
			<table>
			<tr>
			<td>	<label for="ptdepart">Adresse de départ<span class="requis">*</span></label> 
			</td><td>	<input type="text" id="ptdepart" name="ptdepart" value="${form['ptdepart']}"/><span class="error">${erreurs['ptdepart']}</span><br />
			</td></tr><tr>
			<td>	<label for="ptarrivee">Adresse d'arrivée<span class="requis">*</span></label>
			</td><td>	<input type="text" id="ptarrivee" name="ptarrivee" value="${form['ptarrivee']}" /> <span class="error">${erreurs['ptarrivee']}</span> <br />
			</td></tr><tr>	
			<td>	<label for="date">Date du trajet<span class="requis">*</span></label>
			</td><td>	<input type="date" id="date" name="date" value="${form['date']}" /> <span class="error">${erreurs['date']}</span> <br />
			</td></tr><tr>	
			<td>	<label for="heure">Heure de départ</label>
			</td><td>	<input type="time" id="heure" name="heure" value="${form['heure']}" /> <span class="error">${erreurs['heure']}</span> <br />
			</td></tr>	
			</table>
				
				<label for="fumeur">Préférences :</label><br />
				<input type="radio" id="fumeur" name="fumeur" value="NonFumeur" >
				<label for="NonFumeur"><img src="images/logo_non_fumeur.jpg" alt="Non fumeur" /></label>
				<input type="radio" id="fumeur" name="fumeur" value="Fumeur">
				<label for="Fumeur"><img src="images/logo_fumeur.jpg" alt="Fumeur" /></label><br />
				
				<input type="radio" id="musique" name="musique" value="NonMusique" >
				<label for="NonMusique">Sans musique</label>
				<input type="radio" id="musique" name="musique" value="AvecMusique">
				<label for="AvecMusique">Avec musique</label><br />
				
				<label for="submit"></label> 
				<input type="submit" id="submit" name="submit" value="Rechercher un trajet" />
				<label for="reset"></label> 
				<input type="reset" id="reset" name="reset" value="Rafraichir" />
			</fieldset>
	</form>