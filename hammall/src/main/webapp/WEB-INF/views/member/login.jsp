<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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

<script src="/js/member/login.js"></script>
  
  
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
    </style>

  </head>
  <body>
    
<!-- header.jsp -->
<%@include file="/WEB-INF/views/common/header.jsp" %>



<main role="main" class="container">

 
 <div class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
  <h1 class="display-4">Log In</h1>
</div>

 <div class="wrapper">
 
	<section class="content container-fluid">
		<div class="container" style="width: 450px; height:620px; background-color: white; margin-top:30px;">	
			<form id="loginForm" class="form-signin" action="/member/loginPost" method="post" style="padding:50px 30px;">
				
				<label for="inputId" class="sr-only">ID</label>
				<input type="text" id="mb_id" name="mb_id" class="form-control" style="margin-bottom: 15px" placeholder="아이디" required autofocus>
			
				<label for="inputPassword" class="sr-only">Password</label>
				<input type="password" id="mb_pw" name="mb_pw" class="form-control" placeholder="비밀번호" required>
			
				<br>
				
				<div class="checkbox">
					<label> <input type="checkbox" name="idSaveCheck" id="idSaveCheck" />아이디 저장</label>
				</div>
				<div style="text-align: center;">
					<a href="/member/join">회원가입</a> <span>&nbsp|&nbsp</span>
					<a href="/member/find_id">아이디찾기</a><span>&nbsp|&nbsp</span>
					<a href="/member/find_pwd">비밀번호찾기</a>
				</div>
				<button type="button" id="btn_login" class="btn btn-lg btn-outline-primary btn-block">
					로그인
				</button>
			</form>		
		</div>
	</section>
 </div>

</main>

      
  </body>
</html>
    