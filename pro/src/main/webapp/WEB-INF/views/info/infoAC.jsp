<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title></title>
<link rel="stylesheet" href="/pro/css/w3.css" />
<link rel="stylesheet" href="/pro/css/info.css" />
<link rel="stylesheet" href="/pro/css/side.css" />
<script type="text/javascript" src="/pro/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript" src="/pro/js/info.js"></script>
<style>

</style>
<script type="text/javascript">

</script>
</head>
<jsp:include page="/head.pro" flush="true" />
<body>
<jsp:include page="/left.pro" flush="true" />
  
  <!-- 가운데 영역 (주내용 담길 곳) -->
  <div class="centercolumn w3-center">
    <div class="card">
      <h1>자동차 캠핑</h1>
      <!-- 자동차 캠핑 리스트 위치 -->
      <div id="List">
		<table class="cp" id="autoCP">
			  <tr>
			    <th style="width: 300px;"><h2>자동차 캠핑 List</h2></th>
			  </tr>
			  <c:forEach var="data" items="${LIST}">
				  <tr>
				  	<td id="${data.ifno}">${data.ifname}</td>
				  </tr>
			  </c:forEach>
		</table>
      </div>
	  <div id="map"></div>
	  <div class='w3-row'><p></p></div>
	  <div class="detail_card">
	  	<div class="detail">
			<span> 캠핑장 이름 : </span> <span id="acname"></span><br><br>
			<span> 연락처 : </span> <span id="actel"></span><br><br>
			<span> 주소 : </span> <span id="acaddr"></span><br><br>
			<span> 이용가격 : </span> <span id="acpri"></span><br><br>
			<span> 홈페이지 : </span> <a id="hplink" href="" target="_blank"><span id="ctlink">링크</span></a><br><br>
			<span> 길찾기 바로가기 : </span> <a id="search" href="" target="_blank"><span id="ctlink">링크</span></a><br><br>
		</div>
	  	<div class="mgbottom">
		  	<div style="float: left;">평점 : </div>
		  	<div style="color: orange;">★데이터</div>
	  	</div>
	  	<button class="rebtn" id="reviewbt" >리뷰</button>
	  	<div id="reviewWrite">
   		<br><br>
        <div>
            <div>
                <span><h4><strong>리뷰</strong></h4></span>
            </div>
            <div>
                <div>                    
                    <div>
                        <div id="rWrite">
                        	 <div id="rst"><h6><b>평점</b></h6>
								<select id="rstSelect" name="rst">
									<option value="5">★★★★★
									<option value="4">★★★★
									<option value="3">★★★
									<option value="2">★★
									<option value="1">★
								</select>
								<br>
							</div>
	                            <textarea id="rett" placeholder="리뷰제목을 입력해주세요."></textarea>
	                            <textarea id="rebd" placeholder="리뷰내용을 입력해주세요."></textarea>
                            <br>
                                <button id="">등록</button>
                               </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
	  </div>
	  
      <!-- 자동차 캠핑 리스트 위치 끝 -->
	  <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=dd8f721c7ccf9b1ba7c336d64d77a8aa&libraries=services"></script>
	  <script>
	  	var container = document.getElementById('map');
	  	var options = {
			center: new kakao.maps.LatLng(33.450701, 126.5706670),
			level: 3
	  	};
	  	
	  	var map = new kakao.maps.Map(container, options);
	  </script>
    </div>
  </div>
  
<jsp:include page="/right.pro" flush="true" />

<!-- footer -->
<div class="footer">
	
</div>

</body>
<script type="text/javascript" src="/pro/js/info_ajax.js"></script>
</html>