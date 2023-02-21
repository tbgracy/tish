package com.tish.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tish.dao.CommandeDAO;
import com.tish.database.DatabaseConnection;

@WebServlet("/tableau_de_bord")
public class TableauDeBordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommandeDAO commandeDAO = new CommandeDAO(DatabaseConnection.getInstance());
       
    public TableauDeBordServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int nombreCommande = commandeDAO.getAll().size();
		request.setAttribute("nombreCmd", nombreCommande);
		request.getRequestDispatcher("/WEB-INF/jsp/pages/tableau_de_bord.jsp").forward(request, response);
	}

}
