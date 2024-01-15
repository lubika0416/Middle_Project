<%@page import="vo.CouponVO"%>
<%@page import="java.util.Map"%>
<%@page import="vo.ClassScheduleVO"%> <%@page import="vo.FileVO"%> <%@page
import="java.util.List"%> <%@page import="vo.ClassesVO"%> <%@ page
language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>PAYMENT</title>
    <!-- Favicon-->
    <!-- <link rel="icon" type="image/x-icon" href="assets/favicon.ico" /> -->
    <!-- Bootstrap icons-->
<!--     <link
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
      rel="stylesheet"
    /> -->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
      crossorigin="anonymous"
    />
    <link href="<%=request.getContextPath() %>/css/styles.css" rel="stylesheet"/>
    <link href="<%=request.getContextPath() %>/css/font.css" rel="stylesheet" />
    <link href="<%=request.getContextPath() %>/css/classPage.css" rel="stylesheet"/>
<!--     <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css"
    /> -->

    <style>
      * {
        font-family: 'Pretendard5';
      }
      /* 선택한 날짜 버튼의 스타일링 */
      .selected-date {
        background-color: #00E577;
        color: #ffffff;
      }
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
  </head>
  <script>
  $(function(){
      $('#payment').on("click", function(){
        IMP.init("imp20445073");
        IMP.request_pay({
          pg: "kakaopay.TC0ONETIME",
          pay_method: "card",
          merchant_uid: "dmdlkpa55z22aqsz3",
          name: '원데이클래스',
          amount: 33000,
          buyer_email: "falcomm@naver.com",
          buyer_name: "임형택",
          buyer_tel: "010-9135-0378"
        }, function(rsp){
          if (rsp.success) {
        	  console.log(rsp.imp_uid, rsp.merchant_uid);
              $.ajax({
                  url:"http://localhost:8888/Jdus/payment.do",
                  type: "post",
                  data: {
                    pCnt: $('#pCnt').text(), 
                    cssId: $('#cssId').val(),
                    price: orgPrice,
                    fPrice: $('#price').text(),
                    cpNo: cpNo,
                    clsId: $('#clsId').val()
                  },
                  success: function(rsp){
                	console.log(rsp);
                    if (rsp.resResult) {
                    	alert("예약을 완료했습니다.")
                    	location.href="http://localhost:8888/Jdus/detailclass.do?clsId="+$('#clsId').val()
                    } else {
                    	alert("예약이 취소되었습니다.")
                    	location.href="http://localhost:8888/Jdus/detailclass.do?clsId="+$('#clsId').val()
                    }
                  },
                  error: function(xhr) {
                    console.log(xhr);
                  },
                  dataType: 'json'
                })
          }
          else console.log(rsp.error_code, rsp.error_msg);
        })
      })
    })
  </script>
  
  <%
  	MemberVO mv = (MemberVO)session.getAttribute("loginInfo");
  	ClassesVO cv = (ClassesVO)request.getAttribute("cv");
  	Map<String, Object> map = (Map<String, Object>)request.getAttribute("map");
  	List<CouponVO> cpList = (List<CouponVO>)request.getAttribute("cpList"); 
  	
  %>
  <body>
    <%@include file="mainheader.jsp" %>

    <div class="container wrapper">
      <div class="wrapper mx-auto resInfo">
        <div>
          <p class="resInfo_title">예약 정보</p>
          <hr class="my-4" />
        </div>

        <table class="resTable">
          <tr>
            <th>이름</th>
            <td><%=mv.getMemName()%></td>
          </tr>
          <tr>
            <th>클래스 제목</th>
            <td><%=cv.getClsName()%></td>
          </tr>

          <tr>
            <th>예약일시</th>
            <td><%=map.get("resDate")%> / <%=map.get("resTime")%></td>
          </tr>

          <tr>
            <th>예약인원</th>
            <td id="pCnt"><%=map.get("pCnt")%></td>
          </tr>
        </table>
        <hr class="my-5" />

        <p class="coupon">쿠폰</p>
        <select name="" id="couponSelect" class="form-select" style="margin-bottom: 50px">
          <option value="default">-- 선택 --</option>
          <%for(int i = 0; i < cpList.size(); i++){ %>
          <option value="<%=i%>" data-cpno="<%=cpList.get(i).getCouponNo()%>" data-disc="<%=cpList.get(i).getCouponDisc()%>">
            <%=cpList.get(i).getCouponContent() %>
          </option>
          <%} %>
        </select>

        <p class="price">최종 결제 금액</p>
        <div><span id="price"><%=map.get("resPrice")%></span>원</div>

        <hr class="my-5" />
        <input type="text" id="cssId" value="<%=map.get("cssId")%>" style="display: none;">
        
        <!-- 카카오페이 결제 버튼 -->
        <input class="btn btn-warning" type="button" id="payment" value="카카오페이로 결제하기" style="font-family: 'Pretendard7'; width: 100%; height: 50px;" >
        
        <input type="text" id="clsId" value="<%=cv.getClsId()%>" style="display: none;">
        <input type="button" class="btn btn-success" onclick="finishRes()" value="다른 결제 수단 선택" style="font-family: 'Pretendard7'; width: 100%; height: 50px;">
        <!-- <div>
          <p class="price">결제 수단 선택</p>

          <div class="form-check form-check-inline">
            <input
              class="form-check-input"
              type="radio"
              name="payment"
              id="card"
              value="card"
            />
            <label class="form-check-label" for="card">카드</label>
          </div>
          <div class="form-check form-check-inline">
            <input
              class="form-check-input"
              type="radio"
              name="payment"
              id="bank"
              value="bank"
            />
            <label class="form-check-label" for="bank">무통장입금</label>
          </div>
          <div class="form-check form-check-inline">
            <input
              class="form-check-input"
              type="radio"
              name="payment"
              id="easyPay"
              value="easyPay"
            />
            <label class="form-check-label" for="easyPay">간편결제</label>
          </div>
        </div> -->
      </div>
    </div>
    <script type="text/javascript">
      
      const orgPrice = $('#price').text();
      
      let cpNo = "";
      document.querySelector('#couponSelect').addEventListener('change', function(){
        
        const selectedValue = $(this).val();
        
        if (selectedValue == "default") {
          $('#price').text(orgPrice);
        } else {
          const selectOption = this.options[this.selectedIndex];
          cpNo = selectOption.getAttribute('data-cpno');
          const disc = selectOption.getAttribute('data-disc');
          let price = Number(orgPrice.substring(1).replace(",",""))
          price = price - (price / Number(disc));
          price = "₩" + String(price).substring(0,3) + "," + String(price).substring(3);
          $('#price').text(price)
        }
      })
      
      function finishRes() {
        $.ajax({
          url:"http://localhost:8888/Jdus/payment.do",
          type: "post",
          data: {
            pCnt: $('#pCnt').text(), 
            cssId: $('#cssId').val(),
            price: orgPrice,
            fPrice: $('#price').text(),
            cpNo: cpNo,
            clsId: $('#clsId').val()
          },
          success: function(rsp){
        	console.log(rsp);
            if (rsp.resResult) {
            	alert("예약을 완료했습니다.")
            	location.href="http://localhost:8888/Jdus/detailclass.do?clsId="+$('#clsId').val()
            } else {
            	alert("예약이 취소되었습니다.")
            	location.href="http://localhost:8888/Jdus/detailclass.do?clsId="+$('#clsId').val()
            }
          },
          error: function(xhr) {
            console.log(xhr);
          },
          dataType: 'json'
        })
        
    	}
      
      
    </script>

    <!-- Footer-->
    <%@include file="mainfooter.jsp" %> 
    <% Object obj = request.getAttribute("loginResult"); 
      	if (obj != null) { %>
    <script>
      alert("로그인이 필요한 서비스입니다.");
    </script>
    <%}%>
    <!-- Bootstrap core JS-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Core theme JS-->
    <script src="<%=request.getContextPath() %>/js/scripts.js"></script>
  </body>
</html>
