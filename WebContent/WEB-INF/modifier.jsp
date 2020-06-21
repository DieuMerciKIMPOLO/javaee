<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
     <form action="Modifier?id=${6}" method="post">
   			<input name="nom" id="nom" type="text" placeholder="Votre nom" value="${ user.nom}"/>
   			<input name="prenom" id="prenom" type="text" placeholder="Votre prenom" value="${user.prenom }"/>
   			<input name="email" id="email" type="text" placeholder="Votre email" value="${user.email }"/>
   			<input name="adresse" id="adresse" type="text" placeholder="Votre adresse" value="${user.adresse }"/>
   			<input name="id" id="id" type="hidden" placeholder="Votre adresse" value="${user.adresse }"/>
   			<input name="Envoyer" id="Envoyer" type="submit"/>
     </form>
</body>
</html>