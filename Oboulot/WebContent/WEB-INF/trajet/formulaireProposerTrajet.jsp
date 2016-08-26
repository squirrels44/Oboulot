<form method="POST" action="formPropositionTrajet">
	<div class="form-group">
		<label class="control-label col-sm-6" for="pointDepart">Adresse de départ<span class="requis">*</span></label> 
		<div class="col-sm-6">
			<input type="text" id="pointDepart" name="pointDepart" onBlur="calculateAndDisplayRoute('pointDepart','pointArrivee')" value="${form['pointDepart']}"/>
		</div>
		<div style="color: #FF0000">${erreurs['pointDepart']}</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-6" for="pointArrivee">Adresse d'arrivée<span class="requis">*</span></label>
		<div class="col-sm-6">
			<input type="text" id="pointArrivee" name="pointArrivee" onBlur="calculateAndDisplayRoute('pointDepart','pointArrivee')" value="${form['pointArrivee']}" />
		</div>
		<div style="color: #FF0000">${erreurs['pointArrivee']}</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-6" for="pointIntermediaire">Adresse d'un point de passage</label>
		<div class="col-sm-6">
			<input type="text" id="pointIntermediaire" name="pointIntermediaire" onBlur="calculateAndDisplayRoute('pointDepart','pointArrivee')" value="${form['pointIntermediaire']}" />
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-6" for="date">Date du trajet<span class="requis">*</span></label>
		<div class="col-sm-6">	
			<input type="date" id="date" name="date" value="${form['date']}" /> <span class="error">${erreurs['date']}</span> <br />
		</div>
		<div style="color: #FF0000">${erreurs['date']}</div>
	</div>
	<div class="form-group">	
		<label class="control-label col-sm-6" for="heure">Heure de départ<span class="requis">*</span></label>
		<div class="col-sm-6">
			<input type="time" id="heure" name="heure" value="${form['heure']}" />
		</div>
		<div style="color: #FF0000">${erreurs['heure']}</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-6" for="nombrePlace">Nombre de places disponibles<span class="requis">*</span></label> 
		<div class="col-sm-6">
			<input type="number" min="1" max="4" id="nombrePlace"  name="nombrePlace" value="${form['nombrePlace']}" /><br />
		</div>
		<div style="color: #FF0000">${erreurs['nombrePlace']}</div>
	</div>
	<div class="checkbox">			
		<label class="control-label col-sm-6" for="fumeur">Fumeur :</label>
		<div class="col-sm-6">
			<input type="radio" name="fumeur" value="NonFumeur" checked>
			<label for="NonFumeur"><img src="images/logo_non_fumeur.jpg" alt="Non fumeur" /></label>
			<input type="radio" name="fumeur" value="Fumeur">
			<label for="Fumeur"><img src="images/logo_fumeur.jpg" alt="Fumeur" /></label>
		</div>
	</div>	
	<div class="checkbox">			
		<label class="control-label col-sm-6" for="musique">Musique :</label>
		<div class="col-sm-6">
			<input type="radio" name="musique" value="nonMusique" checked>
			<label for="nonMusique">Sans musique</label>
			<input type="radio" name="musique" value="avecMusique">
			<label for="avecMusique">Avec musique</label>
		</div>
	</div>			
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-4">
			<input type="submit" name="submit" value="Valider mon trajet"
				class=" form-control btn btn-primary" />
		</div>
		<div class="col-sm-4">
			<input type="reset" name="reset" value="Rafraichir"
				class=" form-control btn btn-primary" />
		</div>
	</div>
	<div style="color: #FF0000">${ actionMessage }</div>
	</form>