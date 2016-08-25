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
	public static final String FIELD_NAME = "name";
	public static final String FIELD_EMAIL = "email"; 
	public static final String FIELD_TEL = "tel";
	public static final String FIELD_PWD1 = "pwd1"; 
	public static final String FIELD_PWD2 = "pwd2";
	public static final String SUCCES = "Succès de l'inscription";
	public static final String ECHEC = "Echec de l'inscription";
	public static String actionMessage;
	User newUser=null;
	ValidationUser validationUser;
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

		HttpSession session = request.getSession();
		ServletContext application = request.getServletContext();

		String email = request.getParameter(FIELD_EMAIL);
		String pwd1 = request.getParameter(FIELD_PWD1);
		String pwd2 = request.getParameter(FIELD_PWD2);
		String name = request.getParameter(FIELD_NAME);
		String tel = request.getParameter(FIELD_TEL);


		
		//On va vérifier que la liste user existe et si elle existe  
		Map<String, User> users = UserService.getInstance().getUserMap();
//		Map<String, User> users = (HashMap<String, User>) application.getAttribute("users");		
		
		HashMap<String, String>erreurs = new HashMap<String, String>();
		HashMap<String, String>form = new HashMap<String, String>();

		newUser = new User(name,email,pwd1, tel);
		request.setAttribute("newUser", newUser);

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

		if (actionMessage.equals(SUCCES)){
			users.put(newUser.getName(), newUser);
			application.setAttribute( "users", users );
			session.setAttribute("connectedUser", newUser);
			RequestDispatcher dispat = request.getRequestDispatcher("/index.jsp");
			dispat.forward(request,response);
		} else{
			request.setAttribute("errorStatus", false); 

			//RequestDispatcher dispat = request.getRequestDispatcher(VIEW_PAGES_URL);
			//dispat.forward(request,response);

			response.sendRedirect("inscription");

		}
	}
}
