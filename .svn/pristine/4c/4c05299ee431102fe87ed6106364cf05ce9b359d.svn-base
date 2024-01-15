package review.service;

import java.util.List;
import java.util.Map;
import review.dao.IReviewDao;
import review.dao.ReviewDaoImpl;
import vo.ClassesVO;
import vo.ReservationVO;
import vo.ReviewVO;

public class ReviewServiceImpl implements IReviewService{
	
	private static IReviewService reviewService;
	
	private ReviewServiceImpl() {
		reviewDao = ReviewDaoImpl.getInstance();
	}
	
	public static IReviewService getInstance() {
		if(reviewService == null) {
			reviewService = new ReviewServiceImpl();
		}
		return reviewService;
	}
	
	private IReviewDao reviewDao;
	
	
	@Override
	public int addReview(ReviewVO rv) {
		return reviewDao.insertReview(rv);
	}

	@Override
	public int modifyReview(ReviewVO rv) {
		return reviewDao.updateReview(rv);
	}

	@Override
	public int removeReview(int reviewNo) {
		return reviewDao.deleteReview(reviewNo);
	}

	@Override
	public List<ReviewVO> selectAll() {
		List<ReviewVO> list = reviewDao.selectAll();
		return list;
	}

	@Override
	public List<ReviewVO> boardList(Map<String, Object> map) {
		List<ReviewVO> list = reviewDao.boardList(map);
		return list;
	}

	@Override
	public ReviewVO getReview(int reviewNo) {
		return reviewDao. getReview(reviewNo);
	}

	@Override
	public String getClsName(String clsId) {
		return reviewDao.getClsName(clsId);
	}

	@Override
	public List<ReviewVO> getMyReviewList(String memId) {
		return reviewDao.getMyReviewList(memId);
	}

	@Override
	public boolean checkReview(int resNo) {
		return reviewDao.checkReview(resNo);
	}

	@Override
	public Map<String, Object> getClassRating(String clsId) {
		return reviewDao.getClassRating(clsId);
	}

	@Override
	public List<ReviewVO> getClassReviews(String clsId) {
		return reviewDao.getClassReviews(clsId);
	}

	@Override
	public String getMemName(int reviewNo) {
		return reviewDao.getMemName(reviewNo);
	}

	@Override
	public List<ReviewVO> getReviewList(String proId) {
		return reviewDao.getReviewList(proId);
	}

	@Override
	public int getFileId(int reviewNo) {
		return reviewDao.getFileId(reviewNo);
	}
	
	
}
