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
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<%@include file="/WEB-INF/views/common/common.jsp" %>


<script>
	var message = '${status}';
	
	if(message == 'insertSuccess'){
		alert('회원가입을 축하합니다.');
	}else if(message == 'loginSuccess'){
		alert('로그인 되었습니다.');
	}else if(message == 'logout'){
		alert('로그아웃 되었습니다.');
	}else if(message == 'modifySuccess'){
		alert('정보가 수정되었습니다.');
	}else if(message == 'DelSuccess'){
		alert('회원 탈퇴가 되었습니다.');
	}
	
</script>

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
      
      li{
      	list-style: none;
      }
      
      .mySlides {display:none}
      .w3-tag, .fa {cursor:pointer}
	  .w3-tag {height:15px;width:15px;padding:0;margin-top:6px}
    </style>

  </head>
  
  <body>
  
 <!-- header.jsp -->
<%@include file="/WEB-INF/views/common/header.jsp" %>

	<main role="main" class=".container-fluid">
	

<div class="row">
	<!-- 카테고리 목록 -->
	<div class="col-2">
		<%@include file="/WEB-INF/views/common/category_list.jsp" %>	
	</div>



  <!--  콘텐츠 --> 
  <div class="col-9">
  <div class="w3-container" style="display: block;margin: 0 auto;">
    <div class="w3-display-container mySlides">
      <img src="/img_all/main1.PNG" style="width:70%;height: 700px;">
      <div class="w3-display-topleft w3-container w3-padding-32">
      </div>
    </div>
    
    <div class="w3-display-container mySlides" >
      <img src="/img_all/main2.PNG" style="width:70%;height: 700px">
      <div class="w3-display-middle w3-container w3-padding-32">
      </div>
    </div>
    <div class="w3-display-container mySlides">
      <img src="/img_all/main3.PNG" style="width:70%;height: 700px">
      <div class="w3-display-topright w3-container w3-padding-32">
      </div>
    </div>

    <!-- Slideshow next/previous buttons -->
    <div class="w3-container w3-dark-grey w3-padding w3-xlarge" style="width: 70%">
      <div class="w3-left" onclick="plusDivs(-1)"><i class="fa fa-arrow-circle-left w3-hover-text-teal"></i></div>
      <div class="w3-right" onclick="plusDivs(1)"><i class="fa fa-arrow-circle-right w3-hover-text-teal"></i></div>
    
      <div class="w3-center">
        <span class="w3-tag demodots w3-border w3-transparent w3-hover-white" onclick="currentDiv(1)"></span>
        <span class="w3-tag demodots w3-border w3-transparent w3-hover-white" onclick="currentDiv(2)"></span>
        <span class="w3-tag demodots w3-border w3-transparent w3-hover-white" onclick="currentDiv(3)"></span>
      </div>
    </div>
  </div>

</div>
</div>


</main>

<%@include file="/WEB-INF/views/common/footer.jsp" %>
	
<script>
	// Slideshow
	var slideIndex = 1;
	showDivs(slideIndex);
	
	function plusDivs(n) {
	  showDivs(slideIndex += n);
	}
	
	function currentDiv(n) {
	  showDivs(slideIndex = n);
	}
	
	function showDivs(n) {
	  var i;
	  var x = document.getElementsByClassName("mySlides");
	  var dots = document.getElementsByClassName("demodots");
	  if (n > x.length) {slideIndex = 1}    
	  if (n < 1) {slideIndex = x.length} ;
	  for (i = 0; i < x.length; i++) {
	    x[i].style.display = "none";  
	  }
	  for (i = 0; i < dots.length; i++) {
	    dots[i].className = dots[i].className.replace(" w3-white", "");
	  }
	  x[slideIndex-1].style.display = "block";  
	  dots[slideIndex-1].className += " w3-white";
	}
</script>	
	
  </body>
 </html>