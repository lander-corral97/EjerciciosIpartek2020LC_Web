<jsp:include page="includes/cabecera.jsp" />
		<h1>Soy la p�gina de inicio</h1>
	
		<%
			// podemos combinar HTML + JAVA = JSP (Java Server Page)
		out.print("<p class='code'>Este p�rrafo est� escrito en Java</p>");
		%>
	
		<p>Esto hace un GET</p>
		<a class="button" href="futbol">Futbolistas</a>
<jsp:include page="includes/pie.jsp" />