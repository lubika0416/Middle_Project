package producer.controller;

import java.io.IOException;

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
@WebServlet("/producer/signup.do")
public class SignUpController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/producer/signup.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String proId = req.getParameter("proId");
		String proPw = req.getParameter("proPw");
		String proEmail = req.getParameter("proEmail");
		String proName = req.getParameter("proName");
		String proTel = req.getParameter("proTel");
		String proStore = req.getParameter("proStore");
		String proRegNo = req.getParameter("proRegNo");
		String proStrTel = req.getParameter("proStrTel");
		String zipCode = req.getParameter("zip");
		String proAddr2 = req.getParameter("proAddr2");
		String proAddr = zipCode + "/" + req.getParameter("proAddr") + "/" + proAddr2;
		String proDesc = req.getParameter("proDesc");
		String proPro = req.getParameter("proPro");
		
		IFileService fileService = FileServiceImpl.getInstance();
		FileVO fileVO = null;
		
		try {
			fileVO = fileService.saveAtchFileList(req.getParts());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		IProducerService proService = ProducerServiceImpl.getInstance();
		ProducerVO pv = new ProducerVO(proId, proPw, proName, proEmail, 
					    proTel, proStore, proAddr, proStrTel, proRegNo,
					    proDesc, proPro);
		if(fileVO != null) {
			pv.setFileId(fileVO.getFileId());
		}
		int cnt = proService.registProducer(pv);
		

		if (cnt > 0) req.setAttribute("result", true);
		else req.setAttribute("result", false);
		
		req.getRequestDispatcher("/WEB-INF/views/common/login.jsp").forward(req, resp);
	
	}
}









