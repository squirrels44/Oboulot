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


/**
 * Servlet implementation class Inscription
 */
@WebServlet("/formInscription")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String VIEW_PAGES_URL="/WEB-INF/compte/inscription/formulaireInscription.jsp";
	public static final String FIELD_NAME = "name";
	public static final String FIELD_EMAIL = "email"; 
	public static final String FIELD_TEL = "tel";
	public static final String FIELD_PWD1 = "pwd1"; 
	public static final String FIELD_PWD2 = "pwd2";
	public static final String SUCCES = "Succès de l'inscription";
	public static final String ECHEC = "Echec de l'inscription";
	public static String actionMessage;
	User newUser=null;

       
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
		
		HttpSession session = request.getSession();
		ServletContext application = request.getServletContext();
		
		String email = request.getParameter(FIELD_EMAIL);
		String pwd1 = request.getParameter(FIELD_PWD1);
		String pwd2 = request.getParameter(FIELD_PWD2);
		String name = request.getParameter(FIELD_NAME);
		String tel = request.getParameter(FIELD_TEL);
		
		Map<String, User> users = (HashMap<String, User>) application.getAttribute("users");
		if(users==null){
			users = new HashMap<String, User>();
			User admin = new User("Admin", "admin@gmail.com", "123456", "0611223344");
			users.put("Admin", admin);
			application.setAttribute( "users", users );
		}
		
		HashMap<String, String>erreurs = new HashMap<String, String>();
		HashMap<String, String>form = new HashMap<String, String>();
		
		newUser = new User(name,email,pwd1, tel);
		request.setAttribute("newUser", newUser);
		
		String errEmail = validateEmail(email) ;
		if(errEmail!=null){
			erreurs.put(FIELD_EMAIL, errEmail);
			form.put(FIELD_EMAIL, null);
			actionMessage = ECHEC;
		} else {
			form.put(FIELD_EMAIL, email);
			actionMessage = SUCCES;
		}
		
		String errPwd = validatePwd(pwd1, pwd2) ;
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
		
		String errName = validateName(name, users) ;
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
		
		String errTel = validateTel(tel) ;
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
		
		if (actionMessage.equals(SUCCES)){
			users.put(newUser.getName(), newUser);
			application.setAttribute( "users", users );
			session.setAttribute("connectedUser", newUser);
			RequestDispatcher dispat = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
			dispat.forward(request,response);
		} else{
			request.setAttribute("errorStatus", false); 
			RequestDispatcher dispat = request.getRequestDispatcher(VIEW_PAGES_URL);
			dispat.forward(request,response);
		}
	}
	
	
	private String validateEmail( String email ){ 
		if ( email != null && email.trim().length() != 0 ) {
			if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) { 
				return "Veuillez saisir une adresse mail valide";
			} 
		} else { 
			return "L'adresse mail est obligatoire"; 
		}
		return null ;
	}
	
	private String validatePwd(String pwd1, String pwd2){
		if (pwd1 != null && pwd1.trim().length() > 5){
			if (pwd2 != null && pwd2.trim().length() != 0){
				if (!pwd1.equals(pwd2)){
					return "La confirmation du mot de passe est invalide";
				}
			} else{
				return "Veuillez confirmer votre mot de passe";
			}
		} else {
			return "Le mot de passe est obligatoire et doit contenir au moins 6 caractères";
		}
		return null;
	}
	
	private String validateTel( String tel ){ 
		if ( tel != null && tel.trim().length() == 10 ) {
			if ( !tel.startsWith("0")) { 
				return "Veuillez saisir un numéro de téléphone valide";
			} 
		} else { 
			return "Le numéro de téléphone est obligatoire"; 
		}
		return null ;
	}
	
	private String validateName( String name, Map<String, User> users ){ 
		if ( name != null && name.trim().length() != 0 ) {
			if (users.keySet().contains(name)){
				return "Ce nom est déjà utilisé";
			}
		} else { 
			return "Le nom d'utilisateur est obligatoire"; 
		}
		return null ;
	}

}
