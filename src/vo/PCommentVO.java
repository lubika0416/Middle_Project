package vo;

import java.util.Date;

public class PCommentVO {
	private int pcmtNo; // 댓글번호
	private Date pcmtRegdt; // 댓글 단 시간
	private String pcmtContent; // 댓글 내용
	private String proId; // 댓글 단 사업자 아이디
	private int pqnaNo; // 문의 번호
	
	public PCommentVO() {
	}

	public PCommentVO(String pcmtContent, int pqnaNo) {
		this.pcmtContent = pcmtContent;
		this.pqnaNo = pqnaNo;
	}

	public int getPcmtNo() {
		return pcmtNo;
	}

	public void setPcmtNo(int pcmtNo) {
		this.pcmtNo = pcmtNo;
	}

	public Date getPcmtRegdt() {
		return pcmtRegdt;
	}

	public void setPcmtRegdt(Date pcmtRegdt) {
		this.pcmtRegdt = pcmtRegdt;
	}

	public String getPcmtContent() {
		return pcmtContent;
	}

	public void setPcmtContent(String pcmtContent) {
		this.pcmtContent = pcmtContent;
	}

	public String getProId() {
		return proId;
	}

	public void setProId(String proId) {
		this.proId = proId;
	}

	public int getPqnaNo() {
		return pqnaNo;
	}

	public void setPqnaNo(int pqnaNo) {
		this.pqnaNo = pqnaNo;
	}
	
}
