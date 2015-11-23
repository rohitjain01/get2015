<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>cardekho.com</title>
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
		  <ul class="nav1">
			<li class="active"><a href="#">My Home</a></li>
			<li><a href="CreateController">Create</a></li>
			<li><a href="SearchAdminController">Search</a></li>
			<li><a href="LogoutController">Logout</a></li>
		  </ul>
		</nav>
		<section class="sectionAdmin">
				<h1>Admin Profile</h1>
				<table>
				<%
						Map<String, String> profile = (Map<String, String>)request.getAttribute("profile");
						out.print("<tr><td>Email</td><td>"+profile.get("email")+"</td></tr>");
						out.print("<tr><td>Name</td><td>"+profile.get("name")+"</td></tr>");
						out.print("<tr><td>Contact</td><td>"+profile.get("contact")+"</td></tr>");
						out.print("<tr><td>Address</td><td>"+profile.get("address")+"</td></tr>");
					
				%>
					<tr>
						<td colspan="2"><a href="EditProfileController">Edit Profile</a></td>
					</tr>
				</table>
		</section>
		<footer>
			<p> @Copyright  2015. All Rights Reserved. Designed By <a href="https://www.linkedin.com/home?trk=nav_responsive_tab_home">R. K. Jain</a> </p>
		</footer>
		</div>
	</body>
</html>