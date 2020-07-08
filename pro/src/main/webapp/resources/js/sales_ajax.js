$(document).one(function(){
	car();
})
$(document).ready(function(){
	reList();
//	var isshow = $('#isshow').attr('value');
//	alert(isshow);
//	if(isshow == 'Y'){
//		.one();
//	}
	
// 리뷰 등록, 이미지 포함 ajax
$('#reviewOK').click(function reOK() {
		var form =  $('#ajax');
		var formData = new FormData(form[0]);
		for(var i of formData.entries()){
			console.log(i);
		}
		$.ajax({
			url: '/pro/sales/sales_review.pro',
			type: 'post',
			enctype: 'multipart/form-data',
			data: formData,
			processData: false,
			contentType: false,
			success: function(obj){
						$('#reviewTitle').val('');
						$('#reviewArea').val('');
						$('#reviewWrite').css('display','none');
						$('.line').remove();
						reList();
//						$('#reviewList').prepend('<div>'+
//								'<div id="rlist'+obj.rno+'" class="line">'+
//								'<div id="rCenter"><div><img src="/pro/upload/'+obj.savename+'" id="rimg"></div>'+
//								'<div>'+
//								'<span><b>평점 : <span id="rrst">'+ obj.rst + '</span></b></span><br>'+
//								'<span id="rname">ID : '+ obj.memid + '</span><br>'+
//								'<span id="rrtt" class="rrtt">'+ obj.rtt + '</span><br>'+
//								'<span id="rrbd">'+ obj.rbd + '</span><br>'+
//								'</div>'+
//								'</div>'+
//						'</div>')
			},
			error: function(){
				alert("### 리뷰 달기 통신에러 ###");
			}
		});
	});
// 리뷰 리스트 조회 ajax
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
						$('#reviewList').prepend('<div id="list">'+
								'<div id="rlist'+obj[i].rno+'" class="line">'+
									'<div id="rCenter"><div><img src="/pro/upload/'+obj[i].savename+'" id="rimg"></div>'+
									'<div id="rredit'+obj[i].rno+'">'+
										'<span><b>평점 : <span id="rrst'+obj[i].rno+'">'+ obj[i].rst + '</span></b>&nbsp&nbsp&nbsp'+obj[i].edit+'</span><br>'+
										'<span id="rname">ID : '+ obj[i].memid + '</span><br>'+
										'<span id="rrtt'+obj[i].rno+'" value="'+obj[i].rtt+'">'+ obj[i].rtt + '</span><br>'+
										'<span id="rrbd'+obj[i].rno+'">'+ obj[i].rbd + '</span><br>'+
									'</div>'+
										'<div id="review2'+obj[i].rno+'" style="display:none;"><h6><b>평점</b></h6>'+
											'<select id="rstSelect2'+obj[i].rno+'" name="rst">'+
												'<option value="5">★★★★★'+
												'<option value="4">★★★★'+
												'<option value="3">★★★'+
												'<option value="2">★★'+
												'<option value="1">★'+
											'</select>'+
											'<br>'+
											'<textarea id="reviewTitle2'+obj[i].rno+'"  style="resize:none; width: 100%; height: 30px;" name="rtt" placeholder="리뷰제목을 입력해주세요."></textarea><br>'+
											'<textarea id="reviewArea2'+obj[i].rno+'" style="resize:none; width: 100%; height: 100px;" name="rbd" placeholder="리뷰내용을 입력해주세요."></textarea>'+
											'<br>'+
											'<button class="editOK" value="'+obj[i].rno+'" onclick="edit()">등록</button>'+
										'</div>'+
								'</div>'+
								'<div id="reDelete" class="reDelete" value="'+obj[i].pno+'">'+
									'<a class="delete" value="'+obj[i].rno+'" onclick="remove()">삭제</a>&nbsp'+
									'<a class="edit" value="'+obj[i].rno+'">수정</a>'+
								'</div>'+
						'</div>')					
					} else {
						$('#reviewList').prepend('<div>'+
								'<div id="rlist'+obj[i].rno+'" class="line">'+
									'<div id="rCenter"><div><img src="/pro/upload/'+obj[i].savename+'" id="rimg"></div>'+
									'<div>'+
										'<span><b>평점 : <span id="rrst">'+ obj[i].rst + '</span></b>&nbsp&nbsp&nbsp'+obj[i].edit+'</span><br>'+
										'<span id="rname">ID : '+ obj[i].memid + '</span><br>'+
										'<span id="rrtt">'+ obj[i].rtt + '</span><br>'+
										'<span id="rrbd">'+ obj[i].rbd + '</span><br>'+
									'</div>'+
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
// 좋아요 클릭 이벤트 ajax
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
// 리뷰 글 삭제 ajax
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
			}
		},
		error: function(){
			alert("### 삭제 후 리스트 뽑기 통신에러 ###");
		}
	});
});

// 리뷰 수정 css변경
$(document).on('click', '.edit', function(){
	var rno = $(this).attr('value');
	$('#'+'rredit'+rno).css('display','none');
	$('#'+'review2'+rno).css('display', 'block');
	$('#reviewList').css('margin-top','3em');
	var rrtt = $(this).parent().parent().find('#'+'rrtt'+rno).html();
	var rrbd = $(this).parent().parent().find('#'+'rrbd'+rno).html();
	$('#'+'reviewTitle2'+rno).focus();	
	$('#'+'reviewTitle2'+rno).val(rrtt);
	$('#'+'reviewArea2'+rno).val(rrbd);
});

// 리뷰 수정 동작 ajax
$(document).on('click','.editOK', function edit(){
	var rno = $(this).attr('value');
	var pno = $('#'+'rlist'+rno).attr('value');
	var rst = $('#'+'rstSelect2'+rno).val();
	var rtt = $('#'+'reviewTitle2'+rno).val();
	var rbd = $('#'+'reviewArea2'+rno).val();
	alert('pno : ' + pno);
	alert('rno : ' + rno);
	alert('rst : ' + rst);
	alert('rtt : ' + rtt);
	alert('rbd : ' + rbd);
	$.ajax({
		url: '/pro/sales/reviewEdit.pro',
		type: 'post',
		dataType: 'json',
		data:{
			'rno' : rno,
			'rst' : rst,
			'rtt' : rtt,
			'rbd' : rbd
		},
		success: function(obj){
			$('.line').remove();
			reList();
		},
		error: function(){
			alert("### 통신에러 ###");
		}
	});
});
//차량 통계
function car(){
	var no = $('#apno').attr('value');
	$('#cpno').val(no);
	$('#car').submit();
};
});
