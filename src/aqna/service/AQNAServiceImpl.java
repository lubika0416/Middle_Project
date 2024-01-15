package aqna.service;

import java.util.List;
import java.util.Map;

import aqna.dao.AQNADaoImpl;
import aqna.dao.IAQNADao;
import vo.AQNAVO;
import vo.AcommentVO;

public class AQNAServiceImpl implements IAQNAService{
	//다오 객체 생성
	private IAQNADao aqnaDao;
	
	//싱글톤 패턴
	private static IAQNAService aqnaService;
	
	private AQNAServiceImpl() {
		aqnaDao = AQNADaoImpl.getInstance();
	}
	
	public static IAQNAService getInstance() {
		if(aqnaService == null) {
			aqnaService = new AQNAServiceImpl();
		}
		return aqnaService;
	}
	

	
	@Override
	public List<AQNAVO> selectAllQna() {
		return aqnaDao.selectAllQna();
	}

	@Override
	public AQNAVO getAQNA(String aqnaNo) {
		return aqnaDao.getAQNA(aqnaNo);
	}

	@Override
	public int answerAQNA(AcommentVO acvo) {
		return aqnaDao.answerAQNA(acvo);
	}

	@Override
	public AcommentVO getAnswer(String aqnaNo) {
		return aqnaDao.getAnswer(aqnaNo);
	}

	@Override
	public void changeStatus(AQNAVO aqvo) {
		aqnaDao.changeStatus(aqvo);
	}

	@Override
	public List<AQNAVO> selectAllAQNAMember(String memId) {
		
		return aqnaDao.selectAllAQNAMember(memId);
	}

	@Override
	public int createAQNA(AQNAVO aqv) {
		int cnt = aqnaDao.insertAQNA(aqv);
		return cnt;
	}

	@Override
	public int createProAQNA(AQNAVO aqv) {
		int cnt = aqnaDao.insertAQNA(aqv);
		return cnt;
	}



}
