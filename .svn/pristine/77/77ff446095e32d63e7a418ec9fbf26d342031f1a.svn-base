<%@page import="vo.ReportVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- header 정보 -->
<%@ include file="../header.jsp"%>


<!-- main -->
<%
	ReportVO rpv = (ReportVO)request.getAttribute("rpv");
%>

    <div id="layoutSidenav_content">
        <main>
            <div class="container-fluid px-4">
                <h1 class="mt-4">고객센터</h1>
                <ol class="breadcrumb mb-4">
                    <li class="breadcrumb-item active">신고 관리</li>
                </ol>


                <!-- 여기서부터 내용!!!!!!!!!!!!!!!!!! -->
        		<div class="col-md" style="width:1120px; margin: auto; display: flex; align-items: center; flex-direction: column;">
                <table class="table table-striped table-bordered" style="width:1020px;">
                    <tr>
                        <th style="width:100px;">번호</th>
                        <td><%=rpv.getReportNo() %></td>
                        <th style="width:100px;">작성일</th>
                        <td><%=rpv.getReportDate() %></td>
                    </tr>
                    <tr>
                        <th>신고대상ID</th>
                        <td><%=rpv.getMemId() %></td>
                        <th>처리상태</th>
                        <td><%=rpv.getReportResult() %></td>
                    </tr>

                    <tr>
                        <th style="height:400px;">신고사유</th>
                        <td colspan='3' style="height:400px; overflow-y: scroll; "><%=rpv.getReportReason() %></td>
                    </tr>
             
                </table>
                
                <div style="margin-bottom: 40px;">
                	<button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal" style="width:100px;">
  						탈퇴
					</button>
                	<button  type="button" onclick="location.href='<%=request.getContextPath()%>/admin/reportBoard.do'" class="btn btn-secondary" style="width:100px;">보류</button>
                
                </div>
                	
                	<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  						<div class="modal-dialog">
						    <div class="modal-content">
      							<div class="modal-header">
        							<h1 class="modal-title fs-5" id="exampleModalLabel">경고</h1>
        							<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      							</div>
      							<div class="modal-body">
        							정말 탈퇴시키겠습니까?
      							</div>
      							<div class="modal-footer">
        							<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">아니오</button>
        							<input type="hidden" id="reportNo" value="<%=rpv.getReportNo()%>">
        							<button type="button" id="resignConfirm" value="<%=rpv.getMemId() %>" class="btn btn-danger">예</button>
      							</div>
    						</div>
  						</div>
					</div>
                
                
                
                
                </div>


              


                    
            </div>
        </main>

<script>
var idValue = document.querySelector("#resignConfirm").value;
var reportValue = document.querySelector("#reportNo").value;

document.querySelector("#resignConfirm").addEventListener('click', function() {
	location.href = "resignMember.do?memId=" + idValue + "&reportNo=" + reportValue;
});
</script>


<!-- footer -->
<%@ include file="../footer.jsp" %>