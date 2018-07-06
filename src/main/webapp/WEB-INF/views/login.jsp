<%@ include file="head.jsp"%>

	<!-- div de CONNEXION -->
	<div class="fixed-top my-4 text-left">
            <img src="img/proxybank.png" alt="" class="img-fluid mid-logo">
        </div>
        <!-- div de recherche nom/prenom -->
        <div class="row flex-center flex-column full-screen">
            <div class="col-md-4 text-center">
                <h2>Bienvenue, pour commencer :</h2>
                <form action="<c:url value='/login.html'/>" method="post">
                    <div class="md-form active-pink active-pink-2 mb-3">
                        <input class="form-control" type="text" name="search" placeholder="Veuillez saisir votre NOM ou Pr�nom ou votre Pr�nom et NOM" aria-label="Search">
                    </div>
                    <div class="text-center mt-4">
        				<button class="btn bg-bank-light" type="submit">Valider</button>
    				</div>
                </form>
            </div>
        </div>	
	<!-- /fin de CONNEXION-->
	
<%@ include file="footer.jsp"%>	