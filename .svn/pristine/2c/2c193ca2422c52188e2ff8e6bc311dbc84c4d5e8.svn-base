package notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.service.INoticeService;
import notice.service.NoticeServiceImpl;
import vo.NoticeVO;

@WebServlet("/admin/deleteNotice.do")
public class NoticeDeleteController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String noticeNo = req.getParameter("noticeNo");

		//객체 생성
		INoticeService noticeService = NoticeServiceImpl.getInstance();
		
		//삭제 메서드 실행
		int cnt = noticeService.removeNotice(noticeNo);
		
		if(cnt > 0) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
		
//		req.getRequestDispatcher("/WEB-INF/views/admin/updateNotice.jsp").forward(req, resp);
		
		resp.sendRedirect(req.getContextPath()+"/admin/noticeBoard.do");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
