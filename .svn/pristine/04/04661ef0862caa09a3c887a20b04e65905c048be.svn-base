<%@page import="vo.ClassesVO"%>
<%@page import="vo.FavoriteVO"%>
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
<link href="<%=request.getContextPath()%>/css/styles.css" rel="stylesheet" />
<link href="<%=request.getContextPath()%>/css/font.css" rel="stylesheet" />
<link href="<%=request.getContextPath()%>/css/memberMypage.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" />
<!-- jQuery CDN (FullCalendar은 jQuery를 필요로 합니다) -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<style>
* {
	font-family: 'GmarketSansMedium';
}

#fc-dom-1 {
	font-size: 20px;
}

.mylike {
color: var(--CI, #00E577) !important;
}
</style>
</head>
<script>
	$(function() {
		
		const size = $('#size').val();
        for (let i = 0; i < size; i++) {
            
            const avg = $("#avg"+i).text();
            const cnt = $("#cnt"+i).text();
            console.log(avg,cnt);
            starRating(avg,i,cnt);
            
          }
        
        function starRating (avg , index, cnt) {
            
            const rating = Math.round(avg);
            
            // 별점을 0.5 칸 단위로 계산
            const filledHalfStars = Math.floor(rating / 2);
            const hasHalfStar = rating % 2 === 1;
            
            // 별 아이콘을 표시할 div 요소 선택
            const ratingDiv = document.querySelector("#rating"+index);
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
            const reviewCnt = document.createElement("i");
            reviewCnt.classList.add("main-class-ex");
            reviewCnt.innerText = "(" + cnt + ")";
            ratingDiv.appendChild(reviewCnt);
          }
	})
	
</script>

<body>
	<%
		Object vo = session.getAttribute("loginInfo");

		List<List<FileVO>> fileList = (List<List<FileVO>>) request.getAttribute("fileList");
		List<ClassesVO> clsList = (List<ClassesVO>) request.getAttribute("clsList");

		if (vo != null && vo instanceof MemberVO) {
	%>
	<!-- Header-->
	<%@include file="../common/mainheader.jsp"%>


	<%@include file="memAside.jsp"%>
	<div class="mypagimargin">
	<div class="calbox">
		<div class="mycontenttitle">
			관심목록
		</div>
		
		<hr class="mycontentbar"/>
		
		<div id="likeClass" style="display: flex; flex-wrap: wrap;">
		<input type="number" id="size" style="display: none;" value="<%=clsList.size()%>">
			<%
				for (int i = 0; i < clsList.size(); i++) {
			%>
			<div class="card" style="width: 260px; border: none; margin: 8px;">
				<a
					href="<%=request.getContextPath()%>/detailclass.do?clsId=<%=clsList.get(i).getClsId()%>">
					<div class="imgParent">
						<img
							src="<%=request.getContextPath()%>/upload_images/<%=fileList.get(i).get(0).getFileSvNm()%>"
							class="card-img-top " alt="..." style="height: 260px; width: 260px;"/>
					</div>
					<div class="card-body" style="padding: 0px;">
						<div class="sub-cate"><%=((List<String>) application.getAttribute("categoryName")).get(clsList.get(i).getCateNo() - 1)%>&nbsp;&nbsp;<%=clsList.get(i).getClsTime()%>분
						</div>
						<div class="card-text card-store">
							<%
    							String ClsName = clsList.get(i).getClsName();

    					
       							if (ClsName.length() > 15) {
            				%>
            			<script>
                				var slicedDesc = '<%= ClsName.substring(0, 15) %>'; // JavaScript로 문자열 자르기
               					document.write(slicedDesc + '...'); // 잘린 문자열을 출력
            			</script>
            				<%
        						} else {
            				%>
            					<%= ClsName %> <!-- 14글자 이하인 경우 전체 문자열 출력 -->
            				<%
        						}
              				%>
						
						</div>
						<div class="card-text" style="margin-top: 8px;"><%=clsList.get(i).getClsDesc().substring(0, 17)%>...</div>
						<div id="rating<%=i%>" class="rating" style="margin-top: 8px;"></div>
						<div id="avg<%=i%>" style="display: none;"><%=clsList.get(i).getRatingAvg()%></div>
						<div id="cnt<%=i%>" style="display: none;"><%=clsList.get(i).getReviewCnt()%></div>
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