<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Soy la página de inicio</h1>

	<%
		// podemos combinar HTML + JAVA = JSP (Java Server Page)
	out.print("<p>Este párrafo está escrito en Java</p>");
	%>

	<p>Esto hace un GET</p>
	<a href="futbol">Futbolistas</a>

	<form method="post" action="futbol">
		<p>Esto hace un POST</p>
		<input type="text" name="nombre" placeholder="Nombre del futbolista">
		<br>
		<input type="number" name="edad" placeholder="Introduce la edad">
		<br>
		<input type="number" step="0.01" name="altura" placeholder="Introduce la altura">
		<br>
		<input type="text" name="nacionalidad" placeholder="Introduce la nacionalidad">
		<br>
		<input type="text" name="equipo" placeholder="Nombre del equipo">
		<br> 
		<input type="submit" value="Enviar">
	</form>

</body>
</html>