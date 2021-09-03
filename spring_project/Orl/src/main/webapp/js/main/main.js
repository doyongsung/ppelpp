$(function(){

    $('#fullpage').fullpage({
		//options here
		autoScrolling:true,
		scrollHorizontally: true,
        navigation:true,
        navigationPosition:'right'
        
	});
});
var $header = $('header') ;
$(window).scroll(function(){
	if($(this).scrollTop() > 0){
		$header.addClass('sticky');
	}else{
		$header.removeClass('sticky');
	}
})