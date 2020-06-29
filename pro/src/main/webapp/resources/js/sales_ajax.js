$(document).ready(function(){
	reList();
$('#reviewOK').click(function reOK() {
//		var pno = $('#apno').attr('value');
//		var rtt = $('#reviewTitle').val();
//		var rbd = $('#reviewArea').val();
//		var memid = $('#asid').attr('value');
//		var rst = $('#rstSelect').val();
		var form =  $('#ajax');
		var formData = new FormData(form[0]);
		$.ajax({
			url: '/pro/sales/sales_review.pro',
			type: 'post',
			enctype: 'multipart/form-data',
			data: formData,
			success: function(obj){
						$('#reviewTitle').val('');
						$('#reviewArea').val('');
//						reList();
						$('#reviewList').prepend('<div>'+
								'<div id="rlist" class="line">'+
								'<div>'+
//								'<span><img id="img" alt="" src="/pro/upload/'+ obj.savename + '></span></b></span><br>'+
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
		var sid = $('#asid').attr('value');
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
					if(sid == obj[i].memid){
						$('#reviewList').prepend('<div>'+
//								'<div id="rimgdiv">'+
//								'</div>'+
								'<div id="rlist'+obj[i].rno+'" class="line">'+
								'<div id="rCenter"><div><img src="/pro/upload/'+obj[i].savename+'" id="rimg"></div>'+
//								'</div>'+
//								'<div>'+
								'<div>'+
								'<span><b>평점 : <span id="rrst">'+ obj[i].rst + '</span></b></span><br>'+
								'<span id="rname">ID : '+ obj[i].memid + '</span><br>'+
								'<span id="rrtt">'+ obj[i].rtt + '</span><br>'+
								'<span id="rrbd">'+ obj[i].rbd + '</span><br>'+
								'</div>'+
								'</div>'+
								'<div id="reDelete" class="reDelete" value="'+obj[i].pno+'">'+
								'<a class="delete" value="'+obj[i].rno+'"onclick="remove()">삭제</a></div>'+
								'</div>'+
						'</div>')					
					} else {
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
								'</div>'+
						'</div>')					
					}
				}
			},
			error: function(){
				alert("### 리스트 뽑기 통신에러 ###");
			}
		});
	};

$(document).on('click','#burger', function like(){
	form = $('#likefrm');
	formData = new FormData(form[0]);
	$.ajax({
		url: '/pro/sales/likeCheck.pro',
		type: 'post',
		data: formData,
		processData: false,
		contentType: false,
		success: function(obj){
			$('#likecnt').load('/pro/sales/sales_inside.pro?pno='+obj.pno+' #likecnt');
		},
		error: function(obj){
			alert("좋아요 누르기에 실패하셨습니다...ㅠㅠ");
		}
	});
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

$(document).on('click','#reviewOK', function imgadd(e){
//	var file = $('#file_saWrite').val();
	var profile = e.target.files;
	var form =  $('#ajax');
//	form.method = "POST";
//	alert('form : ' + form + " type : " + typeof form);
	var formData = new FormData(form[0]);
//	alert("formData" + formData);
//	alert("file : " + file + " / type : " + typeof file);
		$.ajax({
			url: '/pro/sales/sales_review.pro',
			type: 'POST',
			enctype: 'multipart/form-data',
			processData: false,
			contentType: false,
			data: formData,
			cache: false,
			success: function(obj){
				alert("업로드 성공");
			},
			error: function(){
				alert("실패");
			}
		});
	});
});
