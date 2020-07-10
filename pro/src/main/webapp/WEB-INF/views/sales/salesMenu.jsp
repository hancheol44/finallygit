<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title></title>
<link rel="stylesheet" href="/pro/css/w3.css" />
<link rel="stylesheet" href="/pro/css/sales.css" />
<link rel="stylesheet" href="/pro/css/side.css" />
<script type="text/javascript" src="/pro/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript" src="/pro/js/sales.js"></script>
<!-- <script type="text/javascript" src="/pro/js/sales_pay.js"></script> -->
<style>

</style>
</head>
<jsp:include page="/head.pro" flush="true" />
<body>
<jsp:include page="/left.pro" flush="true" />

<div class="centercolumn" >
 <!-- 가운데 영역 (주내용 담길 곳) -->
 <form method="post" action="" id="ckfrm">
	 <input type="hidden" id="memid" name="memid">
	 <input type="hidden" id="pno" name="pno">
	 <input type="hidden" id="mno" name="mno">
 </form>
	<table id="menuList">
				<tr>
					<th id="sid" value="${SID}"></th>
					<th id="mmenu">메뉴</th>
					<th id="mprice">가격</th>
				<c:forEach var="data" items="${LIST}">
				 <input type="hidden" id="mpno" value="${data.pno}">
					<tr class="meList" id="meList" value="${data.mno}">
					  	<td><input type="radio" name="menuCk" id="menuCk" value="${data.mno}" class="${data.mprice}"></td>
					  	<td>${data.mname}</td>
					  	<td>${data.mprice}</td>
				  </tr>
			  </c:forEach>
		  </table>
		  <div>
			  <h4>
				  <button id="menuOK" class="menuOK">주문</button>
			  </h4>
		  </div>
<div style="height: 30px;"> </div>

<jsp:include page="/right.pro" flush="true" />
<!-- footer -->
<div class="footer">
	
</div>

</body>
</html>