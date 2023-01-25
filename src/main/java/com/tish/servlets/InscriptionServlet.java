package com.tish.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tish.dao.UserDAO;
import com.tish.database.DatabaseConnection;
import com.tish.entities.User;

/**
 * Servlet implementation class InscriptionServlet
 */
@WebServlet("/inscription")
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InscriptionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("connexionReussie", false);
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/pages/inscription.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pseudo = request.getParameter("pseudo");
		String motDePasse = request.getParameter("motdepasse");
		String numeroTelephone = request.getParameter("numerotel");
		UserDAO userDAO = new UserDAO(DatabaseConnection.getInstance());
		User newUser = new User(pseudo, motDePasse, numeroTelephone);
		if (userDAO.create(newUser)) {
			request.setAttribute("connexionReussie", true);
			this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/pages/inscription.jsp").forward(request,
					response);
		} else {
			response.getWriter().append("Error creating user " + pseudo);
			doGet(request, response);
		}
		;
	}

}
