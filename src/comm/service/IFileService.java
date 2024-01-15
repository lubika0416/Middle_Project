package comm.service;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.Part;

import vo.FeedVO;
import vo.FileVO;

public interface IFileService {
	
	/**
	 * 첨부파일 목록을 저장하기 위한 메소드
	 * @param req Part 정보를 꺼내기위한 요청객체
	 * @return atchFileId를 담고있는 FileVO 객체
	 */
	public FileVO saveAtchFileList(Collection<Part> parts);
	
	/**
	 * 첨부파일 목록 조회하기
	 * @param FileVO
	 * @return 첨부파일 목록
	 */
	public List<FileVO> getAtchFileList(FileVO fileVO);
	
	/**
	 * 첨부파일 세부정보 조회하기
	 * @param FileVO
	 * @return 첨부파일 세부정보
	 */
	public FileVO getAtchFileDetail(FileVO fileVO);
	
	/**
	 * 사업자가 등록한 공방 사진목록을 가져오는 메소드
	 * @param proId
	 * @return
	 */
	public List<FileVO> getProFileList(String proId);
	
	/**
	 * 사업자가 등록한 클래스 공방 사진목록을 가져오는 메소드
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
	 * 검색한 클래스 목록을 가져오기 위한 메서드
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
