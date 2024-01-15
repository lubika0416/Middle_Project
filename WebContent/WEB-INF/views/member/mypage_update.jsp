<%@page import="java.util.Locale"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
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
	font-family: 'Pretendard5';
}

#fc-dom-1 {
	font-size: 20px;
}

.myinfo {
color: var(--CI, #00E577) !important;
}
</style>
</head>

<body>
	<!-- Header-->
	<%@include file="../common/mainheader.jsp"%>

	<%@include file="memAside.jsp"%>
	<%
		if (mv instanceof MemberVO) {

		String addr = mv.getMemAddr();
		String zipCode = addr.substring(0, 5);
		String addr2 = addr.substring(6);

		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

		String date = sdf1.format(mv.getMemBirth());

		long birth = mv.getMemBirth().getTime();
	%>



	<div class="mypagimargin" style="padding: 8px;">
		<div class="calbox">
			<div class="mycontenttitle" >내정보</div>

			<hr class="mycontentbar" />

		<form class="validation-form" novalidate
		action="<%=request.getContextPath()%>/member/mypageupdate.do"
		method="post" enctype="multipart/form-data">
		<input type="hidden" name="memId" value="<%=mv.getMemId()%>">
			<div class="table-responsive small"
				style="display: flex; justify-content: center; margin: 30px">
				<table class="row table table-borderless" style="width: 500px;">
					<tr>
						<th scope="row" class="tbTitle2" style="display: flex;">이름</th>
						<td colspan="2"><input type="text" class="form-control"
							id="name" placeholder="" value="<%=mv.getMemName()%>"
							name="memName" /></td>
					</tr>
					<tr style="display: flex;     flex-direction: row;">
						<th scope="row" class="tbTitle2" style="display: flex;">아이디</th>
						<td colspan="2" style="display: flex; align-items: center;"><%=mv.getMemId()%></td>
					</tr>
					<tr>
						<th scope="row" class="tbTitle2" style="display: flex;">비밀번호</th>
						<td colspan="2"><input type="text" class="form-control"
							id="password" placeholder="" name="memPw"
							value="<%=mv.getMemPw()%>" /></td>
					</tr>
					<tr>
						<th scope="row" class="tbTitle2" style="display: flex;">전화번호</th>
						<td colspan="2"><input type="tel" class="form-control"
							id="tel" placeholder="" value="<%=mv.getMemTel()%>" name="memTel" />
						</td>
					</tr>

					<tr>
						<th scope="row" class="tbTitle2" style="display: flex;">이메일</th>
						<td colspan="2"><input type="email" class="form-control"
							id="email" placeholder="" value="<%=mv.getMemMail()%>"
							name="memMail" /></td>
					</tr>

					<tr style="display: flex; flex-direction: row;">
						<th scope="row" rowspan="2" class="tbTitle2">주소</th>
						<td><input type="text" class="form-control" id="zipCode"
							placeholder="" value="<%=zipCode%>" /></td>
						<td><input class="col" type="button" value="주소찾기"
							onclick="sample6_execDaumPostcode()" style="border: none; 
							color: var(--CI, #00E577); background-color: #000;
							border-radius: 8px; height: 38px; " /></td>
					</tr>
					<tr>
						<th style="width: 100px;"> </th>
						<td colspan="2"><input type="text" class="form-control"
							id="address" placeholder="" value="<%=addr2%>" name="memAddr" /></td>
					</tr>
					<tr style="display: flex;     flex-direction: row;">
						<th scope="row" class="tbTitle2" style="display: flex;">생년월일</th>
						<td colspan="2" id="jav" style="display: flex; align-items: center;"><%=date%></td>
					</tr>
					<tr>
						<th scope="row" class="tbTitle2" style="display: flex;">성별</th>
						<td><select class="form-select" id="gender"
							aria-label="Default select example" required>
								<option value="none">선택 안함</option>
								<option value="men">남성</option>
								<option value="woman">여성</option>
						</select>
							<p id="gd" style="display: none;"><%=mv.getmemGender()%></p></td>
						<td></td>
					</tr>
				</table>
			</div>

			<div class="modifyBtn" style="margin-top: 60px;">
				<div class="mx-auto"
					style="display: flex; justify-content: space-evenly;">
					<button class="cancleBtn btn btn-danger" type="button"
						style="width: 230px;">취소</button>
					<button class="confirmBtn btn btn-primary" id=""
						type="submit" style="width: 230px;">수정</button>
				</div>
			</div>

		</div>
	</div>
	</form>



	</div>
	</div>




	<!-- Footer-->
	<%@include file="../common/mainfooter.jsp"%>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

	<script src="<%=request.getContextPath()%>/js/scripts.js"></script>
	<script>
		/* let date = new Date($('#jav').text());
		$('#birth').val(date); */

		let gender = document.querySelector("#gd").innerText;
		if (gender == 'men') {
			$('#gender').val("men").prop('selected', true);
		} else if (gender == 'women') {
			$('#gender').val("women").prop('selected', true);
		} else {
			$('#gender').val("none").prop('selected', true);
		}
	</script>



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