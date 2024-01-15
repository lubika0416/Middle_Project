package report.service;

import java.util.List;

import report.dao.IReportDao;
import report.dao.ReportDaoImpl;
import vo.ReportVO;

public class ReportServiceImpl implements IReportService{
	
	//싱글톤 패턴
	private static IReportService reportService;
	
	private ReportServiceImpl() {
		reportDao = ReportDaoImpl.getInstance();
	}
	
	public static IReportService getInstance() {
		if(reportService == null) {
			reportService = new ReportServiceImpl();
		}
		return reportService;
	}
	
	//다오 객체 생성
	private IReportDao reportDao;

	@Override
	public List<ReportVO> selectAllReport() {
		return reportDao.selectAllReport();
	}

	@Override
	public ReportVO getReport(String reportNo) {
		return reportDao.getReport(reportNo);
	}

	@Override
	public int removeReport(String reportNo) {
		return reportDao.deleteReport(reportNo);
	}
}
