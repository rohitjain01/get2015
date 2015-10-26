<%@page import="com.helper.*" %>
<%@page import="com.model.*" %>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Search Car</title>
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
			<li><a href="LoginController">Login</a></li>
			<li class="active"><a href="#">Search</a></li>
		  </ul>
		</nav>
		<section class="section2">
			<form action="SearchController" method="post">
					<h2>Select Details</h2>
					<table>
						<tr>
							<td class="text">Select Make:</td>
							<td><input type="text" list="make" name="make" required placeholder="Select Make" class="list">
							<datalist id="make">
							<%
									List<String> make = VehicleJDBCHelper.distictMake();
									if(make.size() != 0) {
										Iterator<String> iterator = make.iterator();
										while(iterator.hasNext()) {
											out.print("<option value="+iterator.next()+">");
										}
									}
								
							%>
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