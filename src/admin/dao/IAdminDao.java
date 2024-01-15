package admin.dao;

import java.util.Date;
import java.util.List;

import vo.AdminVO;
import vo.MemberVO;
import vo.PaymentVO;

public interface IAdminDao {
	/**
	 * 해당 ID에 해당하는 관리자정보가 존재하는지 확인하는 메서드
	 * @param adminId 체크할 ID
	 * @return 해당 ID가 존재하면 true, 없으면 false 반환
	 */
	public boolean checkAdmin(String adminId, String adminPw);
	
	public boolean checkAdmin(String adminId);

	//로그인 할 때 정보 확인하는 메서드
	public AdminVO getAdmin(String adminId);

	/*
	 * 관리자가 회원을 추가하는 메서드
	 */
	public int addMember(MemberVO mv);

	/**
	 * 관리자가 회원을 탈퇴시키는 메서드
	 * @param memId
	 * @return
	 */
	public int resignMember(String memId);

	public List<PaymentVO> selectAllPayment();

	public List<Date> selectAllVisit();
}
