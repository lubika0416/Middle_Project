package member.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.service.ClassesServiceImpl;
import classes.service.IClassesService;
import member.service.IReservationService;
import member.service.ReservationServiceImpl;
import review.service.IReviewService;
import review.service.ReviewServiceImpl;
import vo.ClassesVO;
import vo.MemberVO;
import vo.ReservationVO;
import vo.ReviewVO;
@WebServlet("/member/myReviewList.do")
public class MyClassReviewListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				MemberVO mv = (MemberVO) req.getSession().getAttribute("loginInfo");
				String memId = mv.getMemId();
				
				
				IReviewService reviewService = ReviewServiceImpl.getInstance();
				IClassesService clsService = ClassesServiceImpl.getInstance();
				
				
				List<ReviewVO> reviewList = reviewService.getMyReviewList(memId);
				if(reviewList.size() > 0) {
					for (int i = 0; i < reviewList.size(); i++) {
						ReviewVO rv = reviewList.get(i);
						Date beforeDate = rv.getReviewRegdt();
						rv.setFormDt(beforeDate);
						ClassesVO cv = clsService.getProId(rv.getClsId());
						System.out.println(cv);
						rv.setClsName(cv.getClsName());
					}
				}
				
				
				req.setAttribute("reviewList", reviewList);
				
				req.getRequestDispatcher("/WEB-INF/views/member/myReviewList.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
