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
	crossorigin="anonymous">
<link href="<%=request.getContextPath()%>/css/styles.css"
	rel="stylesheet" />
<link href="<%=request.getContextPath()%>/css/font.css" rel="stylesheet" />
<link href="<%=request.getContextPath()%>/css/proMypage.css"
	rel="stylesheet" />
<link href="<%=request.getContextPath()%>/css/proMypage_update.css"
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
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<style>
* {
	font-family: 'Pretendard5';
}

#fc-dom-1 {
	font-size: 20px;
}

.promyinfo {
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


	<form class="validation-form" novalidate
		action="<%=request.getContextPath()%>/producer/mypageupdate.do"
		method="post" enctype="multipart/form-data">
		<%@ include file="proAside.jsp"%>
		<input type="hidden" name="proId" value="<%=pv.getProId()%>">
		<input type="hidden" name="proRegNo" value="<%=pv.getProRegNo()%>">



		<!-- 사업자 마이페이지_내정보 중앙 -->

		<div class="mypagimargin" style="padding: 8px;">
		<div class="calbox3">
				<div class="mycontenttitle">내 정보 수정</div>
				<hr class="mycontentbar2" />
			

<div style="padding-left: 20%; margin-bottom: 50px; margin-top: 50px;	">
			<table class="row table table-borderless">
				<tr>
					<th class="tbTitle">이름</th>
					<td colspan="2"><input type="text" class="form-control"
						id="name"
						<%-- placeholder="<%=pv.getProName() %>" --%>
                      name="proName"
						value="<%=pv.getProName()%>" /></td>
				</tr>
				<tr>
					<th class="tbTitle">아이디</th>
					<td colspan="2" style="display: flex;"><%=pv.getProId()%></td>
				</tr>


				<tr>
					<th class="tbTitle">비밀번호</th>
					<td colspan="2"><input type="text" class="form-control"
						id="password" placeholder="" name="proPw"
						value="<%=pv.getProPw()%>" /></td>
				</tr>

				<tr>
					<th class="tbTitle">전화번호</th>
					<td colspan="2"><input type="tel" class="form-control"
						id="tel" placeholder="" name="proTel" value="<%=pv.getProTel()%>" />
					</td>
				</tr>

				<tr>
					<th class="tbTitle">이메일</th>
					<td colspan="2"><input type="email" class="form-control"
						id="email" placeholder="" name="proEmail"
						value="<%=pv.getProEmail()%>" /></td>
				</tr>
				<tr>
					<th class="tbTitle">사업자등록번호</th>
					<td colspan="2" style="display: flex;"><%=pv.getProRegNo()%></td>
				</tr>

				<tr>
					<th class="tbTitle">사업장 번호</th>
					<td colspan="2"><input type="tel" class="form-control"
						id="strTel" value="<%=pv.getProStrTel()%>" name="proStrTel" />
					</td>
				</tr>

				<tr>
					<th class="tbTitle">사업장명</th>
					<td colspan="2"><input type="text" class="form-control"
						id="storeName" placeholder="" name="proStore"
						value="<%=pv.getProStore()%>" /></td>
				</tr>

				<tr>
					<th class="tbTitle" rowspan="1">사업장 우편번호</th>
					<td><input type="text" class="form-control" id="zipCode"
						placeholder="" name="zip"
						value="<%=pv.getProAddr().substring(0, 5)%>" />
					</td>
					<td><input class="col" type="button" value="주소찾기"
						onclick="postCode()" /></td>
				</tr>
				<tr>
					<th class="tbTitle" rowspan="2">사업장 주소</th>
					<td colspan="2"><input type="text" class="form-control"
						id="address" placeholder="기존 상세 주소" name="proAddr"
						value="<%=pv.getProAddr()%>" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="text" class="form-control"
						id="address2" placeholder="기존 상세 주소" name="proAddr2" value="" /></td>
					<div class="mb-3" style="display: none;">
						<label for="address3"></label> <input type="text"
							class="form-control" id="address3" placeholder="" />
					</div>
				</tr>

				<tr>
					<th class="tbTitle">사업장 한줄소개</th>
					<td colspan="2"><input type="text" class="form-control"
						id="description1" placeholder="" name="proDesc"
						value="<%=pv.getProDesc()%>" /></td>
				</tr>
				<tr>
					<th class="tbTitle">사업장 세부소개</th>
					<td colspan="2"> <textarea rows="" cols="" class="form-control"
						id="description2" placeholder="" name="proPro"><%=pv.getProPro()%></textarea></td>
				</tr>

				<tr>
					<th class="tbTitle">프로필 사진 변경</th>
					<td colspan="2"><input type="file" class="form-control"
						id="profile_img" accept="image/*" name="file" multiple="multiple" />
					</td>
				</tr>
			</table>
			</div>


			<div class="row modifyBtn">
				<div class="d-grid gap-2 col-3 mx-auto">
					<button class="cancleBtn btn btn-danger" type="button">취소</button>
				</div>
				<div class="d-grid gap-2 col-3 mx-auto">
					<button class="confirmBtn btn btn-primary" id="" type="submit">수정</button>
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
	<script>
		function postCode() {
			new daum.Postcode(
					{
						oncomplete : function(data) {
							// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

							// 각 주소의 노출 규칙에 따라 주소를 조합한다.
							// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
							var addr = ""; // 주소 변수
							var extraAddr = ""; // 참고항목 변수

							//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
							if (data.userSelectedType === "R") {
								// 사용자가 도로명 주소를 선택했을 경우
								addr = data.roadAddress;
							} else {
								// 사용자가 지번 주소를 선택했을 경우(J)
								addr = data.jibunAddress;
							}

							// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
							if (data.userSelectedType === "R") {
								// 법정동명이 있을 경우 추가한다. (법정리는 제외)
								// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
								if (data.bname !== ""
										&& /[동|로|가]$/g.test(data.bname)) {
									extraAddr += data.bname;
								}
								// 건물명이 있고, 공동주택일 경우 추가한다.
								if (data.buildingName !== ""
										&& data.apartment === "Y") {
									extraAddr += extraAddr !== "" ? ", "
											+ data.buildingName
											: data.buildingName;
								}
								// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
								if (extraAddr !== "") {
									extraAddr = " (" + extraAddr + ")";
								}
								// 조합된 참고항목을 해당 필드에 넣는다.
								document.getElementById("address3").value = extraAddr;
							} else {
								document.getElementById("address3").value = "";
							}

							// 우편번호와 주소 정보를 해당 필드에 넣는다.
							document.getElementById("zipCode").value = data.zonecode;
							document.getElementById("address").value = addr;
							// 커서를 상세주소 필드로 이동한다.
							document.getElementById("address2").focus();
						},
					}).open();
		}
	</script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

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