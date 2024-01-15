<%@page import="vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- header 정보 -->
<%@ include file="./header.jsp"%>


<!-- main -->
<%
    MemberVO mv = (MemberVO)request.getAttribute("mv");
	List<MemberVO> list = (List<MemberVO>)request.getAttribute("list");
%>

    <div id="layoutSidenav_content">
        <main>
            <div class="container-fluid px-4">
                <h1 class="mt-4">회원 관리</h1>
                <ol class="breadcrumb mb-4">
                    <li class="breadcrumb-item active">일반회원 관리</li>
                </ol>


                <!-- 여기서부터 내용!!!!!!!!!!!!!!!!!! -->

           
                <div style="height: 1em;"></div>
                
                <div class="card mb-4">
                    <div class="card-header">
                        <i class="fas fa-table me-1"></i>
                        일반회원 조회
                    </div>
                    <div class="card-body">
                        <table id="datatablesSimple">
                            <thead>
                                <tr>
                                    <th>No</th>
                                    <th>회원ID</th>
                                    <th>이름</th>
                                    <th>가입일</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tfoot>
                                <tr>
                                  <th>No</th>
                                  <th>ID</th>
                                  <th>Name</th>
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
                          		 <td><%= list.get(i).getMemId() %></td>
                            	<td><%= list.get(i).getMemName() %></td>
                            	<td><%= list.get(i).getFormBirth() %></td>
                            	<td>
                            		<button type="button" class="btn btn-primary"
                            		data-bs-toggle="modal" data-bs-target="#exampleModal"
        							style="--bs-btn-padding-y: .25rem; --bs-btn-padding-x: .5rem; --bs-btn-font-size: .75rem;">
 									 	수정
									</button>
                            	</td>
                            <tr>
                            <%} %>
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
                          <h1 class="modal-title fs-5" id="exampleModalLabel">회원정보 수정</h1>
                          
                          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>   
                        <div class="modal-body">
                        
                        	<p>
                            	<span><b>회원 I D : </b></span>
                            	<span> <b><%=list.get(i).getMemId() %></b> </span>
                            </p>
                        	
                        	<form id="updateForm" action="memberAdminUpdate.do" method="post">
                				<input type="text" id="dataToUpdate" name="memId" value="<%=list.get(i).getMemId()%>" style="display:none;">
                        		<span>이름 </span>
                				<input type="text" id="dataToUpdate" name="memName" value="<%=list.get(i).getMemName()%>">
                				<p></p>
                				
                				<span>비밀번호 </span>
                				<input type="text" id="dataToUpdate" name="memPw" value="<%=list.get(i).getMemPw()%>">
                				<p></p>
                				
                				<span>이메일 </span>
                				<input type="text" id="dataToUpdate" name="memMail" value="<%=list.get(i).getMemMail()%>">
                				<p></p>
                				
                				<span>성별 </span>
								<span><%=list.get(i).getmemGender() %></span><br>
                				<p></p>
                				
                				<span>생일 : </span>
                				<span><%=list.get(i).getFormBirth() %></span><br>
                				<p></p>
                				
                				<span>전화번호 </span>
                				<input type="text" id="dataToUpdate" name="memTel" value="<%=list.get(i).getMemTel()%>">
                				<p></p>
                				
                				<span>주소 </span>
                				<input type="text" id="dataToUpdate" name="memAddr" value="<%=list.get(i).getMemAddr()%>">
            					<p></p>
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