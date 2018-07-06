<%@ include file="head.jsp"%>
        <div class="row flex-center full-screen my-4">
            <div class="col-md-6">
                <!-- Card -->
                <div class="row d-flex justify-content-center">
                	<span class="alert alert-primary">${erreur}</span>
                </div>
                <div class="card">


                    <div class="card-body">
                        <form method="POST">
                         <input type="hidden" name="idClient" value="${idClient}"/>
                            <p class="h4 text-bank-light text-center py-4">Retrait</p>

                            <label for="compte" class="font-weight-light">Choix du compte � d�biter :</label>
                            <select class="form-control" id="exampleFormControlSelect1" name="compteDebit">
                            				 <c:forEach var="compte" items="${comptes}">
									<option value="${compte.id}">${compte.numCompte} -- ${compte.libelle} -- solde: ${compte.solde}</option>
								 </c:forEach>
                            </select>


                            <div class="md-form">
                                <i class="fa fa-euro prefix grey-text"></i>
                                <input type="text" id="montant" class="form-control" name="montant" required>
                                <label for="montant" class="font-weight-light">Montant maximum 300 euros</label>
                            </div>

                            <div class="text-center py-4 mt-3">
                                <button class="btn btn-success" type="submit">Valider</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <%@ include file="action-user.jsp"%> 
        </div>
<%@ include file="footer.jsp"%>
  