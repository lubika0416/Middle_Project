<%@page import="vo.FAQVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- header 정보 -->
<%@ include file="../header.jsp"%>


<!-- main -->
<%
	List<FAQVO> list = (List<FAQVO>)request.getAttribute("list");
%>

    <div id="layoutSidenav_content">
        <main>
            <div class="container-fluid px-4">
                <h1 class="mt-4">고객센터</h1>
                <ol class="breadcrumb mb-4">
                    <li class="breadcrumb-item active">자주 묻는 질문</li>
                </ol>


                <!-- 여기서부터 내용!!!!!!!!!!!!!!!!!! -->

           
                <div style="height: 1em;"></div>
                
                <div class="card mb-4">
                    <div class="card-header">
                        <i class="fas fa-table me-1"></i>
                        자주 묻는 질문 조회
                    </div>
                    <div class="card-body">
                        <table id="datatablesSimple">
                            <thead>
                                <tr>
                                    <th>No</th>
                                    <th>제목</th>
                                    <th>작성자</th>
                                </tr>
                            </thead>
                            <tfoot>
                                <tr>
                                  <th>No</th>
                                  <th>ID</th>
                                  <th>Writer</th>
                                </tr>
                            </tfoot>
                            
                            <tbody>
                            <%
                            if(list.size() > 0){
                            	for(int i = 0; i < list.size(); i++){
                            %>
                            <tr>
                            	<td><%=list.get(i).getFaqNo() %></td>
                          		<td><a href="FAQ.do?faqNo=<%=list.get(i).getFaqNo()%>"><%=list.get(i).getFaqTitle() %></a></td>
                            	<td><%=list.get(i).getFaqId() %></td>
                            <tr>
                            <%
                            	}
                            }else{ 	
                            %>
                            <tr>
								<td></td>
								<td>등록된 자주 묻는 질문이 없습니다.</td>
								<td></td>
							<tr>
                            <%                            
                            }
                            %>
                            </tbody>
                        </table>
                        
                        <button type="button" onclick="location.href='<%=request.getContextPath()%>/admin/insertFAQ.do'" class="btn btn-secondary" style="width:100px;">글쓰기</button>
                    </div>
                </div>


                    </div>
                </div>
            </div>
        </main>


<!-- footer -->
<%@ include file="../footer.jsp" %>