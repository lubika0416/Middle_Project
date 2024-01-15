package vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ReviewVO {
	private int reviewNo;
	private Date reviewRegdt;
	private int reviewRating;
	private String reviewContent;
	private int fileId = -1;
	
	private String clsId;
	private String clsName;
	

	private int resNo;
	private String formDt;
	private String writer;
	
	public ReviewVO() {}
	
	
	
	public ReviewVO(int reviewRating, String reviewContent, String clsId, int resNo) {
		this.reviewRating = reviewRating;
		this.reviewContent = reviewContent;
		this.clsId = clsId;
		this.resNo = resNo;
	}



	public ReviewVO(int reviewRating, String reviewContent) {
		this.reviewContent  = reviewContent;
		this.reviewRating = reviewRating;
	}



	public String getClsName() {
		return clsName;
	}
	
	public void setClsName(String clsName) {
		this.clsName = clsName;
	}
	
	public String getFormDt() {
		return formDt;
	}
	public void setFormDt(Date date) {
		this.formDt = formatDate(date);
	}

	public int getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}
	public Date getReviewRegdt() {
		return reviewRegdt;
	}
	public void setReviewRegdt(Date reviewRegdt) {
		this.reviewRegdt = reviewRegdt;
	}
	public int getReviewRating() {
		return reviewRating;
	}
	public void setReviewRating(int reviewRating) {
		this.reviewRating = reviewRating;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public int getFileId() {
		return fileId;
	}
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	public String getClsId() {
		return clsId;
	}
	public void setClsId(String clsId) {
		this.clsId = clsId;
	}
	public int getResNo() {
		return resNo;
	}
	public void setResNo(int resNo) {
		this.resNo = resNo;
	}
	
	public String formatDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		return sdf.format(date);
	}



	public String getWriter() {
		return writer;
	}



	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	
	
}
