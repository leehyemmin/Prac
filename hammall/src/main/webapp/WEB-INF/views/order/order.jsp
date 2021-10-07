<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.80.0">
    <title>혜민 플젝</title>
  
<%@include file="/WEB-INF/views/common/common.jsp" %>
 
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
        
       li{
     	list-style: none;
     }
     
      }
    </style>

  </head>
  <body>
    
<!-- header.jsp -->
<%@include file="/WEB-INF/views/common/header.jsp" %>

<main role="main" class=".container-fluid">

<div class="row">
	<div class="col-2">
		<%@include file="/WEB-INF/views/common/category_list.jsp" %>
	</div>
	
	<div class="col-9">
		<div class="panel panel-default">
			<div class="panel-body">
					<!-- 리스트 -->
					<table class="table table-striped">
						<thead>
							<tr>
								<th scope="col">번호</th>
								<th scope="col">이미지</th>
								<th scope="col">상품명</th>
								<th scope="col">수량</th>
								<th scope="col">판매가</th>
							</tr>
						</thead>
						<tbody>
							<%-- 데이터가 존재하지 않는 경우 --%>
							<c:if test="${empty cartVOList }">
							<tr>
								<td colspan="8">
									<p style="color: red; text-align: center; margin-top: 10px">장바구니가 비워져있습니다.</p>
								</td>
							</tr>
							</c:if>
							
								<c:set var="i" value="1"></c:set>
								<c:set var="price" value="0"></c:set>
								<c:forEach items="${cartVOList }" var="cartlist">
								<c:set var="price" value="${cartlist.prod_price * cartlist.cart_amount}"></c:set>
									<tr>
											<th scope="row">${i}</th>
											<td>
												<img src="/cart/displayFile?fileName=${cartlist.prod_img }">
											</td>
											<td>
												<c:out value="${cartlist.prod_name }"/>
											</td>
											<td>
												<c:out value="${cartlist.cart_amount }"/>
											</td>
											<td>
												<fmt:formatNumber type="currency" value="${price }"/>
											</td>
									</tr>
									<c:set var="i" value="${i+1}"></c:set>
									<c:set var="sum" value="${sum + price}"></c:set>
								</c:forEach>
						</tbody>
					</table>
			</div>
			
			<div id="sum_price" class="panel-body">
				<table class="table table-striped">
					<tr>
						<td>총 금액</td>
						<td><fmt:formatNumber type="currency" value="${sum }" /></td>
					</tr>
				</table>
			</div>
		</div>
		<hr>
		
		<!-- 주문입력정보 -->
		<div class="panel panel-default">
			<div class="panel-body">
				<h3>주문자 정보</h3><hr>
				
				<!-- 이름 -->
				<div class="form-group">
					<label for="mb_name"><img src="/img_all/require.png" alt="필수">&nbsp 이름</label><br>
					<input type="text" class="form-control" id="mb_name" name="mb_name" value="${sessionScope.loginStatus.mb_name }" maxlength="30" placeholder="이름을 입력해주세요." style="max-width:350px; display: inline;" required>
				</div>
				<hr>
				<!-- 주소 -->
				<div class="form-group" >
					<label for="inputAddr"><img src="/img_all/require.png" alt="필수">&nbsp 주소</label><br>
					<input type="text" id="sample2_postcode" name="mb_zipcode"  value="${sessionScope.loginStatus.mb_zipcode }" class="form-control" style="max-width: 200px; display: inline-block;" readonly required>
					<input type="button" onclick="sample2_execDaumPostcode()" class="form-control" class="btn btn-outline-dark" 
						style="max-width:150px; margin-right: 5px;  display:inline-block;"  value="우편번호"><br>
					<input type="text" id="sample2_address" name="mb_addr" class="form-control" value="${sessionScope.loginStatus.mb_addr }"
						style="max-width:550px; margin-right: 5px;  display:inline;" readonly required>기본주소<br>
					<input type="text" id="sample2_detailAddress" name="mb_de_addr" class="form-control" value="${sessionScope.loginStatus.mb_de_addr }"
						style="max-width:550px; margin-right: 5px;  display:inline;" required>나머지주소<br>
					<input type="hidden" id="sample2_extraAddress" placeholder="참고항목">
				</div>
				<div id="layer" style="display:none;position:fixed;overflow:hidden;z-index:1;-webkit-overflow-scrolling:touch;">
					<img src="//t1.daumcdn.net/postcode/resource/images/close.png" id="btnCloseLayer" style="cursor:pointer;position:absolute;right:-3px;top:-3px;z-index:1" onclick="closeDaumPostcode()" alt="닫기 버튼">
				</div>
				<hr>
				<!-- 휴대전화 -->
				<div class="form-group">
					<label for="mb_phone"><img src="/img_all/require.png" alt="필수">&nbsp 휴대전화</label><br>
					<input type="text" class="form-control" id="mb_phone" name="mb_phone" value="${sessionScope.loginStatus.mb_phone }" placeholder="핸드폰 번호를 입력해주세요." style="max-width:350px; display: inline;" required>
				</div>
				<hr>
				<!-- 이메일 -->
				<div class="form-group">
					<label for="mb_email"><img src="/img_all/require.png" alt="필수">&nbsp 이메일</label><br>
					<input type="text" class="form-control" id="mb_email" name="mb_email" value="${sessionScope.loginStatus.mb_email }" placeholder="이메일 주소를 입력해주세요." style="max-width:350px; display: inline;" required>
				</div><hr><hr>
				
					<h3>배송정보</h3>
					
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
					<label class="form-check-label" for="defaultCheck1">
						주문고객 정보와 동일
					</label>
				</div> <hr>
				
				<form action="/order/order_buy" id="orderForm" method="post">
					<div class="form-group">
						<input type="hidden" name="prod_num" value="${prod_num }">
						<input type="hidden" name="ord_amount" value="${ord_amount }">
						<input type="hidden" name="ord_price" value="${ord_price }">
						
						<label for="ord_name"><img src="/img_all/require.png" alt="필수">&nbsp 이름</label><br>
						<input type="text" class="form-control" id="ord_name" name="ord_name" value="${sessionScope.loginStatus.mb_name }" maxlength="30" placeholder="이름을 입력해주세요." style="max-width:350px; display: inline;" required>
						<input type="hidden" name="type" value="${type }">
					</div>
						<hr>
						<div class="form-group" >
						<label for="inputAddr">* 주소</label><br>
							<input type="text" id="sample2_postcode" name="ord_zipcode" value="${sessionScope.loginStatus.mb_zipcode }" class="form-control" style="max-width: 200px; display: inline-block;" readonly required>
							<input type="button" onclick="sample2_execDaumPostcode()" class="form-control" class="btn btn-outline-dark" 
								style="max-width:150px; margin-right: 5px;  display:inline-block;"  value="우편번호"><br>
							<input type="text" id="sample2_address" name="ord_addr" class="form-control" value="${sessionScope.loginStatus.mb_addr }"
								style="max-width:550px; margin-right: 5px;  display:inline;" readonly required>기본주소<br>
							<input type="text" id="sample2_detailAddress" name="ord_de_addr" class="form-control" value="${sessionScope.loginStatus.mb_de_addr }"
								style="max-width:550px; margin-right: 5px;  display:inline;" required>나머지주소<br>
							<input type="hidden" id="sample2_extraAddress" placeholder="참고항목">
						</div>
						<div id="layer" style="display:none;position:fixed;overflow:hidden;z-index:1;-webkit-overflow-scrolling:touch;">
							<img src="//t1.daumcdn.net/postcode/resource/images/close.png" id="btnCloseLayer" style="cursor:pointer;position:absolute;right:-3px;top:-3px;z-index:1" onclick="closeDaumPostcode()" alt="닫기 버튼">
						</div>
						<hr>
						<div class="form-group">
							<label for="ord_phone"><img src="/img_all/require.png" alt="필수">&nbsp 휴대전화</label><br>
							<input type="text" class="form-control" id="ord_phone" name="ord_phone" value="${sessionScope.loginStatus.mb_phone }" placeholder="핸드폰 번호를 입력해주세요." style="max-width:350px; display: inline;" required>
						</div>
						<hr>
						<div class="form-group">
							<label for="ord_email"><img src="/img_all/require.png" alt="필수">&nbsp 이메일</label><br>
							<input type="text" class="form-control" id="ord_email" name="ord_email" value="${sessionScope.loginStatus.mb_email }" placeholder="이메일 주소를 입력해주세요." style="max-width:350px; display: inline;" required>
						
							<input type="hidden" name="ord_price" value="${sum }">
						</div>
						<hr>
						
						<div class="form-group text-center">
							<button type="submit" id="btn_submit" class="btn btn-outline-success">
								결제하기 <i class="fa fa-check spaceLeft"></i>
							</button>
							<button type="button" id="btn_cancel" class="btn btn-outline-warning">
								구매취소 <i class="fa fa-check spaceLeft"></i>
							</button>
						</div>
				</form>
				
<!-- iOS에서는 position:fixed 버그가 있음, 적용하는 사이트에 맞게 position:absolute 등을 이용하여 top,left값 조정 필요 -->
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
		</div>
	</div>
</div>

</main>

<script>
	$("#btn_cancel").on("click", function(){
	    var result = confirm("주문을 취소하시겠습니까?");
	
	    if(result){
	        location.href = "/";
	    }else{}
	 });

</script>

</body>
</html>