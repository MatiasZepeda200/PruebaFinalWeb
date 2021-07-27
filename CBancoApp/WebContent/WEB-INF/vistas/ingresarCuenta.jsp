<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../templates/header.jsp"></jsp:include>
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
			<form method="POST" action="IngresarCuentaController.do">
				<div class="card">
					<div class="card-header has-background-link">
						<span class="card-header-title">Iniciar Secion</span>
					</div>
					<div class="card-content">
						<div class="field">
							<label class="label" for="rut-txt">Rut</label>
							<div class="control">
								<input type="text" class="input" id="rut-txt" name="rut-txt" />
							</div>
						</div>
						<div class="field">
							<label class="label" for="clave-txt">Clave</label>
							<div class="control">
								<input type="text" class="input" id="clave-txt"
									name="clave-txt" />
							</div>
						</div>
					</div>
						<div class="card-footer has-text-centered">
						<div class="card-footer-item">
							<button type="submit" class="button is-primary">Ingresar</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</main>
</body>
</html>