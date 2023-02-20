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

import com.tish.dao.CommandeDAO;
import com.tish.dao.TshirtItemDAO;
import com.tish.database.DatabaseConnection;
import com.tish.entities.Commande;
import com.tish.entities.TshirtItem;
import com.tish.entities.User;

@WebServlet("/commander_tshirt")
public class CommanderTshirt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommandeDAO commandeDAO = new CommandeDAO(DatabaseConnection.getInstance());
	private TshirtItemDAO tshirtItemDAO = new TshirtItemDAO(DatabaseConnection.getInstance());

	public CommanderTshirt() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

//		@SuppressWarnings("unchecked")
		List<TshirtItem> pannier = (List<TshirtItem>) session.getAttribute("pannier");
		
		List<TshirtItem> pannier_vide = new ArrayList<TshirtItem>();
		
		if (pannier != null) {
			for (TshirtItem item : pannier) {
				Commande commande = new Commande(user.getIdUtilisateur());
				if (commandeDAO.create(commande)) {
					item.setIdCmd(commande.getIdCmd());
					if (tshirtItemDAO.create(item)) {
						session.setAttribute("pannier", pannier_vide);
						response.sendRedirect("catalogue");
						return;
					}
				} else {
//					System.out.println("creation de commande a échoué");
				}
			}
		} else {
//			System.out.println("il n'y a pas de item dans le pannier");
		}
	}

}
