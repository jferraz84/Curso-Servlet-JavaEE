<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.util.List,br.com.curso.gerenciador.modelo.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Standard Taglib</title>
</head>
<body>

	<c:if test="${not empty empresa }">
			Empresa ${empresa} Cadastrada com sucesso !
		</c:if>

	Lista de Empresas:  <br />

	<ul>
		<c:forEach items="${empresas}" var="empresa">

			<li>${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura }" pattern="dd/MM/yyyy" /></li>
					<a href="/gerenciador/entrada?acao=mostraEmpresa&id=${empresa.id }">edita</a>
					<a href="/gerenciador/entrada?acao=removeEmpresa&id=${empresa.id }">remove</a>
		</c:forEach>
	</ul>

</body>
</html>