package member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import comm.service.FileServiceImpl;
import comm.service.IFileService;
import member.service.IMemberService;
import member.service.MemberServiceImpl;
import vo.MemberVO;

@MultipartConfig
@WebServlet("/member/mypageupdate.do")
public class MypageUpdateController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String memId = req.getParameter("memId");
		
		IMemberService memService = MemberServiceImpl.getInstance();
		
		MemberVO mv = memService.getMember(memId);
		mv.setFormBirth(mv.getMemBirth());
		System.out.println(mv);
		
		req.setAttribute("mv", mv);
		
		req.getRequestDispatcher("/WEB-INF/views/member/mypage_update.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String memId = req.getParameter("memId");
		String memPw = req.getParameter("memPw");
		String memName = req.getParameter("memName");
		String memMail = req.getParameter("memMail");
		String memAddr = req.getParameter("memAddr");
		String memBirth = req.getParameter("memBirth");
		String memGender = req.getParameter("memGender");
		String memTel = req.getParameter("memTel");
		String memRegdt = req.getParameter("memRegdt");
		
		IMemberService memService = MemberServiceImpl.getInstance();
		MemberVO mv = new MemberVO(memId, memPw, memName, memMail, memAddr, memGender, memTel);
				

		int cnt = memService.updateMember(mv);
		
		HttpSession session = req.getSession();
		session.setAttribute("loginInfo", mv);
		
		
		resp.sendRedirect(req.getContextPath() + "/mypage.do");
		
		
	}
}

















