package producer.service;

import java.util.List;
import java.util.Map;

import producer.dao.IProducerDao;
import producer.dao.ProducerDaoImpl;
import vo.ProducerVO;

public class ProducerServiceImpl implements IProducerService{
	private IProducerDao proDao;
	
	private static IProducerService proService;
	private ProducerServiceImpl() {
		proDao = ProducerDaoImpl.getInstance();
	}
	public static IProducerService getInstance() {
		if(proService == null) proService = new ProducerServiceImpl();
		return proService;
	}
	

	@Override
	public int registProducer(ProducerVO pv) {
		int cnt = proDao.signUpProducer(pv);
		return cnt;
	}

	@Override
	public int modifyProducer(ProducerVO pv) {
		int cnt = proDao.updateProducer(pv);
		return cnt;
	}

	@Override
	public int removeProducer(String proId) {
		int cnt = proDao.deleteProducer(proId);
		return cnt;
	}

	@Override
	public boolean checkProducer(String proId) {
		boolean isExist = proDao.checkProducer(proId);
		return isExist;
	}

	@Override
	public ProducerVO getProducer(String proId) {
		
		return proDao.getProducer(proId);
	}

	@Override
	public List<ProducerVO> selectAll() {
		List<ProducerVO> proList = proDao.selectAll();
		return proList;
	}

	@Override
	public List<ProducerVO> searchProducer(ProducerVO pv) {
		List<ProducerVO> proList = proDao.searchProducer(pv);
		return proList;
	}
	@Override
	public boolean checkProducer(String proId, String proPw) {
		return proDao.checkProducer(proId, proPw);
	}
	@Override
	public ProducerVO getProducer(String proName, String proMail) {
		return proDao.getProducer(proName, proMail);
	}
	@Override
	public ProducerVO getProducer(String proName, String proMail, String proId) {
		return proDao.getProducer(proName, proMail, proId);
	}
	@Override
	public int updatePw(String proId, String tempPw) {
		return proDao.updatePw(proId, tempPw);
	}
	
	@Override
	public int getFileId(String proId) {
		return proDao.getFileId(proId);
	}
	@Override
	public ProducerVO getClsPro(String clsId) {
		return proDao.getClsPro(clsId);
	}
	@Override
	public Map<String, Object> getUsedInfo(String proId) {
		return proDao.getUsedInfo(proId);
	}

}
