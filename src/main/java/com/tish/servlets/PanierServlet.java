package com.tish.servlets;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tish.dao.TshirtDAO;
import com.tish.database.DatabaseConnection;
import com.tish.entities.Tshirt;
import com.tish.entities.TshirtItem;

@WebServlet("/panier")
public class PanierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PanierServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<TshirtItem> panier = new ArrayList<TshirtItem>();

		panier = (List<TshirtItem>) session.getAttribute("pannier");

		List<Tshirt> tshirts = new ArrayList<Tshirt>();
		TshirtDAO tshirtDAO = new TshirtDAO(DatabaseConnection.getInstance());
		if (panier != null) {
			for (TshirtItem item : panier) {
				Tshirt tshirt = tshirtDAO.find(item.getIdTshirt());
				tshirts.add(tshirt);
			}
		}

		String uploadPath = getServletContext().getContextPath() + File.separator + "uploads" + File.separator;
		request.setAttribute("upload_path", uploadPath);

		request.setAttribute("liste_tshirts", tshirts);
		request.getRequestDispatcher("/WEB-INF/jsp/pages/panier.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
