package producer.controller;

import java.io.IOException;

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
@WebServlet("/producer/updatefeed.do")
public class UpdateFeedController extends HttpServlet{
	
	IFeedService feedService = FeedServiceImpl.getInstance();
	
	int feedNo = 0;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		feedNo = Integer.parseInt(req.getParameter("feedNo"));
		
		
		FeedVO fdv = feedService.getFeed(feedNo);
		
		req.setAttribute("fdv", fdv);
		
		req.getRequestDispatcher("/WEB-INF/views/producer/feedUpdate.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String feedContent = req.getParameter("feedContent");
		
		IFileService fileService = FileServiceImpl.getInstance();
		
		FileVO fv = null;
		
		try {
			fv = fileService.saveAtchFileList(req.getParts());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		FeedVO fdv = new FeedVO(feedContent);
		fdv.setFeedNo(feedNo);
		
		if (fv == null) {
			int fileId = feedService.getFileId(feedNo);
			fdv.setFileId(fileId);
		} else {
			fdv.setFileId(fv.getFileId());
		}
		
		int cnt = feedService.updateFeed(fdv);
		
		if (cnt > 0) req.setAttribute("updateResult", true);
		else req.setAttribute("updateResult", false);
		
		ProducerVO pv = (ProducerVO)req.getSession().getAttribute("loginInfo");
		
		req.getRequestDispatcher("feed.do?proId="+pv.getProId()).forward(req, resp);
	}
	
}
