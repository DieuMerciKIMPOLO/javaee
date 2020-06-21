<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Test</title>
</head>
<body>
<p>Bonjour
BIENVENU SUR NOTRE APPLICATION

<img src="ls.png" alt="W3Schools.com" width="104" height="142">
    <%
    String name = (String) request.getAttribute("name");
    out.println(name);
    %>
</p>
</body>
</html>