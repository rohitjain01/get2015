

$(document).ready(function(){
    $(".Start").click(function(){
    	$(".div1").stop();
        $(".div1").animate({left: '+=200px'},5000);
    });

    $(".Back").click(function(){
    	$(".div1").stop();
        $(".div1").animate({left: '-=200px'},5000);
    });
    
    $(".Stop").click(function(){
        $(".div1").stop();
    });
    
    $(".Left").click(function(){
    	$(".div1").animate({left: '-=50px'});
    	
    });
    
    $(".Right").click(function(){
    	$(".div1").animate({left: '+=50px'});
    	
    });
    
    $(".Top").click(function(){
    	$(".div1").animate({top: '-=50px'});
    	
    });
    
    $(".Bottom").click(function(){
    	$("div").animate({top: '+=50px'});
    	
    });
    
    
});