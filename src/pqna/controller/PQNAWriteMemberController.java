package pqna.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.service.ClassesServiceImpl;
import classes.service.IClassesService;
import pqna.service.IPQNAService;
import pqna.service.PQNAServiceImpl;
import vo.ClassesVO;
import vo.MemberVO;
import vo.PQNAVO;

@WebServlet("/PQNAWrite.do")
public class PQNAWriteMemberController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String clsId = req.getParameter("clsId");
		
		IPQNAService pqnaService = PQNAServiceImpl.getInstance();
		
		ClassesVO cv = pqnaService.getProId(clsId);
		
		
		req.setAttribute("cv", cv);
		
		req.getRequestDispatcher("/WEB-INF/views/common/classdetail.jsp").forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pqnaTitle = req.getParameter("pqnaTitle");
		String clsId = req.getParameter("clsId");
		String pqnaContent = req.getParameter("pqnaContent");
		MemberVO mv = (MemberVO) req.getSession().getAttribute("loginInfo");
		String memId = mv.getMemId();
		String proId = req.getParameter("proId");
		
		
		IPQNAService pqnaService = PQNAServiceImpl.getInstance();
		PQNAVO pqVO = new PQNAVO(pqnaTitle, pqnaContent);
		pqVO.setMemId(memId);
		pqVO.setProId(proId);
		
		int cnt = pqnaService.createPQNA(pqVO);
		boolean result = false;
		if (cnt > 0) result = true;
		
		req.setAttribute("insertpqnaresult", result);
		
		
		req.getRequestDispatcher("detailclass.do?clsId=" + clsId).forward(req, resp);
		
	}
	
}



