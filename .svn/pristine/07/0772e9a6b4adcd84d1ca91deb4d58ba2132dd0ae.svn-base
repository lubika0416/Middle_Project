<%@page import="vo.PCommentVO"%>
<%@page import="vo.ProducerVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	PQNAVO pqVO = (PQNAVO)request.getAttribute("pqVO");
	PCommentVO pcommVO = (PCommentVO)request.getAttribute("pcommVO");
	List<PQNAVO> pqList = (List<PQNAVO>) request.getAttribute("pqList");
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Mypage</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Bootstrap icons-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
	rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link href="<%=request.getContextPath()%>/css/styles.css"
	rel="stylesheet" />
<link href="<%=request.getContextPath()%>/css/font.css" rel="stylesheet" />
<link href="<%=request.getContextPath()%>/css/proMypage.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" />
<!-- jQuery CDN (FullCalendar은 jQuery를 필요로 합니다) -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="
https://cdn.jsdelivr.net/npm/fullcalendar@6.1.8/index.global.min.js
"></script>

<style>
* {
	font-family: 'Pretendard-Regular';
	font-size: 18px;
}

#fc-dom-1 {
	font-size: 20px;
}

.promyqna {
	color: var(--CI, #00E577) !important;
}

</style>
</head>

<body>

	<%
	Object vo = session.getAttribute("loginInfo");
	if (vo != null && vo instanceof ProducerVO) {
 %>
	<!-- Header-->
	<%@include file="../common/mainheader.jsp"%>
	<%@include file="proAside.jsp"%>
	
	<div class="row">
	<div class="mycontenttitle" style="width: 1120px; margin: 40px 0px 32px 0px;">
			<span class="mycontenttitle">일대일 문의</span>
		</div>

	<!-- 사업자 마이페이지 중앙우측 -->
	<div class="defaultmargin" style="display: block; padding: 0px;">
		<!--  style="border: 1px solid chartreuse" -->
		<div>
		<!--  	<canvas id="sales"></canvas> -->
		
		</div>
		
		<div class="table-responsive small" >
			<table class="table" style="border-radius: 24px; width: 100%;">
                    <tr style="background-color: black; color:#fff; border-color: #fff;">
                        <th style="width:250px;">번호</th>
                        <td><%=pqVO.getPqnaNo() %></td>
                        <th style="width:250px;">작성일</th>
                        <td><%=pqVO.getDateFormat()%></td>
                    </tr>
                    <tr style="background-color: black; color:#fff; border-color: #fff;">
                        <th style="width:250px;">제목</th>
                        <td><%=pqVO.getPqnaTitle() %></td>
                        <th style="width:250px;">작성자</th>
                        <td><%=pqVO.getMemId() %></td>
                    </tr>

                    <tr>
                        <th style="height:400px; display: flex; align-items: center; font-weight: bolder;">문의내용</th>
                        <td colspan='3' style="height:400px; overflow-y: scroll; padding:32px;"><%=pqVO.getPqnaContent() %></td>
                    </tr>
                    
                    <tr>
                        <th style="height:200px; display: flex; align-items: center; font-weight: bolder;">답변내용</th>
						<%
						if(pcommVO != null){
						%>
                        <td colspan='3' style="height:200px; overflow-y: scroll; padding:32px; "><%=pcommVO.getPcmtContent()%></td>
						<%
						}else{
						%>
                        <td colspan='3' style="height:200px; overflow-y: scroll; padding:32px; ">아직 답변이 등록되지 않았습니다.</td>
                        <%
                        
						}
                        %>
                    </tr>
		
			</table>
			 <button  type="button" 
			 onclick="location.href='<%=request.getContextPath()%>/producer/answerPQNA.do?pqnaNo=<%=pqVO.getPqnaNo()%>'" 
			 class="btn btn-secondary" 
			 style="width:100px; 
			 background-color: var(--CI, #00E577); color: black; 
			 border: none; margin-left: calc(100% - 116px);
			 font-family: 'Happiness-Sans-Bold'; font-weight: 700;">
			 	답변하기
			 </button>
		</div>
	</div>
	</div>
</div>

</div>


	<!-- Footer-->
	<%@include file="../common/mainfooter.jsp"%>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

	<script src="<%=request.getContextPath()%>/js/scripts.js"></script>
	<script src="<%=request.getContextPath()%>/js/proMypage.js"></script>
	<%} else {%>
	<script>
		alert("로그인이 필요한 서비스입니다.")
		location.href = "http://localhost:8888/Jdus/login.do";
	</script>
	<%}%>
</body>
</html>