<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.util.List, com.tish.entities.*, java.util.ArrayList, java.util.Locale, java.text.NumberFormat"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/ressources/styles/pico.min.css">
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/ressources/styles/style.css">
<title>tish | Panier</title>
</head>
<body>
	<jsp:include page='../composants/navbar.jsp' />
	<%
	List<Tshirt> tshirts = (List<Tshirt>) request.getAttribute("liste_tshirts");
	List<TshirtItem> panier = (List<TshirtItem>) session.getAttribute("pannier");
	int total_general = 0;
	%>
	<main class='container'>
		<%
		if (tshirts != null && tshirts.size() != 0) {
		%>
		<figure>
			<table>
				<thead>
					<tr>
						<th>t-shirt</th>
						<th>Prix Unitaire</th>
						<th>Quantité</th>
						<th>Total</th>
					</tr>
				</thead>
				<tbody>
					<%
					for (int i = 0; i < tshirts.size(); i++) {
						TshirtItem item = new TshirtItem();
						for (TshirtItem item_ : panier) {
							if (item_.getIdTshirt() == tshirts.get(i).getIdTShirt()) {
						item = item_;
						break;
							}
						}
						int total = tshirts.get(i).getPrix() * item.getQuantite();
						total_general += total;
						String formated_total = NumberFormat.getInstance(new Locale("fr", "MLG")).format(total);
					%>
					<tr>
						<td><div class='grid'>
								<div class='img-container'>
									<img
										src="<%=(String) request.getAttribute("upload_path") + tshirts.get(i).getMotif()%>"
										alt="photo">
									<div class='shirt-color'
										style="background-color: <%=tshirts.get(i).getCouleur()%>"></div>
								</div>
								<div>
									<div>
										Taille :
										<%=tshirts.get(i).getTaille()%></div>
									<a href="#" class='secondary'>Retirer du panier</a>
								</div>
							</div></td>
						<td><%=tshirts.get(i).getFormatedPrix()%> MGA</td>
						<td><%=panier.get(i).getQuantite()%></td>
						<td><%=formated_total%> MGA</td>
					</tr>
					<%
					}
					%>
				</tbody>
				<tfoot>
					<%
					String formated_total_general = NumberFormat.getInstance(new Locale("fr", "MLG")).format(total_general);
					%>
					<tr>
						<th><b>Total</b></th>
						<th colspan='2'></th>
						<th><%=formated_total_general%> MGA</th>
					</tr>
				</tfoot>
			</table>
		</figure>
		<div class='grid'>
			<form>
				<button class='secondary'>Vider panier</button>
			</form>
			<form action='commander_tshirt' method="POST">
				<button>Envoyer commande</button>
			</form>
		</div>
		<%
		
		} else {
		%>
		<p>Votre panier est vide, parcourez <a href="/tish/catalogue">notre catalogue</a> pour trouver votre t-shirt.</p>
		<%
		}
		%>
	</main>
	<jsp:include page='../composants/footer.jsp' />
</body>
</html>