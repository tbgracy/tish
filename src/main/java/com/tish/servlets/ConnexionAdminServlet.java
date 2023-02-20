package com.tish.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tish.dao.AdminDAO;
import com.tish.dao.UserDAO;
import com.tish.database.DatabaseConnection;
import com.tish.entities.Admin;
import com.tish.entities.User;

@WebServlet("/connexion-admin")
public class ConnexionAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ConnexionAdminServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String error = (String) request.getAttribute("error");
		request.setAttribute("isAdmin", true);
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/pages/connexion.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pseudo = request.getParameter("pseudo");
		String motDePasse = request.getParameter("motdepasse");

		AdminDAO adminDAO = new AdminDAO(DatabaseConnection.getInstance());
		Admin wannaConnectAdmin = adminDAO.find(pseudo);
		if (wannaConnectAdmin != null) {
			if (wannaConnectAdmin.getMotDePasse().equals(motDePasse)) {
				HttpSession session = request.getSession();
				session.setAttribute("user", wannaConnectAdmin);
				session.setAttribute("username", wannaConnectAdmin.getNomUtilisateur());
				response.sendRedirect("gestion_tshirt");
			} else {
				response.sendRedirect("connexion-admin?message=Mot de passe incorrect");
			}
		} else {
			response.sendRedirect("connexion-admin?message=Administrateur non existant");
		}

	}

}
