<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Details de la location</title>
<link href="css/style.css" rel="stylesheet">
<script src="js/location.js"></script>
</head>
<body>
	<fieldset>
		<form action="afficheLocation.fr" method="post">
	  		<center>
		  		<label for="begin">Date de debut</label></br>
					<input type = "date" name="begin"></br></br>
		    		
		 		<label for="end">Date de fin</label></br>
					<input type = "date" name="end"></br></br>
				
				<label for="menage">Avec menage ?</label>
					<input type = "checkbox" name="menage"></br>
				
				<label for="assurance">Avec assurance ?</label>
					<input type = "checkbox" name="assurance"></br></br>
			</center>	
			<input value="Valider" type="submit" style=float:right>
			<input type="hidden" id="id" name="id" value="${requestScope.LOCATION.id}">
		</form>
</fieldset>
</body>
</html>