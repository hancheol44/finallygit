$(document).ready(function() {
	// 글쓰기 이동
	$('.btct').click(function() {
		var bct = $(this).html();
		$('#bdct').val(bct);
		$('#ct').attr('action', '/pro/board/board.pro');
		$('#ct').submit();
		
		
	});
	$('#search').click(function() {
		$('#searchForm').attr('action','/pro/board/search.pro');
		$('#searchForm').submit();
		
	});
	$('#write').click(function() {
		$(location).attr('href', '/pro/board/boardWrite.pro');
	});

	$('.content').click(function() {
		// 할일
		// 글 번호 알아낸다.
		var sno = $(this).attr('id');
		alert(typeof sno);
		$('#dbdno').val(sno);
//		$('#nowPage').val('${PAGE.nowPage}');
		$('#dfrm').attr('action', '/pro/board/boardDetail.pro');
		$('#dfrm').submit();
	});
	
	$('.editdetail').click(function() {
		var no = $('#bno').html();
		$('#bdno').val(no);
		$('#efrm').attr('action', '/pro/board/boardEdit.pro');
		$('#efrm').submit();
	});
	
	$('.delete').click(function() {
		var bno = $('#bno').html();
		$('#bdno').val(bno);
		$('#efrm').attr('action', '/pro/board/boardDelete.pro');
		$('#efrm').submit();
	});
	
	
	$('#wbtn').click(function() {
		$('#wfrm').attr('action', '/pro/board/boardWriteProc.pro');
		$('#wfrm').submit();
	});
	$('#edbtn').click(function() {
		$('#efrm').attr('action', '/pro/board/boardEditProc.pro');
		$('#efrm').submit();
	});

	$('#ebtn').click(function() {
		$('#bno').attr('action', '/pro/board/boardEditProc.pro');
		$('#bno').submit();
	});
	
	$('.deletedetail').click(function() {
		$('#wfrm').attr('action', '/pro/board/boardEditProc.pro');
		$('#wfrm').submit();
	});
	
	
});