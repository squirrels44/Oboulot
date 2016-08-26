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
import com.squirrels.oboulot.service.ValidationTrajet;


/**
 * Servlet implementation class RechercherTrajet
 */
@WebServlet("/formRechercheTrajet")
public class RechercherTrajet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public static String VIEW_PAGES_URL="/WEB-INF/trajet/formulaireRechercherTrajet.jsp";
	public static final String FIELD_DPT = "ptdepart";
	public static final String FIELD_ARV = "ptarrivee"; 
	public static final String FIELD_DATE = "date"; 
	public static final String FIELD_HEURE = "heure";
	public static final String FIELD_FUMEUR = "fumeur";
	public static final String FIELD_MUSIQUE = "musique";
	public static final String SUCCES = "Succès";
	public static final String ECHEC = "Echec";
	public static String actionMessage;
	Trajet newTrajet = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RechercherTrajet() {
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
		
		HttpSession session = request.getSession();
		ServletContext application = request.getServletContext();

		User connectedUser = (User) session.getAttribute("connectedUser");
		//TODO le connectedUser peut être null si en tant que visiteur

		String ptdepart = request.getParameter(FIELD_DPT);
		String ptarrivee = request.getParameter(FIELD_ARV);
		String date = request.getParameter(FIELD_DATE);
		String heure = request.getParameter(FIELD_HEURE);
		String fumeur = request.getParameter(FIELD_FUMEUR);
		String musique = request.getParameter(FIELD_MUSIQUE);
		ValidationTrajet validationTrajet=new ValidationTrajet();
		
		Map<String, Trajet> trajetsCherchés = (HashMap<String, Trajet>) application.getAttribute("trajetsCherchés");
		if(trajetsCherchés==null){
			trajetsCherchés = new HashMap<String, Trajet>();
			Trajet trajadmin = new Trajet("2 rue Crucy, Nantes", "Mail Pablo Picasso", "");
			trajetsCherchés.put("Admin", trajadmin);
			application.setAttribute( "trajetsCherchés", trajetsCherchés );
		}

		HashMap<String, String>erreurs = new HashMap<String, String>();
		HashMap<String, String>form = new HashMap<String, String>();

		newTrajet = new Trajet(ptdepart,ptarrivee, "");
		request.setAttribute("newTrajetCherché", newTrajet);

		String errPtDepart = validationTrajet.validateAdresse(ptdepart) ;
		if(errPtDepart!=null){
			erreurs.put(FIELD_DPT, errPtDepart);
			form.put(FIELD_DPT, null);
			actionMessage = ECHEC;
		} else {
			form.put(FIELD_DPT, ptdepart);
			actionMessage = SUCCES;
		}

		String errPtArrivee = validationTrajet.validateAdresse(ptarrivee) ;
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

		String errDate = validationTrajet.validateDate(date) ;
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

		String errHeure = validationTrajet.validateHeure(heure) ;
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

		form.put(FIELD_FUMEUR, fumeur);
		form.put(FIELD_MUSIQUE, musique);

		request.setAttribute("form", form);
		request.setAttribute("erreurs", erreurs);
		request.setAttribute("actionMessage", actionMessage);

		if (actionMessage.equals(SUCCES)){
			trajetsCherchés.put(connectedUser.getName(), newTrajet);
			application.setAttribute( "trajetsCherchés", trajetsCherchés );
			//TODO Rediriger vers une page qui affiche les trajets trouvés
			RequestDispatcher dispat = request.getRequestDispatcher("/index.jsp");
			dispat.forward(request,response);
		} else{
			request.setAttribute("errorStatus", false); 
			RequestDispatcher dispat = request.getRequestDispatcher(VIEW_PAGES_URL);
			dispat.forward(request,response);
		}
	}
	
	

}
