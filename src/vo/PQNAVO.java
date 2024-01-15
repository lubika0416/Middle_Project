package vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PQNAVO {
	private int pqnaNo; // 문의 번호
	private String pqnaTitle; // 문의 제목
	private Date pqnaRegdt; // 문의 작성 날짜
	private String pqnaContent; // 문의 내용
	private String proId; // 문의받은 사업자 아이디
	private String memId; // 문의한 회원 아이디
	private int pqnaStatus; // 답변여부
	private String dateFormat;
	
	public PQNAVO() {}

	public PQNAVO(String pqnaTitle, String pqnaContent) {
		this.pqnaTitle = pqnaTitle;
		this.pqnaContent = pqnaContent;
	}

	public int getPqnaNo() {
		return pqnaNo;
	}

	public void setPqnaNo(int pqnaNo) {
		this.pqnaNo = pqnaNo;
	}

	public String getPqnaTitle() {
		return pqnaTitle;
	}

	public void setPqnaTitle(String pqnaTitle) {
		this.pqnaTitle = pqnaTitle;
	}

	public Date getPqnaRegdt() {
		return pqnaRegdt;
	}

	public void setPqnaRegdt(Date pqnaRegdt) {
		this.pqnaRegdt = pqnaRegdt;
	}

	public String getPqnaContent() {
		return pqnaContent;
	}

	public void setPqnaContent(String pqnaContent) {
		this.pqnaContent = pqnaContent;
	}

	public String getProId() {
		return proId;
	}

	public void setProId(String proId) {
		this.proId = proId;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public int getPqnaStatus() {
		return pqnaStatus;
	}

	public void setPqnaStatus(int pqnaStatus) {
		this.pqnaStatus = pqnaStatus;
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
		return "PQNAVO [pqnaNo=" + pqnaNo + ", pqnaTitle=" + pqnaTitle + ", pqnaRegdt=" + pqnaRegdt + ", pqnaContent="
				+ pqnaContent + ", proId=" + proId + ", memId=" + memId + ", pqnaStatus=" + pqnaStatus + ", dateFormat="
				+ dateFormat + "]";
	}
	
	
}
