package member.service;

import java.util.List;

import vo.ReservationVO;

public interface IReservationService {
	
	public int insertReservation(ReservationVO rv);
	
	public int updateReservation(ReservationVO rv);
	
	public int deleteReservation(int resNo);
	
	public ReservationVO getReservation(int resNo);
	
	/**
	 * 클래스일정 아이디의 예약목록을 가져오는 메소드
	 * @param cssId 클래스일정 아이디
	 * @return 
	 */
	public List<ReservationVO> getCssReservations(String cssId);
	
	/**
	 * 해당 클래스 아이디와 회원 아이디를 통한 예약번호 조회
	 * @param memId
	 * @param cssId
	 * @return
	 */
	public int getReservationNo(String memId, String cssId);
	/**
	 * 로그인한 회원이 예약한 목록을 가져오기 위한 메서드
	 * @param memId
	 * @return
	 */
	public List<ReservationVO> selectMyReservation(String memId);

	
	/**
	 * 사업자 클래스의 예약 목록 조회
	 * @param proId
	 * @return
	 */
	public List<ReservationVO> getResList(String proId);
	
	/**
	 * 클래스 아아디로 클래스 이름을 가져오는 메소드
	 * @param clsId
	 * @return
	 */
	public String getClassName(String clsId);
	
}
