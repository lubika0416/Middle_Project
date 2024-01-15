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
	src="
https://cdn.jsdelivr.net/npm/fullcalendar@6.1.8/index.global.min.js
"></script>

<style>
* {
	font-family: "Pretendard5" !important;
	font-size: 18px;

#fc-dom-1 {
	font-size: 20px;
}

.rating {
	font-size: 24px;
}

.star {
	display: inline-block;
	width: 30px; /* 별의 크기 조절 */
	text-align: center;
	font-size: 24px;
	cursor: pointer;
}

.star.active {
	color: gold;
}

.myrevi {
color: var(--CI, #00E577) !important;
}
</style>
</head>
<%	

	Object obj = request.getAttribute("deleteReviewResult");
	if (obj != null) {
		boolean result = (boolean) obj;
		if (result) {%>
			<script>alert("리뷰 삭제를 성공했습니다.")</script>
		<%} else {%>
			<script>alert("리뷰 삭제를 실패했습니다.")</script>
		<%}%>
	<%}request.removeAttribute("deleteReviewResult");
	
	obj = request.getAttribute("updateReviewResult");
	if (obj != null) {
		boolean result = (boolean) obj;
		if (result) {%>
			<script>alert("리뷰 수정을 성공했습니다.")</script>
		<%} else {%>
			<script>alert("리뷰 수정을 실패했습니다.")</script>
		<%}%>
	<%}request.removeAttribute("updateReviewResult");
	
	Object vo = session.getAttribute("loginInfo");
	if (vo != null && vo instanceof MemberVO) {
 %>

<!-- Header-->
<%@include file="../common/mainheader.jsp"%>


<%@include file="memAside.jsp"%>

<div class="mypagimargin" style="padding: 8px;">
	<div class="calbox">
		<div class="mycontenttitle">나의 리뷰</div>

		<hr class="mycontentbar" />
		
		<div class="table-responsive small">
					<table class="table table-lm">
						<thead>
							<tr>
								<th class="tbTitle">리뷰번호</th>
								<th class="tbTitle">클래스명</th>
								<th class="tbTitle">작성날짜</th>
								<th class="tbTitle">내용</th>
								<th class="tbTitle">예약번호</th>
							</tr>
						</thead>

						<tbody>
							<%
							if(reviewList.size() > 0){
								for(int i = 0; i < reviewList.size(); i++){
							%>
							<tr>
								<td id="reviewNo"><%= reviewList.get(i).getReviewNo() %></td>
								<td><a href="" id="detailReview" onclick="reviewModal(<%=reviewList.get(i).getReviewNo()%>, event)"><%= reviewList.get(i).getClsName()%></a></td>
								<td><%= reviewList.get(i).getFormDt()%></td>
								<%if (reviewList.get(i).getReviewContent().length() > 30){%>
									<td><%=reviewList.get(i).getReviewContent().substring(0,31)%></td>
								<%} else {%>
									<td><%=reviewList.get(i).getReviewContent()%></td>
								<%}%>
								<td><%= reviewList.get(i).getResNo()%></td>
								<%
								}
							}else if(reviewList.size() == 0){
							%>
							<tr>
								<td colspan="5" style="padding: 30px; font-size: 20px;">작성한 리뷰가 없습니다.</td>
							<tr>
								<%
							}
							%>
							
						</tbody>
					</table>
				</div>		
	</div>
</div>


<!-- 사업자 마이페이지_내정보 중앙 -->
<%-- 			<div class="col-10 my-3">
				<div class="row mypage_modify_top">
					<h3>나의 리뷰</h3>
					<hr class="mb-4" />
				</div>
				<div class="table-responsive small">
					<table class="table table-lm">
						<thead>
							<tr>
								<th>리뷰번호</th>
								<th>클래스명</th>
								<th>작성날짜</th>
								<th>내용</th>
								<th>예약번호</th>
							</tr>
						</thead>

						<tbody>
							<%
							if(reviewList.size() > 0){
								for(int i = 0; i < reviewList.size(); i++){
							%>
							<tr>
								<td id="reviewNo"><%= reviewList.get(i).getReviewNo() %></td>
								<td><a href="" id="detailReview" onclick="reviewModal(<%=reviewList.get(i).getReviewNo()%>, event)"><%= reviewList.get(i).getClsName()%></a></td>
								<td><%= reviewList.get(i).getFormDt()%></td>
								<td><%= reviewList.get(i).getReviewContent()%></td>
								<td><%= reviewList.get(i).getResNo()%></td>
								<%
								}
							}else if(reviewList.size() == 0){
							%>
							
							<tr>
								<td>리뷰내역이 없습니다.</td>
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
<div class="modal fade" id="reviewModal" tabindex="-1"
	data-bs-backdrop="static" aria-labelledby="exampleModalLabel"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered">
		<div class="modal-content">
			<div class="modal-header" style="background-color: black; color: #fff;">
				<h1 class="modal-title card-store" id="exampleModalLabel">리뷰 조회</h1>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close" style="background-color: #fff;"></button>
			</div>
			<!-- 여기부터 모달 내용 시작 -->
			<div class="modal-body mtablediv" style="display: flex; justify-content: center;"></div>
			<!-- 여기까지가 모달 내용 끝 -->
			<div class="modal-footer reviewFooter"></div>
		</div>
	</div>
</div>

<script>
	
	function updateReview(reviewNo) {
		location.href = "http://localhost:8888/Jdus/member/updatereview.do?reviewNo="+reviewNo;
	}
	
	function deleteReview(reviewNo) {
		location.href = "http://localhost:8888/Jdus/member/deletereview.do?reviewNo="+reviewNo;
	}
	

	function reviewModal(reviewNo, event){
		event.preventDefault();
		
		console.log(reviewNo);
		
		
		$.ajax({
			url: 'http://localhost:8888/Jdus/member/detailreview.do?reviewNo='+reviewNo,
			type: 'get',
			success: function(rsp){
				console.log(rsp);
				const info = JSON.parse(rsp.rv);
				const fileInfo = JSON.parse(rsp.flist);
				console.log(info)
				console.log(fileInfo)
				if (fileInfo.length > 0) {
					document.querySelector('.mtablediv').innerHTML = 
					`<div class="card" style="width: 90%; border: none;">
						<img src="<%=request.getContextPath()%>/upload_images/` + fileInfo[0].fileSvNm + `" class="card-img-top" alt="..." style="max-height: 400px;">
						<div class="card-body" style="margin: 0px;">
							<p class="card-text" >` + info.reviewContent + `</p>
							<div class="rating" id="rating">
						    </div>
						</div>
					</div>`
				} else {
					document.querySelector('.mtablediv').innerHTML = 
					`<div class="card" style="width: 18rem;">
						<img src="<%=request.getContextPath()%>/images/no_image.png" class="card-img-top" alt="...">
						<div class="card-body">
							<p class="card-text" style="margin: 0px;">` + info.reviewContent + `</p>
							<div class="rating" id="rating">
						    </div>
						</div>
					</div>`
				}
				
				document.querySelector('.reviewFooter').innerHTML = 
					`<button type="button" class="btn btn-warning" onclick="updateReview(` + info.reviewNo + `)">리뷰 수정</button>
					 <button type="button" class="btn btn-danger" onclick="deleteReview(` + info.reviewNo + `)">리뷰 삭제</button>
					 <button type="button" class="btn btn-primary" data-bs-dismiss="modal">확인</button>`
				
				const rating = info.reviewRating;
				console.log(rating);
				
				// 별점을 0.5 칸 단위로 계산
				const filledHalfStars = Math.floor(rating / 2);
				const hasHalfStar = rating % 2 === 1;
				
				// 별 아이콘을 표시할 div 요소 선택
				const ratingDiv = document.getElementById("rating");

				// 0.5 칸으로 채워질 별 아이콘을 생성하고 채우기
				for (let i = 0; i < filledHalfStars; i++) {
				    const starIcon = document.createElement("i");
				    starIcon.classList.add("star", "bi", "bi-star-fill");
				    ratingDiv.appendChild(starIcon);
				}

				// 반 별 아이콘이 필요한 경우 (예: 1.5, 2.5)
				if (hasHalfStar) {
				    const halfStarIcon = document.createElement("i");
				    halfStarIcon.classList.add("star", "bi", "bi-star-half");
				    ratingDiv.appendChild(halfStarIcon);
				}

				// 빈 별 아이콘을 채우기 (0.5 단위)
				const emptyHalfStars = 5 - filledHalfStars - (hasHalfStar ? 1 : 0);
				for (let i = 0; i < emptyHalfStars; i++) {
				    const starIcon = document.createElement("i");
				    starIcon.classList.add("star", "bi", "bi-star");
				    ratingDiv.appendChild(starIcon);
				}
				  
				$('#reviewModal').modal('show');
				
				
			},
			error: function(xhr){
				console.log(xhr)
			},
			dataType: 'json'
		})
		
	}
</script>


<%@include file="../common/mainfooter.jsp"%>
<!-- Bootstrap core JS-->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

<script src="<%=request.getContextPath()%>/js/scripts.js"></script>
<script src="<%=request.getContextPath()%>/js/proMypage.js"></script>
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