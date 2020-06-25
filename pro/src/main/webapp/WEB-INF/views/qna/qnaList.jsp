<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title></title>
<link rel="stylesheet" href="/pro/css/w3.css" />
<link rel="stylesheet" href="/pro/css/qna.css" />
<link rel="stylesheet" href="/pro/css/side.css" />
<style>

</style>
<script type="text/javascript">
  
</script>
</head>
<jsp:include page="/head.pro" flush="true" />
<body>
<jsp:include page="/left.pro" flush="true" />
<!-- Form태그 작성 -->

<!-- 1. Detail 데이터 전담 Form -->
<form method="GET" action="" id="DetailFrm">
	<input type="hidden" name="qno"id="qno"/>
</form>
  
<!-- Form태그 작성 -->

  <!-- 가운데 영역 (주내용 담길 곳) -->
  <div class="centercolumn w3-center">
    <div class="card">
      <h2>물어봥</h2>
			<table id="customers">
			  <tr>
			    <th style="width: 100px;">글번호</th>
			    <th>제목</th>
			    <th style="width: 100px;">작성자</th>
			    <th style="width: 150px;">작성일</th>
			    <th style="width: 100px;">답변상태</th>
			  </tr>
			  <c:forEach var="data" items="${LIST}">
			  <tr id="${data.qno}">
			  	<td class="qlist">${data.qno}</td>
			  	<td>${data.qtt}</td>
			  	<td>${data.name}</td>
			  	<td>${data.today}</td>
			  	<td></td>
			  </tr>
			  </c:forEach>
			</table>
			
			<!-- 페이징 처리 부분 -->
			<div class="w3-center">
				<div class="w3-bar w3-border">
					<c:if test="${PAGE.startPage lt (PAGE.pageGroup + 1) }">
						<span class="w3-bar-item w3-light-gray">PRE</span>
					</c:if>
					<c:if test="${PAGE.startPage ge (PAGE.pageGroup + 1) }">
						<span class="w3-bar-item pgbt w3-button w3-hover-blue pbtn"
							id="${PAGE.preNo}">PRE</span>
					</c:if>
					<c:forEach var="pageNo" begin="${PAGE.startPage}"
						end="${PAGE.endPage}">
						<span
							class="w3-bar-item pgbt w3-border-left w3-button w3-hover-blue pbtn">${pageNo}</span>
					</c:forEach>
					<c:if test="${PAGE.endPage ne PAGE.totalPage}">
						<span
							class="w3-bar-item pgbt w3-border-left w3-button w3-hover-blue pbtn"
							id="${PAGE.nextNo}">NEXT</span>
					</c:if>
					<c:if test="${PAGE.endPage eq PAGE.totalPage}">
						<span class="w3-bar-item  w3-border-left w3-light-gray ">NEXT</span>
					</c:if>
				</div>
				<!-- 페이징 처리 부분 끝 -->
				

				<div style="width: 100%;" class="w3-center" id="searchForm">
					<form method="post" action="" id="search">
						<select name="condition" style="margin: 10px; height: 28px;">
							<option value="bdtt">제목</option>
							<option value="bdbd">내용</option>
							<option value="name">글쓴이</option>
						</select> 
						<input type="text" size="20" name="input" style="margin: 10px;" />
						<input id="serbtn" type="submit" value="search" style="margin: 10px;" />
						<c:if test="${not empty SID}">
							<input style="float: right; margin: 10px 65px 10px -100px;" type="button" value="글쓰기" id="qwbtn">
						</c:if>
					</form>
				</div>
			</div>
    </div>
  </div>
  
  <!-- 오른쪽 공간 태그 -->
<jsp:include page="/right.pro" flush="true" />
<!-- footer -->
<div class="footer">
	
</div>

</body>
<script type="text/javascript" src="/pro/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript" src="/pro/js/qna.js"></script>
</html>