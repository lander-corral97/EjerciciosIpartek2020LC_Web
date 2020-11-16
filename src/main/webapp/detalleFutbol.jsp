<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="includes/cabecera.jsp" />
	<c:choose>
		<c:when test="${ futbolista != null }">
			<h1>${ futbolista.nombre }</h1>
			<hr>
			<p class="detalle">Id: ${ futbolista.id }</p>
			<p class="detalle">Altura: ${ futbolista.altura }m</p>
			<p class="detalle">Edad: ${ futbolista.edad }</p>
			<p class="detalle">País de procedencia: ${ futbolista.nacionalidad }</p>
			<p class="detalle">Equipo actual: ${ futbolista.equipo }</p>
		</c:when>
		<c:otherwise>
			${ error }
		</c:otherwise>
	</c:choose>
	<hr>
	<a href="futbol-eliminar?id=${ futbolista.id }">Eliminar</a>
<jsp:include page="includes/pie.jsp" />