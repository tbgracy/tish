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
				<img
					src="<%=(String) request.getAttribute("upload_path") + tshirt.getMotif()%>"
					alt="<%=tshirt.getMotif()%>" />
					<div class='tshirt-color' style='background-color: <%=tshirt.getCouleur()%>'></div>
				<footer>
					<span><%= tshirt.getPrix()%> Ar</span>
					<span><%= tshirt.getTaille() %></span>
					<div class="grid-fluid">
						<a href="ajouter_dans_panier?idTshirt=<%=tshirt.getIdTShirt()%>"
							role='button'>Ajouter dans le panier</a>
					</div>
				</footer>
			</article>
			<%
			}
			%>
		</section>
	</main>
	<jsp:include page='../composants/footer.jsp' />
</body>
</html>