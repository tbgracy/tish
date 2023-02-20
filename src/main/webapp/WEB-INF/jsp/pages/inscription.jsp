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
<title>tish - Inscription</title>
</head>
<body>
	<jsp:include page="../composants/navbar.jsp" />
	<%
	if ((boolean) request.getAttribute("connexionReussie")) {
	%>
	<%--	<dialog open>
	<article>
		<a href="#close" aria-label="Close" class="close"
			onclick="fermerMessage(event)"></a> Inscription réussie
		<footer>
			<a href="#cancel" role="button" class="secondary"
				onclick="fermerMessage(event)">Ok</a> <a href="connexion"
				role="button">Se connecter</a>
		</footer>
	</article>
	</dialog>
	--%>
	<jsp:include page="../composants/message.jsp"><jsp:param
			name="message" value="Inscription reussie" /></jsp:include>
	<%
	}
	%>
	<main class="grid">
		<div></div>
		<article>
			<form action="inscription" method='POST'>
				<h3>Inscription</h3>
				<fieldset>
					<label for='pseudo'>Pseudo</label> <input type='text' id='pseudo'
						name='pseudo' placeholder='Votre pseudo' required> <label
						for='motdepasse'>Mot de passe</label> <input type='password'
						id='motdepasse' name='motdepasse' placeholder='Votre mot de passe'
						required> <label for='motdepasse'>Confirmation de
						mot de passe</label> <input type='password' id='motdepasse'
						name='motdepasse'
						placeholder='Veuillez confirmer votre mot de passe' required>
				</fieldset>
				<label for='numerotel'>Numéro de téléphone</label> <input
					type='number' id='numerotel' name='numerotel'
					placeholder='Votre numéro de téléphone' required>
				<button>S'inscrire</button>
				<p>
					Déjà inscrit(e)? Se connecter <a href="connexion">ici</a>.
				</p>
			</form>
		</article>
		<div></div>
	</main>
	<jsp:include page="../composants/footer.jsp" />
	<script>
		function fermerMessage(event) {
			document.getElementsByTagName('dialog')[0].removeAttribute('open');
			console.log(event);
		}
	</script>
</body>
</html>