<%@page import="vo.ReservationVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %>
<%@page import="java.util.List"%>
<%@page import="vo.ReservationVO"%>
<!-- header 정보 -->
<%@ include file="./header.jsp"%>


<!-- main -->
 <div id="layoutSidenav_content" style="padding-left: 15em;">
                <main>
                    <div class="container-fluid px-4" >
                        <h1 class="mt-4">Dashboard</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active">Dashboard</li>
                        </ol>


                        <!-- aside1 끝 여기서부터 내용!!!!!!!!!!!!!!!!!! -->

                   
                        <div class="row" style="width:1320px; height:1020px;">
                            <div class="col-xl-6" >
                                <div class="card mb-4" style="height: 47.5%;">
                                    <div class="card-header" >
                                        <i class="fas fa-chart-area me-1"></i>
                                       이번 주 방문자
                                    </div>
                                    <div class="card-body"><canvas id="myAreaChart" width="100%" height="70" ></canvas></div>
                                </div>
                                <div class="card mb-4" style="height: 47.5%;">
                                    <div class="card-header">
                                        <i class="fas fa-chart-bar me-1"></i>
                                        이번 주 매출
                                    </div>
                                    <div class="card-body"><canvas id="myBarChart" width="100%" height="70"></canvas></div>
                                </div>
                            </div>                                    
 <%
 	
 	SimpleDateFormat sd = new SimpleDateFormat("MM.dd"); 
 	Calendar cal = Calendar.getInstance();
 	List<ReservationVO> list = (List<ReservationVO>)request.getAttribute("list");
 
 %>                                                     
                            <div class="col-xl-6 col-md-6">
                            <div class="card bg-white text-black mb-4" style="height: fit-content;">    
                            
    
                                <div class="card-body">
                                    <i class="fas fa-table me-1"></i>
                                    일자별 요약
                                    <table class="table" style="font-size: 1em; margin-top: 1em;">
                                        <thead>
                                          <tr style="background-color: rgb(240, 240, 240); font-weight: bold;">
                                            <th scope="col">날짜</th>
                                            <th scope="col">예약</th>
                                            <th scope="col">방문</th>
                                            <th scope="col">가입</th>
                                          </tr>
                                        </thead>
                                        <tbody>
                                        
                                          <tr>
                                            <th scope="row">오늘</th>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                          </tr>	
                                        
                                        <%
                                        for(int i=1; i<=10; i++){
                                        	
                                        	cal.add(Calendar.DAY_OF_MONTH, -1);
                                        	
                                        %>
                                          
                                        
                                          <tr>
                                            <th scope="row"><%=sd.format(cal.getTime()) %></th>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                          </tr>
                                          
                                          <%
                                        }
                                          %>
                                  
                                          <tr>
                                            <th scope="row">일주일</th>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                          </tr>
                                          <tr>
                                            <th scope="row">한달</th>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                          </tr>
                                        </tbody>
                                    </table>


                                </div>
                            </div>    
                            </div>
                            
                        </div>
                      </div>
                      </div>
                       
                    </div>
                </main>
<%@ include file="./footer.jsp" %>