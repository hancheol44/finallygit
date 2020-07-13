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
	      var x = new Array();
	      var y = new Array();
	      x = ${LIKE};
	      y = '${NAME}';
	      var plike = x;
	      var a = y.replace('[',' ');
	      var b = a.replace(']',' ');
	      var pname = b.split(',');
	     
	      
        // Some raw data (not necessarily accurate)
        var prodata = google.visualization.arrayToDataTable([
          ['Month', 'like', { role: 'style' } ],
          [pname[0],  plike[0], "gold"],
          [pname[1],  plike[1], "#ff7f50"],
          [pname[2],  plike[2], "color: #db7093"],
          [pname[3],  plike[3], "color: #6495ed"],
          [pname[4],  plike[4], "color: #dc143c"]
        ]);
        
        var prooptions = {
          title : '팝니당 TOP 5 (좋아요기준)',
       // vAxis: {title: 'Cups'},
          hAxis: {title: '상호명'},
          seriesType: 'bars',
          series: {5: {type: 'line'}} };
        
        
        
        var q = new Array();
	      var w = new Array();
	      q = ${ILIKE};
	      w = '${INAME}';
	      var ilike = q;
	      var a = w.replace('[',' ');
	      var b = a.replace(']',' ');
	      var iname = b.split(',');
        
        var infodata = google.visualization.arrayToDataTable([
          ['Month', 'like', { role: 'style' } ],
          [iname[0],  ilike[0], "gold"],
          [iname[1],  ilike[1], "#ff7f50"],
          [iname[2],  ilike[2], "color: #db7093"],
          [iname[3],  ilike[3], "color: #6495ed"],
          [iname[4],  ilike[4], "color: #dc143c"]
        ]);

        var infooptions = {
          title : '오세용 TOP 5 (좋아요기준)',
       // vAxis: {title: 'Cups'},
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
