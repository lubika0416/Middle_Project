package vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NoticeVO {
	
	private int noticeNo;
	
	private Date noticeRegdt;
	
	private String noticeTitle;
	
	private String noticeContent;
	
	private String adminId = "admin";
	
	private int fileId = -1;
	
	private String formNoticeRegdt;
	
	public NoticeVO() {
		// TODO Auto-generated constructor stub
	}
	

	public NoticeVO(String noticeTitle, String noticeContent) {
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
	}



	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getFormNoticeRegdt() {
		return formNoticeRegdt;
	}

	public void setFormNoticeRegdt(Date noticeRegdt) {
		this.formNoticeRegdt = formatDate(noticeRegdt);
	}
//집에 가고 싶어우어~~~~ //나도
	
	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	
	public String formatDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		return sdf.format(date);
	}


	public Date getNoticeRegdt() {
		return noticeRegdt;
	}


	public void setNoticeRegdt(Date noticeRegdt) {
		this.noticeRegdt = noticeRegdt;
	}
	
	
}
