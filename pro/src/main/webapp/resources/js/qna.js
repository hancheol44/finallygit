$(document).ready(function(){
	// qnaList.jsp 기능처리
	// qnalist -> qnaWrite 버튼 기능처리
	$('#qwbtn').click(function(){
		$(location).attr('href','/pro/qna/qnaWrite.pro');
	});
	
	// qnaList -> qnaDetail 버튼 기능처리
	$('.qlist').siblings().click(function(){
		var qno = $(this).parent().attr('id');
		$('#qno').val(qno);
		$('#DetailFrm').attr('action','/pro/qna/qnaDetail.pro');
		$('#DetailFrm').submit();
	});
	
	  
	// qna 글삭제 기능 처리
	$('#delbtn').click(function(){
	 
	  $('#delfrm').attr('action','/pro/qna/qnaDelProc.pro');
	  $('#delfrm').submit()
	});

	// qnaWrite.jsp 기능처리
	// qnaWrite -> qnalist 버튼 기능처리
	$('#wcbtn').click(function(){
		$(location).attr('href', '/pro/qna/qnaList.pro');
	});
	
	// qnaWrite 글쓰기 버튼 기능처리
	$('#sbbtn').click(function(){
		var tt = $('#qttin').val();
		var ip = $('#qip1').val();
		
		$('#qtt').val(tt);
		$('#qip').val(ip);
		$('#frm').attr('action','/pro/qna/qnaWriteProc.pro');
		$('#frm').submit();
	});
	// 페이징 기능처리
	
	
	
});