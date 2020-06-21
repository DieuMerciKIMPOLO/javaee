package com.octest.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.octest.db.DBConnect;
import com.octest.models.LoginAuthen;
import com.octest.models.Utilisateurs;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        this.getServletContext().getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginAuthen login =new LoginAuthen();
		List<Utilisateurs> authen = new ArrayList<Utilisateurs>();
		login.setEmail(request.getParameter("email"));
		login.setMotDePasse(request.getParameter("motDepasse"));
		DBConnect db=new DBConnect();
		authen=db.LoginAuthen(login);
		HttpSession session =request.getSession();
		if(authen.size()>0) {
				session.setAttribute("user",authen.get(0));
				request.setAttribute("authen", authen.get(0));
		}else {
			request.setAttribute("error", "Verifier l'exactitude de votre mot de passe et votre email!!");
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);

	}

}
