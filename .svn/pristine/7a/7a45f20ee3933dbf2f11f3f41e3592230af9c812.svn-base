package admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.IMemberService;
import member.service.MemberServiceImpl;
import vo.MemberVO;

@WebServlet("/admin/memberAdmin.do")
public class MemberAdminController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		IMemberService service = MemberServiceImpl.getInstance();
		
		List<MemberVO> list = service.selectAll();
		
		for (MemberVO mv : list) {
			mv.setFormBirth(mv.getMemBirth());
		}
		
		req.setAttribute("list", list);
		
		req.getRequestDispatcher("/WEB-INF/views/admin/memberAdmin.jsp")
		.forward(req, resp);

	}
}
