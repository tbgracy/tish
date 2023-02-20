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

import com.tish.entities.TshirtItem;

@WebServlet("/vider_panier")
public class ViderPanier extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViderPanier() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<TshirtItem> panier_vide = new ArrayList<TshirtItem>();
		HttpSession session = request.getSession();
		session.setAttribute("pannier", panier_vide);
		response.sendRedirect("panier");
		return;
	}

}
