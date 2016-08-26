<form method="POST" action="formRechercheTrajet">
	<div class="form-group">
		<label for="ptdepart">Adresse de départ<span class="requis">*</span></label> 
		<div class="col-sm-6">
			<input type="text" id="ptdepart" name="ptdepart" onBlur="calculateAndDisplayRoute('ptdepart','ptarrivee')" value="${form['ptdepart']}"/><span class="error">${erreurs['ptdepart']}</span><br />
		</div>
	</div>
	<br />
	<div class="form-group">
		<label for="ptarrivee">Adresse d'arrivée<span class="requis">*</span></label>
		<div class="col-sm-6">
			<input type="text" id="ptarrivee" name="ptarrivee" onBlur="calculateAndDisplayRoute('ptdepart','ptarrivee')" value="${form['ptarrivee']}" /> <span class="error">${erreurs['ptarrivee']}</span> <br />
		</div>
	</div>
	<br />
	<div class="form-group">	
		<label for="date">Date du trajet<span class="requis">*</span></label>
		<div class="col-sm-6">
			<input type="date" id="date" name="date" value="${form['date']}" /> <span class="error">${erreurs['date']}</span> <br />
		</div>
	</div>
	<br />
	<div class="form-group">	
		<label for="heure">Heure de départ</label>
		<div class="col-sm-6">
			<input type="time" id="heure" name="heure" value="${form['heure']}" /> <span class="error">${erreurs['heure']}</span> <br />
		</div>
	</div>
	<br />
	<div class="checkbox">
		<label for="fumeur">Préférences :</label><br /><br />
		<div class="col-sm-6">
			<input type="radio" id="fumeur" name="fumeur" value="NonFumeur" >
			<label for="NonFumeur"><img src="images/logo_non_fumeur.jpg" alt="Non fumeur" /></label>
			<input type="radio" id="fumeur" name="fumeur" value="Fumeur">
			<label for="Fumeur"><img src="images/logo_fumeur.jpg" alt="Fumeur" /></label><br />
		</div>
		<br />
		<div class="col-sm-6">
			<input type="radio" id="musique" name="musique" value="NonMusique" >
			<label for="NonMusique">Sans musique</label>
			<input type="radio" id="musique" name="musique" value="AvecMusique">
			<label for="AvecMusique">Avec musique</label><br />
		</div>
	</div>
	<br />	
	<input type="submit" name="submit" value="Rechercher un trajet" class="btn btn-default" />
	<input type="reset" name="reset" value="Rafraichir" class="btn btn-default" />
</form>