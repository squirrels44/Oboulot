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
import com.squirrels.oboulot.bean.User;
import com.squirrels.oboulot.service.UserService;
import com.squirrels.oboulot.service.ValidationUser;


/**
 * Servlet implementation class Inscription
 */
@WebServlet("/fInscription")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String VIEW_PAGES_URL="/index.jsp";
	//Le champ "name" correspond à un login
	private static final String FIELD_NAME = "name";
	private static final String FIELD_EMAIL = "email"; 
	private static final String FIELD_TEL = "tel";
	private static final String FIELD_PWD1 = "pwd1"; 
	private static final String FIELD_PWD2 = "pwd2";
	public static final String SUCCES = "Succès de l'inscription";
	public static final String ECHEC = "Echec de l'inscription";
	public static String actionMessage;
	User newUser=null;
	ValidationUser validationUser =new ValidationUser();
	UserService userService; 


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Inscription() {
		super();
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

		//On va chercher les Scopes de session et d'application
		HttpSession session = request.getSession();
		ServletContext application = request.getServletContext();
		
		//On récupère ce que l'utilisateur a entré lors de son inscription
		String email = request.getParameter(FIELD_EMAIL);
		String pwd1 = request.getParameter(FIELD_PWD1);
		String pwd2 = request.getParameter(FIELD_PWD2);
		String name = request.getParameter(FIELD_NAME);
		String tel = request.getParameter(FIELD_TEL);


		
		//On va vérifier que la liste user existe et si elle existe  
		Map<String, User> users = UserService.getInstance().getUserMap();		
		
		//Création des HashMap contenant les messages d'erreurs retourné lors des méthodes de 
		//validation des champs ou ce qui a été rentré si pas d'erreur
		HashMap<String, String>erreurs = new HashMap<String, String>();
		HashMap<String, String>form = new HashMap<String, String>();

		//On enregistre temporairement le nouvel utilisateur et s'il va être validé, on l'enverra
		//sur le Scope application
		newUser = new User(name,email,pwd1, tel);
		request.setAttribute("newUser", newUser);

		
		//On verrifie les différents champs avec les méthodes prises dans validationUser
		//s'il y a une erreur, on rentre le message dans la map erreurs, sinon on entre ce
		//qu'a donné l'utilisateur dans la map form. "actionMessage" permet de savoir au final 
		//si tout est validé ou s'il existe une ou plusieurs erreurs
		
		String errEmail = validationUser.validateEmailInscription(email) ;
		if(errEmail!=null){
			erreurs.put(FIELD_EMAIL, errEmail);
			form.put(FIELD_EMAIL, null);
			actionMessage = ECHEC;
		} else {
			form.put(FIELD_EMAIL, email);
			actionMessage = SUCCES;
		}

		String errPwd = validationUser.validatePwdInscription(pwd1, pwd2) ;
		if(errPwd!=null){
			erreurs.put(FIELD_PWD1, errPwd);
			form.put(FIELD_PWD1, null);
			actionMessage = ECHEC;
		} else {
			form.put(FIELD_PWD1, pwd1);
			if (actionMessage.equals(ECHEC)){
				actionMessage=ECHEC;
			}
			else {
				actionMessage=SUCCES;
			}
		}

		String errName = validationUser.validateNameInscription(name, users) ;
		if(errName!=null){
			erreurs.put(FIELD_NAME, errName);
			form.put(FIELD_NAME, null);
			actionMessage = ECHEC;
		} else {
			form.put(FIELD_NAME, name);
			if (actionMessage.equals(ECHEC)){
				actionMessage=ECHEC;
			}
			else {
				actionMessage=SUCCES;
			}
		}

		String errTel = validationUser.validateTelInscription(tel) ;
		if(errTel!=null){
			erreurs.put(FIELD_TEL, errTel);
			form.put(FIELD_TEL, null);
			actionMessage = ECHEC;
		} else {
			form.put(FIELD_TEL, tel);
			if (actionMessage.equals(ECHEC)){
				actionMessage=ECHEC;
			}
			else {
				actionMessage=SUCCES;
			}
		}

		request.setAttribute("form", form);
		request.setAttribute("erreurs", erreurs);
		request.setAttribute("actionMessage", actionMessage);

		//S'il n'y a pas d'erreur, on ajoute un nouvel utilisateur dans le Scope d'application,
		//on le connecte, et on le redirige vers la page index
		if (actionMessage.equals(SUCCES)){
			UserService.getInstance().addUser(newUser);
			application.setAttribute( "users", users );
			session.setAttribute("connectedUser", newUser);
			RequestDispatcher dispat = request.getRequestDispatcher("/index.jsp");
			dispat.forward(request,response);
		//S'il y a des erreurs, on affiche des messages d'erreurs à coté des champs correspondants
		} else{
			request.setAttribute("errorStatus", false); 
			RequestDispatcher dispat = request.getRequestDispatcher(VIEW_PAGES_URL);
			dispat.forward(request,response);
		}
	}
}
