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
import com.tish.dao.TshirtDAO;
import com.tish.dao.TshirtItemDAO;
import com.tish.database.DatabaseConnection;
import com.tish.entities.Commande;
import com.tish.entities.Tshirt;
import com.tish.entities.TshirtItem;
import com.tish.entities.User;

@WebServlet("/commander_tshirt")
public class CommanderTshirt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommandeDAO commandeDAO = new CommandeDAO(DatabaseConnection.getInstance());
	private TshirtItemDAO tshirtItemDAO = new TshirtItemDAO(DatabaseConnection.getInstance());
	private TshirtDAO tishDAO = new TshirtDAO(DatabaseConnection.getInstance());

	public CommanderTshirt() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

//		@SuppressWarnings("unchecked")
		List<TshirtItem> panier = (List<TshirtItem>) session.getAttribute("pannier");

		List<TshirtItem> panier_vide = new ArrayList<TshirtItem>();

		if (panier != null) {
			for (TshirtItem item : panier) {
				Commande commande = new Commande(user.getIdUtilisateur());
				if (commandeDAO.create(commande)) {
					item.setIdCmd(commande.getIdCmd());
					if (tshirtItemDAO.create(item)) {

						int quantiteCmd = item.getQuantite();
						Tshirt tish = tishDAO.find(item.getIdTshirt());
						int nombreUpdate = tish.getNombre() - quantiteCmd;

						tish.setNombre(nombreUpdate);

						tishDAO.update(tish);

						session.setAttribute("pannier", panier_vide);
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
