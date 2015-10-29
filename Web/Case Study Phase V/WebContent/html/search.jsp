<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Search Car</title>
		<link rel="stylesheet" type="text/css" href="../css/style.css"></link>
	</head>
	<body>
	<div id="wrapper">
		<header>
			<img src="../images/logo1.jpg"></img>
			<h1>Car Dekho</h1>
			<br>
			<h3>Drive For Excellence</h3>
		</header>
		<nav>
		  <ul>
			<li><a href="MainController?type=index">Home</a></li>
			<li><a href="MainController?type=login">Login</a></li>
			<li class="active"><a href="#">Search</a></li>
		  </ul>
		</nav>
		<section class="section2">
			<form action="searchResult.jsp">
					<h2>Select Details</h2>
					<table>
						<tr>
							<td class="text">Select Make:</td>
							<td><input type="text" list="make" required placeholder="Select Make" class="list">
							<datalist id="make">
							<option value="Maruti Suzuki">
							<option value="TATA">
							<option value="Hyundai">
							<option value="SAIC Motors">
							<option value="Nissan Motors">
							<option value="BMW Group">
							<option value="Toyota Motors">
							<option value="Honda Motors">
							</datalist></td>
						</tr>
						<tr>
							<td class="text">Select Model:</td>
							<td><input type="text" list="model" required placeholder="Select Model" class="list">
							<datalist id="model">
							<option value="Volkswagen Golf GTE">
							<option value="BMW i8">
							<option value="Tesla Model S">
							<option value="Mercedes-AMG GT">
							<option value="Range Rover Sport SVR">
							<option value="Mazda MX-5">
							<option value="Mercedes-Benz A45 AMG">
							<option value="BMW M235i Convertible">
							</datalist></td>
						</tr>
						<tr>
							<td colspan="2" align="center" class="button"><input type="submit" name="submit" class="button"></td>
						</tr>
					</table>
			</form>
		</section>
		<footer>
			<p> @Copyright  2015. All Rights Reserved. Designed By <a href="https://www.linkedin.com/home?trk=nav_responsive_tab_home">R. K. Jain</a> </p>
		</footer>
		</div>
	</body>
</html>