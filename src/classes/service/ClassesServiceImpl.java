package classes.service;

import java.util.List;

import classes.dao.ClassesDaoImpl;
import classes.dao.IClassesDao;
import vo.ClassesVO;
import vo.FavoriteVO;

public class ClassesServiceImpl implements IClassesService{
	
	private IClassesDao clsDao;
	
	private static IClassesService clsService;
	
	private ClassesServiceImpl() {
		clsDao = ClassesDaoImpl.getInstance();
	}
	
	public static IClassesService getInstance() {
		if (clsService == null) clsService = new ClassesServiceImpl();
		return clsService;
	}
	
	@Override
	public int registClasses(ClassesVO cv) {
		int cnt = clsDao.createClasses(cv);
		return cnt;
	}

	@Override
	public int modifyClasses(ClassesVO cv) {
		int cnt = clsDao.updateClasses(cv);
		return cnt;
	}

	@Override
	public int removeClasses(String clsId) {
		int cnt = clsDao.deleteClasses(clsId);
		return cnt;
	}

	@Override
	public boolean checkClasses(String clsId) {
		boolean isExist = clsDao.checkClasses(clsId);
		return isExist;
	}

	@Override
	public ClassesVO getClasses(String clsId) {
		return clsDao.getClasses(clsId);
	}

	@Override
	public List<ClassesVO> selectAll() {
		List<ClassesVO> clsList = clsDao.selectAll();
		return clsList;
	}

	@Override
	public List<ClassesVO> searchProducer(ClassesVO cv) {
		List<ClassesVO> clsList = clsDao.searchClasses(cv);
		return clsList;
	}

	@Override
	public List<ClassesVO> getClassesList(String proId) {
		return clsDao.getClassesList(proId);
	}

	@Override
	public int getFileId(String clsId) {
		return clsDao.getFileId(clsId);
	}

	@Override
	public ClassesVO getProId(String clsId) {
		return clsDao.getProId(clsId);
	}

	@Override
	public List<ClassesVO> selectCookCate() {
		return clsDao.selectCookCate();
	}

	@Override
	public List<ClassesVO> selectArtCate() {
		return clsDao.selectArtCate();
	}

	@Override
	public List<ClassesVO> selectFlowerCate() {
		return clsDao.selectFlowerCate();
	}

	@Override
	public List<ClassesVO> selectBeautyCate() {
		return clsDao.selectBeautyCate();
	}

	@Override
	public List<ClassesVO> selectActivityCate() {
		return clsDao.selectActivityCate();
	}

	@Override
	public List<ClassesVO> selectCraftCate() {
		return clsDao.selectCraftCate();
	}

	@Override
	public List<ClassesVO> getClassList(String clsName) {
		return clsDao.getClassList(clsName);
	}

	@Override
	public List<ClassesVO> descClassList() {
		return clsDao.descClassList();
	}

	@Override
	public List<FavoriteVO> getFavoriteList(String proId) {
		return clsDao.getFavoriteList(proId);
	}

}
