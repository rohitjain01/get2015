
	
	function createCar(){
		var t1 = document.getElementById("t1").value;
		var t2 = document.getElementById("t2").value;
		var t3 = document.getElementById("t3").value;
		var t4 = document.getElementById("t4").value;
		var t5 = document.getElementById("t5").value;
		var t6 = document.getElementById("t6").value;
		var t7 = document.getElementById("t7").value;
		var t8 = document.getElementById("t8").value;
		var t9 = document.getElementById("t9").value;
		var t10 = document.getElementById("t10").value;
		if( t1 == "" || t2 == "" || t3 == "" || t4 == "" || t5 == "" || t6 == "" || t7 == "" || t8 == "" || t9 == "" || t10 == ""){
			alert("Please fill completely");
			return false;
		}else{
			return true;
		}
	}