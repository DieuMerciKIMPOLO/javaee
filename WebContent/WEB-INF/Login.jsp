<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="background:red;">
    
     <c:if test="${ !empty sessionScope.user}">
        <p>Vous êtes ${ sessionScope.user.prenom } ${ sessionScope.user.nom } !</p>
    </c:if>
    
    <img src="ls.png" alt="ec2lt" width="104" height="142">
     <form action="Login" method="post" >
       <input name="email" type="text" id="email" placeholder="Votre Email"/>
       <input name="motDepasse" type="password" id="motDepasse" placeholder="Votre mot de passe"/>
       <input name="envoyer" type="submit" id="envoyer">
     </form>
</body>
</html>