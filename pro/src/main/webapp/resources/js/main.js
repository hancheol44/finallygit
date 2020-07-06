$(document).ready(function(){
	

function counterUp( settings ){
  var $settings = settings;
  var $target =$settings.ele;
  var countUpDatas = [];
  var countFuncs;

  var nums = [];
  var delay=$settings.delay || 0.9;
  var time=$settings.time || 100;
  var divisions = time / delay;
  var num = $settings.num;
  //콤마가 있는지 체크 정규식
  var isComma = /[0-9]+,[0-9]+/.test(num);
  num = num.replace(/,/g, '');
  // 숫자 목록 생성
  for (var i = divisions; i >= 1; i--) {
    
    //  int 인 경우 int로 유지
    var newNum = parseInt(num / divisions * i);
    // console.log( newNum, num / divisions * i)
    // 쉼표가있는 경우 쉼표 유지
    if (isComma) {
      while (/(\d+)(\d{3})/.test(newNum.toString())) {
        newNum = newNum.toString().replace(/(\d+)(\d{3})/, '$1'+','+'$2');
      }
    }
    nums.unshift(newNum);
  }

  countUpDatas=nums;


  $target.text('0');

  // 완료 될 때까지 번호를 업데이트
  function updateNum() {

    $target.text( countUpDatas.shift() );
    
    //숫자를 담고 있는 배열 길이가 존재한다면 계속해서 루프 시킴.
    if ( countUpDatas.length ) {
      setTimeout( countFuncs, delay);
    } else {
      delete countUpDatas;
      countUpDatas=null;
      countFuncs=null;
    }
    // console.log( countUpDatas.length )
  }
  countFuncs=updateNum;
  // 카운트 시작
  setTimeout( countFuncs, delay);
}

//실행할 카운트가 여러개일 경우 설정.
function numberMotion( items ) {
  if(Object.prototype.toString.call( items )!=='[object Array]'){ return }
  for( var i=0;i<items.length;i++){
    counterUp( {num:items[i].num, ele:items[i].ele });
  }
}
// 각 숫자 변수 선언
var num1 = '122';
var num2 ='1,222';
var num3 ='100';
numberMotion( [
  {num:num1, ele:$('.min') },
  {num:num2, ele:$('.max') },
  {num:num3, ele:$('.member') }
]);

});