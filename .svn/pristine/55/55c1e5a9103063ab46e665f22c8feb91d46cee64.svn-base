<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- header 정보 -->
<%@ include file="./header.jsp"%>


<!-- main -->
<%

%>

	<form action="insertNotice.do" method="post" enctype="multipart/form-data">
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
                          <label class="control-label col-sm-2" for="fname">제목</label>
                          <div class="col-sm-10" style="width:1020px;">          
                            <input type="text" class="form-control" id="fname" name="noticeTitle" value="" placeholder="제목을 입력해주세요." name="fname">
                          </div>
                        </div>
                     
                        <div class="form-group" style="margin: 4px;">
                          <label class="control-label col-sm-2" for="comment">내용</label>
                          <div class="col-sm-10"  style="width:1020px; overflow-y: scroll;">
                            <textarea class="form-control" rows="5" id="comment" name="noticeContent" value="" style="height: 500px;"></textarea>
                          </div>
                        </div>
                        <div class="form-group" style="margin: 4px;">        
                          <div class="col-sm-10">
                          
                    		<input type="submit" value="등록" class="btn btn-secondary" style="width:100px;"/>
               				
                          </div>
                        </div>
                    </div>
                </div>



              


                    
            </div>
        </main>
	</form>


<!-- footer -->
<%@ include file="./footer.jsp" %>