package producer.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import producer.service.FeedServiceImpl;
import producer.service.IFeedService;
import vo.ProducerVO;

@WebServlet("/producer/deletefeed.do")
public class DeleteFeedController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int feedNo = Integer.parseInt(req.getParameter("feedNo"));
		
		IFeedService feedService = FeedServiceImpl.getInstance();
		
		int cnt = feedService.deleteFeed(feedNo);
		
		if (cnt > 0) req.setAttribute("deleteResult", true);
		else req.setAttribute("deleteResult", false);
		
		ProducerVO pv = (ProducerVO)req.getSession().getAttribute("loginInfo");
		
		req.getRequestDispatcher("feed.do?proId="+pv.getProId()).forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	
}
