$(document).ready(function(){

    var form = $("#modifyForm");

    $("#btn_submit").on("click", function(){

            // 정규식
            var reg_name = /^[가-힣]+$/;
            var reg_phone = /^01[0179][0-9]{7,8}$/; // 전화번호
    
            var mb_pw = $("#mb_pw");
            var mb_pw_check = $("#mb_pw_check");
            var mb_name = $("#mb_name");
            var mb_zipcode = $("input[name='mb_zipcode']");
            var mb_addr = $("input[name='mb_addr']");
            var mb_de_addr = $("input[name='mb_de_addr']");
            var mb_phone = $("#mb_phone");
            var mb_email = $("#mb_email");

    
            /* 유효성 검사 */
            if(mb_pw.val()==null || mb_pw.val()==""){
                alert("비밀번호를 입력해주세요.");
                mb_pw.focus();
                
            }else if(mb_pw_check.val==null || mb_pw_check.val==""){
                alert("비밀번호 확인란을 입력해주세요.");
                mb_pw_check.focus();

            }else if(mb_pw.val() != mb_pw_check.val()){
                alert("입력하신 비밀번호가 다릅니다. \n비밀번호를 다시 확인해주세요.");
                mb_pw_check.focus();

            }else if(mb_name.val()==null || mb_name.val()==""){
                alert("이름을 입력해주세요.");
                mb_name.focus();
    
            }else if(!reg_name.test(mb_name.val())){
                alert("이름을 형식에 맞게 입력해주세요.");
                mb_name.focus();
    
            }else if(mb_zipcode.val()==null || mb_zipcode.val()==""){
                alert("우편번호를 입력해주세요.");
                $("#btn_postCode").focus();
    
            }else if(mb_addr.val()==null || mb_addr.val()==""){
                alert("기본 주소를 입력해주세요.");
                    $("#btn_postCode").focus();
    
            }else if(mb_de_addr.val()==null || mb_de_addr.val()==""){
                alert("나머지 주소를 입력해주세요.");
                mb_de_addr.focus();
    
            }else if(mb_phone.val()==null || mb_phone.val()==""){
                alert("휴대 전화를 입력해주세요.");
                mb_phone.focus();
    
            }else if(!reg_phone.test(mb_phone.val())){
                alert("휴대전화를 형식에 맞게 입력해주세요.");
                mb_phone.focus();
    
            }else if(mb_email.val()==null || mb_email.val()==""){
                alert("이메일을 입력해주세요.");
                mb_email.focus();
    
            }else{

                form.submit();
            }

    });

    $("#btn_cancle").on("click", function(){
        var result = confirm("회원정보 수정을 취소하시겠습니까?");
        if(result){
            location.href="/";
        }else{}
    });

  

});