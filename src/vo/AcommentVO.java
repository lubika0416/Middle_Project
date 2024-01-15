package vo;

import java.util.Date;

public class AcommentVO {

	private String acmtNo;				//관리자 댓글 번호
	private Date acmtRegdt;				//댓글 등록 날짜
	private String acmtContent;			//댓글 내용
	private String adminId = "admin";	//관리자 아이디
	private String aqnaNo; 				//문의게시글 번호
	
	public AcommentVO() {
	}

	public AcommentVO(String acmtContent, String aqnaNo) {
		this.acmtContent = acmtContent;
		this.aqnaNo = aqnaNo;
	}

	public String getAcmtNo() {
		return acmtNo;
	}

	public void setAcmtNo(String acmtNo) {
		this.acmtNo = acmtNo;
	}

	public Date getAcmtRegdt() {
		return acmtRegdt;
	}

	public void setAcmtRegdt(Date acmtRegdt) {
		this.acmtRegdt = acmtRegdt;
	}

	public String getAcmtContent() {
		return acmtContent;
	}

	public void setAcmtContent(String acmtContent) {
		this.acmtContent = acmtContent;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAqnaNo() {
		return aqnaNo;
	}

	public void setAqnaNo(String aqnaNo) {
		this.aqnaNo = aqnaNo;
	}	
}
