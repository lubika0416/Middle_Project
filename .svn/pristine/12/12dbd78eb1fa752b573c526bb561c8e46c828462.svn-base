package member.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.IReservationService;
import member.service.ReservationServiceImpl;
import review.service.IReviewService;
import review.service.ReviewServiceImpl;
import vo.MemberVO;
import vo.ReservationVO;

@WebServlet("/member/reservationList.do")
public class MyReservationListController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberVO mv = (MemberVO) req.getSession().getAttribute("loginInfo");
		String memId = mv.getMemId();
		
		IReservationService reserService = ReservationServiceImpl.getInstance();
		List<ReservationVO> reserList = reserService.selectMyReservation(memId);
		System.out.println(reserList);
		if (reserList.size() > 0) {
			for(int i = 0; i < reserList.size(); i++) {
				
				ReservationVO rv = reserList.get(i);
				Date beforeDate = rv.getResRegdt();
				rv.setDateFormat(beforeDate);
				IReviewService revService = ReviewServiceImpl.getInstance();
				rv.setExistReview(revService.checkReview(rv.getResNo()));
				rv.setClsName(reserService.getClassName(rv.getCssId().substring(0,8)));
				
				reserList.set(i, rv);
			}
		}
		req.setAttribute("reserList", reserList);
		
		req.getRequestDispatcher("/WEB-INF/views/member/myReservationList.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}









