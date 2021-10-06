<%@ page import="br.com.alura.gerenciador.modelo.Empresa" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/removeEmpresa" var="linkServletNovaEmpresa" />

<html>
<head>
    <title>Title</title>
</head>
<body>

<ul>
    <h3>Usuário logado: ${usuarioLogado.login}</h3>
    <br>
    <a href="entrada?acao=Logout">Logout</a>

    <c:if test="${not empty empresa}">
        "nome da empresa: " ${empresa}
    </c:if>

    <% //(List<Empresa>) request.getAttribute("empresas") é o mesmo q ${empresas}
    %>
    <c:forEach items="${empresas}" var="empresa">

        <% //empresa.nome = empresa.getNome() %>
        <li>
                ${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy" />
                    <a href="/gerenciador_war_exploded/entrada?acao=MostraEmpresa&id=${empresa.id}">Editar</a>
                    <a href="/gerenciador_war_exploded/entrada?acao=RemoveEmpresa&id=${empresa.id}">Remove</a>
        </li>
    </c:forEach>
</ul>


</body>
</html>
