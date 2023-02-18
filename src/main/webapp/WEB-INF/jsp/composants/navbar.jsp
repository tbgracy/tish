    <nav>
        <ul>
            <!--<li>
                <div id="logo"><img src="${pageContext.request.contextPath}/ressources/images/tish-logo.png" alt="logo_tish"></div>
            </li>-->
            <li><a href="accueil"><h3>tish<span style="color: #00897b;">.</span></h3></a></li>
            <li><a href="accueil">Accueil</a></li>
            <li><a href="catalogue">Catalogue</a></li>
        </ul>
        <ul> 
        <% if (session.getAttribute("user") == null) {%>
            <li><a href="connexion">Connexion</a></li>
            <li><a href="inscription">Inscription</a></li>
        <% } else { %>
			<li><a href="deconnexion?user_id">Déconnexion</a><li>       
        <% } %>
        	<li><a role="button" href="panier" class='cart-icon'><img src="${pageContext.request.contextPath}/ressources/images/cart-icon.png" alt="cart-icon"></a><span class='cart-items-count'>0</span></li>
        </ul>
    </nav>