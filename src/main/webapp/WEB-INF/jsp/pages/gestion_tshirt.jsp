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
<title>Gestion de t-shirts | Admin</title>
</head>
<body>
	<jsp:include page="../composants/navbar.jsp"/>
	<main class="container">
		<details>
			<summary>Formulaire d'ajout de t-shirt</summary>
			<section class="container">
				<article>
					<form method="POST" action="gestion_tshirt"
						enctype="multipart/form-data">
						<fieldset>
							<label for="mofif"> Motif sur le t-shirt <input
								type="file" name="motif" id="motif" accept=".png, .jpg, .jpeg"
								required>
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
								name="nombre" id="nombre" min='0' required></label> <label for="pu">Prix
								unitaire <input type="number" min='0' name="pu" id="pu" required>
							</label>
						</fieldset>
						<button>Ajouter</button>
					</form>
				</article>
			</section>
		</details>
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
				<footer>
					<div class="grid-fluid">
						<a href="modification_tshirt?idTshirt=<%= tshirt.getIdTShirt() %>" role='button'>Modifier</a>
						<a href="suppression_tshirt?idTshirt=<%= tshirt.getIdTShirt() %>" role='button' class='secondary'>Supprimer</a>
					</div>
				</footer>
			</article>
			<%
			}
			%>
		</section>
	</main>
	<script
		src="${ pageContext.request.contextPath }/ressources/scripts/script.js"></script>
</body>
</html>