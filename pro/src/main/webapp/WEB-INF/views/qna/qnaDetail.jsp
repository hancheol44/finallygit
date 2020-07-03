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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script type="text/javascript" src="/pro/js/jquery-3.5.0.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<style>

</style>
<script type="text/javascript">

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
		<form method="post" action="" id="modifrm">
			<input type="hidden" name="qno" id="qno" value="${qno}"/>
			<input type="hidden" name="qtt" id="qttinn" value=""/>
			<input type="hidden" name="qip" id="qip7" value=""/>
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
									<button type="button" class="btn btn-info btn-md" id="ansbtn">답변등록</button>								
									<button class="bbtn" id="delbtn">글삭제</button>
									<button class="cbtn" id="wdbtn">취소</button>
								</c:if>
							</td>
						</c:if>
						<c:if test="${SID ne 'sej0267@naver.com'}">
							<c:if test="${SID eq DETAIL.memid}">
								<td colspan="5">
									<button type="button" id="ansbtn">답변등록</button>								
									<button class="obtn" id="modibtn" >글수정</button>
									<button class="pbtn" id="wcbtn">취소</button>
								</td>
							</c:if>
						</c:if>
					</tr>

			</table>
				
		 <div class="modal fade" id="myModal" role="dialog" style="margin-top : 600px;">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Modal Methods</h4>
        </div>
        <div class="modal-body">
          <p>The toggle method toggles the modal manually.</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      </div>
    </div>
  </div>
</div>
	
 
 <!-- 오른쪽 공간 태그 -->
<jsp:include page="/right.pro" flush="true" />
<!-- footer -->
<div class="footer">
	
</div>

<script type="text/javascript" src="/pro/js/qna.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</body>
</html>