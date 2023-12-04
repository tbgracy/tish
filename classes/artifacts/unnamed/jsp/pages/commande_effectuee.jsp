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
<title>tish | Commande effectuée</title>
</head>
<body>
	<jsp:include page='../composants/navbar.jsp' />
	<main class='container'>
		Votre commande a bien été effectuée. <img
			src="${pageContext.request.contextPath }/ressources/images/order_delivered.png"
			alt="" width=600>
	</main>
	<jsp:include page='../composants/footer.jsp' />
</body>
</html>