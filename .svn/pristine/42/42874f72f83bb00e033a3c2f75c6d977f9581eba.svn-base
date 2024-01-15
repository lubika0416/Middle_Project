package producer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import comm.service.FileServiceImpl;
import comm.service.IFileService;
import producer.service.IProducerService;
import producer.service.ProducerServiceImpl;
import vo.FileVO;
import vo.ProducerVO;

@MultipartConfig
@WebServlet("/producer/mypageupdate.do")
public class MypageUpdateController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String proId = req.getParameter("proId");
		
		IProducerService proService = ProducerServiceImpl.getInstance();
		
		ProducerVO pv = proService.getProducer(proId);
		
		req.setAttribute("pv", pv);
		
		if(pv.getFileId() > 0) {
			IFileService fileService = FileServiceImpl.getInstance();
			
			FileVO fv = new FileVO();
			fv.setFileId(pv.getFileId());
			
			List<FileVO> fileList = fileService.getAtchFileList(fv);
			req.setAttribute("fileList", fileList);
			
		}
		
		req.getRequestDispatcher("/WEB-INF/views/producer/mypage_update.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String proId = req.getParameter("proId");
		String proPw = req.getParameter("proPw");
		String proName = req.getParameter("proName");
		String proEmail = req.getParameter("proEmail");
		String proTel = req.getParameter("proTel");
		String proStore = req.getParameter("proStore");
		String zip = req.getParameter("zip");
		String proAddr = req.getParameter("proAddr");
		String proAddr2 = req.getParameter("proAddr2");
		System.out.println(zip + "/" + proAddr + "/" + proAddr2);
		String proAddr_ = zip + "/" + proAddr + "/" + proAddr2;
		String proStrTel = req.getParameter("proStrTel");
		String proRegNo = req.getParameter("proRegNo");
		String proDesc = req.getParameter("proDesc");
		String proPro = req.getParameter("proPro");
		
		System.out.println(proAddr);
		
		IFileService fileService = FileServiceImpl.getInstance();
		
		FileVO fv = null;
		
		try {
			fv = fileService.saveAtchFileList(req.getParts());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		IProducerService proService = ProducerServiceImpl.getInstance();
		ProducerVO pv = new ProducerVO(proId, proPw, proName, proEmail, proTel, proStore, proAddr_, proStrTel, proRegNo, proDesc, proPro);
				
		if(fv == null) {
			int fileId = proService.getFileId(proId);
			pv.setFileId(fileId);
		}else {
			pv.setFileId(fv.getFileId());
		}
		int cnt = proService.modifyProducer(pv);
		
		
		HttpSession session = req.getSession();
		session.setAttribute("loginInfo", pv);
		
		
		resp.sendRedirect(req.getContextPath() + "/producer/mypage.do");
		
		
	}
}

















