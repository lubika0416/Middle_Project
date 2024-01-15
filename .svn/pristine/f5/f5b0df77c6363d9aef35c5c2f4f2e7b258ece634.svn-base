<%@page import="vo.AcommentVO"%>
<%@page import="vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	AQNAVO aqVO = (AQNAVO) request.getAttribute("aqVO");
AcommentVO acvo = (AcommentVO) request.getAttribute("acvo");
List<AQNAVO> aqList = (List<AQNAVO>) request.getAttribute("aqList");
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
			<div class="mycontenttitle">관리자 일대일 문의</div>

			<hr class="mycontentbar" />
			
			<div class="table-responsive small">
			<table class="table table-lm">
                  <tr>
                        <th style="width:100px;">번호</th>
                        <td><%=aqVO.getAqnaNo() %></td>
                        <th style="width:100px;">작성일</th>
                        <td><%=aqVO.getFormAqnaRegdt()%></td>
                    </tr>
                    <tr>
                        <th>제목</th>
                        <td><%=aqVO.getAqnaTitle() %></td>
                        <th>작성자</th>
                        <td><%=aqVO.getMemId()%></td>
                    </tr>

                    <tr>
                        <th class="tbTitle" style="height:200px;">문의내용</th>
                        <td colspan='3' style="overflow-y: scroll; padding: 30px 120px; text-align: start; vertical-align: middle; "><%=aqVO.getAqnaContent() %></td>
                    </tr>
                    
                    <tr>
                        <th class="tbTitle" style="height:200px;">답변내용</th>
						<%
						if(acvo != null){
						%>
                        <td colspan='3' style="overflow-y: scroll; vertical-align: middle; "><%=acvo.getAcmtContent() %></td>
						<%
						}else{
						%>
                        <td colspan='3' style="overflow-y: scroll; vertical-align: middle; ">아직 답변이 등록되지 않았습니다.</td>
                        <%
						}
                        %>

                    </tr>
                </table>
			
		</div>
	</div>


	<!-- 사업자 마이페이지 중앙우측 -->
	<%-- 	<div class="col-10 my-3">
		<div>
		<!--  	<canvas id="sales"></canvas> -->
		</div>
		<h4 class="mt-3 bg">
			<span>일대일 문의</span>
		</h4>
		<div class="table-responsive small">
			<table class="table table-lm">
                  <tr>
                        <th style="width:100px;">번호</th>
                        <td><%=aqVO.getAqnaNo() %></td>
                        <th style="width:100px;">작성일</th>
                        <td><%=aqVO.getFormAqnaRegdt()%></td>
                    </tr>
                    <tr>
                        <th>제목</th>
                        <td><%=aqVO.getAqnaTitle() %></td>
                        <th>작성자</th>
                        <td><%=aqVO.getMemId()%></td>
                    </tr>

                    <tr>
                        <th style="height:400px;">문의내용</th>
                        <td colspan='3' style="height:400px; overflow-y: scroll; "><%=aqVO.getAqnaContent() %></td>
                    </tr>
                    
                    <tr>
                        <th style="height:200px;">답변내용</th>
						<%
						if(acvo != null){
						%>
                        <td colspan='3' style="height:200px; overflow-y: scroll; "><%=acvo.getAcmtContent() %></td>
						<%
						}else{
						%>
                        <td colspan='3' style="height:200px; overflow-y: scroll; ">아직 답변이 등록되지 않았습니다.</td>
                        <%
						}
                        %>

                    </tr>
                </table>
                
                <div style="margin-bottom: 40px;">
                

                </div>
                
                </div>
                </div> --%>

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