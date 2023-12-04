<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<dialog open>
<article>
	<a href="#close" aria-label="Close" class="close"
		onclick="fermerMessage(event)"></a> <%= request.getParameter("message") %>
	<footer>
		<a href="#cancel" role="button" class="secondary"
			onclick="fermerMessage(event)">Ok</a> <a href="connexion"
			role="button">Se connecter</a>
	</footer>
</article>
</dialog>