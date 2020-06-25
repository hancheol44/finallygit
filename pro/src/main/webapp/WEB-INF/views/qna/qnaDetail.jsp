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
 $(document).ready(function(){
	$('#modibtn').click(function(){
		alert('제 소원은 readonly 삭제입니다');
		$('#qttin').attr('readonly', false);
	});
 });
</script>
</head>
<jsp:include page="/head.pro" flush="true" />
<body>
<jsp:include page="/left.pro" flush="true" />
  <!-- 가운데 영역 (주내용 담길 곳) -->
  <div class="centercolumn w3-center">
    <div class="card">
      <h2>물어봥</h2>
		<form method="post" action="" id="delfrm">
			<input type="hidden" name="qno" id="qno" value="${qno}"/>
		</form>
		<table class="qnadetail">
							<tr>
								<td id="title">작성일</td>
								<td style="text-align: left;">&nbsp;${DETAIL.today}</td>
							</tr>
							<tr>
								<td id="title">작성자</td>
								<td style="text-align: left;">&nbsp;${DETAIL.name}</td>
							</tr>
							<tr>
								<td id="title">제 목</td>
								<td>
									<input id="qttin" type="text" value="${DETAIL.qtt}" readonly/>
								</td>
							</tr>
							<tr>
								<td id="title">내 용</td>
								<td>
									<textarea name="qip" cols="80" rows="8" id="qip4" readonly>${DETAIL.qip}</textarea>
								</td>
							</tr>
						<tr align="center" valign="middle">
						<!-- 버튼 조건 처리 -->
						<c:if test="${SID eq 'sej0267@naver.com'}">
							<td colspan="5">
								<c:if test="${SID eq DETAIL.memid}">
									<input type="submit" value="삭제" id="delbtn"> 
									<input type="reset" value="취소" id="wcbtn">
								</c:if>
								<c:if test="${SID ne DETAIL.memid}">
									<input type="submit" value="답변등록" id="ansbtn"> 
									<input type="submit" value="글삭제" id="delbtn"> 
									<input type="reset" value="취소" id="wcbtn">
								</c:if>
							</td>
						</c:if>
						<c:if test="${SID ne 'sej0267@naver.com'}">
							<c:if test="${SID eq DETAIL.memid}">
								<td colspan="5">
									<input type="submit" value="글수정" id="modibtn"> 
									<input type="reset" value="취소" id="wcbtn"> 
								</td>
							</c:if>
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