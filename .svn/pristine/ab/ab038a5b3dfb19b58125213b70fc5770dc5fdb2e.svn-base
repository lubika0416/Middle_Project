<%@page import="vo.FileVO"%>
<%@page import="vo.ClassesVO"%>
<%@page import="java.util.List"%>
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
<title>CLASS</title>
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
<link href="<%=request.getContextPath()%>/css/classList.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" />

<style>
* {
	font-family: 'Pretendard-Regular';

#fc-dom-1 {
	font-size: 20px;
}
</style>
</head>

<body>
<%
	List<ClassesVO> allClsList = (List<ClassesVO>) request.getAttribute("allClsList");
	List<List<FileVO>> allClsFileList = (List<List<FileVO>>) request.getAttribute("allClsFileList");
	
	List<ClassesVO> craftClsList = (List<ClassesVO>) request.getAttribute("craftClsList");
	List<List<FileVO>> craftClsFileList = (List<List<FileVO>>) request.getAttribute("craftClsFileList");
	
	List<ClassesVO> cookClsList = (List<ClassesVO>) request.getAttribute("cookClsList");
	List<List<FileVO>> cookClsFileList = (List<List<FileVO>>) request.getAttribute("cookClsFileList");
	
	List<ClassesVO> artClsList = (List<ClassesVO>) request.getAttribute("artClsList");
	List<List<FileVO>> artClsFileList = (List<List<FileVO>>) request.getAttribute("artClsFileList");
	
	List<ClassesVO> flowerClsList = (List<ClassesVO>) request.getAttribute("flowerClsList");
	List<List<FileVO>> flowerClsFileList = (List<List<FileVO>>) request.getAttribute("flowerClsFileList");
	
	List<ClassesVO> beautyClsList = (List<ClassesVO>) request.getAttribute("beautyClsList");
	List<List<FileVO>> beautyClsFileList = (List<List<FileVO>>) request.getAttribute("beautyClsFileList");
	
	List<ClassesVO> actibityClsList = (List<ClassesVO>) request.getAttribute("actibityClsList");
	List<List<FileVO>> actibityClsFileList = (List<List<FileVO>>) request.getAttribute("actibityClsFileList");
%>


	<!-- Header-->
	<%@include file="../common/mainheader.jsp"%>


	<div class="wrapper">
		<div class="defaultmargin">
			<div class=""
				style="display: flex; flex-direction: column; align-items: center;">

				<h1 class="menuBarh1">카테고리</h1>

				<nav class="menuBar">
					<button type="button" class="menuBara">전체</button>
					<button type="button" class="menuBara" id="craft">공예</button>
					<button type="button" class="menuBara" id="cook">요리</button>
					<button type="button" class="menuBara" id="art">미술</button>
					<button type="button" class="menuBara" id="flower">플라워</button>
					<button type="button" class="menuBara" id="beauty">뷰티</button>
					<button type="button" class="menuBara" id="activity">체험 및 기타</button>
					<div class="animation start-home"></div>
					
