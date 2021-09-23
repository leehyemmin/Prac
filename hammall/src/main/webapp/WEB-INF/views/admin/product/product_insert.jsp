<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
    
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
					상품 관리
				</h1>
				<ol class="breadcrumb">
					<li>
						<a href="#"><i class="fa fa-dashboard"></i> Level</a>
					</li>
					<li class="active">Here</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class="content container-fluid">

				<!-- 상품등록 폼 -->
				<div class="row">
					<!-- left column -->
					<div class="col-md-12">
						<!-- general form elements -->
						<div class="box box-primary">
							<div class="box-header">
								<h3 class="box-title">상품 등록하기</h3>
							</div>
							<!-- /.box-header -->

							<form id='registerForm' role="form" action="/admin/product/insert" method="post" enctype="multipart/form-data">
								<div class="box-body">
									<div class="form-group">
										<label for="exampleInputctg_prt_code" style="width:30%; margin-right:20px;" >1차 카테고리</label>
										<label for="exampleInputctg_code" style="width:30%;" >2차 카테고리</label> <br />
										
										<select class="form-control" id="mainCategory" name="ctg_prt_code" style="width:30%; margin-right:10px; display: inline-block;" required>
										  <option value="default">1차 카테고리 선택</option>
										  <c:forEach items="${categoryList}" var="cate">
										  	<option value="<c:out value="${cate.ctg_code }" />"><c:out value="${cate.ctg_name }" /></option>
										  </c:forEach>
										</select>
										
										<select class="form-control" id="subCategory" name="ctg_code" style="width: 30%; display: inline-block;" required>
										 	<option value="default">2차 카테고리 선택</option>
										</select>
									</div>
									<div class="form-group">
										<label for="exampleInputName">Product Name</label> <input
											type="text" id="prod_name" name="prod_name" class="form-control"
											placeholder="상품 이름을 입력하세요.">
									</div>
									<div class="form-group">
										<label for="exampleInputCompany">Company</label> <input
											type="text" id="prod_company" name="prod_company" class="form-control"
											placeholder="회사를 입력하세요.">
									</div>
									<div class="form-group">
										<label for="exampleInputColor" style="width:40%; margin-right:10px;">Color</label> 
										<label for="exampleInputSize" style="width:40%;">Size</label>
										<input style="width:40%; margin-right:10px; display: inline-block;"
											type="text" id="prod_color" name="prod_color" class="form-control" 
											placeholder="컬러을 입력하세요." />
										<input style="width:40%; display: inline-block;"
											type="text" id="prod_size" name="prod_size" class="form-control "
											placeholder="사이즈를 입력하세요." />
									</div>
									<div class="form-group">
										<label for="exampleInputPrice" style="width:40%; margin-right:10px;">Price</label> 
										<label for="exampleInputDiscount" style="width:40%;">Discount</label> 
										<input style="width:40%; margin-right:10px; display: inline-block;"
											type="text" id="prod_price" name="prod_price" class="form-control" 
											placeholder="가격을 입력하세요." />
										<input style="width:40%; display: inline-block;"
											type="text" id="prod_discount" name="prod_discount" class="form-control "
											placeholder="할인 가격을 입력하세요." />
									</div>
									<div class="form-group">
										<label for="exampleInputDetail">Detail</label>
										<textarea class="form-control" id="prod_detail" name="prod_detail" rows="8"
											placeholder="Enter ..."></textarea>
									</div>

									<div class="form-group">
										<label for="exampleInputThumbnail">Thumbnail Image</label> <input
											type="file" id="file1" name="file1" class="form-control" />
									</div>
									
									<div class="form-group">
										<label for="exampleInputAmount" style="width:30%; margin-right:10px;">Amount</label> 
										<label for="exampleInputBuyAvail" style="width:15%;">Buy availability</label><br /> 
										<input style="width:30%; margin-right:10px; display: inline-block;"
											type="text" id="prod_amount" name='prod_amount' class="form-control" 
											placeholder="수량을 입력하세요." />
										<select class="form-control" id="prod_buy" name="prod_buy" style="width: 15%; display: inline-block;">
										  <option>Y</option>
										  <option>N</option>
										</select>
									</div>
								</div>

								<!-- /.box-body -->

								<div class="box-footer">
									<div>
										<hr>
									</div>

									<ul class="mailbox-attachments clearfix uploadedList">
									</ul>

									<button id="btn_submit" type="button" class="btn btn-primary">상품등록</button>

								</div>
							</form>


						</div>
						<!-- /.box -->	
					</div>
					<!--/.col (left) -->

				</div>

			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->
		</div>

		<!-- Main Footer -->
		<%@include file="/WEB-INF/views/admin/include/main-footer.jsp" %>
		
		<%@include file="/WEB-INF/views/admin/include/scripts.jsp" %>
			
<script>
	$(document).ready(function(){
	    /* ckEditor 작업 */
			// config.js를 사용하지 않고 개별 설정하는 부분
			var ckeditor_config = {
	            resize_enabled : false,
	            enterMode : CKEDITOR.ENTER_BR,
	            shiftEnterMode : CKEDITOR.ENTER_P,
	            toolbarCanCollapse : true,
	            removePlugins : "elementspath", 
	            // 파일 업로드 기능 추가
	            // CKEditor를 이용해 업로드 사용 시 해당 주소에 업로드 됨
	            filebrowserUploadUrl: '/admin/product/imgUpload'
	    };
	    CKEDITOR.replace("prod_detail", ckeditor_config);
	    // config.js의 설정을 사용하려면, 다음과 같이 사용
	    // CKEDITOR.replace("desc", "");
	
	    // 1차 카테고리 선택
	    $("#mainCategory").on("change", function(){
	        var mainCategoryCode = $(this).val();
	        var url = "/admin/product/subCategoryList/" + mainCategoryCode;
	
	        $.getJSON(url, function(subCGListData){
	
	            // 2차 카테고리 추가작업
	            subCategoryList(subCGListData, $("#subCategory"), $("#subCGListTemplate"));
	        });
	    });
	});
</script>

<script>
	var subCategoryList = function(subCGListData, subCategoryTarget, subCategoryTemplate){
	    var subCGTemplate = Handlebars.compile(subCategoryTemplate.html());
	    var options = subCGTemplate(subCGListData);
	
	    $("#subCategory option").remove(); // 기본 option태그 제거
	    subCategoryTarget.append(options); // 새로운 2차 카테고리 option태그 추가
	}
</script>

<script id="subCGListTemplate" type="text/x-handlebars-template">
	<option value="default">2차카테고리 선택</option>
	{{#each .}}
	<option value="{{ctg_code}}">{{ctg_name}}</option>
	{{/each}}
</script>


<script src="/js/admin/product/insert.js"></script>


   </body>
  </html>