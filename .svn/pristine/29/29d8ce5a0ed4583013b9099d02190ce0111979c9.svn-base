package admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.AdminDaoImpl;
import admin.service.AdminServiceImpl;
import admin.service.IAdminService;
import report.service.IReportService;
import report.service.ReportServiceImpl;

@WebServlet("/admin/resignMember.do")
public class MemberAdminDeleteController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String memId = req.getParameter("memId");
		String reportNo = req.getParameter("reportNo");
		
		IAdminService aservice = AdminServiceImpl.getInstance();
		IReportService rservice = ReportServiceImpl.getInstance();
		
		int rcnt = rservice.removeReport(reportNo);
		int acnt = aservice.resignMember(memId);
		
//		req.getRequestDispatcher("/WEB-INF/views/admin/Report/ReportBoardAdmin.jsp").forward(req, resp);
		resp.sendRedirect(req.getContextPath()+"/admin/reportBoard.do");
	}
}
