<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<head>
</head>
<body>
  <!-- 오른쪽 공간 태그 -->
  <div class="rightcolumn" style="width: 15%">
    <div class="card">
        <div id="prochart" style="width: 100%; height: 380px;"></div>
	</div>
    <div class="card">
        <div id="infochart" style="width: 100%; height: 380px;"></div>
    </div>
  </div>
</body>
 <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawVisualization);

      function drawVisualization() {
    	  
    	  var arr = new Array();
          var arr2 = new Array();
          <c:forEach var="pro" items="${PROMO}" varStatus="st">
          	arr[${st.index}] = '${pro.bname}';
          	arr2[${st.index}] = ${pro.lcnt};
          </c:forEach>
    	  
	    
        var prodata = google.visualization.arrayToDataTable([
          ['Month', 'like', { role: 'style' } ],
          [arr[0],  arr2[0], "gold"],
          [arr[1],  arr2[1], "#ff7f50"],
          [arr[2],  arr2[2], "color: #db7093"],
          [arr[3],  arr2[3], "color: #6495ed"],
          [arr[4],  arr2[4], "color: #dc143c"]
        ]);
        
        var prooptions = {
          title : '팝니당 TOP 5 (좋아요기준)',
          hAxis: {title: '상호명'},
          seriesType: 'bars',
          series: {5: {type: 'line'}} };
        
        
        var arr3 = new Array();
        var arr4 = new Array();
        <c:forEach var="info" items="${INFO}" varStatus="st">
        	arr3[${st.index}] = '${info.ifname}';
        	arr4[${st.index}] = ${info.iflike};
        </c:forEach>
        
	        
        var infodata = google.visualization.arrayToDataTable([
          ['Month', 'like', { role: 'style' } ],
          [arr3[0],  arr4[0], "gold"],
          [arr3[1],  arr4[1], "#ff7f50"],
          [arr3[2],  arr4[2], "color: #db7093"],
          [arr3[3],  arr4[3], "color: #6495ed"],
          [arr3[4],  arr4[4], "color: #dc143c"]
        ]);

        var infooptions = {
          title : '오세용 TOP 5 (좋아요기준)',
          hAxis: {title: '상호명'},
          seriesType: 'bars',
          series: {5: {type: 'line'}}  };

        var chart = new google.visualization.ComboChart(document.getElementById('prochart'));
        chart.draw(prodata, prooptions);
        
        var chart = new google.visualization.ComboChart(document.getElementById('infochart'));
        chart.draw(infodata, infooptions);
      }
    </script>
</html>
