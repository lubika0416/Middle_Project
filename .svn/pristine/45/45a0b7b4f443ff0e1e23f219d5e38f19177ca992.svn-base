package producer.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
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



@WebServlet("/producer/feed.do")
public class FeedController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String proId = req.getParameter("proId");
		
		IFeedService fdService = FeedServiceImpl.getInstance();
		
		List<FeedVO> feedList = fdService.getFeedList(proId);
		
		IFileService fileService = FileServiceImpl.getInstance();
		
		List<List<FileVO>> feedFileList = new ArrayList<List<FileVO>>();
		
		for (FeedVO fdv : feedList) {
			feedFileList.add(fileService.getFeedFileList(fdv.getFeedNo()));
		}

		
		req.getSession().setAttribute("feedList", feedList);
		req.getSession().setAttribute("feedFileList", feedFileList);
		
		req.getRequestDispatcher("/WEB-INF/views/producer/feedManagement.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
