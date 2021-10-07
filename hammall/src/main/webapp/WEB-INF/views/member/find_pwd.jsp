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

<script src="/js/member/find_id_pw.js"></script>

  
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
  <h2>비밀번호 찾기</h2>
  <p>회원님의 비밀번호를 잊으셨나요? 가입하신 정보를 입력해주세요.</p>
</div><hr>

 <div class="wrapper">
	<section class="content container-fluid">
		<div class="container" style="width: 450px; height:620px; background-color: white; margin-top:30px;">	
				
				<label for="mb_id" class="sr-only">아이디</label>
				<input type="text" id="mb_id" name="mb_id" class="form-control" placeholder="아이디" style="margin-bottom: 15px" required autofocus>
				
				<label for="mb_name" class="sr-only">이름</label>
				<input type="text" id="mb_name" name="mb_name" class="form-control" placeholder="이름" style="margin-bottom: 15px" required>
			
				
				<br>
				
				<button type="button" id="btn_PW_find" class="btn btn-outline-success">
					비밀번호 찾기
				</button>
				<button type="button" id="btn_PW_cancle" class="btn btn-outline-warning">
					홈으로 
				</button>
				<hr>
				<p id="result" style="color:green; text-align: center;"></p>
		</div>
	</section>
 </div>

</main>

      
  </body>
</html>
    