<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.80.0">
    <title>혜민 플젝</title>
  <meta name="theme-color" content="#563d7c">
   
   <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }
      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
      	.agree {border: 1px solid #e6e6e6;}
		.agree > div {overflow: auto; height:176px; padding: 26px 19px;}
    </style>
  
<%@include file="/WEB-INF/views/common/common.jsp" %>


<script type="text/javascript" src="/js/member/modifyForm.js"></script>

  </head>
  <body>
    
<!-- header.jsp -->
<%@include file="/WEB-INF/views/common/header.jsp" %>

<main role="main" class="container">
	<div class="wrapper">
		<section class="content container-fluid">
			<div class="container" style="width: 70%; min-width: 900px; background-color: white; font-size: 14px;" >
	
<div class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
  <h1 class="display-4">Form Modify</h1>
</div>

<h3>기본정보</h3>
	<p>
	<img src="/img_all/require.png" alt="필수">표시는 필수적으로 입력해주셔야합니다.
	</p>
	<hr>
	
	
	
<form id="modifyForm" action="/member/modifyForm" method="post">
	<!-- 아이디 -->
	<div class="form-group" style="width:100%;">
		<label for="inputID"><img src="/img_all/require.png" alt="필수">&nbsp 아이디</label><br>
			<input type="text" class="form-control" id="mb_id" name="mb_id" readonly value='<c:out value="${vo.mb_id }" />'
					style="max-width:350px; margin-right: 5px;  display: inline;" required>
	</div>
	
	<!-- 비밀번호 -->
	<div class="form-group">
		<label for="inputPassword"><img src="/img_all/require.png" alt="필수">&nbsp 비밀번호</label><br>
		<input type="password" class="form-control" id="mb_pw" name="mb_pw" maxlength="16" placeholder="비밀번호를 입력해 주세요" style="max-width:350px; display: inline;" required>
			<small class="form-text text-muted" style="display: inline;">(영문 대소문자/숫자/특수문자를 포함, 10~16자)</small>
	</div>
	<div class="form-group">
		<label for="inputPasswordCheck"><img src="/img_all/require.png" alt="필수">&nbsp 비밀번호확인</label><br>
		<input type="password" class="form-control" id="mb_pw_check" name="mb_pw_check" maxlength="16" placeholder="비밀번호를 다시한번 입력해주세요" style="max-width:350px; display: inline;" required>
	</div>
	
	<!-- 이름 -->
	<div class="form-group">
		<label for="inputPassword"><img src="/img_all/require.png" alt="필수">&nbsp 이름</label><br>
		<input type="text" class="form-control" id="mb_name" name="mb_name" maxlength="30" placeholder="이름을 입력해주세요" style="max-width:350px; display: inline;" required value='<c:out value="${vo.mb_name }" />'>
	</div>	<hr>	
	<!-- 주소부분 daum api 우편번호 예제 -->
	<!-- 부트스트랩일 경우 class="form-control" -->
	<div class="form-group" >
		<label for="inputAddr"><img src="/img_all/require.png" alt="필수">&nbsp 주소</label><br>
			<input type="text" id="sample2_postcode" name="mb_zipcode" class="form-control" style="max-width: 200px; display: inline-block;" readonly value='<c:out value="${vo.mb_zipcode }" />'>
			<input type="button" onclick="sample2_execDaumPostcode()" class="form-control" class="btn btn-outline-dark" 
				style="max-width:150px; margin-right: 5px;  display:inline-block;"  value="우편번호"><br>
			<input type="text" id="sample2_address" name="mb_addr" class="form-control"
				style="max-width:550px; margin-right: 5px;  display:inline;" readonly value='<c:out value="${vo.mb_addr }" />'>기본주소<br>
			<input type="text" id="sample2_detailAddress" name="mb_de_addr" class="form-control"
				style="max-width:550px; margin-right: 5px;  display:inline;" value='<c:out value="${vo.mb_de_addr }" />'>나머지주소<br>
			<input type="hidden" id="sample2_extraAddress" placeholder="참고항목">
	</div>
		<div id="layer" style="display:none;position:fixed;overflow:hidden;z-index:1;-webkit-overflow-scrolling:touch;">
		<img src="//t1.daumcdn.net/postcode/resource/images/close.png" id="btnCloseLayer" style="cursor:pointer;position:absolute;right:-3px;top:-3px;z-index:1" onclick="closeDaumPostcode()" alt="닫기 버튼">
		</div><hr>
	
	<!-- 휴대전화 -->
	<div class="form-group">
		<label for="inputCallphone"><img src="/img_all/require.png" alt="필수">&nbsp 휴대전화</label><br>
		<input type="tel" class="form-control" id="mb_phone" name="mb_phone" style="max-width:350px; display: inline;" placeholder="휴대전화를 입력하세요." required value='<c:out value="${vo.mb_phone }" />'>
		<small class="form-text text-muted" style="display: inline;">(  ' - ' 를 빼고 입력해주세요.)</small>
	</div>	
	
			<hr>
	<!-- 이메일 -->
	<div class="form-group">
		<label for="inputEmail"><img src="/img_all/require.png" alt="필수">&nbsp 이메일</label><br>
		<input type="email" class="form-control" id="mb_email" name="mb_email" style="max-width:350px; display: inline;" placeholder="이메일을 입력하세요." required value='<c:out value="${vo.mb_email }" />'>
		<small class="form-text text-muted" style="display: inline;">( ex) abc123@abc.com)</small>
	<!-- aws 이메일 인증 안됨.
		<button id="btn_sendAuthCode" class="btn btn-light" type="button" >이메일 인증</button>
		<p id="authcode_status" style="color: red;"></p>
	-->
	</div>	
	<!-- 이메일 인증 요청을 하고 , 성공적으로 진행이 되면, 아래 div태그가 보여진다. 
			<div id="email_authcode" class="form-group" style="display: none;">
				<label for="inputAuthCode">* 이메일 인증코드</label><br /> 
				<input	type="text" class="form-control" id="mb_authcode"
					placeholder="이메일 인증코드를 입력해 주세요"
					style="max-width: 570px; width: calc(100% - 70px); margin-right: 5px; display: inline-block;" />
				<button id="btn_checkAuthCode" class="btn btn-default" type="button">확인</button>
			</div> 
	-->		
			<!-- 이메일 수신여부 -->
			<div class="form-group">
				<label><img src="/img_all/require.png" alt="필수">&nbsp 이메일 수신여부</label><br /> 쇼핑몰에서 제공하는 유익한 이벤트 소식을 이메일로 받으시겠습니까?
					<label><input type="radio" name="mb_email_e" value="Y" style="margin-left: 20px;" checked="checked" value='<c:out value="${vo.mb_email_e == 'Y'?'checked':''}" />'> 예</label> 
					<label><input type="radio" name="mb_email_e" value="N" style="margin-left: 20px;" value='<c:out value="${vo.mb_email_e == 'N'?'checked':''}" />'> 아니오</label>
			</div>
	<hr>
	
	
	<div class="form-group text-center">
		<button type="button" id="btn_submit" class="btn btn-outline-success">
			확인 <i class="fa fa-check spaceLeft"></i>
		</button>
		<button type="button" id="btn_cancle" class="btn btn-outline-warning">
		 	취소 <i class="fa fa-check spaceLeft"></i>
		</button>
		<button type="button" id="btn_delete" class="btn btn-outline-danger" onclick="location.href='/member/mb_delete'">
			탈퇴 <i class="fa fa-check spaceLeft"></i>
		</button>
	</div>
