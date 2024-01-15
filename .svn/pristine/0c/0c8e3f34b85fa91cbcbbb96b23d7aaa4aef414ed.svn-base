package vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportVO {
	private String reportNo;
	private String reportReason;
	private String reportResult;
	private String memId;
	private Date reportDate;
	private String formReportRegdt;
	
	public ReportVO() {
		// TODO Auto-generated constructor stub
	}

	public String getReportNo() {
		return reportNo;
	}

	public void setReportNo(String reportNo) {
		this.reportNo = reportNo;
	}

	public String getReportReason() {
		return reportReason;
	}

	public void setReportReason(String reportReason) {
		this.reportReason = reportReason;
	}

	public String getReportResult() {
		return reportResult;
	}

	public void setReportResult(String reportResult) {
		this.reportResult = reportResult;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}
	
////////////////////////////////////
	
	public String formatDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		return sdf.format(date);
	}
	
	public String getFormReportRegdt() {
		return formReportRegdt;
	}
	
	public void setFormReportRegdt(Date reportDate) {
		this.formReportRegdt = formatDate(reportDate);
	}
}
