package review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import review.service.IReviewService;
import review.service.ReviewServiceImpl;
import vo.ReviewVO;

@WebServlet("/admin/reviewUpdate.do")
public class AdminReviewUpdateController extends HttpServlet{
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String reviewNo = req.getParameter("reviewNo");
		int reviewRating = Integer.parseInt(req.getParameter("reviewRating"));
		String reviewContent = req.getParameter("reviewContent");
		String fileId = req.getParameter("fileId");
		
		IReviewService reviewService = ReviewServiceImpl.getInstance();
		
		ReviewVO rv = new ReviewVO(reviewRating, reviewContent);
		rv.setReviewNo(Integer.parseInt(reviewNo));
		rv.setFileId(Integer.parseInt(fileId));
		
		int cnt = reviewService.modifyReview(rv);
		
		req.setAttribute("rv", rv);
		
		if(cnt > 0) {
			System.out.println("완료");
		}else {
			System.out.println("실패");
		}
		
		resp.sendRedirect(req.getContextPath() + "/admin/reviewAdmin.do");
		
	}
}