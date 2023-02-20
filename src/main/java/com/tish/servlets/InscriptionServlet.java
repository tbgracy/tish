package com.tish.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tish.Securite;
import com.tish.dao.UserDAO;
import com.tish.database.DatabaseConnection;
import com.tish.entities.User;

@WebServlet("/inscription")
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InscriptionServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("connexionReussie", false);
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/pages/inscription.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pseudo = request.getParameter("pseudo");
		String motDePasse = request.getParameter("motdepasse");
		String motDePasseConf = request.getParameter("motdepasseconf");
		if (!motDePasse.equals(motDePasseConf)) {
			response.sendRedirect("inscription?message=Les mots de passe doivent etre les memes.");
			return;
		}
		String numeroTelephone = request.getParameter("numerotel");
		UserDAO userDAO = new UserDAO(DatabaseConnection.getInstance());
		User newUser = new User(pseudo, Securite.hasher(motDePasse), numeroTelephone);
		if (userDAO.create(newUser)) {
			request.setAttribute("connexionReussie", true);
			this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/pages/inscription.jsp").forward(request,
					response);
		} else {
			response.sendRedirect("inscription?message=Erreur lors de l'ajout de l'utilisateur " + pseudo + ".<br> Veuillez verifier les informations entrees.");
		}
	}

}
