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
 
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
  
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
				<h3>
					주문 목록
				</h3>
			</section>
		</div>	

		<!-- Main content -->
		<section class="content container-fluid">



		<!-- 상품리스트 -->
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-body">
						<!-- 리스트 -->
						<table class="table table-striped">
							<thead>
								<tr>
									<th scope="col">번호</th>
									<th scope="col">주문일시</th>
									<th scope="col">주문번호</th>
									<th scope="col">수령인</th>
									<th scope="col">주소</th>
									<th scope="col">금액</th>
								
								</tr>
							</thead>
							<tbody>
								<c:set var="i" value="${cri.pageNum * 1 }" />
								<c:forEach items="${mb_order_list}" var="orderVO" varStatus="status">
									<tr>
										<td>
											${(cri.pageNum - 1) * cri.amount + status.count}
										</td>
										<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${orderVO.ord_date }" /></td>
										<td>
											${orderVO.ord_code }
											<button type="button" name="btn_order_detail" data-ord_code="${orderVO.ord_code }" class="btn btn-link">주문 상세</button>
										</td>
										<td>${orderVO.ord_name }</td>
										<td>
											(${orderVO.ord_zipcode}) ${orderVO.ord_addr} ${orderVO.ord_de_addr}
										</td>
										<td>
											<p id="total_price"></p>
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

					</div>
				</div>
			</div>

		  <!-- 페이지번호클릭시, 수정클릭시 상품코드정보추가, 삭제클릭시 상품코드정보추가 -->
		  <form id="actionForm" action="/order/mb_order_list" method="GET">
			<input type="hidden" name="pageNum" value='<c:out value="${pageMaker.cri.pageNum }" />'>
			<input type="hidden" name="amount" value='<c:out value="${pageMaker.cri.amount}" />'>
		  </form>

			</section>



		<!-- footer -->






<!-- REQUIRED JS SCRIPTS -->
<%@include file="/WEB-INF/views/admin/include/scripts.jsp" %>

<script>

$(document).ready(function(){

    $("button[name='btn_order_detail']").on("click", function(){
        // console.log("주문상세보기");

        // 파라미터 : 주문번호
        var ord_code = $(this).attr("data-ord_code");

        console.log(ord_code);

        var current_tr = $(this).parents("tr");
        var total_price = 0;

        $.ajax({
         url: '/order/mb_deorder_list',
         type: 'get',
         data: {ord_code : ord_code},
         dataType: 'json',
         success: function(data){

            for(i=0; i<data.length; i++){
               total_price += parseInt(data[i].ord_price)
           }

             // alert(total_price);
            $("#total_price").html(total_price);
             // alert(data.length);
             
             // 함수호출
             MdorderDetailView(data, current_tr, $("#MdorderDetailTemplate"));
         }
        });
     });

});


	var MdorderDetailView = function(MdorderDetailDate, MdorderDetailTarget, MdorderDetailTemplate){
    var detailTemplate = Handlebars.compile(MdorderDetailTemplate.html());
    var details = detailTemplate(MdorderDetailDate);

    console.log(details);

    $(".mb_order_detail").remove(); // 기존 option 태그 제거
    MdorderDetailTarget.after(details);
}
</script>

<script id="MdorderDetailTemplate" type="text/x-handlebars-template">
	<tr class="mb_order_detail" style="border-bottom-style: ridge;"><td colspan="8">주문상세내역</td></tr>
	<tr class="mb_order_detail">
		<th>주문번호</th><th>상품명</th><th>수량</th><th>상품가격</th><th>소계</th><th> </th>
	</tr>
	{{#each .}}
	<tr class="mb_order_detail" style="border-style: ridge; border-color: cornflowerblue;">
		<td>{{ord_code}}</td>
		<td>
			<img src="/order/displayFile?fileName={{prod_img}}">
			{{prod_name}}
		</td>
		<td>{{ord_amount}}</td>
		<td>{{ord_price}}</td>
		<td>{{total_price ord_price ord_amount}}</td>
		<td> </td>
	</tr>
	{{/each}}

</script>

<script>
// 핸들바의 사용자정의 함수
Handlebars.registerHelper("total_price", function(ord_price, ord_amount){
	
	return ord_price * ord_amount;
});

</script>

<script>
$(document).ready(function(){

    var actionForm = $("#actionForm");

    // 페이지번호 클릭
    $(".page-item a").on("click", function(e){
        e.preventDefault();

        // console.log("click");

        actionForm.find("input[name='pageNum']").val($(this).attr("href"));
        actionForm.submit();
    });
});
</script>

</body>
</html>