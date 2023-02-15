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
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/ressources/styles/accueil.css">
<title>tish</title>
</head>
<body>
	<jsp:include page='../composants/navbar.jsp' />
	<main class="container">
		<section id='call-to-action' class='grid'>
			<figure>
				<img src="${pageContext.request.contextPath }/ressources/images/land.jpg" alt="some t-shirts">
				<figcaption>
					Image gratuite trouvée sur <a href="http://pexels.com/">pexels</a>
				</figcaption>
			</figure>
			<section>
			<div>
				<h3 style="margin-bottom: 25px;"> 
					Bienvenu sur <u>tish</u><span style="color: #00897b;">.</span>
				</h3>
				<p>Votre t-shirt est bien plus qu'un simple vêtement, c'est un
					moyen d'expression de votre personnalité et de vos convictions.
					Alors affirmez-vous avec style et montrez au monde qui vous êtes
					grâce à notre collection de t-shirts uniques et originaux.</p>
				<a role="button" href="catalogue">Parcourir le catalogue</a>
			</div>
			</section>
		</section>
		<section>
			<h2>Populaires en ce moment</h2>
			<section class="grid">
				<article></article>
				<article></article>
				<article></article>
				<article></article>
			</section>
		</section>
	</main>
	<jsp:include page='../composants/footer.jsp' />
</body>
</html>