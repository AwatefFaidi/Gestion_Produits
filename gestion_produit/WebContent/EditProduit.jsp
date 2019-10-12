<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib  uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Produits</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
</head>
<body>
<%@include file="header.jsp" %>
	<div class="container col-md-8 col-md-offset-2 col-xs-12">
	
	
		<div class="panel panel-primary">
			<div class="panel-heading">Saisie des Produits</div>
			<div class="panel-body">
				<form action="updateProduit.do" method="post">
				<div class="form-group">
				<!-- on ne peur pas modifier  ID dc on l afficher me sans modifier 
				si on ajoute disabled="disabled" on  a une probleme puisk id n est pas envoyee dans requette 
				c est pourqoi ne pas pratique desabled dans form -->
						<label class="control-label">ID:</label> 
						<input class="form-control" type="hidden" name="id" value="${produit.id}" required="required"
							 />
							 <label>${produit.id}</label>
							 <span></span>

					</div>
					<div class="form-group">
						<label class="control-label">Designation:</label> 
						<input class="form-control" type="text" name="designation" value="${produit.designation}" required="required"
							 />
							 <span></span>

					</div>
					<div class="form-group">
						<label class="control-label">Prix:</label> <input
							class="form-control" type="text" name="prix" value="${produit.prix}" required="required"
							 />
<span></span>
					</div>
					<div class="form-group">
						<label class="control-label">Quantite:</label> <input
							class="form-control" type="text" name="quantite" value="${produit.quantite}" required="required"
							 />
							 <span></span>
					</div>
					<button  type="submit" class="btn btn-primary">save</button>
				</form>
				</div>
	
			</div>
		</div>
	</div>


</body>
</html>