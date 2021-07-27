<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../templates/head.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<main class="container mt-6">
	<div class="columns is-centered">
		<div class="column is-8">
			<table class="table is-hovered is-bordered is-fullwidth" id="tabla">
				<thead class="has-background-link">
					<tr>
						<th>Cuenta</th>
						<th>Fecha de Transaccion</th>
						<th>Descripcion</th>
						<th>Destinatario</th>
						<th>Monto</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="clientes" items="${clientes}">
						<tr>
							<td>${clientes.idCuenta}</td>
							<td>${clientes.fecha}</td>
							<td>${clientes.descripcion}</td>
							<td>${clientes.idDestino}</td>
							<td>${clientes.monto}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</main>
</body>
</html>