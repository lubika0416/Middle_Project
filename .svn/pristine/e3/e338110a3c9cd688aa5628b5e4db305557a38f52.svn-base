package producer.dao;

import java.sql.SQLFeatureNotSupportedException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import util.MyBatisUtil;
import vo.FeedVO;

public class FeedDaoImpl implements IFeedDao {
	
	private static IFeedDao feedDao;
	
	private FeedDaoImpl() {}
	
	public static IFeedDao getInstance() {
		if (feedDao == null) feedDao = new FeedDaoImpl();
		return feedDao;
	}
	

	@Override
	public List<FeedVO> getFeedList(String proId) {
		
		List<FeedVO> feedList = new ArrayList<FeedVO>();
		
		SqlSession session = MyBatisUtil.getInstance(true);
		
		try {
			
			feedList = session.selectList("feed.getFeedList", proId);
			
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return  feedList;
		
	}

	@Override
	public int insertFeed(FeedVO fdv) {
		
		int cnt = 0;
		
		SqlSession session = MyBatisUtil.getInstance();
		
		try {
			cnt = session.insert("feed.insertFeed", fdv);
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
	public FeedVO getFeed(int feedNo) {
		
		FeedVO fdv = null;
		
		SqlSession session = MyBatisUtil.getInstance(true);
		
		try {
			
			fdv = session.selectOne("feed.getFeed", feedNo);
			
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return fdv;
	}

	@Override
	public int getFileId(int feedNo) {
		
		int fileId = 0;
		
		SqlSession session = MyBatisUtil.getInstance(true);
		
		try {
			fileId = session.selectOne("feed.getFileId", feedNo);
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return fileId;
	}

	@Override
	public int updateFeed(FeedVO fdv) {
		
		int cnt = 0;
		
		SqlSession session = MyBatisUtil.getInstance();
		
		try {
			cnt = session.update("feed.updateFeed", fdv);
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
	public int deleteFeed(int feedNo) {
		
		int cnt = 0;
		
		SqlSession session = MyBatisUtil.getInstance();
		
		try {
			cnt = session.delete("feed.deleteFeed", feedNo);
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
	public List<FeedVO> selectFeed() {
		List<FeedVO> feedList = null;
		
		SqlSession session = MyBatisUtil.getInstance(true);
		
		try {
			feedList = session.selectList("feed.selectFeed");
			
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return feedList;
	}

}
