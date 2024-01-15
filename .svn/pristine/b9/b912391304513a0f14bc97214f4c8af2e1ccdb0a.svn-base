<%@page import="vo.FAQVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- header 정보 -->
<%@ include file="../header.jsp"%>


<!-- main -->
<%
	FAQVO faqv = (FAQVO)request.getAttribute("faqv");
%>

<div id="layoutSidenav_content">
	<main>
		<div class="container-fluid px-4">
			<h1 class="mt-4">고객센터</h1>
			<ol class="breadcrumb mb-4">
				<li class="breadcrumb-item active">자주 묻는 질문</li>
			</ol>


			<!-- 여기서부터 내용!!!!!!!!!!!!!!!!!! -->
			<input type="hidden" name="faqNo" id="faqNo" value="<%=faqv.getFaqNo() %>">
			<div class="col-md"
				style="width: 1120px; margin: auto; display: flex; align-items: center; flex-direction: column;">
				<table class="table table-striped table-bordered"
					style="width: 1020px;">
					<tr>
						<th style="width: 100px;">번호</th>
						<td><%=faqv.getFaqNo() %></td>
					</tr>
					<tr>
						<th>제목</th>
						<td><%=faqv.getFaqTitle() %></td>
					</tr>
					<tr>
						<th>분류</th>
						<td><%=faqv.getFaqId() %></td>
					</tr>
					<tr>
						<th>작성자</th>
						<td>관리자</td>
					</tr>
					<tr>
						<th style="height: 400px; overflow-y: scroll;">내용</th>
						<td><%=faqv.getFaqContent() %></td>
					</tr>
				</table>

				<div style="margin-bottom: 40px;">
					<button type="button"
<%-- 						onclick="location.href='<%=request.getContextPath()%>/admin/updateFAQ.do'" --%>
						id="updateFaq" class="btn btn-secondary" style="width: 100px;">수정</button>
					<button type="button"
<%-- 						onclick="location.href='<%=request.getContextPath()%>/admin/deleteFAQ.do" --%>
						id="deleteFaq" class="btn btn-secondary" style="width: 100px;">삭제</button>
				</div>
			</div>
		</div>
	</main>

<script>
	var faqNoValue = document.querySelector("#faqNo").value;
	
	document.querySelector("#updateFaq").addEventListener('click', function() {
		location.href = "updateFAQ.do?faqNo=" + faqNoValue;
	});

	document.querySelector("#deleteFaq").addEventListener('click', function() {
		location.href = "deleteFAQ.do?faqNo=" + faqNoValue;
	});
</script>


	<!-- footer -->
	<%@ include file="../footer.jsp"%>