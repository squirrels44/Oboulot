
<form method="post" action="formConnexion">

Login : <span class="requis">*</span>
<div id="name"><input type="text" name="name" value="${form['name']}"/><span class="error">${erreurs['name']}</span></div>
<br>


Mot de passe : <span class="requis">*</span>
<div id="pwd"><input type="password" name="pwd" value="${form['pwd']}"><span class="error">${erreurs['pwd']}</span></div><br/>

<input type="submit" value="Connexion">


<p>${ actionMessage }</p>
</form>
