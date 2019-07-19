<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Ajout d'un repas</title>
    <!-- Bootstrap core CSS -->
    <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="container">
    <div class="row">
        <div class="col-sm">
            <h1 class="text-center col-sm">Suivi des Repas</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-sm">
            <p class="text-center col-sm">Suivi des repas par la saisie des aliments consommé avec la date et l'heure du repas.</p>
        </div>
    </div>
    <div class="form-group row">
        <div class="col-sm-4 offset-sm-3">
             <a href="http://localhost:6614/TPSuiviDesRepas/AjoutRepas"><button class="btn btn-primary">Ajouter un nouveau repas</button></a>
        </div>
        <div class="col-sm-4">
              <a href="http://localhost:6614/TPSuiviDesRepas/VisuRepas"><button class="btn btn-primary">Historique</button></a>
        </div>
    </div>  
</body>

</html>