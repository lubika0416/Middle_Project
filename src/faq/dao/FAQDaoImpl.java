package faq.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import util.MyBatisUtil;
import vo.FAQVO;
import vo.NoticeVO;

public class FAQDaoImpl implements IFAQDao{

	private static IFAQDao FAQDao;
	
	private FAQDaoImpl() {
	}
	
	public static IFAQDao getInstance() {
		if(FAQDao == null) {
			FAQDao = new FAQDaoImpl();
		}
		return FAQDao;
	}
	
	@Override
	public int insertFAQ(FAQVO faqv) {
		
		SqlSession session = MyBatisUtil.getInstance();
		
		int cnt = 0;
		try {
			
			cnt = session.insert("faq.insertFaq", faqv);
			
			if (cnt > 0) session.commit();
		
		}catch(PersistenceException e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			session.close();
		}
		
		return cnt;
	}

	@Override
	public int updateFAQ(FAQVO faqv) {
		
		SqlSession session = MyBatisUtil.getInstance();
		
		int cnt = 0;
		
		try {
			
			cnt = session.update("faq.updateFaq", faqv);
			
			if (cnt > 0) session.commit();
		
		}catch(PersistenceException e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			session.close();
		}
		
		return cnt;
	}
	
	@Override
	public int deleteFAQ(String faqNo) {
		
		SqlSession session = MyBatisUtil.getInstance();
		
		int cnt = 0;
		
		try {
			
			cnt = session.delete("faq.deleteFaq", faqNo);
			
			if (cnt > 0) session.commit();
		
		}catch(PersistenceException e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			session.close();
		}
		
		return cnt;
	}

	@Override
	public int countList() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<FAQVO> boardList(Map<String, Object> map) {
		
		SqlSession session = MyBatisUtil.getInstance();
		
		List<FAQVO> list = null;
		
		try {
			
			list = session.selectList("faq.boardList", map);
			
		}catch(PersistenceException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
	}

	@Override
	public FAQVO getFAQ(String faqNo) {

		SqlSession session = MyBatisUtil.getInstance();
		
		FAQVO faqv = null;
		
		try {
			
			faqv = session.selectOne("faq.getFaq", faqNo);
			
			if (faqv != null) session.commit();
			
		} catch (PersistenceException e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		return faqv;
	}
}
