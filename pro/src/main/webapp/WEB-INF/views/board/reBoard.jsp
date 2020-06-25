<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>

<html>
<head>
<meta charset="utf-8" />
<title>댓글</title>
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

<body>
	<div class="rtt">
		<div class="w3-center w3-green ">댓글 영역</div>
			
			<c:forEach var="data" items="${LIST}">
			<div class="w3-left reBoard ">
			<div>${data.name}</div>
			<div>${data.bdbd}</div>
			<div>${data.today}</div>
			
			</div>
		</c:forEach>
	</div>
</body>
</html>