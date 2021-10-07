$(document).ready(function(){
    
    /* 아이디 찾기: 화면출력 */
    $("#btn_ID_find").on("click", function(){

        var mb_name = $("#mb_name");
        var mb_email = $("#mb_email");

        if(mb_name.val()=="" || mb_name.val()==null){
            alert("이름을 확인해주세요.");
            mb_name.focus();
        
        }else if(mb_email.val()=="" || mb_email.val()==null){
            alert("이메일을 확인해주세요.");
            mb_email.focus();
        }else{}

        $.ajax({
            url: '/member/find_id',
            type: 'post',
            data: {mb_name:$("#mb_name").val(), mb_email:$("#mb_email").val()},
            dataType: 'text',
            success: function(data){

                if(data != ""){
                    $("#result").html($("#mb_name").val() + "님의 아이디는? " + data + " 입니다.");
                }else{
                    $("#result").html("입력정보가 틀립니다.");
                }

                $("#mb_email").val("");
            }
        });
    });

    /* 비밀번호 찾기(임시 비밀번호) */
    $("#btn_PW_find").on("click",function(){

        var userInfo = {mb_id:$("#mb_id").val(), mb_name:$("#mb_name").val()};

        var mb_id = $("#mb_id");
        var mb_name = $("#mb_name");

        if(mb_id.val()=="" || mb_id.val()==null){
            alert("아이디를 입력해주세요.");
            mb_id.focus();
        }else if(mb_name.val()=="" || mb_name.val()==null){
            alert("이름을 입력해주세요.");
            mb_name.focus();
        }

        $.ajax({
            url: '/member/find_pwd',
            type: 'post',
            data: userInfo,
            dataType: 'text',
            success: function(data){
                
                if(data != ""){
                    $("#result").html($("#mb_name").val() + "님의 비밀번호는? " + data + " 입니다. (보안문제로 암호화되어 보여짐)");
                }else{
                    $("#result").html("입력정보가 틀립니다.");
                }

                $("#mb_id").val("");
            }
        });
    });




    // 아이디 취소버튼
    $("#btn_ID_cancle").on("click", function(){
        var result = confirm("홈으로 돌아가시겠습니까?");
        if(result){
            location.href="/";
        }else{}
    });

    // 비밀번호 취소버튼
    $("#btn_PW_cancle").on("click", function(){
        var result = confirm("홈으로 돌아가시겠습니까?");
        if(result){
            location.href="/";
        }else{}
    });    
});