package visit.dao;

import org.apache.ibatis.session.SqlSession;

import util.MyBatisUtil;

public class VisitCountDao {

	private static VisitCountDao visitDao;

	public VisitCountDao() {
	}

	public static VisitCountDao getInstance() {
		if (visitDao == null) {
			visitDao = new VisitCountDao();
		}
		return visitDao;
	}

	public void setTotalCount() {

		SqlSession session = MyBatisUtil.getInstance();

		int cnt = 0;

		try {

			cnt = session.insert("visit.setTotalCount");
			if (cnt > 0) {
				session.commit();
			} else {
				session.rollback();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public int getTotalCount() {
		SqlSession session = MyBatisUtil.getInstance();
		int cnt = 0;
		
		try {
			
			cnt = session.selectOne("visit.getTotalCount");
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return cnt;
	}
	
	public int getTodayCount() {
		SqlSession session = MyBatisUtil.getInstance();
		int cnt = 0;
		
		try {
			
			cnt = session.selectOne("visit.getTodayCount");
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return cnt;
	}
}
