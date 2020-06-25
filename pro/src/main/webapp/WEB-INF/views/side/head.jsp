<!DOCTYPE html>
<html>
<title>CSS Template</title>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/pro/css/side.css">
<link rel="stylesheet" href="/pro/css/w3.css" />
<script type="text/javascript" src="/pro/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript">
// 카카오 로그아웃 처리 함수
function popup(){
     var url = "https://developers.kakao.com/logout";
     var name = "popuptest";
     var option = "width = 1, height = 1, top = 15000, left = 1, location = no, toolbar = no, statusbar=no, scrollbar=no"
     var popup = window.open(url, name, option);
   setTimeout(wer,600);        
   function wer(){
      popup.close();
        location.href='/pro/kakao/logout.pro';
   }
 }


$(document).ready(function(){
	var link = document.location.href;
	if(link.indexOf("board") != -1){
		$('#board').css('color','#04FBB5');
	}else if (link.indexOf("qna") != -1) {
		$('#qna').css('color','blue');
	}else if (link.indexOf("info") != -1) {
		$('#info').css('color','red');
	}else if (link.indexOf("sales") != -1) {
		$('#sales').css('color','orange');
	}
	$(".logo").hover(function(){
		$('#header').css('border-bottom','7px solid yellow');
		$('.flower').css('animation','flo.20s infinite ');
		$('.flower').css('visibility','visible');
		$('.logo').css('animation','log.5s infinite alternate');
		$('.logo').css('visibility','visible');
		$
	}, function() {
		$('#header').css('border-bottom','5px dashed yellow');
		$('.flower').css('animation','none');
		$('.flower').css('visibility','hidden');
		$('.logo').css('animation','none');
	});
	
	$('#hbtn').click(function(){
		location.href='/pro/main.pro';
	});

});

</script>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>



	<header id="header">
		<div class="inner">
			<div style="width: 10em">
				<input class="flower" id="f1"
					style="margin-left: -9em; height: 7em; width: auto; position: absolute;"
					type="image" src="/pro/img/flower.png"> <input
					class="flower" id="f2"
					style="margin-left: -15em; height: 7em; width: auto; position: absolute;"
					type="image" src="/pro/img/flower.png"> <input
					class="flower" id="f3"
					style="height: 7em; width: auto; position: absolute;" type="image"
					src="/pro/img/flower.png"> <input class="logo" id="hbtn"
					type="image" src="/pro/img/main.png">
			</div>
			<!-- 
					<nav id="nav">
						<a href="">팝니당</a>
						<a href="">놀러왕</a>
						<a href="">물어봥</a>
						<a href="">오세용</a>
						<a href="">로그인</a>
					</nav>
					 -->
			<ul>
				<li><a href="#home">드루왕</a></li>
				<li><a id="sales" href="/pro/sales/sales.pro">팝니당</a></li>
				<li class="dropdown"><a href="javascript:void(0)"
					class="dropbtn"id="info" >오세용</a>
					<div class="dropdown-content">
						<a href="/pro/info/infoCT.pro"><h6>자동차 극장</h6></a> <a
							style="margin-left: -40px;" href="/pro/info/infoAC.pro"><h6>자동차
								캠핑</h6></a> <a style="margin-left: -40px;" href="/pro/info/infoDT.pro"><h6>승차
								검진소</h6></a>
					</div></li>
				<li><a id="qna" href="/pro/qna/qnaList.pro">물어봥</a></li>
				<li><a id="board" href="/pro/board/board.pro">놀러왕</a></li>
				<c:if test="${empty SID && empty userId}">
					<li><a href="/pro/login/loginList.pro">로그인</a></li>
				</c:if>
				<c:if test="${not empty SID && empty userId}">
					<li><a href="/pro/login/logout.pro">로그아웃</a></li>
				</c:if>
				<c:if test="${empty SID && not empty userId}">
					<li><a href="javascript:popup()">로그아웃</a>
				</c:if>

			</ul>
		</div>
	</header>
</body>
</html>
