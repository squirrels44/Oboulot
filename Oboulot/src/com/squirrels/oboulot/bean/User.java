/*
 * bean permettant l'accès aux éléments d'un utilisateur
 * réalisé par benji
 */
package com.squirrels.oboulot.bean;

public class User {
	
	private String name; // le name est unique, c'est un login
	private String email;
	private String pwd;
	private String tel;

	//constructeur de l'objet user
	public User(String name, String email, String pwd, String tel) 
	{
		super();
		this.name = name;
		this.email = email;
		this.pwd = pwd;
		this.tel = tel;
	}

	//série de getters et setters permettant la lecture et modification des données d'un utilisateur
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
}
