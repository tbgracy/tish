package com.tish.servlets;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.tish.dao.TshirtDAO;
import com.tish.database.DatabaseConnection;
import com.tish.entities.Tshirt;

@WebServlet("/gestion_tshirt")
@MultipartConfig(
//		fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
//		maxFileSize = 1024 * 1024 * 10, // 10 MB
//		maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class GestionTshirtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GestionTshirtServlet() {
		super();
	}

	String UPLOAD_DIRECTORY = "uploads";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TshirtDAO tshirtDAO = new TshirtDAO(DatabaseConnection.getInstance());

		List<Tshirt> liste_tshirt = tshirtDAO.getAll();
		request.setAttribute("liste_tshirt", liste_tshirt);
		String uploadPath = getServletContext().getContextPath() + File.separator + UPLOAD_DIRECTORY + File.separator;
		request.setAttribute("upload_path", uploadPath);

		request.getRequestDispatcher("/WEB-INF/jsp/pages/gestion_tshirt.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String couleur = request.getParameter("couleur");
		String taille = request.getParameter("taille");
		// mila try block
		Integer nombre = Integer.valueOf(request.getParameter("nombre"));
		Integer prix = Integer.valueOf(request.getParameter("pu"));
		String motif = request.getPart("motif").getSubmittedFileName();

		String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists())
			uploadDir.mkdir();

		String filename = "";

		for (Part part : request.getParts()) {
			filename = part.getSubmittedFileName();
			part.write(uploadPath + File.separator + filename);
		}

		Tshirt tshirt = new Tshirt(motif, couleur, nombre, taille, prix);
		TshirtDAO tshirtDAO = new TshirtDAO(DatabaseConnection.getInstance());
		if (tshirtDAO.create(tshirt)) {
			doGet(request, response);
		} else {
			// error handling
		}

	}

}