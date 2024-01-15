package vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProducerVO {
	
	private String proId; // id
	 
	private String proPw; // 비밀번호
	
	private String proName; // 사업자 이름
	
	private String proEmail; // 사업자 이메일
	
	private String proTel; // 사업자 번호
	
	private String proStore; // 사업장명
	
	private String proAddr; // 사업장 주소
	
	private String proStrTel; // 사업장 번호
	
	private String proRegNo; // 사업자등록번호
	
	private Date proRegdt; // 사업자 가입일
	
	private String proDesc; // 사업장 소개
	
	private String proPro; // 사업장프로필
	
	private int fileId = -1; // 첨부파일 아이디
	
	private String formRegdt;
	
	private int clsNo;
	
	private int reviewNo;
	
	private int favNo;
	
	public ProducerVO() {}

	public ProducerVO(String proId, String proPw, String proName, String proEmail, String proTel, String proStore,
			String proAddr, String proStrTel, String proRegNo, Date proRegdt) {
		this.proId = proId;
		this.proPw = proPw;
		this.proName = proName;
		this.proEmail = proEmail;
		this.proTel = proTel;
		this.proStore = proStore;
		this.proAddr = proAddr;
		this.proStrTel = proStrTel;
		this.proRegNo = proRegNo;
		this.proRegdt = proRegdt;
	}
	

	public ProducerVO(String proId, String proPw, String proName, String proEmail, String proTel, String proStore,
			String proAddr, String proStrTel, String proRegNo, String proDesc, String proPro) {
		this.proId = proId;
		this.proPw = proPw;
		this.proName = proName;
		this.proEmail = proEmail;
		this.proTel = proTel;
		this.proStore = proStore;
		this.proAddr = proAddr;
		this.proStrTel = proStrTel;
		this.proRegNo = proRegNo;
		this.proDesc = proDesc;
		this.proPro = proPro;
	}

	public ProducerVO(String proName, String proPw, String proTel, String proStrTel, String proRegNo,
			String proEmail, String proStore, String proAddr, String proDesc, String proPro) {
		this.proName = proName;
		this.proPw = proPw;
		this.proTel = proTel;
		this.proStrTel = proStrTel;
		this.proRegNo = proRegNo;
		this.proEmail = proEmail;
		this.proStore = proStore;
		this.proAddr = proAddr;
		this.proDesc = proDesc;
		this.proPro = proPro;
	}
	
	
	public String getFormRegdt() {
		return formRegdt;
	}

	public void setFormRegdt(Date date) {
		this.formRegdt = formatDate(date);
	}

	public String getProId() {
		return proId;
	}

	public void setProId(String proId) {
		this.proId = proId;
	}

	public String getProPw() {
		return proPw;
	}

	public void setProPw(String proPw) {
		this.proPw = proPw;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getProEmail() {
		return proEmail;
	}

	public void setProEmail(String proEmail) {
		this.proEmail = proEmail;
	}

	public String getProTel() {
		return proTel;
	}

	public void setProTel(String proTel) {
		this.proTel = proTel;
	}

	public String getProStore() {
		return proStore;
	}

	public void setProStore(String proStore) {
		this.proStore = proStore;
	}

	public String getProAddr() {
		return proAddr;
	}

	public void setProAddr(String proAddr) {
		this.proAddr = proAddr;
	}

	public String getProStrTel() {
		return proStrTel;
	}

	public void setProStrTel(String proStrTel) {
		this.proStrTel = proStrTel;
	}

	public Date getProRegdt() {
		return proRegdt;
	}

	public void setProRegdt(Date proRegdt) {
		this.proRegdt = proRegdt;
	}

	public String getProRegNo() {
		return proRegNo;
	}

	public void setProRegNo(String proRegNo) {
		this.proRegNo = proRegNo;
	}

	public String getProDesc() {
		return proDesc;
	}

	public void setProDesc(String proDesc) {
		this.proDesc = proDesc;
	}

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public String getProPro() {
		return proPro;
	}

	public void setProPro(String proPro) {
		this.proPro = proPro;
	}
	
	public String formatDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		return sdf.format(date);
	}
	
	public int getClsNo() {
		return clsNo;
	}

	public void setClsNo(int clsNo) {
		this.clsNo = clsNo;
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public int getFavNo() {
		return favNo;
	}

	public void setFavNo(int favNo) {
		this.favNo = favNo;
	}

	@Override
	public String toString() {
		return "ProducerVO [proId=" + proId + ", proPw=" + proPw + ", proName=" + proName + ", proEmail=" + proEmail
				+ ", proTel=" + proTel + ", proStore=" + proStore + ", proAddr=" + proAddr + ", proStrTel=" + proStrTel
				+ ", proRegNo=" + proRegNo + ", proRegdt=" + proRegdt + ", proDesc=" + proDesc + ", proPro=" + proPro
				+ ", fileId=" + fileId + ", formRegdt=" + formRegdt + "]";
	}
	
	
	
}
