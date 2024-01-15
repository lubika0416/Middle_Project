<%@page import="vo.NoticeVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- header 정보 -->
<%@ include file="./header.jsp"%>


<!-- main -->
<%
	NoticeVO nv = (NoticeVO) request.getAttribute("nv");
%>

<div id="layoutSidenav_content">
	<main>
		<div class="container-fluid px-4">
			<h1 class="mt-4">고객센터</h1>
			<ol class="breadcrumb mb-4">
				<li class="breadcrumb-item active">공지사항</li>
			</ol>


			<!-- 여기서부터 내용!!!!!!!!!!!!!!!!!! -->
			<form action="updateNotice.do" method="get">
			<input type="hidden" name="noticeNo" id="noticeNo" value="<%=nv.getNoticeNo()%>">
				<div class="col-md"
					style="width: 1120px; margin: auto; display: flex; align-items: center; flex-direction: column;">
					<table class="table table-striped table-bordered"
						style="width: 1020px;">
						<tr>
							<th style="width: 100px;">번호</th>
							<td><%=nv.getNoticeNo()%></td>
						</tr>
						<tr>
							<th>제목</th>
							<td><%=nv.getNoticeTitle()%></td>
						</tr>
						<tr>
							<th>작성일</th>
							<td><%=nv.getNoticeRegdt() %></td>
						</tr>
						<tr>
							<th>작성자</th>
							<td><%=nv.getAdminId() %></td>
						</tr>
						<tr>
							<th style="height: 400px; overflow-y: scroll;">내용</th>
							<td><%=nv.getNoticeContent()%></td>
						</tr>
					</table>

					<div style="margin-bottom: 40px;">
						<input type="submit" value="수정" class="btn btn-secondary" style="width: 100px;">
						<input type="button" value="삭제" class="btn btn-secondary" id="deleteNotice" style="width: 100px;">
<!-- 						<form action="deleteNotice.do" method="POST"> -->
<%-- 					    	<input type="hidden" name="noticeNo" value="<%=nv.getNoticeNo()%>"> --%>
<!-- 					    	<input type="submit" value="삭제" class="btn btn-secondary"> -->
<!-- 						</form> -->
					</div>
				</form>
			</div>
		</div>
</main>

<script>
var noticeNoValue = document.querySelector("#noticeNo").value;

document.querySelector("#deleteNotice").addEventListener('click', function() {
	location.href = "deleteNotice.do?noticeNo=" + noticeNoValue;
});
</script>

<!-- footer -->
<%@ include file="./footer.jsp"%>