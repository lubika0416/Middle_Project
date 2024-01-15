package admin.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.IMemberService;
import member.service.MemberServiceImpl;
import vo.MemberVO;

@MultipartConfig
@WebServlet("/admin/memberAdminUpdate.do")
public class MemberAdminUpdateController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String memId = req.getParameter("memId");
		
		IMemberService memService = MemberServiceImpl.getInstance();
		
		MemberVO mv = memService.getMember(memId);
		
		req.setAttribute("mv", mv);
		
		req.getRequestDispatcher("/WEB-INF/views/admin/memberAdminUpdate.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//매개변수 설정
		String memId = req.getParameter("memId");
		String memPw = req.getParameter("memPw");
		String memName = req.getParameter("memName");
		String memMail = req.getParameter("memMail");
		String memAddr = req.getParameter("memAddr");
		String memGender = req.getParameter("memGender");
		String memTel = req.getParameter("memTel");
		
		
		//객체 생성
		IMemberService memService = MemberServiceImpl.getInstance();
		//MV에 값 넣어주기
		MemberVO mv = new MemberVO(memId, memPw, memName, memMail, memAddr, memGender, memTel);
				
		//업데이트 실행
		int cnt = memService.updateMember(mv);
		
		req.setAttribute("mv", mv);
			
		//결과 반영
		if(cnt > 0) {
			System.out.println("완료");
		}else {
			System.out.println("실패");
		}
		

		resp.sendRedirect(req.getContextPath()+"/admin/memberAdmin.do");
	}
}
