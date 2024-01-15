package faq.dao;

import java.util.List;
import java.util.Map;

import vo.FAQVO;

public interface IFAQDao {

	//공지사항 입력
	public int insertFAQ(FAQVO faqv);

	//공지사항 수정
	public int updateFAQ(FAQVO faqv);
	
	//공지사항 삭제
	public int deleteFAQ(String faqNo);
	
	//전체 공지사항 조회
	public int countList();

	//범위별 공지사항 조회
	public List<FAQVO> boardList(Map<String, Object> map);

	//공지사항 정보 가져오기
	public FAQVO getFAQ(String faqNo);
	
}
