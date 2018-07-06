<!DOCTYPE html>
<html lang="fr">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Retrait d'argent</title>
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.0/css/font-awesome.min.css">
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- Material Design Bootstrap -->
    <link href="css/mdb.min.css" rel="stylesheet">
    <!-- Your custom styles (optional) -->
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
    <div class="container-fluid">
        <div class="fixed-top my-4 text-center">
            <img src="img/proxybank.png" alt="" class="img-fluid mid-logo">
        </div>
        <!-- div dashboard COMPTE -->
        <div class="row flex-center full-screen my-4">
            <div class="col-md-6">
                <!-- Card -->
                <div class="card">


                    <div class="card-body">
                        <form method="POST">
                            <p class="h4 text-bank-light text-center py-4">Retrait</p>

                            <label for="compte" class="font-weight-light">Choix du compte � d�biter :</label>
                            <select class="form-control" id="exampleFormControlSelect1" name="compteDebit">
                                <option value="${compte1}">Compte 1</option>
                                <option value="${compte2}">Compte 2</option>
                            </select>


                            <div class="md-form">
                                <i class="fa fa-euro prefix grey-text"></i>
                                <input type="text" id="montant" class="form-control" name="montant" required>
                                <label for="montant" class="font-weight-light">Montant maximum 300€</label>
                            </div>

                            <div class="text-center py-4 mt-3">
                                <button class="btn btn-success" type="submit">Valider</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- / div dashboard COMPTE-->
    <!-- Footer -->
    <footer class="page-footer font-small blue">
        <!-- Copyright -->
        <div class="footer-copyright text-center py-3">© 2018 Copyright: KMAProd
        </div>
        <!-- Copyright -->
    </footer>
    </div>
    <!-- Footer -->
    <!-- SCRIPTS -->
    <!-- JQuery -->
    <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
    <!-- Bootstrap tooltips -->
    <script type="text/javascript" src="js/popper.min.js"></script>
    <!-- Bootstrap core JavaScript -->
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <!-- MDB core JavaScript -->
    <script type="text/javascript" src="js/mdb.min.js"></script>
</body>

</html>