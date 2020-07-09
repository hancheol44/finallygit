<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<!--
   Editorial by HTML5 UP
   html5up.net | @ajlkn
   Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
<head>
<!-- 풀커밋 테스트 -->
<meta charset="utf-8" />
<title>메인페이지</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />

<link rel="stylesheet" href="/pro/css/board.css" />
<link rel="stylesheet" href="/pro/css/side.css">
<link rel="stylesheet" href="/pro/css/common.css">
<link rel="stylesheet" href="/pro/css/w3.css" />
<script type="text/javascript" src="/pro/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript" src="/pro/js/board.js"></script>
<script type="text/javascript">

</script>

</head>

<jsp:include page="/head.pro" flush="true" />
<body>
	<jsp:include page="/left.pro" flush="true" />

	<form action="POST" id="dfrm">
		<input type="hidden" name="bdno" id="dbdno">
	</form>
	<form action="POST" id="cfrm">
		<input type="hidden" name="bdno" id="bdno">
	</form>
	<form action="POST" id="ct">
		<input type="hidden" name="bdct" id="bdct">
	</form>

	<div class="hmt centercolumn">
		<div>
			<br>
			<div id="topForm">
				<div style="font-size: x-large;" class="w3-center w3-text-red">자유게시판</div>
				<br>
				<c:if test="${sessionScope.sessionID!=null}">
				</c:if>

			</div>
			<div id="frbd">
				<button onclick="location.href='/pro/board/board.pro'">전체</button>
				<button class="btct">공지</button>
				<button class="btct">팁</button>
				<button class="btct">이벤트</button>
				<c:if test="${SID != null}">
					<button id="write">글쓰기</button>
				</c:if>

			</div>
			<div>
				<table id="customers">
					<thred>

					<tr heigh="30">
						<th>글번호</th>
						<th>종류</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회수</th>
					</tr>
					</thred>
					<c:forEach var="data" items="${LIST}">
						<tr class="w3-text-gray cnt content" id="${data.bdno}">
							<td>${data.bdno}</td>
							<td>${data.bdct}</td>
							<td>${data.bdtt} <c:if test="${data.ccnt !=0}"><a style="color: purple; font-weight: bolder; text-shadow: black;">&nbsp(${data.ccnt})</a></c:if></td>
							<td>${data.name}</td>
							<td>${data.today}</td>
							<td>${data.vcnt}</td>
						</tr>
					</c:forEach>
				</table>
				<br>
			</div>
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
				<form id="searchForm" method="POST" >
					<select style="width:7em;" name="type">
						<option value="bdtt">제목</option>
						<option value="bdbd">내용</option>
						<option value="name">글쓴이</option>
					</select> 
					<input style="width: 30%  type="text" size="20" name="input"/>
					<button style="width: 7em;" id="search" name="search">검색</button>
				</form>
			</div>

			</div>
	</div>
	<jsp:include page="/right.pro" flush="true" />
</body>
</html>