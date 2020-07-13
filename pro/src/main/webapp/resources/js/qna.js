$(document).ready(function(){
	// qnaList.jsp 기능처리
	// qnalist -> qnaWrite 버튼 기능처리
	$('#qwbtn').click(function(){
		$(location).attr('href','/pro/qna/qnaWrite.pro');
	});
	
	// qnaList -> qnaDetail 버튼 기능처리
	$('.qlist').siblings().click(function(){
		var qno = $(this).parent().attr('id');
		/*alert(qno);*/
		$('#qno').val(qno);
		$('#DetailFrm').attr('action','/pro/qna/qnaDetail.pro');
		$('#DetailFrm').submit();
	});
	
	  
	// Q&A 글삭제 기능 처리
	$('#delbtn').click(function(){
	 
	  $('#delfrm').attr('action','/pro/qna/qnaDelProc.pro');
	  $('#delfrm').submit()
	});
	// Q&A 관리자 글 삭제 기능 처리
	$('#delbtnn').click(function(){
		$('#delfrm2').attr('action','/pro/qna/qnaDel2Proc.pro');
		$('#delfrm2').submit()
	});
	

	// qnaWrite.jsp 기능처리
	// qnaWrite -> qnalist 버튼 기능처리
	$('#wcbtn').click(function(){
		$(location).attr('href', '/pro/qna/qnaList.pro');
	});
	//관리자 글 취소 버튼 처리
	$('#wdbtn').click(function(){
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
		var updown = $('#modibtn').text();
			if(updown === '글수정'){
				$('#qttin').attr('readonly', false);
				$('#qip4').attr('readonly', false);
				$('#modibtn').text('수정완료');
			}else{
				var aa = $('#qttin').val();
				var dd = $('#qip4').val();
		
				$('#qttinn').val(aa);
				$('#qip7').val(dd);
				
				$('#modifrm').attr('action', '/pro/qna/mobtnProc.pro');
				$('#modifrm').submit();
				$('#modibtn').text('글수정');
			}
		
		});
	// 관리자 글 수정 기능처리
		$('#modibtnn').click(function(){
		var updown = $('#modibtnn').text();
			if(updown === '글수정'){
				$('#qttin0').attr('readonly', false);
				$('#qip0').attr('readonly', false);
				$('#modibtnn').text('수정완료');
			}else{
				var zz = $('#qttin0').val();
				var xx = $('#qip0').val();
				
				$('#qttinq').val(zz);
				$('#qipp').val(xx);
				
				$('#modifrm2').attr('action', 'pro/qna/mobtnnProc.pro');
			}
		});
	
		
	// 관리자 답변 등록버튼 기능처리
		$("#ansbtn").click(function(){
			alert('답변 쓰시오');
			$('#myModal').modal("toggle");
	});
	// 관리자 답변 디테일 기능처리?
		$('#Enrollment').click(function(){
			var dd = $('#qttin').val();
			alert(dd);
			var cc = $('#qorno4').val();
			alert(cc);
			var qq = $('#qno').val();
			alert(qq);
			var gg = $('#mem').val();
			alert(gg);
		$('#qtt').val(dd);
		$('#qip').val(cc);
		$('#qor').val(qq);
		$('#mem').val(gg);
		$('#menfrm').attr('action','/pro/qna/qnamnoProc.pro');
		$('#menfrm').submit();		
		});
		
		$('')
		
});