<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="includes/cabecera.jsp" />
	<h1>Futbolistas</h1>
	<c:if test="${ !mensaje.equals('') }">
		${ mensaje }
	</c:if>
	<table cellspacing = "0px">
		<thead>
			<tr>
				<th>Nombre</th>
				<th>Equipo</th>
				<th>Acciones</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ futbolistas }" var="fut">
				<tr>
					<td>${ fut.nombre }</td>
					<td>${ fut.equipo }</td>
					<td class="center"><a href="futbolista?id=${ fut.id }"><i class="fa fa-eye" aria-hidden="true"></i></a>
					<a href="#popup${ fut.id }"><i class="fa fa-trash" aria-hidden="true"></i></a></td>
				</tr>
					<div id="popup${ fut.id }" class="fade-to-black">
						<div class="content">
							<p>¿Estás seguro de que quieres borrar?</p>
							<div>
								<a href="futbol-eliminar?id=${ fut.id }" class="button">Sí</a>
								<a href="#" class="button">No</a>
							</div>
						</div>
					</div>
			</c:forEach>
		</tbody>
	</table>
<jsp:include page="includes/pie.jsp" />