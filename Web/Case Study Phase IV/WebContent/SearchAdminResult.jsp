<%@page import="com.helper.*" %>
<%@page import="com.model.*" %>
<%@page import="java.util.*"%>
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
		<section class="section4">
			<form action="#">
				
					<h2>Car Details</h2>
					<table>
						<tr>
							<th>Make</th>
							<th>Model</th>
							<th>View Details</th>
							<th>Edit Car</th>
						</tr>
						<%
							String make = request.getParameter("make");
								List<String> modelList = VehicleJDBCHelper.searchModel(make);
								Iterator<String> modelIterator = modelList.iterator();
								while(modelIterator.hasNext()) {
									String model = modelIterator.next();
									out.print("<tr><td>"+make+"</td><td>"+model+"</td><td><a href='ViewDetailController?make="+make+"&model="+model+"'>View Details</a></td><td><a href='EditCarController?make="+make+"&model="+model+"'>Edit</a></td></tr>");
								}
							
						%>
						
					</table>
				
			</form>
		</section>
		<footer>
			<p> @Copyright  2015. All Rights Reserved. Designed By <a href="https://www.linkedin.com/home?trk=nav_responsive_tab_home">R. K. Jain</a> </p>
		</footer>
		</div>
	</body>
</html>