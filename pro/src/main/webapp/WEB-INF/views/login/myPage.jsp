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
<link rel="stylesheet" href="/pro/css/sales.css" />
<script type="text/javascript" src="/pro/js/jquery-3.5.0.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script type="text/javascript" src="/pro/js/qna.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
	$("#btn1").click(function(){
		$('#msform').attr('method', 'POST');
        $('#msform').attr('action', '/pro/kakao/eidtInfoProc.pro');
        $('#msform').submit();
	});
	$("#btn4").click(function(){
		$('#msform').attr('method', 'POST');
        $('#msform').attr('action', '/pro/kakao/busiInfoProc.pro');
        $('#msform').submit();
	});
	
});
	
</script>
<style>
.big {
	background-color: #2E2E2E;
    cursor: default;
    height: 5em;
    left: 0;
    line-height: 5em;
    position: fixed;
    text-align: right;
    top: 0;
    width: 100%;
    z-index: 10001;
}

#lnb_area {
    height: 39px;
    margin-top: -1px;
    border-top: 1px solid #00af35;
    border-bottom: 1px solid #e5e5e5;
    background-color: #fff;
}

#wrap {
    position: relative;
    min-width: 700px;
    height: 100%;
    padding-bottom: 30px;
}

#content.section_home {
    line-height: 14px;
    zoom: 1;
    padding: 16px 280px 94px;
}

.section_home .column {
    float: left;
    width: 50%;
}

.sh_group {
    min-height: 214px;
}
.sh_group, .sh_group2, .sh_group3, .sh_group4 {
    margin: 16px 8px 0;
    padding: 32px 29px 30px;
    text-align: left;
    border: 1px solid #dadada;
    -webkit-border-radius: 2px;
    border-radius: 2px;
    background: #fff;
}

.section_home h2 {
    font-size: 20px;
    line-height: 22px;
    padding-bottom: 12px;
    color: #333;
}

.sh_header {
    position: relative;
}

.section_home .btn_area_btm {
    font-size: 0;
    padding: 17px 0 0 1px;
}


.sh_content {
    /* min-height: 131px; */
    padding-top: 9px;
}

.btn_model {
    font-size: 12px;
    line-height: 14px;
    display: inline-block;
    vertical-align: top;
    text-decoration: none!important;
}

.btn_model .btn1, .btn_model .btn2, .btn_model .btn3 {
    min-width: 52px;
    height: 21px;
    padding: 10px 12px 0;
    color: #a3a3a3;
}

.pro {
	padding-bottom: 10px;
	border-bottom: 2px solid gray;
	border-top: 2px solid gray;
	margin-top: 25px;
}
</style>

