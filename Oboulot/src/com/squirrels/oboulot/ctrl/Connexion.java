package com.squirrels.oboulot.ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.squirrels.oboulot.bean.User;
import com.squirrels.oboulot.service.UserService;
import com.squirrels.oboulot.service.ValidationInterface;
import com.squirrels.oboulot.service.ValidationNo;
import com.squirrels.oboulot.service.ValidationUser;


/**
 * Servlet implementation class Login
 */
@WebServlet("/formConnexion")
public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String VIEW_PAGES_URL="/WEB-INF/compte/formulaireConnexion.jsp";
	public static String VIEW_PAGES_URL2="/index.jsp";
	public static final String FIELD_PWD = "pwd";
	public static final String FIELD_NAME = "name";
	
	ValidationUser validationUser;
	ValidationInterface validator;
	

	public ValidationInterface getValidator() {
		if(validator==null){
			validator=new ValidationNo();
		}
		return validator;
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Connexion() {
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

		HttpSession session=request.getSession();
		ServletContext application = request.getServletContext();

		response.setContentType("text/html;charset=UTF-8");
		@SuppressWarnings("unused")
		PrintWriter out = response.getWriter();

		//Accés aux parametres de connexion (rentrés par l'utilisateur : connexion)
		String pwd = request.getParameter(FIELD_PWD);
		String name = request.getParameter(FIELD_NAME);
		
		//Accès aux parametres de connexion (rentrés par l'utilisateur : inscription)
		String nameInscription = request.getParameter(Inscription.FIELD_NAME);
		String pwdInscription = request.getParameter(Inscription.FIELD_PWD1);


		Map<String, String> form = new HashMap<String, String>(); 

		//Traitement des erreurs
		Map<String, String> erreurs = new HashMap<String, String>();
		String actionMessage = "";
		String errName = validationUser.validateNameConnexion(name, nameInscription);
		String errPwd = validationUser.validatePwdConnexion(pwd, pwdInscription);

		//Si le message d'erreur n'est pas null
		if(errPwd!=null){	
			erreurs.put(FIELD_PWD, errPwd);
		} 

		if(errName!=null){
			erreurs.put(FIELD_NAME, errName);
		}

		//Si le message d'erreur est null
		if((errPwd==null)&&(errName==null)){
			form.put(FIELD_PWD, pwd);
			form.put(FIELD_NAME, name);

			// L'utilisateur existe ! Donc il est dans users (SessionScope)
			User connectedUser= null;
			
			//On crée le singleton s'il n'existe pas
			UserService userService = UserService.getInstance();
			
			//On va chercher l'attribut dans la classe UserService
			Map<String, User> users = userService.getUserMap();
			
			//Map<String, User> users = (HashMap<String, User>) application.getAttribute("users");

			connectedUser= users.get(name);
			session.setAttribute("connectedUser", connectedUser);
			actionMessage ="Bienvenue " + connectedUser.getName() + ", Besoin d'un covoiturage ?";
			request.setAttribute("actionMessage", actionMessage); 



			this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL2).forward(request, response);


		}
		else{
			if (errPwd!=null){
				actionMessage = erreurs.get(FIELD_PWD);
			}
			else if (errName!=null){actionMessage = erreurs.get(FIELD_NAME);}

			//hashmap pour conserver les erreurs
			request.setAttribute("erreurs", erreurs);
			//String pour afficher un message de retour à l'action
			request.setAttribute("actionMessage", actionMessage);
			//précise si l'enregistrement a échoué
			request.setAttribute("errorStatus", false);

			this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).forward(request, response);
		}
	}
}
