<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<% //gerenciador_war_exploded/novaEmpresa É O MESMO QUE O c:... %>
<c:url value="/entrada" var="linkEntradaServlet" />


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<c:import url="logout-parcial.jsp" />

<form action="${linkEntradaServlet}" method="post">
    Nome: <input type="text" name="nome" value="${empresa.nome}" />
    Data: <input type="text" name="data" value="<fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy" />" />
    <input type="hidden" name="id" value="${empresa.id}" />
    <input type="hidden" name="acao" value="AlteraEmpresa" />
    <input type="submit" name="enviar" />
</form>
</body>
</html>