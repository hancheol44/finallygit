$(document).ready(function(){
	reList();
	
$('#comment').click(function() {
	var form = $('#cfrm');
	var formData = new FormData(form[0]);
		$.ajax({
			url: '/pro/board/boardComment.pro',
			type: 'post',
			data: formData,
			processData: false,
			contentType: false,
			success: function(){
				
				$('.reBoard').remove();
				reList();
				$('#cbd').val('');
			},
			error: function(request,status,erro){
				alert("code:"+request.status+"\n"+"\n"+"error:"+error);
				alert("### 리뷰 달기 통신에러 ###");
			}
		});
	});
	

	
});	
$(document).on('click','.del', function remove(){
	$.ajax({
		url: '/pro/board/reDelete.pro',
		type: 'POST',
		data:{
			'bdno' : $(this).attr('value')
		},
		success: function(obj){
			$('.reBoard').remove();
			reList();
		},
		error: function(request,status,error){
			alert("### 리스트 뽑기 통신에러 ###");
			alert("code:"+request.status+"\n"+"\n"+"error:"+error);
		}
	});

});

function reList(){
	$.ajax({
		url: '/pro/board/reBoard.pro',
		type: 'post',
		dataType: 'json',
		data:{
			'bdno' : $('#bno').html()
			
		},
		success: function(obj){
			var len = obj.length;
			for(var i = 0; i < len; i++){
				$('#reviewList').append('<div class="w3-left reBoard " id="rlist'+obj[i].bdno+'">'+
						'<div>'+obj[i].name+'</div>'+
						'<div>'+obj[i].bdbd+'</div>'+
						'<div>'+obj[i].today+'</div>'+
						'<button type = "button" class="del" value="'+obj[i].bdno+'">삭제</button>&nbsp'+
						'</div>')		
			}
		},
		error: function(request,status,error){
			alert("### 리스트 뽑기 통신에러 ###");
			alert("code:"+request.status+"\n"+"\n"+"error:"+error);

		}
	});
};