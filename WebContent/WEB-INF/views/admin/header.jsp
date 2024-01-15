<%@page import="vo.AdminVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Dashboard - SB Admin</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
        <link href="<%=request.getContextPath() %>/css/AdminStyles.css" rel="stylesheet" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.min.js" integrity="s
		ha384-Rx+T1VzGupg4BHQYs2gCW9It+akI2MM/mndMCy36UVfodzcJcF0GGLxZIzObiEfa" crossorigin="anonymous"></script>
        <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    </head>
    <body class="sb-nav-fixed">
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <!-- Navbar Brand-->
            <a class="navbar-brand ps-3" href="<%=request.getContextPath()%>/admin/statistics.do">CLASS404+</a>
            <!-- Sidebar Toggle-->
            <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i class="fas fa-bars"></i></button>
            
            <!-- Navbar-->
            <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#!">Settings</a></li>
                        <li><a class="dropdown-item" href="#!">Activity Log</a></li>
                        <li><hr class="dropdown-divider" /></li>
                        <li><a class="dropdown-item" href="<%=request.getContextPath()%>/logout.do">Logout</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">

                            <div style="display: flex; align-items: center; justify-content: center;">
                            	<img class="profile" src="<%=request.getContextPath()%>/assets/img/circle_user_icon.png">
                            </div>
                            <div class="profiletext"><%=((AdminVO)session.getAttribute("loginInfo")).getAdminName()%></div>


<!--                             <div class="sb-sidenav-menu-heading">Core</div> -->
<%--                             <a class="nav-link" href="<%=request.getContextPath()%>/admin/main.do"> --%>
<!--                                 <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div> -->
<!--                                 Dashboard -->
<!--                             </a> -->

                            <div class="sb-sidenav-menu-heading">Menu</div>
                            <a class="nav-link collapsed" href="" data-bs-toggle="collapse" data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><img class="icon" src="<%=request.getContextPath()%>/assets/img/user_icon (1).png"></img></div>
                                회원 관리
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                   <a class="nav-link" href="memberAdmin.do">일반회원 관리</a>
                                    <a class="nav-link" href="producerAdmin.do">사업자회원 관리</a>

                                </nav>
                            </div> 
<!--                             <a class="nav-link" href="classAdmin.do"> -->
<%--                                 <div class="sb-nav-link-icon"><img class="icon" src="<%=request.getContextPath()%>/assets/img/center.png"></img></div> --%>
<!--                                 클래스 관리 -->
<!--                             </a> -->
                            <a class="nav-link" href="<%=request.getContextPath()%>/admin/reviewAdmin.do">
                                <div class="sb-nav-link-icon"><img class="icon" src="<%=request.getContextPath()%>/assets/img/review_icon.png"></img></div>
                                리뷰 관리
                            </a>
    
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages">
                                <div class="sb-nav-link-icon"><i class="fas fa-book-open"></i></div>
                                고객센터
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapsePages" aria-labelledby="headingTwo" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
                                    <a class="nav-link" href="<%=request.getContextPath()%>/admin/noticeBoard.do">공지사항</a>
                                    <a class="nav-link" href="<%=request.getContextPath()%>/admin/FAQBoard.do">자주 묻는 질문</a>
                                    <a class="nav-link" href="<%=request.getContextPath()%>/admin/QNABoard.do">1대1 문의</a>
<%--                                     <a class="nav-link" href="<%=request.getContextPath()%>/admin/reportBoard.do">신고 관리</a> --%>
                                </nav>
                            </div>
                                    
<%--                             <a class="nav-link" href="<%=request.getContextPath()%>/admin/issueCoupon.do"> --%>
<%--                                  <div class="sb-nav-link-icon"><img class="icon" src="<%=request.getContextPath() %>/assets/img/cupon.png"></img></div> --%>
<!--                                 쿠폰발급 -->
<!--                             </a> -->

<%--                             <a class="nav-link" href="<%=request.getContextPath()%>/admin/reservationBoard.do"> --%>
<%--                                 <div class="sb-nav-link-icon"><img class="icon" src="<%=request.getContextPath() %>/assets/img/reservation_document_icon.png"></img></div> --%>
<!--                                예약관리 -->
<!--                            </a> -->

                           <a class="nav-link" href="statistics.do">
                            <div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>
                           통계
                       </a>
                            
                            
                        </div>
                    </div>
                    <div class="sb-sidenav-footer">
                        <div class="small">Logged in as:</div>
                        <%=((AdminVO)session.getAttribute("loginInfo")).getAdminName()%>
                    </div>
                </n
                av>
            </div>
          
