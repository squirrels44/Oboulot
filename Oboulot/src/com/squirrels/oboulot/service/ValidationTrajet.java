package com.squirrels.oboulot.service;

public class ValidationTrajet{
	
	//m�thode detectant l'absence d'adresse rentr�e
		public String validateAdresse(String adresse) {
			if ( adresse != null && adresse.trim().length() != 0 ) {
				return "L'adresse est obligatoire"; 
			}
			return null ;
		}
		
		//m�thode permettant l'affichage de message lors d'absence de date rentr�e
		public String validateDate(String date) {
			// TODO Auto-generated method stub
			return null;
		}

		//m�thode permettant l'affichage de message lors d'absence d'heure rentr�e
		public String validateHeure(String heure) {
			// TODO Auto-generated method stub
			return null;
		}

		//m�thode permettant l'affichage de message lors d'absence ou d'un nombre incorrect de place rentr�e
		public String validateNbPlace(String nbplace) {
			if ( nbplace != null && nbplace.trim().length() != 0 ) {
				int i = Integer.parseInt(nbplace);
				if (0<i && i<5){
					return null;
				} else {
					return "Vous pouvez proposer 1 � 4 places";
				}
			} else {
				return "Veuillez entrer le nombre de places que vous proposez";
			}

		}
}
