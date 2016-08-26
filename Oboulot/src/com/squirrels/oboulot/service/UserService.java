package com.squirrels.oboulot.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.squirrels.oboulot.bean.User;

public class UserService { //R�gles service

	static UserService singleton=null;

	HashMap<String, User> userMap=null;


	//Lazy-loading : on cr�� la map des utilisateurs si elle n'existe pas. 
	public Map<String, User>  getUserMap(){
		if(userMap==null){
			userMap = new HashMap<String, User>();

		}
		//On v�rouille la map :  ne peut modifier la liste d'utilisateurs en dehors de la couche service. 
		Map<String, User> res= Collections.unmodifiableMap(userMap);
		return res;
	}

	//M�thode permettant d'ajouter un utilisateur (on ne peut plus faire de .put)
	public void addUser(User newUser){
		userMap.put(newUser.getName(), newUser); 
	}


	//Singleton : on cr�er la classe UserService si elle n'existe pas d�j�
	public static UserService getInstance() {
		if(singleton==null){
			singleton = new UserService();

		} 

		return singleton;

	}

}
