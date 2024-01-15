package report.dao;

import java.util.List;

import vo.ReportVO;

public interface IReportDao {

	public List<ReportVO> selectAllReport();

	public ReportVO getReport(String reportNo);

	public int deleteReport(String reportNo);
}
