package classes.dao;

import java.util.List;

import vo.ClassesVO;
import vo.FavoriteVO;


public interface IClassesDao {
	
	/**
	 * 새로운 클래스 등록하기 위한 메서드
	 * @param cv
	 * @return
	 */
	public int createClasses(ClassesVO cv);
	/**
	 * 등록된 클래스 수정하기 위한 메서드
	 * @param pv
	 * @return
	 */
	public int updateClasses(ClassesVO cv);
	/**
	 * 클래스 삭제하기 위한 메서드
	 * @param clsId
	 * @return
	 */
	public int deleteClasses(String clsId);
	/**
	 * 해당 클래스 존재여부 확인 메서드
	 * @param clsId
	 * @return
	 */
	public boolean checkClasses(String clsId);

//	public boolean checkClasses(String clsId, String clsName);
	/**
	 * 해당 클래스 아이디의 클래스 불러오기 위한 메서드
	 * @param clsId
	 * @return
	 */
	public ClassesVO getClasses(String clsId);
	/**
	 * 전체 클래스 목록 불러오는 메서드
	 * @return
	 */
	public List<ClassesVO> selectAll();
	/**
	 * 클래스 검색위한 메서드
	 * @param cv
	 * @return
	 */
	public List<ClassesVO> searchClasses(ClassesVO cv);
	
	/**
	 * 해당 사업자의 모든 클래스 가져오기
	 * @param proId
	 * @return
	 */
	public List<ClassesVO> getClassesList(String proId);
	/**
	 * 해당 클래스의 존재하는 파일 가져오기
	 * @param clsId
	 * @return
	 */
	public int getFileId (String clsId);
	/**
	 * 클래스 아이디로 해당 클래스의 사업자 정보를 가져오는 메서드
	 * @param clsId
	 * @return
	 */
	public ClassesVO getProId(String clsId);
	/**
	 * 공예 카테고리 클래스 가져오기
	 * @return
	 */
	public List<ClassesVO> selectCraftCate();
	/**
	 * 요리 카테고리 클래스 가져오기
	 * @return
	 */
	public List<ClassesVO> selectCookCate();
	/**
	 * 미술 카테고리 클래스 가져오기
	 * @return
	 */
	public List<ClassesVO> selectArtCate();
	/**
	 * 플라워 카테고리 클래스 가져오기
	 * @return
	 */
	public List<ClassesVO> selectFlowerCate();
	/**
	 * 뷰티 카테고리 클래스 가져오기
	 * @return
	 */
	public List<ClassesVO> selectBeautyCate();
	/**
	 * 체험 및 기타 카테고리 클래스 가져오기
	 * @return
	 */
	public List<ClassesVO> selectActivityCate();
	/**
	 * 클래스 이름으로 검색하기 위한 메서드
	 * @param clsName
	 * @return
	 */
	public List<ClassesVO> getClassList(String clsName);
	
	/**
	 * 리뷰 많은 순으로 정렬 후 가져오는 리스트
	 * @return
	 */
	public List<ClassesVO> descClassList();
	/**
	 * 관식목록 가져오기 위한 메서드
	 * @param proId
	 * @return
	 */
	public List<FavoriteVO> getFavoriteList(String proId);
}
