<%@page import="vo.AcommentVO"%>
<%@page import="vo.AQNAVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- header 정보 -->
<%@ include file="../header.jsp"%>


<!-- main -->
<%
AQNAVO aqvo = (AQNAVO)request.getAttribute("aqvo");
AcommentVO acvo = (AcommentVO)request.getAttribute("acvo");
%>

    <div id="layoutSidenav_content">
        <main>
            <div class="container-fluid px-4">
                <h1 class="mt-4">고객센터</h1>
                <ol class="breadcrumb mb-4">
                    <li class="breadcrumb-item active">1대1 문의</li>
                </ol>


                <!-- 여기서부터 내용!!!!!!!!!!!!!!!!!! -->
        		<div class="col-md" style="width:1120px; margin: auto; display: flex; align-items: center; flex-direction: column;">
                <table class="table table-striped table-bordered" style="width:1020px;">
                    <tr>
                        <th style="width:100px;">번호</th>
                        <td><%=aqvo.getAqnaNo() %></td>
                        <th style="width:100px;">작성일</th>
                        <td><%=aqvo.getAqnaRegdt() %></td>
                    </tr>
                    <tr>
                        <th>제목</th>
                        <td><%=aqvo.getAqnaTitle() %></td>
                        <th>작성자</th>
                        <%if(aqvo.getMemId() != null) {%>
                        <td><%=aqvo.getMemId() %>(일반회원)</td>
                        <%}else if(aqvo.getProId() != null){ %>
                        <td><%=aqvo.getProId() %>(사업자회원)</td>
                        <%} %>
                    </tr>

                    <tr>
                        <th style="height:400px;">문의내용</th>
                        <td colspan='3' style="height:400px; overflow-y: scroll; "><%=aqvo.getAqnaContent() %></td>
                    </tr>
                    
                    <tr>
                        <th style="height:200px;">답변내용</th>
						<%
						if(acvo != null){
						%>
                        <td colspan='3' style="height:200px; overflow-y: scroll; "><%=acvo.getAcmtContent() %></td>
						<%
						}else{
						%>
                        <td colspan='3' style="height:200px; overflow-y: scroll; ">아직 답변이 등록되지 않았습니다.</td>
                        <%
						}
                        %>

                    </tr>
                </table>
                
                <div style="margin-bottom: 40px;">
                
                <button  type="button" onclick="location.href='<%=request.getContextPath()%>/admin/answerQNA.do?aqnaNo=<%=aqvo.getAqnaNo() %>'" class="btn btn-secondary" style="width:100px;">답변하기</button>

                </div>
                
                </div>


              


                    
            </div>
        </main>


<!-- footer -->
<%@ include file="../footer.jsp" %>