package pqna.service;

import pqna.dao.IPCommentDao;
import pqna.dao.PCommentDaoImpl;
import vo.PCommentVO;

public class PCommentServiceImpl implements IPCommentService{
	private IPCommentDao pcommDao;
	private static IPCommentService pcommService;
	private PCommentServiceImpl() {
		pcommDao = PCommentDaoImpl.getInstance();
	}
	public static IPCommentService getInstance(){
		if(pcommService == null) pcommService = new PCommentServiceImpl();
		return pcommService;
	}
	
	
	@Override
	public int writePComment(PCommentVO pcommVO) {
		return pcommDao.writePComment(pcommVO);
	}

}
