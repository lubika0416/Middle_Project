package pqna.service;

import java.util.List;
import java.util.Map;

import pqna.dao.IPQNADao;
import pqna.dao.PQNADaoImpl;
import vo.ClassesVO;
import vo.PCommentVO;
import vo.PQNAVO;

public class PQNAServiceImpl implements IPQNAService{
	private IPQNADao pqnaDao;
	
	private static IPQNAService pqnaService;
	private PQNAServiceImpl() {
		pqnaDao = PQNADaoImpl.getInstance();
	}
	public static IPQNAService getInstance() {
		if(pqnaService == null) pqnaService = new PQNAServiceImpl();
		
		return pqnaService;
	}
	
	
	@Override
	public int createPQNA(PQNAVO pqVO) {
		int cnt = pqnaDao.insertPQNA(pqVO);
		return cnt;
	}

	@Override
	public int modifyPQNA(PQNAVO pqVO) {
		int cnt = pqnaDao.updatePQNA(pqVO);
		return cnt;
	}

	@Override
	public int removePQNA(int pqnaNo) {
		int cnt = pqnaDao.deletePQNA(pqnaNo);
		return cnt;
	}

	@Override
	public List<PQNAVO> getPQNAList(String proId) {
		List<PQNAVO> PQNAList = pqnaDao.getPQNAList(proId);
		return PQNAList;
	}
	@Override
	public List<PQNAVO> PQNAList(Map<String, Object> PQNAMap) {
		return pqnaDao.PQNAList(PQNAMap);
	}
	@Override
	public int countList() {
		int count = 0;
		count = pqnaDao.countList();
		return count;
	}
	
	
	
	@Override
	public PQNAVO getPQNA(int pqnaNo) {
		return pqnaDao.getPQNA(pqnaNo);
	}
	@Override
	public List<PQNAVO> selectAllPQNA(String proId) {
		return pqnaDao.selectAllPQNA(proId);
	}
	@Override
	public PCommentVO getAnswer(int pqnaNo) {
		return pqnaDao.getAnswer(pqnaNo);
	}
	@Override
	public int answerPQNA(PCommentVO pcommVO) {
		return pqnaDao.answerPQNA(pcommVO);
	}
	@Override
	public void changeStatus(PQNAVO pqVO) {
		pqnaDao.changeStatus(pqVO);
	}
	@Override
	public ClassesVO getProId(String clsId) {
		return pqnaDao.getProId(clsId);
	}
	@Override
	public List<PQNAVO> selectAllPQNAMember(String memId) {
		return pqnaDao.selectAllPQNAMember(memId);
	}
	
	
	
}
