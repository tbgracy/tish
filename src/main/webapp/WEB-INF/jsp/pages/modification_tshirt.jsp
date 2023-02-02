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
<title>Modification de t-shirts | Admin</title>
</head>
<body>
	<jsp:include page="../composants/navbar.jsp" />
	<main class="container">
		<form action="gestion_tshirt" method='POST'>
			<a href="#close" aria-label="Close" class="close"
				onclick="fermerMessage(event)"></a>
			<h3>Modifier t-shirt</h3>
			<img src="" alt="">
			<fieldset>
				<label for="mofif"> Motif sur le t-shirt <input type="file"
					name="motif" id="motif" accept=".png, .jpg, .jpeg" required>
				</label>
				<div class="grid">
					<label for="couleur"> Couleur du t-shirt <input
						type="color" name="couleur" id="couleur" required>
					</label> <label for="taille">Taille <select id="taille"
						name="taille" required>
							<option>S</option>
							<option>M</option>
							<option>L</option>
							<option>XL</option>
					</select></label>
				</div>
			</fieldset>
			<fieldset class="grid">
				<label for="nombre">Nombre en stock <input type="number"
					name="nombre" id="nombre" required></label> <label for="pu">Prix
					unitaire <input type="number" name="pu" id="pu" required>
				</label>
			</fieldset>
			<button>Enregistrer modifications</button>
			<button class='secondary' onclick='fermerMessage(event)'>Annuler</button>
		</form>
	</main>
	<script
		src="${ pageContext.request.contextPath }/ressources/scripts/script.js"></script>
</body>
</html>