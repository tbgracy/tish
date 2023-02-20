package com.tish.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/tableau_de_bord")
public class TableauDeBordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TableauDeBordServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int nombre_commandes = 0;
		request.setAttribute("nombre_commandes", nombre_commandes);
		request.getRequestDispatcher("/WEB-INF/jsp/pages/tableau_de_bord.jsp").forward(request, response);
	}

}
