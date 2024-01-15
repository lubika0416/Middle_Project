<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- header 정보 -->
<%@ include file="./header.jsp"%>


<!-- main -->
<%

%>
<form action="<%=request.getContextPath()%>/admin/noticeWrite.do" method="post">
    <div id="layoutSidenav_content">
        <main>
            <div class="container-fluid px-4">
                <h1 class="mt-4">고객센터</h1>
                <ol class="breadcrumb mb-4">
                    <li class="breadcrumb-item active">공지사항</li>
                </ol>


                <!-- 여기서부터 내용!!!!!!!!!!!!!!!!!! -->
        
                <div class="col-md" style="width:1120px; margin: auto;">
                    <div class="contact-form" style="display: flex; flex-direction: column; align-items: center;">
                        <div class="form-group" style="margin: 4px;">
                          <label class="control-label col-sm-2" for="fname">First Name:</label>
                          <div class="col-sm-10" style="width:1020px;">          
                            <input type="text" class="form-control" id="fname" name="noticeTitle" placeholder="제목" name="fname">
                          </div>
                        </div>
                     	
                        <div class="form-group" style="margin: 4px;">
                          <label class="control-label col-sm-2" for="comment"></label>
                          <div class="col-sm-10"  style="width:1020px; overflow-y: scroll;">
                            <textarea class="form-control" rows="5" id="comment" name="noticeContent" style="height: 500px;">내용</textarea>
                            
                            <script>
                            var str = document.getElementById("comment").value;

                            str = str.replace(/(?:\r\n|\r|\n)/g, '<br/>');

                            document.getElementById("comment").value = str;
							</script>
                            
                          </div>
                        </div>
                        <div class="form-group" style="margin: 4px;">        
                          <div class="col-sm-10">
                          	<button type="submit" class="btn btn-secondary" style="width:100px;">등록</button>
<%--                           	 onclick="location.href='<%=request.getContextPath()%>/admin/noticeBoard.do'" --%>
                          </div>
                        </div>
                    </div>
                </div>


              


                    
            </div>
        </main>
</form>

<!-- footer -->
<%@ include file="./footer.jsp" %>