package faq.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import faq.service.FAQServiceImpl;
import faq.service.IFAQService;
import notice.service.INoticeService;
import notice.service.NoticeServiceImpl;

@WebServlet("/admin/deleteFAQ.do")
public class DeleteFAQController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String faqNo = req.getParameter("faqNo");

		//객체 생성
		IFAQService faqService = FAQServiceImpl.getInstance();
		
		//삭제 메서드 실행
		int cnt = faqService.removeFAQ(faqNo);
		
		if(cnt > 0) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
		
		resp.sendRedirect(req.getContextPath()+"/admin/FAQBoard.do");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
