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

<%@include file="/WEB-INF/views/common/header.jsp" %>

<main role="main" class="container">
	
	<div class="starter-template">
		<div class="row">
	    	<div class="col-lg-12">
	    		<h1 class="page-header">게시판</h1>
	    		<br>
	    	</div>
    	</div>
	</div>
	
	<div class="row">
    	<div class="col-lg-12">
    		<div class="panel panel-default">
    			
    			<div class="panel-body">
    				 <div class="form-group">
    					 	<label for="brd_num">번호</label>
    					 	<input type="text" name="brd_num" value='<c:out value="${board.brd_num}" />' class="form-control"  readonly>
    				 </div>
    				 <div class="form-group">
    					 	<label for="brd_title">제목</label>
    					 	<input type="text" name="brd_title" value='<c:out value="${board.brd_title}" />' class="form-control"  readonly>
    				 </div>
    				  <div class="form-group">
    					 	<label for="brd_content">내용</label>
    					 	<textarea name="brd_content" rows="10" class="form-control"  readonly><c:out value="${board.brd_content}" /></textarea>
    				 </div>
    				 <div class="form-group">
    					 	<label for="mb_id">아이디</label>
    					 	<input type="text" name="mb_id" value='<c:out value="${board.mb_id}" />' class="form-control"  readonly>
    				 </div>
    				 
    				 <div class="form-group">
							<button type="button" id="btn_Modify" class="btn btn-primary">수정하기</button>
							<button type="button" id="btn_List" class="btn btn-primary">목록</button>
					</div>
					
					<form id="modifyForm" action="/board/modify" method="get">
						<input type="hidden" id="brd_num" name="brd_num" value='<c:out value="${board.brd_num }" />'>
						<input type="hidden" id="pageNum" name="pageNum" value='<c:out value="${cri.pageNum }" />'>
						<input type="hidden" id="amount" name="amount" value='<c:out value="${cri.amount }" />'>
						<input type="hidden" id="type" name="type" value='<c:out value="${cri.type }" />'>
						<input type="hidden" id="keyword" name="keyword" value='<c:out value="${cri.keyword }" />'>
					</form>
    			</div>
    		</div>
    	</div>
    </div>
</main>

<script>
	$(document).ready(function(){
	
	    var form = $("#modifyForm");
	
	    // 리스트버튼 클릭시
	    $("#btn_List").on("click", function(){
	        form.attr("action", "/board/list");
	        form.submit();
	    });
	
	    // 수정버튼 클릭시
	    $("#btn_Modify").on("click", function(){
	        form.attr("action", "/board/modify").submit();
	    });
	});
</script>



</body>
</html>