$(document).ready(function(){
	$('.detail_card').css('display', 'none');
	$('#reviewWrite').css('display', 'none');
	
	// 리뷰 보기 
	$('#reviewbt').click(function(){
		var updown = $('#reviewbt').text();
		alert(updown);
		if(updown === '리뷰'){
			$('#reviewWrite').css('display', '');
			$('#reviewbt').text('닫기');
		} else {
			$('#reviewWrite').css('display', 'none');
			$('#reviewbt').text('리뷰');
		}
	});
	
	// 자동차캠핑 상세보기
	$('td').click(function(){
		var str = $(this).text();
		var val = $(this).attr('id');
		alert(str);
		alert(val);
		$('.detail_card').css('display', '');
	})
});