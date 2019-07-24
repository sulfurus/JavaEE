<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setBundle basename="fr.eni.javaee.traducteur.messages.messages"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="msg.traducteur"></fmt:message></title>
</head>
<body>
	<form method="post" action="${pageContext.request.contextPath}/traducteur">
		<div>
			<fmt:message key="msg.votreprenom"></fmt:message>
		</div>
		<div>
			<input type="text" name="prenom"/>
		</div>
		<div>
			<input type="submit" value="<fmt:message key="msg.valider"></fmt:message>">
		</div>
	</form>
</body>
</html>