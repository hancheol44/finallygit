$(document).ready(function(){
	reList();

// 리뷰 등록, 이미지 포함 ajax
$('#reviewOK').click(function reOK() {
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
								'<div id="rlist'+obj.rno+'" class="line">'+
								'<div id="rCenter"><div><img src="/pro/upload/'+obj.savename+'" id="rimg"></div>'+
								'<div>'+
								'<span><b>평점 : <span id="rrst">'+ obj.rst + '</span></b></span><br>'+
								'<span id="rname">ID : '+ obj.memid + '</span><br>'+
								'<span id="rrtt">'+ obj.rtt + '</span><br>'+
								'<span id="rrbd">'+ obj.rbd + '</span><br>'+
								'</div>'+
								'</div>'+
								'<div id="reDelete" class="reDelete" value="'+obj.pno+'">'+
								'<a class="delete" value="'+obj.rno+'"onclick="remove()">삭제</a></div>'+
								'</div>'+
						'</div>')
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
						$('#reviewList').prepend('<div>'+
								'<div id="rlist'+obj[i].rno+'" class="line">'+
									'<div id="rCenter"><div><img src="/pro/upload/'+obj[i].savename+'" id="rimg"></div>'+
									'<div id="rredit">'+
										'<span><b>평점 : <span id="rrst">'+ obj[i].rst + '</span></b></span><br>'+
										'<span id="rname">ID : '+ obj[i].memid + '</span><br>'+
										'<span id="rrtt" value="'+obj[i].rtt+'">'+ obj[i].rtt + '</span><br>'+
										'<span id="rrbd">'+ obj[i].rbd + '</span><br>'+
									'</div>'+
									'<form id="inajax" method="post" action="">'+
									'<div id="review2"><h6><b>평점</b></h6>'+
										'<select id="rstSelect2" name="rst">'+
											'<option value="5">★★★★★'+
											'<option value="4">★★★★'+
											'<option value="3">★★★'+
											'<option value="2">★★'+
											'<option value="1">★'+
										'</select>'+
										'<br>'+
										'<h6><b>이미지첨부</b></h6>'+
										'<input type="file" name="file" id="file_saWrite"><br>'+
										'<textarea id="reviewTitle2" name="rtt" placeholder="리뷰제목을 입력해주세요."></textarea><br>'+
										'<textarea id="reviewArea2" name="rbd" placeholder="리뷰내용을 입력해주세요."></textarea>'+
										'<form>'+
										'<br>'+
										'<button class="editOK">등록</button>'+
									'</div>'+
								'</div>'+
								'<div id="reDelete" class="reDelete" value="'+obj[i].pno+'">'+
									'<a class="delete" value="'+obj[i].rno+'"onclick="remove()">삭제</a>&nbsp'+
									'<a class="edit" value="'+obj[i].rno+'"onclick="edit()">수정</a>'+
								'</div>'+
						'</div>')					
					} else {
						$('#reviewList').prepend('<div>'+
								'<div id="rlist'+obj[i].rno+'" class="line">'+
									'<div id="rCenter"><div><img src="/pro/upload/'+obj[i].savename+'" id="rimg"></div>'+
									'<div>'+
										'<span><b>평점 : <span id="rrst">'+ obj[i].rst + '</span></b></span><br>'+
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
	alert("클릭!");
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
	$('#rredit').css('display','none');
	$('#review2').css('display', 'block');
	$('#reviewList').css('margin-top','3em');
	$('#reviewTitle2').focus();
//	$('#reviewTitle2').val(rrtt);
//	$('#reviewArea2').val(rrbd);
});

// 리뷰 수정 동작 ajax
$(document).on('click','.editOK', function edit(){
	var rno = $(this).attr('value');
	var rrtt = find('#rrtt');
	var rrbd = $(this).find('#rrbd');
	alert('rno : ' + rno);
	alert('rtt : ' + rrtt);
	alert('rbd : ' + rrbd);
	var rst = $('#rstSelect2').val();
	var rtt = $('#reviewTitle2').val();
	var rbd = $('#reviewArea2').val();
	
});
/*
// 리뷰 수정 동작 ajax
$(document).on('click','.editOK', function edit(){
	form= $('#inajax');
	formData = new FormData(form[0]);
	$.ajax({
		url: '/pro/sales/reviewEdit.pro',
		type: 'post',
		data: formData,
		processData: false,
		contentType: false,
		success: function(obj){
			('#reviewList').remove();
			reList();
		},
		error: function(){
			alert("### 통신에러 ###");
		}
	});
});
*/
});
