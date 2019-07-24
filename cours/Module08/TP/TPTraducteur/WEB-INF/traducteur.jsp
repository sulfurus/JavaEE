<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setBundle basename="fr.eni.javaee.traducteur.messages.messages"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<style type="text/css">
	table {
	    border-collapse: collapse;
	}
	
	table, th, td {
	    border: 1px solid black;
	}

</style>

<title><fmt:message key="msg.traducteur"/></title>
</head>
<body>
	<h1><fmt:message key="msg.traducteur"/></h1>
	<p>
		<fmt:message key="msg.accueil">
			<fmt:param value="${sessionScope.prenom}"></fmt:param>
		</fmt:message>
	</p>
	
	<form method="POST" action="${pageContext.request.contextPath}/ServletChangerLangue">
		<p>
			<select name="langueinitiale" onchange="document.forms[0].submit();">
				<option value=""><fmt:message key="msg.langueinitiale"/></option>
				<option value="fr" ${sessionScope.langueinitiale=='fr'?'selected':''}>Français</option>
				<option value="en" ${sessionScope.langueinitiale=='en'?'selected':''}>English</option>
				<option value="de" ${sessionScope.langueinitiale=='de'?'selected':''}>Deutch</option>
			</select>
			
			<select name="languecible" onchange="document.forms[0].submit();">
				<option value=""><fmt:message key="msg.languecible"/></option>
				<option value="fr" ${sessionScope.languecible=='fr'?'selected':''}>Français</option>
				<option value="en" ${sessionScope.languecible=='en'?'selected':''}>English</option>
				<option value="de" ${sessionScope.languecible=='de'?'selected':''}>Deutch</option>
			</select>
		<p>
	</form>
	
	<fmt:setLocale value="${sessionScope.langueinitiale}"/>
	<fmt:setBundle basename="fr.eni.javaee.traducteur.messages.dictionnaire" var="r_langueinitiale"/>
	<fmt:setLocale value="${sessionScope.languecible}"/>
	<fmt:setBundle basename="fr.eni.javaee.traducteur.messages.dictionnaire" var="r_languecible"/>
	
	<table>
		<thead>
			<tr>
				<th><fmt:message key="msg.langueinitiale"/>:${sessionScope.langueinitiale}</th>
				<th><fmt:message key="msg.languecible"/>:${sessionScope.languecible}</th>
			</tr>
		</thead>
		<tbody>		
			<c:forEach var="key" items="${r_langueinitiale.getResourceBundle().getKeys()}">
				<tr>
					<td><fmt:message  bundle="${r_langueinitiale}" key="${key}"></fmt:message></td>
					<td><fmt:message  bundle="${r_languecible}" key="${key}"></fmt:message></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>