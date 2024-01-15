package aqna.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import aqna.service.AQNAServiceImpl;
import aqna.service.IAQNAService;
import vo.AQNAVO;
import vo.ProducerVO;


@WebServlet("/AQNAPro.do")
public class AQNAPInsertController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String proId = req.getParameter("proId");
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String aqnaTitle = req.getParameter("aqnaTitle");
		String aqnaContent = req.getParameter("aqnaContent");
		
		HttpSession session = req.getSession();
		
		ProducerVO pv = (ProducerVO)session.getAttribute("loginInfo");
		
		IAQNAService aqnaService = AQNAServiceImpl.getInstance();
		
		AQNAVO aqv = new AQNAVO(aqnaTitle, aqnaContent);
		
		aqv.setProId(pv.getProId());
		
		int cnt = aqnaService.createProAQNA(aqv);
		
		req.setAttribute("aqv", cnt);
		
		req.getRequestDispatcher("/producer/mypage.do").forward(req, resp);
	}
}
