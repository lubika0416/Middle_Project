package classes.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import util.MyBatisUtil;
import vo.ClassesVO;
import vo.FavoriteVO;
import vo.ProducerVO;

public class ClassesDaoImpl implements IClassesDao{
	
	private static IClassesDao clsDao;
	private ClassesDaoImpl() {
	}
	public static IClassesDao getInstance() {
		if(clsDao == null) clsDao = new ClassesDaoImpl();
		return clsDao;
	}
	
	
	
	@Override
	public int createClasses(ClassesVO cv) {
		SqlSession session = MyBatisUtil.getInstance();
		
		int cnt = 0;
		try {
			cnt = session.insert("cls.createClasses", cv);
			if(cnt > 0) {
				session.commit();
			}
		} catch (PersistenceException e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		return cnt;
	}

	@Override
	public int updateClasses(ClassesVO cv) {
		SqlSession session = MyBatisUtil.getInstance();
		int cnt = 0;
		try {
			cnt = session.update("cls.updateClasses", cv);
			if(cnt > 0) {
				session.commit();
			}
		} catch (PersistenceException e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		return cnt;
	}

	@Override
	public int deleteClasses(String clsId) {
		SqlSession session = MyBatisUtil.getInstance();
		int cnt = 0;
		try {
			cnt = session.delete("cls.deleteClasses", clsId);
			if(cnt > 0) {
				session.commit();
			}
		} catch (PersistenceException e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		return cnt;
	}

	@Override
	public boolean checkClasses(String clsId) {
		boolean isExist = false;
		SqlSession session = MyBatisUtil.getInstance(true);

		try {
			int cnt = session.selectOne("cls.checkClasses", clsId);
			if (cnt > 0) {
				isExist = true;
			}
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return isExist;
	}

	@Override
	public ClassesVO getClasses(String clsId) {
		SqlSession session = MyBatisUtil.getInstance(false);
		ClassesVO cv = null;
		try {
			cv = session.selectOne("cls.getClasses", clsId);
		} catch (PersistenceException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return cv;
	}

	@Override
	public List<ClassesVO> selectAll() {
		List<ClassesVO> clsList = new ArrayList<ClassesVO>();

		SqlSession session = MyBatisUtil.getInstance(true);

		try {
			clsList = session.selectList("cls.selectAll");

		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return clsList;
	}

	@Override
	public List<ClassesVO> searchClasses(ClassesVO cv) {
		List<ClassesVO> clsList = new ArrayList<ClassesVO>();

		SqlSession session = MyBatisUtil.getInstance(true);

		try {
			clsList = session.selectList("", cv);

		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return clsList;
	}
	@Override
	public List<ClassesVO> getClassesList(String proId) {
		List<ClassesVO> clsList = null;
		
		SqlSession session = MyBatisUtil.getInstance(true);
		
		try {
			clsList = session.selectList("cls.getClassesList", proId);
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return clsList;
	}
	@Override
	public int getFileId(String clsId) {
		int fileId = 0;
		
		SqlSession session = MyBatisUtil.getInstance(true);
		
		try {
			fileId = session.selectOne("cls.getFileId", clsId);
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return fileId;
			
	}
	@Override
	public ClassesVO getProId(String clsId) {
		ClassesVO cv = null;
		SqlSession session = MyBatisUtil.getInstance(true);
		
		try {
			cv = session.selectOne("cls.getProId", clsId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return cv;
	}
	@Override
	public List<ClassesVO> selectCraftCate() {
		List<ClassesVO> craftList = null;
		
		SqlSession session = MyBatisUtil.getInstance(true);
		
		try {
			craftList = session.selectList("cls.selectCraftCate");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return craftList;
	}
	@Override
	public List<ClassesVO> selectCookCate() {
		List<ClassesVO> cookList = null;
		
		SqlSession session = MyBatisUtil.getInstance(true);
		
		try {
			cookList = session.selectList("cls.selectCookCate");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return cookList;
	}
	@Override
	public List<ClassesVO> selectArtCate() {
		List<ClassesVO> artList = null;
		
		SqlSession session = MyBatisUtil.getInstance(true);
		
		try {
			artList = session.selectList("cls.selectArtCate");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return artList;
	}
	@Override
	public List<ClassesVO> selectFlowerCate() {
		List<ClassesVO> flowerList = null;
		
		SqlSession session = MyBatisUtil.getInstance(true);
		
		try {
			flowerList = session.selectList("cls.selectFlowerCate");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return flowerList;
	}
	@Override
	public List<ClassesVO> selectBeautyCate() {
		List<ClassesVO> beautyList = null;
		
		SqlSession session = MyBatisUtil.getInstance(true);
		
		try {
			beautyList = session.selectList("cls.selectBeautyCate");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return beautyList;
	}
	@Override
	public List<ClassesVO> selectActivityCate() {
		List<ClassesVO> activityList = null;
		
		SqlSession session = MyBatisUtil.getInstance(true);
		
		try {
			activityList = session.selectList("cls.selectActivityCate");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return activityList;
	}
	@Override
	public List<ClassesVO> getClassList(String clsName) {
		SqlSession session = MyBatisUtil.getInstance();
		List<ClassesVO> clsSearchList = null;
		
		try {
			clsSearchList = session.selectList("cls.getClassList", clsName);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
				
		return clsSearchList;
	}
	@Override
	public List<ClassesVO> descClassList() {
		List<ClassesVO> list = null;
		
		SqlSession session = MyBatisUtil.getInstance(true);
		
		try {
			list = session.selectList("cls.descClassList");
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return list;
	}
	@Override
	public List<FavoriteVO> getFavoriteList(String proId) {
		SqlSession session = MyBatisUtil.getInstance();
		
		List<FavoriteVO> favoriteList = null;
		try {
			favoriteList = session.selectList("favorite.getFavoriteList", proId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return favoriteList;
	}


}
