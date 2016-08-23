<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inscription</title>
</head>
<body>
	<form method="POST" action="formInscription">
			<p>Vous pouvez vous inscrire via ce formulaire.</p>
			<div>
				<label for="name">Nom d'utilisateur<span class="requis">*</span></label> 
				<input type="text" name="name" value="${form['name']}"/><br />
				
				<label for="email">Adresse email<span class="requis">*</span></label>
				<input type="text" name="email" value="${form['email']}" /> <span class="error">${erreurs['email']}</span> <br />
				
				<label for="tel">Numéro de téléphone<span class="requis">*</span></label>
				<input type="text" name="tel" value="${form['tel']}" /> <span class="error">${erreurs['tel']}</span> <br />
				
				<label for="fumeur">Fumeur :</label>
				<input type="radio" name="fumeur" value="NonFumeur" checked>
				<label for="NonFumeur"><img src="/WEB-INF/images/logo_non_fumeur.jpg" alt="Non fumeur" /></label>
				<input type="radio" name="fumeur" value="Fumeur">
				<label for="Fumeur"><img src="/WEB-INF/images/logo_fumeur.jpg" alt="Fumeur" /></label><br />
				
				<label for="musique">Musique :</label>
				<input type="radio" name="musique" value="NonMusique" checked>
				<label for="NonMusique">Sans musique</label>
				<input type="radio" name="musique" value="AvecMusique">
				<label for="AvecMusique">Avec musique</label><br />
		
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
</body>
</html>