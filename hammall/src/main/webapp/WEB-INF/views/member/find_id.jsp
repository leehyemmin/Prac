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
  <h2>아이디 찾기</h2>
  <p>회원님의 아이디를 잊으셨나요? 가입하신 정보를 입력해주세요.</p>
</div><hr>

 <div class="wrapper">
	<section class="content container-fluid">
		<div class="container" style="width: 450px; height:620px; background-color: white; margin-top:30px;">	
				
				<label for="mb_name" class="sr-only">이름</label>
				<input type="text" id="mb_name" name="mb_name" class="form-control" placeholder="이름을 입력해주세요." style="margin-bottom: 15px" required autofocus>
				
				<label for="mb_email" class="sr-only">이메일</label>
				<input type="text" id="mb_email" name="mb_email" class="form-control" placeholder="이메일을 입력해주세요." style="margin-bottom: 15px">
				
				<br>
				
				<button id="btn_ID_find" class="btn btn-outline-success">
					아이디 찾기
				</button>
				<button type="button" id="btn_ID_cancle" class="btn btn-outline-warning">
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
    