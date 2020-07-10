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
		var id = $('#sid').attr('value');
		$('#pno').val(no);
		$('#memid').val(id);
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
//		$('#frm3').attr('action', '/pro/sales/sales_inside.pro');
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

	$('#file_saWrite').change(function(e){
		var profile = e.target.files;
		console.log(profile);
	}); 
	// 주문하기 페이지 보내기
	$('#menu').click(function(){
		var pno = $('#apno').attr('value');
		$('#mpno').val(pno);
		$('#menufrm').attr('action','/pro/sales/salesMenu.pro');
		$('#menufrm').submit();
	});
	$('#menuOK').click(function(){
		var select = $(':radio[name="menuCk"]:checked').attr('class');
		var pno = $('#mpno').attr('value');
		var sid = $('#sid').attr('value');
		var mno =  $(':radio[name="menuCk"]:checked').attr('value');
		alert(select+'원 결제되었습니다.');
		$('#memid').val(sid);
		$('#pno').val(pno);
		$('#mno').val(mno);
		$('#ckfrm').attr('action', '/pro/sales/salesPay.pro');
		$('#ckfrm').submit();
	});
});