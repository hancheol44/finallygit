
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>

<html>
<head>
<meta charset="utf-8" />
<title>자유게시판</title>

<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />

<link rel="stylesheet" href="/pro/css/head.css">
<link rel="stylesheet" href="/pro/css/w3.css" />
<link rel="stylesheet" href="/pro/css/board.css" />
<script type="text/javascript" src="/pro/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript" src="/pro/js/board_ajax.js"></script>
<script type="text/javascript" src="/pro/js/board.js"></script>
<script type="text/javascript">
	
</script>

</head>
<jsp:include page="/head.pro" flush="true" />
<body>
	<jsp:include page="/left.pro" flush="true" />
	<jsp:include page="/right.pro" flush="true" />
	<div>
		<p></p>
	</div>
	<form id="efrm" method="GET">
		<input type="hidden" id="bdno" name="bdno">
		<div class="hmt centercolumn" id="board">
			<table id="detailBoard" width="50%" border="3" bordercolor="black">

				<tr>
					<td class="title">글 번호</td>
					<td id="bno">${DATA.bdno}</td>
					<td class="title">작성일</td>
					<td>${DATA.today}</td>
					<td class="title">작성자</td>
					<td>${DATA.name}</td>
					<td class="title">조회수</td>
					<td>${DATA.vcnt+1}</td>
				</tr>
			</table>
			<table>
				<tr>
					<td class="title">제 목</td>
				</tr>
				<tr>
					<td id="bdtt" name="bdtt">${DATA.bdtt}</td>
				</tr>
				<tr>
					<td class="title">내 용</td>
				</tr>
				<tr>
					<td id="bdbd" name="bdbd">${DATA.bdbd}</td>
				</tr>
			</table>


			<tr align="center" valign="middle">
				<td colspan="5"><c:if test="${SID eq DATA.memid}">
						<button class="editdetail">수정</button></c:if>
						<img id = "like" alt="" src="/pro/img/icons8-good-quality-64 default.png">
						<c:if test="${SID eq DATA.memid}">
						<button class="delete">삭제</button>
						</c:if>
					</td>
			</tr>
			</table>
	</form>
		<div class="rtt">
	<form id="cfrm">
			<input type="hidden" id="borino" name="borino" value="${DATA.bdno}">
			<textarea id="cbd" name="bdbd" style="width: 100%" rows="3" cols="50"></textarea>
	</form>
			<button id="comment" style="height: 3em">댓글</button>
		</div>
	<div class="rtt">
		<div class="w3-center w3-green ">댓글 영역</div>
		<div id ="newList">
		</div>
		<div id ="reviewList">
		</div>
		
	</div>

</body>


</html>