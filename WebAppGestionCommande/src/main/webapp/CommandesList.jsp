<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@page import="java.util.Collection"%>
<%@page import="com.GestionCommande.entities.Commande"%>
<!DOCTYPE html>
<html>
<head>
 <link href="static/style.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
 <meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body{
  background-image: linear-gradient(to right, #FFB6C1, grey);
 
	}
	img {
  border-radius: 70%;
}
.container{
 
		margin-top:30px !important;

}
.list-group{
	width: 400px !important;
	margin-top:70px !important;

}

.list-group-item{
	border: 2px solid grey;
	margin-top:10px;
	border-radius: none; 
	background:#c29196;
	cursor: pointer;
	transition: all 0.3s ease-in-out;
}


.list-group-item:hover{
	transform: scaleX(1.1);
	background:grey;
	border: 2px solid #c29196;
}



.check{
	opacity: 0;
	transition: all 0.6s ease-in-out;
}

.list-group-item:hover .check {
	opacity: 1;

}

.about span{
	font-size: 12px;
	margin-right: 10px;

}

input[type=checkbox] {
         position: relative;
	       cursor: pointer;
    }
    input[type=checkbox]:before {
         content: "";
    display: block;
    position: absolute;
    width: 20px;
    height: 20px;
    top: 0px;
    left: 0;
    border: 1px solid #10a3f9;
    border-radius: 3px;
    background-color: white;

}
    input[type=checkbox]:checked:after {
         content: "";
    display: block;
    width: 7px;
    height: 12px;
    border: solid  #007bff;
    border-width: 0 2px 2px 0;
    -webkit-transform: rotate(45deg);
    -ms-transform: rotate(45deg);
    transform: rotate(45deg);
    position: absolute;
    top: 2px;
    left: 6px;
   }

  input[type="checkbox"]:checked + .check { opacity: 1; }
 
</style>
</head>
<%
	Collection<Commande> commandes = (Collection<Commande>)request.getAttribute("commandes");
int i=1;
%>
<body>
<div class="container d-flex justify-content-center">
		<a href="AddCommandeServlet"><img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAOEAAADhCAMAAAAJbSJIAAAAP1BMVEUAAAD/wMvElJz/w87/xdCcdny4ipIkGx3/yNP/ws41KCoMCQmRbXQ/MDLqsLoFBARXQUWIZmz4u8VuU1iieYGP0eo9AAACAklEQVR4nO3d63KCMBBAYQkBQS7K5f2ftaD9045CHAy7Lud7AN0zgtOSODmdAAAAAAAAAAAAAAAAAAD465bl7r88u0mP9Snnri+8L//zvui7s/Rwn9C4skyeK0vXSI+33cX5F30z7y7SA25V1Qt9s7qSHnGjpk0XA9P226/TYekavV+ng/SIG42rhaP0iBvlq4W59IjbXN3ybTjdiO4qPeQmFFKoH4UU6kchhfpRSKF+FFKoH4UU6kchhfpRSKF+FFKoH4UU6kchhfpRSKF+FFKon/3CU0Ch9IjPXEMFfYbVG6+3g6oZnuzZfq1fCUyS/o1Xy7Ohibwf9VK33vs03Grg9CmGm967raPuKm5cEjJzTGkSc2/4eXHP9l68i7fDv3u16X5fZRetsJe+RB/SPlbgrZBu+1XE+rVNpuEunPksUuHqnu29RNsb7nR80UxfNbH+0qNwNxRSSKE8CimkUB6FFFIoj0IKX7L/P7795zT2n7XZf156gGfe9tct7K89HWD98L4GPAquAY/R14Afwtfdq+9bx3/Xl+7FCGd/Pw2FFOpHIYX6UUihfhRSqB+FFOpHIYX6UUihfhRSqB+FFOpHIYX6UUihfhRSqB+FFOpnv9D+mV0HOHfN/tl59s8/tH+Gpf1zSA9wluwBzgOeGT/TGQAAAAAAAAAAAAAAAADwMT8k9kGEfvh6bQAAAABJRU5ErkJggg==" width="40" /></a>

		<ul class="list-group mt-5 text-white">
		<% for(Commande com:commandes){%>
		  <li class="list-group-item d-flex justify-content-between align-content-center  btn-light" >

		  	<div class="d-flex flex-row ">
		  		<a href="CommandeInfServlet?id=<%=com.get_id() %>"><img src="data:image/jpeg;base64,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" width="40" /></a>
		  		<div class="ml-2 ">
		  			<h6 class="mb-0">Commande <%=i%></h6>
		  			<div class="about">
		  				<span><%= com.getDate() %></span>
		  			</div>
		  		</div>
		  	</div>
		
		  </li>
<%i++;} %>

		  
		</ul>
		
		</div>
		
</body>
</html>