package comm.service;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.Part;

import comm.dao.FileDaoImple;
import comm.dao.IFileDao;
import vo.FileVO;

public class FileServiceImpl implements IFileService{
	
	private static IFileService fileService;
	
	private IFileDao fileDao;
	
	private FileServiceImpl() {
		fileDao = FileDaoImple.getInstance();
	}
	
	public static IFileService getInstance() {
		if (fileService == null) fileService = new FileServiceImpl();
		return fileService;
	}

	@Override
	public FileVO saveAtchFileList(Collection<Part> parts) {
		
		String uploadPath = "C:/Users/PC-26/Desktop/Jdus/Jdus/WebContent/upload_images";
		
		File uploadDir = new File(uploadPath);
		
		if (!uploadDir.exists()) uploadDir.mkdir();
		
		FileVO fv = null;
		
		boolean isFirstFile = true;
		
		try {
			
			for (Part part : parts) {
				
				String fileName = part.getSubmittedFileName();
				
				if (fileName != null && !fileName.equals("")) {
					
					if (isFirstFile) {
						
						isFirstFile = false;
						
						fv = new FileVO();
						fileDao.insertAtchFile(fv);
					}
					
					long fileSize = part.getSize();
					
					String saveFileName = UUID.randomUUID().toString().replace("-", "");
					
					String saveFilePath = uploadPath + File.separator + saveFileName;
					
					String fileExtension = fileName.lastIndexOf(".") < 0 ? "" : fileName.substring(fileName.lastIndexOf(".") + 1);
					
					part.write(saveFilePath);
					
					fv.setFilePath(saveFilePath);
					fv.setFileSvNm(saveFileName);
					fv.setFileSize(fileSize);
					fv.setFileOrNm(fileName);
					fv.setFileExtsn(fileExtension);
					fv.setFileCn("");
					
					fileDao.insertAtchFileDetail(fv);
							
					part.delete();
				}
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fv;
	}

	@Override
	public List<FileVO> getAtchFileList(FileVO fileVO) {
		
		return fileDao.getAtchFileList(fileVO);
		
	}

	@Override
	public FileVO getAtchFileDetail(FileVO fileVO) {
		
		return fileDao.getAtchFileDetail(fileVO);
	}

	@Override
	public List<FileVO> getProFileList(String proId) {
		List<FileVO> fileList =  fileDao.getProFileList(proId);
		
		return fileList;
	}

	@Override
	public List<FileVO> getClassFileList(String clsId) {
		return fileDao.getClassFileList(clsId);
	}

	@Override
	public List<FileVO> getFeedFileList(int feedNo) {
		return fileDao.getFeedFileList(feedNo);
	}

	@Override
	public List<FileVO> getFiles(int fileId) {
		return fileDao.getFiles(fileId);
	}

	@Override
	public List<FileVO> getSearchClassFileList(String clsName) {
		return fileDao.getSearchClassFileList(clsName);
	}

	

}
