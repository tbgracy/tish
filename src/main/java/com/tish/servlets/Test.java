package com.tish.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tish.dao.UserDAO;
import com.tish.database.DatabaseConnection;
import com.tish.entities.User;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
//		Class.forName("org.sqlite.JDBC");
		
//		AdminDAO admin = new AdminDAO(DatabaseConnection.getInstance());
		System.out.println("connection succes");
//		boolean result = admin.create(new Admin("Naruto", "12213223"));
		UserDAO user = new UserDAO(DatabaseConnection.getInstance());
		String username = (String) request.getParameter("username");
		User getUser = user.find(username);
		response.getWriter().append(String.valueOf(getUser) + "\n");
		try {
			response.getWriter().append(getUser.getNomUtilisateur());
		} catch (Exception e) {
			response.getWriter().append(e.getMessage());
		}
		response.getWriter().append("\n");
		response.getWriter().append(String.valueOf(username));		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
