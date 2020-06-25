$(document).ready(function(){
	reList();
$('#reviewOK').click(function reOK() {
		var pno = $('#apno').attr('value');
		var rtt = $('#reviewTitle').val();
		var rbd = $('#reviewArea').val();
		var memid = $('#asid').attr('value');
		var rst = $('#rstSelect').val();
		$.ajax({
			url: '/pro/sales/sales_review.pro',
			type: 'post',
			dataType: 'json',
			data:{
				'pno' : pno,
				'rtt' : rtt,
				'rbd' : rbd,
				'memid' : memid,
				'rst' : rst
			},
			success: function(obj){
						$('#reviewTitle').val('');
						$('#reviewArea').val('');
//						reList();
						$('#reviewList').prepend('<div>'+
								'<div id="rlist" class="line">'+
								'<div>'+
								'<span><b>평점 : <span id="rrst">'+ obj.rst + '</span></b></span><br>'+
								'<span id="rname">ID : '+ obj.memid + '</span><br>'+
								'<span id="rrtt">'+ obj.rtt + '</span>'+
								'</div>'+
								'<div>'+
								'<span id="rrbd">'+ obj.rbd + '</span>'+
								'</div>'+
								'<div id="reDelete">'+
								'<a href="/pro/sales/reviewDelete.pro?rno='+obj.rno+'&pno='+obj.pno+'">삭제</a>'+
						'</div>')
			},
			error: function(){
				alert("### 리뷰 달기 통신에러 ###");
			}
		});
	});
	
function reList(){
		var pno = $('#apno').attr('value');
		$.ajax({
			url: '/pro/sales/reviewList.pro',
			type: 'post',
			dataType: 'json',
			data:{
				'pno' : pno
			},
			success: function(obj){
				var len = obj.length;
				for(var i = 0; i < len; i++){
					$('#reviewList').prepend('<div>'+
							'<div id="rlist'+obj[i].rno+'" class="line">'+
							'<div>'+
							'<span><b>평점 : <span id="rrst">'+ obj[i].rst + '</span></b></span><br>'+
							'<span id="rname">ID : '+ obj[i].memid + '</span><br>'+
							'<span id="rrtt">'+ obj[i].rtt + '</span>'+
							'</div>'+
							'<div>'+
							'<span id="rrbd">'+ obj[i].rbd + '</span>'+
							'</div>'+
							'<div id="reDelete" class="reDelete" value="'+obj[i].pno+'">'+
//							'<a href="/pro/sales/reviewDelete.pro?rno='+obj[i].rno+'&pno='+obj[i].pno+'">삭제</a>'+
							'<a class="delete" value="'+obj[i].rno+'"onclick="remove()">삭제</a>'+
							'</div>'+
					'</div>')					
				}
			},
			error: function(){
				alert("### 리스트 뽑기 통신에러 ###");
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
