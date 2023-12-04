<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="ressources/styles/pico.min.css">
<link rel="stylesheet" href="ressources/styles/style.css">
<title>tish | Une erreur s'est produite</title>
<style>
.error-container {
	text-align: center;
}
</style>
</head>
<body>
	<nav>
		<ul>
			<!--<li>
                <div id="logo"><img src="${pageContext.request.contextPath}/ressources/images/tish-logo.png" alt="logo_tish"></div>
            </li>-->
			<li>
			<a href="accueil">
					<h3>
						tish<span style="color: #00897b;">.</span>
					</h3>
				</a>
			</li>
			<li><a href="accueil">Accueil</a></li>
			<li><a href="catalogue">Catalogue</a></li>
		</ul>
		<ul>
			<%
			if (session.getAttribute("user") == null) {
			%>
			<li><a href="connexion">Connexion</a></li>
			<li><a href="inscription">Inscription</a></li>
			<%
			} else {
			%>
			<li><a href="deconnexion?user_id">Déconnexion (<%=session.getAttribute("username")%>)
			</a>
			<li>
				<%
				}
				%> <%@ page
					import="java.util.List, com.tish.entities.Tshirt, java.util.ArrayList, com.tish.entities.TshirtItem"%>
				<%
				List<TshirtItem> panier = (List<TshirtItem>) session.getAttribute("pannier");
				int numb;
				if (panier == null) {
					numb = 0;
				} else {
					numb = panier.size();
				}
				%>

			<li><a role="button" href="panier" class='cart-icon'><img
					src="${pageContext.request.contextPath}/ressources/images/cart-icon.png"
					alt="cart-icon"></a><span class='cart-items-count'> <%=numb%>
			</span></li>
		</ul>
	</nav>
	<main class='container error-container'>
		<h4 id='error-title'>Oups ... Une erreur est survenue lors du
			traitement de votre requête.</h4>
		<p class='error-code'>
			Erreur
			<mark><%=response.getStatus()%></mark>
			</mark>
		</p>
		<img id='error-img' src='ressources/images/error_illu.png'
			width='400px'>
	</main>
	<footer class='container'>
		<hr>
		<section class="grid">
			<section>
				<h4>Contact</h4>
				<p>Email: contact@tish.com</p>
				<p>Téléphone: +261 34 42 381 10</p>
			</section>
			<section>
				<h4>A propos de tish</h4>
				<p>Tish est un site de vente de t-shirts en ligne qui vous
					permet d'exprimer votre personnalité à travers vos vêtements. Nous
					croyons que les t-shirts sont plus que des vêtements de base, ils
					peuvent être un moyen de vous faire remarquer et de démontrer votre
					individualité. C'est pourquoi nous proposons une large gamme de
					t-shirts uniques et originaux qui correspondent à différents
					styles, humeurs et occasions.</p>
			</section>
			<section>
				<h4>Suivez-nous sur les réseaux</h4>
				<section>
					<a href="https://facebook.com/tish">Facebook</a> | <a
						href="https://twitter.com/tish">Twitter</a> | <a
						href="https://instagram.com/tish">Instagram</a>
				</section>
			</section>
		</section>
		<a
			href="${pageContext.request.contextPath }/ressources/manuel-tish.pdf">Manuel
			d'utilisation</a>
		<hr>
		&copy; Tsierenana Botramanagna Gracy &amp; Nomeniavo Fitahiana Joe,
		2023
	</footer>
</body>
</html>