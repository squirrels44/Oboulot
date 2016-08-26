<form method="post" action="formConnexion">
	<div class="form-group">
		<label class="control-label col-sm-6" for="name">Login<span
			class="requis">*</span></label>
		<div class="col-sm-6">
			<input type="text" id="name" name="name" value="${form['name']}" />
		</div>
        <div style="color: #FF0000">${erreurs['name']}</div>
	</div>
	<br/>
	<div class="form-group">
		<label class="control-label col-sm-6" for="pwd">Mot de passe <span
			class="requis">*</span></label>
		<div class="col-sm-6">
			<input type="password" id="pwd" name="pwd" value="${form['pwd']}">
		</div>
        <div style="color: #FF0000">${erreurs['pwd']}</div>
	</div>
    <br/>
	<div class="form-group">
		<div class="col-sm-offset-6 col-sm-6">
			<input type="submit" value="Connexion" class=" form-control btn btn-primary">
		</div>
	</div>
    <br/>
    <div style="color: #FF0000">${ actionMessage }</div>
</form>
