package classes.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import vo.ClassScheduleVO;

public interface IScheduleDao {
	
	public int insertSchedule(List<ClassScheduleVO> scdList);
	
	/**
	 * 해당 클래스의 일정을 모두 가져오는 메소드
	 * @param clsId
	 * @return
	 */
	public List<ClassScheduleVO> getClsScd(String clsId);
	
	/**
	 * 해당 클래스의 상세 일정이 등록된 날짜 목록
	 * @param clsId
	 * @return
	 */
	public List<Date> getScdDate(String clsId); 
	
	/**
	 * 클래스아이디와 예약인원수를 받아 인원수를 업데이트 하는 메소드
	 * @param map
	 * @return
	 */
	public int updateCnt(Map<String, Object> map);
	
	/**
	 * 일정 아이디로 일정 가져오기
	 * @param cssId
	 * @return
	 */
	public ClassScheduleVO getSchedule(String cssId);
	
	
}
