<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
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
      }
      
     li{
      	list-style: none;
      }
    </style>

  </head>
<body>


<!-- Main Header -->
<%@include file="/WEB-INF/views/common/header.jsp" %>

<main role="main" class="container">
	<div class="starter-template">
		<div class="row">
    	<div class="col-lg-12">
    		<h1 class="page-header">게시판 글쓰기</h1>
    		<br>
    	</div>
    </div>
    
    <div class="row">
    	<div class="col-lg-12">
    		<div class="panel panel-default">

    			<div class="panel-body">
    				<form id="brdForm" method="post" action="/board/register">
    					 <div class="form-group">
    					 	<label for="brd_title">제목</label>
    					 	<input type="text" name="brd_title" class="form-control" id="brd_title" placeholder="제목을 입력하세요">
    					 </div>
    					 <div class="form-group">
    					 	<label for="brd_content">내용</label>
    					 	<textarea name="brd_content" class="form-control" id="brd_content" rows="10"></textarea>
    					 </div>
						
						<div class="form-group">
							<button type="button" id="btn_register" class="btn btn-primary">등록하기</button>
						</div>
    				</form>
    			</div>
    		</div>
    	</div>
    </div>
    
	</div>
</main>

</body>

<script>
$(document).ready(function(){

    var form = $("#brdForm");
    
    $("#btn_register").on("click", function(){

        var brd_title = $("#brd_title");
        var brd_content = $("#brd_content");

        if(brd_title.val()=="" || brd_title.val()==null){
            alert("제목을 입력하세요!");
            brd_title.focus();
        }else if(brd_content.val()=="" || brd_content.val()==null){
            alert("내용을 입력하세요!");
            brd_content.focus();
        }else{
            form.submit();
        }
    });
});
    </script>

</html>