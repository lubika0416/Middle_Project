package member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import member.service.IReservationService;
import member.service.ReservationServiceImpl;
import vo.MemberVO;
import vo.ReservationVO;
@WebServlet("/member/cancelReservation.do")
public class CancelReservationController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int resNo = Integer.parseInt(req.getParameter("resNo"));
		IReservationService reservationService = ReservationServiceImpl.getInstance();
		MemberVO mv = (MemberVO) req.getSession().getAttribute("loginInfo");
		String memId = mv.getMemId();
		int cnt = reservationService.deleteReservation(resNo);
		
		boolean result = false;
		
		if (cnt > 0)  result = true;
		
		req.setAttribute("deleteresresult", result);
		
		req.getRequestDispatcher(req.getContextPath() + "/member/reservationList.do?memId=" + memId).forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
