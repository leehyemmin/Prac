$(document).ready(function() {

   var form = $("#joinForm");

   // 아이디 중복체크 기능
   var isCheckId = "false";

    /* 아이디 중복체크 클릭시 */
    $("#btn_checkId").on("click", function(){

        if($("#mb_id").val()=="" || $("#mb_id").val()==null){
            $("#id_availability").html("아이디를 입력해주세요!");
            return;
        }

        var mb_id = $("#mb_id").val();

        $.ajax({
            url: '/member/checkIdDuplicate',
            type: 'post',
            dateType: 'text',
            data: {mb_id:$("#mb_id").val()},
            success: function(data){
                if(data == 'SUCCESS'){
                    // 사용 가능한 아이디
                    $("#id_availability").css("color", "green");
                    $("#id_availability").html("사용 가능한 아이디입니다.");

                    isCheckId = "true"; // 아이디 중복체크 한 용도
                }else{
                    // 사용 불가능한 아이디 -> 이미 존재
                    $("#id_availability").css("color", "red");
                    $("#id_availability").html("이미 사용중인 아이디입니다.");
                }
            }
        });
    });


    /* 회원가입 버튼 클릭시 */
    $("#btn_submit").on("click", function(){

        // 정규식
        var reg_id = /^[a-z0-9]{4,16}$/;  //아이디
        var reg_pw = /^.*(?=^.{9,16}$)(?=.*\d)(?=.*[a-z])(?=.*[~!@#$%^&*()_+{}|:<>?]).*$/; //비밀번호
        var reg_name = /^[가-힣]+$/;
        var reg_phone = /^01[0179][0-9]{7,8}$/; // 전화번호


        var mb_id = $("#mb_id");
        var mb_pw = $("#mb_pw");
        var mb_pw_check = $("#mb_pw_check");
        var mb_name = $("#mb_name");
        var mb_zipcode = $("input[name='mb_zipcode']");
        var mb_addr = $("input[name='mb_addr']");
        var mb_de_addr = $("input[name='mb_de_addr']");
        var mb_phone = $("#mb_phone");
        var mb_email = $("#mb_email");
        var agree_chk = $("#agree_chk");

        /* 유효성 검사 */
        if(mb_id.val()==null || mb_id.val()==""){
            alert("아이디를 입력해주세요.");
            mb_id.focus();

        }else if(!reg_id.test(mb_id.val())){
            alert("아이디는 4~16까지 \n영문소문자, 숫자 사용 가능합니다.");
            mb_id.focus();

        }else if(isCheckId == "false"){
            alert("아이디 중복체크를 해주세요.");
        
        }else if(mb_pw.val()==null || mb_pw.val()==""){
            alert("비밀번호를 입력해주세요.");
            mb_pw.focus();

        }else if(!reg_pw.test(mb_pw.val())){
            alert("비밀번호는 10~16까지 \n영문 대소문자/숫자/특수문자를 포함하여야 사용 가능합니다.");
            mb_pw.focus();

        }else if(mb_pw_check.val()==null || mb_pw_check.val()==""){
            alert("비밀번호 확인 란을 입력해주세요.");
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

        }else if(agree_chk[0].checked == false){
            alert("약관에 동의해주세요.");

        }else{

           form.submit();
        }


    });

    $("#btn_cancle").on("click", function(){
        var result = confirm("가입을 취소하시겠습니까?");
        if(result){
            location.href="/";
        }else{}
    });

});