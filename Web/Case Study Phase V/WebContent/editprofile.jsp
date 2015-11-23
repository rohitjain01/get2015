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
			<li><a href="AdminHomeController">My Home</a></li>
			<li><a href="CreateController">Create</a></li>
			<li><a href="SearchAdminController">Search</a></li>
			<li><a href="LogoutController">Logout</a></li>
		  </ul>
		</nav>
		<section class="sectionAdmin">
				<h1>Update Details </h1>
				<form action="EditProfileController" method="post">
				<table>
				<%

						Map<String, String> profile = (Map<String, String>)request.getAttribute("profile");
						out.print("<tr><td>Email</td><td><input type='text' class='field' name='email' required value='"+profile.get("email")+"'></td></tr>");
						out.print("<tr><td>Name</td><td><input type='text' class='field' name='name' required value='"+profile.get("name")+"'></td></tr>");
						out.print("<tr><td>Password</td><td><input type='password' class='field' name='password' required value='"+profile.get("password")+"'></td></tr>");
						out.print("<tr><td>Contact</td><td><input type='text' class='field' name='contact' required value='"+profile.get("contact")+"'></td></tr>");
						out.print("<tr><td>Address</td><td><input type='text' class='field' name='address' required value='"+profile.get("address")+"'></td></tr>");

				%>
					<tr>
						<td colspan="2"><input type="submit" class="button" value="Submit"></td>
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