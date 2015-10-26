<%@page import="java.util.*" %>
<%@page import="com.helper.*" %>
<%@page import="com.model.*" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Create New Car</title>
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
		<nav class="nav1">
		  <ul>
			<li><a href="AdminHomeController">My Home</a></li>
			<li><a href="CreateController">Create</a></li>
			<li><a href="SearchAdminController">Search</a></li>
			<li class="logout"><a href="LogoutController">Logout</a></li>
		  </ul>
		</nav>
		<section class="section5">
			<img src="./images/car_image.jpg"></img>
			<table>
				<%
				
					String make = request.getAttribute("make").toString();
					String model = request.getAttribute("model").toString();
					List<Vehicle> vehicles = VehicleJDBCHelper.searchByMakeAndModel(make, model);
					Iterator<Vehicle> iterator = vehicles.iterator();
					while(iterator.hasNext()) {
						Vehicle vehicle = iterator.next();
						out.print("<tr><td>Make</td><td>"+vehicle.getMake()+"</td></tr>");
						out.print("<tr><td>Model</td><td>"+vehicle.getModel()+"</td></tr>");
						out.print("<tr><td>EngineInCC</td><td>"+vehicle.getEnginInCC()+"</td></tr>");
						out.print("<tr><td>FuelCapacity</td><td>"+vehicle.getFuelCapacity()+"</td></tr>");
						out.print("<tr><td>Milage</td><td>"+vehicle.getMilage()+"</td></tr>");
						out.print("<tr><td>Price</td><td>"+vehicle.getPrice()+"</td></tr>");
						out.print("<tr><td>RoadTax</td><td>"+vehicle.getRoadTax()+"</td></tr>");
						out.print("<tr><td>AC</td><td>"+((Car)vehicle).isAC()+"</td></tr>");
						out.print("<tr><td>AccessoryKit</td><td>"+((Car)vehicle).isAccessoryKit()+"</td></tr>");
						out.print("<tr><td>PowerSteering</td><td>"+((Car)vehicle).isPowerSteering()+"</td></tr>");
					}
				
				%>
			</table>
			
		</section>
		<footer>
			<p> @Copyright  2015. All Rights Reserved. Designed By <a href="https://www.linkedin.com/home?trk=nav_responsive_tab_home">R. K. Jain</a> </p>
		</footer>
		</div>
	</body>
</html>