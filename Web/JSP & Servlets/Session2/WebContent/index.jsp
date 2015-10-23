<html>
	<head>
		<title>Registration Form</title>
		<link rel = "stylesheet" type = "text/css" href = "style.css"></link>
		<script type="text/javascript" src="session1.js"></script>
	</head>
	<body>
		
		<form id="myform" action="Registration">
			<fieldset>
				<legend>::Login::</legend>
					<table align ="center">
						<tr>
							<td class="text">User Name *</td> 
							<td><input type="text" id="username"  maxlength="15" placeholder="Enter Username" class="field" name="username"></td>
						</tr>
						<tr>
							<td class="text">Password *</td>
							<td><input type="password" id="password"  maxlength="15" placeholder="Enter Password" class="field" name="password"></td>
						</tr>
						<tr>
                    		<td colspan="2" align="center">${a}
                		</tr>
						<tr>
							<td colspan="2" align="center">
								<input type="submit" value="Create"  onclick="return validate()" class="button">
							</td>
						</tr>
					</table>
					<h2><I><a href="signup.jsp">New User......</a></I></h2>
				</fieldset>
		</form>
		
		
	</body>
</html>