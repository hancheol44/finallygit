$(document).ready(function(){
	// 글쓰기 이동
	$('#write').click(function(){
		$(location).attr('href', '/pro/sales/sales_write.pro');
	});
	// 글쓰기
	$('#save').click(function(){
		var sid = $('#sid_saWrite').attr('value');
		var title = $('#ptt_saWrite').val();
		var body = $('#pbd_write').val()
		var cate = $('#cate_saWrite').val();
//		var file = $('#file_saWrite').prop('file');
//		var file = $('#file_saWrite').val();
//		alert(file);
//		$('#file').prop(file);
//		var sf = $('#file').prop();
//		$('#file').val(file);
//		var sf = $('#file').val();
//		alert("file : "+sf+" / type : " + typeof sf);
//		$('#file_saWrite').val();
		$('#memid').val(sid);
		$('#ptt').val(title);
		$('#pbd').val(body);
		$('#cate').val(cate);
		$('#frm').attr('action', '/pro/sales/sales_write.pro');
		$('#frm').submit();
	});
	// 상세보기
	$('.salesList').click(function(){
		var no = $(this).attr('id');
//		alert(typeof no);
		$('#pno').val(no);
		$('#frm').attr('action', '/pro/sales/sales_inside.pro');
		$('#frm').submit();
	});
	// 목록보기
	$('#list').click(function(){
		$(location).attr('href', '/pro/sales/sales.pro');
	});
	// 글 삭제
	$('#delete').click(function(){
		var pno = $(this).attr('value');
		$('#spno').val(pno);
		$('#frm3').attr('action', '/pro/sales/sales_inside.pro');
		$('#frm3').submit();
	});
	// 수정페이지
	$('#modi').click(function(){
		var pno = $('#apno').attr('value');
		var ptt = $('#aptt').attr('value');
		var pbd = $('#apbd').attr('value');
		var cate = $('#acate').attr('value');
		$('#pno').val(pno);
		$('#ptt').val(ptt);
		$('#pbd').val(pbd);
		$('#cate').val(cate);
		$('#frm4').submit();
	});
	// 수정페이지 처리
	$('#edsave').click(function(){
		var pno = $('#pno').attr('value');
		var ptt = $('#ptt_saWrite').val();
		var pbd = $('#pbd_write').val();
		var cate = $('#cate_saWrite').val();
		$('#epno').val(pno);
		$('#eptt').val(ptt);
		$('#epbd').val(pbd);
		$('#ecate').val(cate);
		$('#frm').attr('action', '/pro/sales/sales_modifyProc.pro');
		$('#frm').submit();
	});
	
	// 리뷰펼치기
	$('#review').click(function(){
		$('#reviewWrite').css('display','block');
		$('#reviewList').css('margin-top','2em');
		$('#reviewTitle').focus();
	});
		
	// 리뷰등록
/*	$('#reviewOK').click(function(){
		var pno = $('#apno').attr('value');
		var rtt = $('#reviewTitle').val();
		var rbd = $('#reviewArea').val();
		var memid = $('#asid').attr('value');
		var rst = $('#rstSelect').val();
		$('#rpno').val(pno);
		$('#rtt').val(rtt);
		$('#rbd').val(rbd);
		$('#memid').val(memid);
		$('#rst').val(rst);
		$('#frm').attr('action', '/pro/sales/sales_review.pro');
		$('#frm').submit();
	});*/
	$('#file_saWrite').change(function(e){
//	profileView.addEventListener('change', function(e){
		
		var profile = e.target.files;
		
		console.log(profile);
//	});
		
	}); 
});


/*
$(document).on('click','#save', function imgadd(){
	var file = $('#file_saWrite').val();
	var profile = e.target.files;
	alert("file : " + file + " / type : " + typeof file);
	$.ajax({
		url: '/pro/sales/sales_write.pro',
		type: 'post',
		dataType: 'json',
		data:{
			'file' : profile
		},
		success: function(obj){
			alert("업로드 성공");
		},
		error: function(){
			alert("실패");
		}
	});
});
*/