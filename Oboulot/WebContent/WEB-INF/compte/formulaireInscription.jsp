<form method="POST" action="fInscription">
	<div class="form-group">
		<label class="control-label col-sm-6" for="name">Nom
			d'utilisateur<span class="requis">*</span>
		</label>
		<div class="col-sm-6">
			<input class="form-control" type="text" name="name"
				value="${form['name']}" />
		</div>
		<div style="color: #FF0000">${erreurs['name']}</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-6" for="email">Adresse
			email<span class="requis">*</span>
		</label>
		<div class="col-sm-6">
			<input class="form-control" type="text" id="email" name="email"
				value="${form['email']}" />
		</div>
		<div style="color: #FF0000">${erreurs['email']}</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-6" for="tel">Numéro de téléphone<span class="requis">*</span>
		</label>
		<div class="col-sm-6">
			<input class="form-control" type="text" id="tel" name="tel"
				value="${form['tel']}" />
		</div>
		<div style="color: #FF0000">${erreurs['tel']}</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-6" for="pwd1">Mot de passe<span
			class="requis">*</span></label>
		<div class="col-sm-6">
			<input class="form-control" type="password" id="pwd1" name="pwd1" />
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-6" for="pwd2">Confirmation
			du mot de passe<span class="requis">*</span>
		</label>
		<div class="col-sm-6">
			<input class="form-control" type="password" name="pwd2" />
		</div>
		<div style="color: #FF0000">${erreurs['pwd1']}</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-4">
			<input type="submit" name="submit" value="Inscription"
				class=" form-control btn btn-primary" />
		</div>
		<div class="col-sm-4">
			<input type="reset" name="reset" value="Rafraichir"
				class=" form-control btn btn-primary" />
		</div>
	</div>
	<div style="color: #FF0000">${ actionMessage }</div>
</form>

