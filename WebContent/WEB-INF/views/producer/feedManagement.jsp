<%@page import="java.text.SimpleDateFormat"%>
<%@page import="vo.FeedVO"%>
<%@page import="vo.ClassesVO"%>
<%@page import="vo.FileVO"%>
<%@page import="java.util.List"%>
<%@page import="vo.ProducerVO"%>
<% SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");%>
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
	src="
https://cdn.jsdelivr.net/npm/fullcalendar@6.1.8/index.global.min.js
"></script>
<link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">


<style>
* {
	font-family: "Pretendard5";
}

#fc-dom-1 {
	font-size: 20px;
}

.aaa {
	background-color: var(--CI, #00E577) !important;
	border: none !important;
	color: black !important;
	width: 142px;
	height: 40px;
}

.aaa:hover {
	background-color: black !important;
	border: none !important;
	color: var(--CI, #00E577) !important;
	width: 142px;
	height: 40px;
}

.create_class {
	background-color: black !important;
	border: none !important;
	color: var(--CI, #00E577) !important;
	width: 142px;
	height: 40px;
}

.create_class:hover {
	background-color: var(--CI, #00E577) !important;
	border: none !important;
	color: black !important;
	width: 142px;
	height: 40px;
}

.promyfeed {
	color: var(--CI, #00E577) !important;
}
</style>
</head>
<body>
	<%
		Object obj = request.getAttribute("fInsertResult");

	if (obj != null) {
		boolean insertResult = (boolean) obj;
		if (insertResult) {
	%>
	<script>
		alert("피드 등록을 성공했습니다.")
	</script>
	<%
		} else {
	%>
	<script>
		alert("피드 등록에 실패했습니다.")
	</script>
	<%
		}
	}

	obj = request.getAttribute("deleteResult");
	if (obj != null) {
	boolean insertResult = (boolean) obj;
	if (insertResult) {
	%>
	<script>
		alert("피드 삭제를 성공했습니다.")
	</script>
	<%
		} else {
	%>
	<script>
		alert("피드 삭제를 실패했습니다.")
	</script>
	<%
		}
	}

	obj = request.getAttribute("updateResult");
	if (obj != null) {
	boolean insertResult = (boolean) obj;
	if (insertResult) {
	%>
	<script>
		alert("피드 수정을 성공했습니다.")
	</script>
	<%
		} else {
	%>
	<script>
		alert("피드 수정을 실패했습니다.")
	</script>
	<%
		}
	}

	request.removeAttribute("fInsertResult");

	Object vo = session.getAttribute("loginInfo");

	List<FeedVO> feedList = (List<FeedVO>) session.getAttribute("feedList");

	List<List<FileVO>> feedFileList = (List<List<FileVO>>) session.getAttribute("feedFileList");

	if (vo instanceof ProducerVO) {
	%>
	<!-- Header-->
	<%@include file="../common/mainheader.jsp"%>


	<%@ include file="proAside.jsp"%>

	<div class="mypagimargin" style="padding: 8px;">
		<div class="marginppp" style="width: 1120px;">
			<div style="display: flex; justify-content: space-between;">
				<div class="mycontenttitle">피드 관리</div>
					<a href="<%=request.getContextPath()%>/producer/insertfeed.do?proId=<%=pv.getProId()%>">
					<button type="button" class="btn aaa">+ 피드 추가하기</button></a>
			</div>

			<hr class="mycontentbar2" />
			
			<div style="width: 100%; height: 100%; display: flex; flex-wrap: wrap; flex-direction: row;">

			<%
				if (feedList != null && feedList.size() > 0 && feedFileList != null && feedFileList.size() > 0) {
				for (int i = 0; i < feedList.size(); i++) {
			%>
			
			<!-- 목록 시작 -->
			<div class="class_container" style="padding: 0px; height: fit-content;">
				
				<div   style="display: flex; height: fit-content; align-content: stretch; justify-content: flex-start; margin: 16px;">
                      <div class="realContent_feed">

					
							<div class="card" data-aos="fade-bottom" style="width: 520px; height: auto; margin: 20px 0px; border: none;">
								<div class="feedimg">
									<img src="<%=request.getContextPath()%>/upload_images/<%=feedFileList.get(i).get(0).getFileSvNm()%>" style="width:  100%; height: auto; border-radius: 24px;"/>
								</div>
								<div>
									<p class="feedtext" style="width: 520px;" ><%=feedList.get(i).getFeedContent()%></p>
									<div class="row" style="justify-content: space-between; width: 520px; margin: 0px;">
									<p class="feedtime" style="width: 200px;">
										<%=sdf.format(feedList.get(i).getFeedRegdt()) %> 
									</p>
									<div style="width: 200px; display: flex; justify-content: flex-end;">	
											<button type="button" class="btn"
											onclick="feedUpdate(<%=feedList.get(i).getFeedNo()%>)" style="padding:0px; margin: 0px; width:20px;">
												<?xml version="1.0" ?>
												<svg height="20" viewBox="0 0 48 48" width="20" xmlns="http://www.w3.org/2000/svg" style="fill: #999;">
												<path d="M6 34.5v7.5h7.5l22.13-22.13-7.5-7.5-22.13 22.13zm35.41-20.41c.78-.78.78-2.05 0-2.83l-4.67-4.67c-.78-.78-2.05-.78-2.83 0l-3.66 3.66 7.5 7.5 3.66-3.66z"/>
												<path d="M0 0h48v48h-48z" fill="none"/>
												</svg>
											</button>
											<button type="button" class="btn"
											onclick="feedDelete(<%=feedList.get(i).getFeedNo()%>)" style="padding:0px; margin: 0px; width:20px;">
												<?xml version="1.0" ?>
												<svg height="20" viewBox="0 0 48 48" width="20" xmlns="http://www.w3.org/2000/svg" style="fill: #999;">
													<path d="M0 0h48v48H0V0z" fill="none"/>
													<path d="M12 38c0 2.2 1.8 4 4 4h16c2.2 0 4-1.8 4-4V14H12v24zm4.93-14.24l2.83-2.83L24 25.17l4.24-4.24 2.83 2.83L26.83 28l4.24 4.24-2.83 2.83L24 30.83l-4.24 4.24-2.83-2.83L21.17 28l-4.24-4.24zM31 8l-2-2H19l-2 2h-7v4h28V8z"/>
													<path d="M0 0h48v48H0z" fill="none"/>
												</svg>
											</button>
										</div>	
									</div>
									
								</div>
							</div>
					
						</div>
                    </div>
			
				
				<!-- 클래스 수정 버튼 -->
				
					
				
			</div>
			<!-- 목록 끝  -->
			<script>
		function feedUpdate(feedNo) {
			location.href = "updatefeed.do?feedNo="+feedNo
		}
		
		function feedDelete(feedNo) {
			location.href = "deletefeed.do?feedNo="+feedNo
				}
			</script>
			<%
				}
			} else {
			%>
			<div style="
			display: flex;
			height: 80%;
			align-items: center;
    		justify-content: center;
			">
				<h3>피드를 등록해주세요</h3>
			</div>
			<%
				}
			%>
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
	<script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>


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


<script>
    AOS.init();
</script>
</body>
</html>
</FileVO>
</FileVO>
