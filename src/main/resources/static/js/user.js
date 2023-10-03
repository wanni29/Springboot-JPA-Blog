let index = {
    init: function() { //on(첫번째 파리미터, 두번째파라미터) -> 첫번째파라미터가 실행이되면 두번째 파라미터도 이후에 실행이된다.
        $("#btn-save").on("click",  () => { // function() {}이거를 사용하지않고, () => {} 이거를 사용하는 이유는 this를 바인딩 하기위해서!!! 
            this.save();
        }); // 리스너를 만드는 거임, 누군가가 btn-save를 건드리면 실행됨 

    },

    save: function() {
        // alert("user의 save함수 호출됨");
        let data = {
            username : $("#username").val(),
            password : $("#password").val(),
            email : $("#email").val(),
        };

        // console.log(data);

        // ajax호출시 default가 비동기 호출
        // ajax가 통신을 성공하고 서버가 json 을 리턴해주면 자동으로 자바 오브젝트로 변환해주네요.
        $.ajax({
            // 회원가입 수행 요청
            type: "post", 
            url: "/blog/api/user",
            data: JSON.stringify(data), // http body 데이터
            contentType: "application/json; charset=utf-8", // body 데이터가 어떤 타입인지 (MIME)
            dataType: "json" // 요청을 서버로 해서 응답이 왔을 때 기본적으로 모든것이 문자열 (생긴게 json 이라면) => javascript 오브젝트로 변경 
        }).done(function(resp) {
            // 응답의 결과가 정상이면
            alert("회원가입이 완료되었습니다.");
            //console.log(resp);
            location.href = "/blog";
        }).fail(function(error) {
            // 응답의 결과가 실패면
            alert(JSON.stringify(error));
        }); // ajax 통신을 이용해서 3개의 데이터를 json 으로 변경하여 insert 요청을 할꺼임!!
    }
}

index.init();