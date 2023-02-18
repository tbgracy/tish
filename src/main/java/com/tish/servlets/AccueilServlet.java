package com.tish.servlets;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tish.dao.TshirtDAO;
import com.tish.database.DatabaseConnection;
import com.tish.entities.Tshirt;

/**
 * Servlet implementation class AccueilServlet
 */
@WebServlet({"/accueil", ""})
public class AccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccueilServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TshirtDAO tshirtDAO = new TshirtDAO(DatabaseConnection.getInstance());
		List<Tshirt> liste_tshirt = tshirtDAO.getAll();
		request.setAttribute("liste_tshirt", liste_tshirt);
		String uploadPath = getServletContext().getContextPath() + File.separator + "uploads" + File.separator;
		request.setAttribute("upload_path", uploadPath);
		request.getRequestDispatcher("/WEB-INF/jsp/pages/accueil.jsp").forward(request, response);
	}

}
