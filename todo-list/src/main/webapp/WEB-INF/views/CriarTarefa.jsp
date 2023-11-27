<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form method="POST" modelAttribute="tarefa" action="cadastro">
		<p>
			Título da Tarefa:
			<form:input path="tituloTarefa" />
		</p>
		<p>
			Descrição da Tarefa:
			<form:input path="descricaoTarefa" />
		</p>
		<p>
			Data da Tarefa:
			<form:input path="dataConclusaoTarefa" type="date" />
		</p>
		<p>
			<form:button>Enviar</form:button>
		</p>

		<p>${mensagem}</p>

	</form:form>
	<p>
	<table>
		<thead>
			<tr>
				<th>Título</th>
				<th>Descrição</th>
				<th>Data de Conclusão</th>
				<th>Ação</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="tarefa" items="${tarefas }">
				<tr>
					<td>${tarefa.tituloTarefa}</td>
					<td>${tarefa.descricaoTarefa}</td>
					<td><fmt:formatDate value="${tarefa.dataConclusaoTarefa}"
							pattern="dd/MM/yyyy" /></td>
					<td><a href="editar/${tarefas.indexOf(tarefa)} ">Editar</a> <a
						href="excluir/${tarefas.indexOf(tarefa)}">Excluir</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>
</body>
</html>