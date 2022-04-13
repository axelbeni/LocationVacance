<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Details des prix</title>
<link href="css/style.css" rel="stylesheet">
<script src="js/location.js"></script>
</head>
<body>
	<fieldset>
		<form action = "LocationPrix.fr" method="post">
	  		<center>
		  		<label for="LogPrice">Prix du logement</label>&nbsp;
					<label name="LogPrice">${requestScope.TARIFICATEUR.locationPrice}</label></br></br>
		    		
		 		<label for="MenagePrice">Prix du menage</label>&nbsp;
					<label name="MenagePrice">${requestScope.TARIFICATEUR.menagePrice}</label></br></br>
				
				<label for="AssurPrice">Prix de l assurance</label>&nbsp;
					<label name="AssurPrice">${requestScope.TARIFICATEUR.assPrice}</label></br></br>
				
				<label for="ReducDay">Reductions long sejour(reservation > 7j)</label>&nbsp;
					<label name="ReducDay">${requestScope.TARIFICATEUR.reduJour}</label></br></br>
				
				<label for="ReducAntic">Reductions Anticipation(Reservation 30j en avance)</label>&nbsp;
					<label name="ReducAntic">${requestScope.TARIFICATEUR.reduAnticip}</label></br></br>
				
				<label for="ReducFid">Reductions Fidelite</label>&nbsp;
					<label name="ReducFid">${requestScope.TARIFICATEUR.reduFidelite}</label></br></br>
				
				<label for="ReducTotal">Reductions total (plus de 500euros)</label>&nbsp;
					<label name="ReducTotal">${requestScope.TARIFICATEUR.reductionTotalPrice}</label></br></br>
					
				<label for="TotalPrice">Prix total</label>&nbsp;
					<label name="Price">${requestScope.TARIFICATEUR.totalPrice}</label></br></br>
		  		
			</center>
			<input type="hidden" id="id" name="id" value="${requestScope.LOCATION.id}">
			<input type="hidden" name="totalPrice" value="${requestScope.TARIFICATEUR.totalPrice}">
			<input value="Valider" type="submit" style=float:right>
		</form>
	</fieldset>
</body>
</html>