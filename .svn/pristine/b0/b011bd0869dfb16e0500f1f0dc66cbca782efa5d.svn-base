<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>findId</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
      rel="stylesheet"
    />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
      crossorigin="anonymous"
    />
    <link
      href="<%=request.getContextPath()%>/css/styles.css"
      rel="stylesheet"
    />
    <link href="<%=request.getContextPath()%>/css/font.css" rel="stylesheet" />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css"
    />
    <style>
      * {
        font-family: "GmarketSansMedium";
      }
      
      body{
      background-color: #000;}
      
      #btn-Yes:hover{
       color: #fff !important;
      }
    </style>
    <script
      src="https://code.jquery.com/jquery-3.7.1.js"
      integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
      crossorigin="anonymous"
    ></script>
  </head>

  <script>
    $(function () {
      $("#select").on("change", function (event) {
        console.log(event.target.id);
        if (event.target.id == "findPw") {
          $("#id").removeAttr("style");
          $("#btn-Yes").text("비밀번호 찾기");
          $("#id").val("");
          $("#name").val("");
          $("#email").val("");
        } else {
          $("#id").css("display", "none");
          $("#btn-Yes").text("아이디 찾기");
          $("#id").val("");
          $("#name").val("");
          $("#email").val("");
        }
      });

      $("#btn-Yes").on("click", function () {
        searchAccount();
      });
      
      $('#email').on('keydown', function(event){
    	if (event.originalEvent.code == 'Enter') searchAccount()
      })
      
      function searchAccount() {
    	  let id = $("#id").val();
          let name = $("#name").val();
          let mail = $("#email").val();
          $.ajax({
            url: "http://localhost:8888/Jdus/findaccount.do",
            type: "post",
            data: { id: id, name: name, mail: mail },
            success: function (rsp) {
              console.log(rsp.result);
              if (rsp.result == 'false') {
                alert('입력하신 회원님의 정보가 없습니다. 다시 입력해주세요.');
              } else if (rsp.result == 'true') {
                alert('가입하신 이메일로 임시 비밀번호가 전송되었습니다.');
              } else {
                alert("회원님의 아이디는 '" + rsp.result + "' 입니다.");
              }
            },
            error: function (xhr) {
              alert(xhr);
            },
            dataType: "json",
          });
      }
    });
  </script>
  <body
    style="margin-top: 10%; flex-direction: column"
    class="d-flex align-items-center justify-content-evenly"
  >
   <div class="d-flex justify-content-center" >
            <a href="<%=request.getContextPath() %>/main.do" class="row text-decoration-none my-4">
              <p style="font-weight: bolder; color: black; border-radius: 15px 15px 15px 0; border: 5px solid #00E577; padding: 0.5em 0.6em; border: 5px solid #00E577; background-color: #00E577; padding: 0.5em 0.6em; padding-top: 0.6em;" class="fs-1">Class 404 +</p>
            </a>
          </div>
    <div class="card align-middle" style="width: 40rem; height: 25rem; border-radius: 24px;">
      <div
        class="container d-flex justify-content-evenly mt-5 mb-3"
        id="select"
      >
        <div class="form-check form-check-inline">
          <input
            class="form-check-input"
            type="radio"
            name="findAccount"
            id="findId"
            value="findId"
            checked
          />
          <label class="form-check-label" for="findId">아이디 찾기</label>
        </div>
        <div class="form-check form-check-inline">
          <input
            class="form-check-input"
            type="radio"
            name="findAccount"
            id="findPw"
            value="findPw"
          />
          <label class="form-check-label" for="findPw">비밀번호 찾기</label>
        </div>
      </div>

      <div class="card-body px-5">
        <div class="form-signin" style="width: 542px; display: flex; flex-direction: column; align-items: center;
        ">
          <!-- style="text-align: center;" -->
          <!-- <p class="text2"> ${findid2}</p> -->
          <input
            type="text"
            name="id"
            id="id"
            class="form-control"
            placeholder="아이디"
            required
            style="display: none"
          /><br />
          <input
            type="text"
            name="name"
            id="name"
            class="form-control"
            placeholder="이름"
            required
            autofocus
            style="width: 100%;"
          /><br />
          <input
            type="email"
            name="email"
            id="email"
            class="form-control"
            placeholder="이메일"
            required
             style="width: 100%;"
          /><br />
          <!-- <p class="check" id="check">${check}</p><br/> -->
          <button
            id="btn-Yes"
            class="btn btn-lg btn-primary btn-block"
            type="button"
            style="color: #00E577; width: 300px; height: 60px; font-family: 'Pretendard7';"
          >
            아이디 찾기
          </button>
        </div>
        <div class="links my-4" style="text-align: center">
          <a href="<%=request.getContextPath()%>/login.do">로그인</a> | <a href="<%=request.getContextPath()%>/signup.do">회원가입</a>
        </div>
      </div>
    </div>

    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
      crossorigin="anonymous"
    ></script>
    <script src="<%=request.getContextPath()%>/js/scripts.js"></script>
  </body>
</html>
