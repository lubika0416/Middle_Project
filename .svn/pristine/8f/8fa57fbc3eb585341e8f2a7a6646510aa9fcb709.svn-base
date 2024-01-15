
<%@page import="vo.ClassesVO"%>
<%@page import="java.util.List"%>
<%@page import="vo.ProducerVO"%>
<%@page import="vo.MemberVO"%>
<%@page import="vo.AQNAVO"%>
<%@page import="vo.FileVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	Object mainObj = session.getAttribute("loginInfo");
    %>
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>MAIN</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
    <!-- Bootstrap icons-->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
      rel="stylesheet"
    />
    
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <!-- Bootstrap core JS-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Core theme JS-->
    <script src="<%=request.getContextPath() %>/js/scripts.js"></script>
    
     <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link href="<%=request.getContextPath() %>/css/styles.css" rel="stylesheet" />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css"
    />
    
   
  </head>
<body>
	<nav
      class="navbar navbar-expand-lg navbar-dark"
      style="background-color: black; flex-shrink: 0;
      "
    >
      <div class="container" style="width: 1120px;">
      <% if(session.getAttribute("loginInfo") instanceof ProducerVO) {%>
        <a class="navbar-brand" href="<%=request.getContextPath()%>/producer/mypage.do">
        <%} else {%>
        <a class="navbar-brand" href="<%=request.getContextPath()%>/main.do">
        <%} %>
        <p class="logo mb-0" style="color:  #00E577;">CLASS404+</p></a>
        <button
          class="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav ms-auto" style="display: flex; align-items: center; width: max-content;">
            <div class="mt-sm-2 me-sm-4">

              <!--검색창-->
              <div class="container" style="margin-top: -10px;">
                <div class="d-flex justify-content-center">
                  <div class="search">
                  	<form action="classSearch.do" method="post">
                    <input class="search_input" type="text" name="clsName" placeholder="Search here..." style="color: black;">
                    <a href="<%=request.getContextPath() %>/classSearch.do" class="search_icon"><svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                      <g clip-path="url(#clip0_11_4733)">
                      <path d="M15.4999 14H14.7099L14.4299 13.73C15.6299 12.33 16.2499 10.42 15.9099 8.39C15.4399 5.61 13.1199 3.39 10.3199 3.05C6.08989 2.53 2.52989 6.09 3.04989 10.32C3.38989 13.12 5.60989 15.44 8.38989 15.91C10.4199 16.25 12.3299 15.63 13.7299 14.43L13.9999 14.71V15.5L18.2499 19.75C18.6599 20.16 19.3299 20.16 19.7399 19.75C20.1499 19.34 20.1499 18.67 19.7399 18.26L15.4999 14ZM9.49989 14C7.00989 14 4.99989 11.99 4.99989 9.5C4.99989 7.01 7.00989 5 9.49989 5C11.9899 5 13.9999 7.01 13.9999 9.5C13.9999 11.99 11.9899 14 9.49989 14Z" fill="white"/>
                      </g>
                      <defs>
                      <clipPath id="clip0_11_4733">
                      <rect width="24" height="24" fill="white"/>
                      </clipPath>
                      </defs>
                      </svg>
                      </i></a>
                  	</form>
                  </div>
                </div>
              </div>

            </div>
            <li class="nav-item ppr-40">
              <a class="nav-link head-text" aria-current="page" href="<%=request.getContextPath()%>/classlist.do" style="margin-left: 10px;">클래스</a>
            </li>
            <li class="nav-item ppr-40">
            <%if (session.getAttribute("loginInfo") instanceof ProducerVO){%>
              <a class="nav-link head-text" href="<%=request.getContextPath()%>/producer/mypage.do">마이페이지</a>
            <%} else {%>
              <a class="nav-link head-text" href="<%=request.getContextPath()%>/mypage.do">마이페이지</a>
            <%}%>
            </li>
            <div class="nav-item dropdown ppr-40">
            	<a class="nav-link head-text dropdown-toggle" type="button" role="button" data-bs-toggle="dropdown" aria-expanded="false"]>
            	고객센터
            	</a>
            	
            	<ul class="dropdown-menu" style="background-color: black;">
    				<li><a class="dropdown-item" href="<%=request.getContextPath()%>/Notice.do"  style="color:white;">공지사항</a></li>
    				<li><a class="dropdown-item" href="<%=request.getContextPath()%>/FAQBoard.do" style="color:white;">자주 묻는 질문</a></li>
    				<%if (mainObj != null) {
    					if (mainObj instanceof MemberVO) {
    					MemberVO mainMv = (MemberVO) mainObj;%>
    				<%-- <li><a class="dropdown-item" href="<%=request.getContextPath()%>/member/AQNA.do?memId=<%=mainMv.getMemId()%>" style="color:white;">1대1 문의</a></li> --%>
    				<li><a class="dropdown-item" href="#" data-bs-toggle="modal" data-bs-target="#exampleModal" style="color:white;">1대1 문의</a></li>
    				<%} else if (mainObj instanceof ProducerVO){ 
    					ProducerVO mainPv = (ProducerVO) mainObj;%>
    				<%-- <li><a class="dropdown-item" href="<%=request.getContextPath()%>/producer/AQNA.do?memId=<%=mainPv.getProId()%>" style="color:white;">1대1 문의</a></li> --%>
    				<li><a class="dropdown-item" href="#" data-bs-toggle="modal" data-bs-target="#exampleModalPro" style="color:white;">1대1 문의</a></li>
    				<%} %>
    				<%} else {%>
    				<li><a class="dropdown-item" href="#" onclick="alertLogin()" style="color:white;">1대1 문의</a></li>
    				<%} %>
  				</ul>
            </div>
            <% 
            if (session.getAttribute("loginInfo") != null) {
            %>
            <li class="nav-item" style="display: flex; align-items: center;">
            	<a class="nav-link login-btn" href="<%=request.getContextPath()%>/logout.do" style="color: black;"><b>로그아웃</b> </a>
            </li>
            <%} else {%>
            <li class="nav-item" style="display: flex; align-items: center;">
            	<a class="nav-link login-btn" href="<%=request.getContextPath()%>/login.do" style="color: black;"><b>로그인</b> </a>
            </li>
            <%} %>
          </ul>
        </div>
      </div>
    </nav>
						
                <!-- 모달!!!!!!!!!!! -->
                <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                      <div class="modal-content">
                        <div class="modal-header">
                          <div class="sub-title">
								<h1><b>1대1 문의</b></h1>
						  </div>
                          
                          <button  type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>   
                        <div class="modal-body">
                        
                        	<form id="updateForm" action="<%=request.getContextPath()%>/member/AQNA.do" method="post">
                				
                        		<span>제목 </span>
                				<input type="text" id="dataToUpdate" name="aqnaTitle"  style="width:100%;">
                				<p></p>
                				
                				<span>문의사항 </span><br>
                				<input type="text" id="dataToUpdate" name="aqnaContent" style="width:100%; height:250px;">
                				<p></p>
                				
            				</form>
                            
                        </div>
                        <div class="modal-footer">
                          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                          <button type="submit" method="post" class="btn btn-dark" form="updateForm">제출</button>
                        </div>
            
                      </div>
                    </div>
                  </div>
                  
                  
                  <!-- 사업자 문의 모달!!!!!!!!!!! -->
                <div class="modal fade" id="exampleModalPro" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                      <div class="modal-content">
                        <div class="modal-header">
                          <div class="sub-title">
								<h1><b>1대1 문의</b></h1>
						  </div>
                          
                          <button  type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>   
                        <div class="modal-body">
                        
                        	<form id="updateProForm" action="AQNAPro.do" method="post">
                				
                        		<span>제목 </span>
                				<input type="text" id="dataToUpdate" name="aqnaTitle"  style="width:100%;">
                				<p></p>
                				
                				<span>문의사항 </span><br>
                				<input type="text" id="dataToUpdate" name="aqnaContent" style="width:100%; height:250px;">
                				<p></p>
                				
            				</form>
                            
                        </div>
                        <div class="modal-footer">
                          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                          <button type="submit" method="post" class="btn btn-dark" form="updateProForm">제출</button>
                        </div>
            
                      </div>
                    </div>
                  </div>
                  
                  <!-- 모달 끝 -->
                
                <script type="text/javascript">
                	function alertLogin() {
						alert("로그인이 필요한 서비스입니다.")
						location.href = "http://localhost:8888/Jdus/login.do"
					}
                </script>

</body>
</html>
