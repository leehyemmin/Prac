<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!doctype html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.80.0">
    <title>혜민플젝</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.6/examples/sign-in/">

    

    <!-- Bootstrap core CSS -->
<%@include file="/WEB-INF/views/common/common.jsp" %>
<link rel="stylesheet" href="/resources/signin.css">

<script src="/js/admin/adLogin.js"></script>

    <!-- Favicons -->
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

<script>
	var msg = '${msg}';
	
	if(msg == 'Fail'){
		alert('로그인에 실패했습니다. \n 아이디와 비밀번호를 확인하세요.');
	}else if(msg == 'logout'){
		alert('로그아웃 하셨습니다.');
	}
</script>
    
  </head>
  <body class="text-center">
   
    
<form class="form-signin" action="/admin/admin_check" method="post">
  <h1 class="h3 mb-3 font-weight-normal">관리자 로그인</h1>
  <label for="inputID" class="sr-only">Admin ID</label>
  <input type="text" id="inputID" name="admin_id" class="form-control" placeholder="Admin ID" required autofocus>
  
  <label for="inputPassword" class="sr-only">Password</label>
  <input type="password" id="inputPassword" name="admin_pw"  class="form-control" placeholder="Password" required>
  
  <div class="checkbox mb-3">
    <label>
      <input type="checkbox" name="idSaveCheck" id="idSaveCheck"> 아이디 저장
    </label>
  </div>
  <button class="btn btn-lg btn-outline-success btn-block" type="submit">Login</button>
  <p class="mt-5 mb-3 text-muted">&copy; 2020-2021</p>
</form>

    
  </body>
</html>
    