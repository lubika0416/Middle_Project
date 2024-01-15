<%@page import="vo.ProducerVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
	Object vo = session.getAttribute("loginInfo");
	
	List<PQNAVO> pqList = (List<PQNAVO>) request.getAttribute("pqList");
	
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Mypage</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Bootstrap icons-->
<!-- jQuery CDN (FullCalendar은 jQuery를 필요로 합니다) -->

<!-- Core theme JS-->
	<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script
	src="https://cdn.jsdelivr.net/npm/fullcalendar@6.1.8/index.global.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/scripts.js"></script>
	
	

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
	rel="stylesheet" />
<link href="<%=request.getContextPath()%>/css/styles.css"
	rel="stylesheet" />
<link href="<%=request.getContextPath()%>/css/font.css" rel="stylesheet" />
<link href="<%=request.getContextPath()%>/css/proMypage.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" />
<style>
* {
	font-family: 'Pretendard-Regular';
}
#fc-dom-1{
	font-size: 20px;
}

.promymain {
	color: var(--CI, #00E577) !important;
}
</style>
<!-- Bootstrap core JS-->
	
</head>

<body>

<%	
	Object createclassresult = request.getAttribute("createclassresult");
	if (createclassresult != null) {
		boolean result = (boolean)createclassresult;
		if (result) {%>
			<script type="text/javascript">alert("클래스 등록이 완료되었습니다.")</script>
		<%} else {%>
			<script type="text/javascript">alert("클래스 등록을 실패했습니다.")</script>
		<%}
	}
	request.removeAttribute("createclassresult");


	if (vo != null && vo instanceof ProducerVO) {
 %>
	<!-- Header-->
	<%@include file="../common/mainheader.jsp"%>


<!-- 	<div class="container px-lg-5 mt-5 mb-3">
		<div>
			<p class="fw-bold fs-2">마이페이지</p>
			<hr />
		</div>
	</div> -->

	<%@include file="proAside.jsp"%>
	
	<script>
		
	$(function() {
		let infoJson = [];
		
		$.ajax({
			url: "http://localhost:8888/Jdus/producer/reservation.do?proId=<%=pv.getProId()%>",
			type: 'get',
			success: function(rsp){
				console.log(rsp)
				const resJson = JSON.parse(rsp.resList);
				const scdJson = JSON.parse(rsp.scdList);
				console.log(resJson);
				console.log(scdJson);
				
				for (let i = 0; i < resJson.length; i++) {
					const info = { ...resJson[i], ...scdJson[i]}
					infoJson.push(info);
				}
				console.log(infoJson);
				const groupData = {};
				infoJson.forEach( item => {
					const cssId = item.cssId;
					if (!groupData[cssId]) groupData[cssId] = [];
					groupData[cssId].push(item);
				})
				infoJson = Object.values(groupData);
				
				console.log(infoJson)
				initFullCalendar(infoJson);
			}, 
			error: function(xhr){
				console.log(xhr);
			},
			dataType: 'json'
		});
		
		function initFullCalendar(infoJson){
			const list = [];
			
			infoJson.forEach( arr => {
				const obj = {};
				obj.id = arr[0].cssId;
				obj.title = arr[0].startTime,
				obj.start = arr[0].formatDate + " " + arr[0].startTime;
				obj.end = arr[0].formatDate + " " + arr[0].endTime;
				obj.eTime = arr[0].endTime;
				obj.memName = "";
				obj.resCnt = 0;
				obj.clsName = arr[0].clsName;
				obj.maxPerson = arr[0].maxPerson;
				arr.forEach( res => {
					obj.resCnt += Number(res.resCnt);
					obj.memName += res.memName + " 외 " + (Number(res.resCnt)-1) + "명, ";
					obj.color = obj.resCnt == res.maxPerson ? "orange" : "green";
				})
				list.push(obj);
			})
			console.log(list);
			
			let calendarEl = document.querySelector("#calendar");
			let calendar = new FullCalendar.Calendar(calendarEl, {
				locale : "ko",
				initialView : "dayGridMonth",
				headerToolbar : {
					left : "prev,next",
					center : "title",
					right : "dayGridMonth,timeGridWeek,timeGridDay,listMonth",
				},
				contentHeight : 600,
				editable : true,
				events: list,
				eventClick : function(info) {
					const event = info.event;
					console.log(event);
					console.log(event.extendedProps.clsName)
					const modalBody = document.querySelector(".mtablediv");
					modalBody.innerHTML = `<table class="mtable">
						<tr>
						<th>클래스이름:</th>
						<td>` + event.extendedProps.clsName + `</td>
					</tr>
					<tr>
						<th>시간:</th>
						<td><span>` + event.title + `</span>&nbsp;~&nbsp;<span>` + event.extendedProps.eTime + `</span></td>
					</tr>
					<tr>
						<th>인원:</th>
						<td><span>`+ event.extendedProps.resCnt +`</span>&nbsp;/&nbsp;<span>`+ event.extendedProps.maxPerson +`</span></td>
					</tr>
					<tr>
						<th>예약자 이름:</th>
						<td>
							<ul class="mtableList">`+ processName(event.extendedProps.memName) +`</ul></td></tr></table>`
					$('#eventModal').modal('show');
				},
				eventRender: function (info) {
				    // event 객체에서 시작 시간 속성을 가져오지 않음
				    const event = info.event;
				    const title = event.title;

				    // 일정 타이틀을 변경 (시작 시간을 제거)
				    event.setProp('title', title);
				  },
			});
			calendar.render();
			
			function processName (names) {
				names = names.substring(0,names.length-2).split(", ");
				let result = "";
				names.forEach( name => {
					result += `<li class="list-group-item">` + name + `</li>`
				})
				return result;
			}
			
		}
				
	});
	</script>

	<!-- 사업자 마이페이지 중앙좌측 -->
<div class="mypagimargin" style="padding: 8px;">
	<div class="calbox">
		<div class="mycontenttitle">
			예약 현황
		</div>
		
		<hr class="mycontentbar2"/>
		
        <div id="calendar"></div>
    </div>


	<!-- 사업자 마이페이지 중앙우측 -->
	<div class="calbox2">
		
		<!--  style="border: 1px solid chartreuse" -->
		
		<div>
		<div class="mycontenttitle">
			<div class="mycontenttitle">1:1 문의</div>
		</div>
		<hr class="mycontentbar2"/>
		<div class="table-responsive small" style="overflow: hidden; height: 663px">
			<table class="table table-sm">
			
				<thead>
					<tr>
						<th class="tbTitle">index</th>
						<th class="tbTitle">제목</th>
						<th class="tbTitle">작성자</th>
						<th class="tbTitle">작성일</th>
						<th class="tbTitle">답변여부</th>
					</tr>
				</thead>
				<tbody>
						<%
						if (pqList != null && !pqList.isEmpty()){
							for(int i = 0; i < pqList.size(); i++){	
						%>
					<tr>
						<td><%=pqList.get(i).getPqnaNo() %></td>
						<td><a href="PQNAView.do?pqnaNo=<%=pqList.get(i).getPqnaNo()%>">
						 <%
    				String pqnatitle = pqList.get(i).getPqnaTitle();

    					
       					if (pqnatitle.length() > 11) {
            		%>
            		<script>
                		var slicedDesc = '<%= pqnatitle.substring(0, 11) %>'; // JavaScript로 문자열 자르기
               			document.write(slicedDesc + '...'); // 잘린 문자열을 출력
            		</script>
            		<%
        				} else {
            		%>
            			<%= pqnatitle %> <!-- 14글자 이하인 경우 전체 문자열 출력 -->
            		<%
        				}
              		%>
					
						
						</a></td>
						<td><%=pqList.get(i).getMemId() %></td>
						<td><%=pqList.get(i).getDateFormat()%></td>
							<%if(pqList.get(i).getPqnaStatus() == 0){%>
						<td>답변안됨</td>
							<%}else{%>
						<td style="color: var(--CI, #00E577) !important;">답변완료</td>
							<%}%>
						<%}
						}else if(pqList.size() == 0){%>
					<tr>
						<td colspan="5" style="padding: 30px; font-size: 20px;">등록된 문의가 없습니다.</td>
					<tr>
					<%}%>
				</tbody>
			</table>
		</div>
		<hr class="mycontentbar2" style="margin:0px; padding: 0px;"/>
		</div>
	</div>
</div>
	
	<div class="modal fade" id="eventModal" tabindex="-1" data-bs-backdrop="static" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title card-store" id="exampleModalLabel">예약 조회</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				</div>
	
				<!-- 여기부터 모달 내용 시작 -->
				<div class="modal-body mtablediv">
					<table class="mtable">
						<tr>
							<th>클래스이름:</th>
							<td>가나다라마바사</td>
						</tr>
						<tr>
							<th>시간:</th>
							<td><span>시작시간</span>&nbsp;~&nbsp;<span>끝날시간</span></td>
						</tr>
						<tr>
							<th>인원:</th>
							<td><span>현재인원</span>&nbsp;/&nbsp;<span>최대인원</span></td>
						</tr>
						<tr>
							<th>예약자 이름:</th>
							<td>
								<ul class="mtableList">
									<li class="list-group-item">최승철</li>
									<li class="list-group-item">윤정한</li>
									<li class="list-group-item">이지훈</li>
									<li class="list-group-item">권순영</li>
								</ul>
							</td>
						</tr>
					</table>
				</div>
				<!-- 여기까지가 모달 내용 끝 -->
				<div class="modal-footer">
					<button type="button" class="btn btn-primary"  data-bs-dismiss="modal">확인</button>
				</div>
			</div>
		</div>
	</div>
	</div>
</div>	
</div>	
</div>
</body>

	<!-- Footer-->
	<%@include file="../common/mainfooter.jsp"%>
	
<%} else {%>
	<script>
		alert("로그인이 필요한 서비스입니다.")
		location.href = "http://localhost:8888/Jdus/login.do";
	</script>
<%}%>
	
</body>
</html>