$('document').ready(function(){
	
	$.getJSON('FetchCategoryJSON',{ajax:true},
			function(data){
		  
		 $('#cid').empty();
		    $('#cid').append($('<option>').text('-Select-'));
		   
		    $.each(data,function(i,item){
		    
		  $('#cid').append($('<option>').text(item.CATEGORYNAME).attr('value',item.CATEGORYID));	
		    	
		    	
		    });
		
	
	});
$('#cid').change(function(){
		
		$.getJSON('FetchChapterByCategoryIdJSON',{cid:$('#cid').val(),ajax:true},
				function(data){
		       
			$('#chid').empty();
		    $('#chid').append($('<option>').text('-Select-'));
		   
		    $.each(data,function(i,item){
		    
		  $('#chid').append($('<option>').text(item.CHAPTERNAME).attr('value',item.CHAPTERID));	
		    	
		    	
		    });
		
		
		});	
		
		
	});
$('#chid').change(function(){
	
	$.getJSON('FetchHeadingByChapterId',{chid:$('#chid').val(),ajax:true},
			function(data){
	       $('#hid').empty();
	    $('#hid').append($('<option>').text('-Select-'));
	   
	    $.each(data,function(i,item){
	    
	  $('#hid').append($('<option>').text(item.HEADINGNAME).attr('value',item.HEADINGID));	
	    	
	    	
	    });
	
	
	});	
	
	
});

});