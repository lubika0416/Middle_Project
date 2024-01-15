package member.service;

import java.util.List;
import java.util.Map;

import member.dao.IMemberDao;
import member.dao.MemberDaoImpl;
import vo.FavoriteVO;
import vo.MemberVO;

public class MemberServiceImpl implements IMemberService{
	
	private static IMemberService memberService;
	
	private IMemberDao memberDao;
	
	private MemberServiceImpl() {
		memberDao = MemberDaoImpl.getInstance();
	}
	
	public static IMemberService getInstance() {
		if (memberService == null) {
			memberService = new MemberServiceImpl();
		}
		return memberService;
	}

	@Override
	public int insertMember(MemberVO mv) {
		
		return memberDao.insertMember(mv);
		
	}

	@Override
	public int updateMember(MemberVO mv) {
		return memberDao.updateMember(mv);
	}

	@Override
	public int deleteMember(String memId) {
		return memberDao.deleteMember(memId);
	}

	@Override
	public boolean checkMember(String memId) {
		return memberDao.checkMember(memId);
	}

	@Override
	public MemberVO getMember(String memId) {
		
		return memberDao.getMember(memId);
		
	}

	@Override
	public List<MemberVO> selectAll() {

		return memberDao.selectAll();
		
	}

	@Override
	public List<MemberVO> searchMember(MemberVO mv) {
		return memberDao.searchMember(mv);
	}

	@Override
	public boolean checkMember(String memId, String memPw) {
		
		return memberDao.checkMember(memId, memPw);
	}

	@Override
	public MemberVO getMember(String name, String email) {
		return memberDao.getMember(name, email);
	}

	@Override
	public MemberVO getMember(String name, String email, String id) {
		
		return  memberDao.getMember(name, email, id);
	}

	@Override
	public int updatePw(String memId, String tempPw) {
		return memberDao.updatePw(memId, tempPw);
	}

	@Override
	public int addFavorite(FavoriteVO fv) {
		return memberDao.addFavorite(fv);
	}

	@Override
	public boolean checkFavorite(FavoriteVO fv) {
		return memberDao.checkFavorite(fv);
	}

	@Override
	public List<FavoriteVO> selectFavorite(String memId) {
		return memberDao.selectFavorite(memId);
	}

	@Override
	public int removeFavorite(FavoriteVO fv) {
		return memberDao.removeFavorite(fv);
	}

	@Override
	public String getName(String memId) {
		return memberDao.getName(memId);
	}

	@Override
	public Map<String, Object> getUsedInfo(String memId) {
		return memberDao.getUsedInfo(memId);
	}


}
