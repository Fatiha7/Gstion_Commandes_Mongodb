<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.Collection"%>
<%@page import="com.GestionCommande.entities.Produit"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<style type="text/css">
.p{
margin-right:10% !important;
 margin-left:10% !important;
 
  border-radius: 8px;
  padding: 5px;
}
</style>
<title>Insert title here</title>
</head>
<body>
<h1 class="text-center">Liste des Produits</h1>
<br><br>
<%
	Collection<Produit> produits = (Collection<Produit>)request.getAttribute("produits");
HttpSession Session = request.getSession(); 
Session.setAttribute( "produits", produits);
%>
<div class="p">
<table class="table table-striped">
	<tr>
		<th>Nom</th>
		<th>Stock</th>
		<th>prix</th>
		
	</tr>
<%
	for(Produit produit : produits){
%>
	<tr>
		<td><%=produit.getPnom() %></td>
		<td><%=produit.getStock() %></td>
		<td><%=produit.getPrix() %></td>
		
	</tr>
<%

	}
%>
</table>
</div>
<div class="text-center">
                        <a href="index.jsp" class="btn btn-dark btn-lg">Return</a>
                    <a href="ProduitImpFromServlet" class="btn btn-dark btn-lg">Imprimer</a>
</div>
</body>
</html>