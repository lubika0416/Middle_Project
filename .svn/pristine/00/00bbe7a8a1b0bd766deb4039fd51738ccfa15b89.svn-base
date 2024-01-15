package producer.dao;

import java.util.List;
import java.util.Map;

import vo.ProducerVO;


public interface IProducerDao {

	/**
	 * 사업자 회원가입 하기 위한 메서드
	 * @param pv
	 * @return
	 */
	public int signUpProducer(ProducerVO pv);
	/**
	 * 사업자정보 업데이트 메서드
	 * @param pv
	 * @return
	 */
	public int updateProducer(ProducerVO pv);
	/**
	 * 해당 아이디에 해당하는 사업자의 정보를 삭제하기 위한 메서드
	 * @param proId
	 * @return
	 */
	public int deleteProducer(String proId);
	/**
	 * 해당 ID에 해당하는 회원정보가 존재하는지 확인하기 위한 메서드
	 * @param proId 체크할 회원ID
	 * @return 해당 회원이 존재하면 true, 존재하지 않으면 false반환
	 */
	public boolean checkProducer(String proId);
	/**
	 * 사업자가 로그인하기 위한 메서드
	 * @param proId
	 * @param proPw
	 * @return
	 */
	public boolean checkProducer(String proId, String proPw);
	/**
	 * 해당 ID에 해당하는 회원정보 가져오기 위한 메서드
	 * @param proId 가져올 회원ID
	 * @return 해당 사업자의 정보를 담은 ProducerVO 객체
	 */
	
	public ProducerVO getProducer(String proId);
	/**
	 * 전체사업자정보를 가져오기 위한 메서드
	 * @return 전체사업자정보를 담은 리스트
	 */
	public List<ProducerVO> selectAll();
	/**
	 * 사업자정보를 검색하기위한 메서드
	 * @param pv 검색할 사업지정보를 담은 ProducerVO객체
	 * @return 검색된 사업자정보를 담은 List객체
	 */
	public List<ProducerVO> searchProducer(ProducerVO pv);
	
	/**
	 * 사업자 아이디 찾기 시 사용하는 메소드
	 * @param proName
	 * @param proMail
	 * @return
	 */
	public ProducerVO getProducer(String proName, String proMail);
	
	/**
	 * 사업자 아이디 찾기 시 사용하는 메소드
	 * @param proName
	 * @param proMail
	 * @param proId
	 * @return
	 */
	public ProducerVO getProducer(String proName, String proMail, String proId);
	
	/**
	 * 비밀번호 변경 메소드
	 * @param proId
	 * @param tempPw
	 * @return
	 */
	public int updatePw(String proId, String tempPw);
	
	/**
	 * 해당 사업자의 파일아이디를 가져오는 메소드
	 * @param proId
	 * @return
	 */
	public int getFileId (String proId);
	
	/**
	 * 클래스 아이디로 해당 클래스 사업자 정보를 가져오는 메소드
	 * @param clsId
	 * @return
	 */
	public ProducerVO getClsPro(String clsId);
	
	/**
	 * 사업자 클래스, 리뷰, 관심목록 갯수 가져오기
	 * @param proId
	 * @return
	 */
	public Map<String, Object> getUsedInfo(String proId);
}
