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
import vo.MemberVO;
@WebServlet("/member/myAQNAList.do")
public class MyAQNAListController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberVO mv = (MemberVO) req.getSession().getAttribute("loginInfo");
		String memId = mv.getMemId();
		IAQNAService aqnaService = AQNAServiceImpl.getInstance();
		
		List<AQNAVO> myaqList = aqnaService.selectAllAQNAMember(memId);
		
		if(myaqList.size() > 0) {
			for (int i = 0; i < myaqList.size(); i++) {
				Date beforeDate = myaqList.get(i).getAqnaRegdt();
				myaqList.get(i).setFormAqnaRegdt(beforeDate);
				
			}
		}
		
		req.setAttribute("myaqList", myaqList);
		
		req.getRequestDispatcher("/WEB-INF/views/member/myAQNAList.jsp").forward(req,resp);
		
	}	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
