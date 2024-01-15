<%@page import="vo.AQNAVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- header 정보 -->
<%@ include file="../header.jsp"%>


<!-- main -->
<%
	List<AQNAVO> list = (List<AQNAVO>)request.getAttribute("list");
%>

    <div id="layoutSidenav_content">
        <main>
            <div class="container-fluid px-4">
                <h1 class="mt-4">고객센터</h1>
                <ol class="breadcrumb mb-4">
                    <li class="breadcrumb-item active">1대1 문의</li>
                </ol>


                <!-- 여기서부터 내용!!!!!!!!!!!!!!!!!! -->

           
                <div style="height: 1em;"></div>
                
                <div class="card mb-4">
                    <div class="card-header">
                        <i class="fas fa-table me-1"></i>
                        1대1 문의 조회
                    </div>
                    <div class="card-body">
                        <table id="datatablesSimple">
                            <thead>
                                <tr>
                                    <th>No</th>
                                    <th>제목</th>
                                    <th>작성자</th>
                                    <th>처리상태</th>
                                    <th>작성일</th>
                                </tr>
                            </thead>
                            <tfoot>
                                <tr>
                                  <th>No</th>
                                  <th>ID</th>
                                  <th>Name</th>
                                  <th>Status</th>
                                  <th>Date</th>
                                </tr>
                            </tfoot>
                            
                            <tbody>
                            <%
                            if(list.size() > 0){
                            for(int i = 0; i < list.size(); i++){
                            %>
                            <tr>
                            	<td><%=list.get(i).getAqnaNo() %></td>
                          		<td><a href="QNAView.do?aqnaNo=<%=list.get(i).getAqnaNo()%>"><%=list.get(i).getAqnaTitle() %> </a></td>
<%--                           		<td><a href="notice.do?noticeNo=<%= list.get(i).getNoticeNo() %>"><%= list.get(i).getNoticeTitle() %></a></td> --%>
<%--                             	<td><%=list.get(i).getMemId() %></td> --%>
                            	
		                       	 <%if(list.get(i).getMemId() != null) {%>
		                        <td><%=list.get(i).getMemId() %>(일반회원)</td>
		                        <%}else if(list.get(i).getProId() != null){ %>
		                        <td><%=list.get(i).getProId() %>(사업자회원)</td>
		                        <%} %>
		                        
		                        <%
		                        if(Integer.parseInt(list.get(i).getAqnaStatus()) == 0){
		                        %>
                            	<td>답변 대기중</td>
                            	<%
		                        }else{
                            	%>
                            	<td>답변 완료</td>
                            	<%
		                        }
                            	%>
                            	
                            	<td><%=list.get(i).getFormAqnaRegdt() %></td>
                            <tr>
                            <%
                            	}
                            }else{
                            %>
                            <tr>
                            	<td></td>
                            	<td>등록된 문의가 없습니다.</td>
                            	<td></td>
                            	<td></td>
                            	<td></td>                                                        	
                            </tr>
                            <%
                            }
                            %>
                            </tbody>
                            
                        </table>
                        
                    </div>
                </div>


                    </div>
                </div>
            </div>
        </main>


<!-- footer -->
<%@ include file="../footer.jsp" %>