<%@page import="java.text.SimpleDateFormat"%>
<%@page import="vo.FeedVO"%>
<%@page import="vo.ReviewVO"%>
<%@page import="vo.FileVO"%>
<%@page import="java.util.List"%>
<%@page import="vo.ClassesVO"%>
<%@page import="vo.FavoriteVO"%>
<%@page import="vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	Object obj = session.getAttribute("loginInfo");

List<FileVO> storeFileList = (List<FileVO>) request.getAttribute("storeFileList");
ProducerVO pvo = (ProducerVO) request.getAttribute("pvo");
List<List<FileVO>> feedFileList = (List<List<FileVO>>) request.getAttribute("feedFileList");
List<FeedVO> feedList = (List<FeedVO>) request.getAttribute("feedList");
List<List<FileVO>> clsFileList = (List<List<FileVO>>) request.getAttribute("clsFileList");
List<ClassesVO> classList = (List<ClassesVO>) request.getAttribute("classList");

List<FavoriteVO> favoriteList = (List<FavoriteVO>) request.getAttribute("favoriteList");

List<ReviewVO> reviewList = (List<ReviewVO>) request.getAttribute("reviewList");
List<List<FileVO>> reviewFileList = (List<List<FileVO>>)request.getAttribute("reviewFileList"); 
SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
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
<link href="<%=request.getContextPath()%>/css/storePage.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" />
<!-- jQuery CDN (FullCalendar은 jQuery를 필요로 합니다) -->
<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous"></script>
<script src="https://oapi.map.naver.com/openapi/v3/maps.js?ncpClientId=zuyt7c86ti"></script>
<link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
<style>
* {
	font-family: "Pretendard5";
}

#fc-dom-1 {
	font-size: 20px;
}

b{
	font-family: 'Pretendardbold' !important;
	font-weight: 900 !important;
}

