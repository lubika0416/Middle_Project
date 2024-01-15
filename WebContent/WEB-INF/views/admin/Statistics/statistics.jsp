<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Date"%>
<%@ include file="../header.jsp"%>
<%@page import="vo.PaymentVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% List<PaymentVO> pList = (List<PaymentVO>)request.getAttribute("pList"); %>
<% List<String> vList = (List<String>)request.getAttribute("vList"); %>
<% List<String> cList = (List<String>)request.getAttribute("cList"); %>
<% 
Map<String, Integer> quarterVisits = (Map<String, Integer>) request.getAttribute("quarterVisits");
int FirstQuarterVisit = quarterVisits.get("FirstQuarterVisit");
int SecondQuarterVisit = quarterVisits.get("SecondQuarterVisit");
int ThirdQuarterVisit = quarterVisits.get("ThirdQuarterVisit");
int FourthQuarterVisit = quarterVisits.get("FourthQuarterVisit");
%>
<%Map<String, Integer> monthVisits = (Map<String, Integer>) request.getAttribute("monthVisits"); %>

<style>
.row {
	padding: 20px;
}

/* 방문자 수를 왼쪽에, 셀렉트를 오른쪽에 배치 */
.card-header {
	display: flex;
	justify-content: space-between;
	align-items: center;
}

/* 셀렉트 스타일 조정 */
.selector {
	order: 2; /* 셀렉트를 오른쪽으로 이동 */
}
</style>

<body>
	<div id="layoutSidenav_content" style="padding-left: 15em;">
		<main>
			<div class="container-fluid px-4">
				<h1 class="mt-4">통계</h1>
				<ol class="breadcrumb mb-4">
					<li class="breadcrumb-item active">상세 통계</li>
				</ol>
			</div>

			<!-- aside1 끝 여기서부터 내용!!!!!!!!!!!!!!!!!! -->

			<div class="row" style="width: 1670px; height: 1020px;">
				<div class="col-6">
					<div class="card mb-4" style="min-height: 100px;" >
						<div class="card-header" option="">
							<i class="fas fa-chart-area me-1"></i> 방문자 통계
							<select class="selector" id="selector1">
							<option>개월</option>
							<option>분기</option>
<!-- 							<option>년도</option> -->
							</select>
						</div>
						<div class="card-body">
							<canvas id="myChart" width="100%" height="100vh"></canvas>
						</div>
					</div>
				</div>
				<div class="col-6">
					<!-- 추가된 열 -->
					<div class="card mb-4" style="min-height: 100px;">
						<div class="card-header">
							<i class="fas fa-chart-bar me-1"></i> 매출 통계
							<select class="selector" id="selector2">
							<option>개월</option>
							<option>분기</option>
<!-- 							<option>년도</option> -->
							</select>
						</div>
						<div class="card-body">
							<canvas id="myChart2" width="100%" height="100vh"></canvas>
						</div>
					</div>
				</div>
			</div>
		</main>
	</div>


<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script>

	const ctx1 = document.querySelector('#myChart');
	const ctx2 = document.getElementById('myChart2');
	
	const vChart = new Chart(ctx1, {
		type : 'bar',
		data : {
			labels : [ '1월', '2월', '3월', '4월', '5월', '6월',
					   '7월', '8월', '9월', '10월', '11월', '12월'],
			datasets : [ {
				label : '방문자수',
				data : [ 
				  	<%=monthVisits.get("01")%>,
		        	<%=monthVisits.get("02")%>,
		        	<%=monthVisits.get("03")%>,
		        	<%=monthVisits.get("04")%>,
		        	<%=monthVisits.get("05")%>,
		        	<%=monthVisits.get("06")%>,
		        	<%=monthVisits.get("07")%>,
		        	<%=monthVisits.get("08")%>,
		        	<%=monthVisits.get("09")%>,
		        	<%=monthVisits.get("10")%>,
		        	<%=monthVisits.get("11")%>,
		        	<%=monthVisits.get("12")%>
		        	],
				borderWidth : 1
			} ]
		},
		options : {
			scales : {
				y : {
					beginAtZero : false
				}
			}
		}
	});

	<%Map<String, Long> quarterSales = new HashMap<>();
long FirstQuarterSales = 0;
long SecondQuarterSales = 0;
long ThirdQuarterSales = 0;
long FourthQuarterSales = 0;

SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
List<String> sdfPlist = new ArrayList<String>();

for (int i = 0; i < pList.size(); i++) {
	sdfPlist.add(i, sdf.format(pList.get(i).getPayDate()));
	String month = sdfPlist.get(i).substring(3, 5);

	if (month.equals("01") || month.equals("02") || month.equals("03")) {
		FirstQuarterSales += pList.get(i).getPayPrice();
	} else if (month.equals("04") || month.equals("05") || month.equals("06")) {
		SecondQuarterSales += pList.get(i).getPayPrice();
	} else if (month.equals("07") || month.equals("08") || month.equals("09")) {
		ThirdQuarterSales += pList.get(i).getPayPrice();
	} else if (month.equals("10") || month.equals("11") || month.equals("12")) {
		FourthQuarterSales += pList.get(i).getPayPrice();
	}
}

quarterSales.put("FirstQuarterSales", FirstQuarterSales);
quarterSales.put("SecondQuarterSales", SecondQuarterSales);
quarterSales.put("ThirdQuarterSales", ThirdQuarterSales);
quarterSales.put("FourthQuarterSales", FourthQuarterSales);

Map<String, Integer> monthSales = new HashMap<>();

