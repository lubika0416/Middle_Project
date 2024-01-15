package notice.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import util.MyBatisUtil;
import vo.MemberVO;
import vo.NoticeVO;

public class NoticeDaoImpl implements INoticeDao{
	
	//�떛湲��꽩 �깮�꽦
	private static INoticeDao noticeDao;
	
	private NoticeDaoImpl() {
	}
	
	public static INoticeDao getInstance() {
		if(noticeDao == null) {
			noticeDao = new NoticeDaoImpl();
		}
		return noticeDao;
	}

	//怨듭��궗�빆 �엯�젰
	@Override
	public int insertNotice(NoticeVO nv) {
		SqlSession session = MyBatisUtil.getInstance();
		
		int cnt = 0;
		
		try {
			
			cnt = session.insert("notice.insertNotice", nv);
			
			if (cnt > 0) session.commit();
		
		}catch(PersistenceException e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			session.close();
		}
		
		return cnt;
	}
	
	//怨듭��궗�빆 �닔�젙
	@Override
	public int updateNotice(NoticeVO nv) {
		SqlSession session = MyBatisUtil.getInstance();
		
		int cnt = 0;
		try {
			
			cnt = session.update("notice.updateNotice", nv);
			
			if (cnt > 0) session.commit();
		
		}catch(PersistenceException e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			session.close();
		}
		
		return cnt;
	}
	
	//怨듭��궗�빆 �궘�젣 윤서야 매개변수 왜이래
	@Override
	public int deleteNotice(String faqNo) {
		SqlSession session = MyBatisUtil.getInstance();
		
		int cnt = 0;
		try {
			
			cnt = session.delete("notice.deleteNotice", faqNo);
			
			if (cnt > 0) session.commit();
		
		}catch(PersistenceException e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			session.close();
		}
		return cnt;
	}

	//�쟾泥� 怨듭��궗�빆 議고쉶
	@Override
	public int countList() {

		//�꽭�뀡 �뿴湲�
		SqlSession session = MyBatisUtil.getInstance();
		
		int cnt = 0;
		
		try {
			
			cnt = session.selectOne("notice.countList");
			
		}catch(PersistenceException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return cnt;

	}

	//踰붿쐞蹂� 怨듭��궗�빆 議고쉶
	@Override
	public List<NoticeVO> boardList(Map<String, Object> map) {

		//�꽭�뀡 �뿴湲�
		SqlSession session = MyBatisUtil.getInstance();
		
		List<NoticeVO> list = null;
		
		try {
			
			list = session.selectList("notice.boardList", map);
			
		}catch(PersistenceException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
	}

	@Override
	public NoticeVO getNotice(String noticeNo) {
		
		SqlSession session = MyBatisUtil.getInstance();
		
		NoticeVO nv = null;
		
		try {
			
			nv = session.selectOne("notice.getNotice", noticeNo);
			
			if (nv != null) session.commit();
			
		} catch (PersistenceException e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		return nv;
	}
}
