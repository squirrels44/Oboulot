package com.squirrels.oboulot.service;

import java.util.Map;

import com.squirrels.oboulot.bean.User;

public class ValidationUser {		//Centralisation des methodes de validation d'inscription et de connexion des users
	
	
	//méthode de validation d'inscription
	
	public String validateEmailInscription( String email ){ 
		if ( email != null && email.trim().length() != 0 ) {
			if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) { 
				return "Veuillez saisir une adresse mail valide";
			} 
		} else { 
			return "L'adresse mail est obligatoire"; 
		}
		return null ;
	}
	
	public String validatePwdInscription(String pwd1, String pwd2){
		if (pwd1 != null && pwd1.trim().length() > 5){
			if (pwd2 != null && pwd2.trim().length() != 0){
				if (!pwd1.equals(pwd2)){
					return "La confirmation du mot de passe est invalide";
				}
			} else{
				return "Veuillez confirmer votre mot de passe";
			}
		} else {
			return "Le mot de passe est obligatoire et doit contenir au moins 6 caractères";
		}
		return null;
	}
	
	public String validateTelInscription( String tel ){ 
		if ( tel != null && tel.trim().length() == 10 ) {
			if ( !tel.startsWith("0")) { 
				return "Veuillez saisir un numéro de téléphone valide";
			} 
		} else { 
			return "Le numéro de téléphone est obligatoire"; 
		}
		return null ;
	}
	
	public String validateNameInscription( String name, Map<String, User> users ){ 
		if ( name != null && name.trim().length() != 0 ) {
			if (users.keySet().contains(name)){
				return "Ce nom est déjà utilisé";
			}
		} else { 
			return "Le nom d'utilisateur est obligatoire"; 
		}
		return null ;
	}

	
		//Methode validation de connexion
	
	public String validateNameConnexion(String name, String nameInscription){
		String res = null;
		if(name ==null || name.trim().length() == 0){
			res = "Veuillez saisir un identifiant valide";
		}else if( name==nameInscription ){
			return res; 
		}return res;
	}

	//TODO : récupérer la méthode de validation de charlotte pour faire coorespondre le nom inscrit et logué.

	public String validatePwdConnexion(String pwd, String pwdInscription) {
		String res = null;
		if(pwd ==null || pwd.trim().length() == 0){
			res = "Veuillez saisir un mot de passe valide";
		}else if( pwd==pwdInscription ){
			return res; 
		}return res;

	}

}
