<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title></title>
<style type="text/css">
body {
	font-family: sans-serif;
}

.data, .data td {
	border-collapse: collapse;
	border: 1px solid #aaa;
	margin: 2px;
	padding: 2px;
}

.data th {
	font-weight: bold;
	background-color: #5C82FF;
	color: white;
}
</style>
</head>
<body>

	<h2>CIUDADANO</h2>
	<c:url var="addAction" value="/ciudadano/add"></c:url>

	<form:form action="${addAction}" commandName="ciudadano"
		modelAttribute="ciudadano">


		<h3>${message}</h3>

		<c:if test="${!empty ciudadano.NOMBRE}">
			<tr>
				<td><form:label path="IDCIUDADANO">
						<spring:message text="ID" />
					</form:label></td>
				<td><form:input path="IDCIUDADANO" readonly="true" size="1"
						disabled="true" /><br> <form:hidden path="IDCIUDADANO" /></td>
			</tr>
		</c:if>
 
 NOMBRE: <form:input path="NOMBRE" />
		<br>
		<form:errors path="NOMBRE" />
		
 APELLIDO PATERNO: <form:input path="APPATERNO" />
		<br>
		<form:errors path="APPATERNO" />
		
APELLIDO MATERNO: <form:input path="APPMATERNO" />
		<br>
		<form:errors path="APPMATERNO" />

		<br>

		<c:if test="${!empty ciudadano.NOMBRE}">
			<input type="submit"
				value="<spring:message text="Editar ciudadano"/>" />
		</c:if>

		<c:if test="${empty ciudadano.NOMBRE}">
			<input type="submit"
				value="<spring:message text="Agregar Ciudadano"/>" />
		</c:if>
	</form:form>


	<h3>CIUDADANOS</h3>
	<table class="data" border="1">
		<tr>
			<th>ID</th>
			<th>NOMBRE</th>
			<th>APELLIDO PATERNO</th>
			<th>APELLIDO MATERNO</th>
			<th>DOMICILIO</th>
			<th>EDITAR</th>
			<th>ELIMINAR</th>
		</tr>
		<c:forEach items="${ciudadanoList}" var="ciudadano">
			<tr>
				<td>${ciudadano.IDCIUDADANO}</td>
				<td>${ciudadano.NOMBRE}</td>
				<td>${ciudadano.APPATERNO}</td>
				<td>${ciudadano.APPMATERNO}</td>
				<td><a href="<c:url value='/ciudadano/${ciudadano.IDCIUDADANO}/domicilio'/>">Ver</a></td>
				<td><a href="<c:url value='/edit/${ciudadano.IDCIUDADANO}'/>">Editar</a></td>
				<td><a href="<c:url value='/delete/${ciudadano.IDCIUDADANO}'/>">Eliminar</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>