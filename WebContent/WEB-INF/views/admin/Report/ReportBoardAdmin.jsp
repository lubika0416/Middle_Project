<%@page import="vo.ReportVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- header 정보 -->
<%@ include file="../header.jsp"%>


<!-- main -->
<%
	List<ReportVO> list = (List<ReportVO>)request.getAttribute("list");
%>

    <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">회원 관리</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active">신고 관리</li>
                        </ol>


                        <!-- 여기서부터 내용!!!!!!!!!!!!!!!!!! -->

                   
                        <div style="height: 1em;"></div>
                        
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>
                               신고 조회
                            </div>
                            <div class="card-body">
                                <table id="datatablesSimple">
                                    <thead>
                                        <tr>
                                            <th>No</th>
                                            <th>회원ID</th>
                                            <th>신고사유</th>
                                            <th>처리여부</th>
                                            <th>신고일</th>
                                        </tr>
                                    </thead>
                                  
                                    <tbody>
                                    <%
                                    if(list.size() > 0){
                                    for(int i = 0; i < list.size(); i++){ 
                                    %>
                                        <tr>
                                            	<td><%=list.get(i).getReportNo() %></td>
                                            	<td><%=list.get(i).getMemId()%></td>
                                            	<td><a href="<%=request.getContextPath()%>/admin/reportView.do?reportNo=<%=list.get(i).getReportNo()%>"><%=list.get(i).getReportReason() %></a></td>
                                            	<td><%=list.get(i).getReportResult() %></td>
                                            	<td><%=list.get(i).getFormReportRegdt() %></td>
                                        </tr>
                                    <%
                                    	}
                                    }else{
                                    %>
	                                    <tr>
	                                         	<td></td>
	                                         	<td></td>
	                                         	<td>신고가 없습니다.</td>
	                                         	<td></td>
	                                         	<td></td>
	                                     </tr>
                                     <%
                               	     }
                                     %>
                                        
                                     <tfoot>
                                        <tr>
                                          <th>No</th>
                                          <th>ID</th>
                                          <th>Reason</th>
                                          <th>Result</th>
                                          <th>REGDT</th>
                                        </tr>
                                    </tfoot>
                                       
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