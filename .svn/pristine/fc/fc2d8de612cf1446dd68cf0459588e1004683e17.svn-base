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
import vo.PQNAVO;
@WebServlet("/member/myPQNAList.do")
public class MyPQNAListController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberVO mv = (MemberVO) req.getSession().getAttribute("loginInfo");
		String memId = mv.getMemId();
		IPQNAService pqnaService = PQNAServiceImpl.getInstance();
		
		List<PQNAVO> mypqList = pqnaService.selectAllPQNAMember(memId);
		
		if(mypqList.size() > 0) {
			for (int i = 0; i < mypqList.size(); i++) {
				Date beforeDate = mypqList.get(i).getPqnaRegdt();
				mypqList.get(i).setDateFormat(beforeDate);
				
			}
		}
		
		req.setAttribute("mypqList", mypqList);
		
		req.getRequestDispatcher("/WEB-INF/views/member/myPQNAList.jsp").forward(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
