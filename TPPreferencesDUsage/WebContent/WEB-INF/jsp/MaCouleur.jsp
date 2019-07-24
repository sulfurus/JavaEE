<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Affichage de ma couleur</title>
    <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">

    <style type="text/css">
    	.MaCouleur{

		background-color: lightgrey;
			<%
		String colorCode = null;
		colorCode = (String) session.getAttribute("colorCode");
		if (colorCode != null) {
	%>
		color: <%=colorCode%>;
	<%
		}
	%>
	}
	request.setAttribute("nbRequete");

  
    </style>
</head>
<body class="container">
<div class="row"><h1>Affichage de ma couleur</h1></div>
<div class="row">
	<div class="MaCouleur"><p>Voici mon texte avec ma couleur personnalisé et un fond personnalisé.</p></div>

</div>

	<div class="row">
		<a href="<%=request.getContextPath()%>/accueil">Retour</a>
	</div>



</body>
</html>