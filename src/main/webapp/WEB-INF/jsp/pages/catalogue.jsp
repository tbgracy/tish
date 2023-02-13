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
<title>tish | Catalogue</title>
</head>
<body>
	<jsp:include page='../composants/navbar.jsp' />
	<main class='container'>
		<section id="shirt-catalog">
			<%
			List<Tshirt> liste_tshirt = (ArrayList<Tshirt>) request.getAttribute("liste_tshirt");
			%>
			<%
			for (Tshirt tshirt : liste_tshirt) {
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
			%>
		</section>
	</main>
	<jsp:include page='../composants/footer.jsp' />
</body>
</html>