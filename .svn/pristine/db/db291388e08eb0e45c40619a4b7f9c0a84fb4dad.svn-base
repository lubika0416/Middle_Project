package review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import review.service.IReviewService;
import review.service.ReviewServiceImpl;

@WebServlet("/admin/deleteReview.do")
public class AdminReviewDeleteController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int reviewNo = Integer.parseInt(req.getParameter("reviewNo").trim());
		
		IReviewService reviewService = ReviewServiceImpl.getInstance();
		
		//삭제 메서드 실행
		int cnt = reviewService.removeReview(reviewNo);
		
		if(cnt > 0) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
		
		resp.sendRedirect(req.getContextPath()+"/admin/reviewAdmin.do");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
