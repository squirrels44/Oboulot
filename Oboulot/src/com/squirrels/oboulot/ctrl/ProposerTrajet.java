package com.squirrels.oboulot.ctrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.squirrels.oboulot.bean.Trajet;
import com.squirrels.oboulot.bean.User;

/**
 * Servlet implementation class ProposerTrajet
 */
@WebServlet("/formPropositionTrajet")
public class ProposerTrajet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String VIEW_PAGES_URL="/WEB-INF/trajet/formulaireProposerTrajet.jsp";
	//variables statiques concernant le trajet propos�
	private static final String FIELD_DPT = "ptdepart";
	private static final String FIELD_ARV = "ptarrivee"; 
	private static final String FIELD_PSG = "ptpassage";
	private static final String FIELD_DATE = "date"; 
	private static final String FIELD_HEURE = "heure";
	private static final String FIELD_NBPLACE = "nbplace";
	private static final String FIELD_FUMEUR = "fumeur";
	private static final String FIELD_MUSIQUE = "musique";
	private static final String SUCCES = "Succ�s de l'inscription";
	private static final String ECHEC = "Echec de l'inscription";
	public static String actionMessage;
	Trajet newTrajet = null;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//V�rifier les diff�rentes informations
		//Si non valide, renvoyer sur la m�me page avec message d'erreur
		//Si valide, renvoyer vers... et enregistrer trajet dans application

		HttpSession session = request.getSession();
		ServletContext application = request.getServletContext();

		User connectedUser = (User) session.getAttribute("connectedUser");

		String ptdepart = request.getParameter(FIELD_DPT);
		String ptarrivee = request.getParameter(FIELD_ARV);
		String ptpassage = request.getParameter(FIELD_PSG);
		String date = request.getParameter(FIELD_DATE);
		String heure = request.getParameter(FIELD_HEURE);
		String nbplace = request.getParameter(FIELD_NBPLACE);
		String fumeur = request.getParameter(FIELD_FUMEUR);
		String musique = request.getParameter(FIELD_MUSIQUE);

		Map<String, Trajet> trajets = (HashMap<String, Trajet>) application.getAttribute("trajets");
		if(trajets==null){
			trajets = new HashMap<String, Trajet>();
			Trajet admin = new Trajet("2 rue Crucy, Nantes", "Mail Pablo Picasso", "");
			trajets.put("Admin", admin);
			application.setAttribute( "users", trajets ); //TODO Erreur? avec "users"?
		}

		HashMap<String, String>erreurs = new HashMap<String, String>();
		HashMap<String, String>form = new HashMap<String, String>();

		//on creer un nouveau trajet
		newTrajet = new Trajet(ptdepart,ptarrivee, "");
		request.setAttribute("newTrajet", newTrajet);

		//lignes de code permettants l'affichage de message d'erreur
		String errPtDepart = validateAdresse(ptdepart) ;
		if(errPtDepart!=null){
			erreurs.put(FIELD_DPT, errPtDepart);
			form.put(FIELD_DPT, null);
			actionMessage = ECHEC;
		} else {
			form.put(FIELD_DPT, ptdepart);
			actionMessage = SUCCES;
		}

		String errPtArrivee = validateAdresse(ptarrivee) ;
		if(errPtArrivee!=null){
			erreurs.put(FIELD_ARV, errPtArrivee);
			form.put(FIELD_ARV, null);
			actionMessage = ECHEC;
		} else {
			form.put(FIELD_ARV, ptarrivee);
			if (actionMessage.equals(ECHEC)){
				actionMessage=ECHEC;
			}
			else {
				actionMessage=SUCCES;
			}
		}

		String errDate = validateDate(date) ;
		if(errDate!=null){
			erreurs.put(FIELD_DATE, errDate);
			form.put(FIELD_DATE, null);
			actionMessage = ECHEC;
		} else {
			form.put(FIELD_DATE, date);
			if (actionMessage.equals(ECHEC)){
				actionMessage=ECHEC;
			}
			else {
				actionMessage=SUCCES;
			}
		}

		String errHeure = validateHeure(heure) ;
		if(errHeure!=null){
			erreurs.put(FIELD_HEURE, errHeure);
			form.put(FIELD_HEURE, null);
			actionMessage = ECHEC;
		} else {
			form.put(FIELD_HEURE, heure);
			if (actionMessage.equals(ECHEC)){
				actionMessage=ECHEC;
			}
			else {
				actionMessage=SUCCES;
			}
		}

		String errNbPlace = validateNbPlace(nbplace) ;
		if(errNbPlace!=null){
			erreurs.put(FIELD_NBPLACE, errNbPlace);
			form.put(FIELD_NBPLACE, null);
			actionMessage = ECHEC;
		} else {
			form.put(FIELD_NBPLACE, nbplace);
			if (actionMessage.equals(ECHEC)){
				actionMessage=ECHEC;
			}
			else {
				actionMessage=SUCCES;
			}
		}
		//fin des lignes de code permettants l'affichage de message d'erreur
		
		form.put(FIELD_FUMEUR, fumeur);
		form.put(FIELD_MUSIQUE, musique);
		request.setAttribute("form", form);
		request.setAttribute("erreurs", erreurs);
		request.setAttribute("actionMessage", actionMessage);

		// si le formulaire de trajet est correctement rempli, on associe le login du conducteur au trajet et on redirige vers l'index
		if (actionMessage.equals(SUCCES)){
			trajets.put(connectedUser.getName(), newTrajet);
			application.setAttribute( "trajets", trajets );
			RequestDispatcher dispat = request.getRequestDispatcher("/index.jsp");
			dispat.forward(request,response);
		} 
		// sinon on revient sur le formulaire avec les messages d'erreurs pour les champs en question
		else
		{
			request.setAttribute("errorStatus", false); 
			RequestDispatcher dispat = request.getRequestDispatcher(VIEW_PAGES_URL);
			dispat.forward(request,response);
		}
	}

	//m�thode detectant l'absence d'adresse rentr�e
	private String validateAdresse(String adresse) {
		if ( adresse != null && adresse.trim().length() != 0 ) {
			return "L'adresse est obligatoire"; 
		}
		return null ;
	}
	
	//m�thode permettant l'affichage de message lors d'absence de date rentr�e
	private String validateDate(String date) {
		// TODO Auto-generated method stub
		return null;
	}

	//m�thode permettant l'affichage de message lors d'absence d'heure rentr�e
	private String validateHeure(String heure) {
		// TODO Auto-generated method stub
		return null;
	}

	//m�thode permettant l'affichage de message lors d'absence ou d'un nombre incorrect de place rentr�e
	private String validateNbPlace(String nbplace) {
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
