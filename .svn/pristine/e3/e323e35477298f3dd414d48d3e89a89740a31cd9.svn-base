<%@page import="vo.NoticeVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>MAIN</title>
    
    <!-- js -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
    <!-- Bootstrap icons-->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
      rel="stylesheet"
    />
     <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link href="<%=request.getContextPath() %>/css/styles.css" rel="stylesheet" />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css"
    />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
    <style>
.panel-faq-container {
  margin-bottom: -16px;
}
.panel-faq-title {
  cursor: pointer;
}
.panel-faq-answer {
  height: 0;
  overflow: hidden;
  /* 변화가 시작되는 쪽에다가 transition 적용해준다 0 -> 300px 
  왜? 닫기 버튼을 누를 때 변화가 티남 */
  transition: all 1s;
}
#btn-all-close {
  margin-bottom: 10px;
  background-color: #726996;
  border: none;
  color: #fff;
  cursor: pointer;
  padding: 10px 25px;
  float: right;
}
#btn-all-close:hover {
  background-color: yellow;
  color: #000;
  transition: all 0.35s;
}
.active {
  display: block;
  /* 높이를 정해줘야지만 transition이 적용됨 */
  height: 300px;
}

p::-webkit-scrollbar {
    display: none; /* Chrome, Safari, Opera*/
}    
    </style>
    
<%@include file="mainheader.jsp" %>
  </head>

<%
	List<NoticeVO> list = (List<NoticeVO>)request.getAttribute("list");
%>

  
<nav class="main-nav" style="width: 1120px; margin:auto; height: auto;">

<div class="sub-title">
<h1><b>공지사항</b></h1>
</div>
<div style="margin-top: 10vh; min-height:60vh; height: auto;">
  <table class="table" style="margin: 40px 0px; width:100%;">
    <thead>
      <tr class="text-center">
        <th scope="col" >&nbsp;&nbsp;No</th>
        <th scope="col">&nbsp;&nbsp;제목</th>
        <th scope="col">&nbsp;&nbsp;작성일</th>
      </tr>
    </thead>
    <tbody>
    <%
    	if(list.size()>0){
    		for(int i = 0; i<list.size(); i++){
    %>
      <tr>
        <td class="text-center" style="width:250px;">&nbsp;&nbsp;<%= list.get(i).getNoticeNo() %></td>
        <td>
        	 <div class="panel-faq-container" style="height: fit-content;">
              <p class="panel-faq-title"><%= list.get(i).getNoticeTitle() %></p>
              <div class="panel-faq-answer" >
                <p style="height: 290px; overflow-y: scroll;"><%=list.get(i).getNoticeContent() %></p>
              </div>
            </div>
        </td>
        <td class="text-center" style="width:250px;">&nbsp;&nbsp;<%= list.get(i).getFormNoticeRegdt() %></td>
      </tr>
      
    <% 
    }
    	}else {	
    %>
    <tr>
    	<td>등록된 공지사항이 없습니다.</td>
    </tr>
    <%
    	}
    %>
    </tbody>
  </table>
</div>  

  <div class="pagination p2" style="display: flex; height: 100%; justify-content: center;">
      <ul class="pagination pager">
      	<%
			int sPage = (int)request.getAttribute("sPage");	
			int ePage = (int)request.getAttribute("ePage");	
			int cPage = (int)request.getAttribute("cPage");	
		
			for(int i=sPage; i<=ePage; i++){
				if(cPage == i){
		%>
        <a class="is-active" href="Notice.do?page=<%=i %>"><li><%=i %></li></a>
        <%
				}else {
        %>
        <a href="Notice.do?page=<%=i %>"><li><%=i %></li></a>
        <%			
  		
				}//if end	
			}//for end
  		%>
      </ul>
    </div>
  

</nav>

<script>
window.onload = () => {
	  // panel-faq-container
	  const panelFaqContainer = document.querySelectorAll(".panel-faq-container"); // NodeList 객체
	  
	  // panel-faq-answer
	  let panelFaqAnswer = document.querySelectorAll(".panel-faq-answer");

	  // btn-all-close
	  const btnAllClose = document.querySelector("#btn-all-close");
	  
	  // 반복문 순회하면서 해당 FAQ제목 클릭시 콜백 처리
	  for( let i=0; i < panelFaqContainer.length; i++ ) {
	    panelFaqContainer[i].addEventListener('click', function() { // 클릭시 처리할 일
	      // FAQ 제목 클릭시 -> 본문이 보이게끔 -> active 클래스 추가
	      panelFaqAnswer[i].classList.toggle('active');
	    });
	  };
	  
	  btnAllClose.addEventListener('click', function() {
	    // 버튼 클릭시 처리할 일  
	    for(let i=0; i < panelFaqAnswer.length; i++) {
	        panelFaqAnswer[i].classList.remove('active');
	    };
	  });
	}
</script>


</html>



<!-- Footer-->
<%@include file="mainfooter.jsp" %>