package com.squirrels.oboulot.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.squirrels.oboulot.bean.User;

public class UserService { //Règles service

	static UserService singleton=null;

	HashMap<String, User> userMap=null;


	//Lazy-loading : on créé la map des utilisateurs si elle n'existe pas. 
	public Map<String, User>  getUserMap(){
		if(userMap==null){
			userMap = new HashMap<String, User>();

		}
		//On vérouille la map :  ne peut modifier la liste d'utilisateurs en dehors de la couche service. 
		Map<String, User> res= Collections.unmodifiableMap(userMap);
		return res;
	}

	//Méthode permettant d'ajouter un utilisateur (on ne peut plus faire de .put)
	public void addUser(User newUser){
		userMap.put(newUser.getName(), newUser); 
	}


	//Singleton : on créer la classe UserService si elle n'existe pas déjà
	public static UserService getInstance() {
		if(singleton==null){
			singleton = new UserService();

		} 

		return singleton;

	}

}
