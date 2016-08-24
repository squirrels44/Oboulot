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
	public static final String FIELD_DPT = "ptdepart";
	public static final String FIELD_ARV = "ptarrivee"; 
	public static final String FIELD_PSG = "ptpassage";
	public static final String FIELD_DATE = "date"; 
	public static final String FIELD_HEURE = "heure";
	public static final String FIELD_NBPLACE = "nbplace";
	public static final String FIELD_FUMEUR = "fumeur";
	public static final String FIELD_MUSIQUE = "musique";
	public static final String SUCCES = "Succès de l'inscription";
	public static final String ECHEC = "Echec de l'inscription";
	public static String actionMessage;
	Trajet newTrajet = null;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProposerTrajet() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		//Vérifier les différentes informations
		//Si non valide, renvoyer sur la même page avec message d'erreur
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
			Trajet admin = new Trajet("2 rue Crucy, Nantes", "Mail Pablo Picasso");
			trajets.put("Admin", admin);
			application.setAttribute( "users", trajets );
		}
		
		HashMap<String, String>erreurs = new HashMap<String, String>();
		HashMap<String, String>form = new HashMap<String, String>();
		
		newTrajet = new Trajet(ptdepart,ptarrivee);
		request.setAttribute("newTrajet", newTrajet);
		
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
		
		String errPtPassage = validateAdresseFacultative(ptpassage) ;
		if(errPtPassage!=null){
			erreurs.put(FIELD_PSG, errPtPassage);
			form.put(FIELD_PSG, null);
			actionMessage = ECHEC;
		} else {
			form.put(FIELD_PSG, ptpassage);
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
			form.put(FIELD_NBPLACE, date);
			if (actionMessage.equals(ECHEC)){
				actionMessage=ECHEC;
			}
			else {
				actionMessage=SUCCES;
			}
		}
		
		form.put(FIELD_FUMEUR, fumeur);
		form.put(FIELD_MUSIQUE, musique);
		
		request.setAttribute("form", form);
		request.setAttribute("erreurs", erreurs);
		request.setAttribute("actionMessage", actionMessage);
		
		if (actionMessage.equals(SUCCES)){
			trajets.put(connectedUser.getName(), newTrajet);
			application.setAttribute( "trajets", trajets );
			RequestDispatcher dispat = request.getRequestDispatcher("/index.jsp");
			dispat.forward(request,response);
		} else{
			request.setAttribute("errorStatus", false); 
			RequestDispatcher dispat = request.getRequestDispatcher(VIEW_PAGES_URL);
			dispat.forward(request,response);
		}
	}


	private String validateAdresse(String adresse) {
		if ( adresse != null && adresse.trim().length() != 0 ) {
			if ( !adresse.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) { 
				return "Veuillez saisir une adresse valide";
			} 
		} else { 
			return "L'adresse est obligatoire"; 
		}
		return null ;
	}
	
	private String validateAdresseFacultative(String adresse) {
		if ( adresse != null && adresse.trim().length() != 0 ) {
			if ( !adresse.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) { 
				return "Veuillez saisir une adresse valide";
			} 
		} else { 
			return null; 
		}
		return null ;
	}

	private String validateDate(String date) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private String validateHeure(String heure) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private String validateNbPlace(String nbplace) {
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
