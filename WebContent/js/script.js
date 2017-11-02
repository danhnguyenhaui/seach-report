$(document).ready(function(){
	$('#btn_upload').click(function(){
		$('.alert').addClass('show');
		
	});
	
	
	// set background for search text
	var searchText = $('.search-input').val();
	console.log(searchText);
	if(searchText != null && searchText != ''){
		$('.paragraph:contains("'+ searchText +'")').each(function(){
	        $(this).html( 
	            $(this).html().replace(searchText,"<strong style='background:yellow'>$&</strong>")
	        );
	    });
	}
	
	
});
