<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../templates/head.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<main class="container mt-6">
	<c:if test="${errores !=null}">
		<div class="columns is-centered mb-6">
			<div class="column is-6">
				<div class="notification is-warning">
					<h6>Existen errores en el formulario</h6>
					<ul>
						<c:forEach var="error" items="${errores}">
							<li>${error}</li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
	</c:if>
	<div class="columns is-centered">
		<div class="column is-6">
			<form method="POST" action="RealizarTransferenciaController.do">
					<div class="card-header has-background-link">
						<span class="card-header-title">Ingresar Transferencia</span>
					</div>
					<div class="card-content">
					  <div class="field">
							<label class="label" for="origen-txt">Numero cuenta de origen</label>
							<div class="control">
								<input type="number" class="input" id="origen-txt" name="origen-txt" />
							</div>
						</div>
						<div class="field">
							<label class="label" for="destino-txt">Numero cuenta de destino</label>
							<div class="control">
								<input type="number" class="input" id="destino-txt" name="destino-txt" />
							</div>
						</div>
						<div class="field">
							<label class="label" for="monto-txt">Monto</label>
							<div class="control">
								<input type="number" class="input" id="monto-txt" name="monto-txt" />
							</div>
						</div>
						<div class="field">
							<label class="label" for="clave-txt">Clave</label>
							<div class="control">
								<input type="number" class="input" id="clave-txt" name="clave-txt" />
							</div>
						</div>
											<div class="card-footer has-text-centered">
						<div class="card-footer-item">
							<button type="submit" class="button is-primary">Registrar</button>
						</div>
					</div>
				</div>
			</form>
			</div>
			</div>
			</main>
</body>
</html>