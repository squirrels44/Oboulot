<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Connexion</title>
</head>
<body>
<form method="post" action="formConnexion">

Login : <span class="requis">*</span>
<div id="name"><input type="text" name="name" value="${form['name']}"/><span class="error">${erreurs['name']}</span></div>
<br>


Mot de passe : <span class="requis">*</span>
<div id="pwd"><input type="password" name="pwd" value="${form['pwd']}"><span class="error">${erreurs['pwd']}</span></div><br/>

<input type="submit" value="Connexion">


<p>${ actionMessage }</p>
</form>
</body>
</html>