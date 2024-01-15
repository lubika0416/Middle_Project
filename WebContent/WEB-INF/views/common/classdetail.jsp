<%@page import="org.apache.catalina.connector.Request"%>
<%@page import="vo.ReviewVO"%>
<%@page import="vo.PQNAVO"%>
<%@page import="vo.ClassScheduleVO" %>
  <%@page import="vo.FileVO" %>
    <%@page import="java.util.List" %>
      <%@page import="vo.ClassesVO" %>
        <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
        <%
        	PQNAVO pqVO = (PQNAVO)request.getAttribute("pqVO");
        %>

          <!DOCTYPE html>
          <html lang="en">

          <head>
            <meta charset="utf-8" />
            <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
            <title>CLASS</title>
            <!-- Favicon-->
            <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
            <!-- Core theme CSS (includes Bootstrap)-->
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
            <link href="<%=request.getContextPath()%>/css/styles.css" rel="stylesheet" />
            <link href="<%=request.getContextPath()%>/css/font.css" rel="stylesheet" />
            <link href="<%=request.getContextPath()%>/css/classPage.css" rel="stylesheet" />
            <link rel="stylesheet"
              href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" />
            <script src="https://oapi.map.naver.com/openapi/v3/maps.js?ncpClientId=zuyt7c86ti"></script>
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
            
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.css" />
            <script src="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.js"></script>

            <style>
              * {
                font-family: "Pretendard4";
              }
              
              .tab-content{
               width: 100%; 
               display: flex; 
               align-items: flex-start;
              }
              
              .nav-link .nav-link.active {
              	padding: 3px 40px;
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
			  
			  .nav-pills {
			  	font-size: 24px !important;
			  }
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
          <script>
            $(function () {

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
              
              
              // 별점 시작
              const size = $('#rvLength').val();
              
              for(let i = 0; i < size; i++) {
                const rating = $('#rvRating'+i).val();
                starRating(rating,i);
              }
              
              function starRating(rating, index) {
                
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
              }
              
              
            })
          </script>
          <%
			
	      	Object insertpqnaresult_ = request.getAttribute("insertpqnaresult");
	      	if (insertpqnaresult_ != null) {
	      		boolean result = (boolean)insertpqnaresult_;
	      		if (result) {%>
	      			<script>alert("문의 등록에 성공했습니다.")</script>
	      		<%} else {%>
	      			<script>alert("문의 등록에 실패했습니다.")</script>
	      		<%}
	      	}
	      	request.removeAttribute("insertpqnaresult");
          %>

          <body>

            <%@include file="mainheader.jsp" %>
			

			<script>
				const dateList = [];
				const scdList = [];
			</script>
              <% 
              Object obj = session.getAttribute("loginInfo");
              
              // 공방정보 
              ProducerVO pv=(ProducerVO) request.getAttribute("pv"); 
              // 클래스정보 
              ClassesVO cv=(ClassesVO)request.getAttribute("cv"); 
              // 클래스 이미지 리스트 
              List<FileVO> clsFileList = (List<FileVO>)request.getAttribute("clsFileList");
              // 일정이 있는 날짜("MM-dd")
              List<String> dateList = (List<String>) request.getAttribute("dateList");
              // 클래스 모든 일정
              List<ClassScheduleVO> scdList = (List<ClassScheduleVO>) request.getAttribute("scdList");
              // 일정 중 가장 빠른 달
              int minMonth = (int) request.getAttribute("minMonth");
              // 리뷰 파일 리스트
              List<List<FileVO>> rvFileList = (List<List<FileVO>>)request.getAttribute("rvFileList");
              // 리뷰 리스트
              List<ReviewVO> reviewList = (List<ReviewVO>)request.getAttribute("reviewList"); 
              
              for(String s : dateList) {%>
            	 <div id="values<%=s%>" style="display: none;"><%=s%></div>
            	 <script>dateList.push($('#values<%=s%>').text())</script>
              <%}
				int a = 1;
              for(ClassScheduleVO csv : scdList) {%>
                <script>
                	scdList.push({
                    "formDate": "<%=csv.getFormatDate()%>",
                    "mxPs": "<%=csv.getMaxPerson()%>",
                    "cPs": "<%=csv.getCurrentPerson()%>",
                    "sTm": "<%=csv.getStartTime()%>",
                    "cssId": "<%=csv.getCssId()%>",
                    "cnt": <%=a++%>
                  })
                </script>
              <%}%>
              
               <!-- 이미지 -->
                      
                      <div class="swiper mySwiper" >
					<div class="swiper-wrapper">
					
					<% for (FileVO fv : clsFileList) { %>
                          <div class="swiper-slide">
                            <img src="<%=request.getContextPath()%>/upload_images/<%=fv.getFileSvNm()%>"
                              style=" height:500px; width: 1120px;" alt="...">
                          </div>
                          <% } %>
					
					</div>
					<div class="swiper-button-next" style="color: #000;"></div>
					<div class="swiper-button-prev" style="color: #000;"></div>
					<div class="swiper-pagination" style="color: #000;"></div>
				</div>
                      
                  <!-- 이미지 끝 -->
              
                  <div class="defaultmargin" style="height: 100vh;">

                   

                      <div class="classHeader" style="margin-top: 16px; padding:0px 16px; width: 100%;">
                        <div class="col-9 container classContent">
                          <div class="classcontentText">
                            <a href="<%=request.getContextPath() %>/detailstore.do?proId=<%=pv.getProId() %>"><%=pv.getProStore()%></a>
                          </div>
                          <h1 class="classtitle" style="font-size: 50px;">
                            <b><%=cv.getClsName()%></b>
                          </h1>
                        </div>
                        <div class="classBtn">
                        <%if (obj != null && obj instanceof MemberVO) { %>
                          <button type="button" class="btn1" data-bs-toggle="offcanvas"
                            data-bs-target="#offcanvasRight" aria-controls="offcanvasRight">예약하기</button>
                            <% if ((boolean)request.getAttribute("checked")) { %>
                          <button type="button" class="btn2" onclick="location.href='http://localhost:8888/Jdus/member/removefavorite.do?memId=<%=((MemberVO)session.getAttribute("loginInfo")).getMemId()%>&clsId=<%=cv.getClsId()%>'">관심목록 제거</button>
                           <%} else { %>
                          <button type="button" class="btn22" onclick="location.href='http://localhost:8888/Jdus/member/addfavorite.do?memId=<%=((MemberVO)session.getAttribute("loginInfo")).getMemId()%>&clsId=<%=cv.getClsId()%>'">관심목록 추가</button>
                           <%} %>
                          <button type="button" class="btn22" data-bs-toggle="modal"
                            data-bs-target="#staticBackdrop">문의하기</button>
                            <%} else { %>
                            <button type="button" class="btn1" data-bs-toggle="offcanvas"
                            data-bs-target="#offcanvasRight" aria-controls="offcanvasRight" onclick="alertLogin()">예약하기</button>
                          <button type="button" class="btn22" onclick="alertLogin()">관심목록 추가</button>
                          <button type="button" class="btn22" data-bs-toggle="modal"
                            data-bs-target="#staticBackdrop" onclick="alertLogin()">문의하기</button>
                            <%} %>
                        </div>
                      </div>
                     
                      
                      <hr style="width: 1120px; height: 2px; color: black;  margin: 32px;">
                      
				<div class="defaultmargin" style="align-items: flex-start;  justify-content: flex-start;">
                     
                    <ul class="nav nav-pills">
  
  						<li class="nav-item">
						    <a class="nav-link active" data-toggle="tab" href="#qwe">클래스 정보</a>
					   </li>
  					   <li class="nav-item">
   	  					    <a class="nav-link" data-toggle="tab" href="#asd">위치</a>
  					   </li>
  					   <li class="nav-item">
    						<a class="nav-link" data-toggle="tab" href="#zxc">리뷰</a>
  					   </li>
  					   
					</ul>
				<div class="tab-content">
  					<div class="tab-pane fade show active" id="qwe">
						<div class="container classInfo" style="width: 100%; margin-top: 32px; padding:16px; display: flex; flex-direction: row; align-items: flex-start;">
                      		<div class="classScript" style="width:300px; padding: 0px;">
                        		<p>소요 시간: <%=cv.getClsTime()%>분</p>
                          		<p>가격: <%=cv.getClsPrice()%>/ 1인</p>
                          		<p>최대인원: <%=cv.getClsMxps()%>명</p>
                      		</div>
                      		<div style="width:800px;">
                      			<p><%=cv.getClsDesc() %>
                      		</div>
                    	</div>
  					</div>
  					<div class="tab-pane fade" id="asd" style="width: 100%; height: 100%; padding:16px;">

    					<div style="margin-top: 32px;  display: flex; height: 100%; align-content: stretch; justify-content: flex-start; margin: 16px;">
                      		<div id="map" style="width: 600px; height: 500px; border-radius: 24px; margin-top: 16px;"></div>
                      		<div style="margin-top: 16px;">
                      			<div class="classScript" style="margin-left: 32px; ">
                      				<b>오시는 길</b> 
                      			</div>
                      			<div id="proAddr"><%=pv.getProAddr().split("/")[1] %></div>
                      		</div>	
                    	</div>
  					</div>
					<div class="tab-pane fade" id="zxc"
						style="width: 100%; padding: 16px;">
						
						
						<div style="height: 550px; overflow-y: scroll; padding:24px;">
						
						
							<input type="number" id="rvLength" value="<%=reviewList.size()%>" style="display: none;">
							<%if (reviewList.size() > 0) { 
								for(int i = 0; i < reviewList.size(); i++) {%>
								<!-- 리뷰 목록 시작 -->
								<div class="card shadow-0 border rounded-3"
									style="margin-bottom: 8px; width: 1000px; height: 250px; display: flex; flex-direction: row;">
									<div class="card-body">
										<div class="row">
											<%if (rvFileList.get(i).size() > 0){ %>
											<img src="<%=request.getContextPath()%>/upload_images/<%=rvFileList.get(i).get(0).getFileSvNm()%>"
												style="width: 300px; height: 220px;" />
											<%}%>
											<div style="width: 50%; margin-left: 30px; margin-top: 10px;">
												<div class="mt-1 mb-0 text-muted small">
													<span><%=reviewList.get(i).getWriter().substring(0,2)+"*"%> </span> &nbsp;&nbsp;&nbsp; <span><%=reviewList.get(i).getReviewNo()%></span>
												</div>
												<div class="mt-1 mb-0 text-muted small"><%=reviewList.get(i).getFormDt()%></div>
												<p style="height: 100px; font-size: 18px; overflow: hidden;"><%=reviewList.get(i).getReviewContent()%></p>
												<div id="rating<%=i%>" class="rating" style="margin-top: 8px;">
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
           
           
           
           
           
           <!-- Modal -->
                      <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static"
                        data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel"
                        aria-hidden="true">
                        <div class="modal-dialog modal-dialog-centered">
                          <div class="modal-content">
                            <div class="modal-header">
                              <h4 class="modal-title" id="staticBackdropLabel">공방에 문의하기</h4>
                              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">

                              <form action="<%=request.getContextPath()%>/PQNAWrite.do" method="post">
                               <input type="hidden" name="proId" value="<%=cv.getProId()%>">
                               <input type="hidden" name="clsId" value="<%=cv.getClsId()%>">
                              
                              
                                <div class="modal_group">
                                  <label for="questionTitle">제목</label>
                                  <input type="text" class="form-control" id="questionTitle" placeholder="제목을 입력하세요." required name="pqnaTitle"/>
                                </div>

                                <div class="modal_group">
                                  <label for="questionContent">문의 내용</label>
                                  <input type="text" class="form-control" id="questionContent" placeholder="문의 내용을 입력하세요." required name="pqnaContent"/>
                                </div>

                            </div>
                            <div class="modal-footer">
                              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
                              <button type="submit" class="btn btn-primary" id="clsdetail">문의하기</button>
                            </div>
                              </form>
          
                               
                          </div>
                        </div>
                      </div>

					
					
					 <div class="offcanvas offcanvas-end" data-bs-backdrop="static" tabindex="-1"
                        id="offcanvasRight" aria-labelledby="offcanvasRightLabel" style="width: 30%;">
                        <div class="offcanvas-header mb-3">
                          <h3 class="offcanvas-title" id="offcanvasRightLabel">클래스 예약하기</h3>
                          <button type="button" class="btn-close" data-bs-dismiss="offcanvas"
                            aria-label="Close"></button>
                        </div>
                        <div class="offcanvas-body">

                          <span class="classTitle">
                            <%=cv.getClsName()%>
                          </span>

                          <div class="container classRes">
                            <form action="<%=request.getContextPath()%>/reservation.do" method="post">
                              
                              <div class="classRes_group">
                                <p>예약 날짜</p>
                                <div class="resMonthBtns">
                                  <input type="button" value="<<" class=" btn btn-outline-dark btn-sm" style="width: 50px" onclick="prevMonth()">
                                  <span class="resMonth"><div id="month" onchange="changeMonth()">9</div>월</span>
                                  <input type="button" value=">>" class="btn btn-outline-dark btn-sm" style="width: 50px" onclick="nextMonth()">
                                </div>
                                <input type="text" name="resDate" id="resDate" style="display: none;">
                                <!-- 날짜목록 처리 div -->
                                <div class="possibleDates"></div>
                              </div>
                              
                              <div class="classRes_group">
                                <label for="resCnt">예약 인원</label> <span class="count"> <a
                                    class="minusCnt"><i class="bi bi-dash-square"></i></a>
                                  <span id="resultCnt" >0</span> <a class="plusCnt"><i
                                      class="bi bi-plus-square"></i></a>
                                </span>
                                <input type="number" name="pCnt" id="pCnt" style="display: none;">
                                <div class="resCnt_comment"></div>
                              </div>
                              <div class="classRes_group">
                                <p>예약 시간</p>
                                <div id="resultTime"></div>
                                <input type="text" name="resTime" id="resTime" style="display: none;">
                              </div>

                              <div class="classRes_group">
                                <label for="resultPrice">결제 예정 금액</label> <span id="resultPrice">₩0</span>
                                <input type="text" name="resPrice" id="resPrice" style="display: none;">
                                <input type="text" name="clsId" value="<%=cv.getClsId()%>" style="display: none;">
                                <input type="text" name="cssId" id="cssId" style="display: none;">
                              </div>

                          <div class="resBtn">
                            <!-- data-bs-dismiss="offcanvas" aria-label="Close" -->
                            <button type="reset" class="btn btn-outline-danger" data-bs-dismiss="offcanvas"
                              aria-label="Close">취소</button>
                            <button type="submit" class="btn btn-outline-success">예약하기</button>
                          </div>
                            </form>
                          </div>



                        </div>
                      </div>
					
					
					
                  <!-- Footer-->
                  <%@include file="mainfooter.jsp" %>



                        <script>
                          
                        
                        
                          let plus = document.querySelector(".plusCnt");
                          let minus = document.querySelector(".minusCnt");
                          let result = document.querySelector("#resultCnt");
                          let comment = document.querySelector(".resCnt_comment");
                          let totalcost = document.querySelector("#resultPrice");
                          let i = 0;

                          plus.addEventListener("click", () => {
                            i++
                            result.textContent = i;
                            let totalcostNum = i * <%=cv.getClsPrice()%>;
                            totalcost.textContent = "₩" + totalcostNum.toLocaleString();
                            comment.textContent = ""
                          })

                          minus.addEventListener("click", () => {
                            if (i > 1) {
                              i--
                              result.textContent = i;
                              let totalcostNum = i * <%=cv.getClsPrice()%>;
                              totalcost.textContent = "₩" + totalcostNum.toLocaleString();
                              comment.textContent = ""
                            } else {
                              comment.textContent = "1명 이상의 예약인원을 입력해주세요."
                            }
                          })
                          
                          
                          let month = $('#month');
                          function prevMonth() {
                            if (month.text() == 1) {
                              month.text(12);
                              renderResDateList()
                            } else {
                              month.text(month.text()-1);
                              renderResDateList()
                            }
                          }
                          
                          function nextMonth() {
                            if (month.text() == 12) {
                              month.text(1);
                              renderResDateList()
                            } else {
                              month.text(Number(month.text())+1);
                              renderResDateList()
                            }
                          }
                          
                          let resDate = "";
                          
                          function renderResDateList() {
                            const possibleDates = $('.possibleDates');
                            possibleDates.empty();
                            // 일단 날짜 목록부터 보여주자
                            dateList.forEach( date => {
                              const today = new Date();
                              const currentYear = today.getFullYear();
                              const dateParts = date.split('-');
                              const targetDate = new Date(currentYear, parseInt(dateParts[0])-1, parseInt(dateParts[1]))
                              if (month.text() == Number(date.substring(0,2)) && targetDate > today) {
                              // if (month.text() == Number(date.substring(0,2))) {
                                let radio = `<input type="radio" class="btn-check" name="date" id="` + date + `"><label class="btn-outline-secondary dateBtn" for="` + date + `">` + date + `</label>`;
                                possibleDates.append(radio);
                              }
                            })
                            $('.dateBtn').on('click', event => {
                              resDate = event.target.innerText;
                              console.log(resDate);
                            })
                          }
                          
                          $('.bi').on('click', async () => {
                            await delay(150);
                            const resCnt = $('#resultTime');
                            resCnt.empty();
                            const resultCnt = $('#resultCnt').text();
                            console.log(resultCnt);
                            scdList.forEach( scd => {
                              if (scd.formDate == resDate && (scd.mxPs - scd.cPs >= resultCnt)) {
                                let radio = `<input type="radio" class="btn-check " name="time" id="` + scd.sTm + `"><label class="btn-outline-secondary dateBtn" for="` + scd.sTm + `">` + scd.sTm + `</label>`;
                                resCnt.append(radio);
                              }
                            })
                            
                            $('.dateBtn').on('click', event => {
                              $('#pCnt').val(resultCnt);
                              $('#resDate').val(resDate);
                              $('#resTime').val(event.target.innerText)
                              $('#resPrice').val(totalcost.innerText)
                              scdList.forEach( scd => {
                                if (scd.formDate == resDate && scd.sTm == event.target.innerText) {
                                  $('#cssId').val(scd.cssId);
                                }
                              })
                            })
                          })
                          
                          function delay(ms = 1000) {
                            return new Promise((resolve) => setTimeout(resolve, ms));
                          }
                          
                          function alertLogin() {
                            alert("로그인이 필요한 서비스 입니다.");
                            location.href = "http://localhost:8888/Jdus/login.do";
                          }
                          
                          renderResDateList();
                          
                          
                          
                          
                        </script>
                        
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
    	    delay: 2000,
    	  },
    });
  </script>

                        <!-- Bootstrap core JS-->
                        <script
                          src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
                        <!-- Core theme JS-->
                        <script src="<%=request.getContextPath()%>/js/scripts.js"></script>
  </body>

  </html>