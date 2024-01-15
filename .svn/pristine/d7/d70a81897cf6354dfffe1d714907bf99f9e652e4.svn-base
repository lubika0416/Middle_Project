<%@page import="vo.ClassesVO"%>
<%@page import="vo.FeedVO"%>
<%@page import="vo.FileVO"%>
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
<title>MAIN</title>
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
<link href="<%=request.getContextPath()%>/css/main.css" rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" />

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.css" />
<script src="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.js"></script>

<style>
* {
	font-family: "Pretendard5";
}

.wrapper {
	height: auto;
	min-height: 100%;
	padding-bottom: 125px;
}

.rating {
	font-size: 24px;
}

.star {
	display: inline-block;
	width: 28px; /* 별의 크기 조절 */
	text-align: center;
	font-size: 24px;
	cursor: pointer;
}

.star.active {
	color: gold;
}

.mclswrapper {
	margin: 32px 0px;
}

/* ========================================== */
.swiper {
	width: 100%;
	height: 100%;
}

.swiper-slide {
	text-align: center;
	font-size: 18px;
	background: #fff;
	display: flex;
	justify-content: center;
	align-items: center;
}

.swiper-slide img {
	display: block;
	width: 100%;
	height: 100%;
	object-fit: cover;
}

.swiper {
	margin-left: auto;
	margin-right: auto;
}
</style>
</head>

