package comm.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import comm.service.FileServiceImpl;
import comm.service.IFileService;
import util.MyBatisUtil;
import vo.FileVO;

public class FileDaoImple implements IFileDao {

	private static IFileDao fileDao;

	private FileDaoImple() {
	}

	public static IFileDao getInstance() {
		if (fileDao == null)
			fileDao = new FileDaoImple();
		return fileDao;
	}

	@Override
	public int insertAtchFile(FileVO fileVO) {

		int cnt = 0;

		SqlSession session = MyBatisUtil.getInstance();

		try {

			cnt = session.insert("file.insertFile", fileVO);

			if (cnt > 0)
				session.commit();

		} catch (PersistenceException e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}

		return cnt;
	}

	@Override
	public int insertAtchFileDetail(FileVO fileVO) {

		int cnt = 0;

		SqlSession session = MyBatisUtil.getInstance();

		try {

			cnt = session.insert("file.insertDetailFile", fileVO);

			if (cnt > 0)
				session.commit();

		} catch (PersistenceException e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}

		return cnt;
	}

	@Override
	public List<FileVO> getAtchFileList(FileVO fileVO) {

		List<FileVO> fileList = new ArrayList<FileVO>();

		SqlSession session = MyBatisUtil.getInstance(true);

		try {

			fileList = session.selectList("file.getFileList", fileVO);

		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return fileList;
	}

	@Override
	public FileVO getAtchFileDetail(FileVO fileVO) {

		FileVO fv = null;

		SqlSession session = MyBatisUtil.getInstance();

		try {

			fv = session.selectOne("file.getFileDetail", fileVO);

		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return fv;
	}

	@Override
	public List<FileVO> getProFileList(String proId) {

		List<FileVO> fileList = null;

		SqlSession session = MyBatisUtil.getInstance(true);

		try {

			fileList = session.selectList("file.getProFileList", proId);

		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return fileList;
	}

	@Override
	public List<FileVO> getClassFileList(String clsId) {
		
		List<FileVO> fileList = null;

		SqlSession session = MyBatisUtil.getInstance(true);

		try {

			fileList = session.selectList("file.getClassFileList", clsId);

		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return fileList;
	}

	@Override
	public List<FileVO> getFeedFileList(int feedNo) {
		
		List<FileVO> fileList = null;
		
		SqlSession session = MyBatisUtil.getInstance(true);
		
		try {
			fileList = session.selectList("file.getFeedFileList", feedNo);
			
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return fileList;
		
	}

	@Override
	public List<FileVO> getFiles(int fileId) {

		List<FileVO> list = null;
		
		SqlSession session = MyBatisUtil.getInstance(true);
		
		try {
			list = session.selectList("file.getFiles", fileId);
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return list;
	}

	@Override
	public List<FileVO> getSearchClassFileList(String clsName) {
		SqlSession session = MyBatisUtil.getInstance();
		List<FileVO> fileList = null;
		try {
			fileList = session.selectList("file.getSearchClassFileList", clsName);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return fileList;
	}

	

}
