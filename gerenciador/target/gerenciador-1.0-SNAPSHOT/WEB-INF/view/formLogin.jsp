<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% //gerenciador_war_exploded/novaEmpresa É O MESMO QUE O c:... %>
<c:url value="/entrada" var="linkServletNovaEmpresa" />


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form action="${linkServletNovaEmpresa}" method="post">
    Login: <input type="text" name="login" />
    Senha: <input type="password" name="senha" />
    <input type="hidden" name="acao" value="Login" />
    <input type="submit" name="enviar">
</form>
</body>
</html>