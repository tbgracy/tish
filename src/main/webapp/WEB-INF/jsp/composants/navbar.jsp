    <nav>
        <ul>
            <li>
                <div id="logo"><img src="${pageContext.request.contextPath}/ressources/images/tish-logo.png" alt="logo_tish"></div>
            </li>
            <li><a href="">Accueil</a></li>
            <li><a href="catalogue">Catalogue</a></li>
        </ul>
        <%--HttpSession session = request.getSession(); --%>
        <ul>
        <% if (session.getAttribute("user") == null) {%>
            <li><a role="button" href="connexion">Connexion</a></li>
            <li><a role="button" href="inscription">Inscription</a></li>
        <% } else { %>
			<li><a role="button" href="deconnexion?user_id">Déconnexion</a><li>       
        <% } %>
        </ul>
    </nav>