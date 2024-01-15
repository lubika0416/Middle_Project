package notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.service.INoticeService;
import notice.service.NoticeServiceImpl;
import vo.NoticeVO;

@MultipartConfig
@WebServlet("/admin/updateNotice.do")
public class NoticeUpdateController extends HttpServlet{
	
	//수정하려는 공지사항의 정보를 가져오는 메서드
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String noticeNo = req.getParameter("noticeNo");
				
		INoticeService noticeService = NoticeServiceImpl.getInstance();
		
		NoticeVO nv = noticeService.getNotice(noticeNo);
		
		req.setAttribute("nv", nv);
		
		req.getRequestDispatcher
		("/WEB-INF/views/admin/noticeUpdateAdmin.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String noticeNo = req.getParameter("noticeNo");
		String noticeTitle = req.getParameter("noticeTitle");
		String noticeContent = req.getParameter("noticeContent");
		
		INoticeService noticeService = NoticeServiceImpl.getInstance();
		
		NoticeVO nv = new NoticeVO(noticeTitle, noticeContent);
		nv.setNoticeNo(Integer.parseInt(noticeNo)); 
		
		//이렇게 해야 기존에 있는번호로 세팅될듯??
		//nv.setNoticeNo(nv.getNoticeNo());
		
		int cnt = noticeService.modifyNotice(nv);
		
		req.setAttribute("nv", nv);
		
		if(cnt > 0) {
			System.out.println("완료");
		}else {
			System.out.println("실패");
		}
			
//		resp.sendRedirect(req.getContextPath()+"/admin/updateNotice.jsp");
		resp.sendRedirect(req.getContextPath()+"/admin/noticeBoard.do");
	}
}
