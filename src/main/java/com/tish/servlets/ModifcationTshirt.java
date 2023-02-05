package com.tish.servlets;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.tish.dao.TshirtDAO;
import com.tish.database.DatabaseConnection;
import com.tish.entities.Tshirt;

@WebServlet("/modification_tshirt")
public class ModifcationTshirt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final TshirtDAO tshirtDAO = new TshirtDAO(DatabaseConnection.getInstance());
	private String UPLOAD_DIRECTORY = "uploads";

	public ModifcationTshirt() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		String motif = request.getParameter("motif");
		String couleur = request.getParameter("coleur");
		int nombre = Integer.valueOf(request.getParameter("nombre"));
		String taille = request.getParameter("taille");
		int prix = Integer.valueOf(request.getParameter("pu"));
		Tshirt new_tshirt = new Tshirt(idTshirt, motif, couleur, nombre, taille, prix);

		Tshirt old_tshirt = tshirtDAO.find(idTshirt);

		if (old_tshirt.getMotif() != new_tshirt.getMotif()) {
			String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
			File uploadDir = new File(uploadPath);
			if (!uploadDir.exists())
				uploadDir.mkdir();
			
			String filename = "";
			
			for (Part part: request.getParts()) {
				filename = part.getSubmittedFileName();
				part.write(uploadPath + File.separator + filename); 
			}
			System.out.println("File uploaded successfully to : " + uploadPath + File.separator + filename);
		}

		if (tshirtDAO.update(new_tshirt)) {
			response.sendRedirect("gestion_tshirt");
		} else {
			request.setAttribute("erreur", "le modification a echoué!");
			request.getRequestDispatcher("/WEB-INF/jsp/pages/modification_tshirt.jsp").forward(request, response);
		}

	}

}
