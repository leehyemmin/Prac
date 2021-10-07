$(document).ready(function(){

    var form = $("#registerForm");

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
        }

    });
});