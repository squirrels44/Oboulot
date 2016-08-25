package com.squirrels.oboulot.bean;

public class Trajet {
	
	private String ptdepart;
	private String ptarrivee;
	private String ptintermediaire;

	public Trajet(String ptdepart, String ptarrivee, String ptintermediaire) {
		this.ptdepart = ptdepart;
		this.ptarrivee = ptarrivee;
		this.ptintermediaire = ptintermediaire;
	}

	public String getPtdepart() {
		return ptdepart;
	}

	public void setPtdepart(String ptdepart) {
		this.ptdepart = ptdepart;
	}

	public String getPtarrivee() {
		return ptarrivee;
	}

	public void setPtarrivee(String ptarrivee) {
		this.ptarrivee = ptarrivee;
	}
	
	public String getPtintermediaire() {
		return ptintermediaire;
	}

	public void setPtintermediaire(String ptintermediaire) {
		this.ptintermediaire = ptintermediaire;
	}

}
