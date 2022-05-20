<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href='<c:url value="./resources/css/styles.css"/>'>
<title>Disciplina</title>
</head>
<body>
	<div align="center">
		<form action="disciplina" method="post">
		<table>
			<tr>
				<td colspan="3"><input type="number" id="codigo" name="codigo" placeholder="Código"
					value="${disciplina.codigo }"></td>
				<td><input type="submit" value="Buscar" id="button" name="button"></td>
			</tr>
			<tr>
				<td colspan="4"><input type="text" id="nome" name="nome" placeholder="Nome" size="40"
					value="${disciplina.nome }"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Cadastrar" id="button" name="button"></td>
				<td><input type="submit" value="Atualizar" id="button" name="button"></td>
				<td><input type="submit" value="Excluir" id="button" name="button"></td>
				<td><input type="submit" value="Listar" id="button" name="button"></td>
			</tr>
		</table>
		</form>
	</div>
	<div align="center">
		<c:if test="${not empty saida }">
			<p><c:out value="${saida }" /></p>
		</c:if>
		<c:if test="${not empty erro }">
			<h2 style="color: red"><c:out value="${erro }" /></h2>
		</c:if>
	</div>
	<div align="center">
		<c:if test="${not empty disciplinas }">
			<table border="1">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nome</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="d" items="${disciplinas }">
				<tr>
					<td>${d.codigo }</td>
					<td>${d.nome }</td>
				</tr>
			</c:forEach>
			</tbody>
			</table>
		</c:if>
	</div>
	<div align="center">
		<form action="relatoriojson" method="post" target="_blank">
			<H3>Lista de Chamada</H3>
			<table>
				<tr>
					<td>
						<input class="id_input_data" type="number" min="0"
							step="1" id="codigo" name="codigo" placeholder="COD">
					</td>
					<td>
						<input type="submit" id="botao" name="botao" value="Gerar Relatório">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>