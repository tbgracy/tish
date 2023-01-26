package com.tish.servlets;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class GestionTshirtServlet
 */
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/pages/gestion_tshirt.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		String couleur = request.getParameter("couleur");
//		String taille = request.getParameter("taille");
//		// mila try block
//		Integer nombre = Integer.valueOf(request.getParameter("nombre"));
//		Integer prix = Integer.valueOf(request.getParameter("pu"));
//		//

		Part filePart = request.getPart("motif");
		String filename = filePart.getSubmittedFileName();
		System.out.println(getServletContext().getRealPath(request.getContextPath()));
		File motif = new File(getServletContext().getRealPath(request.getContextPath()) + filename);
		motif.createNewFile();
		for (Part part : request.getParts()) {
			part.write(getServletContext().getRealPath(request.getContextPath() + "/uploads/" + filename));
		}
		System.out.println(request.getContextPath());
		System.out.println("File uploaded successfully to : ");
		doGet(request, response);
	}

}