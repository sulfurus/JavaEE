<%@ page
	import="java.util.ArrayList,java.util.List,fr.eni.javaee.module4.tp1.BusinessException,fr.eni.javaee.module4.tp1.bll.AlimentManager,fr.eni.javaee.module4.tp1.bll.RepasManager,fr.eni.javaee.module4.tp1.bo.Repas,fr.eni.javaee.module4.tp1.bo.Aliment"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ajout d'un repas</title>
<!-- Bootstrap core CSS -->
<link href="<%=request.getContextPath()%>/css/bootstrap.min.css"
	rel="stylesheet">
</head>

<body class="container">
	<div class="row">
		<div class="col-sm">
			<h1 class="text-center col-sm">Historique</h1>
		</div>
	</div>
	<div class="col-sm">

		<%
			RepasManager repasManager = new RepasManager();
			List<Repas> listeRepas = new ArrayList<Repas>();
			listeRepas = (List<Repas>)request.getAttribute("listeRepas");
		/*	int idRepasDetail = 0;
			out.print(" param idRepas " +(String)request.getAttribute("idRepas"));
			if(request.getAttribute("idRepas") != null){
				out.print(" param idRepas" +(String)request.getAttribute("idRepas"));
				//idRepasDetail= Integer.valueOf((String)request.getAttribute("idRepas"));	
			}
			
			out.print(idRepasDetail);
			//idRepasDetail = Integer.parseInt(strid.trim());
			*/
			for (int i = 0; i < (listeRepas.size() + 1); i++) {
				if (i == 0) {
					%>
					<div>
						<div class="row bg-info ">
							<div class="col-5 borderborder-primary">
								<b>Date</b>
							</div>
							<div class="col-5 borderborder-primary">
								<b>Heure</b>
							</div>
							<div class="col-2 borderborder-primary">
								<b>Actions</b>
							</div>
						</div>
					</div>
					<%
				} else {
			
						if (i % 2 == 0) {
							%>
							<div>
								<div class="row bg-secondary ">
									<div class="col-5 border border-primary"><%=listeRepas.get(i - 1).getDate()%></div>
									<div class="col-5 border border-primary"><%=listeRepas.get(i - 1).getHeure()%></div>
									<div class="col-2 border border-primary">
										<a
											href="http://localhost:6614/TPSuiviDesRepas/VisuRepas?detail=<%=listeRepas.get(i - 1).getId_repas()%>">@détail</a>
									</div>
								</div>
							</div>
							<%
						} else if (i % 2 == 1) {
							%>
							<div>
								<div class="row bg-light ">
									<div class="col-5 border border-primary"><%=listeRepas.get(i - 1).getDate()%></div>
									<div class="col-5 border border-primary"><%=listeRepas.get(i - 1).getHeure()%></div>
									<div class="col-2 border border-primary">
										<a
											href="http://localhost:6614/TPSuiviDesRepas/VisuRepas?detail=<%=listeRepas.get(i - 1).getId_repas()%>">@détail</a>
									</div>
								</div>
							</div>
							<%
						}
					}
							if (i ==listeRepas.size()) {
								
								List<Aliment> listeAliment = new ArrayList<Aliment>();
								listeAliment = (ArrayList<Aliment>) request.getAttribute("listeAliment");
								if (listeAliment.size() > 0) {
									%>
									<div class="row border">
										<%
											for (Aliment aliment : listeAliment) {
												%><div class="col-6">
													<p><%=aliment.getLibelle()%></p>
									
												</div>
												<%
											}
										%>
									</div>
									<%
								}
			
							}
			
						}
		%>
	</div>
	<div class="form-group row mt-4">
		<div class="col-sm-4 offset-sm-2">
			<a href="http://localhost:6614/TPSuiviDesRepas/AjoutRepas"><button
					class="btn btn-primary">Ajouter un nouveau repas</button></a>
		</div>
		<div class="col-sm-4">
			<a href="http://localhost:6614/TPSuiviDesRepas/SuiviDesRepas"><button
					class="btn btn-primary">Retour à l'accueil</button></a>
		</div>
	</div>
</body>

</html>