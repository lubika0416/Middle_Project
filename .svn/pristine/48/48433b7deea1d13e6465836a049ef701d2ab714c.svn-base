<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Login</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="<%=request.getContextPath() %>/assets/favicon.ico" />
    <!-- Bootstrap icons-->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
      rel="stylesheet"
    />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link href="<%=request.getContextPath() %>/css/styles.css" rel="stylesheet" />
    <link href="<%=request.getContextPath() %>/css/font.css" rel="stylesheet" />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css"
    />
    <script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous"></script>
    <style>
    	*{
    	font-family: 'GmarketSansMedium';
    	}
    	#login{
    		background-color: black;
    		color: white;
    		border: none;
    		width: 350px;
    		height: 50px;
    		font-weight: 600;
    	}
    	#login:hover{
    		background-color: #00E577; 
    		color: black;
    	}
    	
    </style>
  </head>
  <body style="height: 80vh;" class="d-flex align-items-center">
    
    <div class="container d-flex justify-content-center">
      <main style="width: 350px; height: 550px;">   <!-- border: 1px solid black;   --> 
        <div class="d-flex row justify-content-center">
        
        
        <!-- <p><span style="border-radius: 15px 15px 15px 0; border: 3px solid #FFAD5B; padding: 0.5em 0.6em; color: #FF8000;">내용</span></p> -->
          <div class="d-flex justify-content-center" >
            <a href="<%=request.getContextPath() %>/main.do" class="row text-decoration-none my-4">
              <p style="font-weight: bolder; color: black; border-radius: 15px 15px 15px 0; border: 5px solid #00E577; padding: 0.5em 0.6em; border: 5px solid #00E577; padding: 0.5em 0.6em; padding-top: 0.6em;" class="fs-1">Class 404 +</p>
            </a>
          </div>
          <div class="d-flex justify-content-center mt-3 align-items-center">
            <a href="#" id="kakao_login">
              <button style="background-color: #FFEB00; border: none; width: 350px; height: 50px; " class="rounded-2 shadow-sm">
                <img src="<%=request.getContextPath() %>/images/kakao_icon.png" alt="kakao_icon" style="margin-right: 20px;"> <span>카카오 로그인</span>
              </button>
            </a>
          </div>
          <div class="d-flex justify-content-center mt-2 align-items-center">
            <a href="#" id="naver_login">
              <button style="background-color: #03C75A; border: none; width: 350px; height: 50px; " class="rounded-2 shadow-sm">
                <img src="<%=request.getContextPath() %>/images/naver_icon.png" alt="naver_icon" style="margin-right: 20px;"> <span class="text-white fw-bold">네이버 로그인</span>
              </button>
            </a>
          </div>
          <div class="d-flex justify-content-center mt-2 align-items-center">
            <a href="#" id="google_login">
              <button style="background-color: #ffffff; border: none; width: 350px; height: 50px; border: 1px solid lightgrey;" class="rounded-2 shadow-sm">
                <img src="<%=request.getContextPath() %>/images/google_icon.png" alt="google_icon" style="margin-right: 15px; margin-left: -20px;"> <span class="fw-bold">구글 로그인</span>
              </button>
            </a>
          </div>

          <div class="container row d-flex justify-content-center my-sm-4 align-items-center">
            <span class="col ">
              <hr>
            </span>
            <span class="w-25" style="padding: -30px; text-align: center; color: gray;">또는</span>
            <span class="col">
              <hr>
            </span>
          </div>

          <div class="form-floating mb-3 d-flex">
            <input type="text" class="form-control" name="id" style="height: 90%;" id="ID" placeholder="ID">
            <label for="floatingInput" style="padding-left: 20px; color: gray; float: inline-end;" class="d-flex align-items-center">ID</label>
          </div>
          <div class="form-floating">
            <input type="password" class="form-control" id="PW" name="pw" placeholder=" Password" style="height: 90%;">
            <label for="floatingPassword" style="padding-left: 20px; color: gray;" class="d-flex align-items-center">Password</label>
          </div>

          <button type="button" class="rounded-2 my-4 fs-5" id="login"> 로그인 </button>

          <div class="row">
            <a href="<%=request.getContextPath()%>/findaccount.do" class="col text-decoration-none text-secondary" style="text-align: center;">아이디 찾기</span></a>
            <span class="col-1 mx-1" style="text-align: center;">|</span>
            <a href="<%=request.getContextPath()%>/signup.do" class="col text-decoration-none text-secondary" style="text-align: center;">회원가입</a>
          </div>
          
        </div>
      </main>
    </div>


<!-- Bootstrap core JS-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Core theme JS-->
    <script src="<%=request.getContextPath() %>/js/scripts.js"></script>
    
    <%if (request.getAttribute("result") != null && (boolean)request.getAttribute("result")){ %>
    <script>
    	alert("회원 가입에 성공하셨습니다. 로그인 해주세요.")
    </script>
    <%request.removeAttribute("result");
    }%>
    
    <script>
      document.getElementById("ID").focus();
    
      $('#login').on('click', function(){
        loginInfo();
        
      })
      
      $('#PW').on('keydown', function(event){
    	  if (event.originalEvent.code == 'Enter') loginInfo();
      })
      
      $('#PW').on('keydown', function(event){
    	  if (event.originalEvent.code == 'NumpadEnter') loginInfo();
      })
      
      
      
        function loginInfo() {
    	  let id = $('#ID').val();
          let pw = $('#PW').val();
          
          $.ajax({
            url: 'http://localhost:8888/Jdus/login.do',
            type: 'post',
            data: {id:id, pw:pw},
            success: function(rst) {
            	console.log(rst.mv)
            	console.log(rst.pv)
          	if (rst.result) {
          		if(rst.type == 1) {
	                location.href="http://localhost:8888/Jdus/main.do"
          		} else if (rst.type == 2) {
          			location.href = "http://localhost:8888/Jdus/producer/mypage.do"
          		} else if (rst.type == 3) {
          			location.href = "http://localhost:8888/Jdus/admin/statistics.do"
          		}
          	  } else {
              alert('아이디 / 비밀번호가 틀렸습니다. 확인 후 다시 입력해주세요.');
          	  }
            },
            error: function(xhr) {
          	  alert(xhr)
          	  console.log(xhr)
            },
            dataType: 'json'
          })
		}
      
    </script>
  </body>
</html>