<%@page import="vo.MemberVO"%>
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
<%-- <link href="<%=request.getContextPath()%>/css/proMypage.css" rel="stylesheet" /> --%>
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

.mypqna {
color: var(--CI, #00E577) !important;
}
</style>
</head>
<%
	Object vo = session.getAttribute("loginInfo");
if (vo != null && vo instanceof MemberVO) {
%>

<!-- Header-->
<%@include file="../common/mainheader.jsp"%>

<%@include file="memAside.jsp"%>

<div class="mypagimargin" style="padding: 8px;">
	<div class="calbox">
		<div class="mycontenttitle">클래스 문의 내역</div>

		<hr class="mycontentbar" />

		<div class="table-responsive small">
			<table class="table table-lm">
				<thead>
					<tr>
						<th class="tbTitle">글번호</th>
						<th class="tbTitle">제목</th>
						<th class="tbTitle">질문한 사업자 아이디</th>
						<th class="tbTitle">작성일</th>
						<th class="tbTitle">답변여부</th>
					</tr>
				</thead>

				<tbody>
					<%
						if (mypqList.size() > 0) {
						for (int i = 0; i < mypqList.size(); i++) {
					%>
					<tr>
						<td><%=mypqList.get(i).getPqnaNo()%></td>
						<td><a
							href="PQNAAnswerView.do?pqnaNo=<%=mypqList.get(i).getPqnaNo()%>"><%=mypqList.get(i).getPqnaTitle()%>
						</a></td>
						<td><%=mypqList.get(i).getProId()%></td>
						<td><%=mypqList.get(i).getDateFormat()%></td>
						<%
							if (mypqList.get(i).getPqnaStatus() == 0) {
						%>
						<td>답변안됨</td>
						<%
							} else {
						%>
						<td>답변완료</td>
						<%
							}
						%>


						<%
							}
						} else if (mypqList.size() == 0) {
						%>
					
					<tr>
						<td colspan="5" style="padding: 30px; font-size: 20px;">문의내역이 없습니다.</td>
					<tr>
						<%
							}
						%>
					
				</tbody>
			</table>
		</div>

	</div>
</div>


</div>
</div>

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

</html>