.nav-pills .nav-link.active, .nav-pills .show > .nav-link {
	border-radius: 0px;
    color: var(--CI, #00E577) !important;
    font-size: 18px !important;
    border-bottom: 3px solid var(--CI, #00E577);
    background-color:transparent;
    height: 42px !important;
    margin-left: 0px !important;
    padding: 3px 30px !important;
}

.nav-pills .nav-link {
	color: #999 !important;
	font-size: 18px !important;
	height: 42px !important;
    margin-left: 0px !important;
    padding: 3px 30px !important;
}

.tab-pane {
	padding: 64px 0px;
	width: 1120px !important;
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

.promyclass {
	color: var(--CI, #00E577) !important;
}

.aaa {
	background-color: var(--CI, #00E577) !important;
	border: none !important;
	color: black !important;
}

.aaa:hover {
	background-color: black !important;
	border: none !important;
	color: var(--CI, #00E577) !important;
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
</style>
</head>


<body>

	<%
	Object pqnaResult_ = request.getAttribute("pqnaResult");
	
	if (pqnaResult_ != null) {
		
		boolean pqnaResult = (boolean) pqnaResult_;
		
		if (pqnaResult) {%>
			<script type="text/javascript">alert("문의 등록이 완료되었습니다.")</script>
		<%}else {%>
			<script type="text/javascript">alert("문의 등록에 실패했습니다. 다시 시도해주세요.")</script>
	<%}}%>
	


	<!-- Header-->
	<%@include file="../common/mainheader.jsp"%>

	


<div class="wrapper">
   <div class="storeheader">
	  <div class="defaultmargin">
	  	 <div class="headerContent">
		   <div style="display: flex; align-items:center;">		  	 
	  		<div class="top-imgParent" style="width: 150px; height: 150px;">
				<img src="<%=request.getContextPath()%>/upload_images/<%=storeFileList.get(0).getFileSvNm()%>"
				class="img-top"  style="width: 150px; height: 150px;">
			</div>
			
			<div class="storeTopContent">
				<div class="storeTitle" style="margin:0px;"><%=pvo.getProStore()%></div>
				<div style="color: #999;">
					<%=pvo.getProDesc() %>
				</div>
			</div>
		   </div>	
			<div class="rightarray">
        	<div class="textbbox">
        		<div class="proName"><%=pvo.getClsNo()%></div>
        		<div class="proSub">클래스</div>
        	</div>
        	<hr style="width: 2px; height: 40px; background: #585858;">
        	<div class="textbbox">
        		<div class="proName"><%=pvo.getReviewNo()%></div>
        		<div class="proSub">리뷰</div> 		
        	</div>
        	<hr style="width: 2px; height: 40px; background: #585858;">
        	<div class="textbbox" style="margin-right: -20px;">
        		<div class="proName"><%=favoriteList.size()%></div>
        		<div class="proSub">관심</div>
        	</div>
        </div>	
		</div>
	  </div>
	</div>
	
	<div class="storeNav">
		<div class="defaultmargin">
			<div class="defaultmargin" style="align-items: flex-start;  justify-content: flex-start;">
                     
                    <ul class="nav nav-pills">
  						<li class="nav-item">
						    <a class="nav-link active" data-toggle="tab" href="#profile">프로필</a>
					   </li>
  					   <li class="nav-item">
   	  					    <a class="nav-link" data-toggle="tab" href="#feed">피드</a>
  					   </li>
  					   <li class="nav-item">
    						<a class="nav-link" data-toggle="tab" href="#zxc">클래스</a>
  					   </li>
  					   <li class="nav-item">
    						<a class="nav-link" data-toggle="tab" href="#review">리뷰</a>
  					   </li>
					</ul>
					
			</div>
		</div>
	</div>
			<div class="defaultmargin" style="min-height: 40vh;">
				<div class="tab-content">
					<!-- 공방프로필 -->
  					<div class="tab-pane fade show active" id="profile" style="height: 1088px;">
  						<div style="display: flex;">
  							<img
							src="<%=request.getContextPath()%>/upload_images/<%=storeFileList.get(0).getFileSvNm()%>"
							class="img-profile">
							<div style="margin: 40px;">
								<h3><b>공방 소개</b></h3>
								<div style="margin-top: 32px;"><%=pvo.getProPro()%></div>
								<div style="margin-top: 24px;">오시는 길: <%=pvo.getProAddr().split("/")[1]%></div>
							</div>
  						</div>
						
						<div style="width: 1120px; height: 480px; margin: 64px 0px;">	
						 	<div id="map" style="width: 1120px; height: 480px; border-radius: 24px; display="">
						 	
						 	</div>
                      	</div>
  					</div>
  					
  					<!-- 피드 -->
  					<div class="tab-pane fade" id="feed" style="width: 100%; height: auto; padding:16px;">
    					<div style="display: flex; height: 100%; width: 100%; align-content: stretch; justify-content: flex-start;">
                      	 	<div class="realContent_feed" style="display: flex; justify-content: space-around;">

						<%
							for (int i = 0; i < feedList.size(); i++) {
						%>
							<div class="card" data-aos="fade-bottom"  style="width: 510px; height: fit-content; margin: 20px 0px; border: none; ">
								<div class="feedimg" style="height: fit-content;">	
									<img
										src="<%=request.getContextPath()%>/upload_images/<%=feedFileList.get(i).get(0).getFileSvNm()%>"
										class="feedimg" alt="...">
								</div>
								<div>
									<p class="feedtext" style="line-height: 24px;"><%=feedList.get(i).getFeedContent()%></p>
									<p class="feedtime"><%=feedList.get(i).getFormDate()%></p>
								</div>
							</div>
						<%
							}
						%>
							</div>
                    	</div>
  					</div>
  					
						<!--클래스목록 시작  -->	
  					<div class="tab-pane fade" id="zxc" style="width: 100%; height: auto; padding:16px;">
    					<div style="display: flex; height: 100%; width:100%; align-content: stretch; justify-content: flex-start;">
                      	 	<div class="realContentclass">
							<input type="number" id="size" value="<%=classList.size()%>" style="display: none;">
						<%
								for (int i = 0; i < classList.size(); i++) {
						%>
							<div class="card" style="width: 520px; margin: 20px 0px; border: none;">
								<div class="feedimg"><a href="<%=request.getContextPath()%>/detailclass.do?clsId=<%=classList.get(i).getClsId()%>"
								class="text-decoration-none text-black"
								style="text-align: left;">
									<img 
										src="<%=request.getContextPath()%>/upload_images/<%=clsFileList.get(i).get(0).getFileSvNm()%>"
										class="card-img-top " alt="..." style="border-radius: 16px;"></a>
								</div>
								<div style="margin-left: 8px;">
									<div class="main-class-ex"><%=((List<String>) application.getAttribute("categoryName")).get(classList.get(i).getCateNo() - 1)%>&nbsp;&nbsp;<%=classList.get(i).getClsTime()%>
										분
									</div>
									<div class="main-class-title"><%=classList.get(i).getClsName()%></div>
									<div class="main-class-ex text-black" style="margin-top: 8px;"><%=classList.get(i).getClsDesc()%></div>
									<div class="rating" id="rating<%=i%>" style="margin-top: 8px;"></div>
									<div id="avg<%=i%>" style="display: none;"><%=classList.get(i).getRatingAvg()%></div>
									<div id="cnt<%=i%>" style="display: none;"><%=classList.get(i).getReviewCnt()%></div>
								</div>
							</div>
						<%
							}
						%>

						</div>
					</div>
						</div>
					
					
					<div class="tab-pane fade" id="review">
						<div class="container classInfo" style="width: 100%; padding:16px;">
                      		
                      		<div style="height: 550px; overflow-y: scroll; padding:24px;">
						
						
							<input type="number" id="rvLength" value="<%=reviewList.size()%>" style="display: none;">
							<%if (reviewList.size() > 0) { 
								for (int i =  0; i < reviewList.size(); i++) {%>
								<!-- 리뷰 목록 시작 -->
								<div class="card shadow-0 border rounded-3"
									style="margin-bottom: 8px; width: 1000px; height: 250px; display: flex; flex-direction: row;">
									<div class="card-body">
										<div class="row">
											<%if (reviewFileList != null && reviewFileList.get(i) != null) { %>
											<img src="<%=request.getContextPath()%>/upload_images/<%=reviewFileList.get(i).get(0).getFileSvNm()%>"
												style="width: 300px; height: 220px;" />
											<%}%>
											<div style="width: 50%; margin-left: 30px; margin-top: 10px;">
												<div class="mt-1 mb-0 text-muted small">
													<span><%=reviewList.get(i).getWriter().substring(0,1)+"**"%> </span> &nbsp;&nbsp;&nbsp; <span><%=reviewList.get(i).getReviewNo()%></span>
												</div>
												<div class="mt-1 mb-0 text-muted small"><%=reviewList.get(i).getFormDt()%></div>
												<p style="height: 100px; font-size: 18px; overflow: hidden;"><%=reviewList.get(i).getReviewContent()%></p>
												<div id="ratingg<%=i%>" class="rating" style="margin-top: 8px;">
													<input type="number" id="rvRating<%=i%>" value="<%=reviewList.get(i).getReviewRating()%>" style="display: none;" >
												</div>
											</div>
										</div>
									</div>
								</div>
								<!-- 리뷰 목록 끝 -->
								
							<%	}
							  } else {%>
								<h4>등록된 리뷰가 없습니다.</h4>
							<%}%>
							
							
						</div>
                      		
                    	</div>
  					</div>
  					
  					
  					
  					
  					
  					
  					
  					
  					
				</div>      
                    </div>
		</div>
	  
	</div>


	<!-- 문의하기 플로팅 아이콘  -->
	<%
		if (obj != null && obj instanceof MemberVO) {
	%>
	<button id="floating-map-button" data-bs-toggle="modal"
		data-bs-target="#pqna">
		<span>문의하기</span>
	</button>
	<%
		}
	%>

	<!-- Modal -->
	<div class="modal fade" id="pqna" tabindex="-1"
		data-bs-backdrop="static" aria-labelledby="exampleModalLabel"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title card-store" id="exampleModalLabel">공방에
						문의하기</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				
					<div class="modal-body">
						<input type="hidden" name="proId" value="<%=pvo.getProId()%>">
						<% if (obj != null && obj instanceof MemberVO){ %>
						<input type="hidden" name="memId" value="<%=((MemberVO) obj).getMemId()%>">
						<%} %>
						<div class="modal_group">
							<label for="questionTitle">제목</label> <input type="text"
								class="form-control" id="questionTitle" placeholder="제목을 입력하세요."
								required name="pqnaTitle" />
						</div>

						<div class="modal_group">
							<label for="questionContent">문의 내용</label>
							<textarea name="pqnaContent" id="questionContent" cols="44" rows="10" style=" width: 100%;" required></textarea>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
						<button type="button" id="inquiry" class="btn btn-primary" data-bs-dismiss="modal">문의하기</button>
					</div>
			</div>
		</div>
	</div>




	<script>
		// 초기로드: 피드를 보이고 클래스를 숨깁니다.
		document.addEventListener("DOMContentLoaded", function() {

			const size = $('#size').val();
			console.log(size);
			for (let i = 0; i < size; i++) {
				const avg = $("#avg"+i).text();
				const cnt = $("#cnt"+i).text();
				
				starRating(avg, i, cnt);
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
			
			const sizee = $('#rvLength').val();
			
			for (let i = 0; i < sizee; i++) {
			  const rating = $('#rvRating'+i).val();
			  rstarRating(rating, i);
			}
			
			
			function rstarRating(rating, index) {
				
				const filledHalfStars = Math.floor(rating / 2);
				const hasHalfStar = rating % 2 === 1;
				// 별 아이콘을 표시할 div 요소 선택
				const ratingDiv = document.querySelector("#ratingg"+index);
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
			}
			
			
			let lat = 0;
            let lng = 0;

            $.ajax({
              url: 'https://dapi.kakao.com/v2/local/search/address.json',
              type: 'get',
              async: false,
              data: { query: '<%=request.getAttribute("addr")%>' },
              headers: {
                Authorization: 'KakaoAK 12ed18b67b798c0122346f21a4dce253',
              },
              success: function (rsp) {
              	console.log(rsp)
                console.log(rsp.documents[0].address.x);
                lng = rsp.documents[0].address.x;
                console.log(rsp.documents[0].address.y);
                lat = rsp.documents[0].address.y;
              },
              error: function (error) {
                console.log(error);
              }
            })


            var mapOptions = {
              center: new naver.maps.LatLng(lat, lng),
              zoom: 18
            };
            
            var map = new naver.maps.Map('map', mapOptions);
            
            var marker = new naver.maps.Marker({
              position: new naver.maps.LatLng(lat, lng),
              map: map
            });
			
		});

	
		
		
		$("#inquiry").on("click", function() {
			let pqnaTitle = $('#questionTitle').val();
			let pqnaContent = $('#questionContent').val();
			
			$.ajax({
				url: 'http://localhost:8888/Jdus/detailstore.do',
				type: 'post',
				data: {pqnaTitle:pqnaTitle, pqnaContent:pqnaContent, proId:"<%=pvo.getProId()%>"},
				success: function(result) {
					if(result.rst) {
						$("#exampleModal").modal("hide");
						alert("성공적으로 문의하기가 등록 되었습니다.")
					}else {
						alert("문의하기에 실패했습니다. 다시 시도해주세요.")
					}
				},
				error: function(xhr) {
					alert(xhr)
					console.log(xhr)
				},
				dataType: 'json'
			})
		})
		
				
              
		
	</script>

	<!-- Footer-->
	<%@include file="../common/mainfooter.jsp"%>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

	<!-- Core theme JS-->
	<script src="<%=request.getContextPath()%>/js/scripts.js"></script>
	<script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
<script>
    AOS.init();
</script>
</body>
</html>