package com.squirrels.oboulot.bean;

public class User {
	
	private String name;
	private String email;
	private String pwd;
	private String tel;

	public User(String name, String email, String pwd, String tel) {
		this.name = name;
		this.email = email;
		this.pwd = pwd;
		this.tel = tel;
	}

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