</form>
<br><br><br><br>



<!-- 주소 -->
<!-- iOS에서는 position:fixed 버그가 있음, 적용하는 사이트에 맞게 position:absolute 등을 이용하여 top,left값 조정 필요 -->
<div id="layer" style="display:none;position:fixed;overflow:hidden;z-index:1;-webkit-overflow-scrolling:touch;">
<img src="//t1.daumcdn.net/postcode/resource/images/close.png" id="btnCloseLayer" style="cursor:pointer;position:absolute;right:-3px;top:-3px;z-index:1" onclick="closeDaumPostcode()" alt="닫기 버튼">
</div>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    // 우편번호 찾기 화면을 넣을 element
    var element_layer = document.getElementById('layer');

    function closeDaumPostcode() {
        // iframe을 넣은 element를 안보이게 한다.
        element_layer.style.display = 'none';
    }

    function sample2_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("sample2_extraAddress").value = extraAddr;
                
                } else {
                    document.getElementById("sample2_extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample2_postcode').value = data.zonecode;
                document.getElementById("sample2_address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample2_detailAddress").focus();

                // iframe을 넣은 element를 안보이게 한다.
                // (autoClose:false 기능을 이용한다면, 아래 코드를 제거해야 화면에서 사라지지 않는다.)
                element_layer.style.display = 'none';
            },
            width : '100%',
            height : '100%',
            maxSuggestItems : 5
        }).embed(element_layer);

        // iframe을 넣은 element를 보이게 한다.
        element_layer.style.display = 'block';

        // iframe을 넣은 element의 위치를 화면의 가운데로 이동시킨다.
        initLayerPosition();
    }

    // 브라우저의 크기 변경에 따라 레이어를 가운데로 이동시키고자 하실때에는
    // resize이벤트나, orientationchange이벤트를 이용하여 값이 변경될때마다 아래 함수를 실행 시켜 주시거나,
    // 직접 element_layer의 top,left값을 수정해 주시면 됩니다.
    function initLayerPosition(){
        var width = 300; //우편번호서비스가 들어갈 element의 width
        var height = 400; //우편번호서비스가 들어갈 element의 height
        var borderWidth = 5; //샘플에서 사용하는 border의 두께

        // 위에서 선언한 값들을 실제 element에 넣는다.
        element_layer.style.width = width + 'px';
        element_layer.style.height = height + 'px';
        element_layer.style.border = borderWidth + 'px solid';
        // 실행되는 순간의 화면 너비와 높이 값을 가져와서 중앙에 뜰 수 있도록 위치를 계산한다.
        element_layer.style.left = (((window.innerWidth || document.documentElement.clientWidth) - width)/2 - borderWidth) + 'px';
        element_layer.style.top = (((window.innerHeight || document.documentElement.clientHeight) - height)/2 - borderWidth) + 'px';
    }
</script>
				</div>
			</section>
		</div>
      </main>
  </body>
</html>