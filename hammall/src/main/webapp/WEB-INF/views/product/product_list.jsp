<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!doctype html>
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
        
       li{
      	list-style: none;
      }
      
      }
    </style>

  </head>
  <body>
    
<!-- header.jsp -->
<%@include file="/WEB-INF/views/common/header.jsp" %>

<main role="main" class=".container-fluid">

<div class="row">
	<div class="col-2">
		<%@include file="/WEB-INF/views/common/category_list.jsp" %>
	</div>
	
  <div class="col-9">
  	 <div class="card-deck mb-3 text-center">
  	 	<c:forEach items="${productVOList}" var="productVO">
  	 		<div class="card mb-4 shadow-sm">
	     	 <div class="card-body">
	     	 	<a href="/product/product_read?prod_num=${productVO.prod_num }">
	     	 		<img src="/product/displayFile?fileName=${productVO.prod_img }">
	     	 	</a>
	     	 	<br>
	     	 	<input type="hidden" name="prod_num" value="${productVO.prod_num }">
	     	 	<span><fmt:formatNumber type="currency" value="${productVO.prod_price }" /></span><hr>
	     	 	
	     	 	<input type="number" style="width: 50px;" name="ord_amount" value="1"> 개<br>
	     	 	
	     	 	<button type="button" name="btn_cart_add" class="btn btn-link">장바구니</button>
	     	 	<button type="button" name="btn_direct_buy" class="btn btn-link">즉시구매</button>
	     	 </div>
	      </div>
	     </c:forEach>
	     <form id="order_direct_form" method="get" action="/order/order">
	     	<input type="hidden" name="type" value="1">
	     </form>
  	 </div>
  </div>
 </div>
 
 
</main>


</body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<script id="subCGListTemplate" type="text/x-handlebars-template">
  {{#each .}}
    <li><a href="2차카테고리 참조하는 상품목록?ctg_code={{ctg_code}}">{{ctg_name}}</a></li>
  {{/each}}
</script>

<script>
	$(document).ready(function(){
		
		$(".mainCategory").on("click",function(){
	    	
		      var mainCategory = $(this);
		      var ctg_code = $(this).find("a").attr("data-code");
		      var url = "/product/subCategoryList/" + ctg_code;

		      // alert(url);

		      // 1차카테고리를 참조하는 2차카테고리
		      $.getJSON(url, function(data){
		        subCGList(data, mainCategory, $("#subCGListTemplate"));
		      });
		    });
		
		
	    // 장바구니 클릭시
	    $("button[name='btn_cart_add']").on("click", function(){

	        var prod_num = $(this).siblings("input[name='prod_num']").val();
	        var prod_amount = $(this).siblings("input[name='ord_amount']").val();

	        $.ajax({
	            url: '/cart/add',
	            type: 'post',
	            data: {prod_num:prod_num, prod_amount:prod_amount},
	            dataType: 'text',
	            success: function(data){
	                if(data == "SUCCESS"){
	                    if(confirm("장바구니에 추가되었습니다. \n 확인하시겠습니까?")){
	                        location.href="/cart/cart_list";
	                    }
	                }else if(data == "LoginRequired"){
	                    alert("로그인이 안되어있습니다.");
	                    location.href="/member/login";
	                }
	            }
	        });
	    });
		
	});
	
	// 즉시구매 클릭시
	$("button[name='btn_direct_buy']").on("click",function(){

      alert("구매하시겠습니까?");
      //console.log("즉시구매");

      // 상품코드, 구매수량

      var prod_num = $(this).parent().find("input[name='prod_num']").val(); //<input type='hidden' name='prod_num' 
      var ord_amount = $(this).parent().find("input[name='ord_amount']").val(); //	<input type="number" name="ord_amount"

      console.log("상품코드: " + prod_num);
      console.log("구매수량: " + ord_amount);


      var order_direct_form = $("#order_direct_form");
      order_direct_form.append("<input type='hidden' name='prod_num' value='" + prod_num + "'>");
      order_direct_form.append("<input type='hidden' name='ord_amount' value='" + ord_amount + "'>");
      
      //return;
      order_direct_form.submit();

    });
	
	
	  var subCGList = function(subCGData, targetSubCategory, templateObject){

		    var template = Handlebars.compile(templateObject.html());
		    var subCGLi = template(subCGData);

		    $(".mainCategory .subCategory").empty();

		    targetSubCategory.find(".subCategory").append(subCGLi);

		  }	
</script>

</html>
 