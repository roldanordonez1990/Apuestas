<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2>¿Has acertado tu apuesta?</h2>

	<form action="/Apuestas/ServletApuestas" method="post">
		
		<input type="radio" name="azar" value="ganar"> 
		<label for="ganar">Ganar</label> 
		<input type="radio" name="azar" value="perder"> 
		<label for="perder">Perder</label> <br /> <br />

		<input type="submit" value="Confirmar" name="confirmar">
		<br />
		
		<input type="hidden" name="cantidadApostada" value="<%= request.getAttribute("cantidadApostada") %>">
		<input type="hidden" name="nombre" value="<%= request.getAttribute("nombre") %>">

	</form>

	<%
	
	if(request.getAttribute("boton") != null){
		
		if ((Boolean) request.getAttribute("acierto") == true) {
			
			float cantidadTotal = (float)request.getAttribute("cantidadApostada");
			
			String nombre = (String) request.getAttribute("nombre");

			out.println("El jugador " + nombre +  " ha ganado: " + cantidadTotal);
		} else {
			
			out.println("El jugador " + request.getAttribute("nombre") + " ha perdido la apuesta");
		}
	}
		
	%>

</body>
</html>