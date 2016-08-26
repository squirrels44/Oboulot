package com.squirrels.oboulot.bean;

public class Trajet {
	/**
	 * Ce bean contient les informations d'adresses relatives au trajet 
	 */
	
	private String pointDepart;	//adresse entrée dans le formulaire en tant que point de départ
	private String pointArrivee;	//adresse entrée dans le formulaire en tant que point d'arrivée
	private String pointIntermediaire;	//adresse entrée dans le formulaire en tant que point de passage

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
