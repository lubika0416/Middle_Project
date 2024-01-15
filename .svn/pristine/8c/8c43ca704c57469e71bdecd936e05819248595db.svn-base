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
import vo.MemberVO;

@WebServlet("/member/AQNA.do")
public class AQNAInsertController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String memId = req.getParameter("memId");
		
		
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String aqnaTitle = req.getParameter("aqnaTitle");
		String aqnaContent = req.getParameter("aqnaContent");
		
		HttpSession session = req.getSession();
		
		MemberVO mv = (MemberVO)session.getAttribute("loginInfo");
		
		IAQNAService aqnaService = AQNAServiceImpl.getInstance();
		
		AQNAVO aqv = new AQNAVO(aqnaTitle, aqnaContent);
		
		aqv.setMemId(mv.getMemId());
		
		int cnt = aqnaService.createAQNA(aqv);
		
		req.setAttribute("aqv", cnt);
		
		req.getRequestDispatcher("/main.do").forward(req, resp);
	}
}
