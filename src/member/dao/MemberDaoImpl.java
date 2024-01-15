package member.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import util.MyBatisUtil;
import vo.FavoriteVO;
import vo.MemberVO;

public class MemberDaoImpl implements IMemberDao {

	private static IMemberDao memberDao;

	private MemberDaoImpl() {
	}

	public static IMemberDao getInstance() {
		if (memberDao == null)
			memberDao = new MemberDaoImpl();
		return memberDao;
	}

	@Override
	public int insertMember(MemberVO mv) {

		SqlSession session = MyBatisUtil.getInstance();

		int cnt = 0;

		try {

			cnt = session.insert("member.insertMember", mv);
			
			if (cnt > 0) session.commit();

		} catch (PersistenceException e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		
		return cnt;

	}

	@Override
	public int updateMember(MemberVO mv) {
		
		SqlSession session = MyBatisUtil.getInstance();
		
		int cnt = 0;
		
		try {
			
			cnt = session.update("member.updateMember", mv);
			System.out.println(cnt);
			if (cnt > 0) session.commit();
			
		} catch (PersistenceException e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		return cnt;
	}

	@Override
	public int deleteMember(String memId) {
		
		SqlSession session = MyBatisUtil.getInstance();
		
		int cnt = 0;
		
		try {
			
			cnt = session.delete("member.deleteMember", memId);
			if (cnt > 0) session.commit();
		} catch (PersistenceException e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		return cnt;
	}

	@Override
	public boolean checkMember(String memId) {
		
		SqlSession session = MyBatisUtil.getInstance(true);
		
		boolean isExist = false;
		
		try {
			
			int cnt = session.selectOne("member.checkMember", memId);
			
			if (cnt > 0) isExist = true;
			
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return isExist;
	}

	@Override
	public MemberVO getMember(String memId) {
		
		SqlSession session = MyBatisUtil.getInstance();
		
		MemberVO mv = null;
		
		try {
			
			mv = session.selectOne("member.getMember", memId);
			
			if (mv != null) session.commit();
			
		} catch (PersistenceException e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		return mv;
	}

	/**
	 * 회원정보를 모두 불러오는 메서드
	 */
	@Override
	public List<MemberVO> selectAll() {
		
		SqlSession session = MyBatisUtil.getInstance();
		
		List<MemberVO> list = null;
		
		try {
			
			list = session.selectList("member.selectAll");
			
			if(list != null) session.commit();
		}catch(PersistenceException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
	}

	@Override
	public List<MemberVO> searchMember(MemberVO mv) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkMember(String memId, String memPw) {
		
		SqlSession session = MyBatisUtil.getInstance(true);
		
		boolean isExist = false;
		
		Map<String, String> map = new HashMap<String, String>();
		
		try {
			
			map.put("uId", memId);
			map.put("uPw", memPw);
			
			int cnt = session.selectOne("member.loginMember", map);
			
			if (cnt > 0) isExist = true;
			
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return isExist;
	}

	@Override
	public MemberVO getMember(String name, String email) {
		
		MemberVO mv = null;
		
		SqlSession session = MyBatisUtil.getInstance(true);
		
		try {
			
			Map<String , Object> map = new HashMap<String, Object>();
			map.put("name", name);
			map.put("email", email);
			mv = session.selectOne("member.findId", map);
			
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return mv;
	}

	@Override
	public MemberVO getMember(String name, String email, String id) {
		
		MemberVO mv = null;
		
		SqlSession session = MyBatisUtil.getInstance(true);
		
		try {
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("name", name);
			map.put("email", email);
			map.put("id", id);
			
			mv = session.selectOne("member.findPw", map);
			
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return mv;
	}

	@Override
	public int updatePw(String memId, String tempPw) {
		
		int cnt = 0;
		
		SqlSession session = MyBatisUtil.getInstance();
		
		try {
			Map<String, String> map = new HashMap<String, String>();
			map.put("tempPw", tempPw);
			map.put("memId", memId);
			
			cnt = session.update("member.updatePw", map);
			if (cnt > 0) session.commit();
			
		} catch (PersistenceException e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		
		
		return cnt;
	}

	@Override
	public int addFavorite(FavoriteVO fv) {
		
		int cnt = 0;
		
		SqlSession session = MyBatisUtil.getInstance();
		
		try {
			
			cnt = session.insert("favorite.addFavorite", fv);
			if (cnt > 0) session.commit();
		} catch (PersistenceException e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		return cnt;
	}

	@Override
	public boolean checkFavorite(FavoriteVO fv) {

		boolean checked = false;
		
		SqlSession session = MyBatisUtil.getInstance(true);
		
		try {
			int cnt = session.selectOne("favorite.checkFavorite", fv);
			if (cnt > 0) checked = true;
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return checked;
	}

	@Override
	public List<FavoriteVO> selectFavorite(String memId) {
		List<FavoriteVO> fvList = null;
		
		SqlSession session = MyBatisUtil.getInstance(true);
		
		try {
			fvList = session.selectList("favorite.selectFavorite", memId);
			
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return fvList;
	}

	@Override
	public int removeFavorite(FavoriteVO fv) {
		
		int cnt = 0;
		
		SqlSession session = MyBatisUtil.getInstance();
		
		try {
			cnt = session.delete("favorite.removeFavorite", fv);
			if (cnt > 0) session.commit();
		} catch (PersistenceException e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		
		return cnt;
	}

	@Override
	public String getName(String memId) {
		
		String name = "";
		
		SqlSession session = MyBatisUtil.getInstance(true);
		
		try {
			name = session.selectOne("member.getName", memId);
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return name;
	}

	@Override
	public Map<String, Object> getUsedInfo(String memId) {
		
		Map<String, Object> map = null;
		
		SqlSession session = MyBatisUtil.getInstance(true);
		
		try {
			
			map = session.selectOne("member.getUsedInfo", memId);
			
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return map;
	}
	
	

}
