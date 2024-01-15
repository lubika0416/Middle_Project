package vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MemberVO {
	
	private String memId;
	
	private String memPw;
	
	private String memName;
	
	private String memMail;
	
	private String memAddr;
	
	private Date memBirth;
	
	private String memGender;
	
	private String memTel;
	
	private Date memRegdt;
	
	private String formBirth;
	
	private int resNo;
	
	private int reviewNo;
	
	private int favoriteNo;
	

	public MemberVO() {}

	public MemberVO(String memId, String memPw, String memName, String memMail, String memAddr, Date memBirth,
			String memGender, String memTel) {
		this.memId = memId;
		this.memPw = memPw;
		this.memName = memName;
		this.memMail = memMail;
		this.memAddr = memAddr;
		this.memBirth = memBirth;
		this.memGender = memGender;
		this.memTel = memTel;
	}

	public MemberVO(String memId, String memPw, String memName, String memMail, String memAddr, String memGender,
			String memTel) {
		this.memId = memId;
		this.memPw = memPw;
		this.memName = memName;
		this.memMail = memMail;
		this.memAddr = memAddr;
		this.memGender = memGender;
		this.memTel = memTel;
	}

	public String getFormBirth() {
		return formBirth;
	}
	
	public void setFormBirth(Date date) {
		this.formBirth = formatDate(date);
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemPw() {
		return memPw;
	}
	
	
	
	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemMail() {
		return memMail;
	}

	public void setMemMail(String memMail) {
		this.memMail = memMail;
	}

	public String getMemAddr() {
		return memAddr;
	}

	public void setMemAddr(String memAddr) {
		this.memAddr = memAddr;
	}

	public Date getMemBirth() {
		return memBirth;
	}

	public void setMemBirth(Date memBirth) {
		this.memBirth = memBirth;
	}

	public String getmemGender() {
		return memGender;
	}

	public void setmemGender(String memGender) {
		this.memGender = memGender;
	}

	public String getMemTel() {
		return memTel;
	}

	public void setMemTel(String memTel) {
		this.memTel = memTel;
	}

	public Date getMemRegdt() {
		return memRegdt;
	}

	public void setMemRegdt(Date memRegdt) {
		this.memRegdt = memRegdt;
	}
	
	public String formatDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		return sdf.format(date);
	}
	
	public void setFormBirth(String formBirth) {
		this.formBirth = formBirth;
	}

	public int getResNo() {
		return resNo;
	}

	public void setResNo(int resNo) {
		this.resNo = resNo;
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public int getFavoriteNo() {
		return favoriteNo;
	}

	public void setFavoriteNo(int favoriteNo) {
		this.favoriteNo = favoriteNo;
	}

	@Override
	public String toString() {
		return "MemberVO [memId=" + memId + ", memPw=" + memPw + ", memName=" + memName + ", memMail=" + memMail
				+ ", memAddr=" + memAddr + ", memBirth=" + memBirth + ", memGender=" + memGender + ", memTel=" + memTel
				+ ", memRegdt=" + memRegdt + ", formBirth=" + formBirth + ", resNo=" + resNo + ", reviewNo=" + reviewNo
				+ ", favoriteNo=" + favoriteNo + "]";
	}

	
	
	
	
	
	
}
