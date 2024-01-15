package vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AQNAVO {
	private String aqnaNo; 			//문의번호
	private String aqnaTitle;		//문의제목
	private String aqnaContent;		//문의내용
	private Date aqnaRegdt;			//등록날짜
	private String memId;			//문의한 회원 아이디
	private String proId;			//문의한 사업자 회원 아이디
	private String aqnaStatus;		//문의상태
	private String formAQNARegdt;
	
	public AQNAVO() {
	}
	
	public AQNAVO(String aqnaTitle, String aqnaContent) {
		this.aqnaContent = aqnaContent;
		this.aqnaTitle = aqnaTitle;
	}
	
	public AQNAVO(String aqnaNo, String aqnaTitle, String aqnaContent, Date aqnaRegdt, String proId, String memId, String aqnaStatus) {
		this.aqnaNo = aqnaNo;
		this.aqnaTitle = aqnaTitle;
		this.aqnaContent = aqnaContent;
		this.aqnaRegdt = aqnaRegdt;
		this.memId = memId;
		this.proId = proId;
		this.aqnaStatus = aqnaStatus;
	}

	public AQNAVO(String aqnaStatus) {
		this.aqnaStatus = aqnaStatus;
	}

	public String getAqnaNo() {
		return aqnaNo;
	}

	public void setAqnaNo(String aqnaNo) {
		this.aqnaNo = aqnaNo;
	}

	public String getAqnaTitle() {
		return aqnaTitle;
	}

	public void setAqnaTitle(String aqnaTitle) {
		this.aqnaTitle = aqnaTitle;
	}

	public String getAqnaContent() {
		return aqnaContent;
	}

	public void setAqnaContent(String aqnaContent) {
		this.aqnaContent = aqnaContent;
	}

	public Date getAqnaRegdt() {
		return aqnaRegdt;
	}

	public void setAqnaRegdt(Date aqnaRegdt) {
		this.aqnaRegdt = aqnaRegdt;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getProId() {
		return proId;
	}

	public void setProId(String proId) {
		this.proId = proId;
	}

	public String getAqnaStatus() {
		return aqnaStatus;
	}

	public void setAqnaStatus(String aqnaStatus) {
		this.aqnaStatus = aqnaStatus;
	}
	
////////////////////////////////////

	public String formatDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		return sdf.format(date);
	}
	
	public String getFormAqnaRegdt() {
		return formAQNARegdt;
	}
	
	public void setFormAqnaRegdt(Date aqnaRegdt) {
		this.formAQNARegdt = formatDate(aqnaRegdt);
	}
}
