<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
  <head>
    <title>혜민 플젝</title>
  
<%@include file="/WEB-INF/views/admin/include/head_inc.jsp" %>
 
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
 
  </head>
<body class="hold-transition skin-blue sidebar-mini">

	<div class="wrapper">

		<!-- Main Header -->
		<%@include file="/WEB-INF/views/admin/include/main-header.jsp" %>
			
		<%@include file="/WEB-INF/views/admin/include/main-sidebar.jsp" %>	
			

			
		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>
					매출 통계
				</h1>
			</section>
		
		
	<section class="content container-fluid">
		
		<div class="row">
			<div class="col-lg-12">
				<form id="fromDate" action="/admin/order/order_sale" method="get">
					<c:set var="today" value="<%=new java.util.Date() %>>" />
					<c:set var="year"><fmt:formatDate value="${today}" pattern="yyyy" /></c:set>
					<c:set var="month"><fmt:formatDate value="${today}" pattern="MM" /></c:set>
					
					<select name="year" id="year">
						<c:forEach begin="0" end="2" var="i" step="1">
							<option value='<c:out value="${year-2+i }" />' ${(year-2+i) == sel_year? 'selected' : '' }>
								<c:out value="${year-2+i}" />
							</option>
						</c:forEach>
						
						<c:forEach begin="1" end="2" var="i" step="1">
							<option value='<c:out value="${year+i }" />' ${(year+i) == sel_year ? 'selected' : '' }>
								<c:out value="${year+i }"></c:out>
							</option>
						</c:forEach>
						
					</select>년
					<select name="month" id="month">
						<c:forEach begin="1" end="12" var="i" step="1" >
							<fmt:formatNumber var="dal" minIntegerDigits="2" value="${i }" type="number" />
							<fmt:formatNumber var="cur_month" minIntegerDigits="2" value="${month }" type="number" />
							<option value="${dal}" ${dal == sel_month ? 'selected' : '' }>${dal }</option>
						</c:forEach>
					</select>월
					<button id="btnSearch" type="submit" class="btn btn-primary">검색</button>
					
				</form>
			</div>
		</div>		
		
		<!-- 상품리스트 -->
		<div class="row">
			<div class="col-12">
				<div class="panel panel-default">
					<div class="panel-body">
						<!-- 리스트 -->
						<table class="table table-striped table-dark">
							<thead>
								<tr>
									<th scope="col">일별통계</th>
									<th scope="col">주문건수</th>
								</tr>
							</thead>
							<tbody>	
								<c:forEach items="${order_salelist}" var="OrderSaleDTO">
									<tr>
										<th scope="row">
											${OrderSaleDTO.hiredate}(${OrderSaleDTO.day })
										</th>
										<td>
											${OrderSaleDTO.cnt}
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
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
						
						<hr>
						${pageMaker}

					</div>
				</div>
			</div>
			
			<!-- 페이지번호클릭시, 수정클릭시 상품코드정보추가, 삭제클릭시 상품코드정보추가 -->
		  <form id="actionForm" action="/admin/order/order_list" method="GET">
			<input type="hidden" name="pageNum" value='<c:out value="${pageMaker.cri.pageNum }" />'>
			<input type="hidden" name="amount" value='<c:out value="${pageMaker.cri.amount}" />'>
			<input type="hidden" name="type" value='<c:out value="${pageMaker.cri.type}" />'>
			<input type="hidden" name="keyword" value='<c:out value="${pageMaker.cri.keyword}" />'>
		  </form>
		
	</section>
		

		</div>	
	</div>
			
	<%@include file="/WEB-INF/views/admin/include/scripts.jsp" %>		
			

</body>
</html>