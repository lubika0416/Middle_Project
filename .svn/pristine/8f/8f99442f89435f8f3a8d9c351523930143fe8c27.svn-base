<%@page import="vo.ClassesVO"%>
<%@page import="vo.FileVO"%>
<%@page import="java.util.List"%>
<%@page import="vo.ProducerVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


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
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
	rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous" />
<link href="<%=request.getContextPath()%>/css/styles.css"
	rel="stylesheet" />
<link href="<%=request.getContextPath()%>/css/font.css" rel="stylesheet" />
<link href="<%=request.getContextPath()%>/css/proMypage.css"
	rel="stylesheet" />
<link href="<%=request.getContextPath()%>/css/classManagement.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" />
<!-- jQuery CDN (FullCalendar은 jQuery를 필요로 합니다) -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/fullcalendar@6.1.8/index.global.min.js"></script>
<link rel="stylesheet"
	href="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.css">


<style>
* {
	font-family: "Pretendard5";
}

#fc-dom-1 {
	font-size: 20px;
}

.promyclass {
	color: var(--CI, #00E577) !important;
}

.aaa {
	background-color: var(--CI, #00E577) !important;
	border: none !important;
	color: black !important;
}

.aaa:hover {
	background-color: black !important;
	border: none !important;
	color: var(--CI, #00E577) !important;
}

.create_class {
	background-color: black !important;
	border: none !important;
	color: var(--CI, #00E577) !important;
	width: 142px;
	height: 40px;
}

.create_class:hover {
	background-color: var(--CI, #00E577) !important;
	border: none !important;
	color: black !important;
	width: 142px;
	height: 40px;
}
</style>
</head>
<body>
	<%
	Object deleteResult = request.getAttribute("deleteResult");

	if (deleteResult != null) {
	boolean result = (boolean) deleteResult;
	if (result == true) {
	%>
	<script>alert("클래스 삭제에 성공했습니다.")</script>

	<%
		} else if (result == false) {
	%>
	<script>alert("클래스 삭제가 실패했습니다. 등록된 클래스 일정이 있는지 확인해주세요.")</script>
	<%
		}
	}
	request.removeAttribute("result");
	request.removeAttribute("deleteResult");

	List<List<FileVO>> clsFileList = (List<List<FileVO>>) session.getAttribute("clsFileList");

	Object vo = session.getAttribute("loginInfo");

	if (vo instanceof ProducerVO) {
	%>
	<!-- Header-->
	<%@include file="../common/mainheader.jsp"%>


	<%@ include file="proAside.jsp"%>

	<div class="mypagimargin" style="padding: 8px;">
		<div class="calbox3">
		<div style="display: flex; justify-content: space-between; padding-right: 42px;">
			<div class="mycontenttitle">클래스 관리</div>
			<a href="<%=request.getContextPath()%>/producer/create.do?proId=<%=pv.getProId()%>">
					<button type="button" class="btn btn-outline-primary create_class">
						+ 클래스 추가하기</button>
		</div>
			<hr class="mycontentbar2" style="width: 100%; margin-top: 0px;"/>

			<!-- 목록 시작 -->
		<div style="height: 670px; overflow-y: scroll;">	

			<%
				if (clsList != null && clsList.size() > 0) {
				for (int i = 0; i < clsList.size(); i++) {
			%>
			<div class="class_container">
				<!-- 클래스 이미지 -->
				<div class="col-4 insert_img">
					<%
						if (clsFileList != null && clsFileList.size() > i && clsFileList.get(i).size() > 0) {
					%>
					<a
						href="<%=request.getContextPath()%>/detailclass.do?clsId=<%=clsList.get(i).getClsId()%>">

						<img
						src="<%=request.getContextPath()%>/upload_images/<%=clsFileList.get(i).get(0).getFileSvNm()%>"
						alt="photo08.jpg" />
					</a>
					<%
						} else {
					%>
					<a href="#"><img
						src="<%=request.getContextPath()%>/images/photo08.jpg"
						alt="photo08.jpg" />
				</div>
				</a>
				<%
					}
				%>
			</div>
		
			<!-- 클래스 정보 -->
			<div class="col-6">
				<div class="row class_info">
					<h3 class="class_title"><%=clsList.get(i).getClsName()%></h3>
					<!-- <p class="class_detail"></p> -->
					<div class="class_detail">

						<p>
							카테고리: <span><%=((List<String>) application.getAttribute("categoryName")).get(clsList.get(i).getCateNo() - 1)%></span>
						</p>
						<p>
							소요시간: <span><%=clsList.get(i).getClsTime()%></span>분
						</p>
						<p>
							최대 수용 인원: <span id="maxPerson"><%=clsList.get(i).getClsMxps()%></span>명
						</p>
						<p>
							가격: <span><%=clsList.get(i).getClsPrice()%></span>원
						</p>
						<p id="clsId" style="display: none;"><%=clsList.get(i).getClsId()%></p>
					</div>
				</div>
			</div>

			<!-- 클래스 수정 버튼 -->
			<div style="display: flex; flex-direction: column; justify-content: space-evenly; align-items: flex-end; width: 150px; height: 160px;">
				<button type="button" class="aaa btn btn-primary"
					data-bs-toggle="offcanvas" data-bs-target="#offcanvasRight"
					aria-controls="offcanvasRight" style="width: 140px;">일정 등록</button>
				<a
					href="<%=request.getContextPath()%>/producer/updateclass.do?clsId=<%=clsList.get(i).getClsId()%>">
					<button type="button" class="aaa btn btn-primary" style="width: 140px;">클래스 수정</button>
				</a> <a
					href="<%=request.getContextPath()%>/producer/deleteclass.do?clsId=<%=clsList.get(i).getClsId()%>">
					<button type="button" class="aaa btn btn-primary" style="width: 140px;">클래스 삭제</button>
				</a>


			<!-- 일정등록창 -->

				<div class="offcanvas offcanvas-end" data-bs-backdrop="static"
					tabindex="-1" id="offcanvasRight"
					aria-labelledby="offcanvasRightLabel" style="width: 40%">
					<div class="offcanvas-header" style="background-color: #000;">
						<h2 class="offcanvas-title" id="offcanvasRightLabel" style="background-color: #000; color: #fff;"><%=clsList.get(i).getClsName()%></h3>
						<button type="button" class="btn-close"
							data-bs-dismiss="offcanvas" aria-label="Close" style="background-color: #fff;"></button>
					</div>

					<div class="offcanvas-body" style="display: flex; justify-content: space-between; margin: 24px;">
						<div id="cld">
							<form action="" method="post">
								<div class="row row-2">
									<div style="width: 100%; display: flex; justify-content: space-between; margin: 24px 0px;">
										<h4 style="width: 140px;">설정할 기간</h4>
										  <div style="width: 500px; display: flex; justify-content: space-between;">
											<input type="date" name="" id="startDate" placeholder="시작날짜"
											required style="width: 200px;"/> ~ <input type="date" name="" id="endDate"
											placeholder="종료날짜" style="width: 200px;" required />
										  
										  </div>
									</div>

									<div style="width: 100%; display: flex; justify-content: space-between; margin: 24px 0px;">
										<h4 style="width: 140px;">요일</h4>
										<div style="width: 500px; display:flex; justify-content: space-between; align-items: center;">
											<div><input type="checkbox" name="day" id="sun" value="일" style="margin-right: 10px;"/><span>일</span></div>
											<div><input type="checkbox" name="day" id="mon" value="월" style="margin-right: 10px;"/><span>월</span></div>
											<div><input type="checkbox" name="day" id="tue" value="화" style="margin-right: 10px;"/><span>화</span></div>
											<div><input type="checkbox" name="day" id="wed" value="수" style="margin-right: 10px;"/><span>수</span></div>
											<div><input type="checkbox" name="day" id="thu" value="목" style="margin-right: 10px;"/><span>목</span></div>
											<div><input type="checkbox" name="day" id="fri" value="금" style="margin-right: 10px;"/><span>금</span></div>
											<div><input type="checkbox" name="day" id="sat" value="토" style="margin-right: 10px;"/><span>토</span></div>
										</div>
									</div>

									<div style="display: flex; justify-content: space-between; margin: 24px 0px;">
										<h4 style="width: 140px;">수강시간</h4>
										<div class="dateList" style="width: 500px;">
											<div class="date" style="width: 500px; margin-bottom: 16px; display: flex; justify-content: space-between;">
												<input type="text" id="startTime" class="timepicker" style="width:200px;" required />
												~ <input type="text" id="endTime" class="timepicker" style="width:200px;" required />
												<input type="button" value="X" class="deleteDate" style="width:28px; height: 28px; background-color:black; color: #00E577; border-radius: 4px; margin-left: 8px;">
											</div>
										</div>
									</div>
									
									

									<div style="width: 100%; display: flex; justify-content:center;">
										<button type="button" onclick="add_start_date()" style="width:40px; height: 40px; background-color:black; color: #00E577; border-radius: 8px; margin-left: 16px; font-family: 'Pretendard6'; font-size: 20px;">+</button>
										<button type="button" id="sendDate" style="height: 40px; background-color:black; color: #00E577; border-radius: 8px; margin-left: 8px; font-family: 'Pretendard6'; font-size: 20px;">상세일정 등록</button>
									</div>

								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>	
			
		<!-- 목록 끝  -->
		<%
			}
		} else {
		%>
		<h3>클래스를 등록해주세요.</h3>
		<%
			}
		%>
		</div>
	</div>
	</div>
	</div>
	</div>

	<!-- Footer-->
	<%@include file="../common/mainfooter.jsp"%>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

	<script src="<%=request.getContextPath()%>/js/scripts.js"></script>
	<script>
		
	  	  $(function(){
		    $('.timepicker').timepicker({
		    timeFormat: 'h:mm p',
		    interval: 30,
		    minTime: '9',
		    defaultTime: '9',
		    dynamic: false,
		    dropdown: true,
		    scrollbar: true
		    });
		  })
		
		
		const listWrap = document.querySelector('.dateList');
		const list = document.querySelector('.date');
		
		$('#sendDate').on('click', function(){
			
			const startDay = $('#startDate').val(); // 시작날짜
			const endDay = $('#endDate').val(); // 종료날짜
			const checkedValues = []; // 체크한 요일
			$('input[type="checkbox"]').each(function(){
				if ($(this).prop('checked')) {
					checkedValues.push($(this).val())
				}
			})
			
			// 추가된 .date 클래스의 값들을 저장할 배열을 초기화합니다.
			const dateValues = [];
			// 모든 .date 요소를 선택하고 각 요소의 값을 가져옵니다.
			$('.date').each(function() {
				const startTime = $(this).find('#startTime').val();
				const endTime = $(this).find('#endTime').val();
				// 가져온 값들을 객체로 저장하거나 배열에 추가합니다.
				if (startTime != null && startTime != undefined && startTime != ""){
					dateValues.push({
						startTime: startTime,
						endTime: endTime
					});
				}
			});
			
			const maxPerson = $('#maxPerson').text();
			const clsId = $('#clsId').text();
			
			// 보내자
			$.ajax({
				url:"http://localhost:8888/Jdus/class/insertschedule.do",
				type:'post',
				data:{startDay:startDay, endDay:endDay, checkedDay:JSON.stringify(checkedValues), dateValues:JSON.stringify(dateValues), maxPerson:maxPerson, clsId:clsId},
				success: function(rsp){
					if (rsp.result) {
						alert("일정 등록이 완료되었습니다.")
					} else alert("일정 등록이 실패했습니다. 다시 입력해주세요")
				},
				error:function(xhr){
					alert(xhr);
				},
				dataType:'json'
			})
			
			
			
			$('input[type="checkbox"]').prop('checked', false);
			const addedForms = document.querySelectorAll('.date');
			for (let i = 1; i < addedForms.length; i++) {
				addedForms[i].remove();
			}
			// 모든 input 요소의 값을 초기화합니다.
			const inputElements = document.querySelectorAll('input[type="text"], input[type="date"], input[type="time"]');
			inputElements.forEach(function(inputElement) {
        inputElement.value = '';
			});
			
		})
		
		function add_start_date() {
			
			const newList = list.cloneNode(true);
			
			const inputElements = newList.querySelectorAll('input[type="text"], input[type="date"], input[type="time"]');
			inputElements.forEach(function(inputElement){
				inputElement.value = '';
			})
			
			listWrap.append(newList);
			
			let dltBtns = document.querySelectorAll('.deleteDate');
			
			dltBtns.forEach(item => {
				item.addEventListener('click', function(event){
				event.target.parentElement.remove();
			})
			$('.timepicker').timepicker({
		    timeFormat: 'h:mm p',
		    interval: 30,
		    minTime: '9',
		    defaultTime: '9',
		    dynamic: false,
		    dropdown: true,
		    scrollbar: true
		    });
		})
	}
			
	</script>


	<%
		} else {
	%>
	<script>
		alert("로그인이 필요한 서비스입니다.");
		location.href = "http://localhost:8888/Jdus/login.do";
	</script>
	<%
		}
	%>

	<script
		src="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.js"></script>
</body>
</html>

