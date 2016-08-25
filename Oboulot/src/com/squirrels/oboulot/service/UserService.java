package com.squirrels.oboulot.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.squirrels.oboulot.bean.User;

public class UserService {

	static UserService singleton=null;
	
	HashMap<String, User> userMap=null;

	
	//Lazy-loading : on créé la map si elle n'existe pas. 
	public  HashMap<String, User>  getUserMap(){
		if(userMap==null){
			userMap = new HashMap<String, User>();
			User admin = new User("Admin", "admin@gmail.com", "123456", "0611223344");
			userMap.put("Admin", admin);
		}
		//On ne peut modifier la liste d'utilisateurs en dehors de la couche service. 
		HashMap<String, User> res=(HashMap<String, User>) Collections.unmodifiableMap(this.userMap);
		return res;
	}
	
	//Méthode permettant d'ajouter un utilisateur (on ne peut plus faire de .put)
	public void addUser(User newUser){
		userMap.put(newUser.getName(), newUser); 
	}
	
	
	//Singleton
	public static UserService getInstance() {
		if(singleton==null){
			singleton = new UserService();
			
		} 
		
		return singleton;
		
	}

}
