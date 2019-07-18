<%@page import="fr.eni.javaee.module4.messages.LecteurMessage"%>
<%@page import="java.util.List"%>
<%@page import="fr.eni.javaee.module4.bo.Avis"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:mso="urn:schemas-microsoft-com:office:office" xmlns:msdt="uuid:C2F41010-65B3-11d1-A29F-00AA00C14882">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ajouter un avis</title>

<!--[if gte mso 9]><xml>
<mso:CustomDocumentProperties>
<mso:_dlc_DocId msdt:dt="string">Z5HNVW24N33T-678105430-3881</mso:_dlc_DocId>
<mso:_dlc_DocIdItemGuid msdt:dt="string">e4fbd88a-9c55-481f-9bba-0498eeb0f0ab</mso:_dlc_DocIdItemGuid>
<mso:_dlc_DocIdUrl msdt:dt="string">http://inet/sites/projets/EcoleNumerique/_layouts/15/DocIdRedir.aspx?ID=Z5HNVW24N33T-678105430-3881, Z5HNVW24N33T-678105430-3881</mso:_dlc_DocIdUrl>
<mso:xd_Signature msdt:dt="string"></mso:xd_Signature>
<mso:TemplateUrl msdt:dt="string"></mso:TemplateUrl>
<mso:xd_ProgID msdt:dt="string"></mso:xd_ProgID>
<mso:_dlc_DocIdPersistId msdt:dt="string"></mso:_dlc_DocIdPersistId>
<mso:Order msdt:dt="string">388100.000000000</mso:Order>
<mso:ContentTypeId msdt:dt="string">0x010100486201FEAA9EBE4FA7C434936B46E6EC</mso:ContentTypeId>
<mso:_SourceUrl msdt:dt="string"></mso:_SourceUrl>
<mso:_SharedFileIndex msdt:dt="string"></mso:_SharedFileIndex>
</mso:CustomDocumentProperties>
</xml><![endif]-->
</head>
<body>

	<%
		Avis avis = (Avis)request.getAttribute("avis");
		if(avis!=null)
		{
	%>
			<p style="color:red;">L'avis a été ajouté avec succès :</p>
			<p><%=avis %></p>
	<%	
		} 
	%>
	
	<%
		List<Integer> listeCodesErreur = (List<Integer>)request.getAttribute("listeCodesErreur");
		if(listeCodesErreur!=null)
		{
	%>
			<p style="color:red;">Erreur, l'avis n'a pas pu être ajouté :</p>
	<%
			for(int codeErreur:listeCodesErreur)
			{
	%>
				<p><%=LecteurMessage.getMessageErreur(codeErreur)%></p>
	<%	
			}
		}
	%>
	<form action="<%=request.getContextPath()%>/modules/module4/ServletAjoutAvis" method="post">
		<label for="idDescription">Description : </label><input type="text" id="idDescription" name="description" value="<%=listeCodesErreur!=null?request.getParameter("description"):""%>"/>
		<br/>
		<label for="idNote">Note : </label><input type="text" id="idNote" name="note" value="<%=listeCodesErreur!=null?request.getParameter("note"):""%>"/>
		<br/>
		<input type="submit" value="Valider"/>
	</form>
	<a href="demonstrations/demonstration2.html">Retour</a>
</body>
</html>