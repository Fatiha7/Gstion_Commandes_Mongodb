<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,700,600' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

	<link rel="stylesheet" href="static/css/reset.css"> <!-- CSS reset -->
	
  	<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container mt-5 mb-5">
    <div class="row d-flex justify-content-center">
        <div class="col-md-12 ">
            <div class="card">
                <div class=" bg-light text-dark">
                    <div  class="text-center col">
                    
                    <div class="">
		
				<div class=" mb-0 h2" >
				<br>
			<h2>Gestion de Commande</h2>
			</div>
<br>
		</div>
		
		<form action="">
			<fieldset  ><!-- disabled -->
				<legend class=" h4">Client Info </legend>
				<br>
				<div>
				<p> 
				
				
				
				<div class="half-width row  ">
					<label for="Nom" class="h5 col-2">Name :  </label>
					<input type="text" id="Nom" name="Nom" class="form-control col" value="code java"> 
					<label for="Prenom" class="h5 col-2">Prenom :  </label>
					<input type="text" id="Prenom" name="Prenom " class="form-control col" value="code java">
				</div>
			<p><br>
				<div class="half-width row">
					<label for="Adresse" class="h5 col-2">Adresse :</label>
					<input type="text" id="Adresse" name="Adresse" class="form-control col" value="code java">
					<label for="Phone" class="h5 col-2">Phone :</label>
					<input type="text" id="Phone" name="Phone" class="form-control col" value="code java">
				</div>
				
			</div>
				<br>
				<legend class=" h4" >Produits info</legend>
				<br><p>
				<div class="col"><% for (int i=1;i<4;i++){ %>
				<div class="cd-credit-card ">
				<br>
					<div>
						<p class="half-width row">
							<label for="Produit" class="h5 col-2">Produit : </label>
							<input type="text" id="Produit" name="Produit" class="form-control col" value="code java">
							<label for="Prix" class="h5 col-2">Prix : </label>
							<input type="text" id="Prix" name="Prix" class="form-control col" value="code java">
							
						
							<p class="half-width row">
						
							<label for="Quentite" class="h5 col-2">Quantite:</label>
							
								<span class="cd-select ">
									<select  id="card-expiry-month" class="custom-select col">
									<option class="form-control ">select Quantite</option>
									<% for (int j=1;j<15;j++){ %>
										<option value="select Quantite" ><%=j %></option>
										<%} %>
									</select>
								</span>
							</b>
						</p>
					</div>
				</div> <!-- .cd-credit-card -->
		<%} %>
			<div>
			<br><br>
			
					<ul class="cd-payment-gateways">
						<li>
						<p class="half-width row ">
							
							<label for="paypal" class="h5 col">Prix Total:</label>
						<input type="text" name="PrixT" id="PrixT" value="xxx DH" class="form-control col">
						</li>
						<li>
						<p class="half-width row ">
							
							<label for="paypal" class="h5 col">Date :</label>
						<input type="text" name="PrixT" id="PrixT" value="07/12/2020" class="form-control col">
						</li>
					</ul>  <!-- .cd-payment-gateways -->
				</div>
				<br>
		</div>
				
			</fieldset>
			<input type="submit" value="Get started" class="">
					<input type="submit" value="Get started" class="">
					
		</form>

		<br><br>
	</div> <!-- .cd-form -->
	
              </div>      
                    
                    
                </div>
            </div>
            <div>
					
				</div>
        </div>
    </div>
</body>
</html>