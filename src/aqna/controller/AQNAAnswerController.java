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

import aqna.service.AQNAServiceImpl;
import aqna.service.IAQNAService;
import notice.service.INoticeService;
import notice.service.NoticeServiceImpl;
import vo.AQNAVO;
import vo.AcommentVO;
import vo.NoticeVO;

@WebServlet("/admin/answerQNA.do")
public class AQNAAnswerController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String aqnaNo = req.getParameter("aqnaNo");
		
		IAQNAService service = AQNAServiceImpl.getInstance();
		
		AQNAVO aqvo = service.getAQNA(aqnaNo);
		
		req.setAttribute("aqvo", aqvo);
		
		req.getRequestDispatcher
		("/WEB-INF/views/admin/AQNA/AQNAAnswerAdmin.jsp").forward(req, resp);
	}
		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String aqnaNo = req.getParameter("aqnaNo");
		String acmtContent = req.getParameter("aqnaAnswer");
		
		IAQNAService service = AQNAServiceImpl.getInstance();
		
		AcommentVO acvo = new AcommentVO(acmtContent, aqnaNo);
		AQNAVO aqvo = service.getAQNA(aqnaNo);
		aqvo.setAqnaStatus("1");
		service.changeStatus(aqvo);
		
		
		int rst = service.answerAQNA(acvo);
		
		req.setAttribute("acvo", rst);
		
		resp.sendRedirect("QNABoard.do");
	}
}