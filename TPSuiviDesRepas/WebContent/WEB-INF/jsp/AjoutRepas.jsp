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
    <div>
        <p class="text-center">AJOUT</p>
    </div>
    <form>
        <div class="form-group row">
            <label for="date" class="col-sm-2 col-form-label">Date</label>
            <div class="col-sm-4">
                <input type="date" class="form-control" id="date" placeholder="Date">
            </div>
        </div>
        <div class="form-group row">
            <label for="heure" class="col-sm-2 col-form-label">Heure</label>
            <div class="col-sm-4">
                <input type="time" class="form-control" id="heure" placeholder="Heure">
            </div>
        </div>
        <div class="form-group row">
            <label for="aliment" class="col-sm-2 col-form-label">Liste des aliments</label>
            <div class="col-sm-6">
                <textarea class="form-control" id="heure" placeholder="Liste des aliments séparée par des virgules (,)"></textarea>
            </div>
        </div>
        <div class="form-group row">
            <div class="col-sm-5">
                <button type="submit" class="btn btn-primary">Valider</button>
            </div>
            <div class="col-sm-4">
                <button type="submit" class="btn btn-warning">Annuler</button>
            </div>
        </div>
    </form>
</body>

</html>