<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des utilisateurs</title>
</head>
<body>
 <c:if test="${ !empty sessionScope.user}">
    <p>Vous êtes ${ sessionScope.user.prenom } ${ sessionScope.user.nom } !</p>
</c:if>
<c:if test="${ !empty usersList}">
<table boreder="2">
<tr>
	<th>Numero</th>
	<th>Nom</th>
	<th>Prenom</th>
	<th>Email</th>
	<th>Adresse</th>
	<th>Profile</th>
	<th colspan="2">Operations</th>
</tr>
<c:forEach items="${ usersList }" var="user" varStatus="status">
    <tr>
		<td>N°<c:out value="${ status.count }" /></td>
		<td><c:out value="${ user.nom }" /></td>
		<td><c:out value="${ user.prenom }" /></td>
		<td><c:out value="${ user.email }" /></td>
		<td><c:out value="${ user.adresse }" /></td>
		<td><c:out value="${ user.profile }" /></td>
		<td><a href="remove?userId=<c:out value="${ user.id }"/>">Supprimer</a></td>
		<td><a href="modifier?id=<c:out value="${ user.id }"/>">Modifier</a></td>
    </tr>
</c:forEach>
</table>
</c:if>
</body>
</html>