package com.squirrels.oboulot.service;

import java.util.Map;

import com.squirrels.oboulot.bean.User;

public class ValidationUser {	//Centralisation des methodes de validation d'inscription et de connexion des users


	UserService userService;

	/////////////////////
	//INSCRIPTION//
	/////////////////////

	//crit�re de validation de l'email d'inscription
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

	//crit�re de validation du mot de passe d'inscription
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
			return "Le mot de passe est obligatoire et doit contenir au moins 6 caract�res";
		}
		return null;
	}

	//crit�re de validation du num�ro de telephone d'inscription
	public String validateTelInscription( String tel ){ 
		if ( tel != null && tel.trim().length() == 10 ) {
			if ( !tel.startsWith("0")) { 
				return "Veuillez saisir un num�ro de t�l�phone valide";
			} 
		} else { 
			return "Le num�ro de t�l�phone est obligatoire"; 
		}
		return null ;
	}

	//critere de validation du nom d'inscription
	public String validateNameInscription( String name, Map<String, User> users ){ 
		if ( name != null && name.trim().length() != 0 ) {
			if (users.keySet().contains(name)){
				return "Ce nom est d�j� utilis�";
			}
		} else { 
			return "Le nom d'utilisateur est obligatoire"; 
		}
		return null ;
	}

	/////////////////////
	//CONNEXION//
	/////////////////////

	//critere de validation du nom de connexion
	public String validateNameConnexion(String name){
		String res = null;
		Map<String, User> users = UserService.getInstance().getUserMap();
		if(name !=null && name.trim().length() != 0){
			if (users.keySet().contains(name)){
				return res;
			} else { res = "Identifiant erronn�" ;}
		}else{res = "Veuillez saisir un identifiant";

		}
		return res ;
	}

	//critere de validation du mot de passe de connexion
	public String validatePwdConnexion(String name, String pwd) {
		String res = null;
		Map<String, User> users = UserService.getInstance().getUserMap();
		if(pwd !=null && pwd.trim().length() != 0){
			if(users.keySet().contains(name)){
			if (pwd.equals(users.get(name).getPwd())){
				return res;
			} else { res = "Mot de passe erronn�" ;}
			}else{ res = "";}
		}else{res = "Veuillez saisir un Mot de passe";

		}
		return res ;
	}
}

