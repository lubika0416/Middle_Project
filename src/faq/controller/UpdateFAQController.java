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

@WebServlet("/admin/updateFAQ.do")
public class UpdateFAQController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String faqNo = req.getParameter("faqNo");

		//객체 생성
		IFAQService faqService = FAQServiceImpl.getInstance();
		
		//찾기 메서드 실행
		FAQVO faqv = faqService.getFAQ(faqNo);
		
		req.setAttribute("faqv", faqv);
		
		req.getRequestDispatcher
		("/WEB-INF/views/admin/AFAQ/updateFAQ.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String faqNo = req.getParameter("faqNo");
		String faqTitle = req.getParameter("faqTitle");
		String faqContent = req.getParameter("faqContent");
		
		IFAQService faqService = FAQServiceImpl.getInstance();
		
		FAQVO nv = new FAQVO(faqTitle, faqContent);
		nv.setFaqNo(Integer.parseInt(faqNo));
		
		//이렇게 해야 기존에 있는번호로 세팅될듯??
		//nv.setfaqNo(nv.getfaqNo());
		
		int cnt = faqService.modifyFAQ(nv);
		
		req.setAttribute("nv", nv);
		
		if(cnt > 0) {
			System.out.println("완료");
		}else {
			System.out.println("실패");
		}
			
		resp.sendRedirect(req.getContextPath()+"/admin/FAQBoard.do");
	}
}