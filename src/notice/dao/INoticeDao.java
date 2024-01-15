package notice.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import vo.NoticeVO;

public interface INoticeDao {
	
	//공지사항 입력
	public int insertNotice(NoticeVO nv);

	//공지사항 수정
	public int updateNotice(NoticeVO nv);
	
	//공지사항 삭제
	public int deleteNotice(String noticeNo);
	
	//전체 공지사항 조회
	public int countList();

	//범위별 공지사항 조회
	public List<NoticeVO> boardList(Map<String, Object> map);

	//공지사항 정보 가져오기
	public NoticeVO getNotice(String noticeTitle);

}
