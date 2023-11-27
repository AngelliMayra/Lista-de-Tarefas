<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form method="POST" modelAttribute="tarefa" action="../atualizar/${id}">
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
			<form:input path="dataConclusaoTarefa" type="date"/>
		</p>
		<p>
			<form:button>Enviar</form:button>
		</p>

		<p>${mensagem}</p>

	</form:form>

</body>
</html>