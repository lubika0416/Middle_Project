package pqna.service;

import vo.PCommentVO;

public interface IPCommentService {
	/**
	 * 문의에 답변을 달기위한 메서드
	 * @param pcommVO
	 * @return
	 */
	public int writePComment(PCommentVO pcommVO);
	
}
