package review.service;

import java.util.List;
import java.util.Map;

import vo.ClassesVO;
import vo.ReservationVO;
import vo.ReviewVO;

public interface IReviewService {
	
	/**
	 * 리뷰 쓰기
	 * @param rv
	 * @return
	 */
	public int addReview(ReviewVO rv);
	
	/**
	 * 리뷰 수정
	 * @param rv
	 * @return
	 */
	public int modifyReview(ReviewVO rv);
	
	/**
	 * 리뷰 삭제
	 * @param reviewNo
	 * @return
	 */
	public int removeReview(int reviewNo);
	
	/**
	 * 전체 리뷰 조회
	 * @return
	 */
	public List<ReviewVO> selectAll();
	
	/**
	 * 범위 별 리뷰 조회
	 * @param map
	 * @return
	 */
	public List<ReviewVO> boardList(Map<String, Object> map);
	
	/**
	 * 리뷰 정보 가져오기
	 * @param reviewNo
	 * @return
	 */
	public ReviewVO getReview(int reviewNo);
	
	public String getClsName(String clsId);
	/**
	 * 해당 회원이 한 리뷰 리스트를 가져오는 메서드
	 * @param memId
	 * @return
	 */
	public List<ReviewVO> getMyReviewList(String memId);
	
	/**
	 * 해당 예약 번호의 리뷰가 존재 하는지 확인 여부
	 * @param resNo
	 * @return
	 */
	public boolean checkReview(int resNo);
	
	/**
	 * 해당 클래스의 리뷰 숫자와 평균 점수를 가져오는 메소드
	 * @param clsId
	 * @return
	 */
	public Map<String, Object> getClassRating(String clsId);
	
	/**
	 * 해당 클래스의 리뷰를 가져오는 메소드
	 * @param cldId
	 * @return
	 */
	public List<ReviewVO> getClassReviews(String clsId);
	
	/**
	 * 리뷰 번호로 작성자의 이름을 가져오는 메소드
	 * @param reviewNo
	 * @return memName
	 */
	public String getMemName(int reviewNo);
	/**
	 * 해당 클래스의 리뷰를 가져오기 위한 메서드
	 * @param proId
	 * @return
	 */
	public List<ReviewVO> getReviewList(String proId);
	
	/**
	 * 해당 리뷰의 파일 아이디를 가져오는 메소드
	 * @param reviewNo
	 * @return
	 */
	public int getFileId(int reviewNo);
}
