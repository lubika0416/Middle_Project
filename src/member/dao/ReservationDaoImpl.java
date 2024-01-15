package member.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import util.MyBatisUtil;
import vo.ReservationVO;

public class ReservationDaoImpl implements IReservationDao{
	
	private static IReservationDao resDao;
	
	private ReservationDaoImpl() {}
	
	public static IReservationDao getInstance() {
		return resDao == null ? new ReservationDaoImpl() : resDao;
	}

	@Override
	public int insertReservation(ReservationVO rv) {
		
		SqlSession session = MyBatisUtil.getInstance();
		
		int cnt = 0;
		
		try {
			
			cnt = session.insert("res.insertReservation", rv);
			
			if (cnt > 0) session.commit();
			
		} catch (PersistenceException e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		return cnt;
	}

	@Override
	public int updateReservation(ReservationVO rv) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteReservation(int resNo) {
		SqlSession session = MyBatisUtil.getInstance();
		int cnt = 0;
		try {
			cnt = session.delete("res.deleteReservation", resNo);
			
			if(cnt > 0) session.commit();
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			session.close();
		}
		return cnt;
	}

	@Override
	public ReservationVO getReservation(int resNo) {
		
		SqlSession session = MyBatisUtil.getInstance(true);
		
		ReservationVO rv = null;
		
		try {
			rv = session.selectOne("res.getReservation",resNo);
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return rv;
	}

	@Override
	public List<ReservationVO> getCssReservations(String cssId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getReservationNo(String memId, String cssId) {
		
		SqlSession session = MyBatisUtil.getInstance(true);
		
		int resNo = 0;
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("memId", memId);
		map.put("cssId", cssId);
		
		try {
			resNo = session.selectOne("res.getReservationNo", map);
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return resNo;
	}

	@Override
	public List<ReservationVO> getResList(String proId) {
		
		List<ReservationVO> resList = null;
		
		SqlSession session = MyBatisUtil.getInstance(true);
		
		try {
			resList = session.selectList("res.getResList", proId);
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return resList;
	}

	@Override
	public List<ReservationVO> selectAllReservations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReservationVO> selectMyReservation(String memId) {
		SqlSession session = MyBatisUtil.getInstance();
		
		List<ReservationVO> reserList = null;
		
		try {
			reserList = session.selectList("res.selectMyReservation", memId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return reserList;
	}

	@Override
	public String getClassName(String clsId) {

		String clsName = null;
		
		SqlSession session = MyBatisUtil.getInstance();
		
		try {
			clsName = session.selectOne("res.getClassName", clsId);
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return clsName;
	}



}














