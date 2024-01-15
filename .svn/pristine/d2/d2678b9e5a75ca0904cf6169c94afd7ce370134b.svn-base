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
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>MAIN</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
    <!-- Bootstrap icons-->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
      rel="stylesheet"
    />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link href="<%=request.getContextPath() %>/css/styles.css" rel="stylesheet" />
    <link href="<%=request.getContextPath() %>/css/font.css" rel="stylesheet" />
    <link href="<%=request.getContextPath() %>/css/main.css" rel="stylesheet" />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css"
    />
<style>
	* {
		font-family: 'GmarketSansMedium';
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
	    width: 30px; /* 별의 크기 조절 */
	    text-align: center;
	    font-size: 24px;
	    cursor: pointer;
	}
	.star.active {
	    color: gold;
	}

</style>
</head>

  <body>
  <%
  	List<List<FileVO>> feedFileList = (List<List<FileVO>>)request.getAttribute("feedFileList");
  	List<FeedVO> feedList = (List<FeedVO>)request.getAttribute("feedList");
  	List<ProducerVO> proList = (List<ProducerVO>)request.getAttribute("proList");
  	List<ClassesVO> classList = (List<ClassesVO>)request.getAttribute("classList"); 
  	List<List<FileVO>> clsFileList = (List<List<FileVO>>)request.getAttribute("clsFileList");
  	Object qnaInsertResult =  request.getAttribute("aqv");
  	if (qnaInsertResult != null) {
  		int cnt = (int)qnaInsertResult;
  		if (cnt > 0) {%>
  			<script type="text/javascript">alert("질문이 정상적으로 등록되었습니다.")</script>
  		<%} else {%>
  			<script type="text/javascript">alert("질문 등록에 실패하였습니다.")</script>
  		<%}
  	}
  %>
  	
	<%@include file="mainheader.jsp" %>
	<script>
      $(function(){
        
        const size = $('#size').val();
        console.log(size)
        
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
    <!-- Header 이미지 슬라이드-->
    <header class="ppy-40 ">
      <div class="container px-lg-5 " style="width: 100%; display: inline;">
        <div class="bg-white rounded-3 text-center ">
          <div
            id="carouselExampleIndicators"
            class="carousel slide"
            data-bs-ride="carousel"
          >
            <div class="carousel-indicators">
              <button
                type="button"
                data-bs-target="#carouselExampleIndicators"
                data-bs-slide-to="0"
                class="active"
                aria-current="true"
                aria-label="Slide 1"
              ></button>
              <button
                type="button"
                data-bs-target="#carouselExampleIndicators"
                data-bs-slide-to="1"
                aria-label="Slide 2"
              ></button>
              <button
                type="button"
                data-bs-target="#carouselExampleIndicators"
                data-bs-slide-to="2"
                aria-label="Slide 3"
              ></button>
            </div>
            <div class="carousel-inner">
              <div class="carousel-item active">
              	<div class="carinner-text" style="position: absolute;">
                  <div class="caro-btn">쿠폰 혜택</div>
                  <div class="caro-title">한눈에 보는<br>요즘 스트랩 & 키링</div>
                  <div class="caro-ex">5% 할인 쿠폰과 팔로우 혜택까지</div>
                </div>
                <img
                  src="<%=request.getContextPath() %>/images/Group 17.png"  
                  style="height: 480px; margin-left: -600px; width:1500px;"
                  alt="배경화면1.jpg"
                />
              </div>
              <div class="carousel-item">
              	<div class="carinner-text" style="position: absolute;">
                  <div class="caro-btn">쿠폰 혜택</div>
                  <div class="caro-title">매주 새로운 발견<br>금요작가</div>
                  <div class="caro-ex">9월 20일 수요일까지</div>
                </div>
                <img
                  src="<%=request.getContextPath() %>/images/Group 24.png"
                  style="height: 480px; margin-left: -600px; width:1500px;"
                  alt="배경화면2.jpg"
                />        
              </div>
              <div class="carousel-item">
              	<div class="carinner-text" style="position: absolute;">
                  <div class="caro-btn">쿠폰 혜택</div>
                  <div class="caro-title">오늘만 할인<br>최대 81%</div>
                  <div class="caro-ex">오늘 밤 12시까지</div>
                </div>
                <img
                  src="<%=request.getContextPath() %>/images/Group 25.png"
                  style="height: 480px; margin-left: -600px; width:1500px;"
                  alt="배경화면3.jpg"
                />
              </div>
            </div>
            <div>
            <button
              class="carousel-control-prev"
              type="button"
              data-bs-target="#carouselExampleIndicators"
              data-bs-slide="prev"
              style="display: flex; align-content: flex-end; flex-wrap: wrap; margin-bottom: 40px; margin-left: 35px;"
            >
                <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
			          <g clip-path="url(#clip0_11_4131)">
                <path d="M16.6201 2.99C16.1301 2.5 15.3401 2.5 14.8501 2.99L6.54006 11.3C6.15006 11.69 6.15006 12.32 6.54006 12.71L14.8501 21.02C15.3401 21.51 16.1301 21.51 16.6201 21.02C17.1101 20.53 17.1101 19.74 16.6201 19.25L9.38006 12L16.6301 4.75C17.1101 4.27 17.1101 3.47 16.6201 2.99Z" fill="black"/>
                </g>
                <defs>
                <clipPath id="clip0_11_4131">
                <rect width="24" height="24" fill="white"/>
                </clipPath>
                </defs>
                </svg>

              <span class="visually-hidden">Previous</span>
            </button>
            <button
              class="carousel-control-next"
              type="button"
              data-bs-target="#carouselExampleIndicators"
              data-bs-slide="next"
              style="display: flex; flex-direction: column-reverse; justify-content: flex-start; align-items: flex-start; margin-bottom: 40px; margin-right: 1320px;"
            >
                <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                <g clip-path="url(#clip0_11_4135)">
                <path d="M7.37994 21.01C7.86994 21.5 8.65994 21.5 9.14994 21.01L17.4599 12.7C17.8499 12.31 17.8499 11.68 17.4599 11.29L9.14994 2.98C8.65994 2.49 7.86994 2.49 7.37994 2.98C6.88994 3.47 6.88994 4.26 7.37994 4.75L14.6199 12L7.36994 19.25C6.88994 19.73 6.88994 20.53 7.37994 21.01Z" fill="black"/>
                </g>
                <defs>
                <clipPath id="clip0_11_4135">
                <rect width="24" height="24" fill="white" transform="translate(24 24) rotate(-180)"/>
                </clipPath>
                </defs>
                </svg>
              
              <span class="visually-hidden">Next</span>
            </button>
            </div>
            
          </div>
        </div>
      </div>
    </header>
    <!-- Header 이미지 슬라이드 끝-->


    <!-- 카테고리 이미지 시작-->
<div class="wrapper">
    <div class="container ppy-40" style="width: 1120px;">
      <div class="row" style="width: 1120px;">
        <div class="col" style="padding:0px;">
          <div class="main-h2">
            어떤 클래스를 찾으시나요?
          </div>
        </div>
        <!-- <div class="col-md-1 offset-6 text-end" style="padding-top: 8px; padding-left: 0;">
          <a href="#" class="text-decoration-none text-black">전체보기 ></a>
        </div> -->
      </div>

      <div class="row" style="width: 1120px; margin-top:40px; padding: 0px;">

        <div class="main-ctg-box">
            	<p class="main-ctg-text">공예</p>
		  		<a class="navbar-brand cate_img"  href="#">
		  			<img
		  				src="https://image.idus.com/static/edu/category_craft.png"
		  				alt="Logo"
		  				style="  width: 70px;"
		  			/>
		  		</a>
		  	</div>

        <div class="main-ctg-box">
           		<p class="main-ctg-text">요리</p>
		  		<a class="navbar-brand cate_img"  href="#">
		  			<img
		  				src="https://image.idus.com/static/edu/category_cook.png"
		  				alt="Logo" 
		  				style="  width: 70px;"
		  			/>
		  		</a>
		  	</div>

        <div class="main-ctg-box">
           		<p class="main-ctg-text">미술</p>
		  		<a class="navbar-brand cate_img"  href="#">
		  			<img
		  				src="https://image.idus.com/static/edu/category_art.png"
		  				alt="Logo"
		  				style="  width: 70px;"
		  			/>
		  		</a>
		  	</div>

        <div class="main-ctg-box"">
           		<p class="main-ctg-text">플라워</p>
		  		<a class="navbar-brand cate_img"  href="#">
		  			<img
		  				src="https://image.idus.com/static/edu/category_flower.png"
		  				alt="Logo"
		  				style="  width: 70px;"
		  			/>
		  		</a>
		  	</div>

        <div class="main-ctg-box">
          		<p class="main-ctg-text">뷰티</p>
		  		<a class="navbar-brand cate_img"  href="#">
		  			<img
		  				src="https://image.idus.com/static/edu/category_beauty.png"
		  				alt="Logo"
		  				style="  width: 70px;"
		  			/>
		  		</a>
		  	</div>

        <div class="main-ctg-box" style="margin-right: 0px;">
          		<p class="main-ctg-text">체험 및 기타</p>
		  		<a class="navbar-brand cate_img"  href="#">
		  			<img
		  				src="https://image.idus.com/static/edu/category_etc.png"
		  				alt="Logo"
		  				style="  width: 70px;"
		  			/>
		  		</a>
		  	</div>

      </div>
    </div>
    <!-- 카테고리 이미지 끝-->

    <!-- Page Content-->
    <!-- 인기 클래스-->
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

    <div class="container " style="width: 1120px; height: 380px; padding: 0px;">
      <div class="row" style="width: 1120px;  margin-left: 12px;">
        <div class="main-class-box"" style="margin-right: 20px;">
          <a href="<%=request.getContextPath()%>/detailclass.do?clsId=" class="text-decoration-none text-black" style="text-align: left;">
            <img src="images/photo09.jpg" class="card-img-top " alt="photo09.jpg" style="border-radius: 16px; height: 240px;" />
            <div style="margin-left: 8px;">
              <div class="main-class-ex">카테고리&nbsp;&nbsp;소요시간</div>
              <div class="main-class-title">윤서네 베이킹</div>
              <div class="main-class-ex text-black" style="margin-top: 8px;">해당 클래스 간단한 설명</div>
              <div style="margin-top: 8px;">
              	<i class="bi bi-star-fill"></i>
              	<i class="bi bi-star-fill"></i>
              	<i class="bi bi-star-fill"></i>
              	<i class="bi bi-star-fill"></i>
              	<i class="bi bi-star-half"></i>
              	<i class="main-class-ex">(31)</i>
              </div>
            </div>
          </a>
        </div> 
        
        <div class="main-class-box"">
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
        </div>
     
      </div>
    </div>
    
    
    
    <!-- 신규 클래스 -->
    
    <div class="container ppy-40" style="width: 1120px;">
      <div class="row" style="width: 1120px;">
        <div class="col-md-3">
          <div class="main-h2">신규 클래스</div>
        </div>
      </div>
    </div>

    <div class="container" style="width: 1120px;  height: max-content; padding: 0px;">
      <div class="row" style="width: 1120px; margin-left: 12px">
	    <input type="number" id="size" style="display: none;" value="<%=classList.size()%>">
      	<% for(int i=0; i<classList.size(); i++){ %>
      	<div class="main-class-box" style="margin-right: 20px;">
          <a href="<%=request.getContextPath() %>/detailclass.do?clsId=<%=classList.get(i).getClsId() %>" class="text-decoration-none text-black" style="text-align: left;">
            <div class="imgParent" >
            <img src="<%=request.getContextPath() %>/upload_images/<%=clsFileList.get(i).get(0).getFileSvNm() %>" class="card-img-top " alt="..." style="border-radius: 16px; height: 240px;" />
            </div>
            <div style="margin-left: 8px;">
              <div class="main-class-ex"><%=((List<String>)application.getAttribute("categoryName")).get(classList.get(i).getCateNo()-1) %>&nbsp;&nbsp;<%=classList.get(i).getClsTime() %>분</div>
              <div class="main-class-title"><%=classList.get(i).getClsName() %></div>
              <div class="main-class-ex text-black" style="margin-top: 8px;"><%=classList.get(i).getClsDesc().substring(0,2) %></div>
              <div class="rating" id="rating<%=i%>" style="margin-top: 8px;">
              </div>
              <div id="avg<%=i%>" style="display: none;"><%=classList.get(i).getRatingAvg()%></div>
              <div id="cnt<%=i%>" style="display: none;"><%=classList.get(i).getReviewCnt()%></div>
            </div>
          </a>
        </div>
		<%} %>
	
      </div>
    </div>
    
    <!-- 피드 영역 -->
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
    
    
    <div class="container" style="width: 1120px;  height: 380px; padding: 0px;">
      <div style="width: 1120px; margin-left: 12px; display: flex; flex-direction: row; flex-wrap: wrap; justify-content: flex-start;">
    
    		<% for(int i=0; i<feedList.size(); i++){ %>
			<div class="card" style="width: 260px; margin: 10px;">
                <a href="<%=request.getContextPath() %>/detailstore.do?proId=<%=proList.get(i).getProId() %>">
                  <div class="imgParent">
                    <img src="<%=request.getContextPath()%>/upload_images/<%=feedFileList.get(i).get(0).getFileSvNm() %>" class="card-img-top" alt="..." style="border-radius: 16px; height: 240px;" >
                  </div>
                  <div class="card-body">
                    <p class="main-class-title"><%=proList.get(i).getProStore()%></p>
                    <p class="main-class-ex text-black"><%=feedList.get(i).getFeedContent().substring(0, 10) %></p>
                  </div>
                </a>
              </div>	
            <%} %>
				
      
      </div>
    </div>
    
    
</div>
  



    
    <!-- Footer-->
    	<%@include file="mainfooter.jsp" %>
    	
    	
    
    <%
    Object obj = request.getAttribute("loginResult");
    if (obj != null) {
    %>
    <script>
		alert("로그인이 필요한 서비스입니다.")    	
    </script>
    <%}%>	
    	
    <!-- Bootstrap core JS-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Core theme JS-->
    <script src="js/scripts.js"></script>

    
    
  </body>
</html>