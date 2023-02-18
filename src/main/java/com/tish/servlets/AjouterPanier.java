package com.tish.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tish.dao.TshirtItemDAO;
import com.tish.entities.TshirtItem;

@WebServlet("/ajouter_dans_panier")
public class AjouterPanier extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AjouterPanier() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<TshirtItem> pannier = new ArrayList<TshirtItem>();

		int idTshirt = Integer.valueOf(request.getParameter("idTshirt"));
		int quantite = Integer.valueOf(request.getParameter("quantite"));
		TshirtItem item = new TshirtItem(idTshirt, quantite);

		// ajouter item dans list pannier
		pannier.add(item);

		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		// verifier si pannier session exist déja et non vide
		List<TshirtItem> oldpannier = (List<TshirtItem>) session.getAttribute("pannier");
		if (oldpannier != null)
			pannier.addAll(oldpannier);

		session.setAttribute("pannier", pannier);
		
		response.sendRedirect("catalogue");

	}

}
