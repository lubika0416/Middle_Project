package producer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.service.FileServiceImpl;
import comm.service.IFileService;
import producer.service.FeedServiceImpl;
import producer.service.IFeedService;
import vo.FeedVO;
import vo.FileVO;
import vo.ProducerVO;

@MultipartConfig
@WebServlet("/producer/insertfeed.do")
public class InsertFeedController extends HttpServlet{
	
	String proId = "";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		proId = req.getParameter("proId");
		
		req.getRequestDispatcher("/WEB-INF/views/producer/feedCreate.jsp").forward(req, resp);;
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String feedContent = req.getParameter("feedContent");
		
		IFileService fileServoce = FileServiceImpl.getInstance();
		
		FileVO fv = null;
		
		try {
			fv = fileServoce.saveAtchFileList(req.getParts());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		IFeedService fdService = FeedServiceImpl.getInstance();
		
		FeedVO fdv = new FeedVO(feedContent, proId);
		
		if (fv != null) fdv.setFileId(fv.getFileId());
		
		int cnt = fdService.insertFeed(fdv);
		
		if (cnt > 0) req.setAttribute("fInsertResult", true);
		else req.setAttribute("fInsertResult", false);
		
		List<FeedVO> feedList = fdService.getFeedList(proId);
		
		// feedList 초기화
		req.getSession().setAttribute("feedList", feedList);
		
		ProducerVO pv = (ProducerVO)req.getSession().getAttribute("loginInfo");
		
		req.getRequestDispatcher("mypage.do").forward(req, resp);
		
	}
	
}
