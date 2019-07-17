<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isErrorPage="true"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>Erreur :</h1>
		<img src="https://img.icons8.com/cotton/64/000000/dynamite.png">
	<p>
		<strong>(<%=exception %>) </strong> <%=exception.getMessage() %>
		<br><strong>Context de l'erreur :</strong>
		<br>Joueur : <%=request.getAttribute("joueur")%>
		<br>Prg : <%=request.getAttribute("prg")%>
			<br>
	<a href="http://localhost:8080/TPChifoumi/ServletChifoumi">Rejouer</a>
	</p>

</body>
</html>