package com.squirrels.oboulot.bean;

public class Trajet {
	
	private String ptdepart;
	private String ptarrivee;

	public Trajet(String ptdepart, String ptarrivee) {
		this.ptdepart = ptdepart;
		this.ptarrivee = ptarrivee;
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

}
