<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mi cuenta</title>
<link href="vendor/bulma/css/bulma.min.css" rel="stylesheet" />
</head>
<body>
	<header>
		<nav class="navbar has-background-warning" role="navigation" aria-label="main navigation">
			<div class="navbar-brand">
				<a class="navbar-item" href="Indexs.jsp"> <img
					src="img/logo.png">
				</a> <a role="button" class="navbar-burger" aria-label="menu"
					aria-expanded="false" data-target="navbarBasicExample"> <span
					aria-hidden="true"></span> <span aria-hidden="true"></span> <span
					aria-hidden="true"></span>
				</a>
			</div>

			<div id="navbarBasicExample" class="navbar-menu">
				<div class="navbar-start">
					<a class="navbar-item" href="Indexs.jsp">Inicio</a> <a class="navbar-item" href="VerSaldoController.do">
						Ver Saldo </a>
						<a class="navbar-item" href="RealizarTransferenciaController.do">
						Transferencia</a>
						<a class="navbar-item" href="VerTransferenciasController.do">
						Ver Movimientos	</a>
				</div>
			</div>
		</nav>
	</header>
