<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Résultat du chifoumi</title>
</head>
<body>
	<%
		String resultat = (String) request.getAttribute("resp");
		String joueur = (String) request.getAttribute("joueur");
		String prg = (String) request.getAttribute("prg");
	%>	
	<p><%=resultat %></p>	
	<img src="./images/<%=joueur%>.png"> <img src="./images/<%=prg%>.png">
	<br>
	<a href="http://localhost:8080/TPChifoumi/ServletChifoumi">Rejouer</a>

</body>
</html>