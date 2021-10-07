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
      }
      
      /* 상품후기 별평점 */
      #star_grade a{
     	font-size:22px;
        text-decoration: none;
        color: lightgray;
    }
    #star_grade a.on{
        color: black;
    }
    
    #star_grade_modal a{
     	font-size:22px;
        text-decoration: none;
        color: lightgray;
    }
    #star_grade_modal a.on{
        color: black;
    }
    
    .popup {position: absolute;}
    .back { background-color: gray; opacity:0.5; width: 100%; height: 300%; overflow:hidden;  z-index:1101;}
    .front { 
       z-index:1110; opacity:1; boarder:1px; margin: auto; 
      }
     /*
     .show{
       position:relative;
       max-width: 1200px; 
       max-height: 800px; 
       overflow: auto;       
     } 
     */
    </style>

  </head>
  <body>
    
<!-- header.jsp -->
<%@include file="/WEB-INF/views/common/header.jsp" %>

<!-- handlebars.js 참조 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>



<main role="main" class=".container-fluid">

<div class="row">
	<div class="col-2">
		<%@include file="/WEB-INF/views/common/category_list.jsp" %>
	</div>
		
	<div class="col-10">
	  	<!-- 상품상세설명 -->
	  	<!--  <img src="/product/displayFile?fileName=${ProductVO.prod_img }"> -->
	  <div class="row no-gutters border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
        
        <div class="col-auto d-none d-lg-block">
        	<img src="/product/displayFile?fileName=${productVO.prod_img }" style="width:200; height:250;">
        </div>
        
        <div class="col p-4 d-flex flex-column position-static">
          <h2 class="d-inline-block mb-2 text-primary">${productVO.prod_name }</h2>
          
          price	<strong class="d-inline-block mb-2 text-primary">${productVO.prod_price }</strong>
          discount	<strong class="d-inline-block mb-2 text-primary">${productVO.prod_discount }</strong>
          color	<strong class="d-inline-block mb-2 text-primary" >${productVO.prod_color }</strong>
          size	<strong class="d-inline-block mb-2 text-primary">${productVO.prod_size }</strong>
          company	<strong class="d-inline-block mb-2 text-primary">${productVO.prod_company }</strong>
          수량 <input type="text" value="${productVO.prod_amount }" id="prod_amount" name="prod_amount" style="max-width: 200px;">
          <br>
		  <button type="button" id="btnCart" class="btn btn-light" style="width: 450px;">장바구니</button>
	      <button type="button" id="btnOrder" class="btn btn-light" style="width: 450px;">즉시구매</button>
	      <button type="button" id="btnReview" class="btn btn-light" style="width: 450px;">상품후기</button>
        </div>
        <form id="order_direct_form" method="get" action="/order/order"> 
          <input type="hidden" name="type" value="1">
        </form>
       
        <!-- 상세설명 -->
        <div class="row">
        	<p class="card-text mb-auto">${ProductVO.prod_detail }</p>
        </div>
      </div>
    </div>
</div>

<!--  상품후기 목록-->
	<div class="row">
    <div class="col-2">
      &nbsp;
    </div>
		<div class="col-7">
    		<div class="panel panel-default">
    			<div class="panel-heading">
    			 <b>[Review List]</b>
    			</div>
    			
    			<!-- 상품후기 목록위치 -->
    			<div class="panel-body" id="reviewListView"></div>
				<!-- 페이징 위치 -->
				<div class="panel-footer" id="reviewPaging"></div>
			</div>
		</div>
	</div>
  
</main><!-- /.container -->

