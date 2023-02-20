
<nav>
	<ul>
		<!--<li>
                <div id="logo"><img src="${pageContext.request.contextPath}/ressources/images/tish-logo.png" alt="logo_tish"></div>
            </li>-->
		<li><h3>
				tish<span style="color: #00897b;">.</span>
			</h3></li>
		<li><a href="gestion_tshirt">Gestion de stock</a></li>
		<li><a href="tableau_de_bord">Tableau de bord</a></li>
	</ul>
	<ul>
		<li><a href="deconnexion?user_id">Déconnexion (<%= session.getAttribute("username") %>)</a>
		<li>
	</ul>
</nav>