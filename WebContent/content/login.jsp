<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.model.Emp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>


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





<link href="../assets/css/css1" rel="stylesheet" />

</head>
<body>


	<%-- <h1><%= session.getAttribute("email") %></h1> --%>

	<div class="container text-center text-warning headcstm">
		<h2>Welcome to St. Paul School!!</h2>
	</div>
	<div class="">
		<div class="wrapper">

			<div class="form-left">
				<h2 class="text-uppercase text-center text-warning">Welcome to St. Paul School!!</h2>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
					do eiusmod tempor incididunt ut labore et dolore magna aliqua. Et
					molestie ac feugiat sed. Diam volutpat commodo.</p>
				<p class="text">
					<span>Sub Head:</span> Vitae auctor eu augudsf ut. Malesuada nunc
					vel risus commodo viverra. Praesent elementum facilisis leo vel.
				</p>
				<div class="form-field">
					<input type="submit" class="account" value="Have an Account?">
				</div>
			</div>


			<form class="form-right" action="mobile" method="post" id="myform">
				<h2 class="text-uppercase">Login</h2>
				<input type="hidden" name="pageName" value="login">

				<div class="row py-6">
					<div class="col-lg-1 control-label  py-13">

						<i class="fa-solid fa-envelope"></i>
					</div>
					<div class="col-lg-11 control-label">

						<input type="email" class="input-field" name="userEmail" required>

					</div>

				</div>

				<div class="row py-6">
					<div class="col-lg-1 control-label  py-13">
						<i class="fa-solid fa-lock"></i>
					</div>
					<div class="col-lg-11 control-label">
						<input type="password" name="password" id="userpassword"
							class="input-field">
					</div>
				</div>
				<br> <span id="myspan"></span> <br> <br>

				<div class="col-12 text-center">

					<button class="btn btn-warning text-center" type="submit">Submit
						form</button>
				</div>
			</form>
		</div>

	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

	<script>
	 	$(document).ready(function() {

			console.log("Page ready..........")
			$("#myform").on('submit', function(event) {
				event.preventDefault();

				var data = $(this).serialize();
				console.log(data);

				$.ajax({
					url : "mobile",
					data : data,
					type : 'POST',
					success : function(data) {
						console.log(data)
						if (data.trim() === 'fail'){
						
							$('#myspan').html("Invalid email & password!!")
							
						}else {
							console.log("success..........")
							location.href = "success.jsp";
						}
				
						
					},
					error : function(e) {
						console.log(data);
						console.log("error")
						$(".loader").hide();
						$(".form").show();
						$('#msg').html("Something went wrong on server!!")
						$("#msg").addClass('red-text')

					}
				})

			})
		}) 
	</script>



	<script src="https://code.jquery.com/jquery-3.6.0.min.js"
		integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
		crossorigin="anonymous"></script>
	

</body>
</html>