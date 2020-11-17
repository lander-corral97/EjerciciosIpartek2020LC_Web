<jsp:include page="includes/cabecera.jsp" />
<h1>Futbolista Creado</h1>

<h1>${ futbolista.nombre }</h1>
<hr>
<p class="detalle">Id: ${ futbolista.id }</p>
<p class="detalle">Altura: ${ futbolista.altura }m</p>
<p class="detalle">Edad: ${ futbolista.edad }</p>
<p class="detalle">País de procedencia: ${ futbolista.nacionalidad }</p>
<p class="detalle">Equipo actual: ${ futbolista.equipo }</p>
<jsp:include page="includes/pie.jsp" />