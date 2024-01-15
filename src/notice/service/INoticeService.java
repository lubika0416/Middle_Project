package notice.service;

import java.util.List;
import java.util.Map;

import vo.NoticeVO;

public interface INoticeService {
	
	//공지사항 쓰기
	public int addNotice(NoticeVO nv);
	
	//공지사항 수정
	public int modifyNotice(NoticeVO nv);
	
	//공지사항 삭제
	public int removeNotice(String noticeNo);
	
	//전체 공지사항 조회
	public int countList();

	//범위별 공지사항 조회
	public List<NoticeVO> boardList(Map<String, Object> map);

	//공지사항 정보 가져오기
	public NoticeVO getNotice(String noticeNo);
}
