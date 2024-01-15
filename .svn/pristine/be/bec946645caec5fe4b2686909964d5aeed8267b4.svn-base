package vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FeedVO {
	
	private int feedNo;
	
	private Date feedRegdt;
	
	private String feedContent;
	
	private String proId;
	
	private int fileId;
	
	private String formDate;
	
	public FeedVO() {}
	
	public FeedVO(String feedContent) {
		this.feedContent = feedContent;
	}
	
	public FeedVO(String feedContent, String proId) {
		this.feedContent = feedContent;
		this.proId = proId;
	}

	public int getFeedNo() {
		return feedNo;
	}

	public void setFeedNo(int feedNo) {
		this.feedNo = feedNo;
	}

	public Date getFeedRegdt() {
		return feedRegdt;
	}

	public void setFeedRegdt(Date feedRegdt) {
		this.feedRegdt = feedRegdt;
	}

	public String getFeedContent() {
		return feedContent;
	}

	public void setFeedContent(String feedContent) {
		this.feedContent = feedContent;
	}

	public String getProId() {
		return proId;
	}

	public void setProId(String proId) {
		this.proId = proId;
	}

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	
	public String formatDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yy.MM.dd");
		return sdf.format(date);
	}

	@Override
	public String toString() {
		return "FeedVO [feedNo=" + feedNo + ", feedRegdt=" + feedRegdt + ", feedContent=" + feedContent + ", proId="
				+ proId + ", fileId=" + fileId + "]";
	}

	public String getFormDate() {
		return formDate;
	}

	public void setFormDate(Date date) {
		this.formDate = formatDate(date);
	}
	
	
	
	
}
