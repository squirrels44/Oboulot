	<form method="POST" action="formPropositionTrajet">
			<p>Vous pouvez proposer votre trajet via ce formulaire.</p>
			<fieldset >
			<table>
			<tr>
			<td>	<label for="ptdepart">Adresse de départ<span class="requis">*</span></label> 
			</td><td>	<input type="text" id="ptdepart" name="ptdepart" value="${form['ptdepart']}"/><span class="error">${erreurs['ptdepart']}</span><br />
			</td></tr><tr>
			<td>	<label for="ptarrivee">Adresse d'arrivée<span class="requis">*</span></label>
			</td><td>	<input type="text" id="ptarrivee" name="ptarrivee" value="${form['ptarrivee']}" /> <span class="error">${erreurs['ptarrivee']}</span> <br />
			</td></tr><tr>	
			<td>	<label for="ptpassage">Adresse d'un point de passage</label>
			</td><td>	<input type="text" id="ptpassage" name="ptpassage" value="${form['ptpassage']}" /> <span class="error">${erreurs['ptpassage']}</span> <br />
			</td></tr><tr>	
			<td>	<label for="date">Date du trajet<span class="requis">*</span></label>
			</td><td>	<input type="date" id="date" name="date" value="${form['date']}" /> <span class="error">${erreurs['date']}</span> <br />
			</td></tr><tr>	
			<td>	<label for="heure">Heure de départ<span class="requis">*</span></label>
			</td><td>	<input type="time" id="heure" name="heure" value="${form['heure']}" /> <span class="error">${erreurs['heure']}</span> <br />
			</td></tr><tr>
			<td>	<label for="nbplace">Nombre de places disponibles<span class="requis">*</span></label> 
			</td><td>	<input type="number" min="1" max="4" id="nbplace"  name="nbplace" value="${form['nbplace']}" /><br />
			</td></tr>	
			</table>
				
				<label for="fumeur">Fumeur :</label><br />
				<input type="radio" name="fumeur" value="NonFumeur" checked>
				<label for="NonFumeur"><img src="images/logo_non_fumeur.jpg" alt="Non fumeur" /></label>
				<input type="radio" name="fumeur" value="Fumeur">
				<label for="Fumeur"><img src="images/logo_fumeur.jpg" alt="Fumeur" /></label><br />
				
				<label for="musique">Musique :</label>
				<input type="radio" name="musique" value="NonMusique" checked>
				<label for="NonMusique">Sans musique</label>
				<input type="radio" name="musique" value="AvecMusique">
				<label for="AvecMusique">Avec musique</label><br />
				
				<label for="submit"></label> 
				<input type="submit" name="submit" value="Valider mon trajet" />
				<label for="reset"></label> 
				<input type="reset" name="reset" value="Rafraichir" />
			</div>
	</form>