package review.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import util.MyBatisUtil;
import vo.ClassesVO;
import vo.ReservationVO;
import vo.ReviewVO;

public class ReviewDaoImpl implements IReviewDao{
	
	private static IReviewDao reviewDao;

	private ReviewDaoImpl() {	
	}
	
	public static IReviewDao getInstance() {
		if(reviewDao == null) {
			reviewDao = new ReviewDaoImpl();
		}
		return reviewDao;
	}
	
	
	@Override
	public int insertReview(ReviewVO rv) {
		SqlSession session = MyBatisUtil.getInstance();
		
		int cnt = 0;
		
		try {
			
			cnt = session.insert("review.insertReview", rv);
			
			if(cnt > 0) session.commit();
			
		}catch (PersistenceException e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			session.close();
		}
		
		return cnt;
	}

	@Override
	public int updateReview(ReviewVO rv) {
		SqlSession session = MyBatisUtil.getInstance();
		
		int cnt = 0;
		
		try {
			
			cnt = session.update("review.updateReview", rv);
			
			if (cnt > 0) session.commit();
			
		}catch (PersistenceException e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			session.close();
		}
		return cnt;
	}

	@Override
	public int deleteReview(int reviewNo) {
		SqlSession session = MyBatisUtil.getInstance();
		
		int cnt = 0;
		try {
			
			cnt = session.delete("review.deleteReview", reviewNo);
			
			if(cnt > 0) session.commit();
		}catch (PersistenceException e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			session.close();
		}
		return cnt;
	}

	@Override
	public List<ReviewVO> selectAll() {
		SqlSession session = MyBatisUtil.getInstance();
		
		List<ReviewVO> list = null;
		
		try {
			
			list = session.selectList("review.selectAll");
			
			if(list != null) session.commit();
			
		}catch (PersistenceException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return list;
	}

	@Override
	public List<ReviewVO> boardList(Map<String, Object> map) {
		
		SqlSession session = MyBatisUtil.getInstance();
		
		List<ReviewVO> list = null;
		
		try {
			
			list = session.selectList("review.boardList", map);
			
		}catch (PersistenceException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return list;
	}

	@Override
	public ReviewVO getReview(int reviewNo) {

		SqlSession session = MyBatisUtil.getInstance();
		
		ReviewVO rv = null;
		
		try {
			
			rv = session.selectOne("review.getReview", reviewNo);
			
			if(rv != null) session.commit();
			
		} catch (PersistenceException e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			session.close();
		}
		
		return rv;
	}

	@Override
	public String getClsName(String classNo) {
		
		SqlSession session = MyBatisUtil.getInstance();
		
		ClassesVO cv = null;
		String clsName = "";
		
		try {
			
			cv = session.selectOne("cls.getClasses", classNo);
			clsName = cv.getClsName();
			
		}catch (PersistenceException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return clsName;
	}

	@Override
	public List<ReviewVO> getMyReviewList(String memId) {
		SqlSession session = MyBatisUtil.getInstance();
		List<ReviewVO> reviewList = null;
		
		try {
			reviewList = session.selectList("review.getMyReviewList", memId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return reviewList;
	}

	@Override
	public boolean checkReview(int resNo) {
		
		boolean isExist = false;
		
		SqlSession session = MyBatisUtil.getInstance(true);
		
		try {
			
			int cnt = session.selectOne("review.checkReview", resNo);
			
			if (cnt > 0) isExist = true;
			
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return isExist;
	}

	@Override
	public Map<String, Object> getClassRating(String clsId) {
		Map<String, Object> map = null;
		
		SqlSession session = MyBatisUtil.getInstance(true);
		
		try {
			map = session.selectOne("review.getClassRating", clsId);
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return map;
	}

	@Override
	public List<ReviewVO> getClassReviews(String clsId) {
		List<ReviewVO> list = null;
		
		SqlSession session = MyBatisUtil.getInstance(true);
		
		try {
			list = session.selectList("review.getClassReviews", clsId);
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return list;
	}

	@Override
	public String getMemName(int reviewNo) {
		String memName = null;
		
		SqlSession session = MyBatisUtil.getInstance(true);
				
		try {
			memName = session.selectOne("review.getMemName", reviewNo);
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return memName;
	}

	@Override
	public List<ReviewVO> getReviewList(String proId) {
		SqlSession session = MyBatisUtil.getInstance();
		
		List<ReviewVO> reviewList = null;
		try {
			reviewList = session.selectList("review.getReviewList", proId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return reviewList;
	}

	@Override
	public int getFileId(int reviewNo) {
		SqlSession session = MyBatisUtil.getInstance(true);
		
		int fileId = 0;
		
		try {
			fileId = session.selectOne("review.getFileId", reviewNo);
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return fileId;
	}
	

	
	
}
