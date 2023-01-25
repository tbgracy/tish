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

@WebServlet("/connexion")
public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ConnexionServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String error = (String) request.getAttribute("error");
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/pages/connexion.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pseudo = request.getParameter("pseudo");
		String motDePasse = request.getParameter("motdepasse");
		UserDAO userDAO = new UserDAO(DatabaseConnection.getInstance());
		User wannaConnectUser = userDAO.find(pseudo);
		if (wannaConnectUser != null) {
			if (wannaConnectUser.getMotDePasse().equals(motDePasse)) {
				// session
				response.sendRedirect("accueil");
			} else {
				response.sendRedirect("connexion?error=motdepasse");
			}
		} else {
			response.sendRedirect("connexion?error=usernotfound");
		}
	}

}
