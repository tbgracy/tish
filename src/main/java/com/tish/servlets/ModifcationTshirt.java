package com.tish.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tish.dao.TshirtDAO;
import com.tish.database.DatabaseConnection;
import com.tish.entities.Tshirt;

@WebServlet("/modifcation_tshirt")
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
			request.setAttribute("tshirt", tshirt);
			request.getRequestDispatcher("/WEB-INF/jsp/pages/modification_tshirt.jsp").forward(request, response);
		} else {
			// TODO
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idTshirt = Integer.valueOf(request.getParameter("idTshirt"));
		TshirtDAO tshirtDAO = new TshirtDAO(DatabaseConnection.getInstance());

		Tshirt tshirt = tshirtDAO.find(idTshirt);
		if (tshirt != null) {
			if (tshirtDAO.update(tshirt)) {
				doPost(request, response);
			} else {
				// TODO
			}
		} else {
			// TODO error handling
		}
	}

}
