<form method="POST" action="formPropositionTrajet">
	<div class="form-group">
		<label class="control-label col-sm-6" for="ptdepart">Adresse de départ<span class="requis">*</span></label> 
		<div class="col-sm-6">
			<input type="text" id="ptdepart" name="ptdepart" onBlur="calculateAndDisplayRoute('ptdepart','ptarrivee')" value="${form['ptdepart']}"/>
		</div>
		<div style="color: #FF0000">${erreurs['ptdepart']}</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-6" for="ptarrivee">Adresse d'arrivée<span class="requis">*</span></label>
		<div class="col-sm-6">
			<input type="text" id="ptarrivee" name="ptarrivee" onBlur="calculateAndDisplayRoute('ptdepart','ptarrivee')" value="${form['ptarrivee']}" />
		</div>
		<div style="color: #FF0000">${erreurs['ptarrivee']}</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-6" for="ptpassage">Adresse d'un point de passage</label>
		<div class="col-sm-6">
			<input type="text" id="ptpassage" name="ptpassage" onBlur="calculateAndDisplayRoute('ptdepart','ptarrivee')" value="${form['ptpassage']}" />
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
		<label class="control-label col-sm-6" for="nbplace">Nombre de places disponibles<span class="requis">*</span></label> 
		<div class="col-sm-6">
			<input type="number" min="1" max="4" id="nbplace"  name="nbplace" value="${form['nbplace']}" /><br />
		</div>
		<div style="color: #FF0000">${erreurs['nbplace']}</div>
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
			<input type="radio" name="musique" value="NonMusique" checked>
			<label for="NonMusique">Sans musique</label>
			<input type="radio" name="musique" value="AvecMusique">
			<label for="AvecMusique">Avec musique</label>
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