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
import vo.MemberVO;
import vo.ReviewVO;

@MultipartConfig
@WebServlet("/member/review.do")
public class WriteReviewController extends HttpServlet{
	
	String clsId = "";
	
	int resNo = 0;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		clsId = req.getParameter("clsId");
		
		resNo = Integer.parseInt(req.getParameter("resNo"));
		
		req.getRequestDispatcher("/WEB-INF/views/member/writeReview.jsp").forward(req, resp);
		
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
		
		IReviewService reviewService = ReviewServiceImpl.getInstance();
		
		ReviewVO rv = new ReviewVO(rating, content, clsId, resNo);
		
		if (fv != null) rv.setFileId(fv.getFileId());
		
		System.out.println(fv);
		System.out.println(rv);
		
		int cnt = reviewService.addReview(rv);
		
		boolean result = false;
		
		if (cnt > 0) result = true;
		
		req.setAttribute("insertreviewresult", result);
		
		MemberVO mv = (MemberVO)req.getSession().getAttribute("loginInfo");
		
		req.getRequestDispatcher("reservationList.do?memId="+mv.getMemId()).forward(req, resp);
		
	}
	
}
