<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  
   
<style>

	.text-dark{
		font-size: 13px;
	    margin-block-start: 1em;
	    margin-block-end: 1em;
	    margin-inline-start: 0px;
	    margin-inline-end: 0px;
	    margin-bottom: 7px;
    	margin-top: -1px;
	}

</style>

<div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm" >
  <a class="my-0 mr-md-auto font-weight-normal" href="/" style="color:#ffc107"> HAM MALL </a>
  <nav class="my-2 my-md-0 mr-md-3">
    
    <!-- 인증 전 표시 -->
    <c:if test="${sessionScope.loginStatus == null }">
    <a class="p-2 text-dark" href="/member/login">로그인</a>
    <span>&nbsp|&nbsp</span>
    <a class="p-2 text-dark" href="/member/join">회원가입</a>
  	</c:if>
    
    
    <!-- 인증 후 표시 -->
    <c:if test="${sessionScope.loginStatus != null }">
    <span style="font-size: 13px;">
   		<strong>
   			<span>
   				${sessionScope.loginStatus.mb_name}
   			</span>
   		</strong>
   		님 환영합니다.
    </span>
    <a class="p-2 text-dark" href="/member/logout">로그아웃</a>
    <a class="p-2 text-dark" href="/member/modifyForm">프로필수정</a>
    <a class="p-2 text-dark" href="/cart/cart_list">장바구니</a>
    <a class="p-2 text-dark" href="/order/mb_order_list">주문조회</a>
    <a class="p-2 text-dark" id="/member/board" href="/board/list">게시판</a>
    </c:if>
  </nav>
</div>






