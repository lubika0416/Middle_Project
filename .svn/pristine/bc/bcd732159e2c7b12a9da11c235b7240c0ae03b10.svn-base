package pqna.controller;

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
import vo.PCommentVO;
import vo.PQNAVO;
import vo.ProducerVO;

@WebServlet("/producer/answerPQNA.do")
public class PQNAAnswerController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int pqnaNo = Integer.parseInt(req.getParameter("pqnaNo"));
		
		IPQNAService pqnaService = PQNAServiceImpl.getInstance();
		
		PQNAVO pqVO = pqnaService.getPQNA(pqnaNo);
		ProducerVO pv = (ProducerVO) req.getSession().getAttribute("loginInfo");
		String proId = pv.getProId();
		List<PQNAVO> pqList = pqnaService.selectAllPQNA(proId);
		
		if(pqList.size() > 0) {
			for (int i = 0; i < pqList.size(); i++) {
				Date beforeDate = pqList.get(i).getPqnaRegdt();
				pqList.get(i).setDateFormat(beforeDate);
				pqVO.setDateFormat(beforeDate);
				
			}
		}
		req.setAttribute("pqList", pqList);
		
		
		req.setAttribute("pqVO", pqVO);
		
		req.getRequestDispatcher("/WEB-INF/views/producer/PQNAAnswerProducer.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int pqnaNo = Integer.parseInt(req.getParameter("pqnaNo"));
		String pcmtContent = req.getParameter("pcmtContent");
		String proId = req.getParameter("proId");
		
		IPQNAService pqnaService = PQNAServiceImpl.getInstance();
		
		PCommentVO pcommVO = new PCommentVO(pcmtContent, pqnaNo);
		PQNAVO pqVO = pqnaService.getPQNA(pqnaNo);
		pqVO.setPqnaStatus(1);
		pcommVO.setProId(proId);
		pqnaService.changeStatus(pqVO);
		
		int cnt = pqnaService.answerPQNA(pcommVO);
		
		req.setAttribute("pcommVO", cnt);
		
		resp.sendRedirect("pqnaBoard.do");
	}
}