for (int i = 0; i < pList.size(); i++) {
    String month = sdfPlist.get(i).substring(3, 5);
    
    // 해당 월에 방문자 수를 가져와서 1을 더합니다.
    // 이미 해당 월의 데이터가 있으면 기존 값을 가져와서 1을 더한 후 다시 저장합니다.
    int currentMonthSales = monthSales.getOrDefault(month, 0);
    monthSales.put(month, currentMonthSales+= pList.get(i).getPayPrice());
}
%>
	
	const sChart = new Chart(ctx2, {
		type : 'bar',
		data : {
			labels : [ '1월', '2월', '3월', '4월', '5월', '6월',
				   	   '7월', '8월', '9월', '10월', '11월', '12월' ],
			datasets : [ {
				label : '매출',
				data : [
					<%=monthSales.get("01")%>,
		        	<%=monthSales.get("02")%>,
		        	<%=monthSales.get("03")%>,
		        	<%=monthSales.get("04")%>,
		        	<%=monthSales.get("05")%>,
		        	<%=monthSales.get("06")%>,
		        	<%=monthSales.get("07")%>,
		        	<%=monthSales.get("08")%>,
		        	<%=monthSales.get("09")%>,
		        	<%=monthSales.get("10")%>,
		        	<%=monthSales.get("11")%>,
		        	<%=monthSales.get("12")%>
		        	],
	        borderWidth: 1
	      }]
	    },
	    options: {
	      scales: {
	        y: {
	          beginAtZero: false
	        }
	      }
	    }
	  });
	
	document.querySelector('#selector1').addEventListener('change', function() {
	    // 선택된 옵션 가져오기
	    var selectedOption1 = this.value;
	    console.log(selectedOption1);

	    // 차트 데이터 업데이트
	    if (selectedOption1 === '개월') {
	        // 개월에 대한 데이터 업데이트
	        vChart.data.labels = [ '1월', '2월', '3월', '4월', '5월', '6월',
	                            '7월', '8월', '9월', '10월', '11월', '12월' ];
	        vChart.data.datasets[0].data = [ 
	        	<%=monthVisits.get("01")%>,
	        	<%=monthVisits.get("02")%>,
	        	<%=monthVisits.get("03")%>,
	        	<%=monthVisits.get("04")%>,
	        	<%=monthVisits.get("05")%>,
	        	<%=monthVisits.get("06")%>,
	        	<%=monthVisits.get("07")%>,
	        	<%=monthVisits.get("08")%>,
	        	<%=monthVisits.get("09")%>,
	        	<%=monthVisits.get("10")%>,
	        	<%=monthVisits.get("11")%>,
	        	<%=monthVisits.get("12")%>
	      ];
	        
	    } else if (selectedOption1 === '분기') {
	        // 분기에 대한 데이터 업데이트
	         vChart.data.labels = [ '1분기', '2분기', '3분기', '4분기'];
	         vChart.data.datasets[0].data = [
	         <%=quarterVisits.get("FirstQuarterVisit")%>,
	         <%=quarterVisits.get("SecondQuarterVisit")%>,
	         <%=quarterVisits.get("ThirdQuarterVisit")%>,
	         <%=quarterVisits.get("FourthQuarterVisit")%>
	         ];
	    }
	    vChart.update();  // 방문자 통계 차트 업데이트

	        // 분기 데이터를 여기에 설정

// 	    } else if (selectedOption1 === '년도') {
// 	        // 년도에 대한 데이터 업데이트
// 	        // 년도 데이터를 여기에 설정

// 	    }

	    // 차트 다시 그리기
	});
	
	document.querySelector('#selector2').addEventListener('change', function() {
	    // 선택된 옵션 가져오기
	    const selectedOption2 = this.value;
	    console.log(selectedOption2);

	    // 차트 데이터 업데이트
	    if (selectedOption2 === '개월') {
	        // 개월에 대한 데이터 업데이트
	        sChart.data.labels = [ '1월', '2월', '3월', '4월', '5월', '6월',
	                            '7월', '8월', '9월', '10월', '11월', '12월' ];
	        sChart.data.datasets[0].data = [ 
	          	<%=monthSales.get("01")%>,
	        	<%=monthSales.get("02")%>,
	        	<%=monthSales.get("03")%>,
	        	<%=monthSales.get("04")%>,
	        	<%=monthSales.get("05")%>,
	        	<%=monthSales.get("06")%>,
	        	<%=monthSales.get("07")%>,
	        	<%=monthSales.get("08")%>,
	        	<%=monthSales.get("09")%>,
	        	<%=monthSales.get("10")%>,
	        	<%=monthSales.get("11")%>,
	        	<%=monthSales.get("12")%>
	        	];

	    } else if (selectedOption2 === '분기') {
	        // 분기에 대한 데이터 업데이트
	         sChart.data.labels = [ '1분기', '2분기', '3분기', '4분기'];
	         sChart.data.datasets[0].data = [ 
	        	 <%= quarterSales.get("FirstQuarterSales")%>, 
	        	 <%= quarterSales.get("SecondQuarterSales")%>, 
	        	 <%= quarterSales.get("ThirdQuarterSales")%>, 
	        	 <%= quarterSales.get("FourthQuarterSales")%>, 
	         ];
	    }
	    sChart.update(); // 매출 통계 차트 업데이트
	        // 분기 데이터를 여기에 설정

// 	    } else if (selectedOption2 === '년도') {
// 	        // 년도에 대한 데이터 업데이트
// 	        // 년도 데이터를 여기에 설정
// 	    }

	    // 차트 다시 그리기
	});
</script>
</body>


<%@ include file="../footer.jsp" %>
