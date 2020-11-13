<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Futbolistas</h1>

	<ul>
		<c:forEach items="${ futbolistas }" var="fut">
			<li style="list-style: none">${ fut.id }:${ fut.nombre }, ${ fut.equipo }
			</li>
		</c:forEach>
	</ul>
</body>
</html>