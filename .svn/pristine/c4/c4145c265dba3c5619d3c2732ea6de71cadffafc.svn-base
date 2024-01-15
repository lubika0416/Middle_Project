package comm.dao;

import java.util.List;

import vo.FileVO;

public interface IFileDao {
	
	/**
	 * 첨부파일 저장
	 * @param FileVO
	 * @return
	 */
	public int insertAtchFile(FileVO fileVO);
	
	/**
	 * 첨부파일 상세정보 저장
	 * @param FileVO
	 * @return
	 */
	public int insertAtchFileDetail(FileVO fileVO);
	
	/**
	 * 첨부파일 목록 조회하기
	 * @param FileVO
	 * @return
	 */
	public List<FileVO> getAtchFileList(FileVO fileVO);
	
	/**
	 * 첨부파일 세부정보 조회하기
	 * @param FileVO
	 * @return
	 */
	public FileVO getAtchFileDetail(FileVO fileVO);
	
	/**
	 * 사업자가 등록한 공방 사진목록을 가져오는 메소드
	 * @param proId
	 * @return
	 */
	public List<FileVO> getProFileList(String proId);
	
	/**
	 * 사업자가 등록한 클래스 사진목록을 가져오는 메소드
	 * @param clsId
	 * @return
	 */
	public List<FileVO> getClassFileList(String clsId);
	
	/**
	 * 사업자가 등록한 피드의 이미지 목록을 가져오는 메소드
	 * @param feedNo
	 * @return
	 */
	public List<FileVO> getFeedFileList(int feedNo);
	/**
	 * 검색한 클래스의 파일정보를 가져오기 위한 메서드
	 * @param clsName
	 * @return
	 */
	public List<FileVO> getSearchClassFileList(String clsName);
	
	/**
	 * 파일 아이디를 통한 파일 찾기
	 * @param fileId
	 * @return
	 */
	public List<FileVO> getFiles(int fileId);
	
}
