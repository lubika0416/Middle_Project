package member.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aqna.service.AQNAServiceImpl;
import aqna.service.IAQNAService;
import vo.AQNAVO;
import vo.AcommentVO;
import vo.MemberVO;
@WebServlet("/member/AQNAAnswerView.do")
public class MyAQNAAnswerViewController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String aqnaNo = req.getParameter("aqnaNo");
		
		IAQNAService aqnaService = AQNAServiceImpl.getInstance();
		
		MemberVO mv = (MemberVO) req.getSession().getAttribute("loginInfo");
		String memId = mv.getMemId();
		List<AQNAVO> aqList = aqnaService.selectAllAQNAMember(memId);
		AQNAVO aqVO = aqnaService.getAQNA(aqnaNo);
		AcommentVO acvo = aqnaService.getAnswer(aqnaNo);
	
		
		if (aqList.size() > 0) {
			for (int i = 0; i < aqList.size(); i++) {
				Date beforeDate = aqList.get(i).getAqnaRegdt();
				aqList.get(i).setFormAqnaRegdt(beforeDate);
				aqVO.setFormAqnaRegdt(beforeDate);
			}
		}
		req.setAttribute("aqList", aqList);
		req.setAttribute("aqVO", aqVO);
		req.setAttribute("acvo", acvo);
		
		req.getRequestDispatcher("/WEB-INF/views/member/AQNAViewMember.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
