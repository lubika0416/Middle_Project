<%@page import="vo.ClassesVO"%>
<%@page import="vo.FeedVO"%>
<%@page import="vo.FileVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%
    List<ClassesVO> clsSearchList = (List<ClassesVO>)request.getAttribute("clsSearchList");
    List<List<FileVO>> fileListt = (List<List<FileVO>>)request.getAttribute("fileListt"); 
    
    %>
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
		min-height: 70vh; 
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




    
    
    
    <!-- 신규 클래스 -->
    
    <div class="container ppy-40" style="width: 1120px;">
      <div class="row" style="width: 1120px;">
        <div class="col-md-3">
          <div class="main-h2">검색 클래스 목록</div>
        </div>
      </div>
    </div>
	<!-- clsSearchList, fileListt -->
    <div class="container wrapper" style="width: 1120px;  height: max-content; padding: 0px;">
      <div class="row" style="width: 1120px; margin-left: 12px">
	    <input type="number" id="size" style="display: none;" value="<%=clsSearchList.size()%>">
	    <% if(clsSearchList.size() > 0){ %>
      	<% for(int i=0; i<clsSearchList.size(); i++){ 
      		%>
      	<div class="main-class-box" style="margin-right: 20px;">
          <a href="<%=request.getContextPath() %>/detailclass.do?clsId=<%=clsSearchList.get(i).getClsId() %>" class="text-decoration-none text-black" style="text-align: left;">
            <div class="imgParent" >
            <img src="<%=request.getContextPath() %>/upload_images/<%=fileListt.get(i).get(0).getFileSvNm() %>" class="card-img-top " alt="..." style="border-radius: 16px; height: 240px;" />
            </div>
            <div style="margin-left: 8px;">
              <div class="main-class-ex"><%=((List<String>)application.getAttribute("categoryName")).get(clsSearchList.get(i).getCateNo()-1) %>&nbsp;&nbsp;<%=clsSearchList.get(i).getClsTime() %>분</div>
              <div class="main-class-title"><%=clsSearchList.get(i).getClsName() %></div>
              <div class="main-class-ex text-black" style="margin-top: 8px;"><%=clsSearchList.get(i).getClsDesc().substring(0,2) %></div>
              <div class="rating" id="rating<%=i%>" style="margin-top: 8px;">
              </div>
              <div id="avg<%=i%>" style="display: none;"><%=clsSearchList.get(i).getRatingAvg()%></div>
              <div id="cnt<%=i%>" style="display: none;"><%=clsSearchList.get(i).getReviewCnt()%></div>
            </div>
          </a>
        </div>
		<%
			}
		}else{
		%>
		<div>검색 결과가 없습니다.</div>
		<%
		}
		%>
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