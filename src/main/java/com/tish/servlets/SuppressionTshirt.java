package com.tish.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tish.dao.TshirtDAO;
import com.tish.database.DatabaseConnection;

/**
 * Servlet implementation class SuppressionTshirt
 */
@WebServlet("/suppression_tshirt")
public class SuppressionTshirt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuppressionTshirt() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idTshirt = Integer.valueOf(request.getParameter("idTshirt"));
		TshirtDAO tshirtDAO = new TshirtDAO(DatabaseConnection.getInstance());
		if (tshirtDAO.delete(idTshirt)) {
			response.sendRedirect("gestion_tshirt");
		} else {
			// TODO: error handling
		}
	}

}
