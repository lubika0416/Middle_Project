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
	font-family: "GmarketSansMedium";
}

#fc-dom-1 {
	font-size: 20px;
}

.promyclass {
	color: var(--CI, #00E577) !important;
}

.addclasscontent{
padding: 24px;
width: 80%;
}

label {
font-family: 'Pretendard7';
width: 140px;
}

.aaa {
	background-color: var(--CI, #00E577) !important;
	border: none !important;
	color: black !important;
}

.aaa:hover {
	background-color: black !important;
	border: none !important;
	
</style>
</head>

<body>
	<%
		Object vo = session.getAttribute("loginInfo");
	ClassesVO cv = (ClassesVO) request.getAttribute("cVo");
	if (vo instanceof ProducerVO) {
	%>
	<!-- Header-->
	<%@include file="../common/mainheader.jsp"%>


	<%@ include file="proAside.jsp"%>

	<div class="mypagimargin" style="padding: 8px;">
		<div class="calbox3">
			<div class="mycontenttitle">클래스 수정</div>

			<hr class="mycontentbar2" />
			<div class="defaultmargin">
			<div class="addclasscontent"
				style="align-items: center;">
				<form action="<%=request.getContextPath()%>/producer/updateclass.do"
					method="post" enctype="multipart/form-data">
					<input type="hidden" name="proId" value="<%=pv.getProId()%>">
					<input type="hidden" name="clsId" value="<%=cv.getClsId()%>">
					<div class="formcontainer">
						<label for="classTitle" style="width: 140px;">클래스 제목</label> <input type="text"
							class="underline" id="classTitle" placeholder=""
							name="clsTitle" required value="<%=cv.getClsName()%>" style="width: 700px;" />
						<!-- <div class="invalid-feedback">아이디를 입력해주세요.</div> -->
					</div>

					<div class="formcontainer">
						<!-- <label for="classCatecory">카테고리</label>
						<select class="underline" name="cateNo"
							aria-label="Default select example" style="margin-right: 28px;">
							<option selected>선택</option>
							<option value="1">공예</option>
							<option value="2">요리</option>
							<option value="3">미술</option>
							<option value="4">플라워</option>
							<option value="5">뷰티</option>
							<option value="6">체험 및 기타</option>
						</select> -->
						
						<label for="classPrice" style="width: 140px;">가격</label> <input type="number"
							class="underline" id="classPrice" placeholder=""
							name="clsPrice" style="margin-right: 28px;" required value="<%=cv.getClsPrice()%>" />
						<!-- <div class="invalid-feedback">아이디를 입력해주세요.</div> -->
							<label for="classDuring">최대 수용인원</label> <input type="number"
							class="underline" id="classDuring" placeholder="" required
							name="clsMxPs" value="<%=cv.getClsMxps()%>"/>
					</div>


					

					<div class="formcontainer">
						  
						<label for="classDuring">수업 시간(분)</label> <input type="number"
							class="underline" id="classDuring" placeholder="" required
							name="clsTime" style="margin-right: 28px;" value="<%=cv.getClsTime()%>" />
						<label for="classImg" style="width: 140px;">클래스 소개 사진</label> <input type="file"
							class="form-control" id="classImg" accept="image/*" required
							multiple name="file" style="width: 262px; display: inline;" />
						<!-- <div class="invalid-feedback">아이디를 입력해주세요.</div> -->
					</div>


					<div class="formcontainer">
						<label for="description2" style="width: 140px;">클래스 내용 소개</label> <input type="text"
							class="form-control" id="description2"
							placeholder="클래스 내용을 입력해주세요. (추후 수정 가능)" style="height: 100px"
							name="clsDesc" minlength="20" value="<%=cv.getClsDesc()%>"  />
					</div>
					<div class="formcontainer"
						style="justify-content: space-between">
						<div class="formcontainer" style="display: flex; justify-content: center;">
							<button type="submit"
								class="btn aaa">
								+ 클래스 수정하기</button>
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