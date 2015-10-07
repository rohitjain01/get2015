
		function activateSubmit() {
			if(document.getElementById("check").checked == true) {
				document.getElementById("submit").disabled = false;
			}
			else {
				document.getElementById("submit").disabled = true;
			}
		}
		
		
		function validate() {
			var flag = true;
			if(document.getElementById("first").value.trim() == "") {
				flag = false;
				alert("First Name Is Empty");
			
				
			} 
			
			else if(document.getElementById("last").value.trim() == "") {
				flag = false;
				alert("Last Name Is Empty");
				
			}
			
			else if(document.getElementById("password").value.length < 8 ){
				flag = false;
				alert("Password Length should be greater than 8");
				
			}
			
			
			else if(document.getElementById("password").value != document.getElementById("confirm").value) {
				flag = false;
				alert("Password & Re-Enter Password  mismatch!!");
				
			}
			
			else if(document.getElementById("age").value< 18 ||document.getElementById("age").value >100 ){
				flag = false;
				alert("age  should between 18 and 100");
				
			}
			else if(document.getElementById("state").selectedIndex == 0) {
				flag = false;
				alert("Please select state") ;
				
			}
			else if(document.getElementById("city").selectedIndex == 0) {
				flag = false;
				alert("Please select city") ;
				
			}
			else if(document.getElementById("address").value.trim() == "") {
				flag = false;
				alert("address Is Empty");
				
			}
			if(flag == true) {
				
				
				alert("Form successfully submitted");
			}
		}
		
		function createCity() {
			var cityObject = document.getElementById("city");
			var stateObject = document.getElementById("state");
			switch(stateObject.value) {
				case "Rajsthan" :
					cityObject.innerHTML = "<Option>Select City<Option>Jaipur</option><Option>Bikaner</option><Option>Kota</option><Option>Ajmer</option>";
					break;
				case "MP" :
					cityObject.innerHTML = "<Option>Select City<Option>Bilaspur</option><Option>Bhopal</option><Option>Gwalior</option><Option>Mandi</option>";
					break;
				case "UP" :
					cityObject.innerHTML = "<Option>Select City<Option>Agra</option><Option>Kanpur</option><Option>Aligarh</option><Option>Mathura</option>";
					break;
				case "Maharastra":
					cityObject.innerHTML = "<Option>Select City<Option>Mumbai</option><Option>Pune</option><Option>Aurangabad</option><Option>Thane</option>";
					break;
			}
		}
	
		