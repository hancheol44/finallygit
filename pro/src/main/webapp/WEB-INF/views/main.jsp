<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title></title>
<link rel="stylesheet" href="/pro/css/w3.css" />
<link rel="stylesheet" href="/pro/css/main.css" />
<link rel="stylesheet" href="/pro/css/side.css" />
<script type="text/javascript" src="/pro/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript" src="/pro/js/main.js"></script>
<style>

</style>

</head>
<jsp:include page="/head.pro" flush="true" />
<body>

  <jsp:include page="/left.pro" flush="true" />
  
  <input type="hidden" id="mcnt" name="mcnt" value="${CNT.mcnt}" />
  <input type="hidden" id="pcnt" name="pcnt" value="${CNT.pcnt}" />
  <input type="hidden" id="visitor" name="vcnt" value="${LCNT}" />
  <!-- 가운데 영역 (주내용 담길 곳) -->
  <div class="centercolumn w3-center">
  		<div class="card" style="margin: 0; width: 100%; height: 40em; background-color: #ffffff;">
	      <h2>매장위치</h2>
		      <div id="map" style="width: 600px; height: 400px; margin:auto;"></div>
		</div>
		<div class="card" style="height: 40em;">
	      <h2>드루왕?!</h2><br>
	      <h4>'CODIV-19 Pandemic' 차를 활용한 거래의 시작과 끝, 사회적 거리두기 잘 지킵시당.</h4><br>
		      <div style="float: left; margin-left: 100px;">
		      <br><br>
		      <h3>카카오 지도를 통한 위치기반 시스템으로 </h3><br>
		      <h3>드라이브스루 시스템이 갖춰지지 않은 매장에</h3><br>
		      <h3>간편하게 드라이브스루 기능을 도입시키기 위한 플랫폼</h3>
		      </div>
		      <div>
		      	<img width="400" height="400" src="/pro/img/businessmodel.jpg" alt="Noimg" id="business"/>
		      </div>
		</div>	
  		<div class="card" style="height: 30em;">
	      <h2>서비스현황</h2>
		      <div style="float: left; margin-left: 15%;">
					<div>등록판매점</div>
					<div class="min">0</div>
		      </div>
		      <div style="float: left; margin-left: 15%;">
					<div>누적판매량</div>
					<div class="max">0</div>
		      </div>
		      <div style="float: left; margin-left: 15%;">
					<div>가입자수</div>
					<div class="member">0</div>
		      </div>
		      <div style="float: left; margin-left: 15%;">
					<div>누적방문자수</div>
					<div class="visitor">0</div>
		      </div>
		</div>
	<!-- 	<div class="cardm" style="width: 100%; height: 30em; background-color: #ffffff;">
	      <h2>구글차트API들어가요</h2>
		  <div id="curve_chart" style="width: 900px; height: 400px; margin:auto;"></div>
		</div> -->
		
   </div>
  
  <!-- 오른쪽 공간 태그 -->
<jsp:include page="/right.pro" flush="true" />

  

<!-- footer -->
<div class="footer">
	
</div>

</body>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
 <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=dd8f721c7ccf9b1ba7c336d64d77a8aa&libraries=services"></script>
	  <script type="text/javascript">
	  var mapContainer = document.getElementById('map');
		var mapOption = {
		    center: new kakao.maps.LatLng(37.503672, 126.999805), // 지도의 중심좌표
		    level: 11 // 지도의 확대 레벨
		}// 지도를 표시할 div 
		
		// 지도를 생성합니다    
		var map = new kakao.maps.Map(mapContainer, mapOption); 
		$.ajax({
			 url: '/pro/info/main_Addr.pro',
				type: 'post',
				dataType: 'json',
				success: function(obj){
				console.log(obj);
				// 주소-좌표 변환 객체를 생성합니다
				var geocoder = new kakao.maps.services.Geocoder();
				var imageSrc = "/pro/img/drive-thru.png";
				// 주소로 좌표를 검색합니다
				for(var i = 0 ; i < obj.length ; i++){
					let tmp = obj[i].bname;
					let str = '<div style="width:150px;text-align:center;padding:6px 0;">'+ tmp +'</div>';
					
					var imageSize = new kakao.maps.Size(25, 25); 	
					var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);
					geocoder.addressSearch(obj[i].bloc , function(result, status) {
					    // 정상적으로 검색이 완료됐으면 
					     if (status === kakao.maps.services.Status.OK) {
					    	 var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
					        
					        // 결과값으로 받은 위치를 마커로 표시합니다
					        var marker = new kakao.maps.Marker({
					            map: map,
					            position: coords,
					            image : markerImage
					        });
					        var infowindow = new kakao.maps.InfoWindow({
					            content : str
					        });
					        
					        kakao.maps.event.addListener(marker,'click', function(){
					        	alert('팝니당 페이지로 이동합니다');
								// 마커 위에 인포 윈도우를 표시합니다.
								location.replace('http://localhost/pro/sales/sales.pro');
							}); 
							
							 kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
						     kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
							// 인포윈도우를 표시하는 클로저를 만드는 함수입니다 
							function makeOverListener(map, marker, infowindow) {
							    return function() {
							        infowindow.open(map, marker);
							    };
							}
			
							// 인포윈도우를 닫는 클로저를 만드는 함수입니다 
							function makeOutListener(infowindow) {
							    return function() {
							        infowindow.close();
							    };
							} 
					     }
					});
				}
			},
			error: function(request, error){
			}
		 });
	  </script>
</html>