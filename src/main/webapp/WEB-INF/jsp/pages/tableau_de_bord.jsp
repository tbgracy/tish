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
<title>Tableau de bord | Admin</title>
</head>
<body>
	<jsp:include page="../composants/navbar_admin.jsp"/>
	<main class="container">
	<article style='width: 600px;' class='dash'>
		${nombre_commandes } t-shirts commandés depuis le lancement du site. 
	</article>
	</main>
	<jsp:include page='../composants/footer.jsp'/>
	<script
		src="${ pageContext.request.contextPath }/ressources/scripts/script.js"></script>
</body>
</html>