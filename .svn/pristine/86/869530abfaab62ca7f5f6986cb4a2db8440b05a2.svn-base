package notice.service;

import java.util.List;
import java.util.Map;

import notice.dao.INoticeDao;
import notice.dao.NoticeDaoImpl;
import vo.NoticeVO;

public class NoticeServiceImpl implements INoticeService{

	//싱글톤 패턴
	private static INoticeService noticeService;
	
	
	private NoticeServiceImpl() {
		noticeDao = NoticeDaoImpl.getInstance();
	}
	
	public static INoticeService getInstance() {
		if(noticeService == null) {
			noticeService = new NoticeServiceImpl();
		}
		return noticeService;
	}
	
	//다오 객체 생
	private INoticeDao noticeDao;
	
	//공지사항 입력
	@Override
	public int addNotice(NoticeVO nv) {
		return noticeDao.insertNotice(nv);
	}
	
	//공지사항 수정
	@Override
	public int modifyNotice(NoticeVO nv) {
		return noticeDao.updateNotice(nv);
	}
	
	//공지사항 삭제
	@Override
	public int removeNotice(String noticeNo) {
		return noticeDao.deleteNotice(noticeNo);
	}

	//전체 공지사항 조회
	@Override
	public int countList() {
		int count = 0;
		count = noticeDao.countList();
		return count;
	}

	//범위별 공지사항 조회
	@Override
	public List<NoticeVO> boardList(Map<String, Object> map) {
		List<NoticeVO> list = noticeDao.boardList(map);
		return list;
	}

	//공지사항 정보 가져오기
	@Override
	public NoticeVO getNotice(String noticeTitle) {
		return noticeDao.getNotice(noticeTitle);
	}

}
