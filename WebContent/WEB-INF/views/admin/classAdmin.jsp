<%@page import="vo.ClassesVO"%>
<%@page import="vo.FileVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- header 정보 -->
<%@ include file="./header.jsp"%>


<!-- main -->


      <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">클래스</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active"> 클래스 관리</li>
                        </ol>


                        <!-- 여기서부터 내용!!!!!!!!!!!!!!!!!! -->
<%
	List<ClassesVO> clsList = (List<ClassesVO>)request.getAttribute("clsList");


%>
                   
                      <div class="row">  
                        <div class="col-xl-2 card mx-6" style="display: flex; margin-left: 1em; margin-right: 1em; padding: 0.5em; background-color: rgb(179, 179, 179); height: 70vh;">                   
                          <div style="margin: 0.5em">검색</div>
                          <input class="form-control" id="myInput" type="text" placeholder="Search..">
                          <br>
                          
                        </div>



                      <div class="col-xl-9">
                        <div class="card mb-4" style="height: 70vh; overflow-y: scroll; display: block">
                        
                        
                          	<div class="box m-3" style="border: none; border-bottom: 1px solid lightgrey; height: 13em; display: flex;">	
                          	 	<img src="<%=request.getContextPath()%>/assets/img/유빈하이.jpg" style="height: 12em; width: 17em; display: flex;">
                          	  	<div class="row" style="width:60vh;" >
                          	  	<%
                          	  	for(int i=0; i<clsList.size(); i++){
                          	  		
                          	  	
                          	  	%>
                          	  	<div class="col-xl-10" style="justify-content: space-between;">카테고리
                          	  		<h3 style="margin-top: 10px;"><%=clsList.get(i).getClsName() %></h3>
                          	  		<br>
                          	  		<%=clsList.get(i).getClsPrice() %><br>
                          	  		<%=clsList.get(i).getClsTime() %><br>
                          	  		인원
                          	  	</div>
                          	  	<%
                          	  	}
                          	  	%>
                          	  	
                          	  	<div class="col-xl-2" style="float: right;">
                          	  		<button type="button" class="btn text-white" style="background-color: gray; width: 60px; margin-top: 17vh;" >수정</button>
                          		</div>
                          	</div>
                           </div>
                          	
                          
                          	
                        </div>  
                      </div>  

                    </div> 
     
                            </div>
                            
                        </div>
                       
                    </div>
                </main>


<!-- <script> -->
// $(document).ready(function(){
//   $("#myInput").on("keyup", function() {
//     var value = $(this).val().toLowerCase();
//     $("#myList li").filter(function() {
//       $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
//     });
//   });
// });
<!-- </script> -->
<!-- footer -->
<%@ include file="./footer.jsp" %>