<body>
	<%
		List<ClassesVO> hotClassList = (List<ClassesVO>) request.getAttribute("hotClassList");
	List<List<FileVO>> hotFileList = (List<List<FileVO>>) request.getAttribute("hotFileList");
	List<List<FileVO>> feedFileList = (List<List<FileVO>>) request.getAttribute("feedFileList");
	List<FeedVO> feedList = (List<FeedVO>) request.getAttribute("feedList");
	List<ProducerVO> proList = (List<ProducerVO>) request.getAttribute("proList");
	List<ClassesVO> classList = (List<ClassesVO>) request.getAttribute("classList");
	List<List<FileVO>> clsFileList = (List<List<FileVO>>) request.getAttribute("clsFileList");
	Object qnaInsertResult = request.getAttribute("aqv");
	if (qnaInsertResult != null) {
		int cnt = (int) qnaInsertResult;
		if (cnt > 0) {
	%>
	<script type="text/javascript">alert("질문이 정상적으로 등록되었습니다.")</script>
	<%
		} else {
	%>
	<script type="text/javascript">alert("질문 등록에 실패하였습니다.")</script>
	<%
		}
	}
	%>

	<%@include file="mainheader.jsp"%>
	<script>
      $(function(){
        
    	const hsize = $('#hsize').val();
    	for(let i = 0; i < hsize; i++) {
    		
    		const avg = $('#havg'+i).text();
    		const cnt = $('#hcnt'+i).text();
    		console.log(avg,cnt);
    		hstarRating(avg, i, cnt)
    		
    	}
    	  
        const size = $('#size').val();
        console.log(size)
        
        for (let i = 0; i < size; i++) {
          
          const avg = $("#avg"+i).text();
          const cnt = $("#cnt"+i).text();
          console.log(avg,cnt);
          starRating(avg,i,cnt);
          
        }
        
        function hstarRating (avg , index, cnt) {
          
          const rating = Math.round(avg);
          
          // 별점을 0.5 칸 단위로 계산
          const filledHalfStars = Math.floor(rating / 2);
          const hasHalfStar = rating % 2 === 1;
          
          // 별 아이콘을 표시할 div 요소 선택
          const ratingDiv = document.querySelector("#hrating"+index);
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
	<!-- Header 이미지 슬라이드-->
	<header class="ppy-40 ">
		<div class="container px-lg-5 " style="width: 100%; display: inline;">
			<div class="bg-white rounded-3 text-center ">

				<div class="swiper mySwiper" >
					<div class="swiper-wrapper">
						<div class="swiper-slide">
							<img src="<%=request.getContextPath()%>/images/Group 1.png"
								style="height: 480px; width: auto;" alt="배경화면1.jpg" />
						</div>
						<div class="swiper-slide">
							<img src="<%=request.getContextPath()%>/images/Group 2.png"
								style="height: 480px; width: auto;" alt="배경화면1.jpg" />
						</div>
						<div class="swiper-slide">
							<img src="<%=request.getContextPath()%>/images/Group 3.png"
								style=" height: 480px; width: auto;" alt="배경화면1.jpg" />
						</div>
					</div>
					<div class="swiper-button-next" style="color: black;"></div>
					<div class="swiper-button-prev" style="color: black;"></div>
					<div class="swiper-pagination" style="color: black;"></div>
				</div>



				
			</div>
		</div>
	</header>
	<!-- Header 이미지 슬라이드 끝-->


	<!-- 카테고리 이미지 시작-->
	<div class="wrapper">
		<div class="container ppy-40" style="width: 1120px;">
			<div class="row" style="width: 1120px;">
				<div class="col" style="padding: 0px;">
					<div class="main-h2">어떤 클래스를 찾으시나요?</div>
				</div>
				<!-- <div class="col-md-1 offset-6 text-end" style="padding-top: 8px; padding-left: 0;">
          <a href="#" class="text-decoration-none text-black">전체보기 ></a>
        </div> -->
			</div>

			<div class="row"
				style="width: 1120px; margin-top: 40px; padding: 0px;">

				<div class="main-ctg-box">
					<p class="main-ctg-text">공예</p>
					<a class="navbar-brand cate_img"
						href="<%=request.getContextPath()%>/classlist.do?cate=craft">
						<img src="https://image.idus.com/static/edu/category_craft.png"
						alt="Logo" style="width: 70px;" />
					</a>
				</div>

				<div class="main-ctg-box">
					<p class="main-ctg-text">요리</p>
					<a class="navbar-brand cate_img"
						href="<%=request.getContextPath()%>/classlist.do?cate=cook"> <img
						src="https://image.idus.com/static/edu/category_cook.png"
						alt="Logo" style="width: 70px;" />
					</a>
				</div>

				<div class="main-ctg-box">
					<p class="main-ctg-text">미술</p>
					<a class="navbar-brand cate_img"
						href="<%=request.getContextPath()%>/classlist.do?cate=art"> <img
						src="https://image.idus.com/static/edu/category_art.png"
						alt="Logo" style="width: 70px;" />
					</a>
				</div>

				<div class="main-ctg-box"">
					<p class="main-ctg-text">플라워</p>
					<a class="navbar-brand cate_img"
						href="<%=request.getContextPath()%>/classlist.do?cate=flower">
						<img src="https://image.idus.com/static/edu/category_flower.png"
						alt="Logo" style="width: 70px;" />
					</a>
				</div>

				<div class="main-ctg-box">
					<p class="main-ctg-text">뷰티</p>
					<a class="navbar-brand cate_img"
						href="<%=request.getContextPath()%>/classlist.do?cate=beauty">
						<img src="https://image.idus.com/static/edu/category_beauty.png"
						alt="Logo" style="width: 70px;" />
					</a>
				</div>

				<div class="main-ctg-box" style="margin-right: 0px;">
					<p class="main-ctg-text">체험 및 기타</p>
					<a class="navbar-brand cate_img"
						href="<%=request.getContextPath()%>/classlist.do?cate=activity">
						<img src="https://image.idus.com/static/edu/category_etc.png"
						alt="Logo" style="width: 70px;" />
					</a>
				</div>

			</div>
		</div>
		<!-- 카테고리 이미지 끝-->

		<!-- Page Content-->
		<!-- 인기 클래스-->
		<div class="mclswrapper">
			<div class="container ppy-40" style="width: 1120px;">
				<div class="row" style="width: 1120px;">
					<div class="col-md-3">
						<div class="main-h2">인기 클래스</div>
					</div>
					<div class="col-md-3 offset-6 text-end" style="padding-top: 8px;">
						<a href="#" class="text-decoration-none text-black">더보기 ></a>
					</div>
				</div>
			</div>

			<div class="container "
				style="width: 1120px; height: 380px; padding: 0px;">
				<div class="row" style="width: 1120px; margin-left: 12px;">
					<input type="number" id="hsize" style="display: none;"
						value="<%=hotClassList.size()%>">
					<%
						for (int i = 0; i < hotClassList.size(); i++) {
					%>
					<div class="main-class-box" style="margin-right: 20px;">
						<a
							href="<%=request.getContextPath()%>/detailclass.do?clsId=<%=hotClassList.get(i).getClsId()%>"
							class="text-decoration-none text-black" style="text-align: left;">
							<img
							src="<%=request.getContextPath()%>/upload_images/<%=hotFileList.get(i).get(0).getFileSvNm()%>"
							class="card-img-top " alt="photo09.jpg"
							style="border-radius: 16px; height: 240px;" />
							<div style="margin-left: 8px;">
								<div class="main-class-ex"><%=((List<String>) application.getAttribute("categoryName")).get(hotClassList.get(i).getCateNo() - 1)%>&nbsp;&nbsp;<%=hotClassList.get(i).getClsTime()%>분</div>
								<div class="main-class-title">

									<%
										String ClsName = hotClassList.get(i).getClsName();

									if (ClsName.length() > 15) {
									%>
									<script>
                		var slicedDesc = '<%=ClsName.substring(0, 15)%>'; // JavaScript로 문자열 자르기
               			document.write(slicedDesc + '...'); // 잘린 문자열을 출력
            		</script>
									<%
										} else {
									%>
									<%=ClsName%>
									<!-- 14글자 이하인 경우 전체 문자열 출력 -->
									<%
										}
									%>

								</div>
								<div class="main-class-ex text-black" style="margin-top: 8px;"><%=hotClassList.get(i).getClsDesc().substring(0, 23)%>...
								</div>
								<div id="hrating<%=i%>" class="rating">
									<div id="havg<%=i%>" style="display: none;"><%=hotClassList.get(i).getRatingAvg()%></div>
									<div id="hcnt<%=i%>" style="display: none;"><%=hotClassList.get(i).getReviewCnt()%></div>
								</div>
							</div>
						</a>
					</div>
					<%
						}
					%>
				</div>

				<!-- <div class="main-class-box"">
          <a href="#" class="text-decoration-none text-black" style="text-align: left;">
            <img src="images/photo10.jpg" class="card-img-top " alt="photo10.jpg" style="border-radius: 16px; height: 240px;" />
            <div style="margin-left: 8px;">
              <div class="main-class-ex">카테고리&nbsp;&nbsp;소요시간</div>
              <div class="main-class-title">동규의 아트 클래스</div>
              <div class="main-class-ex text-black" style="margin-top: 8px;">이거 몇개 안되니까 디비</div>
              <div style="margin-top: 8px;">
              	<i class="bi bi-star-fill"></i>
              	<i class="bi bi-star-fill"></i>
              	<i class="bi bi-star-fill"></i>
              	<i class="bi bi-star-fill"></i>
              	<i class="bi bi-star"></i>
              	<i class="main-class-ex" style="margin-top: 4px;">(31)</i>
              </div>
            </div>
          </a>
        </div>
        
        <div class="main-class-box"">
          <a href="#" class="text-decoration-none text-black" style="text-align: left;">
            <img src="images/photo11.jpg" class="card-img-top " alt="photo11.jpg" style="border-radius: 16px; height: 240px;" />
            <div style="margin-left: 8px;">
              <div class="main-class-ex">카테고리&nbsp;&nbsp;소요시간</div>
              <div class="main-class-title">꽃보다 형택</div>
              <div class="main-class-ex text-black" style="margin-top: 8px;">쓰지 말고 그냥 직접 쓰자</div>
              <div style="margin-top: 8px;">
              	<i class="bi bi-star-fill"></i>
              	<i class="bi bi-star-fill"></i>
              	<i class="bi bi-star-fill"></i>
              	<i class="bi bi-star-half"></i>
              	<i class="bi bi-star"></i>
              	<i class="main-class-ex" style="margin-top: 4px;">(31)</i>
              </div>
            </div>
          </a>
        </div>
        
        <div class="main-class-box" style="margin:0px;">
          <a href="#" class="text-decoration-none text-black" style="text-align: left;">
            <img src="images/photo12.jpg" class="card-img-top " alt="photo12.jpg" style="border-radius: 16px; height: 240px;" />
            <div style="margin-left: 8px;">
              <div class="main-class-ex">카테고리&nbsp;&nbsp;소요시간</div>
              <div class="main-class-title">다영작가의 사진 꿀팁</div>
              <div class="main-class-ex text-black" style="margin-top: 8px;">다들 힘냅시당v^^v</div>
              <div style="margin-top: 8px;">
              	<i class="bi bi-star-fill"></i>
              	<i class="bi bi-star-fill"></i>
              	<i class="bi bi-star-fill"></i>
              	<i class="bi bi-star-fill"></i>
              	<i class="bi bi-star-half"></i>
              	<i class="main-class-ex" style="margin-top: 4px;">(31)</i>
              </div>
            </div>
          </a>
        </div> -->

			</div>
		</div>



		<!-- 신규 클래스 -->
		<div class="mclswrapper">
			<div class="container ppy-40" style="width: 1120px;">
				<div class="row" style="width: 1120px;">
					<div class="col-md-3">
						<div class="main-h2">신규 클래스</div>
					</div>
				</div>
			</div>

			<div class="container"
				style="width: 1120px; height: max-content; padding: 0px;">
				<div class="row" style="width: 1120px; margin-left: 12px">
					<input type="number" id="size" style="display: none;"
						value="<%=classList.size()%>">
					<%
						for (int i = 0; i < 4; i++) {
					%>
					<div class="main-class-box" style="margin-right: 20px;">
						<a
							href="<%=request.getContextPath()%>/detailclass.do?clsId=<%=classList.get(i).getClsId()%>"
							class="text-decoration-none text-black" style="text-align: left;">
							<div class="imgParent">
								<img
									src="<%=request.getContextPath()%>/upload_images/<%=clsFileList.get(i).get(0).getFileSvNm()%>"
									class="card-img-top " alt="..."
									style="border-radius: 16px; height: 240px;" />
							</div>
							<div style="margin-left: 8px;">
								<div class="main-class-ex"><%=((List<String>) application.getAttribute("categoryName")).get(classList.get(i).getCateNo() - 1)%>&nbsp;&nbsp;<%=classList.get(i).getClsTime()%>분
								</div>
								<div class="main-class-title">

									<%
										String NClsName = classList.get(i).getClsName();

									if (NClsName.length() > 15) {
									%>
									<script>
                		var slicedDesc = '<%=NClsName.substring(0, 15)%>'; // JavaScript로 문자열 자르기
               			document.write(slicedDesc + '...'); // 잘린 문자열을 출력
            		</script>
									<%
										} else {
									%>
									<%=NClsName%>
									<!-- 14글자 이하인 경우 전체 문자열 출력 -->
									<%
										}
									%>


								</div>
								<div class="main-class-ex text-black" style="margin-top: 8px;"><%=classList.get(i).getClsDesc().substring(0, 23)%>...
								</div>
								<div class="rating" id="rating<%=i%>"></div>
								<div id="avg<%=i%>" style="display: none;"><%=classList.get(i).getRatingAvg()%></div>
								<div id="cnt<%=i%>" style="display: none;"><%=classList.get(i).getReviewCnt()%></div>
							</div>
						</a>
					</div>
					<%
						}
					%>

				</div>
			</div>
		</div>

		  <!-- 피드 영역 -->
   <div class="mclswrapper">
    <div class="container ppy-40 " style="width: 1120px;">
      <div class="row" style="width: 1120px;">
        <div class="col-md-3">
          <div class="main-h2">FEED</div>
        </div>
        <!-- <div class="col-md-3 offset-6 text-end" style="padding-top: 8px;">
          <a href="#" class="text-decoration-none text-black">더보기 ></a>
        </div> -->
      </div>
    </div>
    
    
    <div class="container" style="width: 1120px;  height: 440px; padding: 0px; display: flex; justify-content: center;">
      <div style="width: 1120px; display: flex; flex-direction: row;">
    
    		<% for(int i=0; i<feedList.size(); i++){ %>
			<div style="width: 260px; margin: 10px;">
                <a href="<%=request.getContextPath() %>/detailstore.do?proId=<%=proList.get(i).getProId() %>">
                  <div class="imgParent">
                    <img src="<%=request.getContextPath()%>/upload_images/<%=feedFileList.get(i).get(0).getFileSvNm() %>" class="card-img-top" alt="..." style="border-radius: 16px; height: 240px;" >
                  </div>
                  <div main-class-box>
                    <p class="main-class-ex" style="margin: 8px 0px;"><%=proList.get(i).getProStore()%></p>
                    <p style="font-size: 16px; color: black;">
                    	  <%
    				String FeedCon = feedList.get(i).getFeedContent();

    					
       					if (FeedCon.length() > 500) {
            		%>
            		<script>
                		var slicedDesc = '<%= FeedCon.substring(0, 500) %>'; // JavaScript로 문자열 자르기
                		document.write(slicedDesc + '...');  // 잘린 문자열을 출력
            		</script>
            		<%
        				} else {
            		%>
            			<%= FeedCon %> <!-- 112글자 이하인 경우 전체 문자열 출력 -->
            		<%
        				}
              		%>
        			<p class="main-class-ex" style="margin: 8px 0px;"><%=feedList.get(i).getFormDate()%></p>	                   
                  </div>
                </a>
              </div>	
            <%} %>


				</div>
			</div>
		</div>

	</div>





	<!-- Footer-->
	<%@include file="mainfooter.jsp"%>



	<%
		Object obj = request.getAttribute("loginResult");
	if (obj != null) {
	%>
	<script>
		alert("로그인이 필요한 서비스입니다.")
	</script>
	<%
		}
	%>

	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>

	<!-- =============== -->
	<script>
    var swiper = new Swiper(".mySwiper", {
      slidesPerView: 1,
      spaceBetween: 30,
      loop: true,
      pagination: {
        el: ".swiper-pagination",
        clickable: true,
      },
      navigation: {
        nextEl: ".swiper-button-next",
        prevEl: ".swiper-button-prev",
      },
      autoplay: {
    	    delay: 3000,
    	  },
    });
  </script>



</body>
</html>