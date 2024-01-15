package pqna.dao;


import org.apache.ibatis.session.SqlSession;

import util.MyBatisUtil;
import vo.PCommentVO;

public class PCommentDaoImpl implements IPCommentDao{
	
	private static IPCommentDao pcommDao;
	private PCommentDaoImpl() {
	}
	public static IPCommentDao getInstance() {
		if (pcommDao == null) pcommDao = new PCommentDaoImpl();
		return pcommDao;
	}
	
	
	@Override
	public int writePComment(PCommentVO pcommVO) {
		int cnt = 0;
		SqlSession session = MyBatisUtil.getInstance();
		try {
			cnt = session.insert("pcomm.writePComment", pcommVO);
			
			if(cnt > 0) session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			session.close();
		}
		return cnt;
	}

}













