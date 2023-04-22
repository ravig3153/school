<!doctype html>
 <%@page import="com.model.Emp"%>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Success</title>
    <link href="../assets/css/css1" rel="stylesheet" />
    <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	
	<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
  </head>
  <body>
 
  
  
  
  <form  action="logout" method="get" id="form">
  
  <div class="container text-center text-warning ravi">
    
     <%
   Emp employee = (Emp) session.getAttribute("data");
  
  out.println("<h1>"+"Welcome " + employee.getName()+"</h1>");
  
 
%> 
   </div> 
  
   
   <div class="container text-right font ">
<button class="btn btn-primary text-right" type="submit">Logout</button>
     </div> 
    <div class="container-fluid ">
     <img src="../img/alone.jpg"class="d-block w-90" alt="Cinque Terre">
      </div>
      </form>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
  </body>
  
  
  
  
</html>

