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
<c:import url="logout-parcial.jsp" />

<form action="${linkServletNovaEmpresa}" method="post">
    Nome: <input type="text" name="nome" />
    Data: <input type="text" name="data" />
    <input type="hidden" name="acao" value="NovaEmpresa" />
    <input type="submit" name="enviar">
</form>
</body>
</html>