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
	// qna 페이징 처리
	$('.pbtn').click(function(){
		var str = $(this).text();
		$('#nowPage').val(str);
		$('#frm').attr('action', '/pro/qna/qnaList.pro');
		$('#frm').submit();
	});
	$('.w3-button').click(function(){
		var str = $(this).html();
		if(str == 'PRE'){
			$('#nowPage').val('${PAGE.startPage - 1}');
		}else if(str == 'NEXT'){
			$('#nowPage').val('${PAGE.EndPage + 1}');
		}else{
			return;
		}
		$('#frm').attr('action', '/pro/qna/qnaList');
		$('#frm').submit();
	});
	// 글 수정 버튼 기능처리
		$('#modibtn').click(function(){
			$('#qttin').attr('readonly', false);
			$('#qip4').attr('readonly', false);
		});
});