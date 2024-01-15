package member.service;

import java.util.List;
import java.util.Map;

import vo.FavoriteVO;
import vo.MemberVO;

public interface IMemberService {
	
	public int insertMember(MemberVO mv);

	public int updateMember(MemberVO mv);

	public int deleteMember(String memId);
	
	public boolean checkMember(String memId);

	public boolean checkMember(String memId, String memPw);
	
	public MemberVO getMember(String memId);

	public List<MemberVO> selectAll();

	public List<MemberVO> searchMember(MemberVO mv);
	
	/**
	 * 아이디 찾기 시 사용되는 메소드
	 * @param name 
	 * @param email 
	 * @return
	 */
	public MemberVO getMember(String name, String email);
	
	/**
	 * 비밀번호 찾기 시 사용되는 메소드
	 * @param name
	 * @param email
	 * @param id
	 * @return
	 */
	public MemberVO getMember(String name, String email, String id);
	
	/**
	 * 비밀번호 변경 메소드
	 * @param memId
	 * @return
	 */
	public int updatePw(String memId, String tempPw);
	
	/**
	 * 관심목록 추가 메소드
	 * @param fv
	 * @return
	 */
	public int addFavorite(FavoriteVO fv);
	
	/**
	 * 관심목록 체크 메소드
	 * @param fv
	 * @return
	 */
	public boolean checkFavorite(FavoriteVO fv);
	
	/**
	 * 관심목록 삭제 메소드
	 * @param fv
	 * @return
	 */
	public int removeFavorite(FavoriteVO fv);
	
	/**
	 * 관심목록 조회하는 메소드
	 * @param memId
	 * @return
	 */
	public List<FavoriteVO> selectFavorite(String memId);
	
	/**
	 * 아이디로 이름찾기
	 * @param memId
	 * @return
	 */
	public String getName(String memId);
	
	/**
	 * 예약, 리뷰, 관심 숫자 가져오기
	 * @param memId
	 * @return
	 */
	public Map<String, Object> getUsedInfo(String memId);
	
	
}