<%-- 					<% --%>
// 					if(request.getSession().getAttribute("cate").equals("craft")){
<%-- 					%> --%>
<!-- 					<div class="animation start-about"></div> -->
<%-- 					<% --%>
// 					}else if(request.getSession().getAttribute("cate").equals("cook")){
<%-- 					%> --%>
<!-- 					<div class="animation start-blog"></div> -->
<%-- 					<% --%>
// 					}else if(request.getSession().getAttribute("cate").equals("art")){
<%-- 					%> --%>
<!-- 					<div class="animation start-portefolio"></div> -->
<%-- 					<% --%>
// 					}else if(request.getSession().getAttribute("cate").equals("flower")){
<%-- 					%> --%>
<!-- 					<div class="animation start-apple"></div> -->
<%-- 					<% --%>
// 					}else if(request.getSession().getAttribute("cate").equals("beauty")){
<%-- 					%> --%>
<!-- 					<div class="animation start-banana"></div> -->
<%-- 					<% --%>
// 					}else if(request.getSession().getAttribute("cate").equals("activity")){
<%-- 					%> --%>
<!-- 					<div class="animation start-tomato"></div> -->
<%-- 					<% --%>
// 					}else{
<%-- 					%> --%>
<!-- 					<div class="animation start-about"></div> -->
<%-- 					<% --%>
// 					}
<%-- 					%> --%>
				
				</nav>

				<!-- 내용 나올 공간 -->
				<div id="realContent">

					<!-- 전체 -->
					<div class="realContent_all">
					
						<%
							for (int i = 0; i < allClsList.size(); i++) {
						%>
						<div class="card" style="width: 350px; margin: 16px 0px; border: none;">

							<a href="<%=request.getContextPath()%>/detailclass.do?clsId=<%=allClsList.get(i).getClsId() %>">
								<div class="imgParent">
									<img src="<%=request.getContextPath()%>/upload_images/<%=allClsFileList.get(i).get(0).getFileSvNm() %>" class="card-img-top "
										alt="..." />
								</div>
								<div class="card-body" style="width: 360px; padding: 16px 0px;">
									<div class="sub-cate"><%=((List<String>) application.getAttribute("categoryName")).get(allClsList.get(i).getCateNo()-1) %></div>
									<div class="card-text card-store" ><%=allClsList.get(i).getClsName() %></div>
									<div class="card-text" style="margin-top: 8px;">
									<%
    									String ClsDesc = allClsList.get(i).getClsDesc();

    					
       									if (ClsDesc.length() > 50) {
            						%>
            						<script>
                						var slicedDesc = '<%= ClsDesc.substring(0, 50) %>'; // JavaScript로 문자열 자르기
               							document.write(slicedDesc + '...'); // 잘린 문자열을 출력
            						</script>
            						<%
        								} else {
            						%>
            						<%= ClsDesc %> <!-- 14글자 이하인 경우 전체 문자열 출력 -->
            						<%
        									}
              						%>
									
									
									</div>
									<!-- <div style="margin-top: 8px;">
										<i class="bi bi-star-fill"></i> <i class="bi bi-star-fill"></i>
										<i class="bi bi-star-fill"></i> <i class="bi bi-star-fill"></i>
										<i class="bi bi-star-half"></i> <i class="main-class-ex">(31)</i>
									</div> -->
								</div>
							</a>
						</div>
						<%
							}
						%>
						
					</div>

					<!-- 공예  -->
					<div class="realContent_craft">
					
						<%
							for (int i = 0; i < craftClsList.size(); i++) {
						%>
						<div class="card" style="width: 350px; margin: 16px 0px; border: none;">

							<a href="<%=request.getContextPath()%>/detailclass.do?clsId=<%=craftClsList.get(i).getClsId() %>">
								<div class="imgParent">
									<img src="<%=request.getContextPath() %>/upload_images/<%=craftClsFileList.get(i).get(0).getFileSvNm() %>" class="card-img-top "
										alt="photo09.jpg" />
								</div>
								<div class="card-body" style="width: 360px; padding: 16px 0px;">
									<div class="sub-cate"><%=((List<String>) application.getAttribute("categoryName")).get(craftClsList.get(i).getCateNo()-1) %></div>
									<div class="card-text card-store"><%=craftClsList.get(i).getClsName() %></div>
									<div class="card-text" style="margin-top: 8px;"><%=craftClsList.get(i).getClsDesc().substring(0,20) %></div>
									
								</div>
							</a>

						</div>
						<%
							}
						%>
					</div>
					
					<!-- 요리  -->
					<div class="realContent_cook">
						<%
							for (int i = 0; i < cookClsList.size(); i++) {
						%>
						<div class="card" style="width: 350px; margin: 16px 0px; border: none;">

							<a href="<%=request.getContextPath()%>/detailclass.do?clsId=<%=cookClsList.get(i).getClsId() %>">
								<div class="imgParent">
									<img src="<%=request.getContextPath() %>/upload_images/<%=cookClsFileList.get(i).get(0).getFileSvNm() %>" class="card-img-top "
										alt="..." />
								</div>
								<div class="card-body" style="width: 360px; padding: 16px 0px;">
									<div class="sub-cate"><%=((List<String>) application.getAttribute("categoryName")).get(cookClsList.get(i).getCateNo()-1) %></div>
									<div class="card-text card-store"><%=cookClsList.get(i).getClsName() %></div>
									<div class="card-text" style="margin-top: 8px;"><%=cookClsList.get(i).getClsDesc().substring(0,10) %></div>
									
								</div>
							</a>

						</div>
						<%
							}
						%>
					</div>
					
					<!-- 미술  -->
					<div class="realContent_art">
						<%
							for (int i = 0; i < artClsList.size(); i++) {
						%>
						<div class="card" style="width: 350px; margin: 16px 0px; border: none;">

							<a href="<%=request.getContextPath()%>/detailclass.do?clsId=<%=artClsList.get(i).getClsId() %>">
								<div class="imgParent">
									<img src="<%=request.getContextPath() %>/upload_images/<%=artClsFileList.get(i).get(0).getFileSvNm() %>" class="card-img-top "
										alt="..." />
								</div>
								<div class="card-body" style="width: 360px; padding: 16px 0px;">
									<div class="sub-cate"><%=((List<String>) application.getAttribute("categoryName")).get(artClsList.get(i).getCateNo()-1) %></div>
									<div class="card-text card-store"><%=artClsList.get(i).getClsName() %></div>
									<div class="card-text" style="margin-top: 8px;"><%=artClsList.get(i).getClsDesc().substring(0,10) %></div>
									
								</div>
							</a>

						</div>
						<%
							}
						%>
					</div>
					
					<!-- 플라워  -->
					<div class="realContent_flower">
						<%
							for (int i = 0; i < flowerClsList.size(); i++) {
						%>
						<div class="card" style="width: 350px; margin: 16px 0px; border: none;">

							<a href="<%=request.getContextPath()%>/detailclass.do?clsId=<%=flowerClsList.get(i).getClsId() %>">
								<div class="imgParent">
									<img src="<%=request.getContextPath() %>/upload_images/<%=flowerClsFileList.get(i).get(0).getFileSvNm() %>" class="card-img-top "
										alt="..." />
								</div>
								<div class="card-body" style="width: 360px; padding: 16px 0px;">
									<div class="sub-cate"><%=((List<String>) application.getAttribute("categoryName")).get(flowerClsList.get(i).getCateNo()-1) %></div>
									<div class="card-text card-store"><%=flowerClsList.get(i).getClsName() %></div>
									<div class="card-text" style="margin-top: 8px;"><%=flowerClsList.get(i).getClsDesc().substring(0,10) %></div>
									
								</div>
							</a>

						</div>
						<%
							}
						%>
					</div>
					
					<!-- 뷰티  -->
					<div class="realContent_beauty">
						<%
							for (int i = 0; i < beautyClsList.size(); i++) {
						%>
						<div class="card" style="width: 350px; margin: 16px 0px; border: none;">

							<a href="<%=request.getContextPath()%>/detailclass.do?clsId=<%=beautyClsList.get(i).getClsId() %>">
								<div class="imgParent">
									<img src="<%=request.getContextPath() %>/upload_images/<%=beautyClsFileList.get(i).get(0).getFileSvNm() %>" class="card-img-top "
										alt="..." />
								</div>
								<div class="card-body" style="width: 360px; padding: 16px 0px;">
									<div class="sub-cate"><%=((List<String>) application.getAttribute("categoryName")).get(beautyClsList.get(i).getCateNo()-1) %></div>
									<div class="card-text card-store"><%=beautyClsList.get(i).getClsName() %></div>
									<div class="card-text" style="margin-top: 8px;"><%=beautyClsList.get(i).getClsDesc().substring(0,10) %></div>
									
								</div>
							</a>

						</div>
						<%
							}
						%>
					</div>
					
					<!-- 체험  -->
					<div class="realContent_activity">
						<%
							for (int i = 0; i < actibityClsList.size(); i++) {
						%>
						<div class="card" style="width: 350px; margin: 16px 0px; border: none;">

							<a href="<%=request.getContextPath()%>/detailclass.do?clsId=<%=actibityClsList.get(i).getClsId() %>">
								<div class="imgParent">
									<img src="<%=request.getContextPath() %>/upload_images/<%=actibityClsFileList.get(i).get(0).getFileSvNm() %>" class="card-img-top "
										alt="..." />
								</div>
								<div class="card-body" style="width: 360px; padding: 16px 0px;">
									<div class="sub-cate"><%=((List<String>) application.getAttribute("categoryName")).get(actibityClsList.get(i).getCateNo()-1) %></div>
									<div class="card-text card-store"><%=actibityClsList.get(i).getClsName() %></div>
									<div class="card-text" style="margin-top: 8px;"><%=actibityClsList.get(i).getClsDesc().substring(0,10) %></div>
									
								</div>
							</a>

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

	<script>
		// 초기로드: 전체를 보이고 나머지를 숨깁니다.
		document.addEventListener("DOMContentLoaded", function() {
			showContentAll();
			
			const selectedCategory = '<%=session.getAttribute("cate")%>';
			console.log(selectedCategory);
			<%session.removeAttribute("cate");%>
			if (selectedCategory != null) {
				if (selectedCategory == 'craft') showContentCraft();
				else if (selectedCategory == 'cook') showContentCook();
				else if (selectedCategory == 'art') showContentArt();
				else if (selectedCategory == 'flower') showContentFlower();
				else if (selectedCategory == 'beauty') showContentBeauty();
				else if (selectedCategory == 'activity') showContentActivity();
				else (showContentAll());
			}
		});

		//전체를 보이고 나머지를 숨긴다.
		function showContentAll() {
			document.querySelector(".realContent_all").style.display = "flex";
			document.querySelector(".realContent_craft").style.display = "none";			
			document.querySelector(".realContent_cook").style.display = "none";
			document.querySelector(".realContent_art").style.display = "none";
			document.querySelector(".realContent_flower").style.display = "none";
			document.querySelector(".realContent_beauty").style.display = "none";
			document.querySelector(".realContent_activity").style.display = "none";
		}
		
		//공예를 보이고 나머지를 숨긴다.
		function showContentCraft() {
			document.querySelector(".realContent_all").style.display = "none";
			document.querySelector(".realContent_craft").style.display = "flex";			
			document.querySelector(".realContent_cook").style.display = "none";
			document.querySelector(".realContent_art").style.display = "none";
			document.querySelector(".realContent_flower").style.display = "none";
			document.querySelector(".realContent_beauty").style.display = "none";
			document.querySelector(".realContent_activity").style.display = "none";
		}

		//요리를 보이고 나머지를 숨긴다.
		function showContentCook() {
			document.querySelector(".realContent_all").style.display = "none";
			document.querySelector(".realContent_craft").style.display = "none";
			document.querySelector(".realContent_cook").style.display = "flex";
			document.querySelector(".realContent_art").style.display = "none";
			document.querySelector(".realContent_flower").style.display = "none";
			document.querySelector(".realContent_beauty").style.display = "none";
			document.querySelector(".realContent_activity").style.display = "none";
		}

		//미술을 보이고 나머지를 숨긴다.
		function showContentArt() {
			document.querySelector(".realContent_all").style.display = "none";
			document.querySelector(".realContent_craft").style.display = "none";
			document.querySelector(".realContent_cook").style.display = "none";
			document.querySelector(".realContent_art").style.display = "flex";
			document.querySelector(".realContent_flower").style.display = "none";
			document.querySelector(".realContent_beauty").style.display = "none";
			document.querySelector(".realContent_activity").style.display = "none";
		}

		//플라워를 보이고 나머지를 숨긴다.
		function showContentFlower() {
			document.querySelector(".realContent_all").style.display = "none";
			document.querySelector(".realContent_craft").style.display = "none";
			document.querySelector(".realContent_cook").style.display = "none";
			document.querySelector(".realContent_art").style.display = "none";
			document.querySelector(".realContent_flower").style.display = "flex";
			document.querySelector(".realContent_beauty").style.display = "none";
			document.querySelector(".realContent_activity").style.display = "none";
		}

		//뷰티를 보이고 나머지를 숨긴다.
		function showContentBeauty() {
			document.querySelector(".realContent_all").style.display = "none";
			document.querySelector(".realContent_craft").style.display = "none";
			document.querySelector(".realContent_cook").style.display = "none";
			document.querySelector(".realContent_art").style.display = "none";
			document.querySelector(".realContent_flower").style.display = "none";
			document.querySelector(".realContent_beauty").style.display = "flex";
			document.querySelector(".realContent_activity").style.display = "none";
		}

		//체험을 보이고 나머지를 숨긴다.
		function showContentActivity() {
			document.querySelector(".realContent_all").style.display = "none";
			document.querySelector(".realContent_craft").style.display = "none";
			document.querySelector(".realContent_cook").style.display = "none";
			document.querySelector(".realContent_art").style.display = "none";
			document.querySelector(".realContent_flower").style.display = "none";
			document.querySelector(".realContent_beauty").style.display = "none";
			document.querySelector(".realContent_activity").style.display = "flex";
		}

		// 전체 클릭 시
		document.querySelector(".menuBar button:nth-child(1)")
				.addEventListener("click", function() {
					showContentAll();	
				});
		
		// 공예 클릭 시
		document.querySelector(".menuBar button:nth-child(2)")
				.addEventListener("click", function() {
					showContentCraft();	
				});

		// 요리 클릭 시
		document.querySelector(".menuBar button:nth-child(3)")
				.addEventListener("click", function() {
					showContentCook();
				});
		// 미술 클릭 시
		document.querySelector(".menuBar button:nth-child(4)")
				.addEventListener("click", function() {
					showContentArt();
				});
		// 플라워 클릭 시
		document.querySelector(".menuBar button:nth-child(5)")
				.addEventListener("click", function() {
					showContentFlower();
				});
		// 뷰티 클릭 시
		document.querySelector(".menuBar button:nth-child(6)")
				.addEventListener("click", function() {
					showContentBeauty();
				});
		// 체험 클릭 시
		document.querySelector(".menuBar button:nth-child(7)")
				.addEventListener("click", function() {
					showContentActivity();
				});
	</script>

	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

	<script src="<%=request.getContextPath()%>/js/scripts.js"></script>
</body>
</html>