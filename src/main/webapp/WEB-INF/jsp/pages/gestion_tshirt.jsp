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
<title>Gestion de t-shirts | Admin</title>
</head>
<body>
	<jsp:include page="../composants/navbar.jsp" />
	<main>
		<details>
			<summary>Formulaire d'ajout de t-shirt</summary>
			<section class="grid">
				<div></div>
				<article>
					<form method="POST" action="gestion_tshirt"
						enctype="multipart/form-data">
						<fieldset>
							<label for="mofif">
								Motif sur le t-shirt 
								<input type="file" name="motif" id="motif">
							</label> 
							<div class="grid">
							<label for="couleur">
								Couleur du t-shirt 
								<input type="color" name="couleur" id="couleur">
							</label> 
							<label for="taille">Taille
							<select id="taille"
								name="taille">
								<option>S</option>
								<option>M</option>
								<option>L</option>
								<option>XL</option>
							</select></label>
							</div>
						</fieldset>
						<fieldset class="grid">
							<label for="nombre">Nombre en stock <input type="number"
								name="nombre" id="nombre"></label> <label for="pu">Prix
								unitaire <input type="number" name="pu" id="pu">
							</label>
						</fieldset>
						<button>Ajouter</button>
					</form>
				</article>
				<div></div>
			</section>
		</details>
		<section class="grid">
			<article>
				<header> </header>
				<img />
				<footer> </footer>
			</article>
			<article></article>
			<article></article>
			<article></article>
		</section>
	</main>
</body>
</html>