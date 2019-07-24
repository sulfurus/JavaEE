<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ page
	import="java.util.Map,java.util.stream.Collectors,java.util.stream.Stream"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Module 5 - TP</title>
    <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">


<style>
<%
					Map <String, String>mapColor ;
					mapColor = (Map <String, String> ) application.getAttribute("mapColor");
					if (!mapColor.isEmpty ()) {
						for (Map.Entry mapentry :mapColor.entrySet()) 
						{
				 			%>.<%=mapentry.getKey () %> {				 
				 				background-color: <%=mapentry.getValue()%>;	
								}
								<%
						}
					}
					
%>
</style>
</head>
<body class="container">
	<div class="row">
		<h1>Choix de ma couleur</h1>
	</div>
	<div class="row">
		<form action="/TPPreferencesDUsage/accueil" method="post">
			<select name="color" id="color">
				<%

					if (!mapColor.isEmpty()) {

						for (Map.Entry mapentry2 : mapColor.entrySet()) {
				%><option class="<%=mapentry2.getKey()%>"
					value="<%=mapentry2.getValue()%>"
					<%if (mapentry2.getValue().equals(session.getAttribute("colorCode"))) {%>
					selected <%}%>><%=mapentry2.getKey()%></option>
				<%
					}
					}
				%>
			</select>

			<button type="submit" class="btn btn-primary">Valider</button>

		</form>

	</div>
	<div class="row mt-4 mb-4">
		<p>
			<%
		if(request.getAttribute("nbRequete") != null)
		{
			%>
			Vous êtes venu
			<%=request.getAttribute("nbRequete") %>
			fois
			<%
			}
			else
			{
			%>
			C'est votre première visite !<%
			}
		%>
		</p>

	</div>
	<%
		String colorCode = null;
		colorCode = (String) session.getAttribute("colorCode");
		if (colorCode != null) {
	%>
	<div class="row">
		<a href="<%=request.getContextPath()%>/maCouleur">Affichage de ma
			couleur</a>
	</div>
	<%
		}
	%>


</body>
</html>