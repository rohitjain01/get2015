	function show() {
				document.getElementById("text").style.visibility = "hidden";
				document.getElementById("showhide").hidden = "";
				document.getElementById("show").disabled = true;
				document.getElementById("hide").disabled = false;
	}
	
	function hide() {
				document.getElementById("text").style.visibility = "visible";
				document.getElementById("showhide").hidden = "hidden";
				document.getElementById("show").disabled = false;
				document.getElementById("hide").disabled = true;
	}