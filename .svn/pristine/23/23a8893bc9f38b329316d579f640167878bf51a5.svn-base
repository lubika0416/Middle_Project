package aqna.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import util.MyBatisUtil;
import vo.AQNAVO;
import vo.AcommentVO;

public class AQNADaoImpl implements IAQNADao{
	
	private static IAQNADao aqnaDao;
	
	public AQNADaoImpl() {
	}
	
	public static IAQNADao getInstance() {
		if(aqnaDao == null) {
			aqnaDao = new AQNADaoImpl();
		}
		return aqnaDao;
	}

	@Override
	public List<AQNAVO> selectAllQna() {

		SqlSession session = MyBatisUtil.getInstance();
		
		List<AQNAVO> list = null;
		
		try {
			
			list = session.selectList("aqna.selectAllQna");

		}catch(PersistenceException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return list;
	}

	@Override
	public AQNAVO getAQNA(String aqnaNo) {

		SqlSession session = MyBatisUtil.getInstance();
		
		AQNAVO aqvo = null;
		
		try {
			
			aqvo = session.selectOne("aqna.getQna", aqnaNo);
			
		}catch(PersistenceException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return aqvo;
	}

	@Override
	public int answerAQNA(AcommentVO acvo) {
		
		SqlSession session = MyBatisUtil.getInstance();
		
		int rst = 0;
		
		try {
			
			rst = session.insert("acmt.answerAQNA", acvo);
			
			if(rst > 0 ) session.commit();
			
		}catch(PersistenceException e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			session.close();
		}
		return rst;
	}

	@Override
	public AcommentVO getAnswer(String aqnaNo) {
		
		SqlSession session = MyBatisUtil.getInstance();
		
		AcommentVO acvo = null;
		
		try {
			
			acvo = session.selectOne("acmt.getAnswer", aqnaNo);
			
		}catch(PersistenceException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return acvo;
	}

	@Override
	public void changeStatus(AQNAVO aqvo) {
		
		SqlSession session = MyBatisUtil.getInstance();
		
		try {
			
			session.selectOne("aqna.changeStatus", aqvo);
			
		}catch(PersistenceException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
	}

	@Override
	public List<AQNAVO> selectAllAQNAMember(String memId) {
		SqlSession session = MyBatisUtil.getInstance();
		List<AQNAVO> myaqList = null;
		try {
			myaqList = session.selectList("aqna.selectAllAQNAMember", memId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return myaqList;
	}

	@Override
	public int insertAQNA(AQNAVO aqv) {
		SqlSession session = MyBatisUtil.getInstance();
		
		int cnt = 0;
		try {
			cnt = session.insert("aqna.insertAQNA", aqv);
			if(cnt > 0) {
				session.commit();
			}
		} catch (PersistenceException e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		return cnt;
		
	}

	@Override
	public int insertProAQNA(AQNAVO aqv) {
		SqlSession session = MyBatisUtil.getInstance();
		
		int cnt = 0;
		try {
			cnt = session.insert("aqna.insertProAQNA", aqv);
			if(cnt > 0) {
				session.commit();
			}
		} catch (PersistenceException e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		return cnt;
		
	}
}
