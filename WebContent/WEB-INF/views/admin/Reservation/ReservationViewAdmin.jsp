<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- header 정보 -->
<%@ include file="../header.jsp"%>


<!-- main -->
<%

%>

    <div id="layoutSidenav_content">
        <main>
            <div class="container-fluid px-4">
                <h1 class="mt-4">예약 관리</h1>
                <ol class="breadcrumb mb-4">
                    <li class="breadcrumb-item active">예약 상세</li>
                </ol>


                <!-- 여기서부터 내용!!!!!!!!!!!!!!!!!! -->
        <div class="card-res" style="padding:40px; width: 1420px;">
            <div class="row" style="flex-wrap: nowrap;">
                <div class="res cart" style="width:450px;">
                    <div class="title-res">
                        <div class="row">
                            <div class="col summary">
                            	<h2><b>예약 상세</b></h2>
                            </div>
                            <hr class="hr-h5" style="margin-top:5px;">
                        </div>
                    </div>    
                    <div class="row border-top-res border-bottom-res" style="flex-wrap: nowrap;">
                        <div class="row main-res align-items-center" style="flex-direction: column; flex-wrap: nowrap;">
                            <div class="col-2-res"><img class="img-fluid-res" src="<%=request.getContextPath()%>/images/빵빵.jpg"></div>
                            <div style="line-height: 15px; margin-left: 8px;">
                                <h3><b>클래스 이름</b></h5><br>
                                <div><h5><b>예약번호</b></h5>123123</div><br>
                                <div><h5><b>회원 아이디</b></h5>ody</div><br>
                                <div><h5><b>결제일</b></h5>2023.09.12</div>
                            </div>
                        </div>
                    </div>
                    
                </div>
                <div class="col summary" style="width:400px;">
                    <div><h5><b>  </b></h5></div>
                    <hr class="hr-h5" style="margin-top:51px;">
                    <div class="row" style="line-height: 50px;">
                        <div class="col-res"><h5 style="margin-bottom:-10px;"><b>예약일</b></h5>2023.09.12</div><br>
                        <div class="col-res"><h5 style="margin-bottom:-10px;"><b>예약시간</b></h5>14:00 - 15:00</div><br>
                        <div class="col-res"><h5 style="margin-bottom:-10px;"><b>인원</b></h5>5명</div><br>
                        <div class="col-res"><h5 style="margin-bottom:-10px;"><b>클래스 가격</b></h5>30000원</div><br>
                    </div>
                    <div class="row" style="border-top: 1px solid rgba(0,0,0,.1); padding: 2vh 0;">
                        <div class="col-res"><h5><b>총 결제 금액</b></h5></div>
                        <div class="col-res text-right">150000원</div>
                    </div>
                    <div>
                    	<button class="btn-res" data-bs-toggle="modal" data-bs-target="#exampleModal">수정</button>
                    	<button class="btn-res" data-bs-toggle="modal" data-bs-target="#exampleModal2">삭제</button>
                    </div>
                </div>
            </div>
            
        </div>
                
                </div>
			</div> 
              

			  <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog">
				  <div class="modal-content" style="width:1000px;">
					<div class="modal-header">
					  <h1 class="modal-title fs-5" id="exampleModalLabel">수정</h1>
					  <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
					</div>
					<div class="modal-body">

						<div class="card-res" style="padding:40px; width: 1420px;">
							<div class="row" style="flex-wrap: nowrap;">
								<div class="res cart" style="width:450px;">
									<div class="title-res">
										<div class="row">
											<div class="col summary">
												<h2><b>예약 상세</b></h2>
											</div>
											<hr class="hr-h5" style="margin-top:5px;">
										</div>
									</div>    
									<div class="row border-top-res border-bottom-res" style="flex-wrap: nowrap;">
										<div class="row main-res align-items-center" style="flex-direction: column; flex-wrap: nowrap;">
											<div class="col-2-res"><img class="img-fluid-res" src="<%=request.getContextPath()%>/images/빵빵.jpg"></div>
											<div style="line-height: 15px;">
												<h3><b>클래스 이름</b></h5><br>
												<div><h5><b>예약번호</b></h5>123123</div><br>
												<div><h5><b>회원 아이디</b></h5>ody</div><br>
												<div><h5><b>결제일</b></h5>2023.09.12</div>
											</div>
										</div>
									</div>
									
								</div>
								<div class="col summary" style="width:400px;">
									<div><h5><b>  </b></h5></div>
									<hr class="hr-h5" style="margin-top:51px;">
									<div class="row" style="line-height: 50px;">
										<div class="col-res"><h5 style="margin-bottom:-10px;"><b>예약일</b></h5>2023.09.12</div><br>
										<div class="col-res"><h5 style="margin-bottom:-10px;"><b>예약시간</b></h5>
											<div class="btn-group">
  												<button class="btn btn-secondary btn-sm dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
    												예약 시간
  												</button>
  												<ul class="dropdown-menu">
												  <li><a class="dropdown-item" href="">09:00 - 10:00</a></li>
												  <li><a class="dropdown-item" href="#">10:00 - 11:00</a></li>
												  <li><a class="dropdown-item" href="#">11:00 - 12:00</a></li>
												  <li><a class="dropdown-item" href="#">13:00 - 14:00</a></li>
												  <li><a class="dropdown-item" href="#">14:00 - 15:00</a></li>
												</ul>
											</div>
										</div><br>
										<div class="col-res"><h5 style="margin-bottom:-10px;"><b>인원</b></h5>
											<div class="btn-group">
												<button class="btn btn-secondary btn-sm dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
												  인원
												</button>
												<ul class="dropdown-menu">
													<li><a class="dropdown-item" href="#">1</a></li>
													<li><a class="dropdown-item" href="#">2</a></li>
													<li><a class="dropdown-item" href="#">3</a></li>
													<li><a class="dropdown-item" href="#">4</a></li>
													<li><a class="dropdown-item" href="#">5</a></li>
													<li><a class="dropdown-item" href="#">6</a></li>
												</ul>
										  </div>
										</div><br>
										<div class="col-res"><h5 style="margin-bottom:-10px;"><b>클래스 가격</b></h5>30000원</div><br>
									</div>
									<div class="row" style="border-top: 1px solid rgba(0,0,0,.1); padding: 2vh 0;">
										<div class="col-res"><h5><b>총 결제 금액</b></h5></div>
										<div class="col-res text-right">150000원</div>
									</div>
								</div>
							</div>
						</div>

					</div>
					<div class="modal-footer">
					  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
					  <button type="button" class="btn btn-primary">수정</button>
					</div>
				  </div>
				</div>
			  </div>

			  <div class="modal fade" id="exampleModal2" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog">
				  <div class="modal-content">
					<div class="modal-header">
					  <h1 class="modal-title fs-5" id="exampleModalLabel">삭제</h1>
					  <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
					</div>
					<div class="modal-body">
					  정말 삭제하시겠습니까?
					</div>
					<div class="modal-footer">
					  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">아니오</button>
					  <button type="button" class="btn btn-primary">예</button>
					</div>
				  </div>
				</div>
			  </div>



                    
            </div>
        </main>


<!-- footer -->
<%@ include file="../footer.jsp" %>