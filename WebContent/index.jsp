<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2>bet365</h2>

	<form name="form" action="/Apuestas/ServletApuestas" method="post">

		Nombre: <input type="text" name="nombre"> <br /> <br />

		<h3>Evento Deportivo:</h3>
		Real Madrid vs Deportivo de la Coruña <br /> 
		<input type="radio" name="apuesta" value="1"> <label for="1">1</label> 
		<input type="radio" name="apuesta" value="x"> <label for="x">x</label>
		<input type="radio" name="apuesta" value="2"> <label for="2">2</label>

		<br /> 
		<br /> 
		
		Cantidad de la apuesta: <input type="text" name="cantidadApostada"> 
		<br /> 
		<br /> 
		Cuota del partido: 1.45 - 2.10 - 5.00 (por € apostado) 
		<br /> 
		<br /> <input type="submit" name="enviar" value="Apostar">

	</form>
	
	

</body>
</html>