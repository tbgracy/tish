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
		<details>
			<summary>Trouver LE t-shirt</summary>
			<section class="container">
				<article>
					<form method="POST" action="gestion_tshirt"
						enctype="multipart/form-data">
						<fieldset>
							<div class="grid">
								<label for="taille">Taille <select id="taille"
									name="taille" required>
										<option>S</option>
										<option>M</option>
										<option>L</option>
										<option>XL</option>
								</select></label>
							</div>
						</fieldset>
						<fieldset class="grid">
							<label for="pu_min">Prix minimum<input type="number"
								name="pu_min" id="pu_min" min='0' required></label> <label
								for="pu_max">Prix maximum <input type="number" min='0'
								name="pu_max" id="pu_max" required>
							</label>
						</fieldset>
						<button>Chercher</button>
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
				<header>
					<img
						src="<%=(String) request.getAttribute("upload_path") + tshirt.getMotif()%>"
						alt="<%=tshirt.getMotif()%>" />
					<div class='shirt-color'
						style="background-color: <%=tshirt.getCouleur()%>"></div>
				</header>
				<div class='shirt-price'>
					<b><%=tshirt.getFormatedPrix()%> MGA</b>
				</div>
				<div class='shirt-count'>
					Taille
					<%=tshirt.getTaille()%></div>
				<footer>
					<form action='ajouter_dans_panier' style="margin-bottom: 0"
						method='POST'>
						<div class="grid-fluid">
							<div class='grid'>
								<label for='number'>Quantité</label> <input type='number'
									name='quantite' id='quantite' value='1' min='1'
									max='<%=tshirt.getNombre()%>' placeholder='Quantité'>
							</div>
							<input type='number' name='idTshirt' id='idTshirt'
								value='<%=tshirt.getIdTShirt()%>' hidden>
							<button>Ajouter dans le panier</button>
						</div>
					</form>
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