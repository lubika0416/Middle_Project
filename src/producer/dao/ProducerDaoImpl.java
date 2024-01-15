package producer.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import util.MyBatisUtil;
import vo.ProducerVO;

public class ProducerDaoImpl implements IProducerDao {

	private static IProducerDao proDao;

	private ProducerDaoImpl() {
	}

	public static IProducerDao getInstance() {
		if (proDao == null)
			proDao = new ProducerDaoImpl();
		return proDao;
	}

	@Override
	public int signUpProducer(ProducerVO pv) {

		SqlSession session = MyBatisUtil.getInstance();

		int cnt = 0;
		try {
			cnt = session.insert("producer.SignUpProducer", pv);
			if (cnt > 0) {
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
	public int updateProducer(ProducerVO pv) {

		SqlSession session = MyBatisUtil.getInstance();
		int cnt = 0;
		try {
			cnt = session.update("producer.updateProducer", pv);
			if (cnt > 0) {
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
	public int deleteProducer(String proId) {
		SqlSession session = MyBatisUtil.getInstance();
		int cnt = 0;
		try {
			cnt = session.delete("", proId);
			if (cnt > 0) {
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
	public boolean checkProducer(String proId) {
		boolean isExist = false;
		SqlSession session = MyBatisUtil.getInstance(true);

		try {
			int cnt = session.selectOne("producer.checkProducer", proId);
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

	@Override
	public ProducerVO getProducer(String proId) {
		SqlSession session = MyBatisUtil.getInstance(false);
		ProducerVO pv = null;
		try {
			pv = session.selectOne("producer.getProducer", proId);
			if (pv != null)
				session.commit();
		} catch (PersistenceException e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}

		return pv;
	}

	@Override
	public List<ProducerVO> selectAll() {
		List<ProducerVO> proList = new ArrayList<ProducerVO>();

		SqlSession session = MyBatisUtil.getInstance(true);

		try {
			proList = session.selectList("producer.selectAll");

		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return proList;
	}

	@Override
	public List<ProducerVO> searchProducer(ProducerVO pv) {
		List<ProducerVO> proList = new ArrayList<ProducerVO>();

		SqlSession session = MyBatisUtil.getInstance(true);

		try {
			proList = session.selectList("", pv);

		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return proList;
	}

	@Override
	public boolean checkProducer(String proId, String proPw) {
		SqlSession session = MyBatisUtil.getInstance(true);

		boolean isExist = false;
		Map<String, String> proMap = new HashMap<String, String>();

		try {
			proMap.put("proId", proId);
			proMap.put("proPw", proPw);

			int cnt = session.selectOne("producer.loginProducer", proMap);

			if (cnt > 0)
				isExist = true;

		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return isExist;
	}

	@Override
	public ProducerVO getProducer(String proName, String proMail) {

		ProducerVO pv = null;

		SqlSession session = MyBatisUtil.getInstance();

		try {

			Map<String, String> map = new HashMap<String, String>();
			map.put("name", proName);
			map.put("mail", proMail);

			pv = session.selectOne("producer.findId", map);

		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return pv;
	}

	@Override
	public ProducerVO getProducer(String proName, String proMail, String proId) {
		
		ProducerVO pv = null;

		SqlSession session = MyBatisUtil.getInstance();

		try {

			Map<String, String> map = new HashMap<String, String>();
			map.put("name", proName);
			map.put("mail", proMail);
			map.put("id", proId);

			pv = session.selectOne("producer.findPw", map);

		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return pv;
	}

	@Override
	public int updatePw(String proId, String tempPw) {
		
		int cnt = 0;
		
		SqlSession session = MyBatisUtil.getInstance();
		
		try {
			
			Map<String, String> map = new HashMap<String, String>();
			
			map.put("proId", proId);
			map.put("tempPw", tempPw);
			
			cnt = session.update("producer.updatePw", map);
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
	public int getFileId(String proId) {

		int fileId = 0;
		
		SqlSession session = MyBatisUtil.getInstance(true);
		
		try {
			fileId = session.selectOne("producer.getFileId", proId);
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return fileId;
	}

	@Override
	public ProducerVO getClsPro(String clsId) {
		ProducerVO pv = null;
		
		SqlSession session = MyBatisUtil.getInstance(true);
		
		try {
			pv = session.selectOne("producer.getClsPro", clsId);
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return pv;
	}

	@Override
	public Map<String, Object> getUsedInfo(String proId) {
		Map<String, Object> map = null;
		
		SqlSession session = MyBatisUtil.getInstance(true);
		
		try {
			map = session.selectOne("producer.getUsedInfo", proId);
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return map;
	}

}
