<jsp:include page="includes/cabecera.jsp" />
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
<jsp:include page="includes/pie.jsp" />