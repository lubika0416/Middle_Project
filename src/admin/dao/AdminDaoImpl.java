package admin.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import util.MyBatisUtil;
import vo.AdminVO;
import vo.MemberVO;
import vo.PaymentVO;

public class AdminDaoImpl<E, O> implements IAdminDao{

	//싱글턴 생성
	private static IAdminDao adminDao;
	
	private AdminDaoImpl() {
		
	}
	
	public static IAdminDao getInstance() {
		if(adminDao == null) {
			adminDao = new AdminDaoImpl();
		}
		return adminDao;
	}
	
	//해당 ID에 해당하는 관리자정보가 존재하는지 확인하는 메서드
	@Override
	public boolean checkAdmin(String adminId, String adminPw) {
		//마이바티스 세션 생성
		SqlSession session = MyBatisUtil.getInstance();
		
		//리턴해 변수 isExist 초기화
		boolean isExist = false;
		
		//계정을 담는 맵
		Map<String, String> adminMap = new HashMap<String, String>();
		
		try {
			//ID와 PW 정보 삽입
			adminMap.put("adminId", adminId);
			adminMap.put("adminPw", adminPw);
			System.out.println(isExist);
			//
			int cnt = session.selectOne("admin.loginAdmin", adminMap);
			
			if(cnt > 0) {
				isExist = true;
			}
			System.out.println(isExist);
			
		}catch(PersistenceException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return isExist;
	}
	
	@Override
	public boolean checkAdmin(String adminId) {
		boolean isExist = false;
		SqlSession session = MyBatisUtil.getInstance(true);

		try {
			int cnt = session.selectOne("admin.checkAdmin", adminId);
			if (cnt > 0) {
				isExist = true;
			}
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return isExist;
	}
	

	//로그인 할 때 정보 확인하는 메서드
	@Override
	public AdminVO getAdmin(String adminId) {
		//마이바티스 세션 생성
		SqlSession session = MyBatisUtil.getInstance();
		
		AdminVO av = null;
		
		try {
			
			av = session.selectOne("admin.getAdmin", adminId);
			
			if (av != null) session.commit();
			
		} catch (PersistenceException e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		return av;
	}

	@Override
	public int addMember(MemberVO mv) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int resignMember(String memId) {
		
		SqlSession session = MyBatisUtil.getInstance();
		
		int cnt = 0;
		
		try {
			
			cnt = session.delete("admin.resignMember", memId);
			
		}catch(PersistenceException e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			session.close();
		}

		return 0;
	}
	
	public List<PaymentVO> selectAllPayment() {
		
		SqlSession session = MyBatisUtil.getInstance();
		
		List<PaymentVO> list = null;
		
		try {
			
			list = session.selectList("pay.selectAllPay");
		}catch(PersistenceException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
	return list;	
	}
	
	public List<Date> selectAllVisit(){
		
		SqlSession session = MyBatisUtil.getInstance();
		
		List<Date> visitList = null;
		
		try {
			
			visitList = session.selectList("visit.selectAllVisit");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return visitList;
	}
}
