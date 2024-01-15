<%@page import="vo.ProducerVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	font-family: 'GmarketSansMedium';
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

	<div class="mypagimargin" style="padding: 8px;">
		<div class="calbox3">
			<div class="mycontenttitle">일대일 문의</div>

			<hr class="mycontentbar2" />

			<div class="table-responsive small">
				<table class="table table-lm">
					<thead>
						<tr>
							<th class="tbTitle">글번호</th>
							<th class="tbTitle">제목</th>
							<th class="tbTitle">작성자</th>
							<th class="tbTitle">작성일</th>
							<th class="tbTitle">답변여부</th>
						</tr>
					</thead>

					<tbody>
						<%
							if (list.size() > 0) {
							for (int i = 0; i < list.size(); i++) {
						%>
						<tr>
							<td><%=list.get(i).getPqnaNo()%></td>
							<td><a
							
								href="PQNAView.do?pqnaNo=<%=list.get(i).getPqnaNo()%>"><%=list.get(i).getPqnaTitle()%>
							</a></td>
							<td><%=list.get(i).getMemId()%></td>
							<td><%=list.get(i).getDateFormat()%></td>
							<%
								if (list.get(i).getPqnaStatus() == 0) {
							%>
							<td
								style="background-color: black; color: white; border-radius: 15px; width: 80px; margin: 2px;">답변안됨</td>
							<%
								} else {
							%>
							<td
								style="background-color: #00E577; color: black; border-radius: 15px; width: 80px; margin: 2px;"">답변완료</td>
							<%
								}
							%>


							<%
								}
							} else if (list.size() == 0) {
							%>
						
						<tr>
							<td colspan="5" style="padding: 30px; font-size: 20px;">등록된
								문의가 없습니다.</td>
						<tr>
							<%
								}
							%>
						
					</tbody>

				</table>
			</div>

		</div>
	</div>


	<!-- 사업자 마이페이지 중앙우측 -->
	<%-- 	<div class="col-10 my-3">
		<!--  style="border: 1px solid chartreuse" -->
		<div>
		<!--  	<canvas id="sales"></canvas> -->
		</div>
		<h4 class="mt-3 bg">
			<span>일대일 문의</span>
		</h4>
		<div class="table-responsive small" style="overflow: scroll; height: 600px" >
			<table class="table table-lm">
				<thead>
					<tr>
						<th>글번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>답변여부</th>
					</tr>
				</thead>

				<tbody>
					<%
							if(list.size() > 0){
								for(int i = 0; i < list.size(); i++){
							%>
					<tr>
						<td><%= list.get(i).getPqnaNo() %></td>
						<td><a href="PQNAView.do?pqnaNo=<%=list.get(i).getPqnaNo()%>"><%=list.get(i).getPqnaTitle() %> </a></td>
						<td><%= list.get(i).getMemId()%></td>
						<td><%= list.get(i).getDateFormat()%></td>
						<%
		                        if(list.get(i).getPqnaStatus() == 0){
		                        %>
                            	<td>답변안됨</td>
                            	<%
		                        }else{
                            	%>
                            	<td>답변완료</td>
                            	<%
		                        }
                            	%>
                            	
                            	
								<%
								}
							}else if(list.size() == 0){
							%>
					
					<tr>
						<td>등록된 문의가 없습니다.</td>
					<tr>
						<%
							}
							%>
					
				</tbody>
		
			</table>
		</div>
	</div> --%>
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
	<%
		} else {
	%>
	<script>
		alert("로그인이 필요한 서비스입니다.")
		location.href = "http://localhost:8888/Jdus/login.do";
	</script>
	<%
		}
	%>
</body>
</html>