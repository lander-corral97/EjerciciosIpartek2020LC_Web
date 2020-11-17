<jsp:include page="includes/cabecera.jsp" />
<form method="post" action="futbol">
	<p>Esto hace un POST</p>
	<div class="form-group">
		<label for="nombre">Nombre</label> <input autofocus="autofocus" type="text" id="nombre"
			name="nombre" placeholder="Nombre del futbolista">
	</div>
	<div class="form-group">
		<label for="edad">Edad</label> <input type="number" id="edad"
			name="edad" placeholder="Introduce la edad">
	</div>
	<div class="form-group">
		<label for="altura">Altura</label> <input type="number" id="altura"
			step="0.01" name="altura" placeholder="Introduce la altura">
	</div>
	<div class="form-group">
		<label for="nacionalidad">Nacionalidad</label> <input type="text"
			id="nacionalidad" name="nacionalidad"
			placeholder="Introduce la nacionalidad">
	</div>
	<div class="form-group">
		<label for="equipo">Equipo</label> <input type="text" id="equipo"
			name="equipo" placeholder="Nombre del equipo">
	</div>
	<div class="form-group">
		<input type="submit" value="Enviar">
	</div>
</form>
<jsp:include page="includes/pie.jsp" />