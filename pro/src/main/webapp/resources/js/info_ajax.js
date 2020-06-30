$(document).ready(function(){
	// 리뷰 작성 후 카운트
	function reviewCount(){
		alert('리뷰 카운트 왔니?');
		var ifn = $('#c_ifno').val();
		
		$.ajax({
			url: '/pro/info/infoAC_Detail.pro',
			type: 'post',
			dataType: 'json',
			data:{
				'ifno':ifn
			},
			success: function(obj){
				alert(obj.ifrcnt);
				$('#ifrcnt').text('('+obj.ifrcnt+')');
			},
			error: function(){
				alert('리뷰카운트 전송실패');
			}
	});
	
}	
	
// 글 삭제후 리스트 다시 호출	
function reList(){
		var ifn = $('#c_ifno').val();
			alert('여기는 삭제 후 리스트 :'+ifn);
			$.ajax({
				url: '/pro/info/infoAC_ReviewList.pro',
				type: 'post',
				dataType: 'json',
				data:{
					'ifno':ifn
				},
				success: function(obj){
					alert('리뷰뽑기 성공!!!');
					var len = obj.length;
					for(var i = 0 ; i < len ; i++){
						if(id === obj[i].memid){
							$('#reviewList').prepend('<div id="remove_point">'+
									'<div value="gdgdgd" id="rlist'+obj[i].ifno+'" class="line">'+
									'<div>'+
									'<span><b>평점 : <span id="rrst">'+ obj[i].ifrst + '</span></b></span><br>'+
									'<span id="rname">작성자 : '+ obj[i].memid + '</span><br>'+
									'<span id="rrtt">'+ obj[i].ifrtt + '</span>'+
									'</div>'+
									'<div>'+
									'<span id="rrbd">'+ obj[i].ifrbd + '</span>'+
									'</div>'+
									'<a class="modbtn" value="'+obj[i].ifrno+'" id="modbtn">수정</a>'+
									'<a class="delbtn" value="'+obj[i].ifrno+'" id="delbtn" onclick="remove()">삭제</a>'+
									//'<a href="/pro/sales/reviewDelete.pro?rno='+obj[i].rno+'&pno='+obj[i].pno+'">삭제</a>'+
									//'<a class="delete" value="'+obj[i].rno+'"onclick="remove()">삭제</a>'+
									'</div>' +
							'</div>' +
							'<br>')
						} else {
							$('#reviewList').prepend('<div id="remove_point">'+
									'<div id="rlist'+obj[i].ifno+'" class="line">'+
									'<div>'+
									'<span><b>평점 : <span id="rrst">'+ obj[i].ifrst + '</span></b></span><br>'+
									'<span id="rname">작성자 : '+ obj[i].ifname + '</span><br>'+
									'<span id="rrtt">'+ obj[i].ifrtt + '</span>'+
									'</div>'+
									'<div>'+
									'<span id="rrbd">'+ obj[i].ifrbd + '</span>'+
									'</div>'+
									//'<a href="/pro/sales/reviewDelete.pro?rno='+obj[i].rno+'&pno='+obj[i].pno+'">삭제</a>'+
									//'<a class="delete" value="'+obj[i].rno+'"onclick="remove()">삭제</a>'+
									'</div>'+
							'</div>'+
							'<br>')
						}
					}
				},
				error: function(){
					alert('리뷰뽑기 통신실패');
				}
			});
		
		};
	

	
	
	
	// 글 삭제 ajax 클릭시
$(document).on('click','.delbtn', function remove(){
	var ifrno = $(this).attr('value');
	alert('여기??'+ifrno);
	cifno = $('#c_ifno').val();
	alert('글삭제 cifno : ' + cifno);
	$.ajax({
		url:'/pro/info/infoAC_ReviewDel.pro',
		type:'post',
		dataType:'json',
		data:{
			'ifrno':ifrno
		},
		success: function(obj){
			
			if(obj == 1){
				$('#'+'rlist'+ifrno).remove();
			} else{
				alert("실패");
			}
		},
		error: function(request, error){
			alert('삭제실패!!');
			alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}
	});
	reList(); // 리뷰 목록 다시 불러오는 함수
	reviewCount(); //리뷰 카운트 다시 불러오는 함수
});



// 글 수정
$(document).on('click','.modbtn', function modi(){
	var ifrno = $(this).attr('value');
	var modbtn = $(this).html();
	var rttt = $('#'+'rtt'+ifrno).html();
	var rtbd = $('#'+'rbd'+ifrno).html();
	
	if(modbtn === '수정'){
		$('#'+'rtt'+ifrno).replaceWith('<textarea id="rtt'+ifrno+'" style="resize: none;">'+rttt+'</textarea>');
		$('#'+'rbd'+ifrno).replaceWith('<textarea id="rbd'+ifrno+'" style="resize: none;">'+rtbd+'</textarea>');
		$(this).text('등록');
	} else {
		var modirt = $('#'+'rtt'+ifrno).val();
		var modibd = $('#'+'rbd'+ifrno).val();
		
		$(this).text('수정');
		
		$.ajax({
			url:'/pro/info/infoAC_ReviewMod.pro',
			type:'post',
			dataType:'json',
			data:{
				'ifrno':ifrno,
				'ifrtt':modirt,
				'ifrbd':modibd
			},
			success: function(obj){
				if(obj == 1){
				$('#'+'rtt'+ifrno).replaceWith('<span id="rtt'+ifrno+'">'+modirt+'</span>');
				$('#'+'rbd'+ifrno).replaceWith('<span id="rbd'+ifrno+'">'+modibd+'</span>');
				$(this).text('수정');
				} else {
					alert('수정처리 실패');
				}
			},
			error: function(request, error){
				alert('수정실패!!');
				alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			}
		});
	}
	
	
});

	
	// 자동차캠핑 상세보기 ajax
	$('td').click(function(){
		alert('비동기');
		var ifno = $(this).attr('id');
		var cifno = $('#c_ifno').val(ifno);
		$.ajax({
			url: '/pro/info/infoAC_Detail.pro',
			type: 'post',
			dataType: 'json',
			data:{
				'ifno':ifno
			},
			success: function(obj){
				var name = obj.ifname;
				var tel = obj.iftel;
				var addr = obj.ifaddr;
				var price = obj.ifpri;
				var link = obj.iflink;
				var strp = obj.ifrst;
				
				if(strp == 5){
					$('#strpoint').html('★★★★★');
				} else if(strp == 4){
					$('#strpoint').html('★★★★');
				} else if(strp == 3){
					$('#strpoint').html('★★★');
				} else if(strp == 2){
					$('#strpoint').html('★★');
				} else if(strp == 1){
					$('#strpoint').html('★');
				} else {
					$('#strpoint').html(' ');
				}
				
				$('#ifrcnt').text('('+obj.ifrcnt+')');
				$('#acname').html(name);
				$('#actel').html(tel);
				$('#acaddr').html(addr);
				$('#acpri').html(price);
				$('#hplink').attr('href', link);
				$('#search').attr('href','https://map.kakao.com/link/search/' + addr);
				$('.detail_card').css('display', '');
				$('#reviewbt').text('리뷰');
				$('#addReview').text('리뷰작성');
				$('#reviewList *').remove();
				$('#rWrite').css('display','none');
				
			},
			error: function(request, error){
				alert('### 통신에러 ###');
				alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			}
		});
	});
	
	// 리뷰 보기 ajax 처리
	$('#reviewbt').click(function(){
		var btnname = $('#reviewbt').text();
		var ifn = $('#c_ifno').val();
		var id = $('#sid').val();
		if(btnname === '닫기'){
			alert('리뷰뽑기 ajax');
			
			$.ajax({
				url: '/pro/info/infoAC_ReviewList.pro',
				type: 'post',
				dataType: 'json',
				data:{
					'ifno':ifn
				},
				success: function(obj){
					alert('리뷰뽑기 성공!!!');
					var len = obj.length;
					
					for(var i = 0 ; i < len ; i++){
						if(id === obj[i].memid){
							$('#reviewList').prepend('<div id="remove_point">'+
									'<div id="rlist'+obj[i].ifrno+'" class="line">'+
									'<div>'+
									'<span><b>평점 : <span id="rrst">'+ obj[i].ifrst + '</span></b></span><br>'+
									'<span id="rname">작성자 : '+ obj[i].memid + '</span><br>'+
									'<span><b>제목 : </b></span><span id="rtt'+obj[i].ifrno+'">'+ obj[i].ifrtt + '</span>'+
									'</div>'+
									'<div>'+
									'<span><b>내용 : </b></span><span id="rbd'+obj[i].ifrno+'">'+ obj[i].ifrbd + '</span>'+
									'</div>'+
									'<a class="modbtn" value="'+obj[i].ifrno+'" id="modbtn">수정</a>'+
									'<a class="delbtn" value="'+obj[i].ifrno+'" id="delbtn" onclick="remove()">삭제</a>'+
									//'<a href="/pro/sales/reviewDelete.pro?rno='+obj[i].rno+'&pno='+obj[i].pno+'">삭제</a>'+
									//'<a class="delete" value="'+obj[i].rno+'"onclick="remove()">삭제</a>'+
									'</div>' +
							'</div>' +
							'<br>')
						} else {
							$('#reviewList').prepend('<div id="remove_point">'+
									'<div id="rlist'+obj[i].ifrno+'" class="line">'+
									'<div>'+
									'<span><b>평점 : <span id="rrst">'+ obj[i].ifrst + '</span></b></span><br>'+
									'<span id="rname">작성자 : '+ obj[i].memid + '</span><br>'+
									'<span><b>제목 : </b></span><span id="rtt'+obj[i].ifrno+'">'+ obj[i].ifrtt + '</span>'+
									'</div>'+
									'<div>'+
									'<span><b>내용 : </b></span><span id="rbd'+obj[i].ifrno+'">'+ obj[i].ifrbd + '</span>'+
									'</div>'+
									//'<a href="/pro/sales/reviewDelete.pro?rno='+obj[i].rno+'&pno='+obj[i].pno+'">삭제</a>'+
									//'<a class="delete" value="'+obj[i].rno+'"onclick="remove()">삭제</a>'+
									'</div>'+
							'</div>'+
							'<br>')
						}
							
					}
					
				},
				error: function(){
					alert('리뷰뽑기 통신실패');
				}
			});
		} else {
			alert('리뷰닫아!!');
			$('#reviewList *').remove();
		}
		
	
	});
	
	// 리뷰 작성 ajax 처리
	$('#inputreview').click(function(){
		alert('리뷰씁니다');
		var ifno = $('#c_ifno').val();
		var strp = $('#rstSelect').val();
		var rtt = $('#rett').val();
		var rbd = $('#rebd').val();
		var sid = $('#sid').val();
		alert(ifno);
		alert(sid);
		alert(strp);
		alert(rtt);
		alert(rbd);
		
			$.ajax({
				url: '/pro/info/infoAC_ReviewWrite.pro',
				type: 'post',
				dataType: 'json',
				data:{
					'ifrst':strp,
					'ifrtt':rtt,
					'ifrbd':rbd,
					'ifno': ifno,
					'memid': sid
				},
				success: function(obj){
					alert(obj.memid);
					$('#reviewList').prepend('<div id="remove_point">'+
							'<div id="rlist'+obj.ifno+'" class="line">'+
							'<div>'+
							'<span><b>평점 : <span id="rrst">'+ obj.ifrst + '</span></b></span><br>'+
							'<span id="rname">작성자 : '+ obj.memid + '</span><br>'+
							'<span id="rrtt">제목 : '+ obj.ifrtt + '</span>'+
							'</div>'+
							'<div>'+
							'<span id="rrbd">내용 : '+ obj.ifrbd + '</span>'+
							'</div>'+
							//'<a class="modbtn" id="modbtn">수정</a>'+
							//'<a class="delbtn" id="delbtn" onclick="remove()">삭제</a>'+
							'</div>'+
					'</div>'+
					'<br>')
					document.getElementById('rett').value=" ";
					document.getElementById('rebd').value=" ";
				},
				error: function(request, error){
					alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
				}
			});
			reList(); // 리뷰 목록 다시 불러오는 함수
			reviewCount(); //리뷰 카운트 다시 불러오는 함수
	});
	
});