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
<script type="text/javascript" src="/pro/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript" src="/pro/js/qna.js"></script>
<style>

</style>
<script type="text/javascript">
  
</script>
</head>
<jsp:include page="/head.pro" flush="true" />
<body>
  <jsp:include page="/left.pro" flush="true" />
  
  <!-- FORM 태그 작성공간 -->
		<form method="post" action="" id="frm">
			<input type="hidden" name="qtt" id="qtt" value=""/>
			<input type="hidden" name="qip" id="qip" value=""/>
		</form>
  <!-- FORM 태그 작성공간 -->
  
  <!-- 가운데 영역 (주내용 담길 곳) -->
  <div class="centercolumn w3-center">
    <div class="card">
      <h2>물어봥</h2>
		<table class="qnaWrite">
					<c:if test="${empty qno}">
						<tr>
							<td id="title">작성자</td>
							<td style="text-align: left;">${NAME}</td>
						</tr>
						<tr>
							<td id="title">제 목</td>
							<td>
								<input id="qttin" type="text" />
							</td>
						</tr>
						<tr>
							<td id="title">내 용</td>
							<td>
								<textarea name="qip" cols="72" rows="16" id="qip1"></textarea>
							</td>
						</tr>
					</c:if>
					<c:if test="${not empty qno}">
						
					</c:if>
						<tr align="center" valign="middle">
						<!-- 글 수정 작업시 아래 -->
						<c:if test="${not empty qno}">
							<td colspan="5">
								<input type="submit" value="글수정" id="modibtn"> 
								<input type="reset" value="취소" id="wcbtn"> 
							</td>
						</c:if>
						<!-- 글 작성 작업시 아래 -->
						<c:if test="${empty qno}">
						<td colspan="5">
								<input type="submit" value="등록" id="sbbtn"> 
								<input type="reset" value="취소" id="wcbtn"> 
							</td>
						</c:if>
						</tr>
			</table>
		</div>
			
    </div>
 
   <!-- 오른쪽 공간 태그 -->
<jsp:include page="/right.pro" flush="true" />

<!-- footer -->
<div class="footer">
	
</div>

</body>
</html>