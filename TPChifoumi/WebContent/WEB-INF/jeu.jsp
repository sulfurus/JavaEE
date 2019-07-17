<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Chifoumi</title>
</head>
<body>
<h1>Choisi entre CHI-FU-MI</h1>
	<form action="/TPChifoumi/ServletChifoumi" method="POST">
		<input type="submit" value="Pierre" name="choix" >
		<input type="submit" value="Feuille" name="choix">
		<input type="submit" value="Ciseaux" name="choix">
			<input type="submit" value="Erreur" name="choix">
	</form>
</body>
</html>