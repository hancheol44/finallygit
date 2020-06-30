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
		$(".logo").hover(function(){
			$('#header').css('border-bottom','7px solid yellow');
		}, function() {
			$('#header').css('border-bottom','5px dashed yellow');
		});
	});
</script>
<script type="text/javascript">

    document.addEventListener("DOMContentLoaded", function() {



        // 시간을 딜레이 없이 나타내기위한 선 실행

        realTimer();



        // 이후 0.5초에 한번씩 시간을 갱신한다.

        setInterval(realTimer, 500);

    });



    // 시간을 출력

    function realTimer() {

		const nowDate = new Date();

		const year = nowDate.getFullYear();

		const month= nowDate.getMonth() + 1;

		const date = nowDate.getDate();

		const hour = nowDate.getHours();

		const min = nowDate.getMinutes();

		const sec = nowDate.getSeconds();

		document.getElementById("nowTimes").innerHTML = 

                  year + "-" + addzero(month) + "-" + addzero(date) + "&nbsp;" + hour + ":" + addzero(min) + ":" + addzero(sec);

	}



        // 1자리수의 숫자인 경우 앞에 0을 붙여준다.

	function addzero(num) {

		if(num < 10) { num = "0" + num; }

 		return num;

	}

</script>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
</head>
<body>
  <!-- 왼쪽 영역 태그 -->
  <div class="leftcolumn" style="width: 15%">
    <div class="card">
      <h2>About Me</h2>
      <div class="fakeimg" style="height:100px;">Image</div>
      <p>Some text about me in culpa qui officia deserunt mollit anim..</p>
        <h1>■ 현재시간 : <span id="nowTimes"></span></h1>
    </div>
    <div class="card">
      <h3>Popular Post</h3>
      <div class="fakeimg"><p>Image</p></div>
      <div class="fakeimg"><p>Image</p></div>
      <div class="fakeimg"><p>Image</p></div>
    </div>
  </div>
</body>
</html>
