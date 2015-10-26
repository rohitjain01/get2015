<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Create New Car</title>
		<script type="text/javascript" src="./javascript/carDekho.js"></script>
		<link rel="stylesheet" type="text/css" href="./css/style.css"></link>
	</head>
	<body>
<div id="wrapper">
		<header>
			<img src="./images/logo1.jpg"></img>
			<h1>Car Dekho</h1>
			<br>
			<h3>Drive For Excellence</h3>
		</header>
		<nav>
		  <ul>
			<li><a href="HomeController">Home</a></li>
			<li class="active"><a href="#">Login</a></li>
			<li><a href="SearchController">Search</a></li>
		  </ul>
		</nav>
		<section class="section3">
			<form action="LoginController" name="loginform" method="post">
				
					<h2>Enter Administrator Details</h2>
					<table>
						<tr><td colspan="2" class="alert1"><% if(request.getParameter("message") != null) {
																	out.print(request.getParameter("message"));
															}
														   %>
					    ${message}</td></tr>
						<tr><td class="text">Email:</td>
							<td><input type="email" required name="email" placeholder="Enter Email Id"  id="id" class="field"></td></tr>
						<tr><td class="text">Password:</td>
							<td><input type="password" required="required" name="password"  class="field" placeholder="Enter Password" id="password"></td></tr>	
						<tr><td colspan="2" align="center"><input type="submit" name="submit" value="Login" class="button"></td>
					</table>
				
			</form>
		</section>
		<footer>
			<p> @Copyright  2015. All Rights Reserved. Designed By <a href="https://www.linkedin.com/home?trk=nav_responsive_tab_home">R. K. Jain</a> </p>
		</footer>
		</div>
	</body>
</html>