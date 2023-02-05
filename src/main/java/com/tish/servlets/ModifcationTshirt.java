package com.tish.servlets;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tish.dao.TshirtDAO;
import com.tish.database.DatabaseConnection;
import com.tish.entities.Tshirt;

@WebServlet("/modification_tshirt")
public class ModifcationTshirt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ModifcationTshirt() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		TshirtDAO tshirtDAO = new TshirtDAO(DatabaseConnection.getInstance());
		int idTshirt = Integer.valueOf(request.getParameter("idTshirt"));
		Tshirt tshirt = tshirtDAO.find(idTshirt);
		if (tshirt != null) {
			String uploadPath = getServletContext().getContextPath() + File.separator + "uploads" + File.separator;
			request.setAttribute("upload_path", uploadPath);
			request.setAttribute("tshirt", tshirt);
		} else {
			request.setAttribute("erreur", "cette id n'existe pas dans la base de donné");
		}
		request.getRequestDispatcher("/WEB-INF/jsp/pages/modification_tshirt.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idTshirt = Integer.valueOf(request.getParameter("idTshirt"));
		TshirtDAO tshirtDAO = new TshirtDAO(DatabaseConnection.getInstance());

		Tshirt tshirt = tshirtDAO.find(idTshirt);
		if (tshirt != null) {
			if (tshirtDAO.update(tshirt)) {
				response.sendRedirect("gestion_tshirt");
			} else {
				request.setAttribute("erreur", "le modification a echoué!");
				request.getRequestDispatcher("/WEB-INF/jsp/pages/modification_tshirt.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("erreur", "cette id n'existe pas dans la base de donné");
			request.getRequestDispatcher("/WEB-INF/jsp/pages/modification_tshirt.jsp").forward(request, response);
		}
	}

}
