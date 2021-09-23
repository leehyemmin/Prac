$(document).ready(function(){
    
     /* 아이디 저장 버튼 클릭시 */
     var userInputId = getCookie("userInputId");

     $("input[name='admin_id']").val(userInputId);
 
     if($("input[name='admin_id']").val() != ""){ // 처음 페이지 로딩시, 입력칸에 저장된 ID가 표시된 상태
         $("#idSaveCheck").attr("checked", true); // ID 저장하기를 체크 상태로 두기
     }
 
     $("#idSaveCheck").change(function(){  // 체크박스에 변화가 있으면
         if($("#idSaveCheck").is(":checked")){  // ID저장하기 체크했을 때
             var userInputId = $("input[name='admin_id']").val();
             setCookie("userInputId", userInputId, 7); // 7일동안 쿠키 보관
         }else{  // ID저장하기 체크 해제시
             deleteCookie("userInputId");
         }
     });
 
     // ID 저장하기를 체크한 상태에서 ID를 입력하는 경우, 이럴 때도 쿠키 저장.
     $("input[name='admin_id']").keyup(function(){ // ID 입력 칸에 ID를 입력할 때,
         if($("#idSaveCheck").is(":checked")){ // ID 저장하기를 체크한 상태라면,
             var userInputId = $("input[name='admin_id']").val();
             setCookie("userInputId", userInputId, 7); // 7일 동안 쿠키 보관
         }
     });

});

  //  쿠키 설정 
  function setCookie(cookieName, value, exdays){
	var exdate = new Date();

	exdate.setDate(exdate.getDate() + exdays);

	var cookieValue = escape(value) + ((exdays==null) ? "" : "; expires=" + exdate.toGMTString());

	document.cookie = cookieName + "=" + cookieValue;
}

 
    //  쿠키 삭제
    function deleteCookie(cookieName){
	var expireDate = new Date();

	expireDate.setDate(expireDate.getDate() - 1);

	document.cookie = cookieName + "= " + "; expires=" + expireDate.toGMTString();
}

 
    // 쿠키 호출
    function getCookie(cookieName) {

	cookieName = cookieName + '=';

	var cookieData = document.cookie;
	var start = cookieData.indexOf(cookieName);
	var cookieValue = '';

	if(start != -1){
		start += cookieName.length;

		var end = cookieData.indexOf(';', start);

		if(end == -1)end = cookieData.length;

		cookieValue = cookieData.substring(start, end);
	}
	return unescape(cookieValue);
}

