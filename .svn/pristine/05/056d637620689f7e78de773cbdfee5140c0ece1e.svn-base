<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- header 정보 -->
<%@ include file="../header.jsp"%>


<!-- main -->
<%

%>
<form action="<%=request.getContextPath()%>/admin/insertFAQ.do" method="post">
	<div id="layoutSidenav_content">
		<main>
			<div class="container-fluid px-4">
				<h1 class="mt-4">고객센터</h1>
				<ol class="breadcrumb mb-4">
					<li class="breadcrumb-item active">자주 묻는 질문</li>
				</ol>


				<!-- 여기서부터 내용!!!!!!!!!!!!!!!!!! -->

				<div class="col-md" style="width: 1120px; margin: auto;">
					<div class="contact-form"
						style="display: flex; flex-direction: column; align-items: center;">
						<div class="form-group" style="margin: 4px;">
							<label class="control-label col-sm-2" for="fname">제목</label>
							<div class="col-sm-10" style="width: 1020px;">
								<input type="text" class="form-control" id="fname"
									name="faqTitle" placeholder="제목을 입력해주세요.">
							</div>
						</div>

						<div class="form-group" style="margin: 4px;">
							<label class="control-label col-sm-2" for="comment"></label>
							<div class="col-sm-10" style="width: 1020px; overflow-y: scroll;">
								<textarea class="form-control" rows="5" id="comment"
									name="faqContent" style="height: 500px;">내용</textarea>
							</div>
						</div>
						<div class="form-group" style="margin: 4px;">
							<div class="col-sm-10">
								<button type="submit"
<%-- 									onclick="location.href='<%=request.getContextPath()%>/admin/FAQBoard.do'" --%>
									class="btn btn-secondary" style="width: 100px;">등록</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
</main>


<!-- footer -->
<%@ include file="../footer.jsp"%>