package vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ReservationVO {
	
	private int resNo;
	
	private int resCnt;
	
	private Date resRegdt;
	
	private String cssId;
	
	private String memId;
	
	private String dateFormat;
	
	private String memName;
	
	private String clsName;
	
	private boolean existReview;

	public ReservationVO() {}
	
	public ReservationVO(int resCnt, String cssId, String memId) {
		this.resCnt = resCnt;
		this.cssId = cssId;
		this.memId = memId;
	}
	
	public String getMemName() {
		return memName;
	}
	
	public void setMemName(String memName) {
		this.memName = memName;
	}

	public int getResNo() {
		return resNo;
	}

	public void setResNo(int resNo) {
		this.resNo = resNo;
	}

	public int getResCnt() {
		return resCnt;
	}

	public void setResCnt(int resCnt) {
		this.resCnt = resCnt;
	}

	public Date getResRegdt() {
		return resRegdt;
	}

	public void setResRegdt(Date resRegdt) {
		this.resRegdt = resRegdt;
	}

	public String getCssId() {
		return cssId;
	}

	public void setCssId(String cssId) {
		this.cssId = cssId;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(Date date) {
		this.dateFormat = formatDate(date);
	}
	public String formatDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		return sdf.format(date);
	}
	
	@Override
	public String toString() {
		return "ReservationVO [resNo=" + resNo + ", resCnt=" + resCnt + ", resRegdt=" + resRegdt + ", cssId=" + cssId
				+ ", memId=" + memId + "]";
	}

	public String getClsName() {
		return clsName;
	}

	public void setClsName(String clsName) {
		this.clsName = clsName;
	}

	public boolean isExistReview() {
		return existReview;
	}

	public void setExistReview(boolean existReview) {
		this.existReview = existReview;
	}
	
	
	
}
