package report.service;

import java.util.List;

import vo.ReportVO;

public interface IReportService {
	/**
	 * 모든 신고를 불러오는 메서드
	 * @return 모든 신고 내역
	 */
	public List<ReportVO> selectAllReport();

	/**
	 * 번호를 통해 신고 번호를 가져오는 메서드
	 * @param reportNo 신고 번호
	 * @return 신고 정보
	 */
	public ReportVO getReport(String reportNo);

	/**
	 * 신고를 삭제하는 메서드
	 * @param reportNo
	 * @return
	 */
	public int removeReport(String reportNo);
}
