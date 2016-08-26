<form method="POST" action="formRechercheTrajet">
	<div class="form-group">
		<label class="control-label col-sm-6" for="pointDepart">Adresse de départ<span class="requis">*</span></label> 
		<div class="col-sm-5">
			<input class="form-control" type="text" id="pointDepart" name="pointDepart" onBlur="calculateAndDisplayRoute('pointDepart','pointArrivee')" value="${form['pointDepart']}"/>
		</div>
		<div style="color: #FF0000">${erreurs['pointDepart']}</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-6" for="pointArrivee">Adresse d'arrivée<span class="requis">*</span></label>
		<div class="col-sm-5">
			<input class="form-control" type="text" id="pointArrivee" name="pointArrivee" onBlur="calculateAndDisplayRoute('pointDepart','pointArrivee')" value="${form['pointArrivee']}" />
		</div>
		<div style="color: #FF0000">${erreurs['pointArrivee']}</div>
	</div>
	<div class="form-group">	
		<label class="control-label col-sm-6" for="date">Date du trajet<span class="requis">*</span></label>
		<div class="col-sm-5">
			<input type="date" id="date" name="date" value="${form['date']}" /> 
		</div>
		<div style="color: #FF0000">${erreurs['date']}</div>
	</div>
	<div class="form-group">	
		<label class="control-label col-sm-6" for="heure">Heure de départ</label>
		<div class="col-sm-5">
			<input type="time" id="heure" name="heure" value="${form['heure']}" /> 
		</div>
		<div style="color: #FF0000">${erreurs['heure']}</div>
	</div>
	<div class="form-group row">
        <label class="col-sm-offset-2 col-sm-4">Préférences :</label>
        <div class="row">
	        <div class="col-sm-offset-4 col-sm-8">
	            <label><input type="radio" id="fumeur" name="fumeur" value="NonFumeur" ><img src="images/logo_non_fumeur.jpg" alt="Non fumeur" /></label>
	            <label><input type="radio" id="fumeur" name="fumeur" value="Fumeur"><img src="images/logo_fumeur.jpg" alt="Fumeur" /></label>
	        </div>
			<div class="col-sm-offset-4 col-sm-8">
				<label></label><input type="radio" id="musique" name="musique" value="NonMusique" >Sans musique</label>
				<label></label><input type="radio" id="musique" name="musique" value="AvecMusique">Avec musique</label>
			</div>
		</div>
	</div>
	<div class="form-group row">
		<div class="col-sm-offset-2 col-sm-5">
			<input type="submit" name="submit" value="Rechercher un trajet"
				class=" form-control btn btn-primary" />
		</div>
		<div class="col-sm-5">
			<input type="reset" name="reset" value="Rafraichir"
				class=" form-control btn btn-primary" />
		</div>
	</div>
</form>