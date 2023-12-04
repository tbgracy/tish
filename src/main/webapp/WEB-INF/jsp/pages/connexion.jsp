<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/ressources/styles/pico.min.css">
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/ressources/styles/style.css">
<title>tish - Connexion</title>
</head>
<body>
	<% if (!(Boolean) request.getAttribute("isAdmin")){%>
		<jsp:include page="../composants/navbar.jsp" />
	<% } %>
	<main class="grid">
		<div></div>
		<article>
			<form
				action="<%if ((Boolean) request.getAttribute("isAdmin")) {%>connexion-admin<%} else {%>connexion<%}%>"
				method='POST'>

				<h3>
					Connexion
					<%if ((Boolean) request.getAttribute("isAdmin")) {%>
						(admin)
					<%}%>
				</h3>
				<% if (request.getParameter("message") != null) {%>
				<mark>
					<%= request.getParameter("message") %>
				</mark>
				<% } %>
				<label for='pseudo'>Pseudo</label> <input type='text' id='pseudo'
					name='pseudo' placeholder='Votre pseudo' required> <label
					for='motdepasse'>Mot de passe</label> <input type='password'
					id='motdepasse' name='motdepasse' placeholder='Votre mot de passe'
					required>
				<button>Se connecter</button>
				<% if (! (Boolean) request.getAttribute("isAdmin")) { %>
				<p>
					Pas encore de compte? S'inscrire <a href="inscription">ici</a>.
				</p>
				<% } %>
			</form>
		</article>
		<div></div>
	</main>
</body>
</html>