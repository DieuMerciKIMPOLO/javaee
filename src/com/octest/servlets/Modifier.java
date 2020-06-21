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
 * Servlet implementation class Modifier
 */
@WebServlet("/Modifier")
public class Modifier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Modifier() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String str_id = request.getParameter("id");
		int id = Integer.parseInt(str_id);
		DBConnect db=new DBConnect();
		request.setAttribute("user", db.recupererUtilisateur(id));
		this.getServletContext().getRequestDispatcher("/WEB-INF/modifier.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String str_id = request.getParameter("id");
		int id = Integer.parseInt(str_id);
		System.out.print("==================================");
		System.out.print(id);
		String nom =request.getParameter("nom");
		String prenom =request.getParameter("prenom");
		String email =request.getParameter("email");
		String adresse =request.getParameter("adresse");
		Utilisateurs User = new Utilisateurs();
		User.setNom(nom);
		User.setPrenom(prenom);
		User.setAdresse(adresse);
		User.setEmail(email);
		User.setId(id);
		User.setMotDePasse("");
		DBConnect db=new DBConnect();
		db.updateUser(User);
		response.sendRedirect("/test/list");
	}

}
