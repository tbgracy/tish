
<nav>
	<ul>
		<!--<li>
                <div id="logo"><img src="${pageContext.request.contextPath}/ressources/images/tish-logo.png" alt="logo_tish"></div>
            </li>-->
		<li><a href="accueil"><h3>
					tish<span style="color: #00897b;">.</span>
				</h3></a></li>
		<li><a href="accueil">Accueil</a></li>
		<li><a href="catalogue">Catalogue</a></li>
	</ul>
	<ul>
		<%
		if (session.getAttribute("user") == null) {
		%>
		<li><a href="connexion">Connexion</a></li>
		<li><a href="inscription">Inscription</a></li>
		<%
		} else {
		%>
		<li><a href="deconnexion?user_id">Déconnexion</a>
		<li>
			<%
			}
			%> <%@ page
				import="java.util.List, com.tish.entities.Tshirt, java.util.ArrayList, com.tish.entities.TshirtItem"%>
			<%
			List<TshirtItem> panier = (List<TshirtItem>) session.getAttribute("pannier");
			int numb;
			if (panier == null) {
				numb = 0;
			} else {
				numb = panier.size();
			}
			%>
		
		<li><a role="button" href="panier" class='cart-icon'><img
				src="${pageContext.request.contextPath}/ressources/images/cart-icon.png"
				alt="cart-icon"></a><span class='cart-items-count'>
				<%= numb %>
		</span></li>
	</ul>
</nav>