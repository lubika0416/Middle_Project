package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.service.IMemberService;
import member.service.MemberServiceImpl;
import vo.MemberVO;


@WebServlet("/member/update.do")
public class UpdateController extends HttpServlet{

	IMemberService memService = MemberServiceImpl.getInstance();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/member/mypage_update.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// session 의 memId 가져오기
		HttpSession session = req.getSession();
		String memId = (String) session.getAttribute("loginCode");
		
		MemberVO mv = memService.getMember(memId);
		
		String memPw = req.getParameter("memPw");
		String memMail = req.getParameter("memMail");
		String memAddr = req.getParameter("memAddr");
		String memTel = req.getParameter("memTel");
		
		if (memPw != null) mv.setMemPw(memPw);
		if (memMail != null) mv.setMemMail(memMail);
		if (memAddr != null) mv.setMemAddr(memAddr);
		if (memTel != null) mv.setMemTel(memTel);
		
		int cnt = memService.updateMember(mv);
		
		if (cnt > 0) {
			
			req.setAttribute("result", "회원 정보 수정에 성공했습니다.");
			
			req.getRequestDispatcher("/WEB-INF/views/member/mypage.jsp").forward(req, resp);
		} else {
			
			req.setAttribute("result", "회원 정보 수정에 실패했습니다.");
			
			req.getRequestDispatcher("/WEB-INF/views/member/update.jsp").forward(req, resp);
		}
	}
	
	
}
