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
					회원 관리
				</h1>
			</section>

		<!-- Main content -->
		<section class="content container-fluid">


		<!-- 회원리스트 -->
		<div class="row">
			<div class="col-12">
				<div class="panel panel-default">
					<div class="panel-body">
						<!-- 리스트 -->
						<table class="table table-striped table-dark">
							<thead>
								<tr>
									<th scope="col">아이디</th>
									<th scope="col">이름</th>
									<th scope="col">휴대전화</th>
									<th scope="col">이메일</th>
									<th scope="col">전자우편</th>
									<th scope="col">주소</th>
									<th scope="col">나머지주소</th>
								</tr>
							</thead>
							<tbody>
								<c:set var="i" value="${cri.pageNum * 1 }" />
								<c:forEach items="${user_list}" var="userVO" varStatus="status">
									<tr>
										<th scope="row"><c:out value="${userVO.user_id }" /></th>
										<th scope="row"><c:out value="${userVO.user_name }" /></th>
										<th scope="row"><c:out value="${userVO.user_phone }" /></th>
										<th scope="row"><c:out value="${userVO.user_email }" /></th>
										<th scope="row"><c:out value="${userVO.user_zipcode }" /></th>
										<th scope="row"><c:out value="${userVO.user_addr }" /></th>
										<th scope="row"><c:out value="${userVO.user_de_addr }" /></th>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>


			</section>
		</div>
		
	</div>
	
	<%@include file="/WEB-INF/views/admin/include/scripts.jsp" %>
	
	
</body>
</html>