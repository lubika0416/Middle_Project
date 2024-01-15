package aqna.dao;

import java.util.List;
import java.util.Map;

import vo.AQNAVO;
import vo.AcommentVO;

public interface IAQNADao {
	
	/**
	 * 관리자에게 사업자가 1대1문의하기 위한 메소드
	 * @param aqv
	 * @return
	 */
	public int insertProAQNA(AQNAVO aqv);
	
	/**
	 * 관리자에게 1대1문의하기 위한 메소드
	 * @param aqv
	 * @return
	 */
	public int insertAQNA(AQNAVO aqv);


	/**
	 * 전체 관리자 QNA 조회
	 * @return QNA 테이블의 모든 데이터
	 */
	public List<AQNAVO> selectAllQna();

	/**
	 * 특정 관리자 QNA 조회
	 * @param aqnaNo
	 * @return
	 */
	public AQNAVO getAQNA(String aqnaNo);

	/**
	 * 관리자 QNA의 댓글 작성 메서드
	 * @param aqnaAnswer 댓글 내용
	 * @param aqnaNo QNA 번호
	 * @return insert 결과
	 */
	public int answerAQNA(AcommentVO acvo);

	/**
	 * QNA에 달린 댓글을 가져오는 메서드
	 * @param aqnaNo QNA 번호
	 * @return AcommentVO 객체
	 */
	public AcommentVO getAnswer(String aqnaNo);

	/**
	 * QNA의 답변 여부 상태를 바꾸는 메서드
	 * @param aqvo status가 세팅된 객체
	 */
	public void changeStatus(AQNAVO aqvo);
	/**
	 * 로그인한 회원이 한 aqna정보 가져오는 메서드
	 * @param memId
	 * @return
	 */
	public List<AQNAVO> selectAllAQNAMember(String memId);
}
