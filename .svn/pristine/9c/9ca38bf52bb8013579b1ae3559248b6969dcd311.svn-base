package admin.service;

import java.util.Date;
import java.util.List;

import vo.AdminVO;
import vo.MemberVO;
import vo.PaymentVO;

public interface IAdminService {
	
	/**
	 * 관리자 로그인할 때 아이디를 확인하는 메서드
	 * @param adminId
	 * @param adminPw
	 * @return
	 */
	public boolean checkAdmin(String adminId, String adminPw);
	
	public boolean checkAdmin(String adminId);

	public AdminVO getAdmin(String adminId);
	
	
	public int addMember(MemberVO mv);

	/**
	 * 관리자가 멤버를 탈퇴시키는 메서드
	 * @param memId
	 * @return
	 */
	public int resignMember(String memId);
	
	public List<PaymentVO> selectAllPayment();

	public List<Date> selectAllVisit();
}
