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

	<h2>DOMICILIO</h2>
	<h3>CIUDADANO: ${ciudadano.NOMBRE}</h3>
	<c:url var="addAction" value="/ciudadano/${ciudadano.IDCIUDADANO}/domicilio/add"></c:url>

	<form:form action="${addAction}" commandName="domicilio"
		modelAttribute="domicilio">


		<h3>${message}</h3>

		<c:if test="${!empty domicilio.CALLE}">
			<tr>
				<td><form:label path="IDDOMICILIO">
						<spring:message text="ID" />
					</form:label></td>
				<td><form:input path="IDDOMICILIO" readonly="true" size="1"
						disabled="true" /><br> <form:hidden path="IDDOMICILIO" /></td>
			</tr>
		</c:if>
 
 CALLE: <form:input path="CALLE" />
		<br>
		<form:errors path="CALLE" />
		
 NUMERO EXTERIOR: <form:input path="NUMEXT" />
		<br>
		<form:errors path="NUMEXT" />
		
NUMERO INTERIOR: <form:input path="NUMINT" />
		<br>
		<form:errors path="NUMINT" />
		
COLONIA: <form:input path="COLONIA" />
		<br>
		<form:errors path="COLONIA" />

CODIGO POSTAL: <form:input path="CP" />
		<br>
		<form:errors path="CP" />

CIUDAD: <form:input path="CIUDAD" />
		<br>
		<form:errors path="CIUDAD" />

ESTADO: <form:input path="ESTADO" />
		<br>
		<form:errors path="ESTADO" />
                    
		<br>

		<input type="submit" value="<spring:message text="Agregar Domicilio"/>" />
		
	</form:form>


	<h3>DOMICILIOS</h3>
	<table class="data" border="1">
		<tr>
			<th>ID</th>
			<th>CALLE</th>
			<th>NUM EXT</th>
			<th>NUM INT</th>
			<th>COLONIA</th>
			<th>CODIGO POSTAL</th>
			<th>CIUDAD</th>
			<th>ESTADO</th>
			<th>ELIMINAR</th>
		</tr>
		<c:forEach items="${domicilioList}" var="domicilio">
			<tr>
				<td>${domicilio.IDDOMICILIO}</td>
				<td>${domicilio.CALLE}</td>
				<td>${domicilio.NUMEXT}</td>
				<td>${domicilio.NUMINT}</td>
				<td>${domicilio.COLONIA}</td>
				<td>${domicilio.CP}</td>
				<td>${domicilio.CIUDAD}</td>
				<td>${domicilio.ESTADO}</td>
				<td><a href="<c:url value='/domicilio/delete/${domicilio.IDDOMICILIO}'/>">Eliminar</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>