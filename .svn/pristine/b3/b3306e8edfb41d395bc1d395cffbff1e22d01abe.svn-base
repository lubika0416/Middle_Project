package report.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import report.service.IReportService;
import report.service.ReportServiceImpl;
import vo.ReportVO;

@WebServlet("/admin/reportBoard.do")
public class AdminReportBoardController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		IReportService service = ReportServiceImpl.getInstance();
		
		List<ReportVO> list = service.selectAllReport();
		
		for(ReportVO rvp : list) {
			rvp.setFormReportRegdt(rvp.getReportDate());
		}
		
		req.setAttribute("list", list);
		
		req.getRequestDispatcher("/WEB-INF/views/admin/Report/ReportBoardAdmin.jsp").forward(req, resp);
	}
}
