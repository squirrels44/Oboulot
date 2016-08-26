<form method="POST" action="formRechercheTrajet">
	<div class="form-group">
		<label class="control-label col-sm-6" for="pointDepart">Adresse de départ<span class="requis">*</span></label> 
		<div class="col-sm-6">
			<input class="form-control" type="text" id="pointDepart" name="pointDepart" onBlur="calculateAndDisplayRoute('pointDepart','pointArrivee')" value="${form['pointDepart']}"/>
		</div>
		<div style="color: #FF0000">${erreurs['pointDepart']}</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-6" for="pointArrivee">Adresse d'arrivée<span class="requis">*</span></label>
		<div class="col-sm-6">
			<input class="form-control" type="text" id="pointArrivee" name="pointArrivee" onBlur="calculateAndDisplayRoute('pointDepart','pointArrivee')" value="${form['pointArrivee']}" />
		</div>
		<div style="color: #FF0000">${erreurs['pointArrivee']}</div>
	</div>
	<div class="form-group">	
		<label class="control-label col-sm-6" for="date">Date du trajet<span class="requis">*</span></label>
		<div class="col-sm-6">
			<input type="date" id="date" name="date" value="${form['date']}" /> 
		</div>
		<div style="color: #FF0000">${erreurs['date']}</div>
	</div>
	<div class="form-group">	
		<label class="control-label col-sm-6" for="heure">Heure de départ</label>
		<div class="col-sm-6">
			<input type="time" id="heure" name="heure" value="${form['heure']}" /> 
		</div>
		<div style="color: #FF0000">${erreurs['heure']}</div>
	</div>
	<div class="checkbox">
		<label class="control-label col-sm-6" for="fumeur">Préférences :</label><br /><br />
		<div class="col-sm-6">
			<input type="radio" id="fumeur" name="fumeur" value="NonFumeur" >
			<label for="NonFumeur"><img src="images/logo_non_fumeur.jpg" alt="Non fumeur" /></label>
			<input type="radio" id="fumeur" name="fumeur" value="Fumeur">
			<label for="Fumeur"><img src="images/logo_fumeur.jpg" alt="Fumeur" /></label><br />
		</div>
		<div class="col-sm-6">
			<input type="radio" id="musique" name="musique" value="NonMusique" >
			<label for="NonMusique">Sans musique</label>
			<input type="radio" id="musique" name="musique" value="AvecMusique">
			<label for="AvecMusique">Avec musique</label><br />
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-4">
			<input type="submit" name="submit" value="Rechercher un trajet"
				class=" form-control btn btn-primary" />
		</div>
		<div class="col-sm-4">
			<input type="reset" name="reset" value="Rafraichir"
				class=" form-control btn btn-primary" />
		</div>
	</div>
</form>