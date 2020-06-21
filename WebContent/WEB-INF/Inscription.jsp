<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulaire d'incription</title>
</head>
<body>
   <form action="Inscription" method="post">
   			<input name="nom" id="nom" type="text" placeholder="Votre nom"/>
   			<input name="prenom" id="prenom" type="text" placeholder="Votre prenom"/>
   			<input name="email" id="email" type="text" placeholder="Votre email"/>
   			<input name="adresse" id="adresse" type="text" placeholder="Votre adresse"/>
   			<input name="motDePasse" id="motDePass" type="password" placeholder="Votre mot de passe"/>
   			<input name="Envoyer" id="Envoyer" type="submit"/>
   </form>
</body>
</html>