<!-- 상품후기 모달대화상자 : 후기쓰기, 후기수정, 후기삭제 -->
<div class="modal fade" id="reviewModal" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		 <div class="modal-content">
		 	<div class="modal-header">
		 		<h5 class="modal-title" id="modalLabel">Review</h5>
		 		
		 		<button type="button" class="close" data-dismiss="modal" aria-label="Close">
		 			<span aria-hidden="true">&times;</span>
		 		</button>
		 	</div>
		 	
		 	<div class="modal-body">
		 		<div class="form-group">
		 			<label for="review">상품후기 평점</label><br>
		 				<div class="rating">
		 					<p id="star_grade">
		 						<a href="#">★</a>
		 						<a href="#">★</a>
		 						<a href="#">★</a>
		 						<a href="#">★</a>
		 						<a href="#">★</a>
		 					</p>
		 				</div>
		 		</div>
		 		
		 		 <div class="form-group">
		 		 	<label>상품후기</label>
		 		 	<input type="hidden" class="form-control" name="prod_num" id="prod_num" value="${productVO.prod_num }">
		 		 	<input type="hidden" name="rev_num" id="rev_num">
		 		 	<textarea class="form-control" name="rev_content" id="rev_content" style="height: 100px; resize: none;"></textarea>
		 		 	<span class="txsub">
		 		 		남은 글자수 :
		 		 		<input type="text" readonly value="100" name="counter" id="counter">
		 		 	</span>
		 		 </div>
		 	</div>
		 	
		 	<div class="modal-footer">
		 		<button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
		 		<button type="button" id="btnReviewAdd" class="btn btn-primary btnModal">상품후기 등록</button>
		 		<button type="button" id="btnReviewEdit" class="btn btn-primary btnModal">상품후기 수정</button>
		 		<button type="button" id="btnReviewDel" class="btn btn-primary btnModal">상품후기 삭제</button>
		 	</div>
		 </div>
	</div>
</div>


<!-- footer -->





