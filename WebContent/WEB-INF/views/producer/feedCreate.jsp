<%@page import="vo.FileVO"%>
<%@page import="java.util.List"%>
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
	crossorigin="anonymous" />
<link href="<%=request.getContextPath()%>/css/styles.css"
	rel="stylesheet" />
<link href="<%=request.getContextPath()%>/css/font.css" rel="stylesheet" />
<link href="<%=request.getContextPath()%>/css/proMypage.css"
	rel="stylesheet" />
<link href="<%=request.getContextPath()%>/css/classManagement.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" />
<!-- jQuery CDN (FullCalendar은 jQuery를 필요로 합니다) -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/fullcalendar@6.1.8/index.global.min.js"></script>

<style>
* {
	font-family: 'Pretendard5';
	font-size: 20px;
}

#fc-dom-1 {
	font-size: 20px;
}

.promyfeed {
	color: var(--CI, #00E577) !important;
}

label {
font-family: 'Pretendard7';
font-size: 24px;
}

.aaa {
	background-color: var(--CI, #00E577) !important;
	border: none !important;
	color: black !important;
}

.aaa:hover {
	background-color: black !important;
	border: none !important;
	color: var(--CI, #00E577) !important;
}
</style>
</head>

<body>
	<%
		Object vo = session.getAttribute("loginInfo");
	if (vo instanceof ProducerVO) {
	%>
	<!-- Header-->
	<%@include file="../common/mainheader.jsp"%>


	<%@ include file="proAside.jsp"%>

	<div class="mypagimargin" style="padding: 8px;">
		<div class="calbox3">
			<div class="mycontenttitle">피드 추가</div>

			<hr class="mycontentbar2" />

			<div style="display: flex; justify-content: center; padding: 40px;">
				<div class="row d-flex w-75" style="align-items: center;">
					<form action="<%=request.getContextPath()%>/producer/insertfeed.do"
						method="post" enctype="multipart/form-data">

						<div class="formcontainer">
							<label for="description2">피드 내용</label>
							<textarea rows="" cols="" class="form-control" id="description2"
							placeholder="피드 내용을 입력해주세요." style="height: 300px; border: 3px solid black;"
							name="feedContent" minlength="10" ></textarea>
						</div>
						<div class="formcontainer">
							<label for="classImg">피드 사진</label> <input type="file"
								class="form-control" id="classImg" accept="image/*" required
								multiple name="file" style="border: 3px solid black;" />
							<!-- <div class="invalid-feedback">사진을 등록해주세요.</div> -->
						</div>

						<div class="class_modify_top"
							style="justify-content: space-between">
							<div class="col-8 class_top_btn">
								<button type="submit"
									class="btn aaa">
									+ 피드 추가하기</button>
							</div>
						</div>
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

	<script src="<%=request.getContextPath()%>/js/scripts.js"></script>
	<%
		} else {
	%>
	<script>
		alert("로그인이 필요한 서비스입니다.");
		location.href = "http://localhost:8888/Jdus/login.do";
	</script>
	<%
		}
	%>
</body>
</html>
</FileVO>
</FileVO>
