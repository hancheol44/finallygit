<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html class="wbc">
<head>
<meta charset="EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/pro/css/welcome.css">
<script type="text/javascript" src="/pro/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		
	$(".drw").click(function () {
			$(".drw").css('transform','rotate(10deg)')
			$(".drw").css('animation','go 3s')
			
			/* $("#r").css('display','')
			$("#w").css('display','') */
			setTimeout(function () {
				$('#d').css('visibility','visible');
			}, 500);
			setTimeout(function () {
				$('#r').css('visibility','visible');
			}, 1000);
			setTimeout(function () {
				$('#w').css('visibility','visible');
			}, 1500);
			setTimeout(function () {
				$('.drw').css('visibility','hidden');
			}, 2000);
			setTimeout(function () {
				$('span').css('visibility','hidden');
			}, 2500);
			setTimeout(function () {
				$('.car').css('animation','come 2s');
			}, 2500);
			setTimeout(function () {
				$(location).attr('href','/pro/board/board.pro');
			}, 3000);
			
		});
	});
</script>
<title>드루와</title>
<style>
</style>
</head>

<body>
	<div class="title">
	<span id="d">드 </span><span id="r">루 </span><span id="w">와 </span>
	</div>
	<img class="car" src="/pro/img/car.png">
	<img class="drw" src="/pro/img/main.png">
	
</body>
</html>