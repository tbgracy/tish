<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.util.List, com.tish.entities.Tshirt, java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/ressources/styles/pico.min.css">
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/ressources/styles/style.css">
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/ressources/styles/accueil.css">
<title>tish</title>
</head>
<body>
	<jsp:include page='../composants/navbar.jsp' />
	<main class="container">
		<section id='call-to-action' class='grid'>
			<figure>
				<img src="${pageContext.request.contextPath }/ressources/images/land.jpg" alt="some t-shirts">
				<figcaption>
					Image gratuite trouvée sur <a href="http://pexels.com/">pexels</a>
				</figcaption>
			</figure>
			<section>
			<div>
				<h3 style="margin-bottom: 25px;"> 
					Bienvenu sur <u>tish</u><span style="color: #00897b;">.</span>
				</h3>
				<p>Votre t-shirt est bien plus qu'un simple vêtement, c'est un
					moyen d'expression de votre personnalité et de vos convictions.
					Alors affirmez-vous avec style et montrez au monde qui vous êtes
					grâce à notre collection de t-shirts uniques et originaux.</p>
				<a role="button" href="catalogue">Parcourir le catalogue</a>
			</div>
			</section>
		</section>
		<section>
			<h2>Populaires en ce moment</h2>
		<section id="shirt-catalog">
			<%
			List<Tshirt> liste_tshirt = (ArrayList<Tshirt>) request.getAttribute("liste_tshirt");
			%>
			<%
			if (! liste_tshirt.isEmpty()){
				 int len = liste_tshirt.size() > 3 ? 3 : liste_tshirt.size();
			for (Tshirt tshirt : liste_tshirt.subList(0, len)) {
			%>
			<article class="shirt-item">
			<header>
				<img
					src="<%=(String) request.getAttribute("upload_path") + tshirt.getMotif()%>"
					alt="<%=tshirt.getMotif()%>" />
					<div class='shirt-color' style="background-color: <%= tshirt.getCouleur() %>"></div>
			</header>
			<div class='shirt-price'><b><%= tshirt.getFormatedPrix() %> MGA</b></div>
			<div class='shirt-count'>Taille <%= tshirt.getTaille() %></div>
				<!-- footer -->
					<form action='ajouter_dans_panier' style="margin-bottom: 0">
					<div class="grid-fluid">
					<input type='number' min='1' max='<%= tshirt.getNombre() %>' placeholder='Quantité'>
					<input type='number' value='<%= tshirt.getIdTShirt() %>' hidden>
					<button>Ajouter dans le panier</button>
					</div>
					</form>
				<!-- /footer -->
			</article>
			<%
			}
			}
			%>
		</section> 
		</section>
	</main>
	<jsp:include page='../composants/footer.jsp' />
</body>
</html>