</head>
<jsp:include page="/head.pro" flush="true" />
<body>

  <!-- 가운데 영역 (주내용 담길 곳) -->
  <form class="msform" id="msform" name="msform">
  <div class="centercolumn w3-center">
    <div id="lnb_area">
      <h5 style="margin-left: -880px;">회원정보</h5>
	</div>
    <div id="content" class="section_home">
    <div class="column">
    	<div class="sh_group">
    		<div class="sh_header">
    			<h2> 프로필 정보 </h2>
    			<div class="sh-content">
    				<h2> 이메일,핸드폰번호,닉네임</h2>
    			</div>
    		</div>
    		<div class="w3-container">
			  <button onclick="document.getElementById('id01').style.display='inline'" type="button" class="w3-button w3-green"  style="width: 60px; height: 40px; margin-top: 30px;" id="btn2">수정</button>
			  
			
			  <div id="id01" class="w3-modal">
			    <div class="w3-modal-content" style="width:500px; height:400px; margin-top: 200px;">
			      <div class="w3-container">
						  <div class="pro w3-center">
							<h4>회원 정보</h4>
						</div>
			        <span onclick="document.getElementById('id01').style.display='none'" class="w3-button w3-display-topright">&times;</span>
			          <div class="w3-row" style="margin-top: 30px;">
			      		<p style="display:inline; font-size: 20px;"> 이메일  : &nbsp; </p><input type="text" style="width: 370px; height:40px;" name="memid" id="memid" value="${LIST[0].memid}" />
			          </div>
			          <div class="w3-row" style="margin-top: 30px;">
			      		<p style="display:inline; font-size: 20px;"> 핸드폰  : &nbsp; </p><input type="text" style="width: 370px; height:40px;" name="phone" id="phone" value="${LIST[0].phone}" />
			          </div>
			          <div class="w3-row" style="margin-top: 30px;">
			      		<p style="display:inline; font-size: 20px;"> 닉네임  : &nbsp; </p><input type="text" style="width: 370px; height:40px;" name="name" id="name" value="${LIST[0].name}" />
			          </div>
			        <button type="submit" class="w3-button w3-center w3-green" style="width: 60px; height: 40px; margin-top: 37px; margin-left: 218px;" id="btn1">완료</button>
			      </div>
			    </div>
			  </div>
			</div>
    		</div>
    		
    	<div class="sh_group">
    		<div class="sh_header">
    			<h2> 내 게시글 좋아요 </h2>
    			<div class="sh-content">
    				<h2> 팝니다,물어봥,놀러왕</h2>
    			</div>
    		</div>
    		<div class="w3-container">
			  <button onclick="document.getElementById('id03').style.display='inline'" type="button" class="w3-button w3-green"  style="width: 60px; height: 40px; margin-top: 30px;" id="btn5">보기</button>
			  
			
			  <div id="id03" class="w3-modal">
			    <div class="w3-modal-content" style="width:1000px; height:600px; margin-top: 50px;">
			      <div class="w3-container">
						  <div class="pro w3-center">
							<h4>게시글 정보</h4>
						</div>
			        <span onclick="document.getElementById('id03').style.display='none'" class="w3-button w3-display-topright">&times;</span>
						    <div class="" style="background-color: white; padding: 20px; margin-top: 20px; margin-left: -16px; width: 1000px;">
						      <div>
							  </div>
									<table id="saList">
									  <tr>
									  	<th id="pno">no</th>
									    <th id="ptt">제목</th>
									    <th id="name">작성자</th>
									    <th id="today">작성일</th>
									    <th id="lcnt">좋아요</th>
									  </tr>
									  <c:forEach var="data" items="${SAL}">
										  <tr class="salesList" id="${data.pno}" value="${data.memid}">
										  	<td>${data.pno}</td>
										  	<td>${data.ptt}</td>
										  	<td>${data.name}</td>
										  	<td>${data.today}</td>
										  	<td>${data.lcnt}</td>
										  </tr>
									  <div id="sales_memid" value="${data.memid}"></div>
									  </c:forEach>
									</table>
									
									
									<!-- 페이징 처리 부분 -->
									<div class="w3-center" style="margin-top: 5px;">
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
										
										<c:if test="${sessionScope.sessionID!=null}">
										</c:if>
						
										<div style="width: 100%;" class="w3-center" id="searchForm">
												<select name="condition" style="margin: 10px; height: 28px;">
													<option value="bdtt">제목</option>
													<option value="bdbd">내용</option>
													<option value="name">글쓴이</option>
												</select> 
												<input type="text" size="20" name="input" style="margin: 10px;" />
												<input id="serbtn" type="submit" value="search" style="margin: 10px;" />
										</div>
									</div>
									
						    </div>
			        
			      </div>
			    </div>
			  </div>
			</div>
    		
    	</div>
    	<div class="sh_group">
    	
    	</div>
    </div>
      <div class="column">
      	<div class="sh_group">
      		<div class="sh_header">
      		<h2> 사업자 정보</h2>
    		<div class="sh-content">
    			<h2>사업자번호,사업자이름,사업자주소</h2>
    		</div>
      		</div>
      		<div class="w3-container">
			  <button onclick="document.getElementById('id02').style.display='inline'" type="button" class="w3-button w3-green"  style="width: 60px; height: 40px; margin-top: 30px;" id="btn3">수정</button>
			  
			
			  <div id="id02" class="w3-modal">
			    <div class="w3-modal-content" style="width:500px; height:800px; margin-top: 100px;">
			      <div class="w3-container">
						  <div class="pro w3-center">
							<h4>사업자 정보</h4>
						</div>
			        <span onclick="document.getElementById('id02').style.display='none'" class="w3-button w3-display-topright">&times;</span>
			          <div class="w3-row" style="margin-top: 30px;">
			      		<p style="display:inline; font-size: 20px;"> 사업자 번호  : &nbsp; </p><input type="text" style="width: 323px; height:40px;" name="bno" id="bno" value="${LIST[0].bno}" />
			          </div>
			          <div class="w3-row" style="margin-top: 30px;">
			      		<p style="display:inline; font-size: 20px;"> 사업자 이름 : &nbsp; </p><input type="text" style="width: 323px; height:40px;" name="bname" id="bname" value="${LIST[0].bname}" />
			          </div>
			          <div class="w3-row" style="margin-top: 30px;">
			      		<p style="display:inline; font-size: 20px;"> 사업자 주소  : &nbsp; </p><input type="text" style="width: 323px; height:40px;" name="bloc" id="bloc" value="${LIST[0].bloc}" />
			          </div>
			          <div class="w3-row" style="margin-top: 30px;">
			      		<p style="display:inline; font-size: 20px;"> 메뉴1 이름  : &nbsp; </p><input type="text" style="width: 323px; height:40px; margin-left: 7px;" name="bloc" id="bloc" value="${LIST[0].bloc}" />
			          </div>
			          <div class="w3-row" style="margin-top: 30px;">
			      		<p style="display:inline; font-size: 20px;"> 메뉴1 가격  : &nbsp; </p><input type="text" style="width: 323px; height:40px; margin-left: 7px;" name="bloc" id="bloc" value="${LIST[0].bloc}" />
			          </div>
			          <div class="w3-row" style="margin-top: 30px;">
			      		<p style="display:inline; font-size: 20px;"> 메뉴2 이름  : &nbsp; </p><input type="text" style="width: 323px; height:40px; margin-left: 7px;" name="bloc" id="bloc" value="${LIST[0].bloc}" />
			          </div>
			          <div class="w3-row" style="margin-top: 30px;">
			      		<p style="display:inline; font-size: 20px;"> 메뉴2 가격  : &nbsp; </p><input type="text" style="width: 323px; height:40px; margin-left: 7px;" name="bloc" id="bloc" value="${LIST[0].bloc}" />
			          </div>
			          <div class="w3-row" style="margin-top: 30px;">
			      		<p style="display:inline; font-size: 20px;"> 메뉴3 이름  : &nbsp; </p><input type="text" style="width: 323px; height:40px; margin-left: 7px;" name="bloc" id="bloc" value="${LIST[0].bloc}" />
			          </div>
			          <div class="w3-row" style="margin-top: 30px;">
			      		<p style="display:inline; font-size: 20px;"> 메뉴3 가격  : &nbsp; </p><input type="text" style="width: 323px; height:40px; margin-left: 7px;" name="bloc" id="bloc" value="${LIST[0].bloc}" />
			          </div>
			        <button type="submit" class="w3-button w3-center w3-green" style="width: 60px; height: 40px; margin-top: 37px; margin-left: 218px;" id="btn4">완료</button>
			      </div>
			    </div>
			  </div>
			</div>
    		</div>
    	<div class="sh_group">
    	
    	</div>
    	<div class="sh_group">
    	
    	</div>
      		
    	</div>
      </div>
    
    </div>
			
  </form>

</body>
</html>