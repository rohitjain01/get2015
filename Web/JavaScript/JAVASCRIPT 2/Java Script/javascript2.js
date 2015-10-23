var rows;

function printtable(){
	var table = document.getElementById("inputtable");
	rows = document.getElementById("t1").value;
	if( rows <= 0 || rows > 100 ) {
		alert("Please enter correct rows  ");
	} else {
		document.getElementById("button1").disabled = true;
		document.getElementById("button2").disabled = false;
		var string="<tr><th>Name</th><th> Min </th><th> Max </th></tr>";
		for(i=1; i<=rows; i++) {
			string+="<tr><td><input type='text' id='name"+i+"'></td><td><input type='number' id='min"+i+"' min=1 max=9></td><td><input type='number' id='max"+i+"' min=1 max=9></td></tr>";
		}
		string += "<tr><td colspan='3' align='center'><input type='button' value='ok' onclick='drawTable()' class='button'>&nbsp;<input type='Reset' value='Reset' onclick='reset2()' class='button'></td></tr>";
		table.innerHTML = string;
	}
}

function reset1(){
	window.location.reload();
}

function reset2(){
	
	var table = document.getElementById("displaytable");
	var string = "";
	table.innerHTML = string;
	
}


function drawTable(){
	
	var table = document.getElementById("displaytable");
	var string = "";
	
	
		for(i=1; i<=rows; i++){
			
			var name = document.getElementById("name"+i).value;
			var min = document.getElementById("min"+i).value;
			var max = document.getElementById("max"+i).value;
			
			if(name == "" && max == "" && min == ""){
				continue;
			}
			else if( max<=0 || max>=10 || min<=0 || min>=10 ){
				alert("Enter Input in row "+i+" between 0 & 10");
				continue;
			}
			else if(max <= min){
				alert("Max should be greater than min in row "+i);
				continue;
			}	
			
			string += "<tr><td class='name'>"+name+"</td>";
			for(j=1; j<10; j++){
				
				if( j<=max && j>=min ){
					string += "<td class='red'></td>";
				}else{
					string += "<td class='notred'></td>";
				}
					
			}
			string += "</tr>";
		}
		if(string == "") {
			alert("Please fill atleast one row completely");
		}else {
			table.innerHTML = string;
		}
}