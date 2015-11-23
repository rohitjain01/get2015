
$(document).ready(function(){
	$('#emptyDiv').html("");
	$("#name").change(changeDivContent);
	$("#age").change(changeDivContent);
	$("#address").change(changeDivContent);
});


function changeDivContent() {
	string = "";
	if($('#name').val().trim() != "") {
		string += "<br><b> Name: </b>"+$('#name').val(); 
	}
	if($('#age').val() != "") {
		string += "<br><b> Age: </b>"+$('#age').val();
	}
	if($('#address').val().trim() != "") {
		string += "<br><b> Address: </b>"+$('#address').val();
	}
	
	$('#emptyDiv').html(string);
	var $el = $(this),
    	x = 500,
    	originalColor = $el.css("background");

	$el.css("background", "red");
	setTimeout(function(){
		$el.css("background", originalColor);
	}, x);
}

