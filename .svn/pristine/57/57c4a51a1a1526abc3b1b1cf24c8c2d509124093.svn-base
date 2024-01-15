package faq.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.service.FileServiceImpl;
import comm.service.IFileService;
import faq.service.FAQServiceImpl;
import faq.service.IFAQService;
import vo.FAQVO;
import vo.FileVO;

@WebServlet("/admin/insertFAQ.do")
public class InsertFAQController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher
		("/WEB-INF/views/admin/AFAQ/insertAFAQ.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String faqTitle = req.getParameter("faqTitle");
		String faqContent = req.getParameter("faqContent");
	
		IFAQService FAQService = FAQServiceImpl.getInstance();
		
		FAQVO nv = new FAQVO(faqTitle, faqContent);
		
		int cnt = FAQService.addFAQ(nv);
		
		//결과값 세팅
		if (cnt > 0) req.setAttribute("result", true);
		else req.setAttribute("result", false);
		
//		req.getRequestDispatcher
//		("/WEB-INF/views/admin/AFAQ/AFAQAdmin.jsp").forward(req, resp);
		resp.sendRedirect("FAQBoard.do");
	}
}
