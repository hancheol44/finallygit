$(document).ready(function(){
	reList();

$('#comment').click(function reOK() {

	var param = $("form[name=cfrm]").serialize();
		$.ajax({
			url: '/pro/board/boardComment.pro',
			type: 'POST',
			dataType: 'json',
			data: param,
			success: function(data){
			prepend('<div class="w3-left reBoard ">'+
								'<div>'+param.name+'</div>'+
								'<div>'+param.bdbd+'</div>'+
								'<div>'+param.today4+'</div>'+
								'</div>')
			},
			error: function(request,status,erro){
				alert("code:"+request.status+"\n"+"\n"+"error:"+error);
				alert("### 리뷰 달기 통신에러 ###");
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
					$('#reviewList').prepend('	<div class="w3-left reBoard ">'+
							'<div>'+obj[i].name+'</div>'+
							'<div>'+obj[i].bdbd+'</div>'+
							'<div>'+obj[i].today+'</div>'+
							'</div>')		
				}
			},
			error: function(request,status,error){
				alert("### 리스트 뽑기 통신에러 ###");
				alert("code:"+request.status+"\n"+"\n"+"error:"+error);

			}
		});
	};
	
});	
$(document).on('click','.delete', function remove(){
	var rno = $(this).attr('value');
	$.ajax({
		url: '/pro/sales/reviewDelete.pro',
		type: 'post',
		dataType: 'json',
		data:{
			'rno' : rno
		},
		success: function(obj){
			if(obj.result == 1){
				$('#'+'rlist'+rno).remove();
			} else{
				alert("실패");
			}
			
		},
		error: function(){
			alert("### 삭제 후 리스트 뽑기 통신에러 ###");
		}
	});
});

//$(document).on('click','.delete',function(){
//	alert($(this).attr('value'));
//})
