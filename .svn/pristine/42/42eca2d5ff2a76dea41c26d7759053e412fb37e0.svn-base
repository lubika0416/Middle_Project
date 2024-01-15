package pqna.dao;

import java.util.List;
import java.util.Map;

import vo.ClassesVO;
import vo.PCommentVO;
import vo.PQNAVO;

public interface IPQNADao {
	/**
	 * 문의등록 하기위한 메서드
	 * @param pqVO
	 * @return
	 */
	public int insertPQNA(PQNAVO pqVO);
	/**
	 * 문의수정 하기위한 메서드
	 * @param pqVO
	 * @return
	 */
	public int updatePQNA(PQNAVO pqVO);
	/**
	 * 문의삭제 하기위한 메서드
	 * @param pqnaNo
	 * @return
	 */
	public int deletePQNA(int pqnaNo);
	/**
	 * 해당 사업자가 받은 모든 문의 가져오기
	 * @param proId
	 * @return
	 */
	public List<PQNAVO> getPQNAList(String proId);
	/**
	 * 문의 범위별로 보여주기 위한 메서드
	 * @param PQNAMap
	 * @return
	 */
	public List<PQNAVO> PQNAList(Map<String, Object> PQNAMap); 
	/**
	 * 전제 문의 조회
	 * @return
	 */
	public int countList();
	/**
	 * 문의정보 가져오기
	 * @param pqnaNO
	 * @return
	 */
	public PQNAVO getPQNA(int pqnaNO);
	
	public List<PQNAVO> selectAllPQNA(String proId);
	/**
	 * 문의에 남긴 댓글을 가져오는 메서드
	 * @param pqnaNo
	 * @return
	 */
	public PCommentVO getAnswer(int pqnaNo);
	/**
	 * 문의에 답글달기 위한 메서드
	 * @param pCommentVO
	 * @return
	 */
	public int answerPQNA(PCommentVO pcommVO);
	/**
	 * 답변상태 변경하기 위한 메서드
	 * @param pqVO
	 */
	public void changeStatus(PQNAVO pqVO);
	/**
	 * 해당 클래스의 사업자 아이디를 가져오기 위한 메서드
	 * @param clsId
	 * @return
	 */
	public ClassesVO getProId(String clsId);
	/**
	 * 로그인한 회원이 한 pqna가져오기 위한 메서드
	 * @param memId
	 * @return
	 */
	public List<PQNAVO> selectAllPQNAMember(String memId);
}





