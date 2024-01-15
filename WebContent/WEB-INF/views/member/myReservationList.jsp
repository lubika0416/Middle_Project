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
<link href="<%=request.getContextPath()%>/css/memberMypage.css"
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
	font-family: 'GmarketSansMedium';
}

#fc-dom-1 {
	font-size: 20px;
}

.myreserv {
color: var(--CI, #00E577) !important;
}
</style>
</head>
<%	

	Object deleteresresult = request.getAttribute("deleteresresult");
	if (deleteresresult != null) {
		boolean result =  (boolean)deleteresresult;
		if (result) {%>
			<script type="text/javascript">alert("예약이 삭제되었습니다.")</script>
		<%} else {%>
			<script type="text/javascript">alert("예약 삭제에 실패했습니다.")</script>
		<%}
	}
	request.removeAttribute("deleteresresult");
	
	Object insertreviewresult = request.getAttribute("insertreviewresult");
	if (insertreviewresult != null) {
		boolean result =  (boolean)insertreviewresult;
		if (result) {%>
			<script type="text/javascript">alert("리뷰 작성이 완료되었습니다.")</script>
		<%} else {%>
			<script type="text/javascript">alert("리뷰 작성을 실패했습니다.")</script>
		<%}
	}
	request.removeAttribute("insertreviewresult");

	Object vo = session.getAttribute("loginInfo");
if (vo != null && vo instanceof MemberVO) {
%>

<!-- Header-->
<%@include file="../common/mainheader.jsp"%>

<%@include file="memAside.jsp"%>
<div class="mypagimargin" style="padding: 8px;">
	<div class="calbox">
		<div class="mycontenttitle">예약내역</div>

		<hr class="mycontentbar" />

		<div class="table-responsive small">
			<table class="table table-lm">
				<thead>
					<tr>
						<th class="tbTitle">예약번호</th>
						<th class="tbTitle">예약인원수</th>
						<th class="tbTitle">예약등록날짜</th>
						<th class="tbTitle">클래스 이름</th>
						<th class="tbTitle">리뷰 작성 여부</th>
						
					</tr>
				</thead>

				<tbody>
					<%
						if (reserList.size() > 0) {
							for (int i = 0; i < reserList.size(); i++) {%>
						<tr>
							<input type="hidden" name="resNo" id="resNo" value="<%=reserList.get(i).getResNo()%>">
							<td><a href="#" onclick="resModal(<%=reserList.get(i).getResNo()%>)"><%=reserList.get(i).getResNo()%></a></td>
							<td><%=reserList.get(i).getResCnt()%></td>
							<td><%=reserList.get(i).getDateFormat()%></td>
							<td><%=reserList.get(i).getClsName()%></td>
								<%if (reserList.get(i).isExistReview()) {%>
								<td>작성 완료</td>
								<%} else {%>
								<td>미작성</td>
								<%}	
							}
						} else {%>
						<td colspan="5" style="padding: 30px; font-size: 20px;">예약 내역이 없습니다.</td>
						
						<%}%>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>
</div>
</div>



<div class="modal fade" id="eventModal" tabindex="-1"
	data-bs-backdrop="static" aria-labelledby="exampleModalLabel"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered">
		<div class="modal-content">
			<div class="modal-header" style="background-color: #000; color: #fff;">
				<h1 class="modal-title card-store" id="exampleModalLabel">예약 조회</h1>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close" style="background-color: #fff;"></button>
			</div>
			<!-- 여기부터 모달 내용 시작 -->
			<div class="modal-body mtablediv"></div>
			<!-- 여기까지가 모달 내용 끝 -->
			<div class="modal-footer">
				<button type="button" class="btn btn-success" id="review" disabled>리뷰
					작성</button>
				<button type="button" class="btn btn-primary"
					data-bs-dismiss="modal">확인</button>
				<button type="button" class="btn btn-primary"
					data-bs-dismiss="modal" id="cancel">예약취소</button>
			</div>
		</div>
	</div>
</div>
<%@include file="../common/mainfooter.jsp"%>

<script type="text/javascript">
	function resModal(resNo) {
		let info = [];
		$.ajax({
			url: "http://localhost:8888/Jdus/myReservation.do?resNo="+resNo,
			type: 'get',
			success: function(rsp){
				info = { ...JSON.parse(rsp.rv), ...JSON.parse(rsp.sv), ...JSON.parse(rsp.pv)};
				console.log(info);
				document.querySelector('.mtablediv').innerHTML = 
				`<table class="mtable">
					<tr>
						<th>클래스 이름:</th>
						<td>` + info.clsName + `</td>
					</tr>
					<tr>
						<th>시간:</th>
						<td><span>` + info.startTime + `</span>&nbsp;~&nbsp;<span>` + info.endTime + `</span></td>
					</tr>
					<tr>
						<th>예약 인원:</th>
						<td><span>` + info.resCnt + `</span></td>
					</tr>
					<tr>
						<th>결제 금액:</th>
						<td><span>` + info.finalPrice + `</span></td>
					</tr>
				</table>`
				
				console.log(rsp.isExist)
				if (rsp.isExist == true) {
					$('#review').text("리뷰가 작성된 예약내역입니다.")
				} else {
					let resDate = new Date(info.cssDate);
					let today = new Date().getTime();
					
					if (info.cssDate > today) {
						$('#review').prop('disabled', true);
						$('#review').text("클래스 수강 후 리뷰작성이 가능합니다..")
					}
					else {
						$('#review').prop('disabled', false);
						$('#review').text("리뷰 작성")
					}
				}
				
				
				
				$('#eventModal').modal('show');
				
				$('#review').on('click', function(){
					location.href="http://localhost:8888/Jdus/member/review.do?resNo="+info.resNo+"&clsId="+info.clsId;
				})
			},
			error: function(xhr) {
				console.log(xhr);
			},
			dataType: 'json',
		})
	}
	// 클래스 예약취소하는 부분
	var resNoo = document.querySelector('#resNo').value;
	document.querySelector('#cancel').addEventListener('click', function(){
	location.href = "cancelReservation.do?resNo=" +  resNoo;
	})
	
</script>


<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="<%=request.getContextPath()%>/js/scripts.js"></script>
<%-- <script src="<%=request.getContextPath()%>/js/proMypage.js"></script> --%>
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