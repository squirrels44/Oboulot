<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Proposer un trajet</title>
</head>
<body>
	<form method="POST" action="formPropositionTrajet">
			<p>Vous pouvez proposer votre trajet via ce formulaire.</p>
			<div>
				<label for="ptdepart">Adresse de départ<span class="requis">*</span></label> 
				<input type="text" name="ptdepart" value="${form['ptdepart']}"/><span class="error">${erreurs['ptdepart']}</span><br />
				
				<label for="ptarrivee">Adresse d'arrivée<span class="requis">*</span></label>
				<input type="text" name="ptarrivee" value="${form['ptarrivee']}" /> <span class="error">${erreurs['ptarrivee']}</span> <br />
				
				<label for="ptpassage">Adresse d'un point de passage</label>
				<input type="text" name="ptpassage" value="${form['ptpassage']}" /> <span class="error">${erreurs['ptpassage']}</span> <br />
				
				<label for="date">Date du trajet<span class="requis">*</span></label>
				<input type="text" name="date" value="${form['date']}" /> <span class="error">${erreurs['date']}</span> <br />
				
				<label for="heure">Heure de départ<span class="requis">*</span></label>
				<input type="text" name="heure" value="${form['heure']}" /> <span class="error">${erreurs['heure']}</span> <br />
		
				<label for="nbplace">Nombre de places disponibles<span class="requis">*</span></label> 
				<input type="text" name="nbplace" value="${form['nbplace']}" /><br />
				
				<label for="submit"></label> 
				<input type="submit" name="submit" value="Valider mon trajet" />
				<label for="reset"></label> 
				<input type="reset" name="reset" value="Rafraichir" />
			</div>
	</form>
</body>
</html>