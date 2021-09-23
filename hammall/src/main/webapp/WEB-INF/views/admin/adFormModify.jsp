<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
    
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>
<head>
<!-- css file -->
<%@include file="/WEB-INF/views/admin/include/head_inc.jsp" %>
<script src="/ckeditor/ckeditor.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>


</head>

<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">

		<!-- Main Header -->
			<%@include file="/WEB-INF/views/admin/include/main-header.jsp" %>
			
		
		<!-- Left side column. contains the logo and sidebar -->
			<%@include file="/WEB-INF/views/admin/include/main-sidebar.jsp" %>


		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>
					관리자 수정
				</h1>
			
				<ol class="breadcrumb">
					<li>
						<a href="#"><i class="fa fa-dashboard"></i> Level</a>
					</li>
					<li class="active">Here</li>
				</ol>
			</section>

<br><br>
	<!-- 아이디 -->
	<form id="adFormModify" style="margin: 30px;" action="/admin/adFormModify" method="post">
	<div class="form-group" style="width:100%;">
		<label for="inputPWCheck">* 아이디</label><br>
		<input type="text" class="form-control" id="admin_id" name="admin_id" readonly value='<c:out value="${vo.admin_id }"/>'
				style="max-width:350px; margin-right: 5px;  display: inline;">
	</div>
	<!-- 비밀번호 -->
	<div class="form-group">
		<label for="inputPWCheck">* 비밀번호</label><br>
		<input type="password" class="form-control" id="admin_pw" name="admin_pw" maxlength="16" placeholder="바꾸실 비밀번호를 입력해주세요." style="max-width:350px; display: inline;">
	</div>
	<!-- 이름 -->
	<div class="form-group">
		<label for="inputName">* 이름</label><br>
		<input type="text" class="form-control" id="admin_name" name="admin_name"
		value='<c:out value="${vo.admin_name }"/>' maxlength="30" style="max-width:350px; display: inline;">
	</div>
	
	<br><br>
	
	<div class="form-group text-center">
		<button type="button" id="btn_submit" class="btn btn-outline-success">
		 정보수정 <i class="fa fa-check spaceLeft"></i>
		</button>
		<button type="button" id="btn_cancle" class="btn btn-outline-warning">
			취소 <i class="fa fa-check spaceLeft"></i>
		</button>
	</div>
	
	</form>
	</div>
	
		<!-- Main Footer -->
			<%@include file="/WEB-INF/views/admin/include/main-footer.jsp" %>
			
		<div class="control-sidebar-bg"></div>
	</div>


	<%@include file="/WEB-INF/views/admin/include/scripts.jsp" %>
	
<script>
$(document).ready(function(){
    var form = $("#adFormModify");

    $("#btn_submit").on("click", function(){
        var admin_pw = $("#admin_pw");
        var admin_name = $("#admin_name");

        if(admin_pw.val()==null || admin_pw.val()==""){
            alert("비밀번호를 입력해주세요.");
            admin_pw.focus();
        }else if(admin_name.val()==null || admin_name.val()==""){
            alert("이름을 입력해주세요.");
            admin_name.focus();
        }else{
            form.submit();
        }
    });

    $("#btn_cancle").on("click", function(){
        var result = confirm("수정을 취소하시겠습니까?");

        if(result){
            location.href="/admin/admin_process";
        }else{}
    });
});
</script>	
	
	</body>
</html>
	