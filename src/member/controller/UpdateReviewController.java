package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.service.FileServiceImpl;
import comm.service.IFileService;
import review.service.IReviewService;
import review.service.ReviewServiceImpl;
import vo.FileVO;
import vo.ReviewVO;

@MultipartConfig
@WebServlet("/member/updatereview.do")
public class UpdateReviewController extends HttpServlet{
	
	int reviewNo = 0;
	
	IReviewService reviewService = ReviewServiceImpl.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		reviewNo = Integer.parseInt(req.getParameter("reviewNo").trim());
		
		
		ReviewVO review = reviewService.getReview(reviewNo);
		
		req.setAttribute("review", review);
		
		req.getRequestDispatcher("/WEB-INF/views/member/updatereview.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String content = req.getParameter("reviewContent");
		
		int rating = Integer.parseInt(req.getParameter("rating").trim());
		
		IFileService fileService = FileServiceImpl.getInstance();
		
		FileVO fv = null;
		
		try {
			fv = fileService.saveAtchFileList(req.getParts());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ReviewVO rv = new ReviewVO(rating, content);
		rv.setReviewNo(reviewNo);
		
		if (fv == null) {
			int fileId = reviewService.getFileId(reviewNo);
			rv.setFileId(fileId);
		} else {
			rv.setFileId(fv.getFileId());
		}
		
		int cnt = reviewService.modifyReview(rv);
		
		boolean result = false;
		
		if (cnt > 0) result = true;
		
		req.setAttribute("updateReviewResult", result);
		
		req.getRequestDispatcher("myReviewList.do").forward(req, resp);
		
	}
	
}
