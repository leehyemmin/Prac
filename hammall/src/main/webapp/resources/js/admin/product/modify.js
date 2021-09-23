$(document).ready(function(){
 
    var form = $("#modifyForm");

    $("#btn_submit").on("click", function(){


        var prod_name = $("#prod_name");
        var prod_company = $("#prod_company");
        var prod_color = $("#prod_color");
        var prod_size = $("#prod_size");
        var prod_price = $("#prod_price");
        var prod_discount = $("#prod_discount");
        var file1 = $("#file1");
        var prod_amount = $("#prod_amount");


        if(prod_name.val()=="" || prod_name.val()==null){
            alert("Product Name을 입력하세요.");
            prod_name.focus();
        }else if(prod_company.val()=="" || prod_company.val()==null){
            alert("Company를 입력하세요.");
            prod_company.focus();
        }else if(prod_color.val()=="" || prod_color.val()==null){
            alert("Color를 입력하세요.");
            prod_color.focus();
        }else if(prod_size.val()=="" || prod_size.val()==null){
            alert("Size를 입력하세요.");
            prod_size.focus();
        }else if(prod_price.val()=="" || prod_price.val()==null){
            alert("Price를 입력하세요.");
            prod_price.focus();
        }else if(prod_discount.val()=="" || prod_discount.val()==null){
            alert("Discount를 입력하세요.");
            prod_discount.focus();
        }else if(file1.val()=="" || file1.val()==null){
            alert("Thumbnail을 선택하세요.");
        }else if(prod_amount.val()=="" || prod_amount.val()==null){
            alert("Amount을 입력하세요.");
            prod_amount.focus();
        }else{
            form.submit();
            alert("수정이 완료되었습니다.");
        }
    });
});



$(document).ready(function(){


    $("#reviewListView").on("click", ".btn-edit", function(){
        console.log("후기수정버튼");

        // 모달 대화상자 표시 - 수정내용 반영
        var rev_num, mb_id, prod_num, rev_score, rev_content, rev_reg_date;

        rev_num = $(this).parents("ul.list-group").find("li[data-rev_num]").attr("data-rev_num");
        mb_id = $(this).parents("ul.list-group").find("li[data-mb_id]").attr("data-mb_id");
        rev_score = $(this).parents("ul.list-group").find("li[data-rev_score]").attr("data-rev_score");
        rev_content = $(this).parents("ul.list-group").find("li[data-rev_content]").attr("data-rev_content");
        rev_reg_date = $(this).parents("ul.list-group").find("li[data-rev_reg_date]").attr("data-rev_reg_date");

        console.log(rev_score);

        $("#modalLabel").html("상품리뷰 수정" + " (" + rev_num + " 번)");

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

    console.log(rev_score);
    console.log(rev_content);
    console.log(rev_num);

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

});

$(document).ready(function(){

});