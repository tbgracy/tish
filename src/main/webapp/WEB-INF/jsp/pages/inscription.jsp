<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" href="${ pageContext.request.contextPath }/ressources/styles/pico.min.css">
	<link rel="stylesheet" href="${ pageContext.request.contextPath }/ressources/styles/style.css">
<title>tish - Inscription</title>
</head>
<body>
	<jsp:include page="../composants/navbar.jsp"/>
	<main class="grid">
	<div></div>
		<article>
			<form action="#" method='POST'>
				<h3>Inscription</h3>
				<fieldset>
				 <label for='pseudo'>Pseudo</label>
				 <input type='text' id='pseudo' name='pseudo' placeholder='Votre pseudo' required>
				 <label for='motdepasse'>Mot de passe</label>
				 <input type='password' id='motdepasse' name='motdepasse' placeholder='Votre mot de passe' required>
				 <label for='motdepasse'>Confirmation de mot de passe</label>
				 <input type='password' id='motdepasse' name='motdepasse' placeholder='Veuillez confirmer votre mot de passe' required>
				</fieldset>
				<label for='numerotel'>Numéro de téléphone</label>
				<input type='number' id='numerotel' name='numerotel' placeholder='Votre numéro de téléphone' required>
				 <button>S'inscrire</button>
			</form>
		</article>
		<div></div>
	</main>
	<jsp:include page="../composants/footer.jsp"/>
</body>
</html>