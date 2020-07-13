<!DOCTYPE html>
<html>
<title>CSS Template</title>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/pro/css/side.css">
<link rel="stylesheet" href="/pro/css/w3.css" />
<script type="text/javascript" src="/pro/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		starList();
		$(".logo").hover(function(){
			$('#header').css('border-bottom','7px solid yellow');
		}, function() {
			$('#header').css('border-bottom','5px dashed yellow');
		});
	});
	function starList(){
		$.ajax({
			url: '/pro/board/starRanking.pro',
			type: 'post',
			dataType: 'json',
			success: function(obj){
				var len = obj.length;
				for(var i = 0; i < len; i++){
					$('#starList').append('<div class="w3-left starList">'+
							'<div id = "1st">'+obj[i].bname+'</div>'+
							'<c:if test="${'+obj[i].rst+' == "5"}"><div id = "2ed">★★★★★</div> </c:if>'+
							'<c:if test="${'+obj[i].rst+' == "4"}"><div id = "2ed">★★★★</div> </c:if>'+
							'<c:if test="${'+obj[i].rst+' == "3"}"><div id = "2ed">★★★ </div></c:if>'+
							'<c:if test="${'+obj[i].rst+' == "2"}"><div id = "2ed">★★ </div></c:if>'+
							'<c:if test="${'+obj[i].rst+' == "1"}"><div id = "2ed">★ </div></c:if>'+
							'</div>')		
				}
			},
			error: function(request,status,error){
				alert("### 리스트 뽑기 통신에러 ###");
				alert("code:"+request.status+"\n"+"\n"+"error:"+error);

			}
		});
	};
</script>

<head>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
</head>
<body>
  <!-- 왼쪽 영역 태그 -->
  
  <div class="leftcolumn" style="width: 15%">
  	<div style="margin-top: 2em; text-align: center; font-size: 30px; font-style:고딕; font-weight: bold; text-shadow: 3px 3px 2px gray; ">별점 순위</div>
    <div id = "starList">
  		
  </div>

        




  </div>
</body>
</html>
