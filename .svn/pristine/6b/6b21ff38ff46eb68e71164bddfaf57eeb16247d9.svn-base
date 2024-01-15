package aqna.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import aqna.dao.AQNADaoImpl;
import aqna.service.AQNAServiceImpl;
import aqna.service.IAQNAService;
import notice.service.INoticeService;
import notice.service.NoticeServiceImpl;
import vo.AQNAVO;
import vo.AcommentVO;
import vo.NoticeVO;

@WebServlet("/admin/QNAView.do")
public class AQNViewController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String aqnaNo = req.getParameter("aqnaNo");
		
		IAQNAService service = AQNAServiceImpl.getInstance();

		AQNAVO aqvo = service.getAQNA(aqnaNo);
		AcommentVO acvo = service.getAnswer(aqnaNo);
		
		req.setAttribute("aqvo", aqvo);
		req.setAttribute("acvo", acvo);
		System.out.println(acvo);
		
		req.getRequestDispatcher
		("/WEB-INF/views/admin/AQNA/AQNAViewAdmin.jsp").forward(req, resp);
	}
		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}