<script>
$(document).ready(function(){

	// 장바구니 클릭시
    $("#btnCart").on("click", function(){
        console.log("장바구니");
        
       var prod_num = ${productVO.prod_num};
       var prod_amount = $("#prod_amount").val();

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

	
    // 즉시구매 클릭시
    $("#btnOrder").on("click", function(){
        console.log("즉시구매");
        
       var prod_num = ${productVO.prod_num};
       var ord_amount = $("#prod_amount").val();

       var order_direct_form = $("#order_direct_form");
       order_direct_form.append("<input type='hidden' name='prod_num' value='" + prod_num + "'>");
       order_direct_form.append("<input type='hidden' name='ord_amount' value='" + ord_amount + "'>");


       $.ajax({
           url: '/order/order',
           type: 'get',
           data: {prod_num:prod_num, ord_amount:ord_amount},
           dataType: 'text',
           success: function(data){
               alert("구매하시겠습니까?");
               location.href="/order/order";

               order_direct_form.submit();
           }
       });
   });
});
	
</script>

<!-- 2) UI Template (상품후기목록 템플릿) -->
<script id="reviewTemplate" type="text/x-handlebars-template">
	{{#each .}}
    <ul class="list-group">
        <li class="list-group-item" data-rev_num="{{rev_num}}">{{rev_num}}</li>
        <li class="list-group-item" data-rev_content="{{rev_content}}" style="word-break: break-word;">{{rev_content}}</li>
        <li class="list-group-item" data-mb_id="{{mb_id}}">{{mb_id}}</li>
        <li class="list-group-item" data-rev_reg_date="{{rev_reg_date}}">{{displayTime rev_reg_date}}</li>
        <li class="list-group-item" data-rev_score="{{rev_score}}"><strong>{{checkRating rev_score}}</strong></li>
        <li class="list-group-item">{{eqRepler mb_id}}</li>
    </ul>
	<br>
	{{/each}}
</script>


<script>

	// 3) 상품후기목록데이타 출력작업
	var printReviewData = function(reviewData, reviewTarget, reviewTemplate){
	var uiTemplate = Handlebars.compile(reviewTemplate.html());

	var reviewDataResult = uiTemplate(reviewData);
	
	reviewTarget.html(reviewDataResult);
	}


	// 상품후기 목록 페이징구현 작업
	var reviewPageDisplay = ""; // [이전] 1 2 3 4 5... [다음]


	// 댓글 페이징번호를 출력하는 기능.

	// ReplyController에서 Criteria cri = new Criteria(page, 5);부분 같이 바꿔줘야함.
	var displayPageCount = 5; // 페이지에 출력될 갯수
	
	var printReviewPaging = function(reviewCnt, pageNum){
	
	// 페이징 알고리즘
	var endNum = Math.ceil(pageNum / 10.0) * 10; // 10의 의미는 출력될 페이지수 (pageSize)
	var startNum = endNum - 9;

	var prev = startNum != 1;
	var next = false;

	// (마지막페이지 수 번호 * 10개) >= 총데이터 갯수(실제)
	if(endNum * displayPageCount >= reviewCnt){
		// Math.ceil(12/10) = 2
		endNum = Math.ceil(reviewCnt/parseFloat(displayPageCount)); // 실제데이터를 이용한 전체페이지수
	}

	// 실제데이터가 마지막페이지번호*10보다 크면, 다음데이터를 표시하기위하여 next = treu로 해줘야한다.
	if(endNum * displayPageCount < reviewCnt){
		next = true;
	}

	var str = '<ul class="pagination">';
	
	// 이전 표시여부
	if(prev){
		str += '<li class="page-item"><a class="page-link" href="' + (startNum - 1) + '">Previous</a></li>';
	}
	// 페이지번호 출력
	for(var i=startNum; i<= endNum; i++){
		var active = pageNum == i ? "active":""; // 현재페이지 상태를 나타내는 스타일시트 적용

		str += '<li class="page-item ' + active + ' "><a class="page-link" href="' + i + '">' + i + '</a></li>';
	}
	// 다음 표시여부
	if(next){
		str += '<li class="page-item"><a class="page-link" href="' + (endNum + 1) + '">Next</a></li>';
	}

	str += '</ul>';

	console.log(str);

	
	$("#reviewPaging").html(str);
}
</script>


<script>

	// 상품후기 목록/ 페이징 기능
	var showReviewList = function(curPage){
	
	    // 상품코드
	    let prod_num = ${productVO.prod_num};
	    let page = curPage;
	
	    console.log(prod_num);
	
	    let url = "/review/pages/" + prod_num + "/" + page;  // /pages/100/1
	
	        $.getJSON(url, function(data){
	
	            // 1) 상품후기목록 출력
	            printReviewData(data.list, $("#reviewListView"), $("#reviewTemplate"));
	            // 2) 페이징 출력
	            printReviewPaging(data.reviewCnt, page);
	        });
	}
	
	let curPage = 1;
	showReviewList(curPage);

</script>

<script>

	$(document).ready(function(){
		
		// 상품후기 클릭시
		$("#btnReview").on("click", function(){
	        $("modalLabel").html("Review");

	    $("button.btnModal").hide();
	    $("#btnReviewAdd").show();

	    $("#star_grade a").parent().children("a").removeClass("on");
	    $("#rev_content").val("");

	    $("#reviewModal").modal("show");
	    });

	    // 별점 색상변경
	    $("#star_grade a").click(function(e){
	        e.preventDefault();
	        $(this).parent().children("a").removeClass("on");
	        $(this).addClass("on").prevAll("a").addClass("on");
	    });

	    // 글자수 제한
	    $("#rev_content").keyup(function(e){
	        var rev_content = $(this).val();
	        $("#counter").val(99-rev_content.length);

	        if(rev_content.length > 99){
	            $(this).val($(this).val().substring(0,99));
	        }
	    });
	    
	    
	    // 상품후기 등록 클릭
	    $("#btnReviewAdd").on("click", function(){

	        // console.log("클릭");

	        let rev_score = 0;
	        let rev_content = $("#rev_content").val();
	        let prod_num = $("#prod_num").val();

	        $("#star_grade a").each(function(i,e){
	            if($(this).attr("class") == "on"){
	                rev_score += 1;
	            }
	        });

	        if(rev_score == 0){
	            alert("별점을 선택해주세요");
	            return;
	        }else if(rev_content == "" || rev_content == null){
	            alert("후기 내용을 입력해주세요");
	            return;
	        }

	        // ajax호출
	        $.ajax({
	            url: '/review/review_register',
	            type: 'post',
	            data: {rev_score:rev_score, rev_content:rev_content, prod_num:prod_num},
	            dataType: 'text',
	            success: function(data){
	                alert("상품후기가 등록되었습니다.");

	                $("#star_grade a").parent().children("a").removeClass("on");
	                $("#rev_content").val("");

	                $("#reviewModal").modal("hide");

	                // 상품후기 목록호출 함수
	                showReviewList(1);
	            }
	        });
	    });
	    
	    
	    // 로그인 사용자와 상품후기 작성자 동일하면 수정, 삭제 표시
	    Handlebars.registerHelper("eqRepler", function(replyer, rev_num) {
			var str = '';
			var login_id = "${sessionScope.loginStatus.mb_id}";
			if(replyer == login_id){
				str += '<button type="button" class="btn btn-primary btn-edit">Modify</button>';
				str += ' ';
				str += '<button type="button" class="btn btn-primary btn-del">Delete</button>';
			}
			
			return new Handlebars.SafeString(str);  // 태그 문자열 처리시 사용
		});
	    
	    
	    // 상품후기목록 수정클릭시(동적으로 추가된 태그를 이벤트 설정하는 구문)
   		$("#reviewListView").on("click", ".btn-edit", function(){
        //console.log("후기수정버튼");

        // 모달 대화상자 표시 - 수정내용 반영
        var rev_num, mb_id, prod_num, rev_score, rev_content, rev_reg_date;

        rev_num = $(this).parents("ul.list-group").find("li[data-rev_num]").attr("data-rev_num");
        mb_id = $(this).parents("ul.list-group").find("li[data-mb_id]").attr("data-mb_id");
        rev_score = $(this).parents("ul.list-group").find("li[data-rev_score]").attr("data-rev_score");
        rev_content = $(this).parents("ul.list-group").find("li[data-rev_content]").attr("data-rev_content");
        rev_reg_date = $(this).parents("ul.list-group").find("li[data-rev_reg_date]").attr("data-rev_reg_date");

        // console.log(rev_score);

        $("#modalLabel").html("상품리뷰 수정" + " ( " + rev_num + "번)");

        $("#rev_num").val(rev_num);
        $("#rev_content").val(rev_content);


        // 상품후기 수정 모달대화상자에서 별점 표시 작업
        $("#star_grade a").each(function(index, item){
            if(index < rev_score){
                $(item).addClass("on");
            }else{
                $(item).removeClass("on");
            }
        });

        $("button.btnModal").hide();  // 추가, 수정, 삭제버튼 모두 표시안함
        $("#btnReviewEdit").show();

        $("#reviewModal").modal("show");
    });

    // 상품후기 모달 대화상자 수정하기(액션)
   $("#btnReviewEdit").on("click", function(){
    let rev_score = 0;
    let rev_content = $("#rev_content").val();

    let rev_num = $("#rev_num").val();

    $("#star_grade a").each(function(i,e){
        if($(this).attr("class") == "on"){
            rev_score += 1;
        }
    });

    if(rev_score == 0){
        alert("별점을 선택해주세요.");
        return;
    }else if(rev_content == "" || rev_content == null){
        alert("후기 내용을 입력하세요.");
        return;
    }

//    console.log(rev_score);
//    console.log(rev_content);
    console.log("rev_num: " + rev_num);

    // ajax호출
    // 후기입력데이터를 전송
    $.ajax({
        url:'/review/review_modify',
        type: 'post',
        data: {rev_num : rev_num, rev_score: rev_score, rev_content:rev_content},
        dataType: 'text',
        success: function(data){
            alert("상품후기가 수정되었습니다.");
            $("#star_grade a").parent().children("a").removeClass("on");
            $("#rev_content").val("");

            $("#reviewModal").modal("hide");

            // 상품후기 목록호출 함수. 목록의 페이지로
            showReviewList(curPage);
        }
    });
   });
	    
	    
    
   // 상품후기 삭제 보기
	$("#reviewListView").on("click", ".btn-del", function(){
   //console.log("후기삭제버튼");

   // 모달 대화상자 표시 - 수정내용 반영
   var rev_num, mb_id, prod_num, rev_score, rev_content, rev_reg_date;

   rev_num = $(this).parents("ul.list-group").find("li[data-rev_num]").attr("data-rev_num");
   mb_id = $(this).parents("ul.list-group").find("li[data-mb_id]").attr("data-mb_id");
   rev_score = $(this).parents("ul.list-group").find("li[data-rev_score]").attr("data-rev_score");
   rev_content = $(this).parents("ul.list-group").find("li[data-rev_content]").attr("data-rev_content");
   rev_reg_date = $(this).parents("ul.list-group").find("li[data-rev_reg_date]").attr("data-rev_reg_date");

   // console.log(rev_score);

   $("#modalLabel").html("상품리뷰 삭제" + " ( " + rev_num + "번)");

   $("#rev_num").val(rev_num);
   $("#rev_content").val(rev_content);


	// 상품후기 수정 모달대화상자에서 별점 표시 작업
	$("#star_grade a").each(function(index, item){
	    if(index < rev_score){
	        $(item).addClass("on");
	    }else{
	        $(item).removeClass("on");
	    }
	});
	
	$("button.btnModal").hide();  // 추가, 수정, 삭제버튼 모두 표시안함
	$("#btnReviewDel").show();
	
	$("#reviewModal").modal("show");
	});
	
	// 상품후기 모달 대화상자 삭제하기(액션)
	$("#btnReviewDel").on("click", function(){
		
	let rev_num = $("#rev_num").val();
	
	// ajax호출
	// 후기입력데이터를 전송
	$.ajax({
	   url:'/review/review_delete',
	   type: 'post',
	   data: {rev_num : rev_num},
	   dataType: 'text',
	   success: function(data){
	       alert("상품후기가 삭제되었습니다.");
	       $("#star_grade a").parent().children("a").removeClass("on");
	       $("#rev_content").val("");
	
	       $("#reviewModal").modal("hide");
	
	       // 상품후기 목록호출 함수. 목록의 페이지로
	       showReviewList(curPage);
	   }
	});
	});
	    

	    
	    
	    // 사용자정의 헬퍼(Handlebars 버전의 함수)
		// 댓글 날짜를 하루기준으로 표현을 1)24시간 이전 시:분:초 2)24시간 이후 년/월/일

		Handlebars.registerHelper("displayTime", function(timeValue){
			var today = new Date(); // 1970년1월1일 0시0분0초 0 밀리세컨드
			var gap = today.getTime() - timeValue;

			var dateObj = new Date(timeValue);
			var str = "";

			if (gap < (1000 * 60 * 60 * 24)){
				var hh = dateObj.getHours();
				var mi = dateObj.getMinutes();
				var ss = dateObj.getSeconds();

				return [ (hh > 9 ? '' : '0') + hh, ':', (mi > 9 ? '' : '0') + mi,
						':', (ss > 9 ? '' : '0') + ss ].join('');
			}else {
				var yy = dateObj.getFullYear();
				var mm = dateObj.getMonth();
				var dd = dateObj.getDate();

				return [ yy, '/', (mm > 9 ? '' : '0') + mm, '/',
						(dd > 9 ? '' : '0') + dd ].join('');
			}
		});
	    
	    
	    Handlebars.registerHelper("checkRating", function(rating) {
			var stars = "";
			
			switch (rating) {
			case 1:
				stars = "★☆☆☆☆";
				break;
			case 2:
				stars = "★★☆☆☆";
				break;
			case 3:
				stars = "★★★☆☆";
				break;
			case 4:
				stars = "★★★★☆";
				break;
			case 5:
				stars = "★★★★★";
				break;
			default:
				stars = "☆☆☆☆☆";
				break;
			}
			
			return stars;
		});
	    
	    // 이전, 페이지번호, 다음 클릭시
	    $("#reviewPaging").on("click","li.page-item a", function(e){
	    	e.preventDefault();
	    	
	    	curPage = $(this).attr("href");
	    	showReviewList(curPage);
	    });
  
	
	});

</script>
<%@include file="/WEB-INF/views/common/footer.jsp" %>

</body>
</html>