<%@page import="vo.PCommentVO"%>
<%@page import="vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	PQNAVO pqVO = (PQNAVO) request.getAttribute("pqVO");
PCommentVO pcommVO = (PCommentVO) request.getAttribute("pcommVO");
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
<link href="<%=request.getContextPath()%>/css/memberMypage.css"
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
</style>
</head>

<body>

	<%
		Object vo = session.getAttribute("loginInfo");
	if (vo != null && vo instanceof MemberVO) {
	%>


	<!-- Header-->
	<%@include file="../common/mainheader.jsp"%>


	<%@include file="memAside.jsp"%>

	<div class="mypagimargin" style="padding: 8px;">
		<div class="calbox">
			<div class="mycontenttitle">클래스 문의</div>

			<hr class="mycontentbar" />

			<div class="table-responsive small">
				<table class="table table-lm">
					<tr>
						<th style="width: 100px;">번호</th>
						<td><%=pqVO.getPqnaNo()%></td>
						<th style="width: 100px;">작성일</th>
						<td><%=pqVO.getDateFormat()%></td>
					</tr>
					<tr>
						<th>제목</th>
						<td><%=pqVO.getPqnaTitle()%></td>
						<th>작성자</th>
						<td><%=pqVO.getMemId()%></td>
					</tr>

					<tr>
						<th style="height: 200px;" class="tbTitle">문의내용</th>
						<td colspan='3'
							style="overflow-y: scroll; padding: 30px 120px; text-align: start; vertical-align: middle;"><%=pqVO.getPqnaContent()%></td>
					</tr>

					<tr>
						<th style="height: 200px;" class="tbTitle">답변내용</th>
						<%
							if (pcommVO != null) {
						%>
						<td colspan='3'
							style="overflow-y: scroll; vertical-align: middle;"><%=pcommVO.getPcmtContent()%></td>
						<%
							} else {
						%>
						<td colspan='3'
							style="overflow-y: scroll; vertical-align: middle;">아직 답변이
							등록되지 않았습니다.</td>
						<%
							}
						%>
					</tr>
				</table>
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