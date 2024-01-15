package admin.service;

import java.util.Date;
import java.util.List;

import admin.dao.AdminDaoImpl;
import admin.dao.IAdminDao;
import vo.AdminVO;
import vo.MemberVO;
import vo.PaymentVO;

public class AdminServiceImpl implements IAdminService{

	private IAdminDao adminDao;
	
	private static IAdminService adminService;
	private AdminServiceImpl() {
		adminDao = AdminDaoImpl.getInstance();
	}
	
	public static IAdminService getInstance() {
		if(adminService == null) {
			adminService = new AdminServiceImpl();
		}
		return adminService;
	}
	
	@Override
	public boolean checkAdmin(String adminId, String adminPw) {
		return adminDao.checkAdmin(adminId, adminPw);
	}
	
	@Override
	public boolean checkAdmin(String adminId) {
		return adminDao.checkAdmin(adminId);
	}

	@Override
	public AdminVO getAdmin(String adminId) {
		return adminDao.getAdmin(adminId);
	}

	/*
	 * 관리자가 회원을 추가하는 메서드
	 */
	@Override
	public int addMember(MemberVO mv) {
		return adminDao.addMember(mv);
	}

	@Override
	public int resignMember(String memId) {
		return adminDao.resignMember(memId);
	}

	@Override
	public List<PaymentVO> selectAllPayment() {
		return adminDao.selectAllPayment();
	}

	@Override
	public List<Date> selectAllVisit() {
		return adminDao.selectAllVisit();
	}


}
