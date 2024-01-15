<%@page import="vo.PCommentVO"%>
<%@page import="vo.ProducerVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	PQNAVO pqVO = (PQNAVO)request.getAttribute("pqVO");
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

	<!-- 사업자 마이페이지 중앙우측 -->
	<div class="mypagimargin" style="padding: 8px;">
		<div class="calbox3">
			<div class="mycontenttitle">일대일 문의</div>

			<hr class="mycontentbar2" />

			<div class="table-responsive small">
				<table class="table table-lm">
					<tr>
						<th style="width: 100px;">번호</th>
						<td><%=pqVO.getPqnaNo() %></td>
						<th style="width: 100px;">작성일</th>
						<td><%=pqVO.getDateFormat()%></td>
					</tr>
					<tr>
						<th>제목</th>
						<td><%=pqVO.getPqnaTitle() %></td>
						<th>작성자</th>
						<td><%=pqVO.getMemId() %></td>
					</tr>

					<tr>
						<th style="height: 400px;">문의내용</th>
						<td colspan='3' style="height: 400px; overflow-y: scroll;"><%=pqVO.getPqnaContent() %></td>
					</tr>

					<form action="answerPQNA.do" method="post">

						<tr>
							<th style="height: 200px;">답변내용</th>
							<td colspan='3'><textarea name="pcmtContent"
									style="height: 200px; width: 100%; overflow-y: scroll;"></textarea></td>
						</tr>
				</table>

				<div style="margin-bottom: 40px;">
					<%--                 <button  type="button" onclick="location.href='<%=request.getContextPath()%>/admin/QNABoard.do'" class="btn btn-secondary" style="width:100px;">답변등록</button> --%>
					<input type="submit" value="답변등록" class="btn btn-secondary">
					<input type="hidden" name="proId" value="<%=pqVO.getProId()%>">
					<input type="hidden" name="pqnaNo" value="<%=pqVO.getPqnaNo()%>">
					</form>

				</div>

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