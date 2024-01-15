package vo;

public class AdminVO {
	
	private String adminId;
	
	private String adminPw;
	
	private String adminName;
	
	public AdminVO() {}
	
	public AdminVO(String adminId, String adminPw, String adminName) {
		this.adminId = adminId;
		this.adminPw = adminPw;
		this.adminName = adminName;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminPw() {
		return adminPw;
	}

	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	
	
	
}
