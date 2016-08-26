package com.squirrels.oboulot.bean;

public class Trajet {
	/**
	 * Ce bean contient les informations d'adresses relatives au trajet 
	 */
	
	private String pointDepart;	//adresse entr�e dans le formulaire en tant que point de d�part
	private String pointArrivee;	//adresse entr�e dans le formulaire en tant que point d'arriv�e
	private String pointIntermediaire;	//adresse entr�e dans le formulaire en tant que point de passage

	public Trajet(String pointDepart, String pointArrivee, String pointIntermediaire) {
		this.pointDepart = pointDepart;
		this.pointArrivee = pointArrivee;
		this.pointIntermediaire = pointIntermediaire;
	}

	public String getPtdepart() {
		return pointDepart;
	}
	public void setPtdepart(String pointDepart) {
		this.pointDepart = pointDepart;
	}

	public String getPtarrivee() {
		return pointArrivee;
	}
	public void setPtarrivee(String pointArrivee) {
		this.pointArrivee = pointArrivee;
	}
	
	public String getPtintermediaire() {
		return pointIntermediaire;
	}
	public void setPtintermediaire(String pointIntermediaire) {
		this.pointIntermediaire = pointIntermediaire;
	}

}
