package vo;

import java.util.Date;

public class ClassesVO {
	
	private String clsId; // 클래스 아이디
	private String clsName; // 클래스 이름
	private int clsPrice; // 클래스 가격
	private String clsDesc; // 클래스 설명
	private Date clsRegDt; // 클래스등록날짜
	private int clsTime; // 클래스 소요시간
	private String proId; // 사업자 아이디 //
	private int cateNo; // 카테고리 번호 //
	private int fileId = -1; // 첨부파일 아이디 //
	private int clsMxps; // 클래스 수용인원
	
	private int reviewCnt;
	private double ratingAvg;
	






	public ClassesVO() {}
	
	
	
	public ClassesVO(String clsName, int clsPrice, String clsDesc, int clsTime, int cateNo, int clsMxps) {
		this.clsName = clsName;
		this.clsPrice = clsPrice;
		this.clsDesc = clsDesc;
		this.clsTime = clsTime;
		this.cateNo = cateNo;
		this.clsMxps = clsMxps;
	}



	public ClassesVO(String clsName, int clsPrice, String clsDesc, int clsTime, int clsMxps) {
		this.clsName = clsName;
		this.clsPrice = clsPrice;
		this.clsDesc = clsDesc;
		this.clsTime = clsTime;
		this.clsMxps = clsMxps;
	}



	public ClassesVO(String clsName, String clsDesc) {
		this.clsName = clsName;
		this.clsDesc = clsDesc;
	}


	public int getReviewCnt() {
		return reviewCnt;
	}
	
	
	
	public void setReviewCnt(int reviewCnt) {
		this.reviewCnt = reviewCnt;
	}
	
	
	
	public double getRatingAvg() {
		return ratingAvg;
	}
	
	
	
	public void setRatingAvg(double ratingAvg) {
		this.ratingAvg = ratingAvg;
	}

	public int getClsMxps() {
		return clsMxps;
	}
	public void setClsMxps(int clsMxps) {
		this.clsMxps = clsMxps;
	}
	public String getClsId() {
		return clsId;
	}
	public void setClsId(String clsId) {
		this.clsId = clsId;
	}
	public String getClsName() {
		return clsName;
	}
	public void setClsName(String clsName) {
		this.clsName = clsName;
	}
	public int getClsPrice() {
		return clsPrice;
	}
	public void setClsPrice(int clsPrice) {
		this.clsPrice = clsPrice;
	}
	public String getClsDesc() {
		return clsDesc;
	}
	public void setClsDesc(String clsDesc) {
		this.clsDesc = clsDesc;
	}
	public Date getClsRegDt() {
		return clsRegDt;
	}
	public void setClsRegDt(Date clsRegDt) {
		this.clsRegDt = clsRegDt;
	}
	public int getClsTime() {
		return clsTime;
	}
	public void setClsTime(int clsTime) {
		this.clsTime = clsTime;
	}
	public String getProId() {
		return proId;
	}
	public void setProId(String proId) {
		this.proId = proId;
	}
	public int getCateNo() {
		return cateNo;
	}
	public void setCateNo(int cateNo) {
		this.cateNo = cateNo;
	}
	public int getFileId() {
		return fileId;
	}
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}



	@Override
	public String toString() {
		return "ClassesVO [clsId=" + clsId + ", clsName=" + clsName + ", clsPrice=" + clsPrice + ", clsDesc=" + clsDesc
				+ ", clsRegDt=" + clsRegDt + ", clsTime=" + clsTime + ", proId=" + proId + ", cateNo=" + cateNo
				+ ", fileId=" + fileId + "]";
	}
	
	
	
}
