package pqna.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import util.MyBatisUtil;
import vo.ClassesVO;
import vo.PCommentVO;
import vo.PQNAVO;

public class PQNADaoImpl implements IPQNADao{
	private static IPQNADao pqnaDao;
	private PQNADaoImpl() {
	}
	public static IPQNADao getInstance() {
		if(pqnaDao == null) pqnaDao = new PQNADaoImpl();
		return pqnaDao;
	}
	
	
	
	@Override
	public int insertPQNA(PQNAVO pqVO) {
		SqlSession session = MyBatisUtil.getInstance();
		
		int cnt = 0;
		try {
			cnt = session.insert("pqna.insertPQNA", pqVO);
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
	public int updatePQNA(PQNAVO pqVO) {
		SqlSession session = MyBatisUtil.getInstance();
		int cnt = 0;
		try {
			//cnt = session.update("pqna.updatePQNA", pqVO);
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
	public int deletePQNA(int pqnaNo) {
		SqlSession session = MyBatisUtil.getInstance();
		int cnt = 0;
		try {
			//cnt = session.delete("pqna.deletePQNA", pqnaNo);
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
	public List<PQNAVO> getPQNAList(String proId) {

		List<PQNAVO> pqnaList = null;
		
		SqlSession session = MyBatisUtil.getInstance(true);
		
		try {
			//pqnaList = session.selectList("pqna.getPQNAList", proId);
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return pqnaList;
	}
	@Override
	public List<PQNAVO> PQNAList(Map<String, Object> PQNAMap) {
		SqlSession session = MyBatisUtil.getInstance();
		
		List<PQNAVO> PQNAList = null;
		try {
			PQNAList = session.selectList("pqna.PQNAList", PQNAMap);
		} catch (PersistenceException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return PQNAList;
	}
	@Override
	public int countList() {
		SqlSession session = MyBatisUtil.getInstance();
		
		int cnt = 0;
		
		try {
			
			//cnt = session.selectOne("pqna.countList");
			
		}catch(PersistenceException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}
	@Override
	public PQNAVO getPQNA(int pqnaNO) {
		SqlSession session = MyBatisUtil.getInstance();
		
		PQNAVO pqVO = null;
		
		try {
			pqVO = session.selectOne("pqna.getPQNA", pqnaNO);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return pqVO;
	}
	@Override
	public List<PQNAVO> selectAllPQNA(String proId) {
		SqlSession session = MyBatisUtil.getInstance();
		
		List<PQNAVO> list = null;
		try {
			list = session.selectList("pqna.selectAllPQNA", proId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
	}
	@Override
	public PCommentVO getAnswer(int pqnaNo) {
		SqlSession session = MyBatisUtil.getInstance();
		PCommentVO pcommVO = null;
		
		try {
			pcommVO = session.selectOne("pcomm.getAnswer", pqnaNo);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return pcommVO;
	}
	@Override
	public int answerPQNA(PCommentVO pcommVO) {
		SqlSession session = MyBatisUtil.getInstance();
		int cnt = 0;
		try {
			cnt = session.insert("pcomm.answerPQNA", pcommVO);
			if (cnt > 0) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			session.close();
		}
		return 0;
	}
	@Override
	public void changeStatus(PQNAVO pqVO) {
		SqlSession session = MyBatisUtil.getInstance();
		
		try {
			session.selectOne("pqna.changeStatus", pqVO);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	@Override
	public ClassesVO getProId(String clsId) {
		SqlSession session = MyBatisUtil.getInstance(true);
		ClassesVO cv = null;
		
		try {
			cv = session.selectOne("cls.getProId", clsId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return cv;
	}
	@Override
	public List<PQNAVO> selectAllPQNAMember(String memId) {
		SqlSession session = MyBatisUtil.getInstance();
		
		List<PQNAVO> mypqList = null;
		try {
			mypqList = session.selectList("pqna.selectAllPQNAMember", memId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return mypqList;
	}

}
