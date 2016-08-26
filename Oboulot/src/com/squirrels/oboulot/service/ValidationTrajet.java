package com.squirrels.oboulot.service;

public class ValidationTrajet{
	
	//méthode detectant l'absence d'adresse rentrée
		public String validateAdresse(String adresse) {
			if ( adresse != null && adresse.trim().length() != 0 ) {
				return "L'adresse est obligatoire"; 
			}
			return null ;
		}
		
		//méthode permettant l'affichage de message lors d'absence de date rentrée
		public String validateDate(String date) {
			// TODO Auto-generated method stub
			return null;
		}

		//méthode permettant l'affichage de message lors d'absence d'heure rentrée
		public String validateHeure(String heure) {
			// TODO Auto-generated method stub
			return null;
		}

		//méthode permettant l'affichage de message lors d'absence ou d'un nombre incorrect de place rentrée
		public String validateNbPlace(String nbplace) {
			if ( nbplace != null && nbplace.trim().length() != 0 ) {
				int i = Integer.parseInt(nbplace);
				if (0<i && i<5){
					return null;
				} else {
					return "Vous pouvez proposer 1 à 4 places";
				}
			} else {
				return "Veuillez entrer le nombre de places que vous proposez";
			}

		}
}
