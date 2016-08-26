<form method="POST" action="formPropositionTrajet">
	<div class="form-group">
		<label for="ptdepart">Adresse de d�part<span class="requis">*</span></label> 
		<div class="col-sm-6">
			<input type="text" id="ptdepart" name="ptdepart" onBlur="calculateAndDisplayRoute('ptdepart','ptarrivee')" value="${form['ptdepart']}"/><span class="error">${erreurs['ptdepart']}</span><br />
		</div>
	</div>
	<br />
	<div class="form-group">
		<label for="ptarrivee">Adresse d'arriv�e<span class="requis">*</span></label>
		<div class="col-sm-6">
			<input type="text" id="ptarrivee" name="ptarrivee" onBlur="calculateAndDisplayRoute('ptdepart','ptarrivee')" value="${form['ptarrivee']}" /> <span class="error">${erreurs['ptarrivee']}</span> <br />
		</div>
	</div>
	<br />
	<div class="form-group">
		<label for="ptpassage">Adresse d'un point de passage</label>
		<div class="col-sm-6">
			<input type="text" id="ptpassage" name="ptpassage" onBlur="calculateAndDisplayRoute('ptdepart','ptarrivee')" value="${form['ptpassage']}" /> <span class="error">${erreurs['ptpassage']}</span> <br />
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
		<label for="heure">Heure de d�part<span class="requis">*</span></label>
		<div class="col-sm-6">
			<input type="time" id="heure" name="heure" value="${form['heure']}" /> <span class="error">${erreurs['heure']}</span> <br />
		</div>
	</div>
	<br />
	<div class="form-group">
		<label for="nbplace">Nombre de places disponibles<span class="requis">*</span></label> 
		<div class="col-sm-6">
			<input type="number" min="1" max="4" id="nbplace"  name="nbplace" value="${form['nbplace']}" /><br />
		</div>
	</div>
	<br />	
	<div class="checkbox">			
		<label for="fumeur">Fumeur :</label><br />
		<div class="col-sm-6">
			<input type="radio" name="fumeur" value="NonFumeur" checked>
			<label for="NonFumeur"><img src="images/logo_non_fumeur.jpg" alt="Non fumeur" /></label>
			<input type="radio" name="fumeur" value="Fumeur">
			<label for="Fumeur"><img src="images/logo_fumeur.jpg" alt="Fumeur" /></label><br />
		</div>
	</div>
	<br />	
	<div class="checkbox">			
		<label for="musique">Musique :</label>
		<div class="col-sm-6">
			<input type="radio" name="musique" value="NonMusique" checked>
			<label for="NonMusique">Sans musique</label>
			<input type="radio" name="musique" value="AvecMusique">
			<label for="AvecMusique">Avec musique</label><br />
		</div>
	</div>
	<br />			
	<input type="submit" name="submit" value="Valider mon trajet" class="btn btn-default" />
	<input type="reset" name="reset" value="Rafraichir" class="btn btn-default" />
	</form>