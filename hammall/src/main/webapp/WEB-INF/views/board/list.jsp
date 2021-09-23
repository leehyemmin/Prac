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
			

		<div class="col-lg-12">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<br>
				<h3>
					게시판
				</h3>
				
			</section>
		</div>	

		<!-- Main content -->
		<section class="content container-fluid">


		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
				<div class="panel-heading">
    			<button id="regBtn" type="button" class="btn btn-outline-primary" style="float: right;margin:10px">글쓰기</button>
    			<br>
    			</div>
				
					<div class="panel-body">
						<!-- 리스트 -->
						<table class="table table-striped">
							<thead>
								<tr>
									<th scope="col">번호</th>
									<th scope="col">제목</th>
									<th scope="col">작성자</th>
									<th scope="col">작성일</th>
									<th scope="col">수정일</th>
								</tr>
							</thead>
							<tbody>
								
								<c:forEach items="${list}" var="BoardVO">
									<tr>
										<th scope="row"><c:out value="${BoardVO.brd_num}" /></th>
										<td><a class="move" href="${BoardVO.brd_num}"><c:out value="${BoardVO.brd_title}" /></a></td>
										<td><c:out value="${BoardVO.mb_id }" /></td>
										<td><fmt:formatDate pattern="yyyy-MM-dd" value="${BoardVO.brd_reg_date }" /></td>
										<td><fmt:formatDate pattern="yyyy-MM-dd" value="${BoardVO.updateDate }" /></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		
		<br>
		<hr>
		
	    <!-- 검색 / 페이징 -->
	    <div class="row">
	    	<div class="col-lg-12">
	    		<form id="searchForm" action="/board/list" method="get">
	    			<select name="type" id="type">
	    				<option value="" <c:out value="${pageMaker.cri.type == null ? 'selected':''}" />>--</option>
	    				<option value="T" <c:out value="${pageMaker.cri.type == 'T' ? 'selected':''}" />>제목</option>
	    				<option value="C" <c:out value="${pageMaker.cri.type == 'C' ? 'selected':''}" />>내용</option>
	    				<option value="W" <c:out value="${pageMaker.cri.type == 'W' ? 'selected':''}" />>작성자</option>
	    				<option value="TC" <c:out value="${pageMaker.cri.type == 'TC' ? 'selected':''}" />>제목 or 내용</option>
	    				<option value="TW" <c:out value="${pageMaker.cri.type == 'TW' ? 'selected':''}" />>제목 or 작성자</option>
	    				<option value="TCW" <c:out value="${pageMaker.cri.type == 'TCW' ? 'selected':''}" />>제목 or 내용 or 작성자</option>
	    			</select>
	    			<input type="text" name="keyword" value="${pageMaker.cri.keyword }">
	    			<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum }">
	    			<input type="hidden" name="amount" value="${pageMaker.cri.amount }">
	    			<button id="btnSearch" class="btn btn-outline-primary" type="button">Search</button>
	    		</form>
	    	</div>
	    </div>		

			<div class="row">
				<div class="col-lg-12">
					<!-- 페이징 표시 -->
					<div class="panel-footer">
						<ul class="pagination">
							<c:if test="${pageMaker.prev }">
								<li class="page-item"><a
									href="${pageMaker.startPage - 1 }" class="page-link" href="#"
									tabindex="-1">Prev</a></li>
							</c:if>
							<c:forEach begin="${pageMaker.startPage}"
								end="${pageMaker.endPage}" var="num">
								<li class='page-item ${pageMaker.cri.pageNum == num ? "active" :""}'>
									<a href="${num}" class="page-link" href="#">${num}</a>
								</li>
							</c:forEach>
							<c:if test="${pageMaker.next }">
								<li class="page-item"><a href="${pageMaker.endPage + 1 }"
									class="page-link" href="#">Next</a></li>
							</c:if>
						</ul>
					</div>
				</div>
			</div>

	    <form id="actionForm" action="/board/list" method="GET">
			<input type="hidden" name="pageNum" value='<c:out value="${pageMaker.cri.pageNum }" />'>
			<input type="hidden" name="amount" value='<c:out value="${pageMaker.cri.amount}" />'>
			<input type="hidden" name="type" value='<c:out value="${pageMaker.cri.type}" />'>
			<input type="hidden" name="keyword" value='<c:out value="${pageMaker.cri.keyword }" />'>
		</form>

			</section>



		<!-- footer -->


<script>
		$(document).ready(function(){
			$("#regBtn").click(function(){
				window.location.href = "register";
			});
		});
</script>

<script>

$(document).ready(function(){
	
    var result = "${result}";
    if(result == 'modify'){
        alert('수정되었습니다.');
    }else if(result == 'remove'){
        alert('제거되었습니다.');
    }

    var searchForm = $("#searchForm");
    var actionForm = $("#actionForm");

    // 제목 클릭시 다음주소로 이동
    $(".move").on("click", function(e){
        e.preventDefault();
        actionForm.append("<input type='hidden' name='brd_num' value='" + $(this).attr("href") + "'>");
        actionForm.attr("action", "/board/get");
        actionForm.submit();
    });
    
 	// [prev] 1 2 3 4 5 [next]
	$(".page-item a").on("click", function(e){
		e.preventDefault();

		console.log("click");

		actionForm.find("input[name='pageNum']").val($(this).attr("href"));
		actionForm.submit();

	});
 	
 	
	$("#searchForm #btnSearch").on("click", function(e){
		if(!searchForm.find("option:selected").val()){
			alert("검색종류를 선택하세요");
			return false;
		}

		if(!searchForm.find("input[name='keyword']").val()){
			alert("검색어를 입력하세요");
			return false;
		}

		// 검색시 페이지를 1로 시작해야 한다.
		// 리스트에서 변경된 페이지번호가 사용하여 검색결과가 안나올 수 있다.
		searchForm.find("input[name='pageNum']").val("1");

		e.preventDefault();

		searchForm.submit();
		
	});

});


</script>


</body>
</html>