package com.tish.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tish.entities.Admin;

@WebFilter(
		urlPatterns = {"/gestion_tshirt", "/tableau_de_bord"}, 
		servletNames = { 
				"GestionTshirtServlet", 
				"SuppressionTshirt", 
				"ModifcationTshirt"
		})
public class ConnexionAdminFilter extends HttpFilter implements Filter {
       
    private static final String UTILISATEUR_SESSION = "user";

	public ConnexionAdminFilter() {
        super();
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		HttpSession session = req.getSession();
		
		if (session.getAttribute(UTILISATEUR_SESSION) != null) {
			try {
				Admin admin = (Admin) session.getAttribute(UTILISATEUR_SESSION);
				chain.doFilter(req, res);
			} catch (Exception e) {
				System.out.println(e);
				res.sendRedirect(req.getContextPath() + "/connexion-admin");
			}
		} else {
			res.sendRedirect(req.getContextPath() + "/connexion-admin");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
