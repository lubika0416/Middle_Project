package member.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pqna.service.IPQNAService;
import pqna.service.PQNAServiceImpl;
import vo.MemberVO;
import vo.PCommentVO;
import vo.PQNAVO;
@WebServlet("/member/PQNAAnswerView.do")
public class MyPQNAAnswerViewController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int pqnaNo = Integer.parseInt(req.getParameter("pqnaNo"));
		
		IPQNAService pqnaService = PQNAServiceImpl.getInstance();
		
		PQNAVO pqVO = pqnaService.getPQNA(pqnaNo);
		PCommentVO pcommVO = pqnaService.getAnswer(pqnaNo);
		MemberVO mv = (MemberVO) req.getSession().getAttribute("loginInfo");
		String memId = mv.getMemId();
		List<PQNAVO> pqList = pqnaService.selectAllPQNAMember(memId);
		
		if(pqList.size() > 0) {
			for (int i = 0; i < pqList.size(); i++) {
				Date beforeDate = pqList.get(i).getPqnaRegdt();
				pqList.get(i).setDateFormat(beforeDate);
				pqVO.setDateFormat(beforeDate);
			}
		}
		req.setAttribute("pqList", pqList);
		
		req.setAttribute("pqVO", pqVO);
		req.setAttribute("pcommVO", pcommVO);
		
		req.getRequestDispatcher("/WEB-INF/views/member/PQNAViewMember.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
