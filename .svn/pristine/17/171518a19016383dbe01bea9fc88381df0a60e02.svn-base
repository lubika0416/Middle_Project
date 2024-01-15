<%@page import="vo.NoticeVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- header 정보 -->
<%@ include file="./header.jsp"%>


<!-- main -->
<%
	List<NoticeVO> list = (List<NoticeVO>)request.getAttribute("list");
%>

    <div id="layoutSidenav_content">
        <main>
            <div class="container-fluid px-4">
                <h1 class="mt-4">고객센터</h1>
                <ol class="breadcrumb mb-4">
                    <li class="breadcrumb-item active">공지사항</li>
                </ol>


                <!-- 여기서부터 내용!!!!!!!!!!!!!!!!!! -->

           
                <div style="height: 1em;"></div>
                
                <div class="card mb-4">
                    <div class="card-header">
                        <i class="fas fa-table me-1"></i>
                        공지사항 조회
                    </div>
                    <div class="card-body">
                        <table id="datatablesSimple">
                            <thead>
                                <tr>
                                    <th>No</th>
                                    <th>제목</th>
                                    <th>작성일</th>
                                </tr>
                            </thead>
                            <tfoot>
                                <tr>
                                  <th>No</th>
                                  <th>ID</th>
                                  <th>Name</th>
                                </tr>
                            </tfoot>
                            
							<tbody>
							<%
							if(list.size() > 0){
								for(int i = 0; i < list.size(); i++){
							%>
							<tr>
								<td><%= list.get(i).getNoticeNo() %></td>
								<td><a href="notice.do?noticeNo=<%= list.get(i).getNoticeNo() %>"><%= list.get(i).getNoticeTitle() %></a></td>
								<td><%= list.get(i).getFormNoticeRegdt() %></td>
							<%
								}
							}else{
							%>
							<tr>
								<td>등록된 공지사항이 없습니다.</td>
							<tr>
							<%
							}
							%>
							
							</tbody>
                       	
                       	 	</table>
                       	<form action="<%=request.getContextPath()%>/admin/noticeWrite.do" method="get">
                        <button type="submit" class="btn btn-secondary" style="width:100px;">글쓰기</button>
                        </form>
                        
                    </div>
                </div>


                    </div>
                </div>
            </div>
        </main>


<!-- footer -->
<%@ include file="./footer.jsp" %>