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
			<li class="active"><a href="#">Create</a></li>
			<li><a href="SearchAdminController">Search</a></li>
			<li class="logout"><a href="LogoutController">Logout</a></li>
		  </ul>
		</nav>
		<section class="section1">
			<form action="CreateController" method="post">
					<h2>Enter Car Details</h2>
					<table>
						<tr>
							<td colspan="2" class="alert1"><% if(request.getAttribute("message") != null) {
																	out.print(request.getAttribute("message"));
																}
															%>
						</tr>
						<tr><td class="text">Name:</td>
							<td><input type="text" required name="name" placeholder="Enter Your Name"  id="t1" class="field" pattern="[a-zA-Z]{2,}[a-zA-Z ]{0,}"></td></tr>
						<tr><td class="text">EngineIncc:</td>
							<td><input type="number" required="required" min="100" name="enginecc"  class="field" id="t2" placeholder="Enter EngineInCC of Car"></td></tr>	
						<tr><td class="text">FuelCapacity:</td>
							<td><input type="number" required="required" min="10" name="fuelcapacity"  class="field" id="t3" placeholder="Enter Fuel Capacity of Car"></td></tr>						
						<tr><td class="text">Make:</td>
							<td><input type="text" required="required" name="make"  class="field" id="t4" placeholder="Enter Company Name of Car"></td></tr>					
						<tr><td class="text">Milage:</td>
							<td><input type="number" required="required" name="milage" min="10" class="field" id="t5" placeholder="Enter Milage of Car"></td></tr>						
						<tr><td class="text">Model:</td>
							<td><input type="text" required="required" name="model"  class="field" id="t6" placeholder="Enter Model Name of Car"></td></tr>						
						<tr><td class="text">Price:</td>
							<td><input type="number" required="required" name="price" min="100000" class="field" id="t7" placeholder="Enter Price of Car"></td></tr>
						<tr><td class="text">AC:</td>
						<td class="text1"><input type="radio" required="required" name="ac" value="yes"  class="radioField" id="t8">YES
								<input type="radio" required="required" name="ac" value="no"  class="radioField" id="t8">NO</td></tr>
						<tr><td class="text">Accessory Kit:</td>
						<td class="text1"><input type="radio" required="required" name="accessorykit" value="yes"  class="radioField" id="t9">YES
								<input type="radio" required="required" name="accessorykit" value="no"  class="radioField" id="t9">NO</td></tr>
						<tr><td class="text">Power Steering:</td>
						<td class="text1"><input type="radio" required="required" name="powersteering" value="yes"  class="radioField" id="t10">YES
								<input type="radio" required="required" name="powersteering" value="no"  class="radioField" id="t10">NO</td></tr>
						<tr></tr>
						<tr><td colspan="2" align="center"><input type="reset" name="reset" class="button">
						<input type="submit" name="submit" class="button"></td>
						
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