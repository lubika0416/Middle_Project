<%@page import="vo.ReviewVO"%>
<%@page import="vo.ReservationVO"%>
<%@page import="vo.FileVO"%>
<%@page import="java.util.List"%>
<%@page import="vo.MemberVO"%>
<%@page import="vo.PQNAVO"%>
<%@page import="vo.AQNAVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	MemberVO mv = (MemberVO) session.getAttribute("loginInfo");
List<ReservationVO> reserList = (List<ReservationVO>) request.getAttribute("reserList");
List<PQNAVO> mypqList = (List<PQNAVO>) request.getAttribute("mypqList");
List<AQNAVO> myaqList = (List<AQNAVO>) request.getAttribute("myaqList");
List<ReviewVO> reviewList = (List<ReviewVO>) request.getAttribute("reviewList");
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
<link href="<%=request.getContextPath()%>/css/font.css"
	rel="stylesheet" />
<link href="<%=request.getContextPath()%>/css/memberMypage.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" />
<style>
* {
	font-family: 'GmarketSansMedium';
}
</style>
</head>
<body>

	<div class="myheader">
		<div class="myheadermargin">
			<div class="myheadermargin2">
				<div style="display: flex; align-items: center;">
					<div class="profileimg">
						<img src="<%=request.getContextPath()%>/images/profile.png"
							class="card-img-top" alt="profile.png"
							style="border-radius: 100% !important;" />
					</div>
					<div>
						<div class="proName"><%=mv.getMemName()%></div>
						<span class="proSub">일반 회원</span>
					</div>
				</div>
				<div class="rightarray">
					<div class="textbbox">
						<div class="proName">
							<%-- <%=reserList.size() %> --%>
							<%=mv.getResNo() %>
						</div>
						<div class="proSub">나의 예약</div>
					</div>
					<hr style="width: 2px; height: 40px; background: #585858;">
					<div class="textbbox">
						<div class="proName">
							<%-- <%=reviewList.size() %> --%>
							<%=mv.getReviewNo() %>
						</div>
						<div class="proSub">작성한 리뷰</div>
					</div>
					<hr style="width: 2px; height: 40px; background: #585858;">
					<div class="textbbox" style="margin-right: -20px;">
						<div class="proName"><%=mv.getFavoriteNo()%></div>
						<div class="proSub">관심 클래스</div>
					</div>
				</div>
			</div>

			<div class="listContainer">
				<div class="card-body">
					<ul class="list-group list-group-flush"
						style="flex-direction: row !important; display: flex; justify-content: space-between;">
						<a href="<%=request.getContextPath()%>/mypage.do?memId=<%=mv.getMemId()%>">
							<li class="list-group-item mylike">관심 목록</li>
						</a>
						<a href="<%=request.getContextPath()%>/member/reservationList.do?memId=<%=mv.getMemId()%>">
							<li class="list-group-item myreserv">예약 내역</li>
						</a>
						<a href="<%=request.getContextPath()%>/member/myPQNAList.do?memId=<%=mv.getMemId()%>">
							<li class="list-group-item mypqna">클래스 문의 내역</li>
						</a>
						<a  href="<%=request.getContextPath()%>/member/myAQNAList.do?memId=<%=mv.getMemId()%>">
							<li class="list-group-item myaqna">관리자 문의 내역</li>
						</a>
						<a href="<%=request.getContextPath()%>/member/myReviewList.do?memId=<%=mv.getMemId()%>">
							<li class="list-group-item myrevi">내가 쓴 리뷰</li>
						</a>
						<a href="<%=request.getContextPath()%>/member/mypageupdate.do?memId=<%=mv.getMemId()%>">
							<li class="list-group-item myinfo">내 정보</li>
						</a>
					</ul>
				</div>
			</div>
		</div>
	</div>


	<div class="myheadermargin">
		<div class="mypagerow">
			<!-- 사업자 마이페이지 좌측 메뉴 -->
</body>
</html>