<%@page import="vo.PQNAVO"%>
<%@page import="vo.ClassesVO"%>
<%@page import="vo.FileVO"%>
<%@page import="java.util.List"%>
<%@page import="vo.ProducerVO"%>
<%@page import="vo.FavoriteVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%
	// 해당 사업자 ProducerVO
	ProducerVO pv = (ProducerVO)session.getAttribute("loginInfo");
	// 해당 사업자가 등록한 클래스 리스트
	List<ClassesVO> clsList =(List<ClassesVO>)session.getAttribute("clsList");
	// 해당 사업자의 qna 리스트
	List<PQNAVO> list = (List<PQNAVO>)request.getAttribute("list");
	// 해당 사업자 공방 이미지 리스트
	List<FileVO> proFileList = (List<FileVO>) session.getAttribute("proFileList");
	// 해당 사업자 클래스에 관심목록 리스트
	List<FavoriteVO> favoriteList = (List<FavoriteVO>) session.getAttribute("favoriteList");
	%>
    
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
    <title>Mypage</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
    <!-- Bootstrap icons-->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
      rel="stylesheet"
    />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link href="<%=request.getContextPath() %>/css/styles.css" rel="stylesheet" />
    <link href="<%=request.getContextPath() %>/css/font.css" rel="stylesheet" />
    <link href="<%=request.getContextPath() %>/css/proMypage.css" rel="stylesheet" />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css"
    />
  <style>
	* {
	font-family: "Pretendard5";
}
	
	
</style>
  </head>
<body>
<div class="myheader">
	<div class="myheadermargin">
		<div class="myheadermargin2">
        <div style="display: flex; align-items: center;">
		      <div class="profileimg">
		      <% if (proFileList.size() < 1) {%>
              	<img
                  src="<%=request.getContextPath()%>/images/profile.png"
                  class="card-img-top"
                  alt="profile.png"
                  style="border-radius: 50%;" />
              <%} else{ %>
                <img
                  src="<%=request.getContextPath()%>/upload_images/<%=proFileList.get(0).getFileSvNm()%>"
                  class="card-img-top"
                  alt="profile.png"
                  style="border-radius: 100% !important;
                  height: 200px;
                  " 
                  />
                  <%} %>
          </div>
          <div>
             	<div class="proName"><%=pv.getProName() %></div>
             	<span class="proSub"><a href="<%=request.getContextPath() %>/detailstore.do?proId=<%=pv.getProId() %>" style="color:#999999;"><%=pv.getProStore()%></a> · 사업자 회원</span>
          </div>
        </div>
        <div  class="rightarray">
        	<div class="textbbox">
        		<div class="proName"><%=pv.getClsNo()%></div>
        		<div class="proSub">클래스</div>
        	</div>
        	<hr style="width: 2px; height: 40px; background: #585858;">
        	<div class="textbbox">
        		<div class="proName"><%=pv.getReviewNo()%></div>
        		<div class="proSub">리뷰</div> 		
        	</div>
        	<hr style="width: 2px; height: 40px; background: #585858;">
        	<div class="textbbox" style="margin-right: -20px;">
        		<div class="proName"><%=favoriteList.size()%></div>
        		<div class="proSub">관심</div>
        	</div>
        </div>
        </div>
        
    
            <div class="listContainer">
              <div class="card-body">
                <ul class="list-group list-group-flush" style="flex-direction: row !important; display: flex; justify-content: space-between;">
                   <a href="<%=request.getContextPath()%>/producer/mypage.do"">
                    <li class="list-group-item promymain">
                      메인
                    </li></a>
                  <a href="<%=request.getContextPath()%>/producer/pqnaBoard.do?proId=<%=pv.getProId() %>">
                    <li class="list-group-item promyqna">
                      일대일 문의
                    </li></a>
                  <a href="<%=request.getContextPath()%>/producer/classmanagement.do?proId=<%=pv.getProId() %>">
                    <li class="list-group-item promyclass">
                      클래스 관리
                    </li></a>
                  <!-- <a href="#">
                    <li class="list-group-item">매출</li></a> -->
                  <a href="<%=request.getContextPath()%>/producer/feed.do?proId=<%=pv.getProId() %>">
                    <li class="list-group-item promyfeed">
                      피드 관리
                    </li></a>
                  <a href="<%=request.getContextPath()%>/producer/mypageupdate.do?proId=<%=pv.getProId() %>">
                    <li class="list-group-item promyinfo">
                      내 정보
                    </li></a>
                </ul>
              </div>
            </div>
          
	</div>
	
</div>



<div class="myheadermargin">
        <div class="mypagerow">
          <!-- 사업자 마이페이지 좌측 메뉴 -->
          
         
        
       
 



</body>
</html>