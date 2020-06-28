<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" href="/pro/css/w3.css" />
<link rel="stylesheet" href="/pro/css/signup.css" />
<link rel = "icon" href = "/pro/img/favicon.ico">
<style>
</style>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	
function chk(){
 var req = document.form.req.checked;
 var num = 0;
 if(req == true){
  num = 1;
 }
 if(num==1){
 }else{
  alert("개인정보 약관에 동의하셔야 합니다.");
  $(location).attr('href','/pro/kakao/Signup.pro');
 }
}

$('#submit').click(function() {
	alert('이거아니야');
	$('#msform').attr('method', 'POST');
    $('#msform').attr('action', '/pro/kakao/join.pro');
    $('#msform').submit();
});

});
</script>
</head>

<body>
<%-- <jsp:include page="/head.pro" flush="true" /> --%>
	<!-- multistep form -->
<form id="msform" name="form">
  <!-- progressbar -->
  <ul id="progressbar">
    <li class="active">Consent to membership</li>
    <li>Account Setup</li>
    <li>Business registration</li>
  </ul>
  <!-- fieldsets -->
  <fieldset>
    <h2 class="fs-title">Consent to membership</h2>
    <h3 class="fs-subtitle">Accept the terms</h3>
    <textarea rows="20" cols="150">가. 수집하는 개인정보의 항목첫째, 회사는 회원가 입, 원활한 고객상담, 각종 서비스의 제공을 위해 최초 회원가입 당시 아래와 같은 최소한의 개인정보를 필수항목으로 수집하고 있습니다.
		회원가입
		- 이름, 생년월일, 성별, 아이디, 비밀번호, 별명, 연락처(메일주소, 휴대폰 번호 중 선택), 가입인증정보
		만14세 미만 아동 회원가입
		- 이름, 생년월일, 성별, 법정대리인 정보, 아이디, 비밀번호, 연락처 (메일주소, 휴대폰 번호 중 선택), 가입인증정보
		단체아이디 회원가입
		- 단체아이디, 회사명, 대표자명, 대표 전화번호, 대표 이메일 주소, 단체주소, 관리자 아이디, 관리자 연락처, 관리자 부서/직위
		- 선택항목 : 대표 홈페이지, 대표 팩스번호
		둘째, 서비스 이용과정이나 사업처리 과정에서 아래와 같은 정보들이 자동으로 생성되어 수집될 수 있습니다.
		- IP Address, 쿠키, 방문 일시, 서비스 이용 기록, 불량 이용 기록
		셋째, 카카오 아이디를 이용한 부가 서비스 및 맞춤식 서비스 이용 또는 이벤트 응모 과정에서 해당 서비스의 이용자에 한해서만 개인정보 추가 수집이 발생할 수 있으며, 이러한 경우 별도의 동의를 받습니다.
		넷째, 성인컨텐츠, 유료/게임 등 일부 서비스 이용시 관련 법률 준수를 위해 본인인증이 필요한 경우, 아래와 같은 정보들이 수집될 수 있습니다.
		- 이름, 생년월일, 성별, 중복가입확인정보(DI), 암호화된 동일인 식별정보(CI), 휴대폰 번호(선택), 아이핀 번호(아이핀 이용시), 내/외국인 정보
		다섯째, 유료 서비스 이용 과정에서 아래와 같은 결제 정보들이 수집될 수 있습니다.
		- 신용카드 결제시 : 카드사명, 카드번호 등
		- 휴대전화 결제시 : 이동전화번호, 통신사, 결제승인번호 등
		- 계좌이체시 : 은행명, 계좌번호 등
		- 상품권 이용시 : 상품권 번호
		나. 개인정보 수집방법회사는 다음과 같은 방법으로 개인정보를 수집합니다.
		- 홈페이지, 서면양식, 팩스, 전화, 상담 게시판, 이메일, 이벤트 응모, 배송요청
		- 협력회사로부터의 제공
		- 생성정보 수집 툴을 통한 수집
		   </textarea>
		   <br><br>
		   <input type="checkbox" name="req"> 개인정보 수집 및 이용에 동의합니다.
		   <br>
		   <hr>
    <input type="button" name="next" onclick="chk()" class="next action-button" value="Next" />
  </fieldset>
  <fieldset>
    <h2 class="fs-title">Create your account</h2>
    <h3 class="fs-subtitle">This is step 1</h3>
    <input type="hidden" name="memno" placeholder="${userId}" />
    <input type="email" name="memid" placeholder="Email" />
    <input type="text" name="name" placeholder="UserName" />
    <input type="text" name="phone" placeholder="Phone (010-xxxx-xxxx)" />
					<select name="birth_1" class="input" style="margin-bottom: 10px; margin-left:-5px; width:230px; height:51px;" >
					<option value=1>1900</option>
					<option value=2>1901</option>
					<option value=3>1902</option>
					<option value=4>1903</option>
					<option value=5>1904</option>
					<option value=6>1905</option>
					<option value=7>1906</option>
					<option value=8>1907</option>
					<option value=9>1908</option>
					<option value=10>1909</option>
					<option value=11>1910</option>
					<option value=12>1911</option>
					<option value=13>1912</option>
					<option value=14>1913</option>
					<option value=15>1914</option>
					<option value=16>1915</option>
					<option value=17>1916</option>
					<option value=18>1917</option>
					<option value=19>1918</option>
					<option value=20>1919</option>
					<option value=21>1920</option>
					<option value=22>1921</option>
					<option value=23>1922</option>
					<option value=24>1923</option>
					<option value=25>1924</option>
					<option value=26>1925</option>
					<option value=27>1926</option>
					<option value=28>1927</option>
					<option value=29>1928</option>
					<option value=30>1929</option>
					<option value=31>1930</option>
					<option value=32>1931</option>
					<option value=33>1932</option>
					<option value=34>1933</option>
					<option value=35>1934</option>
					<option value=36>1935</option>
					<option value=37>1936</option>
					<option value=38>1937</option>
					<option value=39>1938</option>
					<option value=40>1939</option>
					<option value=41>1940</option>
					<option value=42>1941</option>
					<option value=43>1942</option>
					<option value=44>1943</option>
					<option value=45>1944</option>
					<option value=46>1945</option>
					<option value=47>1946</option>
					<option value=48>1947</option>
					<option value=49>1948</option>
					<option value=50>1949</option>
					<option value=51>1950</option>
					<option value=52>1951</option>
					<option value=53>1952</option>
					<option value=54>1953</option>
					<option value=55>1954</option>
					<option value=56>1955</option>
					<option value=57>1956</option>
					<option value=58>1957</option>
					<option value=59>1958</option>
					<option value=60>1959</option>
					<option value=61>1960</option>
					<option value=62>1961</option>
					<option value=63>1962</option>
					<option value=64>1963</option>
					<option value=65>1964</option>
					<option value=66>1965</option>
					<option value=67>1966</option>
					<option value=68>1967</option>
					<option value=69>1968</option>
					<option value=70>1969</option>
					<option value=71>1970</option>
					<option value=72>1971</option>
					<option value=73>1972</option>
					<option value=74>1973</option>
					<option value=75>1974</option>
					<option value=76>1975</option>
					<option value=77>1976</option>
					<option value=78>1977</option>
					<option value=79>1978</option>
					<option value=80>1979</option>
					<option value=81>1980</option>
					<option value=82>1981</option>
					<option value=83>1982</option>
					<option value=84>1983</option>
					<option value=85>1984</option>
					<option value=86>1985</option>
					<option value=87>1986</option>
					<option value=88>1987</option>
					<option value=89>1988</option>
					<option value=90>1989</option>
					<option value=91>1990</option>
					<option value=92>1991</option>
					<option value=93>1992</option>
					<option value=94>1993</option>
					<option value=95>1994</option>
					<option value=96>1995</option>
					<option value=97>1996</option>
					<option value=98>1997</option>
					<option value=99>1998</option>
					<option value=100>1999</option>
					<option value=101>2000</option>
					<option value=102>2001</option>
					<option value=103>2002</option>
					<option value=104>2003</option>
					<option value=105>2004</option>
					<option value=106>2005</option>
					<option value=107>2006</option>
					<option value=108>2007</option>
					<option value=109>2008</option>
					</select> 년
					<select name="birth_2" class="input" style="margin-bottom: 10px; width:100px; height:51px;">
					<option value=1>1</option>
					<option value=2>2</option>
					<option value=3>3</option>
					<option value=4>4</option>
					<option value=5>5</option>
					<option value=6>6</option>
					<option value=7>7</option>
					<option value=8>8</option>
					<option value=9>9</option>
					<option value=10>10</option>
					<option value=11>11</option>
					<option value=12>12</option>
					</select> 월
					<select name="birth_3" class="input" style="margin-bottom: 10px; width:100px; height:51px;">
					<option value=1>1</option>
					<option value=2>2</option>
					<option value=3>3</option>
					<option value=4>4</option>
					<option value=5>5</option>
					<option value=6>6</option>
					<option value=7>7</option>
					<option value=8>8</option>
					<option value=9>9</option>
					<option value=10>10</option>
					<option value=11>11</option>
					<option value=12>12</option>
					<option value=13>13</option>
					<option value=14>14</option>
					<option value=15>15</option>
					<option value=16>16</option>
					<option value=17>17</option>
					<option value=18>18</option>
					<option value=19>19</option>
					<option value=20>20</option>
					<option value=21>21</option>
					<option value=22>22</option>
					<option value=23>23</option>
					<option value=24>24</option>
					<option value=25>25</option>
					<option value=26>26</option>
					<option value=27>27</option>
					<option value=28>28</option>
					<option value=29>29</option>
					<option value=30>30</option>
					<option value=31>31</option>
					</select> 일
            <select name="opt" style="width: 500px; height: 51px;">
                           <option value="1" id="ab1">소형</option>
                           <option value="2" id="ab2">경형</option>
                           <option value="3" id="ab3">준중형</option>
                           <option value="4" id="ab4">중형</option>
                           <option value="5" id="ab5">준대형</option>
                           <option value="6" id="ab6">대형</option>
                           <option value="7" id="ab7">스포츠카</option>
                           <option value="8" id="ab8">기타</option>
                        </select>
    <input type="button" name="previous" class="previous action-button" value="Previous" />                    
    <input type="button" name="next" class="next action-button" value="Next" />
  </fieldset>
  <fieldset>
    <h2 class="fs-title">Business registration</h2>
    <h3 class="fs-subtitle">Your Business InFomation</h3>
    <input type="text" name="bno" placeholder="Business Number" />
    <input type="text" name="bname" placeholder="Store Name" />
    <input type="text" name="bloc" placeholder="Store address" />
    <input type="button" name="previous" class="previous action-button" value="Previous" />
    <input type="button" name="submit" id="submit" class="submit action-button" value="Submit" />
  </fieldset>
 
</form>
</body>
<Script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></Script>
<!-- <script type="text/javascript" src="/pro/js/jquery-3.5.0.min.js"></script> -->
<script type="text/javascript" src="/pro/js/signup.js"></script>
</html>