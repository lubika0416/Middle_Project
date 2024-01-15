package producer.service;

import java.util.List;

import vo.FeedVO;

public interface IFeedService {
	
	
	/**
	 * 해당 사업자의 전체 피드 목록을 가져오는 메소드
	 * @param proId
	 * @return
	 */
	public List<FeedVO> getFeedList(String proId);
	
	/**
	 * feed 등록 메소드
	 * @param fdv
	 * @return
	 */
	public int insertFeed(FeedVO fdv);
	
	/**
	 * 피드번호로 피드를 가져오는 메소드
	 * @param feedNo
	 * @return
	 */
	public FeedVO getFeed(int feedNo);
	
	
	/**
	 * 피드번호로 파일 아이디를 가져오는 메소드
	 * @param feedNo
	 * @return fileId
	 */
	public int getFileId(int feedNo);
	
	/**
	 * 피드 업데이트 메소드
	 * @param fdv
	 * @return
	 */
	public int updateFeed(FeedVO fdv);
	
	/**
	 * 피드 삭제 메소드
	 * @param feedNo
	 * @return
	 */
	public int deleteFeed(int feedNo);
	
	/**
	 * 피드 조회 메서드
	 * @param feedNo
	 * @return
	 */
	public List<FeedVO> selectFeed();
	
}
