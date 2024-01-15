package report.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import report.service.IReportService;
import report.service.ReportServiceImpl;
import vo.ReportVO;

@WebServlet("/admin/reportView.do")
public class AdminReportViewController extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String reportNo = req.getParameter("reportNo");
		
		IReportService service = ReportServiceImpl.getInstance();
		
		ReportVO rpv = service.getReport(reportNo);
		System.out.println(rpv);
		req.setAttribute("rpv", rpv);
				
		req.getRequestDispatcher("/WEB-INF/views/admin/Report/ReportViewAdmin.jsp").forward(req, resp);
	}
}
