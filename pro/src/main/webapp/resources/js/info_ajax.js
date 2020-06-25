$(document).ready(function(){
	
	// 자동차캠핑 상세보기 ajax
	$('td').click(function(){
		alert('비동기');
		var ifno = $(this).attr('id');
		$.ajax({
			url: '/pro/info/'
		});
	});
});