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
import vo.FAQVO;
import vo.NoticeVO;

@WebServlet("/admin/FAQ.do")
public class FAQController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String faqNo = req.getParameter("faqNo");
		
		IFAQService faqService = FAQServiceImpl.getInstance();
		
		FAQVO faqv = faqService.getFAQ(faqNo);
		
		req.setAttribute("faqv", faqv);
		
		req.getRequestDispatcher
		("/WEB-INF/views/admin/AFAQ/AFAQViewAdmin.jsp").forward(req, resp);
	}
}
