<%@page import="vo.FileVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="vo.ClassesVO"%>
<%@page import="vo.ReviewVO"%>
<%@page import="java.util.List"%>
<%@ page import="java.sql.*" %>
<!-- header 정보 -->
<%@ include file="./header.jsp"%>


<!-- main -->
<script>
function chkDelete(reviewNo) {
	if(confirm("삭제하시겠습니까?")){
		location.href = "deleteReview.do?reviewNo=" + reviewNo;
		alert("정상적으로 삭제되었습니다.");
	}else{
		console.log('ok');
	}
}
</script>

      <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">리뷰</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active"> 리뷰 관리</li>
                        </ol>


                        <!-- 여기서부터 내용!!!!!!!!!!!!!!!!!! -->
<%
	List<ReviewVO> rlist = (List<ReviewVO>)request.getAttribute("rlist");
	ReviewVO rv = (ReviewVO)request.getAttribute("rv");
	List<ClassesVO> cList = (List<ClassesVO>)request.getAttribute("cList");
	List<List<FileVO>> rFileList = (List<List<FileVO>>)request.getAttribute("rFileList"); 
%> 

                   
                       <div class="row" style="display: flex; flex-direction: column; align-items: center; justify-content: center;">  
                        <div class="card" style="width:1540px; display: flex; align-items: center; flex-direction: row; padding: 0.5em; background-color: rgb(179, 179, 179); height: 60px;">                   
                          <div style="margin-right: 16px; display: flex; justify-content: center;"><b>검색</b></div>
                          <input class="form-control" id="myInput" type="text" placeholder="Search.." style="width:500px;">
                        </div>
					
                        <div class="row justify-content-center mb-3">
                          <div style="width: 1560px; height: 70vh; overflow-y: scroll;">
                           <%
                                  	for(int i=0; i<rlist.size(); i++){
                                  %>
                            <div class="card shadow-0 border rounded-3" style="width: 1480px; height:250px;  display: flex; flex-direction: row;">
                              <div class="card-body">
                                <div class="row" style=" display: flex; justify-content: space-around;">
                                	<%if (rFileList != null && rFileList.get(i).size() > 0) { %>
                                      <img src="<%=request.getContextPath()%>/upload_images/<%=rFileList.get(i).get(0).getFileSvNm()%>" style="width: 400px; height: 220px;"/>
                                      <%} else {%>
                                      <img alt="ff" src="<%=request.getContextPath()%>/images/다운로드.png" style="width: 400px; height: 220px;">
                                      <%}%>
                                  <div style="width: 50%; margin-left: 30px; margin-top: 10px;"> 
                                    <div class="mt-1 mb-0 text-muted small">
                                      <span><%= rlist.get(i).getReviewNo() %></span>
<%--                                       <span><%= cList.get(i).getClsName() %></span> --%>
                                    </div>
                                    <h5><b><%= rlist.get(i).getClsName() %></b></h5>
                                    <div class="mt-1 mb-0 text-muted small"><%=rlist.get(i).getFormDt() %></div>
                                    <div>
                                      	<%= rlist.get(i).getReviewContent() %>
                                    </div>
                                  </div>
                                  
                                  <div class="border-sm-start-none border-start" style=" display: flex; flex-direction: column; width:200px; justify-content: center; align-items: center;">
                                      <input type="button" value="삭제" onclick="chkDelete(<%=rlist.get(i).getReviewNo() %>)" class="btn btn-secondary" style="width: 100px;">
                                  </div>
                                </div>
							                </div>
							                
                           
                        </div>
                            <%
                          }//for end
                             %>
                      </div>
                           
                    </div>
                        
                    </div>
                            </div>
                        </div>
                        </div>
					
					
					
					
                       
                    </div>
                </main>


<script>
/* $(document).ready(function(){
  $("#myInput").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#myList li").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});
 */


</script>
<!-- footer -->
<%@ include file="./footer.jsp" %>