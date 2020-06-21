package com.octest.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octest.db.DBConnect;
import com.octest.models.Utilisateurs;
/**
 * Servlet implementation class Inscription
 */
@WebServlet("/Inscription")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inscription() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
        this.getServletContext().getRequestDispatcher("/WEB-INF/Inscription.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String nom =request.getParameter("nom");
			String prenom =request.getParameter("prenom");
			String email =request.getParameter("email");
			String motDePasse = request.getParameter("motDePasse");
			String adresse =request.getParameter("adresse");
			Utilisateurs User = new Utilisateurs();
			User.setNom(nom);
			User.setPrenom(prenom);
			User.setAdresse(adresse);
			User.setEmail(email);
			User.setMotDePasse(motDePasse);
			DBConnect db=new DBConnect();
			db.ajouterUtilisateur(User);
			response.sendRedirect("/test/list");
		}

}
