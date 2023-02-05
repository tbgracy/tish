<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="com.tish.entities.Tshirt, java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/ressources/styles/pico.min.css">
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/ressources/styles/style.css">
<title>Modification de t-shirts | Admin</title>
</head>
<body>
	<jsp:include page="../composants/navbar.jsp" />
	<% Tshirt tshirt = (Tshirt) request.getAttribute("tshirt"); %>
	<main class="container">
		<form action="modification_tshirt" method='POST'>
			<a href="#close" aria-label="Close" class="close"
				onclick="fermerMessage(event)"></a>
			<h3>Modifier t-shirt</h3>
			<img src="" alt="">
			<fieldset>
				<label for="mofif"> Motif sur le t-shirt <input type="file"
					name="motif" id="motif" accept=".png, .jpg, .jpeg" required>
				</label>
				<div class="grid">
					<label for="couleur" value="<%= tshirt.getCouleur()%>"> Couleur du t-shirt <input
						type="color" name="couleur" id="couleur" required>
					</label> <label for="taille">Taille <select id="taille"
						name="taille" required>
							<option <% if (tshirt.getTaille().equals("S")) { %>selected<% } %>>S</option>
							<option <% if (tshirt.getTaille().equals("M")) { %>selected<% } %>>M</option>
							<option <% if (tshirt.getTaille().equals("L")) { %>selected<% } %>>L</option>
							<option <% if (tshirt.getTaille().equals("XL")) { %>selected<% } %>>XL</option>
					</select></label>
				</div>
			</fieldset>
			<fieldset class="grid">
				<label for="nombre">Nombre en stock <input type="number"
					name="nombre" id="nombre" value=<%= tshirt.getNombre() %> required></label> <label for="pu">Prix
					unitaire <input type="number" name="pu" id="pu" required>
				</label>
			</fieldset>
			<input type="number" name="idTshirt" id="idTshirt" value="<%= tshirt.getIdTShirt() %>" hidden>
			<button>Enregistrer les modifications</button>
			<a role='button' href='gestion_tshirt'>Annuler</a>
		</form>
	</main>
	<script
		src="${ pageContext.request.contextPath }/ressources/scripts/script.js"></script>
</body>
</html>