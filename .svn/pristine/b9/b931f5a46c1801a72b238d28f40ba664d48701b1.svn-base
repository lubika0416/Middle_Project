package faq.service;

import java.util.List;
import java.util.Map;

import faq.dao.FAQDaoImpl;
import faq.dao.IFAQDao;
import vo.FAQVO;

public class FAQServiceImpl implements IFAQService{

	//싱글톤 생성
	private IFAQDao FAQDao;
	
	private static IFAQService FAQService;
	
	private FAQServiceImpl() {
		FAQDao = FAQDaoImpl.getInstance();
	}
	
	public static IFAQService getInstance() {
		if(FAQService == null) {
			FAQService = new FAQServiceImpl();
		}
		return FAQService;
	}

	@Override
	public int addFAQ(FAQVO faqv) {
		return FAQDao.insertFAQ(faqv);
	}

	@Override
	public int modifyFAQ(FAQVO faqv) {
		return FAQDao.updateFAQ(faqv);
	}

	@Override
	public int removeFAQ(String faqNo) {
		return FAQDao.deleteFAQ(faqNo);
	}

	@Override
	public int countList() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<FAQVO> boardList(Map<String, Object> map) {
		return FAQDao.boardList(map);
	}

	@Override
	public FAQVO getFAQ(String faqNo) {
		return FAQDao.getFAQ(faqNo);
	}
}
