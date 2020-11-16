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
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ futbolistas }" var="fut">
				<tr>
					<td><a href="futbolista?id=${ fut.id }">${ fut.nombre }</a></td>
					<td>${ fut.equipo }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
<jsp:include page="includes/pie.jsp" />