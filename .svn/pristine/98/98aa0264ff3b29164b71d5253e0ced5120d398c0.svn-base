package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import review.service.IReviewService;
import review.service.ReviewServiceImpl;

@WebServlet("/member/deletereview.do")
public class DeleteReviewController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int reviewNo = Integer.parseInt(req.getParameter("reviewNo").trim());
		
		IReviewService reviewService = ReviewServiceImpl.getInstance();
		
		int cnt = reviewService.removeReview(reviewNo);
		
		boolean result = false;
		
		if (cnt > 0) result = true;
		
		req.setAttribute("deleteReviewResult", result);
		
		req.getRequestDispatcher("myReviewList.do").forward(req, resp);
		
	}
	
}
