package notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.IMemberService;
import member.service.MemberServiceImpl;
import notice.service.INoticeService;
import notice.service.NoticeServiceImpl;
import vo.MemberVO;
import vo.NoticeVO;

//@MultipartConfig
@WebServlet("/admin/notice.do")
public class NoticeController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String noticeNo = req.getParameter("noticeNo");
		
		INoticeService noticeService = NoticeServiceImpl.getInstance();
		
		NoticeVO nv = noticeService.getNotice(noticeNo);
		
		req.setAttribute("nv", nv);
		
		req.getRequestDispatcher
		("/WEB-INF/views/admin/noticeViewAdmin.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
