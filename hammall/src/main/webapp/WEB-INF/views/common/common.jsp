<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!-- Latest compiled and minified CSS -->
<!-- 
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
<link rel="stylesheet" href="/resources/starter-template.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<!--
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>   
 

<!--
<script>
//ajax 전송 전
$(document).ajaxSend(function(event, request, settings) {
	console.log("ajax 전송 전");	
	request.setRequestHeader('AJAX', 'true');
});

// ajax 에러처리
$(document).ajaxError(function(event, request, settings, thrownError) {
  
	alert(request.status);
	if (request.status == -1 || request.status == 0) {
    alert('세션이 종료 되었습니다. 다시 로그인 해주세요.');
    location.href =  '/member/login';  // contextPath
  } else {
    alert('다음 위치에서 에러가 발생하였습니다. 관리자에게 문의해주세요.\n' + settings.url);
  };
});

</script>
   -->