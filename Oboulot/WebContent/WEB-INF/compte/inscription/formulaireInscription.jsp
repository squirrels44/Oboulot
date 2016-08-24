	<form method="POST" action="formInscription">
			<p>Vous pouvez vous inscrire via ce formulaire.</p>
			<div>
				<label for="name">Nom d'utilisateur<span class="requis">*</span></label> 
				<input type="text" name="name" value="${form['name']}"/><span class="error">${erreurs['name']}</span><br />
				
				<label for="email">Adresse email<span class="requis">*</span></label>
				<input type="text" name="email" value="${form['email']}" /> <span class="error">${erreurs['email']}</span> <br />
				
				<label for="tel">Num�ro de t�l�phone<span class="requis">*</span></label>
				<input type="text" name="tel" value="${form['tel']}" /> <span class="error">${erreurs['tel']}</span> <br />
		
				<label for="pwd1">Mot de passe<span class="requis">*</span></label> 
				<input type="password" name="pwd1" value="${form['pwd1']}" /><br />
				<label for="pwd2">Confirmation du mot de passe<span class="requis">*</span></label> 
				<input type="password" name="pwd2" /> <span class="error">${erreurs['pwd1']}</span><br /> 
 				
				<label for="submit"></label> 
				<input type="submit" name="submit" value="Inscription" />
				<label for="reset"></label> 
				<input type="reset" name="reset" value="Rafraichir" />
			</div>
	</form>