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
		boolean isAdmin = request.getParameter("isAdmin") == "true" ? true : false;
		if (isAdmin) {
			AdminDAO adminDAO = new AdminDAO(DatabaseConnection.getInstance());
			Admin wannaConnectAdmin = adminDAO.find(pseudo);
			if (wannaConnectAdmin != null) {
				if (wannaConnectAdmin.getMotDePasse().equals(motDePasse)) {
					HttpSession session = request.getSession();
					session.setAttribute("user", wannaConnectAdmin);
					response.sendRedirect("gestion_tshirt");
				} else {
					response.sendRedirect("connexion?error=motdepasse&admin=true");
				}
			} else {
				response.sendRedirect("connexion?error=usernotfound&admin=true");
			}
		} else {
			UserDAO userDAO = new UserDAO(DatabaseConnection.getInstance());
			User wannaConnectUser = userDAO.find(pseudo);
			if (wannaConnectUser != null) {
				if (wannaConnectUser.getMotDePasse().equals(motDePasse)) {
					HttpSession session = request.getSession();
					session.setAttribute("user", wannaConnectUser);
					response.sendRedirect("accueil");
				} else {
					response.sendRedirect("connexion?error=motdepasse");
				}
			} else {
				response.sendRedirect("connexion?error=usernotfound");
			}
		}
	}

}
