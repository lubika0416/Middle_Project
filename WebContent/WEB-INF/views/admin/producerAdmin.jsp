<%@page import="vo.ProducerVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- header 정보 -->
<%@ include file="./header.jsp"%>


<!-- main -->
<%
	ProducerVO pv = (ProducerVO)request.getAttribute("pv");
	List<ProducerVO> list = (List<ProducerVO>)request.getAttribute("list");
%>

    <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">회원 관리</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active">사업자회원 관리</li>
                        </ol>
                        

                        <!-- 여기서부터 내용!!!!!!!!!!!!!!!!!! -->

                   
                        <div style="height: 1em;"></div>
                        
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>
                               사업자회원 조회
                            </div>
                            <div class="card-body">
                                <table id="datatablesSimple">
                                    <thead>
                                        <tr>
                                            <th>No</th>
                                            <th>회원ID</th>
                                            <th>이름</th>
                                            <th>공방이름</th>
                                            <th>가입일</th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                          <th>No</th>
                                          <th>ID</th>
                                          <th>Name</th>
                                          <th>WorkshopName</th>
                                          <th>REGDT</th>
                                          <th>Update</th>
                                        </tr>
                                    </tfoot>
                                    
		                            <tbody>
		                            <%
		                            for(int i = 0; i < list.size(); i++){
		                            %>
		                            <tr>
		                            	<td><%= i+1 %></td>
		                          		<td><%= list.get(i).getProId() %></td>
		                            	<td><%= list.get(i).getProName() %></td>
		                            	<td><%= list.get(i).getProStore() %></td>
		                            	<td><%= list.get(i).getFormRegdt() %></td>
		                            	<td>
                            				<button type="button" class="btn btn-primary"
                            					data-bs-toggle="modal" data-bs-target="#exampleModal"
        										style="--bs-btn-padding-y: .25rem; --bs-btn-padding-x: .5rem; --bs-btn-font-size: .75rem;">
 									 				수정
											</button>
                            			</td>
		                            <tr>
		                            <%
		                            }
		                            %>
		                            </tbody>
                                    
                                </table>
                            </div>
                        </div>
                        
                        
                        <%
                            for(int i = 0; i < list.size(); i++){
                            %>
                <!-- 모달!!!!!!!!!!! -->
                <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                      <div class="modal-content">
                        <div class="modal-header">
                          <h1 class="modal-title fs-5" id="exampleModalLabel">사업자회원정보 수정</h1>
                          
                          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>   
                        <div class="modal-body">
                        
                        	<p>
                            	<span><b>회원 I D : </b></span>
                            	<span> <b><%=list.get(i).getProId() %></b> </span>
                            </p>
                        	
                        	<form id="updateForm" action="producerAdminUpdate.do" method="post">
                        	
                				<input type="text" id="dataToUpdate" name="proId" value="<%=list.get(i).getProId() %>" style="display:none;">
                				
                        		<span>회원이름 </span>
                				<input type="text" id="dataToUpdate" name="proName" value="<%=list.get(i).getProName()%>">
                				<p></p>
                				
                				<span>비밀번호 </span>
                				<input type="text" id="dataToUpdate" name="proPw" value="<%=list.get(i).getProPw()%>">
                				<p></p>
                				
                				<span>이메일 </span>
                				<input type="text" id="dataToUpdate" name="proEmail" value="<%=list.get(i).getProEmail()%>">
                				<p></p>
                				
                				<span>회원전화번호 </span>
                				<input type="text" id="dataToUpdate" name="proTel" value="<%=list.get(i).getProTel() %>">
                				<p></p>
                		
                				<span>공방명</span>
                				<input type="text" id="dataToUpdate" name="proStore" value="<%=list.get(i).getProStore() %>">
                				<p></p>
                				
                				<span>사업자번호</span>
                				<input type="text" id="dataToUpdate" name="proRegNo" value="<%=list.get(i).getProRegNo() %>">
                				<p></p>
                				
                				<span>사업장 주소</span>
                				<input type="text" id="dataToUpdate" name="proAddr" value="<%=list.get(i).getProAddr() %>">
                				<p></p>
                				
                				<span>사업장 전화번호</span>
                				<input type="text" id="dataToUpdate" name="proStrTel" value="<%=list.get(i).getProStrTel() %>">
                				<p></p>
                				
                				<span>공방 프로필 사진</span>
                				<input type="text" id="dataToUpdate" name="fileId" value="<%=list.get(i).getFileId() %>">
                				<p></p>
                						                				
                				<span>공방 프로필 인사</span>
                				<input type="text" id="dataToUpdate" name="proPro" value="<%=list.get(i).getProPro() %>">
                				<p></p>
                				
                				<span>공방 소개</span>
                				<input type="text" id="dataToUpdate" name="proDesc" value="<%=list.get(i).getProDesc() %>">
                				<p></p>
                				    				
                				<input type="text" id="dataToUpdate" name="proRegNo" value="<%=list.get(i).getProRegdt() %>" style="display:none;">
                				<input type="text" id="dataToUpdate" name="proDesc" value="<%=list.get(i).getProDesc() %>" style="display:none;">
                				<input type="text" id="dataToUpdate" name="proPro" value="<%=list.get(i).getProPro() %>" style="display:none;">
     
                		
            				</form>
                            
                        </div>
                        <div class="modal-footer">
                          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                          <button type="submit" method="post" class="btn btn-primary" form="updateForm">수정하기</button>
                        </div>
            
                      </div>
                    </div>
                  </div>
                    <%}%>

				<!-- 모달!!!!!!!!!!!끝 -->
                        
                        

                 
                            </div>  
                        </div>   
                    </div>
                </main>

<!-- footer -->
<%@ include file="./footer.jsp" %>